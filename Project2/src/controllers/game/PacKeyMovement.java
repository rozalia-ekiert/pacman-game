package controllers.game;

import model.game.TimeThread;
import model.map.MapModel;
import views.GameColors;
import views.PACMANGame;
import views.ViewCardPanel;
import views.game.components.GameCardPanel;
import views.game.components.panels.gameWindow.CurrentStats;
import views.menu.MenuStart;
import views.menu.components.MenuCardPanel;
import views.menu.components.upperPanels.Buttons;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class PacKeyMovement implements KeyListener {

    int playerRow;
    int playerColumn;
    JTable table;
    MapModel mapModel;
    PACMANGame pacmanGame;

    public PacKeyMovement(JTable table, MapModel mapModel, PACMANGame pacmanGame) {
        this.table = table;
        this.mapModel = mapModel;
        this.playerColumn = mapModel.getPlayerY();
        this.playerRow = mapModel.getPlayerX();
        this.pacmanGame = pacmanGame;

    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {

//        //todo cos trzeba z tym zrobic
        if (e.getKeyCode() == KeyEvent.VK_Q && e.isControlDown() && e.isShiftDown()) {
            System.out.println("Pressed Ctrl + Shift + Q");

            new SwingWorker() {
                @Override
                protected Object doInBackground() throws Exception {
                    CurrentStats.timeThread.interrupt();
                    TimeThread.isGameViewReady = false;

                    CardLayout cl = (CardLayout) (pacmanGame.viewsCardPanel.getLayout());
                    cl.show(pacmanGame.viewsCardPanel, pacmanGame.viewsCardPanel.currentCardName);
                    pacmanGame.viewsCardPanel.currentCardName = ViewCardPanel.MENU_VIEW;

                    CardLayout cl2 = (CardLayout) (MenuStart.cardsPanel.getLayout());
                    MenuStart.cardsPanel.currentCardName = MenuCardPanel.TEXT;
                    Buttons.new_game.setBackground(GameColors.pink);
                    Buttons.high_scores.setBackground(GameColors.pink);
                    cl2.show(MenuStart.cardsPanel, MenuCardPanel.TEXT);

                    GameCardPanel.currentCardName = GameCardPanel.START_SCREEN_1;

                    CurrentStats.livesNumber = 5;
                    CurrentStats.yourScore = 0;

                    return null;
                }
            }.execute();
        }

        switch (e.getKeyCode()) {
            case KeyEvent.VK_W, KeyEvent.VK_UP -> mapModel.setPlayerXUstawKolumne(mapModel.getPlayerX() - 1);

            case KeyEvent.VK_A, KeyEvent.VK_LEFT -> {
                if (mapModel.getPlayerY() - 1 < 0) {
                    mapModel.setPlayerYUstawRzad(mapModel.getColumnCount() - 1);
                    return;
                }
                mapModel.setPlayerYUstawRzad(mapModel.getPlayerY() - 1);
            }

            case KeyEvent.VK_S, KeyEvent.VK_DOWN -> mapModel.setPlayerXUstawKolumne(mapModel.getPlayerX() + 1);

            case KeyEvent.VK_D, KeyEvent.VK_RIGHT -> {
                if (mapModel.getPlayerY() + 1 > mapModel.getColumnCount() - 1) {
                    mapModel.setPlayerYUstawRzad(0);
                    return;
                }
                mapModel.setPlayerYUstawRzad(mapModel.getPlayerY() + 1);
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }
}
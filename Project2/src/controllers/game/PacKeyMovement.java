package controllers.game;

import model.game.GameThread;
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

import static model.map.MapModel.player;

public class PacKeyMovement implements KeyListener {

    int playerRow;
    int playerColumn;
    JTable table;
    MapModel mapModel;
    PACMANGame pacmanGame;

    public PacKeyMovement(JTable table, MapModel mapModel, PACMANGame pacmanGame) {
        this.table = table;
        this.mapModel = mapModel;
        this.pacmanGame = pacmanGame;

    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {

        if (e.getKeyCode() == KeyEvent.VK_Q && e.isControlDown() && e.isShiftDown()) {
            if (CurrentStats.timeThread == null) return;
            System.out.println("Pressed Ctrl + Shift + Q");

            GameThread.isGameViewReady.set(false);

            CardLayout cl = (CardLayout) (pacmanGame.viewsCardPanel.getLayout());
            pacmanGame.viewsCardPanel.currentCardName = ViewCardPanel.MENU_VIEW;
            cl.show(pacmanGame.viewsCardPanel, pacmanGame.viewsCardPanel.currentCardName);

            CardLayout cl2 = (CardLayout) (MenuStart.cardsPanel.getLayout());
            MenuStart.cardsPanel.currentCardName = MenuCardPanel.TEXT;
            Buttons.new_game.setBackground(GameColors.pink);
            Buttons.high_scores.setBackground(GameColors.pink);
            cl2.show(MenuStart.cardsPanel, MenuCardPanel.TEXT);

            GameCardPanel.currentCardName = GameCardPanel.START_SCREEN_1;

            CurrentStats.livesNumber = 5;
            CurrentStats.yourScore = 0;
            return;
        }

        switch (e.getKeyCode()) {
            case KeyEvent.VK_W, KeyEvent.VK_UP -> {
                player.moveHorizontally(player.getCurrentRow() - 1);
            }

            case KeyEvent.VK_A, KeyEvent.VK_LEFT -> {
                if (player.getCurrentColumn() - 1 < 0) {
                    player.moveVertically(mapModel.getColumnCount() - 1);
                    return;
                }
                player.moveVertically(player.getCurrentColumn() - 1);
            }

            case KeyEvent.VK_S, KeyEvent.VK_DOWN -> {
                player.moveHorizontally(player.getCurrentRow() + 1);
            }

            case KeyEvent.VK_D, KeyEvent.VK_RIGHT -> {
                if (player.getCurrentColumn() + 1 > mapModel.getColumnCount() - 1) {
                    player.moveVertically(0);
                    return;
                }
                player.moveVertically(player.getCurrentColumn() + 1);
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }
}
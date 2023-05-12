package controllers.game;

import model.game.TimeThread;
import views.GameColors;
import views.PACMANGame;
import views.ViewCardPanel;
import views.game.components.GameCardPanel;
import views.game.components.panels.gameWindow.CurrentStats;
import views.menu.MenuStart;
import views.menu.components.MenuCardPanel;
import views.menu.components.upperPanels.Buttons;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class BackToMenuShortCut implements KeyListener {

    PACMANGame pacmanGame;

    public BackToMenuShortCut(PACMANGame pacmanGame) {
        this.pacmanGame = pacmanGame;
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_Q && e.isControlDown() && e.isShiftDown()) {
            System.out.println("Pressed Ctrl + Shift + Q");

            CurrentStats.timeThread.interrupt();
            TimeThread.isGameViewReady = false;

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
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}

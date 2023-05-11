package controllers.game;

import views.GameColors;
import views.PACMANGame;
import views.ViewCardPanel;
import views.game.components.GameCardPanel;
import views.menu.components.MenuCardPanel;
import views.menu.components.middlePanels.NewGame;
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

            PACMANGame.menuStart.cardsPanel.currentCardName = MenuCardPanel.TEXT;
            Buttons.new_game.setBackground(GameColors.pink);
            Buttons.high_scores.setBackground(GameColors.pink);

            CardLayout cl = (CardLayout) (pacmanGame.viewsCardPanel.getLayout());
            cl.show(pacmanGame.viewsCardPanel, ViewCardPanel.MENU_VIEW);
            pacmanGame.viewsCardPanel.currentCardName = ViewCardPanel.MENU_VIEW;

            GameCardPanel.currentCardName = GameCardPanel.START_SCREEN_1;

            NewGame.setRows = 0;
            NewGame.setColumns = 0;
            NewGame.setYourNick = null;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}

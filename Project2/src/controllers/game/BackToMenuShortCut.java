package controllers.game;

import model.characters.Player;
import model.game.GameThread;
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

import static model.map.MapModel.cookiesCounter;


public class BackToMenuShortCut implements KeyEventDispatcher {

    PACMANGame pacmanGame;

    public BackToMenuShortCut(PACMANGame pacmanGame) {
        this.pacmanGame = pacmanGame;
    }


    @Override
    public boolean dispatchKeyEvent(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_Q && e.isControlDown() && e.isShiftDown()) {
            if (CurrentStats.timeThread == null) return false;
            System.out.println("Pressed Ctrl + Shift + Q");
            cookiesCounter = 0;
            GameThread.isReady.set(false);
            GameThread.isGameViewReady.set(false);

            CardLayout cl = (CardLayout) (PACMANGame.viewsCardPanel.getLayout());
            PACMANGame.viewsCardPanel.currentCardName = ViewCardPanel.MENU_VIEW;
            cl.show(PACMANGame.viewsCardPanel, PACMANGame.viewsCardPanel.currentCardName);

            CardLayout cl2 = (CardLayout) (MenuStart.cardsPanel.getLayout());
            MenuStart.cardsPanel.currentCardName = MenuCardPanel.TEXT;
            Buttons.new_game.setBackground(GameColors.pink);
            Buttons.high_scores.setBackground(GameColors.pink);
            cl2.show(MenuStart.cardsPanel, MenuCardPanel.TEXT);

            GameCardPanel.currentCardName = GameCardPanel.START_SCREEN_1;

            Player.numberOfBonusesOnMap = 0;
            CurrentStats.livesNumber = 5;
            CurrentStats.yourScore = 0;
            return true;
        }
        return false;
    }
}

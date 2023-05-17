package views.game.components;

import views.GameColors;
import views.PACMANGame;
import views.ViewCardPanel;
import views.menu.MenuStart;
import views.menu.components.MenuCardPanel;
import views.menu.components.upperPanels.Buttons;

import javax.swing.*;
import java.awt.*;

import static views.PACMANGame.game;

public class EndGameViewChange {


    public EndGameViewChange() {

        new SwingWorker() {
            @Override
            protected Object doInBackground() throws Exception {
                CardLayout cl = (CardLayout) (game.gameCardPanel.getLayout());
                cl.show(game.gameCardPanel, GameCardPanel.GAME_OVER);
                Thread.sleep(2000);

                CardLayout cl1 = (CardLayout) (PACMANGame.viewsCardPanel.getLayout());
                cl1.show(PACMANGame.viewsCardPanel, ViewCardPanel.MENU_VIEW);

                CardLayout cl2 = (CardLayout) (MenuStart.cardsPanel.getLayout());
                Buttons.new_game.setBackground(GameColors.pink);
                Buttons.high_scores.setBackground(GameColors.pink);
                cl2.show(MenuStart.cardsPanel, MenuCardPanel.HIGHSCORE);

                return null;
            }
        }.execute();
    }
}

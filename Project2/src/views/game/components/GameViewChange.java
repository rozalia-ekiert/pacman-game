package views.game.components;

import views.PACMANGame;
import views.game.Game;

import javax.swing.*;
import java.awt.*;

public class GameViewChange {

    Game game;
    PACMANGame pacmanGame;
    String current;

    public GameViewChange(Game game, PACMANGame pacmanGame) {
        this.game = game;
        this.pacmanGame = pacmanGame;
        this.current = game.gameCardPanel.currentCardName;
        long now = System.currentTimeMillis();

        new SwingWorker() {
            @Override
            protected Object doInBackground() throws Exception {
                Thread.sleep(3000);
                CardLayout cl = (CardLayout) (game.gameCardPanel.getLayout());
                cl.show(game.gameCardPanel, GameCardPanel.START_SCREEN_2);
                game.gameCardPanel.currentCardName = GameCardPanel.START_SCREEN_2;
                return null;
            }
        }.execute();

        new SwingWorker() {
            @Override
            protected Object doInBackground() throws Exception {
                Thread.sleep(6000);
                CardLayout cl = (CardLayout) (game.gameCardPanel.getLayout());
                cl.show(game.gameCardPanel, GameCardPanel.GAME_WINDOW);
                game.gameCardPanel.currentCardName = GameCardPanel.GAME_WINDOW;
                return null;
            }
        }.execute();

    }
}

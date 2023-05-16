package views.game.components;

import model.game.GameThread;
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
        this.current = GameCardPanel.START_SCREEN_1;

        new SwingWorker() {
            @Override
            protected Object doInBackground() throws Exception {
                Thread.sleep(500); //todo zmiana czasu
                CardLayout cl = (CardLayout) (game.gameCardPanel.getLayout());
                cl.show(game.gameCardPanel, GameCardPanel.START_SCREEN_2);
                GameCardPanel.currentCardName = GameCardPanel.START_SCREEN_2;

                Thread.sleep(500);
                cl.show(game.gameCardPanel, GameCardPanel.GAME_WINDOW);
                GameCardPanel.currentCardName = GameCardPanel.GAME_WINDOW;
                GameThread.isGameViewReady.set(true);
                return null;
            }
        }.execute();


    }
}

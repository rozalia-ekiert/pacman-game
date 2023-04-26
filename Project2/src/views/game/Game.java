package views.game;

import views.PACMANGame;
import views.game.components.GameCardPanel;
import views.game.components.panels.GameOver;
import views.game.components.panels.GameStartScreen1;
import views.game.components.panels.GameStartScreen2;
import views.game.components.panels.GameWindow;

import javax.swing.*;

public class Game extends JPanel {

    public GameCardPanel gameCardPanel;

    public Game(int width, int height, PACMANGame pacmanGame) {

        gameCardPanel = new GameCardPanel();

        GameStartScreen1 startScreen1 = new GameStartScreen1(width, height, pacmanGame);
        GameStartScreen2 startScreen2 = new GameStartScreen2(width, height, pacmanGame);
        GameWindow gameWindow = new GameWindow(width, height, pacmanGame);
        GameOver gameOver = new GameOver(width, height, pacmanGame);

        gameCardPanel.add(startScreen1, GameCardPanel.START_SCREEN_1);
        gameCardPanel.add(startScreen2, GameCardPanel.START_SCREEN_2);
        gameCardPanel.add(gameWindow, GameCardPanel.GAME_WINDOW);
        gameCardPanel.add(gameOver, GameCardPanel.GAME_OVER);

        this.add(gameCardPanel);
    }

}

package views.game;

import views.PACMANGame;
import views.game.components.GameCardPanel;
import views.game.components.panels.GameOver;
import views.game.components.panels.GameStartScreen1;
import views.game.components.panels.GameStartScreen2;
import views.game.components.panels.GameWindow;

import javax.swing.*;
import java.awt.*;

public class Game extends JPanel {

    public static GameWindow gameWindow;
    public final GameCardPanel gameCardPanel;
    PACMANGame pacmanGame;

    public Game(PACMANGame pacmanGame) {
        this.pacmanGame = pacmanGame;
        this.setFocusable(true);

        this.setBackground(Color.BLACK);
        this.setLayout(new GridLayout(1, 1));

        this.setFont(pacmanGame.Butterbelly);
        this.gameCardPanel = new GameCardPanel();

        GameStartScreen1 startScreen1 = new GameStartScreen1(pacmanGame.screenWidth, pacmanGame.screenHeight, pacmanGame);
        GameStartScreen2 startScreen2 = new GameStartScreen2(pacmanGame.screenWidth, pacmanGame.screenHeight, pacmanGame);
        GameOver gameOver = new GameOver(pacmanGame.screenWidth, pacmanGame.screenHeight, pacmanGame);

        gameCardPanel.add(startScreen1, GameCardPanel.START_SCREEN_1);
        gameCardPanel.add(startScreen2, GameCardPanel.START_SCREEN_2);
        gameCardPanel.add(gameOver, GameCardPanel.GAME_OVER);

        this.add(gameCardPanel);
    }
}

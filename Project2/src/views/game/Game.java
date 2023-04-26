package views.game;

import views.PACMANGame;
import views.game.components.GameStart;

import javax.swing.*;

public class Game extends JPanel {

    public Game(int width, int height, PACMANGame pacmanGameFrame) {

        GameStart startScreen = new GameStart(width, height, pacmanGameFrame);
        this.add(startScreen);

    }

}

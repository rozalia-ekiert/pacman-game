package views.game;

import views.PACMANGame;
import views.game.components.GameStartScreen1;

import javax.swing.*;

public class Game extends JPanel {

    public Game(int width, int height, PACMANGame pacmanGameFrame) {

        GameStartScreen1 startScreen = new GameStartScreen1(width, height, pacmanGameFrame);
        this.add(startScreen);

    }

}

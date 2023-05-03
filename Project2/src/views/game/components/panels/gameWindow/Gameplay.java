package views.game.components.panels.gameWindow;

import views.PACMANGame;

import javax.swing.*;
import java.awt.*;

public class Gameplay extends JPanel {

    public GameplayMap map;
    public Gameplay(int width, int height, PACMANGame pacmanGame) {

        this.setPreferredSize(new Dimension(width, height));

        this.setBackground(Color.BLACK);
        this.setLayout(new GridBagLayout());

        int sqHeight = (int) (height * 0.9);
        int sqWidth = sqHeight;

        map = new GameplayMap(sqWidth, sqHeight);

        this.add(map);
    }
}
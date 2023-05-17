package views.game.components.panels.gameWindow;

import views.PACMANGame;

import javax.swing.*;
import java.awt.*;

public class Gameplay extends JPanel {

    public static GameplayMap map;
    public static int sqHeight;
    public static int sqWidth;

    public Gameplay(int width, int height, PACMANGame pacmanGame, int setRows, int setColumns) {

        this.setBackground(Color.BLACK);
        this.setLayout(new GridBagLayout());

        sqHeight = (int) (height * 0.85);
        sqWidth = sqHeight;
        GridBagConstraints gbc = new GridBagConstraints();


        map = new GameplayMap(sqWidth, sqHeight, pacmanGame, setRows, setColumns);
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.anchor = GridBagConstraints.CENTER;
        this.add(Gameplay.map, gbc);


    }
}
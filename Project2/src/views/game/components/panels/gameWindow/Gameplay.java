package views.game.components.panels.gameWindow;

import views.PACMANGame;

import javax.swing.*;
import java.awt.*;

public class Gameplay extends JPanel {

    public Gameplay(int width, int height, PACMANGame pacmanGame) {

        this.setPreferredSize(new Dimension(width, height));
        this.setBackground(Color.BLACK);
        this.setLayout(new GridBagLayout());

        int sqHeight = height - 100;
        int sqWidth = sqHeight;

        // --------------------------------------------------------------------------------
        JPanel map = new GameplayMap(sqWidth, sqHeight);

        // --------------------------------------------------------------------------------

        GridBagConstraints gbc = new GridBagConstraints();

        gbc.fill = GridBagConstraints.VERTICAL;
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridheight = 1;
        gbc.gridwidth = 1;
        gbc.anchor = GridBagConstraints.FIRST_LINE_START;
        gbc.insets = new Insets(0, 0, 20, 0);
        this.add(map, gbc);

//        gbc.gridx = 0;
//        gbc.gridy = 1;
//        gbc.gridheight = 1;
//        gbc.gridwidth = 1;
//        gbc.insets = new Insets(0, 0, 40, 0);
//        this.add(lives, gbc);
    }
}

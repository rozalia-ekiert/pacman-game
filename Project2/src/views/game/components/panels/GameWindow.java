package views.game.components.panels;

import views.PACMANGame;
import views.game.components.panels.gameWindow.Comments;
import views.game.components.panels.gameWindow.CurrentStats;
import views.game.components.panels.gameWindow.Gameplay;

import javax.swing.*;
import java.awt.*;

public class GameWindow extends JPanel {

    public GameWindow(int width, int height, PACMANGame pacmanGame) {
//        int top = 30;
//        this.setBorder(BorderFactory.createMatteBorder(top, top, top, top, Color.RED));

        this.setPreferredSize(new Dimension(width, height));
        this.setBackground(Color.BLACK);

        CurrentStats currentStats = new CurrentStats((int) (width * 0.2), height, pacmanGame);
        Gameplay gameplay = new Gameplay((int) (width * 0.6), height, pacmanGame);
        Comments comments = new Comments((int) (width * 0.2), height, pacmanGame);

        this.setLayout(new BoxLayout(this, 0));
        //=======================================================

//        this.setFocusable(true);
//        this.addKeyListener(new PacmanMovement(mapModel.pacCurrentX, mapModel.pacCurrentY));

        //=======================================================


//        GridBagConstraints gbc = new GridBagConstraints();
//        gbc.fill = GridBagConstraints.BOTH;
//
//        gbc.gridx = 0;
//        gbc.gridy = 0;
//        gbc.gridheight = 1;
//        gbc.gridwidth = 1;
//        gbc.insets = new Insets(0, 0, 0, 0);
//        gbc.anchor = GridBagConstraints.CENTER;
//        this.add(currentStats);

//        gbc.gridx = 1;
//        gbc.gridy = 0;
//        gbc.gridheight = 1;
//        gbc.gridwidth = 1;
//        gbc.insets = new Insets(40, 0, 0, 0);
//        gbc.anchor = GridBagConstraints.CENTER;
//        this.add(gameplay);

//        gbc.gridx = 3;
//        gbc.gridy = 0;
//        gbc.gridheight = 1;
//        gbc.gridwidth = 1;
//        gbc.insets = new Insets(0, 0, 0, 0);
//        gbc.anchor = GridBagConstraints.CENTER;
//        this.add(comments);

        this.add(currentStats);
        gameplay.setBorder(BorderFactory.createMatteBorder(0, 3, 0, 3, Color.WHITE));
        this.add(gameplay);
        this.add(comments);
    }
}

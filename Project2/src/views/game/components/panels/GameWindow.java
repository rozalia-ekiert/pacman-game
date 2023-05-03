package views.game.components.panels;

import views.PACMANGame;
import views.game.components.panels.gameWindow.Comments;
import views.game.components.panels.gameWindow.CurrentStats;
import views.game.components.panels.gameWindow.Gameplay;

import javax.swing.*;
import java.awt.*;

public class GameWindow extends JPanel {

    public GameWindow(int width, int height, PACMANGame pacmanGame) {

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

        this.add(currentStats);
        gameplay.setBorder(BorderFactory.createMatteBorder(0, 3, 0, 3, Color.WHITE));
        this.add(gameplay);
        this.add(comments);
    }
}
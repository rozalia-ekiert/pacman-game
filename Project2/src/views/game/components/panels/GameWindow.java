package views.game.components.panels;

import views.PACMANGame;
import views.game.components.panels.gameWindow.Comments;
import views.game.components.panels.gameWindow.CurrentStats;
import views.game.components.panels.gameWindow.Gameplay;

import javax.swing.*;
import java.awt.*;

public class GameWindow extends JPanel {

    public Gameplay gameplay;
    public CurrentStats currentStats;

    public GameWindow(int width, int height, PACMANGame pacmanGame, int setRows, int setColumns) {

        this.setPreferredSize(new Dimension(width, height));
        this.setBackground(Color.BLACK);
        this.setFocusable(true);

        currentStats = new CurrentStats((int) (width * 0.2), height, pacmanGame);
        gameplay = new Gameplay((int) (width * 0.6), height, pacmanGame, setRows, setColumns);
        Comments comments = new Comments((int) (width * 0.2), height, pacmanGame);

        this.setLayout(new BoxLayout(this, 0));

        //=======================================================

        this.add(currentStats);
        gameplay.setBorder(BorderFactory.createMatteBorder(0, 3, 0, 3, Color.WHITE));
        this.add(gameplay);
        this.add(comments);
    }
}
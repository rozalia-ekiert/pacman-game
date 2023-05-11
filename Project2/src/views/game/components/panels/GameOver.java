package views.game.components.panels;

import views.PACMANGame;

import javax.swing.*;
import java.awt.*;

public class GameOver extends JPanel {

    public GameOver(int width, int height, PACMANGame pacmanGame) {

        this.setPreferredSize(new Dimension(width, height));
        this.setBackground(Color.BLACK);
        this.setLayout(new GridBagLayout());
        this.setFocusable(true);

        String text = "<html><center>GAME OVER</center></html>";
        JLabel textLabel = new JLabel(text);

        textLabel.setFocusable(false);
        textLabel.setBackground(Color.BLACK);
        textLabel.setForeground(Color.WHITE);
        textLabel.setFont(pacmanGame.Butterbelly);

        this.add(textLabel);
    }
}

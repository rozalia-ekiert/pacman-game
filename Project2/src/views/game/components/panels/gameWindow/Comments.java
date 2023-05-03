package views.game.components.panels.gameWindow;

import views.PACMANGame;

import javax.swing.*;
import java.awt.*;

public class Comments extends JPanel {

    String comment; // z pliku?

    public Comments(int width, int height, PACMANGame pacmanGame) {

        this.setPreferredSize(new Dimension(width, height));
        this.setBackground(Color.BLACK);

        this.setLayout(new BoxLayout(this, 0));

        this.comment = "be proud of yourself [player], you just ate cute corgi's soul. was it worth it??"; //todo zmiana
        String text = "<html><center>" + comment + "</center></html>";

        JLabel textLabel = new JLabel(text);
        textLabel.setBackground(Color.BLACK);
        textLabel.setForeground(Color.WHITE);
        textLabel.setFont(pacmanGame.Butterbelly);

        this.add(textLabel);

    }
}

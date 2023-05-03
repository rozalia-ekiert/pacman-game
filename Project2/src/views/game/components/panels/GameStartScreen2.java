package views.game.components.panels;

import views.PACMANGame;

import javax.swing.*;
import java.awt.*;

public class GameStartScreen2 extends JPanel {

    public GameStartScreen2(int width, int height, PACMANGame pacmanGame) {
//        int top = 30;
//        this.setBorder(BorderFactory.createMatteBorder(top, top, top, top, Color.RED));

        this.setPreferredSize(new Dimension(width, height));
        this.setBackground(Color.BLACK);

        this.setLayout(new GridBagLayout());

        String text = "<html><center>Get ready!</center></html>";

        JLabel textLabel = new JLabel(text);
        textLabel.setBackground(Color.BLACK);
        textLabel.setForeground(Color.WHITE);
        textLabel.setFont(pacmanGame.Butterbelly);

        this.add(textLabel);
    }
}

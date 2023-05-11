package views.game.components.panels;

import views.PACMANGame;

import javax.swing.*;
import java.awt.*;

public class Gameplay extends JPanel {

    public Gameplay(int width, int height, PACMANGame pacmanGame) {

        this.setPreferredSize(new Dimension(width, height));
        this.setBackground(Color.BLACK);
        this.setFocusable(true);

        this.setLayout(new GridBagLayout());

        String text = "TO MOJ GAME WINDOW";
        JTextArea textArea = new JTextArea(text, 5, 20);

        textArea.setForeground(Color.WHITE);
        textArea.setBackground(Color.BLACK);
        textArea.setFont(pacmanGame.Butterbelly);

        this.add(textArea);
    }
}

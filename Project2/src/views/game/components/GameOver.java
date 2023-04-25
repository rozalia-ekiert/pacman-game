package views.game.components;

import views.PACMANGame;

import javax.swing.*;
import java.awt.*;

public class GameOver extends JPanel {

    public GameOver(int width, int height, PACMANGame pacmanGameFrame) {
        this.setPreferredSize(new Dimension(width, height));
        this.setBackground(Color.BLACK);

        this.setLayout(new GridBagLayout());


        String text = "GAME OVER";

        JTextArea textArea = new JTextArea(text, 1, 20);

        textArea.setForeground(Color.WHITE);
        textArea.setBackground(Color.BLACK);
        textArea.setFont(pacmanGameFrame.Butterbelly);

        textArea.setEnabled(false);
        textArea.setEditable(false);

        this.add(textArea);
    }
}

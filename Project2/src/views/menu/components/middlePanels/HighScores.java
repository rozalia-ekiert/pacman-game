package views.menu.components.middlePanels;

import views.PACMANGame;

import javax.swing.*;
import java.awt.*;

public class HighScores extends JPanel {

    public HighScores(int width, int height, PACMANGame pacmanGameFrame) {
        this.setPreferredSize(new Dimension(width, height));
        this.setBackground(Color.BLACK);

        this.setLayout(new GridBagLayout());


        String text = "TO JEST PANEL DO HighScore";

        JTextArea textArea = new JTextArea(text, 1, 20);
        textArea.setForeground(Color.WHITE);
        textArea.setBackground(Color.BLACK);
        textArea.setFont(pacmanGameFrame.Butterbelly);

        this.add(textArea);
    }

}

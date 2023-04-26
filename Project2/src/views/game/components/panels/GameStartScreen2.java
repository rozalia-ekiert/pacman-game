package views.game.components.panels;

import views.PACMANGame;

import javax.swing.*;
import java.awt.*;

public class GameStartScreen2 extends JPanel {

    public GameStartScreen2(int width, int height, PACMANGame pacmanGameFrame) {

        this.setPreferredSize(new Dimension(width, height));
        this.setBackground(Color.BLACK);

        this.setLayout(new GridBagLayout());


        String text = "Get ready!";

        JTextArea textArea = new JTextArea(text, 7, 20);

        textArea.setForeground(Color.WHITE);
        textArea.setBackground(Color.BLACK);
        textArea.setFont(pacmanGameFrame.Butterbelly);

        textArea.setEnabled(false);
        textArea.setEditable(false);

        this.add(textArea);
    }
}

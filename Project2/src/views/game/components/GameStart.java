package views.game.components;

import views.PACMANGame;

import javax.swing.*;
import java.awt.*;

public class GameStart extends JPanel {

    public GameStart(int width, int height, PACMANGame pacmanGameFrame) {
        this.setPreferredSize(new Dimension(width, height));
        this.setBackground(Color.BLACK);

        this.setLayout(new GridBagLayout());


        String text = "\tOh, nice to see you, [player_name]. This game is more like playing the judge.\n " +
                "You will see some comments on the right panel of its.\n\n" +
                "Note: it was not meant to offense you. Have fun!\n\n\n" +
                "Get ready!";

        JTextArea textArea = new JTextArea(text, 7, 20);

        textArea.setForeground(Color.WHITE);
        textArea.setBackground(Color.BLACK);
        textArea.setFont(pacmanGameFrame.Butterbelly);

        textArea.setEnabled(false);
        textArea.setEditable(false);

        this.add(textArea);
    }
}

package views.game.components.panels;

import views.PACMANGame;

import javax.swing.*;
import java.awt.*;

public class GameStartScreen1 extends JPanel {

    public GameStartScreen1(int width, int height, PACMANGame pacmanGameFrame) {

        this.setPreferredSize(new Dimension(width, height));
        this.setBackground(Color.BLACK);

        this.setLayout(new GridBagLayout());

        //==========================================================

        String introText = "Oh, nice to see you, [player_name]. This game is more like .................\n" +
                "You will see some comments on the right panel of its.\n\n" +
                "Note: it was not meant to offense you.\n\n" +
                "Have fun!";

        JTextArea introTextArea = new JTextArea(introText, 7, 20);
        introTextArea.setBackground(Color.BLACK);
        introTextArea.setForeground(Color.WHITE);
        introTextArea.setFont(pacmanGameFrame.Butterbelly);
        introTextArea.setEditable(false);

        //==========================================================

        String infoText = "<html>PRESS <font color=#FD66C3>CTRL + SHIFT + Q </font>TO RETURN THE MAIN MANU</html>";

        JLabel infoTextLabel = new JLabel(infoText);
        infoTextLabel.setBackground(Color.BLACK);
        infoTextLabel.setForeground(Color.WHITE);
        infoTextLabel.setFont(pacmanGameFrame.Butterbelly);

        //==========================================================

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.BOTH;

        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.insets = new Insets(0, 40, 100, 0);
        gbc.anchor = GridBagConstraints.CENTER;
        this.add(introTextArea, gbc);

        gbc.gridx = 2;
        gbc.gridy = 1;
        gbc.insets = new Insets(100, 0, 0, 40);
        gbc.anchor = GridBagConstraints.LAST_LINE_END;
        this.add(infoTextLabel, gbc);
    }
}

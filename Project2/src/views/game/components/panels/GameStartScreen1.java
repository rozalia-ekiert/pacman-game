package views.game.components.panels;

import views.GameColors;
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
                "Note: it was not meant to offense you. Have fun!";

        JTextArea introTextArea = new JTextArea(introText, 7, 20);
        introTextArea.setForeground(Color.WHITE);
        introTextArea.setBackground(Color.BLACK);
        introTextArea.setFont(pacmanGameFrame.Butterbelly);
        introTextArea.setEnabled(false);
        introTextArea.setEditable(false);

        //==========================================================

        String infoText1 = "PRESS ";

        JTextArea infoText1Area = new JTextArea(introText, 7, 1);
        infoText1Area.setForeground(Color.WHITE);
        infoText1Area.setBackground(Color.BLACK);
        infoText1Area.setFont(pacmanGameFrame.Butterbelly);
        infoText1Area.setEnabled(false);
        infoText1Area.setEditable(false);

        //==========================================================

        String shortcutText = "CTRL + SHIFT + Q ";

        JTextArea shortcutTextArea = new JTextArea(introText, 7, 1);
        shortcutTextArea.setForeground(Color.WHITE);
        shortcutTextArea.setBackground(GameColors.pink);
        shortcutTextArea.setFont(pacmanGameFrame.Butterbelly);
        shortcutTextArea.setEnabled(false);
        shortcutTextArea.setEditable(false);

        //==========================================================

        String infoText2 = "TO RETURN THE MAIN MANU";

        JTextArea infoText2Area = new JTextArea(introText, 7, 1);
        infoText2Area.setForeground(Color.WHITE);
        infoText2Area.setBackground(Color.BLACK);
        infoText2Area.setFont(pacmanGameFrame.Butterbelly);
        infoText2Area.setEnabled(false);
        infoText2Area.setEditable(false);

        //==========================================================


        this.add(introTextArea);
    }
}

package views.game.components.panels;

import views.GameColors;
import views.PACMANGame;

import javax.swing.*;
import javax.swing.text.JTextComponent;
import java.awt.*;
import java.util.ArrayList;

public class CurrentStats extends JPanel {

    //todo
    String highScore = "055 345";
    String yourScore = "000 555";
    String time = "00:34";

    public CurrentStats(int width, int height, PACMANGame pacmanGame) {

        this.setPreferredSize(new Dimension(width, height));
        this.setBackground(Color.BLACK);
        this.setForeground(Color.WHITE);
        this.setFont(pacmanGame.Butterbelly);

        this.setLayout(new GridBagLayout());

        //======================================================================

        JLabel highScoreArea = new JLabel("high score:");
        JTextArea yourScoreArea = new JTextArea("your score:");
        JTextArea timeArea = new JTextArea("time:");

        JLabel setHighScore = new JLabel(highScore);
        JTextArea setYourScore = new JTextArea(yourScore);
        JTextArea setTime = new JTextArea(time);

        ArrayList<JTextComponent> list = new ArrayList<>();
        list.add(yourScoreArea);
        list.add(setYourScore);
        list.add(timeArea);
        list.add(setTime);

        for (JTextComponent j : list) {
            j.setBackground(Color.BLACK);
            j.setForeground(Color.WHITE);
            j.setFont(pacmanGame.Butterbelly);
        }

        highScoreArea.setBackground(Color.BLACK);
        highScoreArea.setForeground(GameColors.pink);
        highScoreArea.setFont(pacmanGame.Butterbelly);

        setHighScore.setBackground(Color.BLACK);
        setHighScore.setForeground(GameColors.pink);
        setHighScore.setFont(pacmanGame.Butterbelly);

        //======================================================================

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.NORTH;

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridheight = 1;
        gbc.gridwidth = 1;
        gbc.insets = new Insets(0, 0, 10, 0);
//        gbc.anchor = GridBagConstraints.NORTH;
        this.add(highScoreArea, gbc);

//        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridheight = 1;
        gbc.gridwidth = 1;
        gbc.insets = new Insets(0, 0, 80, 0);
//        gbc.anchor = GridBagConstraints.NORTH;
        this.add(setHighScore, gbc);

//        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridheight = 1;
        gbc.gridwidth = 1;
        gbc.insets = new Insets(0, 0, 10, 0);
//        gbc.anchor = GridBagConstraints.LINE_START;
        this.add(yourScoreArea, gbc);

//        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridheight = 1;
        gbc.gridwidth = 1;
        gbc.insets = new Insets(0, 0, 40, 0);
//        gbc.anchor = GridBagConstraints.LINE_START;
        this.add(setYourScore, gbc);

//        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridheight = 1;
        gbc.gridwidth = 1;
        gbc.insets = new Insets(0, 0, 10, 0);
//        gbc.anchor = GridBagConstraints.LINE_START;
        this.add(timeArea, gbc);

//        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.gridheight = 1;
        gbc.gridwidth = 1;
        gbc.insets = new Insets(0, 0, (int) (height * 0.5), (int) (width * 0.6));
//        gbc.anchor = GridBagConstraints.LINE_START;
        this.add(setTime, gbc);
    }
}

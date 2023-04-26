package views.game.components.panels;

import views.PACMANGame;

import javax.swing.*;
import java.awt.*;

public class CurrentStats extends JPanel {

    //todo
    String highScore = "055 345";
    String yourScore = "000 555";
    String time = "00:34";

    public CurrentStats(int width, int height, PACMANGame pacmanGame) {

        this.setPreferredSize(new Dimension(width, height));
        this.setBackground(Color.BLACK);

        this.setLayout(new BoxLayout(this, 1));

        JTextArea highScoreArea = new JTextArea("high score:");
        JTextArea yourScoreArea = new JTextArea("your score:");
        JTextArea timeArea = new JTextArea("time:");

        JTextArea setHighScore = new JTextArea(highScore);
        JTextArea setYourScore = new JTextArea(yourScore);
        JTextArea setTime = new JTextArea(time);

        this.add(highScoreArea);
        this.add(setHighScore);
        this.add(yourScoreArea);
        this.add(setYourScore);
        this.add(timeArea);
        this.add(setTime);
    }
}

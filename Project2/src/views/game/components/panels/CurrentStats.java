package views.game.components.panels;

import views.GameColors;
import views.PACMANGame;

import javax.swing.*;
import java.awt.*;

public class CurrentStats extends JPanel {

    //todo
    int highScore = 055345;
    int yourScore = 555;
    long time = 408000; // w milisekundach

    JLabel highScoreArea;
    JLabel setHighScore;
    JLabel yourScoreArea;
    JLabel setYourScore;
    JLabel timeArea;
    JLabel setTime;


    public CurrentStats(int width, int height, PACMANGame pacmanGame) {
        this.setBackground(Color.BLACK);
        this.setForeground(Color.WHITE);
        this.setFont(pacmanGame.Butterbelly);

        this.setLayout(new GridBagLayout());

        Font currentButterbelly = new Font("Butterbelly", Font.PLAIN, 40);

        //======================================================================

        this.highScoreArea = new JLabel("high score:");
        highScoreArea.setBackground(Color.BLACK);
        highScoreArea.setForeground(GameColors.pink);
        highScoreArea.setFont(currentButterbelly);

        this.setHighScore = new JLabel(changeScoreToString(highScore));
        setHighScore.setBackground(Color.BLACK);
        setHighScore.setForeground(GameColors.pink);
        setHighScore.setFont(currentButterbelly);

        //===========================================

        this.yourScoreArea = new JLabel("your score:");
        yourScoreArea.setBackground(Color.BLACK);
        yourScoreArea.setForeground(Color.WHITE);
        yourScoreArea.setFont(currentButterbelly);

        this.setYourScore = new JLabel(changeScoreToString(yourScore));
        setYourScore.setBackground(Color.BLACK);
        setYourScore.setForeground(Color.WHITE);
        setYourScore.setFont(currentButterbelly);

        //===========================================

        this.timeArea = new JLabel("time:");
        timeArea.setBackground(Color.BLACK);
        timeArea.setForeground(Color.WHITE);
        timeArea.setFont(currentButterbelly);

        this.setTime = new JLabel(changeTimeToString(time));
        setTime.setBackground(Color.BLACK);
        setTime.setForeground(Color.WHITE);
        setTime.setFont(currentButterbelly);

        //======================================================================

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.NORTH;

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridheight = 1;
        gbc.gridwidth = 1;
        gbc.insets = new Insets(20, 30, 10, 0);
        this.add(highScoreArea, gbc);

        gbc.gridy = 1;
        gbc.gridheight = 1;
        gbc.gridwidth = 1;
        gbc.insets = new Insets(0, 30, 60, 0);
        this.add(setHighScore, gbc);

        gbc.gridy = 2;
        gbc.gridheight = 1;
        gbc.gridwidth = 1;
        gbc.insets = new Insets(0, 30, 10, 0);
        this.add(yourScoreArea, gbc);

        gbc.gridy = 3;
        gbc.gridheight = 1;
        gbc.gridwidth = 1;
        gbc.insets = new Insets(0, 30, 30, 0);
        this.add(setYourScore, gbc);

        gbc.gridy = 4;
        gbc.gridheight = 1;
        gbc.gridwidth = 1;
        gbc.insets = new Insets(0, 30, 10, 0);
        this.add(timeArea, gbc);

        gbc.gridy = 5;
        gbc.gridheight = 1;
        gbc.gridwidth = 1;
        gbc.insets = new Insets(0, 30, (int) (height * 0.5), (int) (width * 0.6));
        this.add(setTime, gbc);
    }

    public void updateYourScore() { // todo
        if (this.yourScore > this.highScore) {

            this.highScoreArea.setForeground(Color.WHITE);
            this.setHighScore.setForeground(Color.WHITE);

            this.yourScoreArea.setForeground(Color.PINK);
            this.setYourScore.setForeground(Color.PINK);
        }
    }

    public String changeScoreToString(int score) {
        int howManyDigits = String.valueOf(score).length();
        String current = String.valueOf(score);

        if (howManyDigits >= 6) return String.valueOf(score);

        String result = current;
        do {
            result = "0" + result;
        } while (result.length() != 6);

        return result;
    }

    public String changeTimeToString(long time) {

        long seconds = time / 1000;
        long minutes = seconds / 60;
        long finalSeconds = seconds % 60;

        if (minutes > 60) return ">1 hour";

        String StrMinutes = null;
        if (minutes > 9) StrMinutes = String.valueOf(minutes);
        if (minutes < 9) StrMinutes = "0" + String.valueOf(minutes);

        String StrSeconds = null;
        if (finalSeconds > 9) StrSeconds = String.valueOf(finalSeconds);
        if (finalSeconds < 9) StrSeconds = "0" + String.valueOf(finalSeconds);

        String result = StrMinutes + ":" + StrSeconds;

        return result;
    }
}
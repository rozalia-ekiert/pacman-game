package views.game.components.panels.gameWindow;

import model.NumberFormatter;
import model.game.TimeThread;
import views.GameColors;
import views.PACMANGame;

import javax.swing.*;
import java.awt.*;

public class CurrentStats extends JPanel {

    //todo
    int highScore = 110;
    public static int yourScore = 0;
    public static int lives = 5;
    long time = 0;

    JLabel highScoreArea;
    JLabel setHighScore;
    JLabel yourScoreArea;
    public static JLabel setYourScore;
    JLabel timeArea;
    JLabel setTime;
    JTable livesTable;

    PACMANGame pacmanGame;

    public CurrentStats(int width, int height, PACMANGame pacmanGame) {

        this.pacmanGame = pacmanGame;

        this.setPreferredSize(new Dimension(width, height));
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

        this.setHighScore = new JLabel(NumberFormatter.changeScoreToString(highScore));
        setHighScore.setBackground(Color.BLACK);
        setHighScore.setForeground(GameColors.pink);
        setHighScore.setFont(currentButterbelly);

        //===========================================

        this.yourScoreArea = new JLabel("your score:");
        yourScoreArea.setBackground(Color.BLACK);
        yourScoreArea.setForeground(Color.WHITE);
        yourScoreArea.setFont(currentButterbelly);

        this.setYourScore = new JLabel(NumberFormatter.changeScoreToString(yourScore));
        setYourScore.setBackground(Color.BLACK);
        setYourScore.setForeground(Color.WHITE);
        setYourScore.setFont(currentButterbelly);

        //===========================================

        this.timeArea = new JLabel("time:");
        timeArea.setBackground(Color.BLACK);
        timeArea.setForeground(Color.WHITE);
        timeArea.setFont(currentButterbelly);

        this.setTime = new JLabel(NumberFormatter.changeTimeToString(time));
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
        gbc.insets = new Insets(0, 30, 0, 0);
        this.add(setTime, gbc);


        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                TimeThread timeThread = new TimeThread(setTime, pacmanGame);
                timeThread.start();
            }
        });
    }

    public void compareYourAndHighScore() { // todo
        if (yourScore > this.highScore) {

            this.highScoreArea.setForeground(Color.WHITE);
            this.setHighScore.setForeground(Color.WHITE);

            this.yourScoreArea.setForeground(GameColors.pink);
            this.setYourScore.setForeground(GameColors.pink);
        }
    }


}
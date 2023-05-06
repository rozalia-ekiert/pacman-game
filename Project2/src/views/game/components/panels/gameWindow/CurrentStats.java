package views.game.components.panels.gameWindow;

import model.NumberFormatter;
import views.GameColors;
import views.PACMANGame;

import javax.swing.*;
import java.awt.*;

public class CurrentStats extends JPanel {

    //todo
    int highScore = 55345;
    public static int yourScore = 0;
    long time = 408000; // w milisekundach

    JLabel highScoreArea;
    JLabel setHighScore;
    JLabel yourScoreArea;
    public static JLabel setYourScore;
    JLabel timeArea;
    JLabel setTime;


    public CurrentStats(int width, int height, PACMANGame pacmanGame) {

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
    }


    public void compareYourAndHighScore() { // todo
        if (yourScore > this.highScore) {

            this.highScoreArea.setForeground(Color.WHITE);
            this.setHighScore.setForeground(Color.WHITE);

            this.yourScoreArea.setForeground(Color.PINK);
            this.setYourScore.setForeground(Color.PINK);
        }
    }

//    public void update(){
//        //początek
//                //highScore - pobierz z rankingu, jak nic nie ma to 0
//        yourScore = 0;
//        time = 0;
//
//        //co 1/10 sekundy
//        updateYourScore();
//
//    }
//
//    public int updateYourScore(){
//        yourScore = MapModel.yourScore;
//        return yourScore;
//    }

}
package views.game.components.panels.gameWindow;

import model.NumberFormatter;
import model.game.TimeThread;
import model.map.MapComponentsRenderer;
import views.GameColors;
import views.PACMANGame;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.Arrays;

public class CurrentStats extends JPanel {

    //todo
    int highScore = 110;
    public static int yourScore = 0;
    public static int livesNumber = 7;
    long time = 0;

    JLabel highScoreArea;
    JLabel setHighScore;
    JLabel yourScoreArea;
    public static JLabel setYourScore;
    JLabel timeArea;
    JLabel setTime;
    public static JTable livesTable;
    public static DefaultTableCellRenderer mapComponentsRenderer;
    public static DefaultTableModel model;
    public static int livesRows;
    public static int width;
    PACMANGame pacmanGame;
    public static int lifeCellSize;
    JLabel livesArea;

    public CurrentStats(int width, int height, PACMANGame pacmanGame) {

        this.width = width;
        this.lifeCellSize = (width - 60) / 5;
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

        //===========================================
        this.livesArea = new JLabel("lives:");
        livesArea.setBackground(Color.BLACK);
        livesArea.setForeground(Color.WHITE);
        livesArea.setFont(currentButterbelly);


        livesRows = livesNumber / 5;
        if (livesNumber % 5 != 0) livesRows += 1;

        Object[][] livesArr = new Object[livesRows][livesNumber];
        for (int i = 0; i < livesRows; i++) {
            Arrays.fill(livesArr[i], "icon");
        }
        String[] columnNames = new String[5];
        Arrays.fill(columnNames, "");

        model = new DefaultTableModel(livesArr, columnNames);

        livesTable = new JTable(model);
        mapComponentsRenderer = new MapComponentsRenderer();
        mapComponentsRenderer.setHorizontalAlignment(DefaultTableCellRenderer.RIGHT);

        livesTable.setRowHeight(lifeCellSize);
        livesTable.setBackground(Color.black);

        livesTable.setShowGrid(false);
        livesTable.setShowVerticalLines(false);
        livesTable.setShowHorizontalLines(false);
        livesTable.setCellSelectionEnabled(false);
        int finalLivesRows = livesRows;

        int counter = livesNumber;

        for (int i = 0; i < finalLivesRows; i++) {
            for (int j = 0; j < 5; j++) {
                counter--;
                livesTable.getColumnModel().getColumn(j).setPreferredWidth(lifeCellSize);
                livesTable.getColumnModel().getColumn(j).setCellRenderer(mapComponentsRenderer);
                if (counter >= 0) {
                    livesTable.setValueAt(33, i, j);
                } else {
                    livesTable.setValueAt(100, i, j);
                }
            }
        }

        //========================================================================

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.NORTH;

        int sideMargin = 20;

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridheight = 1;
        gbc.gridwidth = 1;
        gbc.insets = new Insets(20, sideMargin, 10, sideMargin);
        this.add(highScoreArea, gbc);

        gbc.gridy = 1;
        gbc.gridheight = 1;
        gbc.gridwidth = 1;
        gbc.insets = new Insets(0, sideMargin, 90, sideMargin);
        this.add(setHighScore, gbc);

        gbc.gridy = 2;
        gbc.gridheight = 1;
        gbc.gridwidth = 1;
        gbc.insets = new Insets(0, sideMargin, 10, sideMargin);
        this.add(yourScoreArea, gbc);

        gbc.gridy = 3;
        gbc.gridheight = 1;
        gbc.gridwidth = 1;
        gbc.insets = new Insets(0, sideMargin, 30, sideMargin);
        this.add(setYourScore, gbc);

        gbc.gridy = 4;
        gbc.gridheight = 1;
        gbc.gridwidth = 1;
        gbc.insets = new Insets(0, sideMargin, 10, sideMargin);
        this.add(timeArea, gbc);

        gbc.gridy = 5;
        gbc.gridheight = 1;
        gbc.gridwidth = 1;
        gbc.insets = new Insets(0, sideMargin, 0, sideMargin);
        this.add(setTime, gbc);

        gbc.gridy = 6;
        gbc.gridheight = 1;
        gbc.gridwidth = 1;
        gbc.insets = new Insets(90, sideMargin, 10, sideMargin);
        this.add(livesArea, gbc);

        gbc.gridy = 7;
        gbc.gridheight = 1;
        gbc.gridwidth = 1;
        gbc.insets = new Insets(0, sideMargin, 20, sideMargin);
        this.add(livesTable, gbc);


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
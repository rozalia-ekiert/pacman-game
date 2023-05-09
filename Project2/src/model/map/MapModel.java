package model.map;

import model.MapGenerator;
import model.NumberFormatter;
import model.characters.Enemy;
import model.characters.Player;
import views.PACMANGame;
import views.game.components.panels.gameWindow.CurrentStats;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;

public class MapModel extends AbstractTableModel {

    int rows;
    int columns;
    public static final Object mapMonitor = new Object();
    public static int cookiesCounter = 0;

    public static Player player = new Player();
    public static final ArrayList<Enemy> enemies = new ArrayList<>();

    public PACMANGame pacmanGame;
    public int[][] map;


    int playerX;
    int playerY;

    //todo pouzupelniac model slowami
    int pustePole = 19;
    int cookieBig = 20;
    int cookieSmall = 21;
    int sciana = 0;
    int pacman = 22;
    int blue = 23;
    int purple = 24;
    int green = 25;
    int pink = 26;


    public MapModel(int rows, int columns, PACMANGame pacmanGame) {
        super();
        this.rows = rows;
        this.columns = columns;
        this.pacmanGame = pacmanGame;

        //=============================================================================

//        Thread repaintMap = new Thread(){
//            @Override
//            public void run() {
//                while (true) {
//                    if (cookiesCounter == 0) {
//                        SwingUtilities.invokeLater(new Runnable() {
//                            public void run() {
//                                JLabel message = new JLabel();
//                                message.setText("N<html><font color=#E9FDAE>o more cookies! Good job!</html></font>");
//                                message.setLayout(new GridBagLayout());
//                                message.setFont(pacmanGame.Butterbelly);
//                            }
//                        });
//                        try {
//                            Thread.sleep(2000); // pauza na 2 sekundy
//                        } catch (InterruptedException e) {
//                            e.printStackTrace();
//                        }
//                        map = generateMap(rows, columns); // przerysowanie mapy
//                        break;
//                    }
//                    try {
//                        Thread.sleep(1000); // pauza na 1 sekundę
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                }
//            }
//        };

        this.map = MapGenerator.generateMap(rows, columns);
        setValueAt(pacman, rows - rows / 4, columns / 2);

        enemies.add(new Enemy());
        enemies.add(new Enemy());
        enemies.add(new Enemy());
        enemies.add(new Enemy());
    }

    public void showModel() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    } // do debuggingu

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        return Integer.class;
    }

    @Override
    public int getRowCount() {
        return rows;
    }

    @Override
    public int getColumnCount() {
        return columns;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        return map[rowIndex][columnIndex];
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        this.map[rowIndex][columnIndex] = (int) aValue;
        fireTableCellUpdated(rowIndex, columnIndex);
        this.playerY = columnIndex;
        this.playerX = rowIndex;
    }


    public int getPlayerX() {
        return playerX;
    }

    public void setPlayerXUstawKolumne(int X) {
        if (!isWall(X, getPlayerY())) {
            if (getValueAt(X, getPlayerY()).equals(cookieSmall) || getValueAt(X, getPlayerY()).equals(cookieBig)) {
                if (getValueAt(X, getPlayerY()).equals(cookieSmall)) CurrentStats.yourScore += 10;
                if (getValueAt(X, getPlayerY()).equals(cookieBig)) CurrentStats.yourScore += 50;
                cookiesCounter--;
                SwingUtilities.invokeLater(new Runnable() {
                    public void run() {
                        CurrentStats.setYourScore.setText(NumberFormatter.changeScoreToString(CurrentStats.yourScore));
                        pacmanGame.game.gameWindow.currentStats.compareYourAndHighScore();
                    }
                });
            }
            setValueAt(pustePole, getPlayerX(), getPlayerY());
            setValueAt(pacman, X, getPlayerY());
        }
    }

    public int getPlayerY() {
        return playerY;
    }

    public void setPlayerYUstawRzad(int playerY) {
        if (!isWall(getPlayerX(), playerY)) {
            if (getValueAt(getPlayerX(), playerY).equals(cookieSmall) || getValueAt(getPlayerX(), playerY).equals(cookieBig)) {
                if (getValueAt(getPlayerX(), playerY).equals(cookieSmall)) CurrentStats.yourScore += 10;
                if (getValueAt(getPlayerX(), playerY).equals(cookieBig)) CurrentStats.yourScore += 50;
                cookiesCounter--;
                SwingUtilities.invokeLater(new Runnable() {
                    public void run() {
                        CurrentStats.setYourScore.setText(NumberFormatter.changeScoreToString(CurrentStats.yourScore));
                        pacmanGame.game.gameWindow.currentStats.compareYourAndHighScore();
                    }
                });
            }
            setValueAt(pustePole, getPlayerX(), getPlayerY());
            setValueAt(pacman, getPlayerX(), playerY);
        }
    }

    private boolean isWall(int playerX, int playerY) {
        return map[playerX][playerY] <= 15;
    }

}
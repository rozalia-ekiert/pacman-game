package model.map;

import model.NumberFormatter;
import model.characters.Enemy;
import model.characters.Player;
import views.PACMANGame;
import views.game.components.panels.gameWindow.CurrentStats;
import views.game.components.panels.gameWindow.Gameplay;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;

public class MapModel extends AbstractTableModel {

    public static int rows;
    public static int columns;
    public static int cookiesCounter = 0;

    public static Player player = new Player();
    public static final ArrayList<Enemy> enemies = new ArrayList<>();

    public PACMANGame pacmanGame;
    public int[][] map;

    static int playerX;
    static int playerY;

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

    Timer timer = new Timer(2000, e -> {
        Gameplay.message.setText(Gameplay.messageDefault);
    });

    public MapModel(int rows, int columns, PACMANGame pacmanGame) {
        super();
        this.rows = rows;
        this.columns = columns;
        this.pacmanGame = pacmanGame;

        enemies.add(new Enemy());
        enemies.add(new Enemy());
        enemies.add(new Enemy());
        enemies.add(new Enemy());

        this.map = MapGenerator.generateMap(rows, columns);
        setValueAt(pacman, rows - rows / 4, columns / 2);
    }

    public void showModel() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    } // do debuggingu

    public synchronized void eatCookie() {
        cookiesCounter--;
        if (cookiesCounter == 0) {
            SwingUtilities.invokeLater(new Runnable() {
                @Override
                public void run() {

                    while (MapModel.cookiesCounter == 0) {

                        map = MapGenerator.generateMap(MapModel.rows, MapModel.columns);
                        setValueAt(pacman, rows - rows / 4, columns / 2);
                        pacmanGame.repaint();
                        Gameplay.message.setText(Gameplay.messageCookiesEaten);
                        timer.start();

//                        try {
//                            Thread.sleep(1000);
//                        } catch (InterruptedException e) {
//                            e.printStackTrace();
//                        }
                    }
                }
            });
        }
    }

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
                eatCookie();
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
                eatCookie();
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
package model.map;

import model.NumberFormatter;
import model.characters.Enemy;
import model.characters.Player;
import views.PACMANGame;
import views.game.components.GameCardPanel;
import views.game.components.panels.gameWindow.CurrentStats;
import views.game.components.panels.gameWindow.Gameplay;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import java.awt.*;
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

    Timer messageTimer = new Timer(3000, e -> {
        Gameplay.message.setText(Gameplay.messageDefault);
    });

//    Thread messageTimer = new Thread(() -> {
//        try {
//            Thread.sleep(3000);
//            Gameplay.message.setText(Gameplay.messageDefault);
//        } catch (InterruptedException ex) {
//            System.out.println("Message timer problem");
//        }
//    });

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

    private void showModel() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    } // do debuggingu

    private void eatCookie() {
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
                        messageTimer.start();
                    }
                }
            });
        }
    }

    private synchronized void eatenByGhosts() {

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                CurrentStats.livesNumber--;
                setValueAt(pacman, rows - rows / 4, columns / 2);

                Gameplay.message.setText(Gameplay.messageEatenByGhosts);
                messageTimer.start();

                removeLife();

                if (CurrentStats.livesNumber == 0) {
                    CardLayout cl = (CardLayout) (pacmanGame.game.gameCardPanel.getLayout());
                    cl.show(pacmanGame.game.gameCardPanel, GameCardPanel.GAME_OVER);
                    pacmanGame.game.gameCardPanel.currentCardName = GameCardPanel.GAME_OVER;
                }
            }

        });
    }

    private void removeLife() {
        int counter = CurrentStats.livesNumber;

        for (int i = 0; i < CurrentStats.livesRows; i++) {
            for (int j = 0; j < 5; j++) {
                counter--;
                CurrentStats.livesTable.getColumnModel().getColumn(j).setPreferredWidth(CurrentStats.lifeCellSize);
                CurrentStats.livesTable.getColumnModel().getColumn(j).setCellRenderer(CurrentStats.mapComponentsRenderer);
                if (counter >= 0) {
                    CurrentStats.livesTable.setValueAt(33, i, j);
                } else {
                    CurrentStats.livesTable.setValueAt(100, i, j);
                }
            }
        }
        CurrentStats.model.fireTableDataChanged();
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

        if (getValueAt(X, getPlayerY()).equals(23) || getValueAt(X, getPlayerY()).equals(24)
                || getValueAt(X, getPlayerY()).equals(25) || getValueAt(X, getPlayerY()).equals(26)) {
            setValueAt(pustePole, getPlayerX(), getPlayerY());
            eatenByGhosts();
            return;
        }

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

    public void setPlayerYUstawRzad(int Y) {
        if (getValueAt(getPlayerX(), Y).equals(23) || getValueAt(getPlayerX(), Y).equals(24)
                || getValueAt(getPlayerX(), Y).equals(25) || getValueAt(getPlayerX(), Y).equals(26)) {
            setValueAt(pustePole, getPlayerX(), getPlayerY());
            eatenByGhosts();
            return;
        }
        if (!isWall(getPlayerX(), Y)) {
            if (getValueAt(getPlayerX(), Y).equals(cookieSmall) || getValueAt(getPlayerX(), Y).equals(cookieBig)) {
                if (getValueAt(getPlayerX(), Y).equals(cookieSmall)) CurrentStats.yourScore += 10;
                if (getValueAt(getPlayerX(), Y).equals(cookieBig)) CurrentStats.yourScore += 50;
                eatCookie();
                SwingUtilities.invokeLater(new Runnable() {
                    public void run() {
                        CurrentStats.setYourScore.setText(NumberFormatter.changeScoreToString(CurrentStats.yourScore));
                        pacmanGame.game.gameWindow.currentStats.compareYourAndHighScore();
                    }
                });
            }
            setValueAt(pustePole, getPlayerX(), getPlayerY());
            setValueAt(pacman, getPlayerX(), Y);
        }
    }

    private boolean isWall(int playerX, int playerY) {
        return map[playerX][playerY] <= 15;
    }

}
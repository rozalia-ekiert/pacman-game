package model.map;

import model.NumberFormatter;
import model.characters.Enemy;
import model.characters.Player;
import model.game.TimeThread;
import views.PACMANGame;
import views.game.Game;
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
    public static int cookiesCounter;
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

    boolean isThisNewMap = false;

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
            map = MapGenerator.generateMap(MapModel.rows, MapModel.columns);
            setValueAt(pacman, rows - rows / 4, columns / 2);
            isThisNewMap = true;
            pacmanGame.repaint();
            Gameplay.message.setText(Gameplay.messageCookiesEaten);
            messageTimer.start();
        }
    }

    private synchronized void eatenByGhosts() {
        CurrentStats.livesNumber--;
        setValueAt(pacman, rows - rows / 4, columns / 2);

        Gameplay.message.setText(Gameplay.messageEatenByGhosts);
        messageTimer.start();

        removeLife();

        if (CurrentStats.livesNumber == 0) {
            CardLayout cl = (CardLayout) (PACMANGame.game.gameCardPanel.getLayout());
            cl.show(PACMANGame.game.gameCardPanel, GameCardPanel.GAME_OVER);
            GameCardPanel.currentCardName = GameCardPanel.GAME_OVER;

            CurrentStats.timeThread.interrupt();
            TimeThread.isGameViewReady = false;

            CurrentStats.livesNumber = 5;
            CurrentStats.yourScore = 0;
        }
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
        playerY = columnIndex;
        playerX = rowIndex;
    }


    public int getPlayerX() {
        return playerX;
    }

    public void setPlayerXUstawKolumne(int X) {

        if (getValueAt(X, getPlayerY()).equals(blue) || getValueAt(X, getPlayerY()).equals(pink) || getValueAt(X, getPlayerY()).equals(green) || getValueAt(X, getPlayerY()).equals(purple)) {
            setValueAt(pustePole, getPlayerX(), getPlayerY());
            eatenByGhosts();
            return;
        }

        if (isWall(X, getPlayerY())) return;
        if (getValueAt(X, getPlayerY()).equals(cookieSmall) || getValueAt(X, getPlayerY()).equals(cookieBig)) {
            if (getValueAt(X, getPlayerY()).equals(cookieSmall)) CurrentStats.yourScore += 10;
            if (getValueAt(X, getPlayerY()).equals(cookieBig)) CurrentStats.yourScore += 50;
            eatCookie();
            CurrentStats.setYourScore.setText(NumberFormatter.changeScoreToString(CurrentStats.yourScore));
            Game.gameWindow.currentStats.compareYourAndHighScore();
            if (isThisNewMap) {
                isThisNewMap = false;
                return;
            }
        }
        setValueAt(pustePole, getPlayerX(), getPlayerY());
        setValueAt(pacman, X, getPlayerY());

    }

    public int getPlayerY() {
        return playerY;
    }

    public void setPlayerYUstawRzad(int Y) {
        if (getValueAt(getPlayerX(), Y).equals(blue) || getValueAt(getPlayerX(), Y).equals(pink) || getValueAt(getPlayerX(), Y).equals(purple) || getValueAt(getPlayerX(), Y).equals(green)) {
            setValueAt(pustePole, getPlayerX(), getPlayerY());
            eatenByGhosts();
            return;
        }
        if (isWall(getPlayerX(), Y)) return;
        if (getValueAt(getPlayerX(), Y).equals(cookieSmall) || getValueAt(getPlayerX(), Y).equals(cookieBig)) {
            if (getValueAt(getPlayerX(), Y).equals(cookieSmall)) CurrentStats.yourScore += 10;
            if (getValueAt(getPlayerX(), Y).equals(cookieBig)) CurrentStats.yourScore += 50;
            eatCookie();
            CurrentStats.setYourScore.setText(NumberFormatter.changeScoreToString(CurrentStats.yourScore));
            Game.gameWindow.currentStats.compareYourAndHighScore();
            if (isThisNewMap) {
                isThisNewMap = false;
                return;
            }
        }
        setValueAt(pustePole, getPlayerX(), getPlayerY());
        setValueAt(pacman, getPlayerX(), Y);
    }

    private boolean isWall(int playerX, int playerY) {
        return map[playerX][playerY] <= 15;
    }

}
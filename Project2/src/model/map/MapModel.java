package model.map;

import model.characters.Enemy;
import model.characters.Player;
import views.PACMANGame;
import views.game.components.panels.gameWindow.Gameplay;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;

public class MapModel extends AbstractTableModel {

    public static int rows;
    public static int columns;
    public static int cookiesCounter;
    public static Player player;
    public static ArrayList<Enemy> enemies = new ArrayList<>();

    public PACMANGame pacmanGame;
    public int[][] map;

    int pacman = 22;

    public static boolean isThisNewMap = false;

    public static Timer messageTimer = new Timer(3000, e -> {
        Gameplay.message.setText(Gameplay.messageDefault);
    });


    public MapModel(int rows, int columns, PACMANGame pacmanGame) {
        super();
        MapModel.rows = rows;
        MapModel.columns = columns;
        this.pacmanGame = pacmanGame;

        this.map = MapGenerator.generateMap();
        player = new Player(this);
        setValueAt(pacman, rows - rows / 4, columns / 2);

        showModel();
    }

    private void showModel() { // do debuggingu
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
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
        player.setCurrentColumn(columnIndex);
        player.setCurrentRow(rowIndex);
    }
}
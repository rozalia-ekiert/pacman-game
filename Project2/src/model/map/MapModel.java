package model.map;

import model.characters.Enemy;
import model.characters.Player;

import javax.swing.table.AbstractTableModel;
import java.util.Arrays;
import java.util.Objects;

public class MapModel extends AbstractTableModel {

    int rows;
    int columns;
    private final int[][] map;

    public static Player player = new Player();
    public static Enemy blueEnemy = new Enemy();
    public static Enemy pinkEnemy = new Enemy();
    public static Enemy greenEnemy = new Enemy();
    public static Enemy purpleEnemy = new Enemy();

    int playerX;
    int playerY;

    int droga = 0;
    int sciana = 1;
    int resprawn = 0;
    int pacman = 3;
    int blue = 4;
    int purple = 5;
    int green = 6;
    int pink = 7;


    public MapModel(int rows, int columns) {
        super();
        this.rows = rows;
        this.columns = columns;

        //=============================================================================
        this.map = generateMap(rows, columns);
//        setPlayerLocation(rows-rows/4, columns/2);
        setValueAt(pacman, rows - rows / 4, columns / 2);

        showModel();
    }


    public int[][] generateMap(int rows, int columns) {
        int[][] map = new int[rows][columns];

        //uzupełniam wszystkie pola
        for (int i = 0; i < rows; i++) {
            Arrays.fill(map[i], 9);
        }

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {

                if (map[i][j] != 9) continue;

                //generowanie brzegów
                if (i == 0 || i == rows - 1 || j == 0 || j == columns - 1) {
                    if (i == rows / 2 && j == 0 || i == rows / 2 && j == columns - 1) { // przejscie w polowie drogi
                        map[i][j] = droga;
                    } else {
                        map[i][j] = sciana;
                    }
                    continue;
                }

                // generowanie miejsca respawnu duszków
                if ((columns % 2) == 0) { //dla parzystej ilosci kolumn
                    if (i == rows / 2 && j == columns / 2) {
                        map[i][j] = blue;
                        map[i][j - 1] = purple;
                        map[i][j - 2] = green;
                        map[i][j + 1] = pink;

                        map[i - 1][j - 2] = sciana;
                        map[i - 1][j - 3] = sciana;
                        map[i - 1][j + 1] = sciana;
                        map[i - 1][j + 2] = sciana;

                        map[i][j - 3] = sciana;
                        map[i][j + 2] = sciana;

                        map[i + 1][j - 3] = sciana;
                        map[i + 1][j - 2] = sciana;
                        map[i + 1][j - 1] = sciana;
                        map[i + 1][j] = sciana;
                        map[i + 1][j + 1] = sciana;
                        map[i + 1][j + 2] = sciana;
                    }
                } else { // dla nieparzystej ilośći kolumn
                    if (i == rows / 2 && j == columns / 2 - 1) {
                        map[i][j] = blue;
                        map[i][j + 1] = purple;
                        map[i][j + 2] = green;
                        map[i - 2][j + 1] = pink;

                        map[i - 1][j - 1] = sciana;
                        map[i - 1][j] = sciana;
                        map[i - 1][j + 2] = sciana;
                        map[i - 1][j + 3] = sciana;

                        map[i][j - 1] = sciana;
                        map[i][j + 3] = sciana;

                        map[i + 1][j - 1] = sciana;
                        map[i + 1][j] = sciana;
                        map[i + 1][j + 1] = sciana;
                        map[i + 1][j + 2] = sciana;
                        map[i + 1][j + 3] = sciana;
                    }
                    continue;
                }

                map[i][j] = droga;
            }
        }
        return map;
    }

    public void showModel() {
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
        this.playerY = columnIndex;
        this.playerX = rowIndex;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MapModel mapModel = (MapModel) o;
        return rows == mapModel.rows && columns == mapModel.columns;
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(rows, columns);
        result = 31 * result + Arrays.hashCode(map);
        return result;
    }


    public int getPlayerX() {
        return playerX;
    }

    public void setPlayerXUstawKolumne(int playerX) {
        setValueAt(0, getPlayerX(), getPlayerY());
        setValueAt(3, playerX, getPlayerY());
    }

    public int getPlayerY() {
        return playerY;
    }

    public void setPlayerYUstawRzad(int playerY) {
        setValueAt(0, getPlayerX(), getPlayerY());
        setValueAt(3, getPlayerX(), playerY);
    }

}
package model.map;

import views.GameColors;

import javax.swing.table.AbstractTableModel;
import java.awt.*;

public class MapModel extends AbstractTableModel {

    int rows;
    int columns;
    private int[][] map;


    public MapModel(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;

        int droga = 0;
        int sciana = 1;
        int resprawn = 2;

        //=============================================================================
        map = new int[rows][columns];

        //uzupełniam wszystkie pola
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                map[i][j] = 9;
            }
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
                    if (i == rows / 2 && j == columns / 2 || i == rows / 2 && j == columns / 2 - 1) {
                        map[i][j] = resprawn;
                        map[i][j - 1] = resprawn;
                        map[i][j + 1] = resprawn;
                        map[i][j + 2] = resprawn;

                        map[i - 1][j - 2] = sciana;
                        map[i - 1][j - 1] = sciana;
                        map[i - 1][j + 2] = sciana;
                        map[i - 1][j + 3] = sciana;

                        map[i][j - 2] = sciana;
                        map[i][j + 3] = sciana;

                        map[i + 1][j - 2] = sciana;
                        map[i + 1][j - 1] = sciana;
                        map[i + 1][j] = sciana;
                        map[i + 1][j + 1] = sciana;
                        map[i + 1][j + 2] = sciana;
                        map[i + 1][j + 3] = sciana;
                    }
                } else { // dla nieparzystej ilośći kolumn
                    if (i == rows / 2 && j == columns / 2 - 1) {
                        map[i][j] = resprawn;
                        map[i][j + 1] = resprawn;
                        map[i][j + 2] = resprawn;

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

//                tab[i][j] = droga;
            }
        }

    }

    // todo renderer
    public void drawMap(Graphics g, int cellSize) {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (this.getValueAt(i, j).equals(0) || this.getValueAt(i, j).equals(2)) continue;

                if (this.getValueAt(i, j).equals(1)) {

                    int x = j * cellSize + cellSize / 2;
                    int y = i * cellSize + cellSize / 2;

                    g.setColor(GameColors.blue);
                    g.fillOval(x - cellSize / 2, y - cellSize / 2, cellSize, cellSize);
                }
            }
        }
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
}

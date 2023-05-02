package model.Map;

import views.GameColors;

import javax.swing.table.AbstractTableModel;
import java.awt.*;

public class MapModel extends AbstractTableModel {

    int rows, columns;
    private int[][] map;


    public MapModel(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;

        int droga = 0;
        int sciana = 1;
        int resprawn = 2;

        //=============================================================================
        map = new int[rows][columns];

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

                //generowanie miejsca respawnu duszków
                if ((columns % 2) == 0) {
                    if (i == rows / 2 && j == columns / 2 || i == rows / 2 && j == columns / 2 - 1) {
                        map[i][j] = resprawn;
                        continue;
                    }
                } else { // dla nieparzystej ilośći kolumn
                    if (i == rows / 2 && j == columns / 2 - 1 || i == rows / 2 && j == columns / 2 || i == rows / 2 && j == columns / 2 + 1) {
                        map[i][j] = resprawn;
                        continue;
                    }
                }
//                tab[i][j] = droga;
            }
        }

    }

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

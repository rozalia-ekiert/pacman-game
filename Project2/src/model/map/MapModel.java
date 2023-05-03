package model.map;

import javax.swing.table.AbstractTableModel;
import java.util.Arrays;

public class MapModel extends AbstractTableModel {

    int rows;

    int columns;
    private final int[][] map;
//    Player player = new Player();


    public MapModel(int rows, int columns) {
        super();
        this.rows = rows;
        this.columns = columns;

        int droga = 0;
        int sciana = 1;
        int resprawn = 2;
//        int pacman = 3;

        //=============================================================================
        map = new int[rows][columns];

        //uzupełniam wszystkie pola
        for (int i = 0; i < rows; i++) {
            Arrays.fill(map[i], 9);
        }

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {

//                if (i == rows - rows / 4 && j == columns / 2) map[i][j] = pacman;

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

                map[i][j] = droga;
            }
        }

    }

//    public void drawMap(Graphics g, int cellSize, ImageObserver imageObserver) {
//        for (int i = 0; i < rows; i++) {
//            for (int j = 0; j < columns; j++) {
//                if (this.getValueAt(i, j).equals(0) || this.getValueAt(i, j).equals(2)) continue;
//
////                if (this.getValueAt(i, j).equals(3)) {
////                    int x = j * cellSize + cellSize / 2;
////                    int y = i * cellSize + cellSize / 2;
////                    setPacCurrentY(x);
////                    setPacCurrentX(y);
////
////                    this.player.drawPlayer(g, cellSize, imageObserver, getPacCurrentX() - cellSize / 2, getPacCurrentY() - cellSize / 2);
////                }
//
//                if (this.getValueAt(i, j).equals(1)) {
//
//                    int x = j * cellSize + cellSize / 2;
//                    int y = i * cellSize + cellSize / 2;
//
//                    g.setColor(Color.BLUE);
//                    g.fillOval(x - cellSize / 2, y - cellSize / 2, cellSize, cellSize);
//                }
//            }
//        }
//    }

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
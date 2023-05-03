package model.map;

import model.characters.Player;

import javax.swing.*;

public class MapTable extends JTable {

    Player player;
    int rows;
    int columns;


    public MapTable(MapModel model) {
        super(model);
        this.setTableHeader(null);
//        TableCellRenderer renderer = new WallRenderer();
//        map.setDefaultRenderer(Object.class, renderer);

        player = new Player();

    }

//    public void drawMap(Graphics g, int cellSize, ImageObserver imageObserver, int rows, int columns) {
//        for (int i = 0; i < rows; i++) {
//            for (int j = 0; j < columns; j++) {
//                if (this.dataModel.getValueAt(i, j).equals(0) || this.dataModel.getValueAt(i, j).equals(2)) continue;
//
//                if (this.getValueAt(i, j).equals(3)) {
//                    int x = j * cellSize + cellSize / 2;
//                    int y = i * cellSize + cellSize / 2;
////                    setPacCurrentY(x);
////                    setPacCurrentX(y);
//
//                    this.player.drawPlayer(g, cellSize, imageObserver, x - cellSize / 2, y - cellSize / 2);
//                }
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

}

package model.map;

import views.game.components.panels.gameWindow.GameplayMap;

import javax.swing.*;
import javax.swing.table.TableCellRenderer;
import java.awt.*;

public class WallRenderer implements TableCellRenderer {
    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {

        if (value.equals(1)) {
            int cellSize = GameplayMap.cellSize;
            int x = row * cellSize + cellSize / 2;
            int y = column * cellSize + cellSize / 2;

//            drawWall();
//            g.setColor(Color.BLUE);
//            g.fillOval(x - cellSize / 2, y - cellSize / 2, cellSize, cellSize);
        }
//        return this;
        return null;
    }


}

package model.map;

import views.game.components.panels.gameWindow.GameplayMap;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.*;

public class WallRenderer extends DefaultTableCellRenderer {
    public WallRenderer() {
        super();
    }

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        int cellSize = GameplayMap.cellSize;
        int x = row * cellSize + cellSize / 2;
        int y = column * cellSize + cellSize / 2;

        JComponent component = new JComponent() {
            @Override
            public void paint(Graphics g) {
                super.paint(g);
                g.setColor(Color.BLUE);
                g.fillOval(0, 0, cellSize, cellSize);
            }
        };
        return component;
    }


}

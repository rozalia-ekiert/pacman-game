package views.game.components.panels.gameWindow;

import model.map.MapModel;
import model.map.WallRenderer;

import javax.swing.*;
import javax.swing.table.TableColumn;
import java.awt.*;

public class GameplayMap extends JPanel {

    public static int cellSize;
    int rows = 15;
    int columns = 15;
    int windowSize;
    MapModel mapModel;


    public GameplayMap(int sqWidth, int sqHeight) {
        super(new GridLayout(1, 0));
        this.windowSize = sqWidth;
        setCellSize();

        this.setBackground(Color.BLACK);

        this.mapModel = new MapModel(rows, columns);
        JTable table = new JTable(this.mapModel);

        table.setFillsViewportHeight(true);
        table.setDefaultRenderer(Integer.class, new WallRenderer());
        table.setRowHeight(GameplayMap.cellSize);
        table.setBackground(Color.BLACK);
        setTableColumnWidth(table, GameplayMap.cellSize);

        table.setShowGrid(false);
        table.setShowVerticalLines(false);
        table.setShowHorizontalLines(false);

        add(table);

//        this.addKeyListener(new PacmanMovement(mapModel.pacCurrentX, mapModel.pacCurrentY, this.mapTable));
    }

    private void setTableColumnWidth(JTable table, int width) {
        for (int i = 0; i < table.getColumnModel().getColumnCount(); i++) {
            TableColumn column = table.getColumnModel().getColumn(i);
            column.setPreferredWidth(width);
            column.setMaxWidth(width);
        }
    }

    private int setCellSize() {
        if (columns <= rows) {
            cellSize = (windowSize / this.rows);
            return cellSize;
        }
        cellSize = (windowSize) / this.columns;
        return cellSize;
    }

}
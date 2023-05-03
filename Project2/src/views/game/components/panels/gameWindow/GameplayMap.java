package views.game.components.panels.gameWindow;

import model.map.MapModel;
import model.map.MapTable;

import javax.swing.*;
import java.awt.*;

public class GameplayMap extends JPanel {

    public static int cellSize;
    int rows = 30;
    int columns = 31;
    int windowSize;
    MapTable mapTable;
    MapModel mapModel;


    public GameplayMap(int sqWidth, int sqHeight) {
        super(new GridLayout(1, 0));
        this.windowSize = sqWidth;
        setCellSize();

        this.setBackground(Color.BLACK);
        this.setSize(new Dimension(sqWidth, sqHeight));

        this.mapModel = new MapModel(rows, columns);
        JTable table = new JTable(this.mapModel);
        table.setFillsViewportHeight(true);
        add(table);


//        this.addKeyListener(new PacmanMovement(mapModel.pacCurrentX, mapModel.pacCurrentY, this.mapTable));
    }

    private int setCellSize() {
        if (columns <= rows) {
            cellSize = windowSize / this.rows;
            return cellSize;
        } else {
            cellSize = windowSize / this.columns;
            return cellSize;
        }
    }

}
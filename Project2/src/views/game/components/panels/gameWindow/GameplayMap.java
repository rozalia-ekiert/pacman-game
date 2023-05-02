package views.game.components.panels.gameWindow;

import controllers.game.PacmanMovement;
import model.map.MapModel;
import model.map.MapTable;

import javax.swing.*;
import java.awt.*;

public class GameplayMap extends JPanel {

    public int cellSize; // = setCellSize();
    int rows = 30;
    int columns = 31;
    int windowSize;
    MapTable mapTable;
    MapModel mapModel = MapTable.mapModel;


    public GameplayMap(int sqWidth, int sqHeight) {
        this.windowSize = sqWidth;
        setCellSize();

        this.setBackground(Color.BLACK);
        this.setPreferredSize(new Dimension(sqWidth, sqHeight));
        this.setLayout(null);

        this.mapModel = new MapModel(rows, columns);
        this.mapTable = new MapTable(rows, columns, this.mapModel);

        this.setFocusable(true);
        this.addKeyListener(new PacmanMovement(mapModel.pacCurrentX, mapModel.pacCurrentY));
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

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        this.mapModel.drawMap(g, cellSize, this);

    }

}
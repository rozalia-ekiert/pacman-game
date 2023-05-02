package views.game.components.panels.gameWindow;

import model.map.MapModel;
import model.map.MapTable;

import javax.swing.*;
import java.awt.*;

public class GameplayMap extends JPanel {

    int rows = 30;
    int columns = 31;
    MapTable mapTable;
    MapModel mapModel;


    public GameplayMap(int sqWidth, int sqHeight) {
        this.setBackground(Color.BLACK);
        this.setPreferredSize(new Dimension(sqWidth, sqHeight));

        this.mapModel = new MapModel(rows, columns);
        this.mapTable = new MapTable(rows, columns, this.mapModel);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        int cellSize = 0;
        if (columns <= rows) {
            cellSize = getWidth() / rows;
        } else {
            cellSize = getHeight() / columns;
        }

        this.mapModel.drawMap(g, cellSize);
    }

}
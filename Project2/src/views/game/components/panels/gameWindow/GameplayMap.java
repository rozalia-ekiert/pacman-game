package views.game.components.panels.gameWindow;

import controllers.game.KeyMovement;
import model.map.MapComponentsRenderer;
import model.map.MapModel;

import javax.swing.*;
import javax.swing.table.TableColumn;
import java.awt.*;
import java.awt.event.KeyListener;

public class GameplayMap extends JPanel {

    public static int cellSize;
    public JTable mapTable;
    int rows = 26;
    int windowSize;
    MapModel mapModel;
    int columns = 27;


    public GameplayMap(int sqWidth, int sqHeight) {


        this.windowSize = sqWidth;
        this.setPreferredSize(new Dimension(sqWidth, sqHeight));
        this.setLayout(new GridBagLayout());
        this.setBackground(Color.BLACK);

        setCellSize();

        //=========================================================================

        this.mapModel = new MapModel(rows, columns);
        mapTable = new JTable(this.mapModel);

        mapTable.setFillsViewportHeight(true);
        mapTable.setDefaultRenderer(Integer.class, new MapComponentsRenderer());
        mapTable.setRowHeight(GameplayMap.cellSize);
        mapTable.setBackground(Color.BLACK);
        setTableColumnWidth(mapTable, GameplayMap.cellSize);

        mapTable.setShowGrid(false);
        mapTable.setShowVerticalLines(false);
        mapTable.setShowHorizontalLines(false);

        GridBagConstraints gbc = new GridBagConstraints();

        gbc.fill = GridBagConstraints.NONE;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        this.add(mapTable, gbc);

        //=========================================================================

        KeyListener keyListener = new KeyMovement(mapTable, mapModel);
        mapTable.addKeyListener(keyListener);

        mapTable.setFocusable(true);
        mapTable.requestFocusInWindow();

        //=========================================================================
    }

    private void setTableColumnWidth(JTable table, int width) {
        for (int i = 0; i < table.getColumnModel().getColumnCount(); i++) {
            TableColumn column = table.getColumnModel().getColumn(i);
            column.setPreferredWidth(width);
        }
    }

    private void setCellSize() {
        if (columns <= rows) {
            cellSize = (windowSize / this.rows);
            return;
        }
        cellSize = (windowSize) / this.columns;
    }

}
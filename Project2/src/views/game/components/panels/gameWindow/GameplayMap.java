package views.game.components.panels.gameWindow;

import controllers.game.PacKeyMovement;
import model.map.MapComponentsRenderer;
import model.map.MapModel;
import views.GameColors;
import views.PACMANGame;

import javax.swing.*;
import javax.swing.table.TableColumn;
import java.awt.*;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyListener;

import static model.map.MapModel.columns;
import static model.map.MapModel.rows;

public class GameplayMap extends JPanel {

    public MapModel mapModel;

    public static JTable mapTable;
    public static int windowSize;
    public Dimension dimension;


    public GameplayMap(int sqWidth, int sqHeight, PACMANGame pacmanGame, int setRows, int setColumns) {
        this.setBorder(BorderFactory.createMatteBorder(3, 3, 3, 3, GameColors.pink));


        windowSize = sqWidth;
        this.dimension = new Dimension(windowSize, windowSize);
        this.setLayout(new GridBagLayout());
        this.setBackground(Color.BLACK);
        //=========================================================================

        this.mapModel = new MapModel(setRows, setColumns, pacmanGame);
        mapTable = new JTable(this.mapModel);

        mapTable.setFillsViewportHeight(false);
        mapTable.setDefaultRenderer(Integer.class, new MapComponentsRenderer());
        mapTable.setBackground(Color.BLACK);
        mapTable.setShowGrid(false);
        mapTable.setShowVerticalLines(false);
        mapTable.setShowHorizontalLines(false);
        mapTable.setCellSelectionEnabled(false);
        mapTable.setRowHeight(getCellSize());
        mapTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        setTableColumnWidth(mapTable, getCellSize());
        this.add(mapTable);

        //=========================================================================

        KeyListener keyListener = new PacKeyMovement(mapTable, mapModel, pacmanGame);
        mapTable.addKeyListener(keyListener);


//        mapTable.grabFocus();
//        mapTable.requestFocusInWindow();
//        SwingUtilities.invokeLater((()-> mapTable.grabFocus()));

        mapTable.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                super.focusGained(e);
                mapTable.requestFocusInWindow();
            }
        });

//        if (!mapTable.hasFocus()) {
//            if (!mapTable.isRequestFocusEnabled()) {
//                mapTable.setRequestFocusEnabled(true);
//            }
//            mapTable.requestFocus();
//        }

        //=========================================================================
    }

    public static void setTableColumnWidth(JTable table, int width) {
        for (int i = 0; i < table.getColumnModel().getColumnCount(); i++) {
            TableColumn column = table.getColumnModel().getColumn(i);
            column.setMaxWidth(width);
            column.setMinWidth(width);
        }
    }

    public static int getCellSize() {
        if (columns <= rows) {
            return (windowSize / rows);
        }
        return (windowSize) / columns;
    }
}
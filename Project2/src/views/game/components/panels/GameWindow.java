package views.game.components.panels;

import views.PACMANGame;
import views.game.components.panels.gameWindow.Comments;
import views.game.components.panels.gameWindow.CurrentStats;
import views.game.components.panels.gameWindow.Gameplay;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

import static model.map.MapModel.columns;
import static model.map.MapModel.rows;
import static views.game.components.panels.gameWindow.GameplayMap.*;

public class GameWindow extends JPanel {

    public Gameplay gameplay;
    public CurrentStats currentStats;

    public GameWindow(int width, int height, PACMANGame pacmanGame, int setRows, int setColumns) {
        this.setBackground(Color.BLACK);
        this.setFocusable(true);

        currentStats = new CurrentStats((int) (width * 0.2), height, pacmanGame);
        gameplay = new Gameplay((int) (width * 0.6), height, pacmanGame, setRows, setColumns);
        Comments comments = new Comments((int) (width * 0.2), height, pacmanGame);

        this.setLayout(new BoxLayout(this, 0));

        //=======================================================

        this.add(currentStats);
        gameplay.setBorder(BorderFactory.createMatteBorder(0, 3, 0, 3, Color.WHITE));
        this.add(gameplay);
        this.add(comments);

        Gameplay.map.mapTable.requestFocus();

        this.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                super.componentResized(e);

                currentStats.setSize(new Dimension((int) (getSize().width * 0.2), getSize().height));
                comments.setSize(new Dimension((int) (getSize().width * 0.2), getSize().height));

                Dimension size = new Dimension(getSize().width - currentStats.getSize().width - currentStats.getSize().width, getSize().height);
                if (size.width > size.height) {
                    windowSize = size.height;
                } else {
                    windowSize = size.width;
                }
                int cellSize = getCellSize();
                System.out.println("getCellSize: " + cellSize + " size: " + size);
                mapTable.setRowHeight(cellSize);
                setTableColumnWidth(mapTable, cellSize);

                Gameplay.map.mapTable.setMinimumSize(new Dimension((int) (cellSize * columns), cellSize * rows));
                Gameplay.map.mapTable.setSize(new Dimension(cellSize * columns, cellSize * rows));
                Gameplay.map.mapTable.setMaximumSize(new Dimension(cellSize * columns, cellSize * rows));
            }
        });
    }
}
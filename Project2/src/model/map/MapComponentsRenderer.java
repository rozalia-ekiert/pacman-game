package model.map;

import model.DrawableObjects;
import views.game.components.panels.gameWindow.CurrentStats;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.*;
import java.io.File;
import java.io.IOException;

import static views.game.components.panels.gameWindow.GameplayMap.getCellSize;

public class MapComponentsRenderer extends DefaultTableCellRenderer {

    {
        try {
            DrawableObjects.addDrawable(21, new Wall(ImageIO.read(new File("assets/cookies/cookie_small.png"))));
            DrawableObjects.addDrawable(20, new Wall(ImageIO.read(new File("assets/cookies/cookie_big.png"))));
            DrawableObjects.addDrawable(16, new Wall(ImageIO.read(new File("assets/gate.png"))));

            File dir = new File("assets/walls");
            File[] directoryListing = dir.listFiles();
            for (File file : directoryListing) {
                int wallCode = Integer.parseInt(file.getName().replace("a.png", ""));
                DrawableObjects.addDrawable(wallCode, new Wall(ImageIO.read(file)));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public MapComponentsRenderer() {
        super();
    }

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        if (table.getValueAt(row, column).equals(18) || table.getValueAt(row, column).equals(19)) return this;
        int cellSize = getCellSize();

        if (table.getValueAt(row, column).equals(33)) { // tabela z życiami
            return new JComponent() {
                @Override
                public void paint(Graphics g) {
                    super.paint(g);
                    int currentCellSize = CurrentStats.lifeCellSize;
                    g.drawImage(getImagebasedOnCellValue(22), 0, 0, (int) (currentCellSize * 0.8), (int) (currentCellSize * 0.8), this);
                }
            };
        }

        return new JComponent() {
            @Override
            public void paint(Graphics g) {
                super.paint(g);
                g.drawImage(getImagebasedOnCellValue((Integer) table.getValueAt(row, column)), 0, 0, cellSize, cellSize, null);
            }
        };

    }

    private Image getImagebasedOnCellValue(int valueAt) {
        try {
            return DrawableObjects.getDrawable(valueAt).getImage();
        } catch (Exception e) {
            System.out.println("nie znaleziono obrazka dla: " + valueAt);
        }
        return null;
    }
}
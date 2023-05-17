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
            DrawableObjects.addDrawable(38, new Wall(ImageIO.read(new File("assets/enemies_icons/dark_blue/enemy_1.png"))));
            DrawableObjects.addDrawable(39, new Wall(ImageIO.read(new File("assets/enemies_icons/dark_blue/enemy_2.png"))));


            DrawableObjects.addDrawable(222, new Wall(ImageIO.read(new File("assets/pacman_icons/pac_caly.png"))));
            //pac up
            DrawableObjects.addDrawable(220, new Wall(ImageIO.read(new File("assets/pacman_icons/pac_up/pac_caly_up.png"))));
            DrawableObjects.addDrawable(230, new Wall(ImageIO.read(new File("assets/pacman_icons/pac_up/pac_sredni_up.png"))));
            DrawableObjects.addDrawable(240, new Wall(ImageIO.read(new File("assets/pacman_icons/pac_up/pac_otwarty_up.png"))));
            //pac down
            DrawableObjects.addDrawable(221, new Wall(ImageIO.read(new File("assets/pacman_icons/pac_down/pac_caly_down.png"))));
            DrawableObjects.addDrawable(231, new Wall(ImageIO.read(new File("assets/pacman_icons/pac_down/pac_sredni_down.png"))));
            DrawableObjects.addDrawable(241, new Wall(ImageIO.read(new File("assets/pacman_icons/pac_down/pac_otwarty_down.png"))));
            //pac right
            DrawableObjects.addDrawable(232, new Wall(ImageIO.read(new File("assets/pacman_icons/pac_right/pac_sredni.png"))));
            DrawableObjects.addDrawable(242, new Wall(ImageIO.read(new File("assets/pacman_icons/pac_right/pac_otwarty.png"))));
            //pac left
            DrawableObjects.addDrawable(223, new Wall(ImageIO.read(new File("assets/pacman_icons/pac_caly.png"))));
            DrawableObjects.addDrawable(233, new Wall(ImageIO.read(new File("assets/pacman_icons/pac_left/pac_sredni_left.png"))));
            DrawableObjects.addDrawable(243, new Wall(ImageIO.read(new File("assets/pacman_icons/pac_left/pac_otwarty_left.png"))));

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
                    g.drawImage(getImagebasedOnCellValue(232), 0, 0, (int) (currentCellSize * 0.8), (int) (currentCellSize * 0.8), this);
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
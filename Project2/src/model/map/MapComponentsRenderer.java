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

            //pac up
            DrawableObjects.addDrawable(220, new Wall(ImageIO.read(new File("assets/pacman_icons/pac_up/pac_caly_up.png"))));
            DrawableObjects.addDrawable(230, new Wall(ImageIO.read(new File("assets/pacman_icons/pac_up/pac_sredni_up.png"))));
            DrawableObjects.addDrawable(240, new Wall(ImageIO.read(new File("assets/pacman_icons/pac_up/pac_otwarty_up.png"))));
            //pac down
            DrawableObjects.addDrawable(221, new Wall(ImageIO.read(new File("assets/pacman_icons/pac_down/pac_caly_down.png"))));
            DrawableObjects.addDrawable(231, new Wall(ImageIO.read(new File("assets/pacman_icons/pac_down/pac_sredni_down.png"))));
            DrawableObjects.addDrawable(241, new Wall(ImageIO.read(new File("assets/pacman_icons/pac_down/pac_otwarty_down.png"))));
            //pac right
            DrawableObjects.addDrawable(222, new Wall(ImageIO.read(new File("assets/pacman_icons/pac_caly.png"))));
            DrawableObjects.addDrawable(232, new Wall(ImageIO.read(new File("assets/pacman_icons/pac_right/pac_sredni.png"))));
            DrawableObjects.addDrawable(242, new Wall(ImageIO.read(new File("assets/pacman_icons/pac_right/pac_otwarty.png"))));
            //pac left
            DrawableObjects.addDrawable(223, new Wall(ImageIO.read(new File("assets/pacman_icons/pac_caly.png"))));
            DrawableObjects.addDrawable(233, new Wall(ImageIO.read(new File("assets/pacman_icons/pac_left/pac_sredni_left.png"))));
            DrawableObjects.addDrawable(243, new Wall(ImageIO.read(new File("assets/pacman_icons/pac_left/pac_otwarty_left.png"))));

            //ghosts

            //blue - left
            DrawableObjects.addDrawable(4211, new Wall(ImageIO.read(new File("assets/enemies_icons/blue/blue_1_left.png"))));
            DrawableObjects.addDrawable(4212, new Wall(ImageIO.read(new File("assets/enemies_icons/blue/blue_2_left.png"))));
            //blue - right
            DrawableObjects.addDrawable(4221, new Wall(ImageIO.read(new File("assets/enemies_icons/blue/blue_1_right.png"))));
            DrawableObjects.addDrawable(4222, new Wall(ImageIO.read(new File("assets/enemies_icons/blue/blue_2_right.png"))));
            //blue - straight
            DrawableObjects.addDrawable(4231, new Wall(ImageIO.read(new File("assets/enemies_icons/blue/blue_1_straight.png"))));
            DrawableObjects.addDrawable(4232, new Wall(ImageIO.read(new File("assets/enemies_icons/blue/blue_2_straight.png"))));

            //green - left
            DrawableObjects.addDrawable(4111, new Wall(ImageIO.read(new File("assets/enemies_icons/green/green_1_left.png"))));
            DrawableObjects.addDrawable(4112, new Wall(ImageIO.read(new File("assets/enemies_icons/green/green_2_left.png"))));
            //green - right
            DrawableObjects.addDrawable(4121, new Wall(ImageIO.read(new File("assets/enemies_icons/green/green_1_right.png"))));
            DrawableObjects.addDrawable(4122, new Wall(ImageIO.read(new File("assets/enemies_icons/green/green_2_right.png"))));
            //green - straight
            DrawableObjects.addDrawable(4131, new Wall(ImageIO.read(new File("assets/enemies_icons/green/green_1_straight.png"))));
            DrawableObjects.addDrawable(4132, new Wall(ImageIO.read(new File("assets/enemies_icons/green/green_2_straight.png"))));

            //pink - left
            DrawableObjects.addDrawable(4011, new Wall(ImageIO.read(new File("assets/enemies_icons/pink/pink_1_left.png"))));
            DrawableObjects.addDrawable(4012, new Wall(ImageIO.read(new File("assets/enemies_icons/pink/pink_2_left.png"))));
            //pink - right
            DrawableObjects.addDrawable(4021, new Wall(ImageIO.read(new File("assets/enemies_icons/pink/pink_1_right.png"))));
            DrawableObjects.addDrawable(4022, new Wall(ImageIO.read(new File("assets/enemies_icons/pink/pink_2_right.png"))));
            //pink - straight
            DrawableObjects.addDrawable(4031, new Wall(ImageIO.read(new File("assets/enemies_icons/pink/pink_1_straight.png"))));
            DrawableObjects.addDrawable(4032, new Wall(ImageIO.read(new File("assets/enemies_icons/pink/pink_2_straight.png"))));

            //purple - left
            DrawableObjects.addDrawable(4311, new Wall(ImageIO.read(new File("assets/enemies_icons/purple/purple_1_left.png"))));
            DrawableObjects.addDrawable(4312, new Wall(ImageIO.read(new File("assets/enemies_icons/purple/purple_2_left.png"))));
            //purple - right
            DrawableObjects.addDrawable(4321, new Wall(ImageIO.read(new File("assets/enemies_icons/purple/purple_1_right.png"))));
            DrawableObjects.addDrawable(4322, new Wall(ImageIO.read(new File("assets/enemies_icons/purple/purple_2_right.png"))));
            //purple - straight
            DrawableObjects.addDrawable(4331, new Wall(ImageIO.read(new File("assets/enemies_icons/purple/purple_1_straight.png"))));
            DrawableObjects.addDrawable(4332, new Wall(ImageIO.read(new File("assets/enemies_icons/purple/purple_2_straight.png"))));

            //food bonuses
            DrawableObjects.addDrawable(60, new Wall(ImageIO.read(new File("assets/food_bonus_icons/leaf.png"))));
            DrawableObjects.addDrawable(61, new Wall(ImageIO.read(new File("assets/food_bonus_icons/carrot.png"))));
            DrawableObjects.addDrawable(62, new Wall(ImageIO.read(new File("assets/food_bonus_icons/avocado.png"))));
            DrawableObjects.addDrawable(63, new Wall(ImageIO.read(new File("assets/food_bonus_icons/mushroom.png"))));
            DrawableObjects.addDrawable(64, new Wall(ImageIO.read(new File("assets/food_bonus_icons/pineapple.png"))));
            DrawableObjects.addDrawable(65, new Wall(ImageIO.read(new File("assets/food_bonus_icons/strawberry.png"))));
            DrawableObjects.addDrawable(66, new Wall(ImageIO.read(new File("assets/food_bonus_icons/donut.png"))));
            DrawableObjects.addDrawable(67, new Wall(ImageIO.read(new File("assets/food_bonus_icons/apple.png"))));

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
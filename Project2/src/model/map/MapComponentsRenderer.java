package model.map;

import model.DrawableObjects;
import model.characters.Player;
import views.game.components.panels.gameWindow.CurrentStats;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.*;
import java.io.File;
import java.io.IOException;

import static model.map.MapModel.enemies;
import static model.map.MapModel.player;
import static views.game.components.panels.gameWindow.GameplayMap.getCellSize;

public class MapComponentsRenderer extends DefaultTableCellRenderer {


    Image cookieSmall;
    Image cookieBig;

    //todo petla
    Image wall0;
    Image wall1;
    Image wall2;
    Image wall3;
    Image wall4;
    Image wall5;
    Image wall6;
    Image wall7;
    Image wall8;
    Image wall9;
    Image wall10;
    Image wall11;
    Image wall12;
    Image wall13;
    Image wall14;
    Image wall15;

    {
        try {
            cookieBig = ImageIO.read(new File("assets/cookies/cookie_big.png"));
            cookieSmall = ImageIO.read(new File("assets/cookies/cookie_small.png"));

            wall0 = ImageIO.read(new File("assets/walls/0a.png"));
            wall1 = ImageIO.read(new File("assets/walls/1a.png"));
            wall2 = ImageIO.read(new File("assets/walls/2a.png"));
            wall3 = ImageIO.read(new File("assets/walls/3a.png"));
            wall4 = ImageIO.read(new File("assets/walls/4a.png"));
            wall5 = ImageIO.read(new File("assets/walls/5a.png"));
            wall6 = ImageIO.read(new File("assets/walls/6a.png"));
            wall7 = ImageIO.read(new File("assets/walls/7a.png"));
            wall8 = ImageIO.read(new File("assets/walls/8a.png"));
            wall9 = ImageIO.read(new File("assets/walls/9a.png"));
            wall10 = ImageIO.read(new File("assets/walls/10a.png"));
            wall11 = ImageIO.read(new File("assets/walls/11a.png"));
            wall12 = ImageIO.read(new File("assets/walls/12a.png"));
            wall13 = ImageIO.read(new File("assets/walls/13a.png"));
            wall14 = ImageIO.read(new File("assets/walls/14a.png"));
            wall15 = ImageIO.read(new File("assets/walls/15a.png"));
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
        if (table.getValueAt(row, column).equals(0)) {
            return new JComponent() {
                @Override
                public void paint(Graphics g) {
                    super.paint(g);
                    g.setColor(Color.BLUE);
                    g.drawImage(wall0, 0, 0, cellSize, cellSize, this);
                }
            };
        }

        if (table.getValueAt(row, column).equals(1)) {
            return new JComponent() {
                @Override
                public void paint(Graphics g) {
                    super.paint(g);
                    g.drawImage(wall1, 0, 0, cellSize, cellSize, this);
                }
            };
        }

        if (table.getValueAt(row, column).equals(2)) {
            return new JComponent() {
                @Override
                public void paint(Graphics g) {
                    super.paint(g);
                    g.drawImage(wall2, 0, 0, cellSize, cellSize, this);
                }
            };
        }
        if (table.getValueAt(row, column).equals(3)) {
            return new JComponent() {
                @Override
                public void paint(Graphics g) {
                    super.paint(g);
                    g.drawImage(wall3, 0, 0, cellSize, cellSize, this);
                }
            };
        }
        if (table.getValueAt(row, column).equals(4)) {
            return new JComponent() {
                @Override
                public void paint(Graphics g) {
                    super.paint(g);
                    g.drawImage(wall4, 0, 0, cellSize, cellSize, this);
                }
            };
        }
        if (table.getValueAt(row, column).equals(5)) {
            return new JComponent() {
                @Override
                public void paint(Graphics g) {
                    super.paint(g);
                    g.drawImage(wall5, 0, 0, cellSize, cellSize, this);
                }
            };
        }
        if (table.getValueAt(row, column).equals(6)) {
            return new JComponent() {
                @Override
                public void paint(Graphics g) {
                    super.paint(g);
                    g.drawImage(wall6, 0, 0, cellSize, cellSize, this);
                }
            };
        }
        if (table.getValueAt(row, column).equals(7)) {
            return new JComponent() {
                @Override
                public void paint(Graphics g) {
                    super.paint(g);
                    g.drawImage(wall7, 0, 0, cellSize, cellSize, this);
                }
            };
        }
        if (table.getValueAt(row, column).equals(8)) {
            return new JComponent() {
                @Override
                public void paint(Graphics g) {
                    super.paint(g);
                    g.drawImage(wall8, 0, 0, cellSize, cellSize, this);
                }
            };
        }
        if (table.getValueAt(row, column).equals(9)) {
            return new JComponent() {
                @Override
                public void paint(Graphics g) {
                    super.paint(g);
                    g.drawImage(wall9, 0, 0, cellSize, cellSize, this);
                }
            };
        }
        if (table.getValueAt(row, column).equals(10)) {
            return new JComponent() {
                @Override
                public void paint(Graphics g) {
                    super.paint(g);
                    g.drawImage(wall10, 0, 0, cellSize, cellSize, this);
                }
            };
        }
        if (table.getValueAt(row, column).equals(11)) {
            return new JComponent() {
                @Override
                public void paint(Graphics g) {
                    super.paint(g);
                    g.drawImage(wall11, 0, 0, cellSize, cellSize, this);
                }
            };
        }
        if (table.getValueAt(row, column).equals(12)) {
            return new JComponent() {
                @Override
                public void paint(Graphics g) {
                    super.paint(g);
                    g.drawImage(wall12, 0, 0, cellSize, cellSize, this);
                }
            };
        }
        if (table.getValueAt(row, column).equals(13)) {
            return new JComponent() {
                @Override
                public void paint(Graphics g) {
                    super.paint(g);
                    g.drawImage(wall13, 0, 0, cellSize, cellSize, this);
                }
            };
        }
        if (table.getValueAt(row, column).equals(14)) {
            return new JComponent() {
                @Override
                public void paint(Graphics g) {
                    super.paint(g);
                    g.drawImage(wall14, 0, 0, cellSize, cellSize, this);
                }
            };
        }
        if (table.getValueAt(row, column).equals(15)) {
            return new JComponent() {
                @Override
                public void paint(Graphics g) {
                    super.paint(g);
                    g.drawImage(wall15, 0, 0, cellSize, cellSize, this);
                }
            };
        }

        if (table.getValueAt(row, column).equals(20)) {
            return new JComponent() {
                @Override
                public void paint(Graphics g) {
                    super.paint(g);
                    g.drawImage(cookieBig, 0, 0, cellSize, cellSize, this);
                }
            };
        }

        if (table.getValueAt(row, column).equals(21)) {
            return new JComponent() {
                @Override
                public void paint(Graphics g) {
                    super.paint(g);
                    g.drawImage(cookieSmall, 0, 0, cellSize, cellSize, this);
                }
            };
        }

        if (table.getValueAt(row, column).equals(22)) {
            return new JComponent() {
                @Override
                public void paint(Graphics g) {
                    super.paint(g);
                    g.drawImage(player.getPlayerImage(Player.currentState), 0, 0, (int) (cellSize * 0.9), (int) (cellSize * 0.9), this);
                }
            };
        }


        if (table.getValueAt(row, column).equals(24)) {
            return new JComponent() {
                @Override
                public void paint(Graphics g) {
                    super.paint(g);
                    g.drawImage(enemies.get(1).getImage(), 0, 0, (int) (cellSize * 0.9), (int) (cellSize * 0.9), this);
                }
            };
        }

        if (table.getValueAt(row, column).equals(25)) {
            return new JComponent() {
                @Override
                public void paint(Graphics g) {
                    super.paint(g);
                    g.drawImage(enemies.get(2).getImage(), 0, 0, (int) (cellSize * 0.9), (int) (cellSize * 0.9), this);
                }
            };
        }

        if (table.getValueAt(row, column).equals(26)) {
            return new JComponent() {
                @Override
                public void paint(Graphics g) {
                    super.paint(g);
                    g.drawImage(enemies.get(3).getImage(), 0, 0, (int) (cellSize * 0.9), (int) (cellSize * 0.9), this);
                }
            };
        }

        if (table.getValueAt(row, column).equals(33)) { // tabela z życiami
            return new JComponent() {
                @Override
                public void paint(Graphics g) {
                    super.paint(g);
                    int currentCellSize = CurrentStats.lifeCellSize;
                    g.drawImage(player.getPlayerImage(Player.currentState), 0, 0, (int) (currentCellSize * 0.9), (int) (currentCellSize * 0.9), this);
                }
            };
        }

        return new JComponent() {
            @Override
            public void paint(Graphics g) {
                super.paint(g);
                g.drawImage(getImagebasedOnCellValue((Integer) table.getValueAt(row, column)), 0, 0, (int) (cellSize * 0.9), (int) (cellSize * 0.9), null);
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
package model.map;

import model.characters.CharacterAnimationState;
import model.characters.Player;
import views.game.components.panels.gameWindow.CurrentStats;
import views.game.components.panels.gameWindow.GameplayMap;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.*;
import java.io.File;
import java.io.IOException;

import static model.map.MapModel.enemies;
import static model.map.MapModel.player;

public class MapComponentsRenderer extends DefaultTableCellRenderer {

    Image cookieSmall;

    {
        try {
            cookieSmall = ImageIO.read(new File("assets/cookies/cookie_small.png"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    Image cookieBig;

    {
        try {
            cookieBig = ImageIO.read(new File("assets/cookies/cookie_big.png"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

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
            wall0 = ImageIO.read(new File("assets/walls/0a.png"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    {
        try {
            wall1 = ImageIO.read(new File("assets/walls/1a.png"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    {
        try {
            wall2 = ImageIO.read(new File("assets/walls/2a.png"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    {
        try {
            wall3 = ImageIO.read(new File("assets/walls/3a.png"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    {
        try {
            wall4 = ImageIO.read(new File("assets/walls/4a.png"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    {
        try {
            wall5 = ImageIO.read(new File("assets/walls/5a.png"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    {
        try {
            wall6 = ImageIO.read(new File("assets/walls/6a.png"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    {
        try {
            wall7 = ImageIO.read(new File("assets/walls/7a.png"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    {
        try {
            wall8 = ImageIO.read(new File("assets/walls/8a.png"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    {
        try {
            wall9 = ImageIO.read(new File("assets/walls/9a.png"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    {
        try {
            wall10 = ImageIO.read(new File("assets/walls/10a.png"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    {
        try {
            wall11 = ImageIO.read(new File("assets/walls/11a.png"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    {
        try {
            wall12 = ImageIO.read(new File("assets/walls/12a.png"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    {
        try {
            wall13 = ImageIO.read(new File("assets/walls/13a.png"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    {
        try {
            wall14 = ImageIO.read(new File("assets/walls/14a.png"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    {
        try {
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
        int cellSize = GameplayMap.cellSize;

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

        if (table.getValueAt(row, column).equals(23)) {
            return new JComponent() {
                @Override
                public void paint(Graphics g) {
                    super.paint(g);
                    g.drawImage(enemies.get(0).getEnemyImage(CharacterAnimationState.GhostBLUE), 0, 0, (int) (cellSize * 0.9), (int) (cellSize * 0.9), this);
                }
            };
        }

        if (table.getValueAt(row, column).equals(24)) {
            return new JComponent() {
                @Override
                public void paint(Graphics g) {
                    super.paint(g);
                    g.drawImage(enemies.get(1).getEnemyImage(CharacterAnimationState.GhostPURPLE), 0, 0, (int) (cellSize * 0.9), (int) (cellSize * 0.9), this);
                }
            };
        }

        if (table.getValueAt(row, column).equals(25)) {
            return new JComponent() {
                @Override
                public void paint(Graphics g) {
                    super.paint(g);
                    g.drawImage(enemies.get(2).getEnemyImage(CharacterAnimationState.GhostGREEN), 0, 0, (int) (cellSize * 0.9), (int) (cellSize * 0.9), this);
                }
            };
        }

        if (table.getValueAt(row, column).equals(26)) {
            return new JComponent() {
                @Override
                public void paint(Graphics g) {
                    super.paint(g);
                    g.drawImage(enemies.get(3).getEnemyImage(CharacterAnimationState.GhostPINK), 0, 0, (int) (cellSize * 0.9), (int) (cellSize * 0.9), this);
                }
            };
        }

        if (table.getValueAt(row, column).equals(33)) {
            return new JComponent() {
                @Override
                public void paint(Graphics g) {
                    super.paint(g);
                    int currentCellSize = CurrentStats.lifeCellSize;
                    g.drawImage(player.getPlayerImage(Player.currentState), 0, 0, (int) (currentCellSize * 0.9), (int) (currentCellSize * 0.9), this);
                }
            };
        }

        return this;
    }
}
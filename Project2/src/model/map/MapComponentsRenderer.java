package model.map;

import model.characters.CharacterAnimationState;
import model.characters.Player;
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
    Image cookieBig;

    {
        try {
            cookieSmall = ImageIO.read(new File("assets/cookies/cookie_small.png"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    {
        try {
            cookieBig = ImageIO.read(new File("assets/cookies/cookie_big.png"));
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

        if (table.getValueAt(row, column).equals(20)) {
            JComponent component = new JComponent() {
                @Override
                public void paint(Graphics g) {
                    super.paint(g);
                    g.drawImage(cookieBig, 0, 0, cellSize, cellSize, this);
                }
            };
            return component;
        }

        if (table.getValueAt(row, column).equals(21)) {
            JComponent component = new JComponent() {
                @Override
                public void paint(Graphics g) {
                    super.paint(g);
                    g.drawImage(cookieSmall, 0, 0, cellSize, cellSize, this);
                }
            };
            return component;
        }

        if (table.getValueAt(row, column).equals(0)) {
            JComponent component = new JComponent() {
                @Override
                public void paint(Graphics g) {
                    super.paint(g);
                    g.setColor(Color.BLUE);
                    g.fillOval(0, 0, cellSize, cellSize);
                }
            };
            return component;
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

        return this;
    }


}

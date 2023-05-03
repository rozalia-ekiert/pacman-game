package model.map;

import model.characters.CharacterAnimationState;
import model.characters.Enemy;
import model.characters.Player;
import views.game.components.panels.gameWindow.GameplayMap;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.*;

import static model.map.MapModel.*;

public class MapComponentsRenderer extends DefaultTableCellRenderer {
    public MapComponentsRenderer() {
        super();
    }

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        int cellSize = GameplayMap.cellSize;

        if (table.getValueAt(row, column).equals(1)) {
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

        if (table.getValueAt(row, column).equals(3)) {
            return new JComponent() {
                @Override
                public void paint(Graphics g) {
                    super.paint(g);
                    g.drawImage(player.getPlayerImage(Player.currentState), 0, 0, (int) (cellSize * 0.9), (int) (cellSize * 0.9), this);
                }
            };
        }

        if (table.getValueAt(row, column).equals(4)) {
            return new JComponent() {
                @Override
                public void paint(Graphics g) {
                    super.paint(g);
                    g.drawImage(blueEnemy.getEnemyImage(CharacterAnimationState.GhostBLUE), 0, 0, (int) (cellSize * 0.9), (int) (cellSize * 0.9), this);
                }
            };
        }

        if (table.getValueAt(row, column).equals(5)) {
            return new JComponent() {
                @Override
                public void paint(Graphics g) {
                    super.paint(g);
                    g.drawImage(purpleEnemy.getEnemyImage(CharacterAnimationState.GhostPURPLE), 0, 0, (int) (cellSize * 0.9), (int) (cellSize * 0.9), this);
                }
            };
        }

        if (table.getValueAt(row, column).equals(6)) {
            Enemy enemy = new Enemy();
            return new JComponent() {
                @Override
                public void paint(Graphics g) {
                    super.paint(g);
                    g.drawImage(greenEnemy.getEnemyImage(CharacterAnimationState.GhostGREEN), 0, 0, (int) (cellSize * 0.9), (int) (cellSize * 0.9), this);
                }
            };
        }

        if (table.getValueAt(row, column).equals(7)) {
            Enemy enemy = new Enemy();
            return new JComponent() {
                @Override
                public void paint(Graphics g) {
                    super.paint(g);
                    g.drawImage(pinkEnemy.getEnemyImage(CharacterAnimationState.GhostPINK), 0, 0, (int) (cellSize * 0.9), (int) (cellSize * 0.9), this);
                }
            };
        }

        return this;
    }


}

package views.game.components.panels.gameWindow;

import model.Map.MapModel;
import views.PACMANGame;

import javax.swing.*;
import java.awt.*;

public class GameplayMap extends JPanel {

    int rows = 30;
    int columns = 30;
    MapModel pacmanMap;

    public GameplayMap(int sqWidth, int sqHeight, PACMANGame pacmanGame) {
        this.setBackground(Color.BLACK);
        this.setPreferredSize(new Dimension(sqWidth, sqHeight));

//        String text = "TO MOJ GAME WINDOW";
//        JTextArea textArea = new JTextArea(text, 1, 10);
//        textArea.setForeground(Color.GREEN);
//        textArea.setBackground(Color.BLUE);
//        textArea.setFont(pacmanGame.Butterbelly);
//        this.add(textArea);

        this.pacmanMap = new MapModel(rows, columns);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        int cellSize = 0;
        if (columns <= rows) {
            cellSize = getWidth() / columns;
        } else {
            cellSize = getHeight() / rows;
        }

        this.pacmanMap.drawMap(g, cellSize);

//        for (int i = 0; i < rows; i++) {
//            for (int j = 0; j < columns; j++) {
//                if (pacmanMap.getValueAt(i,j).equals(0) || pacmanMap.getValueAt(i,j).equals(2)) continue;
//
//                if (pacmanMap.getValueAt(i,j).equals(1)) {
//
//                    int x = j * cellSize + cellSize/2;
//                    int y = i * cellSize + cellSize/2;
//
//                    g.setColor(GameColors.blue);
//                    g.fillOval(x-cellSize/2, y-cellSize/2, cellSize, cellSize);
//                }
//            }
//        }
    }

}

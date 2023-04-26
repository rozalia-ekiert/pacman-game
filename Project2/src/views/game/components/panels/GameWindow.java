package views.game.components.panels;

import views.PACMANGame;

import javax.swing.*;
import java.awt.*;

public class GameWindow extends JPanel {

    public GameWindow(int width, int height, PACMANGame pacmanGame) {

        CurrentStats currentStats = new CurrentStats();
        Gameplay gameplay = new Gameplay();

        this.setPreferredSize(new Dimension(width, height));
        this.setBackground(Color.BLACK);

        this.setLayout(new GridBagLayout());


        String text = "TO MOJ GAME WINDOW";

        JTextArea textArea = new JTextArea(text, 5, 20);

        textArea.setForeground(Color.WHITE);
        textArea.setBackground(Color.BLACK);
        textArea.setFont(pacmanGame.Butterbelly);

        textArea.setEnabled(false);
        textArea.setEditable(false);

        this.add(textArea);

//        this.add(currentStats);
//        this.add(gameplay);
    }
}

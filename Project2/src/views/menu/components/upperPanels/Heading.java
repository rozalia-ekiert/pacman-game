package views.menu.components.upperPanels;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class Heading extends JPanel {

    Action newGame;
    Action highScores;
    Action exit;
    static Image heading = null;

    public Heading(int width, int height) {

        this.setPreferredSize(new Dimension(width, height));
        this.setBackground(Color.BLACK);
        this.setMinimumSize(new Dimension(330, 180));

    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);


        try {
            if (heading == null) {
                heading = ImageIO.read(new File("assets/heading.png"));
            }
        } catch (IOException e) {
            System.out.println("Nieprawidłowe zdjęcie.");
        }
        g.drawImage(heading, 0, 0, getWidth(), getHeight(), this);
    }

}

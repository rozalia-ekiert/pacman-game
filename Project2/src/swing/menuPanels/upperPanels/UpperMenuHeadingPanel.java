package swing.menuPanels.upperPanels;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class UpperMenuHeadingPanel extends JPanel {

    Action newGame;
    Action highScores;
    Action exit;

    public UpperMenuHeadingPanel(int width, int height){

        this.setPreferredSize(new Dimension(width, height));
        this.setBackground(Color.BLACK);
        this.setMinimumSize(new Dimension(330, 180));

    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        Image heading = null;
        try {
            heading = ImageIO.read(new File("assets/heading.png"));
        } catch (IOException e) {
            System.out.println("Nieprawidłowe zdjęcie.");
        }
        g.drawImage(heading, 0, 0, getWidth(), getHeight(), this);
    }

}

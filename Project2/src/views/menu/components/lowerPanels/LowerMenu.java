package views.menu.components.lowerPanels;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class LowerMenu extends JPanel {


    static Image pacmanTEST = null;
    static Image blueTEST = null;
    static Image pinkTEST = null;
    static Image greenTEST = null;
    static Image yellowTEST = null;

    public LowerMenu() {
        this.setBackground(Color.BLACK);
        this.setMinimumSize(new Dimension(330, 70));

    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        try {
            if (pacmanTEST == null) {
                pacmanTEST = ImageIO.read(new File("assets/pacman_icons/pac_right/pac_sredni.png"));
                blueTEST = ImageIO.read(new File("assets/enemies_icons/blue/blue_1_right.png"));
                pinkTEST = ImageIO.read(new File("assets/enemies_icons/pink/pink_1_right.png"));
                greenTEST = ImageIO.read(new File("assets/enemies_icons/green/green_1_right.png"));
                yellowTEST = ImageIO.read(new File("assets/enemies_icons/yellow/yellow_1_right.png"));
            }
        } catch (IOException e) {
            System.out.println("Nieprawidłowe zdjęcie.");
        }

        int size = 32;
        int heightMargin = 20;
        int x = getWidth() / 3;

        g.drawImage(pacmanTEST, x, heightMargin, size, size, this);
        g.drawImage(blueTEST, x + 80, heightMargin, size, size, this);
        g.drawImage(pinkTEST, x + 80 * 2, heightMargin, size, size, this);
        g.drawImage(greenTEST, x + 80 * 3, heightMargin, size, size, this);
        g.drawImage(yellowTEST, x + 80 * 4, heightMargin, size, size, this);
    }
}

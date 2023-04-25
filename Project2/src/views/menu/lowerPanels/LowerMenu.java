package views.menu.lowerPanels;

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

    public LowerMenu(int lowerMenuPanelWidth, int lowerMenuPanelHeight) {

        this.setPreferredSize(new Dimension(lowerMenuPanelWidth, lowerMenuPanelHeight));
        this.setBackground(Color.BLACK);
        this.setMinimumSize(new Dimension(330, 70));

    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // todo to tylko place holder bedzie to zmienione na animacje
        try {
            if (pacmanTEST == null) {
                pacmanTEST = ImageIO.read(new File("assets/pacman_icons/pac_sredni.png"));
                blueTEST = ImageIO.read(new File("assets/enemies_icons/blue/blue_1_right.png"));
                pinkTEST = ImageIO.read(new File("assets/enemies_icons/pink/pink_1_right.png"));
                greenTEST = ImageIO.read(new File("assets/enemies_icons/green/green_1_right.png"));
                yellowTEST = ImageIO.read(new File("assets/enemies_icons/yellow/yellow_1_right.png"));
            }
        } catch (IOException e) {
            System.out.println("Nieprawidłowe zdjęcie.");
        }


        // trzeba wszystko uzależnić od getWidth i getHeight - zapewni to skalowalność okienka
        int size = 32;
        int heightMargin = 30;
        g.drawImage(pacmanTEST, 10, heightMargin, size, size, this);
        g.drawImage(blueTEST, 80, heightMargin, size, size, this);
        g.drawImage(pinkTEST, 150, heightMargin, size, size, this);
        g.drawImage(greenTEST, 220, heightMargin, size, size, this);
        g.drawImage(yellowTEST, 290, heightMargin, size, size, this);
    }
}

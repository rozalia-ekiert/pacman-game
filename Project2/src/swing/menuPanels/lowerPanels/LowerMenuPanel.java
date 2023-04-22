package swing.menuPanels.lowerPanels;

import com.sun.tools.javac.Main;
import swing.PACMANGamePanel;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class LowerMenuPanel extends JPanel {

    public LowerMenuPanel(int lowerMenuPanelWidth, int lowerMenuPanelHeight){

        this.setPreferredSize(new Dimension(lowerMenuPanelWidth, lowerMenuPanelHeight));
        this.setBackground(Color.BLACK);

    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Image pacmanTEST = null;
        Image blueTEST = null;
        Image pinkTEST = null;
        Image greenTEST = null;
        Image yellowTEST = null;
        try {
            pacmanTEST = ImageIO.read(new File("assets/pacman_icons/pac_sredni.png"));
            blueTEST = ImageIO.read(new File("assets/enemies_icons/blue/blue_1_right.png"));
            pinkTEST = ImageIO.read(new File("assets/enemies_icons/pink/pink_1_right.png"));
            greenTEST = ImageIO.read(new File("assets/enemies_icons/green/green_1_right.png"));
            yellowTEST = ImageIO.read(new File("assets/enemies_icons/yellow/yellow_1_right.png"));
        } catch (IOException e) {
            System.out.println("Nieprawidłowe zdjęcie.");
        }

        // trzeba wszystko uzależnić od getWidth i getHeight - zapewni to skalowalność okienka
        int size = getWidth()/45;
        int heightMargin = 30;
        g.drawImage(pacmanTEST, 10, heightMargin, size, size, this);
        g.drawImage(blueTEST, 80, heightMargin, size, size, this);
        g.drawImage(pinkTEST, 150, heightMargin, size, size, this);
        g.drawImage(greenTEST, 220, heightMargin, size, size, this);
        g.drawImage(yellowTEST, 290, heightMargin, size, size, this);
    }
}

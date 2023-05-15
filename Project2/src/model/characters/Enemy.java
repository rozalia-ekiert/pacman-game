package model.characters;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;

import static model.DrawableObjects.addDrawable;

public class Enemy extends Character implements mapTile {
    public final Colors color;

    private Image image;

    public Enemy(int row, int column, Colors color) {
        super(null);
        this.spawnLocationRow = row;
        this.spawnLocationClumn = column;
        this.color = color;

        try {
            switch (color) {
                case PINK -> this.image = ImageIO.read(new File("assets/enemies_icons/pink/pink_2_straight.png"));
                case GREEN -> this.image = ImageIO.read(new File("assets/enemies_icons/green/green_2_straight.png"));
                case BLUE -> this.image = ImageIO.read(new File("assets/enemies_icons/blue/blue_2_straight.png"));
                default -> this.image = ImageIO.read(new File("assets/enemies_icons/purple/purple_2_straight.png"));
            }
        } catch (IOException e) {
            System.out.println("Nieprawidłowe zdjęcie.");
        }
        addDrawable(this.getMapCode(), this);
    }


    @Override
    public Image getAnimatonFrame(long deltaT) {
        return null;
    }


    @Override
    public int getMapCode() {
        return Integer.parseInt("4" + this.color.ordinal());
    }

    @Override
    public void moveHorizontally(int X) {

    }

    @Override
    public void moveVertically(int Y) {

    }

    @Override
    public Image getImage() {
        return this.image;
    }
}

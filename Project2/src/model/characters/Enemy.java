package model.characters;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Enemy extends Character {

    public Image setEnemiesImages(int a) {

        try {
            pink = ImageIO.read(new File("assets/enemies_icons/pink/pink_2_straight.png"));
            green = ImageIO.read(new File("assets/enemies_icons/green/green_2_straight.png"));
            blue = ImageIO.read(new File("assets/enemies_icons/blue/blue_2_straight.png"));
            purple = ImageIO.read(new File("assets/enemies_icons/purple/purple_2_straight.png"));

            ArrayList<Image> imgs = new ArrayList<>();
            imgs.add(pink);
            imgs.add(green);
            imgs.add(blue);
            imgs.add(purple);

            return imgs.get(a);

        } catch (IOException e) {
            System.out.println("Nieprawidłowe zdjęcie.");
        }
        return null;
    }    Image pink = setEnemiesImages(0);

    public Image getEnemyImage(CharacterAnimationState characterAnimationState) {
        Image currentImg = null;
        switch (characterAnimationState) {
            case GhostPINK -> {
                currentImg = this.pink;
                return currentImg;
            }
            case GhostGREEN -> {
                currentImg = this.green;
                return currentImg;
            }
            case GhostBLUE -> {
                currentImg = this.blue;
                return currentImg;
            }
            case GhostPURPLE -> {
                currentImg = this.purple;
                return currentImg;
            }
        }
        return null;
    }    Image green = setEnemiesImages(1);
    Image blue = setEnemiesImages(2);
    Image purple = setEnemiesImages(3);


    Map<CharacterAnimationState, List<Image>> animacje;
//    Image currentState;

    double speed = 80;

    @Override
    public Image getAnimatonFrame(long deltaT) {
        return null;
    }




}

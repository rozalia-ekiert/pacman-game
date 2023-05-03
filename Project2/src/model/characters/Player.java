package model.characters;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Player extends Character {

    public static CharacterAnimationState currentState = CharacterAnimationState.PlayerCLOSE;    Image pacmanDefault = setPlayerImages(0);

    public Image setPlayerImages(int a) {

        try {
            pacmanDefault = ImageIO.read(new File("assets/pacman_icons/pac_sredni.png"));
            pacmanOpened = ImageIO.read(new File("assets/pacman_icons/pac_otwarty.png"));
            pacmanClosed = ImageIO.read(new File("assets/pacman_icons/pac_caly.png"));

            ArrayList<Image> imgs = new ArrayList<>();
            imgs.add(pacmanDefault);
            imgs.add(pacmanOpened);
            imgs.add(pacmanClosed);

            return imgs.get(a);

        } catch (IOException e) {
            System.out.println("Nieprawidłowe zdjęcie.");
        }
        return null;
    }    Image pacmanOpened = setPlayerImages(1);

    public Image getPlayerImage(CharacterAnimationState currentState) {
        Image currentImg = null;
        switch (currentState) {
            case PLayerDEFAULT -> {
                currentImg = this.pacmanDefault;
                return currentImg;
            }
            case PLayerOPEN -> {
                currentImg = pacmanOpened;
                return currentImg;
            }
            case PlayerCLOSE -> {
                currentImg = pacmanClosed;
                return currentImg;
            }
        }
        return null;
    }    Image pacmanClosed = setPlayerImages(2);


    Map<CharacterAnimationState, List<Image>> playerState;

    double speed = 80;

    public Player() {
    }

    @Override
    public Image getAnimatonFrame(long deltaT) {
        return null;
    }






}

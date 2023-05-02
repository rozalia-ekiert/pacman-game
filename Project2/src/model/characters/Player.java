package model.characters;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.ImageObserver;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public class Player extends Character {

    Image pacmanDefault = null;
    Image pacmanOpened = null;
    Image pacmanClosed = null;


    Map<CharacterAnimationState, List<Image>> playerState;
    CharacterAnimationState currentState = CharacterAnimationState.PlayerCLOSE;
    double speed = 80;

    public Player() {
        setPlayerImages();

    }

    @Override
    public Image getAnimatonFrame(long deltaT) {
        return null;
    }


    public void setPlayerImages() {

        try {
            pacmanDefault = ImageIO.read(new File("assets/pacman_icons/pac_sredni.png"));
            pacmanOpened = ImageIO.read(new File("assets/pacman_icons/pac_otwarty.png"));
            pacmanClosed = ImageIO.read(new File("assets/pacman_icons/pac_caly.png"));
        } catch (IOException e) {
            System.out.println("Nieprawidłowe zdjęcie.");
        }
    }

    public void drawPlayer(Graphics g, int cellsize, ImageObserver imageObserver, int x, int y) {

        cellsize = (int) (cellsize * 0.9);
        switch (currentState) {
            case PLayerDEFAULT -> g.drawImage(this.pacmanDefault, x, y, cellsize, cellsize, imageObserver);
            case PLayerOPEN -> g.drawImage(this.pacmanOpened, x, y, cellsize, cellsize, imageObserver);
            case PlayerCLOSE -> g.drawImage(this.pacmanClosed, x, y, cellsize, cellsize, imageObserver);
        }

    }
}

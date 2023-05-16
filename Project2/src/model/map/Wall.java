package model.map;

import model.characters.MapTile;

import java.awt.*;

public class Wall implements MapTile {


    private final Image image;

    public Wall(Image image) {
        this.image = image;
    }

    @Override
    public Image getImage() {
        return this.image;
    }
}

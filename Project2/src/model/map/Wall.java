package model.map;

import model.characters.mapTile;

import java.awt.*;

public class Wall implements mapTile {


    private final Image image;

    public Wall(Image image) {
        this.image = image;
    }

    @Override
    public Image getImage() {
        return this.image;
    }
}

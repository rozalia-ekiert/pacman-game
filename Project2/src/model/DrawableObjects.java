package model;

import model.characters.mapTile;

import java.util.HashMap;

public class DrawableObjects {
  static private HashMap<Integer, mapTile> map = new HashMap<>();

  public static void addDrawable(int id, mapTile drawable) {
    DrawableObjects.map.put(id, drawable);
  }

  public static mapTile getDrawable(int id) {
    return DrawableObjects.map.get(id);
  }
}

package model;

import model.characters.MapTile;

import java.util.HashMap;

public class DrawableObjects {
  static private HashMap<Integer, MapTile> map = new HashMap<>();

  public static void addDrawable(int id, MapTile drawable) {
    DrawableObjects.map.put(id, drawable);
  }

  public static MapTile getDrawable(int id) {
    return DrawableObjects.map.get(id);
  }
}

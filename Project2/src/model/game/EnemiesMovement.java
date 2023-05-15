package model.game;

import model.characters.Enemy;
import model.map.MapModel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class EnemiesMovement {

    public static HashMap<Integer, int[]> ghostsLocalization;
    ArrayList<Enemy> enemies;
    MapModel mapModel;

    public EnemiesMovement(ArrayList<Enemy> enemies, MapModel mapModel) {
        this.enemies = enemies;
        this.mapModel = mapModel;

        for (Enemy e : enemies) {

            int newDestination = setDestination();
            switch (newDestination) {
                case 1:
                    //jedz do gory
                    break;
                case 2:
                    //jedz w prawo
                    break;
                case 3:
                    //jedz w dol
                    break;
                case 4:
                    //jedz w lewo
                    break;
            }
        }
    }

    private int setDestination() {
        Random random = new Random();
        random.nextInt(4);

        return 0;
    }

    private int[][] checkDestinations(Enemy enemy, MapModel model) {

        return null;
    }

}

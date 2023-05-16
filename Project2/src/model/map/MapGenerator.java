package model.map;

import model.characters.Colors;
import model.characters.Enemy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

import static model.map.MapModel.*;

public class MapGenerator {
    //utility class

    static int sciana = 0;
    static final int pustePoleStale = 18;
    public static final int pustePole = 19;
    public static int cookieBig = 20;
    public static final int cookieSmall = 21;
    public static int gate = 16;

    public static int[][] generateMap() {
        int[][] map = new int[rows][columns];
        enemies = new ArrayList<Enemy>();

        //uzupełniam wszystkie pola
        for (int i = 0; i < rows; i++) {
            Arrays.fill(map[i], pustePole);
        }

        //miejsca dużych ciasteczek
        map[2][1] = cookieBig;
        map[2][columns - 2] = cookieBig;
        map[rows - 3][1] = cookieBig;
        map[rows - 3][columns - 2] = cookieBig;
        MapModel.cookiesCounter = MapModel.cookiesCounter + 4;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {

                if (map[i][j] != pustePole) continue;


                //generowanie brzegów
                if (i == 0 || i == rows - 1 || j == 0 || j == columns - 1) {
                    if (i == rows / 2 && j == 0 || i == rows / 2 && j == columns - 1) { // przejscie w polowie drogi
                        map[i][j] = pustePoleStale;
                    } else {
                        map[i][j] = sciana;
                    }
                    continue;
                }

                // generowanie miejsca respawnu duszków

                if (enemiesRespawn(rows, columns, map, i, j)) continue;

                //losowe wnętrze
                if (i > 2 && map[i - 2][j] == pustePole) {
                    if (j != 1 && j != columns - 2 && map[i - 1][j] == pustePole && i != rows / 2 - 1 && j != columns / 2 && j != columns / 4 && j != (columns / 4) * 3)
                        map[i][j] = sciana;
                }
            }
        }

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (i >= 1 && j >= 1 && i <= rows - 2 && j <= columns - 2 && map[i - 1][j - 1] == sciana && map[i - 1][j] == sciana && map[i - 1][j + 1] == sciana && map[i][j - 1] != sciana && map[i][j + 1] != sciana && map[i + 1][j] != sciana && map[i + 1][j - 1] != sciana && map[i + 1][j + 1] != sciana) {
                    Random rand = new Random();
                    int random = rand.nextInt(10);
                    if (random > 5) {
                        map[i][j] = sciana;
                    }
                }
            }
        }


        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                //uzupełniam puste pola ciasteczkami
                if (map[i][j] == pustePole) {
                    map[i][j] = cookieSmall;
                    MapModel.cookiesCounter++;
                }
                //setWallsNumbers
                if (map[i][j] <= 15) {
                    int counter = 0;
                    if (i - 1 >= 0 && map[i - 1][j] <= 15) {
                        counter += 1;
                    }
                    if (i + 1 < rows && map[i + 1][j] <= 15) {
                        counter += 4;
                    }
                    if (j - 1 >= 0 && map[i][j - 1] <= 15) {
                        counter += 8;
                    }
                    if (j + 1 < columns && map[i][j + 1] <= 15) {
                        counter += 2;
                    }
                    map[i][j] = counter;
                }
            }
        }


        MapModel.cookiesCounter = MapModel.cookiesCounter - 1; //odejmuję wartość, gdzie ustawię pacmana
        return map;
    }

    public static void spawnEnemies(MapModel map) {
        for (Enemy e : enemies) {
            int mapCode = e.getMapCode();
            int spawnLocationClumn = e.getSpawnLocationClumn();
            int spawnLocationRow = e.getSpawnLocationRow();
            map.map[spawnLocationRow][spawnLocationClumn] = mapCode;
            e.setMapModel(map);
        }
    }


    private static boolean enemiesRespawn(int rows, int columns, int[][] map, int i, int j) {
        if ((columns % 2) != 0) { // dla nieparzystej ilośći kolumn
            if (i == rows / 2 && j == columns / 2 - 1) {
                enemies.add(new Enemy(i, j, Colors.BLUE));
                enemies.add(new Enemy(i, j + 1, Colors.PURPLE));
                enemies.add(new Enemy(i, j + 2, Colors.GREEN));
                enemies.add(new Enemy(i - 2, j + 1, Colors.PINK));

                //miejsce dla duszków
                map[i][j] = pustePoleStale;
                map[i][j + 1] = pustePoleStale;
                map[i][j + 2] = pustePoleStale;
                map[i - 2][j + 1] = pustePoleStale;

                map[i - 1][j - 1] = sciana;
                map[i - 1][j] = sciana;
                map[i - 1][j + 2] = sciana;
                map[i - 1][j + 3] = sciana;

                map[i - 1][j + 1] = gate;

                map[i][j - 1] = sciana;
                map[i][j + 3] = sciana;

                map[i + 1][j - 1] = sciana;
                map[i + 1][j] = sciana;
                map[i + 1][j + 1] = sciana;
                map[i + 1][j + 2] = sciana;
                map[i + 1][j + 3] = sciana;

                return true;
            }
        }
        if ((columns % 2) == 0) { //dla parzystej ilosci kolumn
            if (i == rows / 2 && j == columns / 2) {

                enemies.add(new Enemy(i, j, Colors.BLUE));
                enemies.add(new Enemy(i, j - 1, Colors.PURPLE));
                enemies.add(new Enemy(i, j - 2, Colors.GREEN));
                enemies.add(new Enemy(i, j + 1, Colors.PINK));

                //miejsce dla duszów
                map[i][j] = pustePoleStale;
                map[i][j - 1] = pustePoleStale;
                map[i][j - 2] = pustePoleStale;
                map[i][j + 1] = pustePoleStale;

                map[i - 1][j - 2] = sciana;
                map[i - 1][j - 3] = sciana;
                map[i - 1][j + 1] = sciana;
                map[i - 1][j + 2] = sciana;

                map[i - 1][j - 1] = gate;
                map[i - 1][j] = gate;

                map[i][j - 3] = sciana;
                map[i][j + 2] = sciana;

                map[i + 1][j - 3] = sciana;
                map[i + 1][j - 2] = sciana;
                map[i + 1][j - 1] = sciana;
                map[i + 1][j] = sciana;
                map[i + 1][j + 1] = sciana;
                map[i + 1][j + 2] = sciana;

                return true;
            }
        }
        return false;
    }

}
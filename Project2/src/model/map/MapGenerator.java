package model.map;

import java.util.Arrays;

public class MapGenerator {
    //utility class

    static int sciana = 0;
    static int pustePoleStale = 18;
    static int pustePole = 19;
    static int cookieBig = 20;
    static int cookieSmall = 21;
    static int blue = 23;
    static int purple = 24;
    static int green = 25;
    static int pink = 26;
    static int pacman = 22;

    public static int[][] generateMap(int rows, int columns) {
        int[][] map = new int[rows][columns];

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
                if ((columns % 2) == 0) { //dla parzystej ilosci kolumn
                    if (i == rows / 2 && j == columns / 2) {
                        map[i][j] = blue;
                        map[i][j - 1] = purple;
                        map[i][j - 2] = green;
                        map[i][j + 1] = pink;

                        map[i - 1][j - 2] = sciana;
                        map[i - 1][j - 3] = sciana;
                        map[i - 1][j + 1] = sciana;
                        map[i - 1][j + 2] = sciana;

                        map[i][j - 3] = sciana;
                        map[i][j + 2] = sciana;

                        map[i + 1][j - 3] = sciana;
                        map[i + 1][j - 2] = sciana;
                        map[i + 1][j - 1] = sciana;
                        map[i + 1][j] = sciana;
                        map[i + 1][j + 1] = sciana;
                        map[i + 1][j + 2] = sciana;
                        continue;
                    }

                }
                if ((columns % 2) != 0) { // dla nieparzystej ilośći kolumn
                    if (i == rows / 2 && j == columns / 2 - 1) {
                        map[i][j] = blue;
                        map[i][j + 1] = purple;
                        map[i][j + 2] = green;
                        map[i - 2][j + 1] = pink;

                        map[i - 1][j - 1] = sciana;
                        map[i - 1][j] = sciana;
                        map[i - 1][j + 2] = sciana;
                        map[i - 1][j + 3] = sciana;

                        map[i][j - 1] = sciana;
                        map[i][j + 3] = sciana;

                        map[i + 1][j - 1] = sciana;
                        map[i + 1][j] = sciana;
                        map[i + 1][j + 1] = sciana;
                        map[i + 1][j + 2] = sciana;
                        map[i + 1][j + 3] = sciana;
                        continue;
                    }
                }

                //losowe wnętrze
                if (i > 2 && map[i - 2][j] == pustePole) {
                    if (j != 1 && j != columns - 2 && map[i - 1][j] == pustePole && i != rows / 2 - 1 && j != columns / 2
                            && j != columns / 4 && j != (columns / 4) * 3) map[i][j] = sciana;
                }
            }
        }

        //uzupełniam puste pola ciasteczkami
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (map[i][j] == pustePole) {
                    map[i][j] = cookieSmall;
                    MapModel.cookiesCounter++;
                }
            }
        }

        //setWallsNumbers
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
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

}
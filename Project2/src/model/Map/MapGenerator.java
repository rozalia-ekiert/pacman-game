//package model.Map;
//
//public class MapGenerator {
//
//    int rows = 20;
//    int columns = 21;
//
//    public MapGenerator(int rows, int columns) {
//
//        this.rows = rows;
//        this.columns = columns;
//
//        int droga = 0;
//        int sciana = 1;
//        int resprawn = 2;
//
//
//        int[][] tab = new int[rows][columns];
//
//        for (int i = 0; i < rows; i++) {
//            for (int j = 0; j < columns; j++) {
//                tab[i][j] = 9;
//            }
//        }
//
//
//        for (int i = 0; i < rows; i++) {
//            for (int j = 0; j < columns; j++) {
//
//                if(tab[i][j]!=9) continue;
//
//                //generowanie brzegów
//                if (i == 0 || i == rows - 1 || j == 0 || j == columns - 1) {
//                    if (i == rows / 2 && j == 0 || i == rows / 2 && j == columns - 1) { // przejscie w polowie drogi
//                        tab[i][j] = droga;
//                    } else {
//                        tab[i][j] = sciana;
//                    }
//                    continue;
//                }
//
//                //generowanie miejsca respawnu duszków
//                if ((columns % 2) == 0) {
//                    if (i == rows / 2 && j == columns / 2 || i == rows / 2 && j == columns / 2 - 1) {
//                        tab[i][j] = resprawn;
//                        continue;
//                    }
//                } else { // dla nieparzystej ilośći kolumn
//                    if (i == rows / 2 && j == columns / 2 - 1 || i == rows / 2 && j == columns / 2 || i == rows / 2 && j == columns / 2 + 1) {
//                        tab[i][j] = resprawn;
//                        continue;
//                    }
//                }
//
////                tab[i][j] = droga;
//
//            }
//        }
//
//
//        for (int i = 0; i < rows; i++) {
//            for (int j = 0; j < columns; j++) {
//                System.out.print(tab[i][j] + " ");
//            }
//            System.out.println();
//        }
//    }
//
//}

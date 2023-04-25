import views.PACMANGame;

public class Main {


    public static void main(String[] args) {
        System.setProperty("sun.java2d.opengl", "True");

        PACMANGame graPanel = new PACMANGame();

//        int a = 100;
//        int b = 100;
//
//        int droga = 0;
//        int sciana = 1;
//        int resprawn = 2;
//
//        int[][] tab = new int[a][b];
//        for (int i=0; i<a; i++){
//            for (int j=0; j<b; j++){
//
//                if (i==0 || i==a-1 || j==0 || j==b-1){ // brzegi
//                    if (i==a/2 && j==0 || i==a/2 && j==b-1){ // przejscie w polowie drogi
//                        tab[i][j] = droga;
//                    } else {
//                        tab[i][j] = sciana;
//                    }
//                }
//                else if (i==a/2 && j==b/2 || i==a/2 && j==b/2-1){ // miejsce respawnu duszków
//                    tab[i][j] = resprawn;
//                }
//                else {
//                    tab[i][j] = droga;
//                }
//
//            }
//        }
//
//        for (int i=0; i<a; i++){
//            for (int j=0; j<b; j++){
//                System.out.print(tab[i][j]+" ");
//            }
//            System.out.println();
//        }

    }
}
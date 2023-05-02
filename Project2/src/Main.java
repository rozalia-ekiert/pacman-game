//import model.Map.MapGenerator;

import views.PACMANGame;

public class Main {

    final static int updatesPerSecond = 10;

    public static void main(String[] args) {
        System.setProperty("sun.java2d.opengl", "True");

        PACMANGame pacmanGame = new PACMANGame();

        Thread movement = new Thread(() -> {
            long now = System.currentTimeMillis();
            long tick = 0;
            while (true) {
                if (System.currentTimeMillis() - now < 1000 / updatesPerSecond) {
                    continue;
                }
                tick++;
                pacmanGame.repaint();
                now = System.currentTimeMillis();
            }
        });

    }
}
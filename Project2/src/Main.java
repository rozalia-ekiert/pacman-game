//import model.Map.MapGenerator;

import views.PACMANGame;

import java.awt.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class Main {

    final static int updatesPerSecond = 10;

    public static void main(String[] args) {
        System.setProperty("sun.java2d.opengl", "True");

        PACMANGame pacmanGame = new PACMANGame();

//        Thread stats = new Thread(() -> {
//            long now = System.currentTimeMillis();
//            while (true) {
//                if (System.currentTimeMillis() - now < 1000 / updatesPerSecond) {
//                    continue;
//                }
//                pacmanGame.repaint();
//                System.out.println("repaintuje");
//                now = System.currentTimeMillis();
//            }
//        });
//        stats.start();

        KeyboardFocusManager.getCurrentKeyboardFocusManager().addPropertyChangeListener("permanentFocusOwner", new PropertyChangeListener() {
            @Override
            public void propertyChange(PropertyChangeEvent evt) {
                System.out.println("Current focus: " + evt.getNewValue());
            }
        });

    }
}
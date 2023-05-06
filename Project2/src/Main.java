//import model.Map.MapGenerator;

import views.PACMANGame;

import java.awt.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class Main {

    final static int updatesPerSecond = 20;

    public static void main(String[] args) {
        System.setProperty("sun.java2d.opengl", "True");

        PACMANGame pacmanGame = new PACMANGame();

        KeyboardFocusManager.getCurrentKeyboardFocusManager().addPropertyChangeListener("permanentFocusOwner", new PropertyChangeListener() {
            @Override
            public void propertyChange(PropertyChangeEvent evt) {
                System.out.println("Current focus: " + evt.getNewValue());
            }
        });

    }
}
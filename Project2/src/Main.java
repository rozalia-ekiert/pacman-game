//import model.Map.MapGenerator;

import views.PACMANGame;

public class Main {

    final static int updatesPerSecond = 10;

    public static void main(String[] args) {
        System.setProperty("sun.java2d.opengl", "True");

        PACMANGame pacmanGame = new PACMANGame();

//
//        KeyboardFocusManager.getCurrentKeyboardFocusManager().addPropertyChangeListener("permanentFocusOwner", new PropertyChangeListener() {
//            @Override
//            public void propertyChange(PropertyChangeEvent evt) {
//                System.out.println("Current focus: " + evt.getNewValue());
//            }
//        });

    }
}
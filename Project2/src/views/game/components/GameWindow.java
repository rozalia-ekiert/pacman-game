package views.game.components;

import javax.swing.*;

public class GameWindow extends JPanel {

    public GameWindow() {

        CurrentStats currentStats = new CurrentStats();
        Gameplay gameplay = new Gameplay();

        this.add(currentStats);
        this.add(gameplay);
    }
}

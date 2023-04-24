package swing.menuPanels.middlePanels;

import swing.PACMANGamePanel;

import javax.swing.*;
import java.awt.*;

public class CustomizeYourGamePanel extends JPanel {

    public CustomizeYourGamePanel(int width, int height, PACMANGamePanel pacmanGamePanel) {
        this.setPreferredSize(new Dimension(width, height));
        this.setBackground(Color.PINK);

        this.setLayout(new GridBagLayout());


        String text = "TO JEST PANEL DO PODANIA ROZMIARU GRY";

        JTextArea textArea = new JTextArea(text, 1, 20);
        textArea.setForeground(Color.GREEN);
        textArea.setBackground(Color.BLACK);
        textArea.setFont(pacmanGamePanel.Butterbelly);

        this.add(textArea);
    }

}

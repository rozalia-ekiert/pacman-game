package swing.menuPanels.middlePanels;

import swing.PACMANGamePanel;

import javax.swing.*;
import java.awt.*;

public class MiddleTextPanel extends JPanel {

    public MiddleTextPanel(int width, int height, PACMANGamePanel pacmanGamePanel) {
        this.setPreferredSize(new Dimension(width, height));
        this.setBackground(Color.BLACK);

        this.setLayout(new GridBagLayout());


        String text = "The classic and enormously popular Pac-Man video game came out\n" +
                "in Japan on May 21, 1980, and by October of that year it was released\n" +
                " in the United States. The yellow, pie-shaped Pac-Man character,\n" +
                "who travels around a maze trying to eat dots and avoid four hunting ghosts,\n" +
                "quickly became an icon of the 1980s.\n";

        JTextArea textArea = new JTextArea(text, 5, 20);
        textArea.setForeground(Color.WHITE);
        textArea.setBackground(Color.BLACK);
        textArea.setFont(pacmanGamePanel.Butterbelly);
        textArea.setEnabled(false);
        textArea.setEditable(false);

        this.add(textArea);
    }

//    public String sformatujTekst (String tekst){
//        String[] listaSlow = tekst.split(" ");
//        for (int i=0; i<listaSlow.length; i++){
//            String obecnyWiersz = null;
//            if ((obecnyWiersz+listaSlow[i]).length()<60){
//                obecnyWiersz = obecnyWiersz+listaSlow[i]+' ';
//            }
//        }
//        return null;
//    }
}

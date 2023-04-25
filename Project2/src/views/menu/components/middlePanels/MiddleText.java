package views.menu.components.middlePanels;

import views.PACMANGame;

import javax.swing.*;
import java.awt.*;

public class MiddleText extends JPanel {

    public MiddleText(int width, int height, PACMANGame pacmanGameFrame) {
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
        textArea.setFont(pacmanGameFrame.Butterbelly);

        textArea.setEnabled(false);
        textArea.setEditable(false);

        this.add(textArea);
    }

// CELEM TEJ METODY MA BYĆ SFORMATOWANIE TEKSTU TAK, ŻEBY BYŁ WYCENTROWANY
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

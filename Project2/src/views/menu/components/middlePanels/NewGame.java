package views.menu.components.middlePanels;

import views.PACMANGame;

import javax.swing.*;
import java.awt.*;

public class NewGame extends JPanel {

    public NewGame(int width, int height, PACMANGame pacmanGameFrame) {

        this.setPreferredSize(new Dimension(width, height));
        this.setLayout(new BoxLayout(this, 0));

        CustomizeYourGame customizeYourGame = new CustomizeYourGame(pacmanGameFrame, width, height);
        Rules rules = new Rules(pacmanGameFrame, width, height);

        this.add(customizeYourGame);
//        this.add(Box.createHorizontalGlue());
        this.add(rules);
    }
}

class CustomizeYourGame extends JPanel {

    private String text;
    private int width;
    private int height;

    public CustomizeYourGame(PACMANGame pacmanGameFrame, int width, int height) {

        this.width = this.width / 2;
        this.height = this.height;
        this.setSize(new Dimension(this.width, this.height));

        this.setLayout(new GridBagLayout());
        this.setBackground(Color.BLACK);

        this.text = "TO JEST PANEL DO PODANIA ROZMIARU GRY";

        JTextArea textArea = new JTextArea(text, 1, 10);
        textArea.setForeground(Color.WHITE);
        textArea.setBackground(Color.BLACK);
        textArea.setFont(pacmanGameFrame.Butterbelly);
        textArea.setEnabled(false);
        textArea.setEditable(false);
        this.add(textArea);
    }
}

class Rules extends JPanel {

    private String rules = "RULES";
    private String text1, text2, text3, text4, text5;
    private Color c1 = new Color(0xE9FDAE);
    private Color c2 = new Color(0xFDA8F7);
    private int width;
    private int height;
    private PACMANGame pacmanGame;

    public Rules(PACMANGame pacmanGame, int width, int height) {

        this.pacmanGame = pacmanGame;
        this.width = width / 2;
        this.height = height;
        this.setSize(new Dimension(this.width, this.height));

        this.setLayout(new GridBagLayout());
        this.setBackground(Color.BLACK);

        this.text1 = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Ut vitae\n";
        this.text2 = "efficitur ligula, in viverra ipsum. Orci varius natoque penatibus\n";
        this.text3 = "et magnis dis parturient montes, nascetur ridiculus mus. Etiam eu\n";
        this.text4 = "molestie dolor. Vestibulum placerat metus vitae justo rutrum mollis.\n";
        this.text5 = "Nam blandit rhoncus neque molestie vulputate.";

//        JTextArea textArea = new JTextArea(text, 1, 10);
//        textArea.setForeground(Color.WHITE);
//        textArea.setBackground(Color.BLACK);
//        textArea.setFont(pacmanGame.Butterbelly);
//        textArea.setEnabled(false);
//        textArea.setEditable(false);
//        this.add(textArea);

//        textArea.setForeground(Color.WHITE);
//        textArea.setBackground(Color.BLACK);
//        textArea.setFont(pacmanGame.Butterbelly);
//        textArea.setEnabled(false);
//        textArea.setEditable(false);
//        this.add(textArea);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2d = (Graphics2D) g;

        GradientPaint gradient = new GradientPaint(20, 60, this.c1, getWidth() - 80, getHeight() - 120, c2);
        g2d.setPaint(gradient);
        g2d.fillRect(20, 60, getWidth() - 80, getHeight() - 120);

        g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 1f));
        g2d.setColor(Color.BLACK);

        Font f1 = new Font("Butterbelly", Font.PLAIN, 24);
        g2d.setFont(f1);
        g2d.drawString(this.rules, 50, (getHeight() / 5) + 30);

        Font f2 = new Font("Arimo", Font.PLAIN, 14);
        g2d.setFont(f2);
        g2d.drawString(this.text1, 50, (getHeight() / 5) + 60);
        g2d.drawString(this.text2, 50, (getHeight() / 5) + 60 + 16);
        g2d.drawString(this.text3, 50, (getHeight() / 5) + 60 + 32);
        g2d.drawString(this.text4, 50, (getHeight() / 5) + 60 + 48);
        g2d.drawString(this.text5, 50, (getHeight() / 5) + 60 + 64);
    }
}
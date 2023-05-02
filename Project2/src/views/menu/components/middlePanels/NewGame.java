package views.menu.components.middlePanels;

import controllers.menu.PlayButtonMouseListener;
import views.GameColors;
import views.PACMANGame;
import views.game.Game;
import views.menu.MenuStart;

import javax.swing.*;
import java.awt.*;


public class NewGame extends JPanel {

    private String text = "<html>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Ut vitae<br>" +
            "efficitur ligula, in viverra ipsum. Orci varius natoque penatibus et magnis dis<br>" +
            "parturient montes, nascetur ridiculus mus. Etiam eu molestie dolor.<br>" +
            "Vestibulum placerat metus vitae justo rutrum mollis. Nam blandit<br>" +
            "rhoncus neque molestie vulputate.</html>";
    public JButton play;
    private String windowGameSize = "SET WINDOW GAME SIZE";
    private int width;
    private int height;
    private String yourNick = "SET YOUR NICKNAME";

    public NewGame(int width, int height, PACMANGame pacmanGame, MenuStart menuStart, Game game) {

        Font font1 = new Font("Butterbelly", Font.PLAIN, 50);
        Font font2 = new Font("Butterbelly", Font.PLAIN, 16);

        this.width = width;
        this.height = height;
        this.setPreferredSize(new Dimension(this.width, this.height));

        this.setLayout(new GridBagLayout());
        this.setBackground(Color.BLACK);

        //------------------------------------------ wiersz 0
        JTextArea rows = new JTextArea("rows");
        rows.setForeground(Color.WHITE);
        rows.setBackground(Color.BLACK);
        rows.setFont(font2);
        rows.setEditable(false);

        JTextArea columns = new JTextArea("columns");
        columns.setForeground(Color.WHITE);
        columns.setBackground(Color.BLACK);
        columns.setFont(font2);
        columns.setEditable(false);

        GradientText gradientText = new GradientText(this.text, pacmanGame);


        //------------------------------------------ wiersz 1
        JTextArea windowGameSize = new JTextArea(this.windowGameSize);
        windowGameSize.setForeground(Color.WHITE);
        windowGameSize.setBackground(Color.BLACK);
        windowGameSize.setFont(font1);
        windowGameSize.setEditable(false);

        JTextField setWindowsSize1 = new JTextField();
        JTextField setWindowsSize2 = new JTextField();

        int size = 80;
        setWindowsSize1.setPreferredSize(new Dimension(size, size));
        setWindowsSize1.setMaximumSize(new Dimension(size, size));

        setWindowsSize2.setPreferredSize(new Dimension(size, size));
        setWindowsSize2.setMaximumSize(new Dimension(size, size));

        //------------------------------------------ wiersz 2
        JTextArea yourNick = new JTextArea(this.yourNick);
        yourNick.setForeground(Color.WHITE);
        yourNick.setBackground(Color.BLACK);
        yourNick.setFont(font1);
        yourNick.setEditable(false);

        JTextField setYourNick = new JTextField();
        setYourNick.setPreferredSize(new Dimension(150, 60));

        //------------------------------------------ wiersz 3
        this.play = new JButton("play!");
        play.setBackground(GameColors.pink);
        play.setFont(pacmanGame.Butterbelly);
        play.setForeground(Color.BLACK);

        //-------------------------------------------------------------------------

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.BOTH;

        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.gridheight = 1;
        gbc.gridwidth = 1;
        gbc.insets = new Insets(40, 0, 10, 40);
        gbc.anchor = GridBagConstraints.FIRST_LINE_START;
        this.add(rows, gbc);


        gbc.gridx = 2;
        gbc.gridy = 0;
        gbc.gridheight = 1;
        gbc.gridwidth = 1;
        gbc.insets = new Insets(40, 0, 10, 0);
        gbc.anchor = GridBagConstraints.FIRST_LINE_START;
        this.add(columns, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridheight = 1;
        gbc.gridwidth = 1;
        gbc.insets = new Insets(0, 0, 20, 40);
        gbc.anchor = GridBagConstraints.LINE_START;
        this.add(windowGameSize, gbc);

        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.gridheight = 1;
        gbc.gridwidth = 1;
        gbc.insets = new Insets(0, 0, 20, 30);
        gbc.anchor = GridBagConstraints.LINE_END;
        this.add(setWindowsSize1, gbc);

        gbc.gridx = 2;
        gbc.gridy = 1;
        gbc.gridheight = 1;
        gbc.gridwidth = 1;
        gbc.insets = new Insets(0, 0, 20, 0);
        gbc.anchor = GridBagConstraints.LINE_END;
        this.add(setWindowsSize2, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridheight = 1;
        gbc.gridwidth = 1;
        gbc.insets = new Insets(20, 0, 20, 30);
        gbc.anchor = GridBagConstraints.LINE_START;
        this.add(yourNick, gbc);

        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.gridwidth = 2;
        gbc.gridheight = 1;
        gbc.anchor = GridBagConstraints.LINE_END;
        gbc.insets = new Insets(20, 0, 20, 0);
        this.add(setYourNick, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 3;
        gbc.gridheight = 1;
        gbc.ipady = 30;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(40, 0, 40, 0);
        this.add(play, gbc);

        gbc.gridx = 3;
        gbc.gridy = 0;
        gbc.gridheight = 4;
        gbc.gridwidth = 1;
        gbc.insets = new Insets(40, 80, 40, 0); // 40 x 40
        gbc.weightx = 0.0;
        gbc.weighty = 1.0;
        gbc.ipadx = 500;
        gbc.anchor = GridBagConstraints.FIRST_LINE_END;
        this.add(gradientText, gbc);

        this.play.addMouseListener(new PlayButtonMouseListener(this, pacmanGame, game));

    }
}


class GradientText extends JPanel {

    public GradientText(String text, PACMANGame pacmanGame) {

//        this.setLayout(new GridBagLayout());
//
//        String rules = "RULES";
//        JLabel rulesLabel = new JLabel(text);
//        rulesLabel.setForeground(Color.BLACK);
//        rulesLabel.setFont(pacmanGame.Butterbelly);
//
//        Font f2 = new Font("Arimo", Font.PLAIN, 14);
//        JLabel textLabel = new JLabel(text);
//        textLabel.setForeground(Color.BLACK);
//        textLabel.setFont(f2);
//
//        this.add(rulesLabel);
//        this.add(textLabel);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        String rules = "RULES";
        String text1 = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Ut vitae\n";
        String text2 = "efficitur ligula, in viverra ipsum. Orci varius natoque penatibus\n";
        String text3 = "et magnis dis parturient montes, nascetur ridiculus mus. Etiam eu\n";
        String text4 = "molestie dolor. Vestibulum placerat metus vitae justo rutrum mollis.\n";
        String text5 = "Nam blandit rhoncus neque molestie vulputate.";

        Graphics2D g2d = (Graphics2D) g;

        GradientPaint gradient = new GradientPaint(0, 0, GameColors.gradient1, getWidth() / 2, getHeight(), GameColors.gradient2);
        g2d.setPaint(gradient);
        g2d.fillRect(0, 0, 550, getHeight());

        g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 1f));
        g2d.setColor(Color.BLACK);

        Font f1 = new Font("Butterbelly", Font.PLAIN, 24);
        g2d.setFont(f1);
        g2d.drawString(rules, 50, (getHeight() / 5) + 30);

        Font f2 = new Font("Arimo", Font.PLAIN, 14);
        g2d.setFont(f2);
        g2d.drawString(text1, 50, (getHeight() / 5) + 60);
        g2d.drawString(text2, 50, (getHeight() / 5) + 60 + 16);
        g2d.drawString(text3, 50, (getHeight() / 5) + 60 + 32);
        g2d.drawString(text4, 50, (getHeight() / 5) + 60 + 48);
        g2d.drawString(text5, 50, (getHeight() / 5) + 60 + 64);
    }

}
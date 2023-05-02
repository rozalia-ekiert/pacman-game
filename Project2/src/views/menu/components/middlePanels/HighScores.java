package views.menu.components.middlePanels;

import views.GameColors;
import views.PACMANGame;

import javax.swing.*;
import java.awt.*;

public class HighScores extends JPanel {

    public HighScores(int width, int height, PACMANGame pacmanGameFrame) {
        this.setPreferredSize(new Dimension(width, height));
        this.setBackground(Color.BLACK);

        Font currentButterbelly = new Font("Butterbelly", Font.PLAIN, 40);

        this.setLayout(new GridBagLayout());


//        String text = "HIGH SCORES";
//        JLabel textLabel = new JLabel(text);
//        textLabel.setForeground(Color.BLACK);
//        textLabel.setFont(currentButterbelly);
//
//        ArrayList<JLabel> list = new ArrayList<>();
//
//        int number = 1;
//        JLabel numberLabel = new JLabel(String.valueOf(number));
//        list.add(numberLabel);
//
//        String playerName = "Rozalka<3";
//        JLabel playerNameLabel = new JLabel(playerName);
//        list.add(playerNameLabel);
//
//        String score = "001555";
//        JLabel scoreLabel = new JLabel(score);
//        list.add(scoreLabel);
//
//        String time = "05:34";
//        JLabel timeLabel = new JLabel(time);
//        list.add(timeLabel);
//
//        String size = "10" + " x " + "10";
//        JLabel sizeLabel = new JLabel(size);
//        list.add(sizeLabel);
//
//
//        for (JLabel jl : list){
//            jl.setForeground(Color.BLACK);
//            jl.setFont(pacmanGameFrame.Butterbelly);
//            this.add(jl);
//        }

//        GridBagConstraints gbc = new GridBagConstraints();
//        gbc.fill = GridBagConstraints.BOTH;
//
//        gbc.gridx = 1;
//        gbc.gridy = 0;
//        gbc.gridheight = 1;
//        gbc.gridwidth = 2;
////        gbc.insets = new Insets(40, 0, 10, 40);
////        gbc.anchor = GridBagConstraints.FIRST_LINE_START;
//        this.add(textLabel, gbc);
//
//        gbc.gridx = 0;
//        gbc.gridy = 1;
//        gbc.gridheight = 1;
//        gbc.gridwidth = 1;

    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2d = (Graphics2D) g;

        GradientPaint gradient = new GradientPaint(0, 0, GameColors.gradient1, getWidth(), getHeight(), GameColors.gradient2);
        g2d.setPaint(gradient);
        g2d.fillRect((int) (getWidth() * 0.1), (int) (getHeight() * 0.1), (int) (getWidth() * 0.8), (int) (getHeight() * 0.8));

        g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 1f));
        g2d.setColor(Color.BLACK);
    }

}

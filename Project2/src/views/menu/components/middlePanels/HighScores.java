package views.menu.components.middlePanels;

import model.highScore.RankingModel;
import views.GameColors;
import views.PACMANGame;

import javax.swing.*;
import java.awt.*;
import java.io.File;

public class HighScores extends JPanel {

    public static RankingModel rankingModel;
    public static JList ranking;

    public HighScores(int width, int height, PACMANGame pacmanGameFrame) {
        this.setBackground(Color.BLACK);
        Font currentButterbelly = new Font("Butterbelly", Font.PLAIN, 30);
        this.setLayout(new GridBagLayout());

        String rankingText = "position --------- score -------- nickname --------- time";
        JLabel rankingTextLabel = new JLabel(rankingText);
        rankingTextLabel.setFont(currentButterbelly);

        rankingModel = new RankingModel();
        File file = new File("Project2/ranking.txt");
        if (file.length() != 0) {
            rankingModel.loadFromFile();
        }
        ranking = new JList(rankingModel);
        this.add(ranking);
        ranking.setFont(currentButterbelly);
        JScrollPane scrollPane = new JScrollPane(ranking);


        GridBagConstraints gbc = new GridBagConstraints();

        gbc.gridx = 0;
        gbc.gridy = 0;
        this.add(rankingTextLabel, gbc);

        gbc.gridy = 1;
        this.add(scrollPane, gbc);
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

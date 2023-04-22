package swing.menuPanels;

import swing.MouseMode;
import swing.menuPanels.lowerPanels.LowerMenuPanel;
import swing.menuPanels.middlePanels.MiddleTextPanel;
import swing.menuPanels.upperPanels.UpperMenuButtonsPanel;
import swing.menuPanels.upperPanels.UpperMenuHeadingPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MenuStartPanel extends JPanel {

    private MouseMode mouseMode;

    Color pink = new Color(0xFD66C3);
    Color blue = new Color(0x00FDFE);

    public MenuStartPanel(int width, int height) {


        this.setLayout(new BoxLayout(this, 1)); // 1 = według osi Y

        UpperMenuHeadingPanel upperMenuHeadingPanel = new UpperMenuHeadingPanel(width, (int) (height * 0.27));
        UpperMenuButtonsPanel upperMenuButtonsPanel = new UpperMenuButtonsPanel(width, (int) (height * 0.08), this);
        MiddleTextPanel defaultTextPanel = new MiddleTextPanel(width, (int) (height * 0.5));
        LowerMenuPanel lowerMenuPanel = new LowerMenuPanel(width, (int) (height * 0.15));

        JSeparator separator = new JSeparator(SwingConstants.HORIZONTAL);
        defineJSeparator(separator, width);

        this.add(upperMenuHeadingPanel);
        this.add(upperMenuButtonsPanel);
        this.add(defaultTextPanel);
        this.add(separator);
        this.add(lowerMenuPanel);

        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);

                if (isMouseMode(swing.MouseMode.CLICK_NEW_GAME)) {

                } else if (isMouseMode(MouseMode.CLICK_HIGH_SCORES)) {

                } else if (isMouseMode(MouseMode.CLICK_EXIT)) {

                } else if (isMouseMode(MouseMode.DEFAULT)) {

                } else {
                    System.out.println("Kliknięto: " + e.getX() + " " + e.getY());
                }
            }
        });

    }

    public void defineJSeparator(JSeparator jSeparator, int width) {
        jSeparator.setPreferredSize(new Dimension(width, 5));
        jSeparator.setForeground(Color.WHITE);
    }

    private boolean isMouseMode(MouseMode mode) {
        return mode == this.mouseMode;
    }

    public void setMouseMode(MouseMode mode, UpperMenuButtonsPanel upperMenuButtonsPanel) {
        mouseMode = mode;
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        switch (mouseMode) {
            case CLICK_NEW_GAME -> {
                upperMenuButtonsPanel.new_game.setBackground(blue);

                upperMenuButtonsPanel.high_scores.setBackground(pink);
                upperMenuButtonsPanel.exit_game.setBackground(pink);
            }
            case CLICK_HIGH_SCORES -> {
                upperMenuButtonsPanel.high_scores.setBackground(blue);
                upperMenuButtonsPanel.new_game.setBackground(pink);
                upperMenuButtonsPanel.exit_game.setBackground(pink);

            }
            case CLICK_EXIT -> {
                upperMenuButtonsPanel.exit_game.setBackground(blue);
                upperMenuButtonsPanel.new_game.setBackground(pink);
                upperMenuButtonsPanel.high_scores.setBackground(pink);
            }
            case DEFAULT -> {
                upperMenuButtonsPanel.new_game.setBackground(pink);
                upperMenuButtonsPanel.high_scores.setBackground(pink);
                upperMenuButtonsPanel.exit_game.setBackground(pink);
            }
        }
    }


}

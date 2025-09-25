package carreravisual;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class RaceTrackPanel extends JPanel {
    private List<MiniRunner> runners;

    public RaceTrackPanel(List<MiniRunner> runners) {
        this.runners = runners;
        setPreferredSize(new Dimension(600, runners.size() * 60));
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        for (int i = 0; i < runners.size(); i++) {
            MiniRunner runner = runners.get(i);
            int y = i * 60 + 20;

            // Pista
            g.setColor(Color.LIGHT_GRAY);
            g.fillRect(10, y, 580, 30);

            // Corredor (círculo azul)
            g.setColor(Color.BLUE);
            g.fillOval(10 + runner.getPosition(), y, 30, 30);

            // Nombre corredor
            g.setColor(Color.BLACK);
            g.drawString(runner.getName(), 10, y - 5);
        }
    }
}

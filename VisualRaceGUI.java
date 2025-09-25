package carreravisual;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class VisualRaceGUI extends JFrame {
    private RaceTrackPanel trackPanel;
    private List<MiniRunner> runners;
    private List<RunnerThread> threads;
    private JButton startBtn;

    public VisualRaceGUI() {
        setTitle("Carrera de prueba");
        setSize(650, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        runners = new ArrayList<>();
        runners.add(new MiniRunner("Corredor 1"));
        runners.add(new MiniRunner("Corredor 2"));
        runners.add(new MiniRunner("Corredor 3"));
        runners.add(new MiniRunner("Corredor 4"));

        trackPanel = new RaceTrackPanel(runners);
        add(trackPanel, BorderLayout.CENTER);

        startBtn = new JButton("Iniciar");
        add(startBtn, BorderLayout.SOUTH);

        startBtn.addActionListener(e -> startRace());

        setVisible(true);
    }

    private void startRace() {
        threads = new ArrayList<>();
        for (MiniRunner runner : runners) {
            runner.setPosition(0);
            RunnerThread thread = new RunnerThread(runner, trackPanel);
            threads.add(thread);
            thread.start();
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(VisualRaceGUI::new);
    }
}







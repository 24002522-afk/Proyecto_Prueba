package carreravisual;

public class RunnerThread extends Thread {
    private MiniRunner runner;
    private RaceTrackPanel trackPanel;
    private int trackLength = 550;

    public RunnerThread(MiniRunner runner, RaceTrackPanel trackPanel) {
        this.runner = runner;
        this.trackPanel = trackPanel;
    }

    @Override
    public void run() {
        int steps = 100;
        int sleepTime = (runner.getSpeed() * 1000) / steps;

        for (int i = 1; i <= steps; i++) {
            runner.setPosition(i * trackLength / steps);
            trackPanel.repaint();

            try {
                Thread.sleep(sleepTime);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

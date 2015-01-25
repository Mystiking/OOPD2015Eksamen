import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class SimulationFrame extends JFrame {
    private static final double TIME_STEP = 0.25;

    private Simulator simulator;

    private ArrayList<Vector> positions = new ArrayList<Vector>();
    private ArrayList<Vector> velocities = new ArrayList<Vector>();
    private ArrayList<Vector> accelerations = new ArrayList<Vector>();

    private Vector position;
    private Vector velocity;

    private Timer t;

    private JButton start;
    private JButton reset;

    private int time;
    private int counter = 0;

    private boolean alreadyStarted = false;

    /**
     * The timer-listener controls what action is performed during each time step.
     */
    class TimerListener implements ActionListener {
        public TimerListener(){}

        public void actionPerformed(ActionEvent e)
        {
            if (counter == time){
                t.stop();
            }
            counter++;
            simulator.updatePositions();
        }

    }

    class StartListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            if (alreadyStarted) {
                t.restart();
            } else {
                t.start();
            }
            if(e.getSource() == start) {
                start.setVisible(false);
            }
            add(reset, BorderLayout.SOUTH);
        }
    }

    class ResetListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            simulator.setAll(positions, velocities, accelerations, position, velocity);
            counter = 0;
            alreadyStarted = true;

            if(e.getSource() == start) {
                start.setVisible(false);
            }
            t.stop();
            repaint();
            start.setVisible(true);

        }
    }

    /**
     * Constructor: creates a frame for the viewer to see.
     *
     * @param time the amount of time the program will run.
     */
    public SimulationFrame(int time){
        this.time = time * 4;
        Body_Loader body_loader = new Body_Loader();
        for (Body body : body_loader.getBodies()){
            positions.add(body.getPosition());
            velocities.add(body.getVelocity());
            accelerations.add(body.getAcceleration());
        }
        position = body_loader.getSun().getPosition();
        velocity = body_loader.getSun().getVelocity();

        this.simulator = new Simulator(body_loader.getBodies(), body_loader.getSun(), TIME_STEP);

        ActionListener listener = new TimerListener();
        t = new Timer((int) (simulator.getTime_step() * 10), listener);
        this.add(simulator);

        start = new JButton("Start");
        reset = new JButton("Reset");

        ActionListener startListener = new StartListener();
        ActionListener resetListener = new ResetListener();
        start.addActionListener(startListener);
        reset.addActionListener(resetListener);

        add(start, BorderLayout.SOUTH);

        this.setSize(720, 720);
        this.setResizable(false);

    }
}

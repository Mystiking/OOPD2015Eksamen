import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        String input = JOptionPane.showInputDialog("Enter the amount of time you wish to run the program (in days)");

        JFrame frame1 = new ComputationFrame();
        frame1.setTitle("The differences between NASAs coordinates and the computed coordinates");
        frame1.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame1.setVisible(true);

        JFrame frame = new SimulationFrame(Integer.parseInt(input));
        frame.setTitle("The Solar System - A Simulation");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setVisible(true);
    }
}

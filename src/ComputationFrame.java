import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class ComputationFrame extends JFrame {
    private static final double TIME_STEP = 1;

    private Computation computation;

    private JTable jtable;

    public ComputationFrame(){
        Body_Loader body_loader = new Body_Loader();
        computation = new Computation(TIME_STEP, body_loader.getSun() ,body_loader.getBodies());
        computation.computePositions();
        ArrayList<String[]> rows = computation.getRows();
        ArrayList<String> dates = computation.getBodies().get(0).getDates();
        ArrayList<String> shortDates = new ArrayList<String>();
        for (String date : dates){
            String[] newDate = date.split(" ");
            String shortDate = newDate[1].trim();
            shortDates.add(shortDate);
        }
        String[] columns = {"Planets \\ Dates", shortDates.get(0), shortDates.get(1), shortDates.get(2),
                            shortDates.get(3), shortDates.get(4), shortDates.get(5), shortDates.get(6),
                            shortDates.get(7), shortDates.get(8), shortDates.get(9), shortDates.get(10),
                            shortDates.get(11), shortDates.get(12)};
        String[][] data = {rows.get(0), rows.get(1), rows.get(2), rows.get(3),
                           rows.get(4), rows.get(5), rows.get(6), rows.get(7),
                           rows.get(8), rows.get(9)};
        jtable = new JTable(data, columns){
            public boolean isCellEditable(int data, int column){
                return false;
            }
        };
        jtable.setPreferredScrollableViewportSize(new Dimension(1000, 30));
        JScrollPane jScrollPane = new JScrollPane(jtable);
        add(jScrollPane);
        setSize(1300, 250);
        setResizable(false);
    }
}

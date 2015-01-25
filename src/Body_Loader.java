import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Body_Loader {
    private static final double G_SUN = 2.959122082322128E-4;

    private static final String MERCURY = "./data/Mercury.txt";
    private static final String VENUS = "./data/Venus.txt";
    private static final String EARTH = "./data/Earth.txt";
    private static final String MARS = "./data/Mars.txt";
    private static final String JUPITER = "./data/JUPITER.txt";
    private static final String SATURN = "./data/Saturn.txt";
    private static final String URANUS = "./data/Uranus.txt";
    private static final String NEPTUNE = "./data/Neptune.txt";
    private static final String PLUTO = "./data/Pluto.txt";
    private static final String SUN = "./data/Sun.txt";

    private ArrayList<Body> bodies;
    private Body sun;

    /**
     * Constructor: constructs a planet loader, that loads the sun and all the planets.
     */
    public Body_Loader(){
        loadSun(SUN);
        this.bodies = new ArrayList<Body>();
        loadPlanet(MERCURY);
        loadPlanet(VENUS);
        loadPlanet(EARTH);
        loadPlanet(MARS);
        loadPlanet(JUPITER);
        loadPlanet(SATURN);
        loadPlanet(URANUS);
        loadPlanet(NEPTUNE);
        loadPlanet(PLUTO);
    }

    /**
     * Loads a planet and adds it to the list of planets called planets.
     *
     * @param filename the filename of the planets data file.
     */
    public void loadPlanet(String filename){
        try{

            ArrayList<Vector> initialPositions = new ArrayList<Vector>();
            ArrayList<String> dates = new ArrayList<String>();

            Scanner scanner = new Scanner(new File(filename));
            String firstLine = scanner.nextLine();
            String[] firstLineSplit = firstLine.split(",");
            String date = firstLineSplit[1].trim();
            Double x = Double.parseDouble(firstLineSplit[2].trim());
            Double y = Double.parseDouble(firstLineSplit[3].trim());
            Double z = Double.parseDouble(firstLineSplit[4].trim());
            Vector position = new Vector(x, y, z);
            initialPositions.add(position);
            dates.add(date);

            Double v_x = Double.parseDouble(firstLineSplit[5].trim());
            Double v_y = Double.parseDouble(firstLineSplit[6].trim());
            Double v_z = Double.parseDouble(firstLineSplit[7].trim());
            Vector velocity = new Vector(v_x, v_y, v_z);

            Vector r_i_to_sun = position.sub(this.sun.getPosition());
            double r_pow_3 = Math.pow(r_i_to_sun.length(), 3);
            double mulConstant = (G_SUN/r_pow_3);
            Vector acceleration = r_i_to_sun.mul(mulConstant).mul(-1);

            Body currentBody = new Body(position, velocity, acceleration);

            while (scanner.hasNext()) {
                String firstLine_temp = scanner.nextLine();
                String[] firstLineSplit_temp = firstLine_temp.split(",");
                String date_temp = firstLineSplit_temp[1].trim();
                Double x_temp = Double.parseDouble(firstLineSplit_temp[2].trim());
                Double y_temp = Double.parseDouble(firstLineSplit_temp[3].trim());
                Double z_temp = Double.parseDouble(firstLineSplit_temp[4].trim());
                Vector position_temp = new Vector(x_temp, y_temp, z_temp);
                initialPositions.add(position_temp);
                dates.add(date_temp);
            }

            currentBody.addInitialPositions(initialPositions);
            currentBody.addDates(dates);
            bodies.add(currentBody);
            scanner.close();
        } catch (IOException e){
            System.out.println(e);
        }
    }

    /**
     * Loads the sun of the universe.
     *
     * @param filename the filename of the suns data file.
     */
    public void loadSun(String filename) {
        try {
            ArrayList<Vector> initialPositions = new ArrayList<Vector>();
            ArrayList<String> dates = new ArrayList<String>();

            Scanner scanner = new Scanner(new File(filename));
            String firstLine = scanner.nextLine();
            String[] firstLineSplit = firstLine.split(",");
            String date = firstLineSplit[1].trim();
            dates.add(date);
            Double x = Double.parseDouble(firstLineSplit[2].trim());
            Double y = Double.parseDouble(firstLineSplit[3].trim());
            Double z = Double.parseDouble(firstLineSplit[4].trim());
            Vector position = new Vector(x, y, z);

            Double v_x = Double.parseDouble(firstLineSplit[5].trim());
            Double v_y = Double.parseDouble(firstLineSplit[6].trim());
            Double v_z = Double.parseDouble(firstLineSplit[7].trim());
            Vector velocity = new Vector(v_x, v_y, v_z);

            Vector acceleration = new Vector(0, 0, 0);

            Body currentBody = new Body(position, velocity, acceleration);

            while (scanner.hasNextLine()) {
                String firstLine_temp = scanner.nextLine();
                String[] firstLineSplit_temp = firstLine_temp.split(",");
                String date_temp = firstLineSplit_temp[1].trim();
                dates.add(date_temp);
                Double x_temp = Double.parseDouble(firstLineSplit_temp[2].trim());
                Double y_temp = Double.parseDouble(firstLineSplit_temp[3].trim());
                Double z_temp = Double.parseDouble(firstLineSplit_temp[4].trim());
                Vector position_temp = new Vector(x_temp, y_temp, z_temp);
                initialPositions.add(position_temp);
            }

            currentBody.addInitialPositions(initialPositions);
            currentBody.addDates(dates);
            this.sun = currentBody;
            scanner.close();
        } catch (IOException e) {
            System.out.println(e);
        }

    }

    public ArrayList<Body> getBodies(){
        return this.bodies;
    }

    public Body getSun(){
        return this.sun;
    }
}

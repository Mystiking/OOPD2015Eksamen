import java.util.ArrayList;

public class Computation {
    private ArrayList<String> names;
    private ArrayList<String[]> rows;

    private Body sun;
    private ArrayList<Body> bodies;
    private double time_step;

    private int positionCounter;
    private int month;
    private int day;

    private boolean isNewYear;
    private boolean isNewMonth;

    public Computation(double time_step, Body sun, ArrayList<Body> bodies){
        this.sun = sun;
        this.bodies = bodies;
        this.time_step = time_step;

        this.rows = new ArrayList<String[]>();
        this.names = new ArrayList<String>();
        this.names.add("Mercury");
        this.names.add("Venus");
        this.names.add("Earth");
        this.names.add("Mars");
        this.names.add("Jupiter");
        this.names.add("Saturn");
        this.names.add("Uranus");
        this.names.add("Neptune");
        this.names.add("Pluto");

        this.positionCounter = 0;
        this.day = 1;
        this.month = 1;

        this.isNewYear = false;
        this.isNewMonth = true;
    }

    /**
     * Computes the positions for a body during 12 months (time interval of 30 days).
     */
    public void computePosition(Body body, String name){
        ArrayList<Vector> NASAPositions = body.getInitialPositions();
        ArrayList<String> differences = new ArrayList<String>();
        Body sun = this.sun;
        while (!this.isNewYear) {
            if (this.isNewMonth) {
                Vector actualPos = body.getPosition();
                Vector expectedPos = NASAPositions.get(this.positionCounter);
                Vector difference = actualPos.sub(expectedPos);
                double length = difference.length();
                double lengthRounded = trim(length);
                String dif = Double.toString(lengthRounded);
                differences.add(dif);
                this.day = 1;
                this.month++;
                this.positionCounter++;
                this.positionCounter %= 12;
            }
            this.isNewMonth = 0 == this.day % 30;
            this.month %= 13;
            this.isNewYear = 1 == this.month;
            body.update(this.time_step, sun);
            sun.update(this.time_step);
            this.day++;
        }
        String allDifferences = name;
        for (String dif : differences){
            allDifferences += " " + dif;
        }
        String[] row = allDifferences.split(" ");
        this.rows.add(row);
        this.positionCounter = 0;
        this.day = 1;
        this.month = 1;
        this.isNewMonth = true;
        this.isNewYear = false;
    }

    /**
     * Computes the positions for a body during 12 months (time interval of 30 days).
     */
    public void computePositionSun(Body sun, String name){
        ArrayList<Vector> NASAPositions = sun.getInitialPositions();
        ArrayList<String> differences = new ArrayList<String>();
        while (!this.isNewYear) {
            if (this.isNewMonth) {
                Vector actualPos = sun.getPosition();
                Vector expectedPos = NASAPositions.get(this.positionCounter);
                Vector difference = actualPos.sub(expectedPos);
                double length = difference.length();
                double lengthRounded = trim(length);
                String dif = Double.toString(lengthRounded);
                differences.add(dif);
                this.day = 1;
                this.month++;
                this.positionCounter++;
                this.positionCounter %= 12;
            }
            this.isNewMonth = 0 == this.day % 30;
            this.month %= 13;
            this.isNewYear = 1 == this.month;
            sun.update(this.time_step);
            this.day++;
        }
        String allDifferences = name;
        for (String dif : differences){
            allDifferences += " " + dif;
        }
        String[] row = allDifferences.split(" ");
        this.rows.add(row);
        this.positionCounter = 0;
        this.day = 1;
        this.month = 1;
        this.isNewMonth = true;
        this.isNewYear = false;
    }

    /**
     * Updates the positions of all bodies.
     */
    public void computePositions(){
        int nameCounter = 0;
        ArrayList<Body> bodies = this.bodies;
        Body sun = this.sun;
        for (Body body : bodies){
            computePosition(body, this.names.get(nameCounter));
            nameCounter++;
        }
        computePositionSun(sun, "Sun");
    }

    public ArrayList<String[]> getRows(){
        return this.rows;
    }

    public ArrayList<Body> getBodies() { return this.bodies; }

    public Body getSun(){
        return this.sun;
    }


    /**
     * Trims the numbers, by deleting some of the ciphers.
     *
     * @param amount the amount to be trimmed.
     * @return the trimmed amount.
     */
    public double trim(double amount){
        String temp = Double.toString(amount);
        if (amount < 1E-3 && amount != 0) {
            String potency = temp.substring(temp.length() - 3, temp.length());
            temp = temp.substring(0, 6) + potency;
            return  Double.parseDouble(temp);
        } else if (amount != 0) {
            temp = temp.substring(0, 6);
            return Double.parseDouble(temp);
        } else {
            return amount;
        }
    }
}

import java.util.ArrayList;

public class Body {
    private static final double G_SUN = 2.959122082322128E-4;

    private Vector position;
    private Vector velocity;
    private Vector acceleration;

    private ArrayList<Vector> initialPositions;
    private ArrayList<String> dates;

    /**
     * Constructor: Creates a body object defined by its initial position,
     * velocity and acceleration.
     *
     * @param position the initial position of the body.
     * @param velocity the initial velocity of the body.
     * @param acceleration the initial acceleration of the body.
     */
    public Body(Vector position, Vector velocity, Vector acceleration){
        this.position = position;
        this.velocity = velocity;
        this.acceleration = acceleration;
    }

    /**
     * Adds the planets positions from 2013 - 2014 to the body.
     *
     * @param initialPositions the positions.
     */
    public void addInitialPositions(ArrayList<Vector> initialPositions){
        this.initialPositions = initialPositions;
    }

    /**1472365*
     * Adds the dates of all observations to the body.
     *
     * @param dates the dates.
     */
    public void addDates(ArrayList<String> dates){
        this.dates = dates;
    }

    /**
     * Updates the position, velocity and acceleration of the body.
     *
     * @param time_step the amount of time between each movement.
     * @param sun the sun which it is assigned to.
     */
    public void update(double time_step, Body sun){
        Vector r_i_to_sun = position.sub(sun.getPosition());
        double r_pow_3 = Math.pow(r_i_to_sun.length(), 3);
        double mulConstant = - (G_SUN/r_pow_3);
        Vector acceleration = r_i_to_sun.mul(mulConstant);

        this.position = this.position.add((this.velocity.mul(time_step)));
        this.velocity = this.velocity.add((this.acceleration.mul(time_step)));
        this.acceleration = acceleration;
    }

    /**
     * Updates the position and velocity of the body.
     * Created to simply update the suns position and velocity.
     *
     * @param time_step the amount of time between each movement.
     */
    public void update(double time_step){
        this.position = this.position.add((this.velocity.mul(time_step)));
        this.velocity = this.velocity.add((this.acceleration.mul(time_step)));
    }

    public ArrayList<Vector> getInitialPositions() { return this.initialPositions; }

    public ArrayList<String> getDates() { return this.dates; }

    public Vector getPosition(){
        return this.position;
    }

    public Vector getVelocity() { return this.velocity; }

    public Vector getAcceleration() { return this.acceleration; }

    public void setPosition(Vector position){
        this.position = position;
    }

    public void setVelocity(Vector velocity){
        this.velocity = velocity;
    }

    public void setAcceleration(Vector acceleration){
        this.acceleration = acceleration;
    }

}

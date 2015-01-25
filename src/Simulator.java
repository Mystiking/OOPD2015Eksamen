import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class Simulator extends JComponent {
    private static final int SCALE = 11;
    private static final int SIZE = 10;
    private static final int SHIFTING = 370;

    private ArrayList<Body> bodies;
    private Body sun;

    private BufferedImage mercury_texture;
    private BufferedImage venus_texture;
    private BufferedImage earth_texture;
    private BufferedImage mars_texture;
    private BufferedImage jupiter_texture;
    private BufferedImage saturn_texture;
    private BufferedImage uranus_texture;
    private BufferedImage neptune_texture;
    private BufferedImage pluto_texture;
    private BufferedImage background_texture;

    private TexturePaint tp_background;
    private TexturePaint tp_mercury;
    private TexturePaint tp_venus;
    private TexturePaint tp_earth;
    private TexturePaint tp_mars;
    private TexturePaint tp_jupiter;
    private TexturePaint tp_saturn;
    private TexturePaint tp_uranus;
    private TexturePaint tp_neptune;
    private TexturePaint tp_pluto;

    private double time_step;

    /**
     * Constructor: creates a simulation of the universe and it's 8(9 - counting pluto!) planets and the sun.
     *
     * @param bodies an arrayList of planets.
     * @param sun the sun
     */
    public Simulator(ArrayList<Body> bodies, Body sun, double time_step){
        this.bodies = bodies;
        this.sun = sun;
        this.time_step = time_step;
        loadImage();
    }


    /**
     * Updates the positions of all planets (and the sun).
     */
    public void updatePositions(){
        for (Body body : bodies){
            body.update(this.time_step, this.sun);
        }
        this.sun.update(this.time_step);
        repaint();
    }

    /**
     * Sets the positions, velocities and accelerations of all bodies. Only
     * used for the "reset" option, in the SimulationFrame class.
     *
     * @param positions the positions to be set for the bodies.
     * @param velocities the velocities to be set for the bodies.
     * @param accelerations the accelerations to be set for the bodies.
     * @param position the position of the sun.
     * @param velocity the velocity of the sun.
     */
    public void setAll(ArrayList<Vector> positions, ArrayList<Vector> velocities,
                       ArrayList<Vector> accelerations,Vector position, Vector velocity){
        for (int i = 0; i < bodies.size(); i++){
            bodies.get(i).setPosition(positions.get(i));
            bodies.get(i).setVelocity(velocities.get(i));
            bodies.get(i).setAcceleration(accelerations.get(i));
        }
        sun.setPosition(position);
        sun.setVelocity(velocity);
    }

    public ArrayList<Body> getBodies()
    {
        return this.bodies;
    }

    /**
     * Paints the simulation of the solar system.
     *
     * @param g the graphics component.
     */
    public void paintComponent(Graphics g){
        Graphics2D g2D = (Graphics2D) g;
        // Adds a white background
        tp_background = new TexturePaint(background_texture, new Rectangle(0, 0, 1000, 1000));
        g2D.setPaint(tp_background);
        g2D.fillRect(0, 0, 1000, 1000);

        // Paints the sun
        g2D.setPaint(Color.YELLOW);
        double sun_x = sun.getPosition().getX() * SCALE;
        double sun_y = sun.getPosition().getY() * SCALE;
        g2D.fillOval((int)(sun_x)  + SHIFTING, (int) (sun_y)  + SHIFTING, SIZE, SIZE);

        // Paints mercury
        tp_mercury = new TexturePaint(mercury_texture, new Rectangle(0, 0, SCALE, SCALE));
        g2D.setPaint(tp_mercury);
        Vector mercury = bodies.get(0).getPosition();
        double mercury_x = mercury.getX() * SCALE;
        double mercury_y = mercury.getY() * SCALE;
        g2D.fillOval((int) mercury_x + SHIFTING, (int) mercury_y + SHIFTING, SIZE, SIZE);
        g2D.setPaint(Color.WHITE);
        g2D.drawString("Mercury", (int) mercury_x + SHIFTING - 40, (int) mercury_y + SHIFTING);

        // Paints venus
        tp_venus = new TexturePaint(venus_texture, new Rectangle(0, 0, SCALE, SCALE));
        g2D.setPaint(tp_venus);
        Vector venus = bodies.get(1).getPosition();
        double venus_x = venus.getX() * SCALE;
        double venus_y = venus.getY() * SCALE;
        g2D.fillOval((int) venus_x + SHIFTING, (int) venus_y + SHIFTING, SIZE, SIZE);
        g2D.setPaint(Color.WHITE);
        g2D.drawString("Venus", (int) venus_x + SHIFTING - 40, (int) venus_y + SHIFTING);

        // Paints earth
        tp_earth = new TexturePaint(earth_texture, new Rectangle(0, 0, SCALE, SCALE));
        g2D.setPaint(tp_earth);
        Vector earth = bodies.get(2).getPosition();
        double earth_x = earth.getX() * SCALE;
        double earth_y = earth.getY() * SCALE;
        g2D.fillOval((int) earth_x + SHIFTING, (int) earth_y + SHIFTING, SIZE, SIZE);
        g2D.setPaint(Color.WHITE);
        g2D.drawString("Earth", (int) earth_x + SHIFTING - 40, (int) earth_y + SHIFTING);

        // Paints mars
        tp_mars = new TexturePaint(mars_texture, new Rectangle(0, 0, SCALE, SCALE));
        g2D.setPaint(tp_mars);
        Vector mars = bodies.get(3).getPosition();
        double mars_x = mars.getX() * SCALE;
        double mars_y = mars.getY() * SCALE;
        g2D.fillOval((int) mars_x + SHIFTING, (int) mars_y + SHIFTING, SIZE, SIZE);
        g2D.setPaint(Color.WHITE);
        g2D.drawString("Mars", (int) mars_x + SHIFTING - 40, (int) mars_y + SHIFTING);

        // Paints jupiter
        tp_jupiter = new TexturePaint(jupiter_texture, new Rectangle(0, 0, SCALE*3, SCALE*3));
        g2D.setPaint(tp_jupiter);
        Vector jupiter = bodies.get(4).getPosition();
        double jupiter_x = jupiter.getX() * SCALE;
        double jupiter_y = jupiter.getY() * SCALE;
        g2D.fillOval((int) jupiter_x + SHIFTING, (int) jupiter_y + SHIFTING, SIZE * 3, SIZE * 3);
        g2D.setPaint(Color.WHITE);
        g2D.drawString("Jupiter", (int) jupiter_x + SHIFTING - 40, (int) jupiter_y + SHIFTING);

        // Paints saturn
        tp_saturn = new TexturePaint(saturn_texture, new Rectangle(0, 0, SCALE*2, SCALE*2));
        g2D.setPaint(tp_saturn);
        Vector saturn = bodies.get(5).getPosition();
        double saturn_x = saturn.getX() * SCALE;
        double saturn_y = saturn.getY() * SCALE;
        g2D.fillOval((int) saturn_x + SHIFTING, (int) saturn_y + SHIFTING, SIZE * 2, SIZE * 2);
        g2D.setPaint(Color.WHITE);
        g2D.drawString("Saturn", (int) saturn_x + SHIFTING - 40, (int) saturn_y + SHIFTING);

        // Paints uranus
        tp_uranus = new TexturePaint(uranus_texture, new Rectangle(0, 0, SCALE*2, SCALE*2));
        g2D.setPaint(tp_uranus);
        Vector uranus = bodies.get(6).getPosition();
        double uranus_x = uranus.getX() * SCALE;
        double uranus_y = uranus.getY() * SCALE;
        g2D.fillOval((int) uranus_x + SHIFTING, (int) uranus_y + SHIFTING, SIZE * 2, SIZE * 2);
        g2D.setPaint(Color.WHITE);
        g2D.drawString("Uranus", (int) uranus_x + SHIFTING - 40, (int) uranus_y + SHIFTING);

        // Paints neptune
        tp_neptune = new TexturePaint(neptune_texture, new Rectangle(0, 0, SCALE*2, SCALE*2));
        g2D.setPaint(tp_neptune);
        Vector neptune = bodies.get(7).getPosition();
        double neptune_x = neptune.getX() * SCALE;
        double neptune_y = neptune.getY() * SCALE;
        g2D.fillOval((int) neptune_x + SHIFTING, (int) neptune_y + SHIFTING, SIZE * 2, SIZE * 2);
        g2D.setPaint(Color.WHITE);
        g2D.drawString("Neptune", (int) neptune_x + SHIFTING - 40, (int) neptune_y + SHIFTING);

        // Paints pluto
        tp_pluto = new TexturePaint(pluto_texture, new Rectangle(0, 0, SCALE, SCALE));
        g2D.setPaint(tp_pluto);
        Vector pluto = bodies.get(8).getPosition();
        double pluto_x = pluto.getX() * SCALE;
        double pluto_y = pluto.getY() * SCALE;
        g2D.fillOval((int) pluto_x + SHIFTING, (int) pluto_y + SHIFTING, SIZE, SIZE);
        g2D.setPaint(Color.WHITE);
        g2D.drawString("Pluto", (int) pluto_x + SHIFTING - 40, (int) pluto_y + SHIFTING);
    }

    public double getTime_step(){
        return this.time_step;
    }

    public Body getSun(){
        return  this.sun;
    }

    /**
     * Loads the texture paints used to create the simulation
     */
    private void loadImage()
    {
        try
        {
            mercury_texture = ImageIO.read(new File("./textures/Mercury_texture_1.jpg"));
            venus_texture = ImageIO.read(new File("./textures/Venus_texture_1.jpg"));
            earth_texture = ImageIO.read(new File("./textures/Earth_texture_1.jpg"));
            mars_texture = ImageIO.read(new File("./textures/Mars_texture_1.jpg"));
            jupiter_texture = ImageIO.read(new File("./textures/Jupiter_texture_1.jpg"));
            saturn_texture = ImageIO.read(new File("./textures/Saturn_texture_1.jpg"));
            uranus_texture = ImageIO.read(new File("./textures/Uranus_texture_1.jpg"));
            neptune_texture = ImageIO.read(new File("./textures/Neptune_texture_1.jpg"));
            pluto_texture = ImageIO.read(new File("./textures/Pluto_texture_1.jpg"));
            background_texture = ImageIO.read(new File("./textures/Background_1.jpg"));
        }
        catch (IOException ex)
        {
            System.out.println(ex);
        }
    }
}

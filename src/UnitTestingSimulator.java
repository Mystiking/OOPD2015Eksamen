import java.util.ArrayList;

public class UnitTestingSimulator {
    private static final double G_SUN = 2.959122082322128E-4;

    public static void main(String[] args) {
        Vector sunP = new Vector(-1.284282111761733E-03, -2.455154076901959E-03, -4.207238483437137E-05);
        Vector sunV = new Vector(6.145761414237818E-06, -1.318053417580493E-06, -1.306280382523269E-07);
        Vector sunA = new Vector(0, 0, 0);
        Body sun = new Body(sunP, sunV, sunA);

        Vector position = new Vector(-1.813068419866209E-01,  9.642197733507970E-01, -6.850809238551276E-05);
        Vector velocity = new Vector(-1.718334419397708E-02, -3.209800047122614E-03,  6.736104268755766E-09);

        Vector r_i_to_sun = position.sub(sun.getPosition());
        double r_pow_3 = Math.pow(r_i_to_sun.length(), 3);
        double mulConstant = - (G_SUN/r_pow_3);
        Vector acceleration = r_i_to_sun.mul(mulConstant);

        Body earth = new Body(position, velocity, acceleration);

        ArrayList<Body> bodies = new ArrayList<Body>();
        bodies.add(earth);

        Simulator simulator = new Simulator(bodies, sun, 1);

        System.out.println("Test for the Simulator class!");

        System.out.println("Test 1 for the updatePosition() method");
        System.out.println("simulation.updatePosition() * 31");
        Vector expectedEarth = new Vector(-6.617426385386131E-01,  7.285798316825735E-01, -6.597215993806411E-05);
        Vector expectedSun = new Vector(-1.093056481060748E-03, -2.491459981614031E-03, -4.616125976796566E-05);
        System.out.println("Expected result: \nEarth:\n" + expectedEarth + "\nSun:\n" + expectedSun + "\n");
        System.out.println("Actual result:");
        for (int i = 0; i < 31; i++){
            simulator.updatePositions();
        }
        Vector actualEarth = simulator.getBodies().get(0).getPosition();
        Vector actualSun = simulator.getSun().getPosition();
        System.out.println("Earth:\n" + actualEarth);
        System.out.println("Sun:\n" + actualSun);

        boolean booleanResultEarth = ((expectedEarth.getX() - actualEarth.getX()) < 0.01) &&
                ((expectedEarth.getY() - actualEarth.getY()) < 0.01) &&
                ((expectedEarth.getZ() - actualEarth.getY()) < 0.01);
        boolean booleanResultSun = ((expectedSun.getX() - actualSun.getX()) < 0.01) &&
                ((expectedSun.getY() - actualSun.getY()) < 0.01) &&
                ((expectedSun.getZ() - actualSun.getY()) < 0.01);
        System.out.println("Conclusion: " + (booleanResultEarth && booleanResultSun));
    }
}

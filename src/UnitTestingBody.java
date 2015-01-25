
public class UnitTestingBody {
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

        System.out.println("Tests for the Body class!");

        System.out.println("Test 1 for the update(double, Body) method in the Body class");
        System.out.println("earth.update(1, sun) * 31");
        Vector expectedResult0 = new Vector(-6.617426385386131E-01,  7.285798316825735E-01, -6.597215993806411E-05);
        System.out.println("Expected result: \n" + expectedResult0);
        for (int i = 0; i < 31; i++){
            earth.update(1, sun);
            sun.update(1);
        }
        Vector actualResult0 = earth.getPosition();
        System.out.println("Actual result: \n" + actualResult0);
        boolean booleanResult0 = ((expectedResult0.getX() - actualResult0.getX()) < 0.01) &&
                                 ((expectedResult0.getY() - actualResult0.getY()) < 0.01) &&
                                 ((expectedResult0.getZ() - actualResult0.getY()) < 0.01);
        System.out.println("Conclusion: " + booleanResult0 + "\n");

        sun = new Body(sunP, sunV, sunA);
        System.out.println("Test 1 for the update(double) method in the Body class");
        System.out.println("sun.update(1) * 31");
        Vector expectedResult1 = new Vector(-1.093056481060748E-03, -2.491459981614031E-03, -4.616125976796566E-05);
        System.out.println("Expected result:  \n" + expectedResult1);
        for (int i = 0; i < 31; i++){
            sun.update(1);
        }
        Vector actualResult1 = sun.getPosition();
        System.out.println("Actual result: \n" + actualResult1);
        boolean booleanResult1 = ((expectedResult1.getX() - actualResult1.getX()) < 0.01) &&
                                 ((expectedResult1.getY() - actualResult1.getY()) < 0.01) &&
                                 ((expectedResult1.getZ() - actualResult1.getY()) < 0.01);
        System.out.println("Conclusion: " + booleanResult1);

    }
}

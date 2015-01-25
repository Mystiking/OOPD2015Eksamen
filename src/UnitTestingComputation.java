import java.util.ArrayList;

public class UnitTestingComputation {
    public static void main(String[] args) {
        Body_Loader body_loader = new Body_Loader();
        ArrayList<Body> bodies = body_loader.getBodies();
        Body sun = body_loader.getSun();
        Body earth = bodies.get(2);
        Computation computation = new Computation(1, sun, bodies);
        System.out.println("Tests for the Computation class!");

        System.out.println("Test 1 for the computePosition(Body, String) method in the computation class");
        System.out.println("computePosition(Earth, \"earth\"), calculating the difference between the computed and given coordinates");
        computation.computePosition(earth, "Earth");
        System.out.println("Computation: " + computation.getRows().get(0)[2]);
        boolean result0 = Double.parseDouble(computation.getRows().get(0)[2]) < 0.02;
        System.out.println("Verdict: " + result0);
        System.out.println("Because of the imprecision in the calculations, the result is : " + result0 + "\n");

        System.out.println("Test 1 for the computePositionSun(Body, String) method in the computation class");
        System.out.println("computePosition(sun, \"Sun\"), calculating the difference between the computed and given coordinates\")");
        computation.computePositionSun(sun, "Sun");
        System.out.println("Computation: " + computation.getRows().get(1)[2]);
        boolean result1 = Double.parseDouble(computation.getRows().get(1)[2]) < 0.02;
        System.out.println("Verdict: " + result1);
        System.out.println("Because of the imprecision in the calculations, the result is : " + result0 + "\n");

        System.out.println("Test 1 for the trim(double) method in the computation class");
        System.out.println("trim(0.000123456)");
        double expectedResult2 = 1.2345E-4;
        System.out.println("Expected result: " + expectedResult2);
        double result2 = computation.trim(0.000123456);
        System.out.println("Actual result: " + result2);
        boolean conclusion0 = (expectedResult2 - result2) < 0.00001;
        System.out.println("Conclusion: " + conclusion0 + "\n");

        System.out.println("Test 2 for the trim(double) method in the computation class");
        System.out.println("trim(0.123456)");
        double expectedResult3 = 0.1234;
        System.out.println("Expected result: " + expectedResult3);
        double result3 = computation.trim(0.123456);
        System.out.println("Actual result: " + result3);
        boolean conclusion1 = (expectedResult3 - result3) < 0.00001;
        System.out.println("Conclusion: " + conclusion1 + "\n");

        System.out.println("Test 3 for the trim(double) method in the computation class");
        System.out.println("trim(0)");
        double expectedResult4 = 0;
        System.out.println("Expected result: " + expectedResult4);
        double result4 = computation.trim(0);
        System.out.println("Actual result: " + result4);
        boolean conclusion2 = (expectedResult4 - result4) < 0.00001;
        System.out.println("Conclusion: " + conclusion2 + "\n");

    }
}

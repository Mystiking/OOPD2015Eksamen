import java.util.ArrayList;

public class UnitTestingBody_Loader {
    public static void main(String[] args) {
        Body_Loader body_loader = new Body_Loader();
        ArrayList<Body> bodies = body_loader.getBodies();
        Body sun = body_loader.getSun();

        System.out.println("Tests for the Body_Loader class!");

        System.out.println("Test 1 for the loadPlanet(String) method");
        System.out.println("Tests if all nine planets have been loaded");
        System.out.println("Expected result: " + 9);
        System.out.println("Actual result: " + bodies.size());
        System.out.println("Conclusion: " + (9 == bodies.size()) + "\n");

        System.out.println("Test 2 for the loadPlanet(String) method");
        System.out.println("Tests if all initial positions have been loaded for one of the planets");
        System.out.println("Expected result: " + 13);
        System.out.println("Actual result: " + bodies.get(2).getDates().size());
        System.out.println("Conclusion: " + (bodies.get(2).getDates().size() == 13) + "\n");

        System.out.println("Test 1 for the loadSun(String) method");
        System.out.println("Tests if the sun have been loaded");
        System.out.println("Expected result: sun != null");
        System.out.println("Actual result: " + sun);
        System.out.println("Conclusion: " + (sun != null) + "\n");

        System.out.println("Test 2 for the loadSun(String) method");
        System.out.println("Tests if all initial positions have been loaded for the sun");
        System.out.println("Expected result: " + 13);
        System.out.println("Actual result: " + sun.getDates().size());
        System.out.println("Conclusion: " + (sun.getDates().size() == 13));
    }
}

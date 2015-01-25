
public class UnitTestingVector {
    public static void main(String[] args) {
        Vector test0 = new Vector(1, 1, 1);
        Vector test1 = test0;
        Vector test2 = new Vector(1, 2, 3);

        double amount0 = 1;
        double amount1 = -1;

        System.out.println("Tests for the add(vector) method!");

        System.out.println("Test 1 for the add(vector) method in the vector class");
        System.out.println("test0 + test1");
        Vector expectedResult0 = new Vector(2, 2, 2);
        System.out.println("Expected result: \n" + expectedResult0.toString());
        Vector actualResult0 = test0.add(test1);
        System.out.println("Actual result: \n" + actualResult0.toString());
        boolean booleanResult0 = expectedResult0.equals(actualResult0);
        System.out.println("Conclusion : " + booleanResult0 + "\n");

        System.out.println("Test 2 for the add(vector) method in the vector class");
        System.out.println("test0 + test2");
        Vector expectedResult1 = new Vector(2, 3, 4);
        System.out.println("Expected result: \n" + expectedResult1.toString());
        Vector actualResult1 = test0.add(test2);
        System.out.println("Actual result: \n" + actualResult1.toString() + "\n");
        boolean booleanResult1 = expectedResult1.equals(actualResult1);
        System.out.println("Conclusion: " + booleanResult1 + "\n");

        System.out.println("Tests for the mul(double) method!");

        System.out.println("Test 1 for the mul(double) method in the vector class");
        System.out.println("test2 * amount0");
        Vector expectedResult5 = new Vector(1, 2, 3);
        System.out.println("Expected result: \n" + expectedResult5.toString());
        Vector actualResult5 = test2.mul(amount0);
        System.out.println("Actual amount: \n" + actualResult5.toString());
        boolean booleanResult5 = actualResult5.equals(expectedResult5);
        System.out.println("Conclusion: " + booleanResult5 + "\n");

        System.out.println("Test 2 for the mul(double) method in the vector class");
        System.out.println("test2 * amount1");
        Vector expectedResult6 = new Vector(-1, -2, -3);
        System.out.println("Expected result: \n" + expectedResult6.toString());
        Vector actualResult6 = test2.mul(amount1);
        System.out.println("Actual amount: \n" + actualResult6.toString());
        boolean booleanResult6 = actualResult6.equals(expectedResult6);
        System.out.println("Conclusion: " + booleanResult6 + "\n");

        System.out.println("Tests for the sub(vector) method!");

        System.out.println("Test 1 for the sub(vector) method in the vector class");
        System.out.println("test2 - test0");
        Vector expectedResult7 = new Vector(0, 1, 2);
        System.out.println("Expected result: \n" + expectedResult7.toString());
        Vector actualResult7 = test2.sub(test0);
        System.out.println("Actual amount: \n" + actualResult7.toString());
        boolean booleanResult7 = actualResult7.equals(expectedResult7);
        System.out.println("Conclusion: " + booleanResult7 + "\n");

        System.out.println("Test 2 for the sub(vector) method in the vector class");
        System.out.println("test2 - test2");
        Vector expectedResult8 = new Vector(0, 0, 0);
        System.out.println("Expected result: \n" + expectedResult8.toString());
        Vector actualResult8 = test2.sub(test2);
        System.out.println("Actual amount: \n" + actualResult8.toString());
        boolean booleanResult8 = actualResult8.equals(expectedResult8);
        System.out.println("Conclusion: " + booleanResult8 + "\n");

        System.out.println("Tests the length method!");

        System.out.println("Test 1 for the length method in the vector class");
        System.out.println("test2.length");
        double expectedResult9 = Math.sqrt(14);
        System.out.println("Expected result: \n" + expectedResult9);
        double actualResult9 = test2.length();
        System.out.println("Actual amount: \n" + actualResult9);
        boolean booleanResult9 = Math.abs(actualResult9 - expectedResult9) < .00001;
        System.out.println("Conclusion: " + booleanResult9 + "\n");
    }
}

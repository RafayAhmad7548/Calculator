import javax.swing.JTextField;

public class Test{
    public static void main(String[] args){
        JTextField tf = new JTextField();
        ButtonPanel bp = new ButtonPanel(tf);

        // Test 1
        testEquation(bp, "2+3*4", "14");

        // Test 2
        testEquation(bp, "(2+3)*4", "20");

        // Test 3
        testEquation(bp, "2+3*4-5", "9");

        // Test 4
        testEquation(bp, "(2+3)*(4-5)", "-5");

        // Test 5
        testEquation(bp, "2+3*4/2", "8");

        // Test 6
        testEquation(bp, "2*3+4*5", "26");

        // Test 7
        testEquation(bp, "(2+3)*(4+5)", "45");

        // Test 8
        testEquation(bp, "2*(3+4)*(5+6)", "154");

        // Test 9
        testEquation(bp, "(2+3)*(4+(5*6))", "170");

        // Test 10
        testEquation(bp, "2*3+4*5-6", "20");

        // Test 11
        testEquation(bp, "(2+3)*(4+5)-6", "39");

        // Test 12
        testEquation(bp, "2*(3+4)*(5+6)-7", "147");

        // Test 13
        testEquation(bp, "(2+3)*(4+(5*6))-7", "163");

        // Test 14
        testEquation(bp, "2+3*4-5/2+6", "17.5");

        // Test 15
        testEquation(bp, "2*3+4*5-6/2", "23");

        // Test 16
        testEquation(bp, "(2+3)*(4+5)-6/2", "42");

        // Test 17
        testEquation(bp, "2*(3+4)*(5+6)-7/2", "150.5");

        // Test 18
        testEquation(bp, "(2+3)*(4+(5*6))-7/2", "166.5");

        // Test 19
        testEquation(bp, "2+3*4-5/2+6-7", "10.5");

        // Test 20
        testEquation(bp, "2*3+4*5-6/2+7", "30");
    }

    private static void testEquation(ButtonPanel bp, String expression, String expected) {
        String result = bp.solveEquation(expression);
        boolean passed = expected.equals(result);
        System.out.println(expression + " = " + result + ", expected: " + expected + ", passed: " + passed);
    }
}

import javax.swing.JTextField;

public class Test{
    public static void main(String[] args){
        JTextField tf = new JTextField();
        ButtonPanel bp = new ButtonPanel(tf);

        // Test 1
        String expression1 = "2+3*4";
        String expected1 = "14";
        String result1 = bp.solveEquation(expression1);
        System.out.println(expression1 + " = " + result1 + ", expected: " + expected1);

        // Test 2
        String expression2 = "(2+3)*4";
        String expected2 = "20";
        String result2 = bp.solveEquation(expression2);
        System.out.println(expression2 + " = " + result2 + ", expected: " + expected2);

        // Test 3
        String expression3 = "2+3*4-5";
        String expected3 = "9";
        String result3 = bp.solveEquation(expression3);
        System.out.println(expression3 + " = " + result3 + ", expected: " + expected3);

        // Test 4
        String expression4 = "(2+3)*(4-5)";
        String expected4 = "-5";
        String result4 = bp.solveEquation(expression4);
        System.out.println(expression4 + " = " + result4 + ", expected: " + expected4);

        // Test 5
        String expression5 = "2+3*4/2";
        String expected5 = "8";
        String result5 = bp.solveEquation(expression5);
        System.out.println(expression5 + " = " + result5 + ", expected: " + expected5);

        // Test 6
        String expression6 = "2*3+4*5";
        String expected6 = "26";
        String result6 = bp.solveEquation(expression6);
        System.out.println(expression6 + " = " + result6 + ", expected: " + expected6);

        // Test 7
        String expression7 = "(2+3)*(4+5)";
        String expected7 = "45";
        String result7 = bp.solveEquation(expression7);
        System.out.println(expression7 + " = " + result7 + ", expected: " + expected7);

        // Test 8
        String expression8 = "2*(3+4)*(5+6)";
        String expected8 = "154";
        String result8 = bp.solveEquation(expression8);
        System.out.println(expression8 + " = " + result8 + ", expected: " + expected8);

        // Test 9
        String expression9 = "(2+3)*(4+(5*6))";
        String expected9 = "170";
        String result9 = bp.solveEquation(expression9);
        System.out.println(expression9 + " = " + result9 + ", expected: " + expected9);

        // Test 10
        String expression10 = "2+3*4-5/2";
        String expected10 = "11.5";
        String result10 = bp.solveEquation(expression10);
        System.out.println(expression10 + " = " + result10 + ", expected: " + expected10);

        // Test 11
        String expression11 = "2*3+4*5-6";
        String expected11 = "20";
        String result11 = bp.solveEquation(expression11);
        System.out.println(expression11 + " = " + result11 + ", expected: " + expected11);

        // Test 12
        String expression12 = "(2+3)*(4+5)-6";
        String expected12 = "39";
        String result12 = bp.solveEquation(expression12);
        System.out.println(expression12 + " = " + result12 + ", expected: " + expected12);

        // Test 13
        String expression13 = "2*(3+4)*(5+6)-7";
        String expected13 = "147";
        String result13 = bp.solveEquation(expression13);
        System.out.println(expression13 + " = " + result13 + ", expected: " + expected13);

        // Test 14
        String expression14 = "(2+3)*(4+(5*6))-7";
        String expected14 = "163";
        String result14 = bp.solveEquation(expression14);
        System.out.println(expression14 + " = " + result14 + ", expected: " + expected14);

        // Test 15
        String expression15 = "2+3*4-5/2+6";
        String expected15 = "17.5";
        String result15 = bp.solveEquation(expression15);
        System.out.println(expression15 + " = " + result15 + ", expected: " + expected15);  //fail

        // Test 16
        String expression16 = "2*3+4*5-6/2";
        String expected16 = "23";
        String result16 = bp.solveEquation(expression16);
        System.out.println(expression16 + " = " + result16 + ", expected: " + expected16);

        // Test 17
        String expression17 = "(2+3)*(4+5)-6/2";
        String expected17 = "41.5";
        String result17 = bp.solveEquation(expression17);
        System.out.println(expression17 + " = " + result17 + ", expected: " + expected17);

        // Test 18
        String expression18 = "2*(3+4)*(5+6)-7/2";
        String expected18 = "150.5";
        String result18 = bp.solveEquation(expression18);
        System.out.println(expression18 + " = " + result18 + ", expected: " + expected18);

        // Test 19
        String expression19 = "(2+3)*(4+(5*6))-7/2";
        String expected19 = "166.5";
        String result19 = bp.solveEquation(expression19);
        System.out.println(expression19 + " = " + result19 + ", expected: " + expected19);

        // Test 20
        String expression20 = "2+3*4-5/2+6-7";
        String expected20 = "10.5";
        String result20 = bp.solveEquation(expression20);
        System.out.println(expression20 + " = " + result20 + ", expected: " + expected20);  //fail
    }
}
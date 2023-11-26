public class Test{
    public static void main(String[] args){
        String expression = "1+2";
        expression = expression.replaceFirst(expression.substring(0, 1) + "\\+" + expression.substring(2, 3), "3");
        // expression = expression.replaceFirst(expression.substring(0, 3), "3");
        System.out.println(expression);
    }
}

public class Test{
    public static void main(String[] args){
        String expression = "9.0";
        System.out.println(expression.substring(0, expression.indexOf('.')));
        System.out.println(Integer.valueOf(expression.substring(0, expression.indexOf('.'))));
    }
}

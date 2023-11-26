import javax.swing.*;
import java.awt.*;

public class ButtonPanel extends JPanel{

    Button[] buttons = new Button[20];
    static String expression = "";
    JTextField screen;
    
    public ButtonPanel(JTextField screen){
        this.screen = screen;
        this.setPreferredSize(new Dimension(550, 500));
        this.setLayout(new GridLayout(5, 4, 10, 10));

        for(int i=0;i<=9;i++) buttons[i] = new Button(Integer.toString(i));
        
        buttons[10] = new Button("+");
        buttons[11] = new Button("-");
        buttons[12] = new Button("*");
        buttons[13] = new Button("/");
        buttons[14] = new Button("DEL");
        buttons[15] = new Button("AC");
        buttons[16] = new Button(".");
        buttons[17] = new Button("=");
        buttons[18] = new Button("(");
        buttons[19] = new Button(")");

        this.add(buttons[15]);
        this.add(buttons[14]);
        this.add(buttons[18]);
        this.add(buttons[19]);
        this.add(buttons[7]);
        this.add(buttons[8]);
        this.add(buttons[9]);
        this.add(buttons[10]);
        this.add(buttons[4]);
        this.add(buttons[5]);
        this.add(buttons[6]);
        this.add(buttons[11]);
        this.add(buttons[1]);
        this.add(buttons[2]);
        this.add(buttons[3]);
        this.add(buttons[12]);
        this.add(buttons[16]);
        this.add(buttons[0]);
        this.add(buttons[17]);
        this.add(buttons[13]);

        buttons[0].addActionListener((e) -> {
            expression += "0";
            screen.setText(expression);
        });
        buttons[1].addActionListener((e) -> {
            expression += "1";
            screen.setText(expression);
        });
        buttons[2].addActionListener((e) -> {
            expression += "2";
            screen.setText(expression);
        });
        buttons[3].addActionListener((e) -> {
            expression += "3";
            screen.setText(expression);
            
        });
        buttons[4].addActionListener((e) -> {
            expression += "4";
            screen.setText(expression);
            
        });
        buttons[5].addActionListener((e) -> {
            expression += "5";
            screen.setText(expression);
            
        });
        buttons[6].addActionListener((e) -> {
            expression += "6";
            screen.setText(expression);
            
        });
        buttons[7].addActionListener((e) -> {
            expression += "7";
            screen.setText(expression);
            
        });
        buttons[8].addActionListener((e) -> {
            expression += "8";
            screen.setText(expression);
            
        });
        buttons[9].addActionListener((e) -> {
            expression += "9";
            screen.setText(expression);
            
        });
        buttons[10].addActionListener((e) -> {  // +
            expression += "+";
            screen.setText(expression);
            
        });
        buttons[11].addActionListener((e) -> {  // -
            expression += "-";
            screen.setText(expression);
            
        });
        buttons[12].addActionListener((e) -> {  // *
            expression += "*";
            screen.setText(expression);
            
        });
        buttons[13].addActionListener((e) -> {  // /
            expression += "/";
            screen.setText(expression);
            
        });
        buttons[14].addActionListener((e) -> {  // DEL
            expression = expression.substring(0, expression.length()-1);
            screen.setText(expression);
        });
        buttons[15].addActionListener((e) -> {  // AC
            expression  = "";
            screen.setText(expression);
            
        });
        buttons[16].addActionListener((e) -> {  // .
            expression += ".";
            screen.setText(expression);
            
        });
        buttons[17].addActionListener((e) -> {  // =
            syntaxCheck(expression);
            expression = resolveOperator(expression);
            expression = solveEquation(expression);
            screen.setText(expression);
        });
        buttons[18].addActionListener((e) -> {  // (
            expression += "(";
            screen.setText(expression);
        });
        buttons[19].addActionListener((e) -> {  // )
            expression += ")";
            screen.setText(expression);
        });

    }

    public void syntaxCheck(String expression){
        // first last check
        if(expression.charAt(0) == '*' || expression.charAt(0) == '/' || expression.charAt(0) == ')'){
            expression = "Syntax Error";
            screen.setText(expression);
        }
        // check for two operators in a row
        for(int i=0;i<expression.length()-1;i++){
            if(expression.charAt(i) == '*' || expression.charAt(i) == '/'){
                if(expression.charAt(i+1) == '*' || expression.charAt(i+1) == '/'){
                    expression = "Syntax Error";
                    screen.setText(expression);
                }
            }
        }
        // check brackets
        int open = 0;
        int close = 0;
        for(int i=0;i<expression.length();i++){
            if(expression.charAt(i) == '(') open++;
            else if(expression.charAt(i) == ')') close++;
        }
        if(open != close){
            expression = "Syntax Error";
            screen.setText(expression);
        }
    }

    public String resolveOperator(String expression){
        expression = expression.replaceAll("\\+" + "-", "-").replaceAll("-" + "\\+", "-").replaceAll("--", "\\+").replaceAll("\\+" + "\\+", "+");
        return expression;
    }

    public String solveEquation(String expression){
        expression = solveBrackets(expression);
        return expression;
    }

    public String solveBrackets(String expression){
        int bracketStart = 0;
        int bracketEnd = 0;
        String bracket;
        for(int i=0;i<expression.length();i++){
            if(expression.charAt(i) == '(') bracketStart = i;
            else if(expression.charAt(i) == ')'){
                bracketEnd = i;
                break;
            }
        }
        bracket = expression.substring(bracketStart+1, bracketEnd);
        expression = expression.replace("\\(" + bracket + "\\)", calculate(bracket));
        return expression;
    }

    public String calculate(String expression){
        
        int indexOp;
        char operator = ' ';

        indexOp = expression.indexOf('*');
        if(indexOp == -1) indexOp = expression.indexOf('/');
        if(indexOp == -1) indexOp = expression.indexOf('+');
        if(indexOp == -1) indexOp = expression.indexOf('-');

        if(expression.charAt(indexOp) == '*') operator = '*';
        else if(expression.charAt(indexOp) == '/') operator = '/';
        else if(expression.charAt(indexOp) == '+') operator = '+';
        else if(expression.charAt(indexOp) == '-') operator = '-';
        

        while(indexOp!=-1){

            int start = 0, end = 0;
            for(int i=indexOp-1;i>=0;i--){
                if(expression.charAt(i) == '*' || expression.charAt(i) == '/' || expression.charAt(i) == '+' || expression.charAt(i) == '-'){
                    start = i+1;
                    break;
                }
                else start = 0;
            }
            for(int i=indexOp+1;i<expression.length();i++){
                if(expression.charAt(i) == '*' || expression.charAt(i) == '/' || expression.charAt(i) == '+' || expression.charAt(i) == '-'){
                    end = i;
                    break;
                }
                else end = expression.length();
            }

            if(operator == '*'){
               expression = expression.replaceFirst(expression.substring(start, indexOp) + "\\*" + expression.substring(indexOp+1, end), String.valueOf(Double.valueOf(expression.substring(start, indexOp)) * Double.valueOf(expression.substring(indexOp+1, end)))); 
            }
            else if(operator == '/'){
                expression = expression.replaceFirst(expression.substring(start, end), String.valueOf(Double.valueOf(expression.substring(start, indexOp)) / Double.valueOf(expression.substring(indexOp+1, end)))); 
            }
            else if(operator == '+'){
               expression = expression.replaceFirst(expression.substring(start, indexOp) + "\\+" + expression.substring(indexOp+1, end), String.valueOf(Double.valueOf(expression.substring(start, indexOp)) + Double.valueOf(expression.substring(indexOp+1, end)))); 
            }
            else if(operator == '-'){
                expression = expression.replaceFirst(expression.substring(start, end), String.valueOf(Double.valueOf(expression.substring(start, indexOp)) - Double.valueOf(expression.substring(indexOp+1, end))));
            }

            indexOp = expression.indexOf('*');
            if(indexOp == -1) indexOp = expression.indexOf('/');
            if(indexOp == -1) indexOp = expression.indexOf('+');
            if(indexOp == -1) indexOp = expression.indexOf('-');

            if(indexOp!=-1){
                if(expression.charAt(indexOp) == '*') operator = '*';
                else if(expression.charAt(indexOp) == '/') operator = '/';
                else if(expression.charAt(indexOp) == '+') operator = '+';
                else if(expression.charAt(indexOp) == '-') operator = '-';
            }
        }

        return expression;
    }

    // AC DEL ( ) 
    // 7 8 9 +
    // 4 5 6 -
    // 1 2 3 *
    // . 0 = /

}

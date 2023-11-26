import javax.swing.*;
import java.awt.*;

public class Main{

    JFrame frame;
    JTextField screen;

    public Main(){
        frame = new JFrame();
        screen = new JTextField();

        screen.setPreferredSize(new Dimension(550, 100));
        screen.setEditable(false);
        screen.setFont(new Font("Arial", Font.PLAIN, 50));
        screen.setText(ButtonPanel.expression);

        frame.setSize(600, 700);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new FlowLayout());
        frame.setResizable(false);
        
        frame.add(Box.createRigidArea(new Dimension(600, 10)));
        frame.add(screen);
        frame.add(new ButtonPanel(screen));
        
        frame.setVisible(true);
    }

    public static void main(String[] args){
        new Main();
    }
}


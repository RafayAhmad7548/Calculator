import javax.swing.*;
import java.awt.*;

public class Button extends JButton{
    
    public Button(String text){
        this.setFocusable(false);
        this.setFont(new Font("Arial", Font.PLAIN, 40));
        this.setText(text);
    }

}

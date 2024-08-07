import java.awt.Color;
import javax.swing.JFrame;




public class SignupOne extends JFrame {
    
    SignupOne()
    {
        getContentPane().setBackground(Color.CYAN); //FRAME COLOR

        setSize(850,800);
        setLocation(350,10);
        setVisible(true);
    }



    public static void main(String args[])
    {
        new SignupOne();
    }
}

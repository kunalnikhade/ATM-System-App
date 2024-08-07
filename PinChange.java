import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;


public class PinChange extends JFrame implements ActionListener{

    JButton change,back;
    JPasswordField pin,Repin;
    String pinnum;

    PinChange(String pinnum)
    {
        this.pinnum = pinnum;
        setLayout(null);


        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Icons\\atm.jpg"));
        Image l1 = i1.getImage().getScaledInstance(900,900,Image.SCALE_DEFAULT);
        ImageIcon i3 =new ImageIcon(l1);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);

        JLabel text = new JLabel("Change Your Pin");
        text.setBounds(270,300,700,35);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("Raleway",Font.BOLD,16));
        image.add(text);

        JLabel pintext = new JLabel("New Pin :");
        pintext.setBounds(165,360,180,25);
        pintext.setForeground(Color.WHITE);
        pintext.setFont(new Font("Raleway",Font.BOLD,16));
        image.add(pintext);

        pin = new JPasswordField();
        pin.setFont(new Font("Raleway",Font.BOLD,25));
        pin.setBounds(330,360,180,25);
        image.add(pin);


        JLabel Repintext = new JLabel("Re-Enter New Pin :");
        Repintext.setBounds(165,390,180,25);
        Repintext.setForeground(Color.WHITE);
        Repintext.setFont(new Font("Raleway",Font.BOLD,16));
        image.add(Repintext);

        Repin = new JPasswordField();
        Repin.setFont(new Font("Raleway",Font.BOLD,25));
        Repin.setBounds(330,390,180,25);
        image.add(Repin);


        change = new JButton("CHANGE");
        change.setBounds(355,480,150,30);
        change.addActionListener(this);
        image.add(change);

        back = new JButton("BACK");
        back.setBounds(355,520,150,30);
        back.addActionListener(this);
        image.add(back);


        setSize(900, 900);
        setLocation(350,0);
        getContentPane().setBackground(Color.white);
        setUndecorated(true);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource() == change)
        {
            try
            {
                String npin = pin.getText();
                String rpin = Repin.getText();

                if(!npin.equals(rpin))
                {
                    JOptionPane.showMessageDialog(null,"Entered PIN does not match");
                    return;
                }

                if(npin.equals(""))
                {
                    JOptionPane.showMessageDialog(null,"Please Enter New PIN");
                    return;
                }

                if(rpin.equals(""))
                {
                    JOptionPane.showMessageDialog(null,"Please Re-Enter New PIN");
                    return;
                }


                Connection c = new Connection();

                String query = "UPDATE bank set pin = '"+rpin+"' WHERE pin ='"+pinnum+"'";
                String query1 = "UPDATE login set pinnum = '"+rpin+"' WHERE pinnum ='"+pinnum+"'";
                String query2 = "UPDATE signupthree set pinnum = '"+rpin+"' WHERE pinnum ='"+pinnum+"'";

                c.s.executeUpdate(query);
                c.s.executeUpdate(query1);
                c.s.executeUpdate(query2);

                JOptionPane.showMessageDialog(null,"PIN Changed Successfully");

                setVisible(false);
                new Transaction(rpin).setVisible(true);
            }
            catch(Exception e)
            {
                System.out.println(e);
            }     
        }
        else if(ae.getSource() == back)
        {
            setVisible(false);
            new Transaction(pinnum).setVisible(true);
        }
    }


    public static void main(String args[] )
    {
        new PinChange("");
    }
}

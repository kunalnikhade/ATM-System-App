import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Deposit extends JFrame implements ActionListener{
    
    JTextField amountT;
    JButton Deposit,back;
    String pinnum;


    Deposit(String pinnum)
    {
        this.pinnum = pinnum;
        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Icons\\atm.jpg"));
        Image l = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 =new ImageIcon(l);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);

        JLabel text = new JLabel("Enter The Amount You Want To Deposit");
        text.setBounds(180,300,700,35);
        text.setForeground(Color.white);
        text.setFont(new Font("Raleway",Font.BOLD,16));
        image.add(text);

        amountT = new JTextField();
        amountT.setFont(new Font("Raleway",Font.BOLD,22));
        amountT.setBounds(172,350,320,25);
        image.add(amountT);


        Deposit = new JButton("Deposit");
        Deposit.setBounds(355,485,150,30);
        Deposit.addActionListener(this);
        image.add(Deposit);
        

        back = new JButton("Back");
        back.setBounds(355,520,150,30);
        back.addActionListener(this);
        image.add(back);

        setSize(900,900);
        setLocation(300,0);
        setUndecorated(true);
        setVisible(true);

    }

 
    public void actionPerformed(ActionEvent ae) 
    {
        if(ae.getSource() == Deposit)
        {
            
            String number = amountT.getText();
            LocalDate date = LocalDate.now(); 

            if(number.equals(""))
            {
                JOptionPane.showMessageDialog(null, "Please enter the amount you want to deposit");
                
            }
            else
            {
                try
                {
                    Connection c = new Connection();

                    String query ="INSERT INTO bank values('"+pinnum+"','"+date+"', 'Deposit','"+number+"')";
                    c.s.executeUpdate(query);

                    JOptionPane.showMessageDialog(null,"Rs "+number+" Deposit Successfully");


                    setVisible(false);
                    new Transaction(pinnum).setVisible(true);
                }
                catch(Exception e)
                {
                    System.out.println(e);
                }

            }
        }
        else if(ae.getSource() == back)
        {
            setVisible(false);
            new Transaction(pinnum).setVisible(true);

        }
    }

    public static void main(String args[])
    {
        new Deposit("");
    }
}

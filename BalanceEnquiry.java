import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.ImageIcon;
import javax.swing.JButton;


class BalanceEnquiry extends JFrame implements ActionListener
{

    String pinnum;
    JButton back;

    /**
     * 
     */
    BalanceEnquiry(String pinnum)
    {

        this.pinnum = pinnum;

        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Icons\\atm.jpg"));
        Image l = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 =new ImageIcon(l);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);


        back = new JButton("Back");
        back.setBounds(355,520,150,30);
        back.addActionListener(this);
        image.add(back);


        Connection c = new Connection();
        int balance = 0;
        try
        {
            ResultSet rs = c.s.executeQuery("SELECT * FROM bank WHERE pin ='"+pinnum+"'");
            
            while(rs.next())
            {
                if(rs.getString("type").equals("Deposit"))
                {
                    balance = balance + Integer.parseInt(rs.getString("amount"));
                }
                else 
                {
                    balance = balance - Integer.parseInt(rs.getString("amount"));
                }
            }
           
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        
       
            
       
        JLabel text = new JLabel("Your current account balance is Rs " +balance);
        text.setBounds(180,350,400,30);
        text.setForeground(Color.white);
        text.setFont(new Font("Raleway",Font.BOLD,16));
        image.add(text);

        

        setSize(900,900);
        setLocation(300,0);
        setUndecorated(true);
        setVisible(true);

    }

    public void actionPerformed(ActionEvent ae)
    {
        setVisible(false);
        new Transaction(pinnum).setVisible(true);
    }
    public static void main(String args[])
    {
        new BalanceEnquiry("");
    }
}
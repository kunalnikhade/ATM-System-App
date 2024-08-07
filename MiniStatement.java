import java.awt.Color;
import java.sql.ResultSet;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class MiniStatement extends JFrame {

    

    MiniStatement(String pinnum)
    {
        
        setLayout(null);

        JLabel mini = new JLabel("");
        mini.setBounds(20,140,400,20);
        add(mini);

        JLabel bank = new JLabel("State Bank Of India");
        bank.setBounds(140,20,200,20);
        add(bank);

        JLabel card = new JLabel("");
        card.setBounds(20,80,300,20);
        add(card);

        JLabel balance = new JLabel("");
        balance.setBounds(20,400,300,20);
        add(balance);


        try
        {
            Connection c = new Connection();
            ResultSet rs = c.s.executeQuery("SELECT * FROM login where pinnum =  '"+pinnum+"'");
            while(rs.next())
            {
                card.setText("Card Number : "+rs.getString("cardnum").substring(0,16));
            }
        }
        catch(Exception e)
        {
            System.out.println(e);
        }



        try
        {
            Connection c = new Connection();
            int bal = 0;
            
            ResultSet rs = c.s.executeQuery("SELECT * FROM bank where pin = '"+pinnum+"'");
            while(rs.next())
            {
                mini.setText(mini.getText() + "       "+ rs.getString("date") +"       "+rs.getString("type")+"       "+rs.getString("amount") + System.lineSeparator());
            
                if(rs.getString("type").equals("Deposit"))
                {
                    bal = bal + Integer.parseInt(rs.getString("amount"));
                }
            
                else
                {
                    bal = bal - Integer.parseInt(rs.getString("amount"));
                }
            }
            balance.setText("Your current account balance is Rs "+bal);

        }
        catch(Exception e)
        {
            System.out.println(e);
        }

        


        setSize(400,600);
        setLocation(20,20);
        getContentPane().setBackground(Color.white);
        setVisible(true);
    }
    public static void main(String args[])
    {
        new MiniStatement("");
    }
}

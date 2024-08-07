import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.awt.*;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 * Transaction
 */
public class FastCash extends JFrame implements ActionListener{
   

    JButton Deposit,Withdraw,fastcash,ministatement,pinchange,balance,Back;
    String pinnum;
    FastCash(String pinnum)
    {
        this.pinnum = pinnum;

        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Icons\\atm.jpg"));
        Image l1 = i1.getImage().getScaledInstance(900,900,Image.SCALE_DEFAULT);
        ImageIcon i3 =new ImageIcon(l1);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);

        JLabel text = new JLabel("Select Withdrawal");
        text.setBounds(270,300,700,35);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("Raleway",Font.BOLD,16));
        image.add(text);

        Deposit = new JButton("Rs 100");
        Deposit.setBounds(170,415,150,30);
        Deposit.addActionListener(this);
        image.add(Deposit);

        Withdraw = new JButton("Rs 500");
        Withdraw.setBounds(355,415,150,30);
        Withdraw.addActionListener(this);
        image.add(Withdraw);

        fastcash = new JButton("Rs 1000");
        fastcash.setBounds(170,450,150,30);
        fastcash.addActionListener(this);
        image.add(fastcash);

        ministatement = new JButton("Rs 2000");
        ministatement.setBounds(355,450,150,30);
        ministatement.addActionListener(this);
        image.add(ministatement);

        pinchange = new JButton("Rs 5000");
        pinchange.setBounds(170,485,150,30);
        pinchange.addActionListener(this);
        image.add(pinchange);

        balance = new JButton("Rs 10000");
        balance.setBounds(355,485,150,30);
        balance.addActionListener(this);
        image.add(balance);

        Back = new JButton("Back");
        Back.setBounds(265,520,150,30);
        Back.addActionListener(this);
        image.add(Back);

        

        


        setSize(900, 900);
        setLocation(350,0);
        getContentPane().setBackground(Color.white);
        setUndecorated(true);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource() == Back)
        {
            setVisible(false);
            new Transaction(pinnum).setVisible(true);
        }
        else
        {
            String amount = ((JButton)ae.getSource()).getText().substring(3);

            Connection c = new Connection();
            try
            {
                ResultSet rs = c.s.executeQuery("SELECT * FROM bank WHERE pin ='"+pinnum+"'");
                int balance = 0;
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

                if(ae.getSource()  != Back && balance < Integer.parseInt(amount) )
                {
                    JOptionPane.showMessageDialog(null, "Insufficient Balance");
                    return;
                }
                LocalDate date = LocalDate.now();
                String query = "INSERT INTO bank values('"+pinnum+"','"+date+"','Withdraw','"+amount+"')";
                c.s.executeUpdate(query);

                JOptionPane.showMessageDialog(null, "Rs "+amount+ "Debited Successfully");

                setVisible(false);
                new Transaction(pinnum).setVisible(true);
            }
            catch(Exception e)
            {
                System.out.println(e);
            }

        }
       
    }

    public static void main (String args[])
    {
        new FastCash("");
    }
     
}
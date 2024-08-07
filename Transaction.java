import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 * Transaction
 */
public class Transaction extends JFrame implements ActionListener{
   

    JButton Deposit,Withdraw,fastcash,ministatement,pinchange,balance,exit;
    String pinnum;
    Transaction(String pinnum)
    {
        this.pinnum = pinnum;

        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Icons\\atm.jpg"));
        Image l1 = i1.getImage().getScaledInstance(900,900,Image.SCALE_DEFAULT);
        ImageIcon i3 =new ImageIcon(l1);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);

        JLabel text = new JLabel("Please Select Your Transaction");
        text.setBounds(215,300,700,35);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("Raleway",Font.BOLD,16));
        image.add(text);

        Deposit = new JButton("Deposit");
        Deposit.setBounds(170,415,150,30);
        Deposit.addActionListener(this);
        image.add(Deposit);

        Withdraw = new JButton("Cash Withdraw");
        Withdraw.setBounds(355,415,150,30);
        Withdraw.addActionListener(this);
        image.add(Withdraw);

        fastcash = new JButton("Fast Cash");
        fastcash.setBounds(170,450,150,30);
        fastcash.addActionListener(this);
        image.add(fastcash);

        ministatement = new JButton("Mini Statement");
        ministatement.setBounds(355,450,150,30);
        ministatement.addActionListener(this);
        image.add(ministatement);

        pinchange = new JButton("Pin Change");
        pinchange.setBounds(170,485,150,30);
        pinchange.addActionListener(this);
        image.add(pinchange);

        balance = new JButton("Balance Enquiry");
        balance.setBounds(355,485,150,30);
        balance.addActionListener(this);
        image.add(balance);

        exit = new JButton("Exit");
        exit.setBounds(265,520,150,30);
        exit.addActionListener(this);
        image.add(exit);

        

        


        setSize(900, 900);
        setLocation(350,0);
        getContentPane().setBackground(Color.white);
        setUndecorated(true);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource() == exit)
        {
            System.exit(0);
        }
        else if(ae.getSource() == Deposit)
        {
            setVisible(false);
            new Deposit(pinnum).setVisible(true);
        }
        else if(ae.getSource() == Withdraw)
        {
            setVisible(false);
            new Withdraw(pinnum).setVisible(true);
        }
        else if(ae.getSource() == fastcash)
        {
            setVisible(false);
            new FastCash(pinnum).setVisible(true);
        }
        else if(ae.getSource() == pinchange)
        {
            setVisible(false);
            new PinChange(pinnum).setVisible(true);
        }
        else if(ae.getSource() == balance)
        {
            setVisible(false);
            new BalanceEnquiry(pinnum).setVisible(true);
        }
        else if(ae.getSource() == ministatement)
        {
            setVisible(false);
            new MiniStatement(pinnum).setVisible(true);
        }
    }

    public static void main (String args[])
    {
        new Transaction("");
    }
     
}
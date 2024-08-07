import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import java.awt.Image;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;

public class SignupThree extends JFrame implements ActionListener{

    JRadioButton r1,r2,r3,r4;
    JButton Submit,Cancel;
    JCheckBox c1,c2,c3,c4,c5,c6,c7;
    String sformno;

    SignupThree(String sformno)
    {
        this.sformno =sformno;
        setLayout(null);
 
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Icons//debit.jpg"));
        Image l = i1.getImage().getScaledInstance(840,820,Image.SCALE_DEFAULT);
        ImageIcon i3 =new ImageIcon(l);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,840,820);
        add(image);

        JLabel l1 = new JLabel("Page 3: Account Details");
        l1.setFont(new Font("Raleway",Font.BOLD,22));
        l1.setBounds(270,40,400,40);
        image.add(l1);

        JLabel type = new JLabel("Account Type :");
        type.setFont(new Font("Raleway",Font.BOLD,22));
        type.setBounds(100,140,200,30);
        image.add(type);

        r1 = new JRadioButton("Saving Account");
        r1.setFont(new Font("Raleway",Font.BOLD,16));
        r1.setBounds(100,180,150,20);
        image.add(r1);

        r2 = new JRadioButton("FD Account");
        r2.setFont(new Font("Raleway",Font.BOLD,16));
        r2.setBounds(350,180,150,20);
        image.add(r2);

        r3 = new JRadioButton("Current Account");
        r3.setFont(new Font("Raleway",Font.BOLD,16));
        r3.setBounds(100,220,150,20);
        image.add(r3);

        r4 = new JRadioButton("RD Account");
        r4.setFont(new Font("Raleway",Font.BOLD,16));
        r4.setBounds(350,220,150,20);
        image.add(r4);

        ButtonGroup groupacc = new ButtonGroup();
        groupacc.add(r1);
        groupacc.add(r2);
        groupacc.add(r3);
        groupacc.add(r4);


        JLabel Ctype = new JLabel("Card Number :");
        Ctype.setFont(new Font("Raleway",Font.BOLD,22));
        Ctype.setBounds(100,300,200,30);
        image.add(Ctype);

        JLabel number = new JLabel("XXXX-XXXX-XXXX-1408");
        number.setFont(new Font("Raleway",Font.BOLD,22));
        number.setBounds(330,302,300,30);
        image.add(number);

        JLabel details = new JLabel("Your 16 Digit Card Number");
        details.setFont(new Font("Raleway",Font.BOLD,12));
        details.setBounds(100,330,300,30);
        image.add(details);


        JLabel pin = new JLabel("PIN :");
        pin.setFont(new Font("Raleway",Font.BOLD,22));
        pin.setBounds(100 ,370,200,30);
        image.add(pin);

        JLabel pdetails = new JLabel("Your 4 Digit Password");
        pdetails.setFont(new Font("Raleway",Font.BOLD,12));
        pdetails.setBounds(100,400,300,30);
        image.add(pdetails);

        JLabel pnumber = new JLabel("XXXX");
        pnumber.setFont(new Font("Raleway",Font.BOLD,22));
        pnumber.setBounds(330,372,300,30);
        image.add(pnumber);

        JLabel Services = new JLabel("Services Required :");
        Services.setFont(new Font("Raleway",Font.BOLD,22));
        Services.setBounds(100,450,250,30);
        image.add(Services);


        c1 = new JCheckBox("ATM CARD");
        c1.setBackground(Color.WHITE);
        c1.setFont(new Font("Raleway",Font.BOLD,16));
        c1.setBounds(100,500,200,30);
        image.add(c1);

        c2 = new JCheckBox("Internet Banking");
        c2.setBackground(Color.WHITE);
        c2.setFont(new Font("Raleway",Font.BOLD,16));
        c2.setBounds(350,500,200,30);
        image.add(c2);

        c3 = new JCheckBox("Mobile Banking");
        c3.setBackground(Color.WHITE);
        c3.setFont(new Font("Raleway",Font.BOLD,16));
        c3.setBounds(100,550,200,30);
        image.add(c3);

        c4 = new JCheckBox("SMS Alert");
        c4.setBackground(Color.WHITE);
        c4.setFont(new Font("Raleway",Font.BOLD,16));
        c4.setBounds(350,550,200,30);
        image.add(c4);

        c5 = new JCheckBox("Cheque Book");
        c5.setBackground(Color.WHITE);
        c5.setFont(new Font("Raleway",Font.BOLD,16));
        c5.setBounds(100,600,200,30);
        image.add(c5);

        c6 = new JCheckBox("E Statement"); 
        c6.setBackground(Color.WHITE);
        c6.setFont(new Font("Raleway",Font.BOLD,16));
        c6.setBounds(350,600,200,30);
        image.add(c6);

        c7 = new JCheckBox("I hereby declares that the above entered details are correct to the best of my knowledge. ");
        c7.setFont(new Font("Raleway",Font.BOLD,10));
        c7.setBounds(100,650,500,30);
        image.add(c7);

        Submit = new JButton("Submit");
        Submit.setBackground(Color.BLACK);
        Submit.setForeground(Color.white);
        Submit.setBounds(150,720,100,30);
        Submit.addActionListener(this);
        image.add(Submit);

        Cancel = new JButton("Cancel");
        Cancel.setBackground(Color.BLACK);
        Cancel.setForeground(Color.white);
        Cancel.setBounds(300,720,100,30);
        Cancel.addActionListener(this);
        image.add(Cancel);


        setSize(840,820);
        getContentPane().setBackground(Color.CYAN);
        setLocation(350, 0);
       
        setVisible(true);

    }

    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource() == Submit)
        {
            String accountType = null;
            if(r1.isSelected())
            {
                accountType = "Saving Account";
            }
            else if(r2.isSelected())
            {
                accountType = "FD Account";
            }
            else if(r3.isSelected())
            {
                accountType = "Current Account";
            }
            else if(r4.isSelected())
            {
                accountType = "Recurring Account";
            }

           Random random = new Random();
           String cardnum = "" + Math.abs((random.nextLong() % 90000000L) + 5040936000000000L);

           String pinnum = "" + Math.abs((random.nextLong() % 9000L) +1000L);
            
           String facility = "";
           if(c1.isSelected())
           {
            facility = facility + "ATM Card";
           }
           else if(c2.isSelected())
           {
            facility = facility + "Internet Banking";
           }
           else if(c3.isSelected())
           {
            facility = facility + "Mobile Banking";
           }
           else if(c4.isSelected())
           {
            facility = facility + "SMS Alert";
           }
           else if(c5.isSelected())
           {
            facility = facility + "Cheque Book";
           }
           else if(c6.isSelected())
           {
            facility = facility + "E Statement";
           }
          
           try 
           {
                if(accountType.equals(""))
                {
                    JOptionPane.showMessageDialog(null, "Account type is Required");
                }
                else
                {
                    Connection c = new Connection();
                    String query2 = "INSERT INTO signupthree values('"+sformno+"','"+accountType+"','"+cardnum+"','"+pinnum+"','"+facility+"')";
                    c.s.executeUpdate(query2);
                    String query1 = "INSERT INTO login values('"+sformno+"','"+cardnum+"','"+pinnum+"')";
                    c.s.executeUpdate(query1);
                    
                    

                    //submit click kelyavr card num and pin num disayla
                    JOptionPane.showMessageDialog(null,"Card Number :" + cardnum + "\n Pin :" + pinnum);
                }
           }
           catch(Exception e)
           {
                System.out.println(e);
           }



        }
        else if(ae.getSource() == Cancel)
        {
            setVisible(false);
            new Login().setVisible(true);
        }
    }

    public static void main(String args[])
    {
        new SignupThree("");
    }
}
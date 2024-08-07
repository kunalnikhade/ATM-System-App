

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener; // button pe click hua h pta lgne ko
import java.sql.ResultSet;

import javax.swing.*; // App

class Login extends JFrame implements ActionListener
{
    JButton login, clear, signup;
    JTextField cardTextField;
    JPasswordField pinTextField;   // JPasswordField ---> kuch b na dikhe isiliye

    Login()
    {

        setLayout(null); // lables positon me lane ko

        ImageIcon a = new ImageIcon(ClassLoader.getSystemResource("Icons/logo.png"));
        Image b = a.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);//location of icon
        ImageIcon c = new ImageIcon(b);
        JLabel label = new JLabel(c); // img set
        label.setBounds(90,1,100,100);
        add(label); // adding icon on frame


        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Icons//img.gif"));
        Image l1 = i1.getImage().getScaledInstance(700,580,Image.SCALE_DEFAULT);
        ImageIcon i3 =new ImageIcon(l1);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,700,580);
        add(image);

        JLabel text = new JLabel("WELCOME TO ATM");
        text.setFont(new Font("Elephant",Font.BOLD,30));
        text.setForeground(Color.black);
        text.setBounds(200,36,400,40);
        image.add(text);

        JLabel cardnum = new JLabel("Card No ");
        cardnum.setFont(new Font("Calibri",Font.BOLD,15));
        cardnum.setBounds(470,155,150,30);
        image.add(cardnum);

        cardTextField = new JTextField();
        cardTextField.setBounds(300,150,230,25);
        cardTextField.setFont(new Font("Arial",Font.BOLD,14));
        image.add(cardTextField);

        JLabel pinnum = new JLabel("Pin");
        pinnum.setFont(new Font("Calibri",Font.BOLD,15));
        pinnum.setBounds(500,230,250,25);
        image.add(pinnum);

        pinTextField = new JPasswordField();
        pinTextField.setBounds(300,220,230,30);
        pinTextField.setFont(new Font("Arial",Font.BOLD,14));
        image.add(pinTextField);

        login = new JButton("SIGN IN");
        login.setBounds(300,300,100,30);
        login.setBackground(Color.black);
        login.setForeground(Color.WHITE);
        login.addActionListener(this);
        image.add(login);

        clear = new JButton("CLEAR");
        clear.setBounds(430,300,100,30);
        clear.setBackground(Color.black);
        clear.setForeground(Color.WHITE);
        clear.addActionListener(this);
        image.add(clear);
        
        
        
        JLabel info = new JLabel("Don't have an account?");
        info.setFont(new Font("Raleway",Font.BOLD,14));
        info.setForeground(Color.black);
        info.setBounds(330,350,250,30);
        image.add(info);


        signup = new JButton("SIGN UP");
        signup.setBounds(300,400,230,30);
        signup.setBackground(Color.black);
        signup.setForeground(Color.WHITE);
        signup.addActionListener(this);
        image.add(signup);


        
        setSize(700,580);
        getContentPane().setBackground(Color.gray);
        //setUndecorated(true);
        setVisible(true); // frame vsibility
        setLocation(350,200); // frame location

    }


    public void actionPerformed(ActionEvent ae) // button click hone k bad kya action performed hoga
    {
        if(ae.getSource() == clear)
        {
            cardTextField.setText(""); //clear krnar
            pinTextField.setText("");  //clear krnar
        }
        else if(ae.getSource() == login)
        {
            Connection c = new Connection();

            String cardnum = cardTextField.getText();
            String pinnum = pinTextField.getText();

            String query = "SELECT * FROM login WHERE cardnum  = '"+cardnum+"' and pinnum = '"+pinnum+"'";
            try
            {
                ResultSet rs = c.s.executeQuery(query);
                if(rs.next())
                {
                    setVisible(false);
                    new Transaction(pinnum).setVisible(true);
                }
                else
                {
                    JOptionPane.showMessageDialog(null, "Incorrect Card Number or PIN");
                }
            }
            catch(Exception e)
            {
                System.out.println(e);
            }
        }
        else if(ae.getSource() == signup)
        {
            setVisible(false);
            new Signup1().setVisible(true);
        }
    }


    public static void main(String[] args) {
        new Login();
    }
}
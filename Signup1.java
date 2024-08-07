import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import com.toedter.calendar.JDateChooser;
import java.awt.Image;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class Signup1 extends JFrame implements ActionListener{
    long random;
    JTextField namTextField,FnameTextField,dobTextField,gmlTextField,moTextField,adrsTextField,ctyTextField,stateTextField,pncTextField;
    JButton next;
    JRadioButton male,female,other,married,unmarried;
    JDateChooser datechooser;
    JComboBox genders,maritals;

    Signup1()
    {
        setLayout(null); // lables positon me lane ko

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Icons//debit.jpg"));
        Image l1 = i1.getImage().getScaledInstance(850,800,Image.SCALE_DEFAULT);
        ImageIcon i3 =new ImageIcon(l1);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,850,800);
        add(image);


        Random ran = new Random(); // form no random lene ko
        long random = Math.abs((ran.nextLong()%9000L) + 1000L);

        JLabel formno = new JLabel("APPLICATION FORM NO : " + random);
        formno.setFont(new Font("Raleway",Font.BOLD, 38));
        formno.setBounds(140,20,600,40);
        image.add(formno);

        JLabel personaldetails = new JLabel("Page 1: Personal Details");
        personaldetails.setFont(new Font("Raleway",Font.BOLD, 22));
        personaldetails.setBounds(270,80,400,30);
        image.add(personaldetails);

        JLabel name = new JLabel("Name :");
        name.setFont(new Font("Raleway",Font.BOLD, 20));
        name.setBounds(100,140,100,30);
        image.add(name);

        namTextField = new JTextField();
        namTextField.setFont(new Font("Raleway",Font.BOLD,14));
        namTextField.setBounds(300,140,400,30);
        image.add(namTextField);

        JLabel Fname = new JLabel("Father's Name :");
        Fname.setFont(new Font("Raleway",Font.BOLD, 20));
        Fname.setBounds(100,190,200,30);
        image.add(Fname);

        FnameTextField = new JTextField();
        FnameTextField.setFont(new Font("Raleway",Font.BOLD,14));
        FnameTextField.setBounds(300,190,400,30);
        image.add(FnameTextField);

        JLabel dob = new JLabel("Date of Birth :");
        dob.setFont(new Font("Raleway",Font.BOLD, 20));
        dob.setBounds(100,240,200,30);
        image.add(dob);

        datechooser = new JDateChooser();
        datechooser.setBounds(300,240,400,30);
        datechooser.setForeground(new Color(105,105,105));
        image.add(datechooser);
        
        JLabel gender = new JLabel("Gender :");
        gender.setFont(new Font("Raleway",Font.BOLD, 20));
        gender.setBounds(100,290,200,30);
        image.add(gender);

        String occupationval[] = {"Male","Female","Others"};
        genders = new JComboBox(occupationval);
        genders.setBounds(300,290,400,30);
        genders.setBackground(Color.white);
        image.add(genders);

        JLabel gml = new JLabel("Email :");
        gml.setFont(new Font("Raleway",Font.BOLD, 20));
        gml.setBounds(100,340,200,30);
        image.add(gml);

        gmlTextField = new JTextField();
        gmlTextField.setFont(new Font("Raleway",Font.BOLD,14));
        gmlTextField.setBounds(300,340,400,30);
        image.add(gmlTextField);

        JLabel mo = new JLabel("Mobile No :");
        mo.setFont(new Font("Raleway",Font.BOLD, 20));
        mo.setBounds(100,390,200,30);
        image.add(mo);

        moTextField = new JTextField();
        moTextField.setFont(new Font("Raleway",Font.BOLD,14));
        moTextField.setBounds(300,390,400,30);
        image.add(moTextField);

        JLabel marry = new JLabel("Marital Status :");
        marry.setFont(new Font("Raleway",Font.BOLD, 20));
        marry.setBounds(100,440,200,30);
        image.add(marry);

        String status[] = {"Married","Unmarried"};
        maritals = new JComboBox(status);
        maritals.setBounds(300,440,400,30);
        maritals.setBackground(Color.white);
        image.add(maritals);
        

        JLabel adrs = new JLabel("Address :");
        adrs.setFont(new Font("Raleway",Font.BOLD, 20));
        adrs.setBounds(100,490,200,30);
        image.add(adrs);

        adrsTextField = new JTextField();
        adrsTextField.setFont(new Font("Raleway",Font.BOLD,14));
        adrsTextField.setBounds(300,490,400,30);
        image.add(adrsTextField);

        JLabel cty = new JLabel("City :");
        cty.setFont(new Font("Raleway",Font.BOLD, 20));
        cty.setBounds(100,540,200,30);
        image.add(cty);

        ctyTextField = new JTextField();
        ctyTextField.setFont(new Font("Raleway",Font.BOLD,14));
        ctyTextField.setBounds(300,540,400,30);
        image.add(ctyTextField);

        JLabel state = new JLabel("State :");
        state.setFont(new Font("Raleway",Font.BOLD, 20));
        state.setBounds(100,590,200,30);
        image.add(state);

        stateTextField = new JTextField();
        stateTextField.setFont(new Font("Raleway",Font.BOLD,14));
        stateTextField.setBounds(300,590,400,30);
        image.add(stateTextField);

        JLabel pnc = new JLabel("Pin Code :");
        pnc.setFont(new Font("Raleway",Font.BOLD, 20));
        pnc.setBounds(100,640,200,30);
        image.add(pnc);

        pncTextField = new JTextField();
        pncTextField.setFont(new Font("Raleway",Font.BOLD,14));
        pncTextField.setBounds(300,640,400,30);
        image.add(pncTextField);

        JButton next = new JButton("Next");
        next.setBackground(Color.BLACK);
        next.setForeground(Color.white);
        next.setFont(new Font("Raleway",Font.BOLD,14));
        next.setBounds(620,690,80,30);
        next.addActionListener(this);
        image.add(next);

        
        setSize(850,800);
        
        setVisible(true); // frame vsibility
        setLocation(350,180); // frame location
    }
    
    public void actionPerformed(ActionEvent ae) // button click hone k bad kya action performed hoga
    {
        String sformno = "" + random;
        String name = namTextField.getText(); //setText
        String Fname = FnameTextField.getText();
        String dob  = ((JTextField)datechooser.getDateEditor().getUiComponent()).getText();
        String gender = (String) genders.getSelectedItem();
       

        String email = gmlTextField.getText();
        String MobileNo = moTextField.getText();
        String marital = (String) maritals.getSelectedItem();
        

        String address = adrsTextField.getText();
        String city = ctyTextField.getText();
        String state = stateTextField.getText();
        String pin = pncTextField.getText();


        try{
            if(name.equals("")) //jr name empty rhaal tr pop yeil
            {
                JOptionPane.showMessageDialog(null, "Name is Required");
            }
            else
            {
                Connection c = new Connection();
                String query = "INSERT INTO signup values('"+sformno+"','"+name+"','"+Fname+"','"+dob+"','"+gender+"','"+email+"','"+MobileNo+"','"+marital+"','"+address+"','"+city+"','"+pin+"','"+state+"')";
                c.s.executeUpdate(query);

                setVisible(false);
                new Signup2(sformno).setVisible(true);
            }

        }catch(Exception e)
        {
            System.out.println(e);
        }
    }

    


    public static void main(String args[])
    {
        new Signup1();
    }
}

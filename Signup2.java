
    import java.awt.Color;
    import java.awt.Font;
    import java.awt.event.ActionEvent;
    import java.awt.event.ActionListener;
    import java.awt.Image;
    import javax.swing.ImageIcon;
    import javax.swing.JButton;
    import javax.swing.JComboBox;
    import javax.swing.JFrame;
    import javax.swing.JLabel;
    import javax.swing.JOptionPane;
    import javax.swing.JTextField;
    
    public class Signup2 extends JFrame implements ActionListener{
        
        
        JTextField pan,adhar,citizen,acc;
        JButton next;
        JComboBox religion,category,incmcategory,education,occupation,citizenn,accc;
        String sformno;

        Signup2(String sformno)
        {
            this.sformno = sformno;

            setLayout(null); // lables positon me lane ko
    
            ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Icons//debit.jpg"));
            Image l1 = i1.getImage().getScaledInstance(850,800,Image.SCALE_DEFAULT);
            ImageIcon i3 =new ImageIcon(l1);
            JLabel image = new JLabel(i3);
            image.setBounds(0,0,850,800);
            add(image);
    
        
    
            JLabel addtionaldetails = new JLabel("Page 2: Additiional Details");
            addtionaldetails.setFont(new Font("Raleway",Font.BOLD, 22));
            addtionaldetails.setBounds(270,80,400,30);
            image.add(addtionaldetails);
    
            JLabel name = new JLabel("Religion :");
            name.setFont(new Font("Raleway",Font.BOLD, 20));
            name.setBounds(100,140,100,30);
            image.add(name);

            String ValReligion[] = {"Hindu","Muslim","Christian","Others"};
            religion = new JComboBox(ValReligion);
            religion.setBounds(300,140,400,30);
            religion.setBackground(Color.white);
            image.add(religion);
    
     
            JLabel Fname = new JLabel("Category :");
            Fname.setFont(new Font("Raleway",Font.BOLD, 20));
            Fname.setBounds(100,190,200,30);
            image.add(Fname);

            String ValCategory[] = {"OBC","ST","General","Others"};
            category = new JComboBox(ValCategory);
            category.setBounds(300,190,400,30);
            category.setBackground(Color.white);
            image.add(category);

    
            JLabel dob = new JLabel("Income :");
            dob.setFont(new Font("Raleway",Font.BOLD, 20));
            dob.setBounds(100,240,200,30);
            image.add(dob);

            String ValIncome[] = {"Null","<1,50,000","<6,50,000",">6,50,000"};
            incmcategory = new JComboBox(ValIncome);
            incmcategory.setBounds(300,240,400,30);
            incmcategory.setBackground(Color.white);
            image.add(incmcategory);
    
            
            JLabel gender = new JLabel("Educational ");
            gender.setFont(new Font("Raleway",Font.BOLD, 20));
            gender.setBounds(100,290,200,30);
            image.add(gender);
    
            JLabel gml = new JLabel("Qualication :");
            gml.setFont(new Font("Raleway",Font.BOLD, 20));
            gml.setBounds(100,315,200,30);
            image.add(gml);
    
            String educationval[] = {"<10th","<12th","<Graduate",">Graduate"};
            education = new JComboBox(educationval);
            education.setBounds(300,315,400,30);
            education.setBackground(Color.white);
            image.add(education);
           
    
    
            JLabel marry = new JLabel("Occupation :");
            marry.setFont(new Font("Raleway",Font.BOLD, 20));
            marry.setBounds(100,390,200,30);
            image.add(marry);
    
            String occupationval[] = {"Salaried","Self Employee","Student","Others"};
            occupation = new JComboBox(occupationval);
            occupation.setBounds(300,390,400,30);
            occupation.setBackground(Color.white);
            image.add(occupation);
            
    
            JLabel adrs = new JLabel("PAN Number :");
            adrs.setFont(new Font("Raleway",Font.BOLD, 20));
            adrs.setBounds(100,440,200,30);
            image.add(adrs);
    
            pan = new JTextField();
            pan.setFont(new Font("Raleway",Font.BOLD,14));
            pan.setBounds(300,440,400,30);
            image.add(pan);
    
            JLabel cty = new JLabel("Adhar Number :");
            cty.setFont(new Font("Raleway",Font.BOLD, 20));
            cty.setBounds(100,490,200,30);
            image.add(cty);
    
            adhar = new JTextField();
            adhar.setFont(new Font("Raleway",Font.BOLD,14));
            adhar.setBounds(300,490,400,30);
            image.add(adhar);
    
            JLabel state = new JLabel("Senior Citizen :");
            state.setFont(new Font("Raleway",Font.BOLD, 20));
            state.setBounds(100,540,200,30);
            image.add(state);
    
            String citizenval[] = {"Yes","No"};
            citizenn = new JComboBox(citizenval);
            citizenn.setBounds(300,540,400,30);
            citizenn.setBackground(Color.white);
            image.add(citizenn);
    
            JLabel pnc = new JLabel("Existing Account :");
            pnc.setFont(new Font("Raleway",Font.BOLD, 20));
            pnc.setBounds(100,590,200,30);
            image.add(pnc);
    
            String accVal[] = {"Yes","No"};
            accc = new JComboBox(accVal);
            accc.setBounds(300,590,400,30);
            accc.setBackground(Color.white);
            image.add(accc);
    
            JButton next = new JButton("Next");
            next.setBackground(Color.BLACK);
            next.setForeground(Color.white);
            next.setFont(new Font("Raleway",Font.BOLD,14));
            next.setBounds(620,680,80,30);
            next.addActionListener(this);
            image.add(next);
    
            //frame
            getContentPane().setBackground(Color.cyan); //FRAME COLOR
            setSize(850,800);
            
            setVisible(true); // frame vsibility
            setLocation(350,180); // frame location
        }
        
        public void actionPerformed(ActionEvent ae) // button click hone k bad kya action performed hoga
        {
           
            String sreligion = (String) religion.getSelectedItem(); //setText
            String scategory = (String) category.getSelectedItem();
            String sincome = (String) incmcategory.getSelectedItem();
            String seducation = (String) education.getSelectedItem();
            String soccupation = (String) occupation.getSelectedItem();
            String scitizenn = (String) citizenn.getSelectedItem();
            String sacc = (String) accc.getSelectedItem();
            String sadhar = adhar.getText();
            String span = pan.getText();
           
    
    
            try{
                if(sadhar.equals("")) //jr name empty rhaal tr pop yeil
                {
                    JOptionPane.showMessageDialog(null, "Adhar Number is Required");
                }
                else
                {
                    Connection c = new Connection();
                    String query = "INSERT INTO signuptwo values('"+sformno+"','"+sreligion+"','"+scategory+"','"+sincome+"','"+seducation+"','"+soccupation+"','"+span+"','"+sadhar+"','"+sacc+"','"+scitizenn+"')";
                    c.s.executeUpdate(query);

                    setVisible(false);
                    new SignupThree(sformno).setVisible(true);
                }
    
            }catch(Exception e)
            {
                System.out.println(e);
            }
        }
    
        
    
    
        public static void main(String args[])
        {
            new Signup2("");
        }
    }
    

    


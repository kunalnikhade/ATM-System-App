//Register the Driver 
//Create Connection
//Create Statement
//Execute query
//Close Connection


import java.sql.*;


public class Connection {

    Statement s;
   
    Connection()
    {
        java.sql.Connection c;

        try
        {
             // Register driver
            c = DriverManager.getConnection("jdbc:mysql:///bank","root","");//Create Connection
            s = c.createStatement(); //Create statement
            
        } catch(Exception e)
        {
            System.out.println(e);
        }
        
    }

    
}

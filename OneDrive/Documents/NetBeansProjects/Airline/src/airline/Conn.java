package airline;
import java.sql.*;  
public class Conn{
    Connection c;
    Statement s;
    public Conn(){  
        try{  
            Class.forName("org.apache.derby.jdbc.ClientDriver");  
            c = DriverManager.getConnection("jdbc:derby://localhost:1527/Airline","man","123");    
            s =c.createStatement();          
        }catch(Exception e){ 
            System.out.println(e);
        }  
    }  
}  
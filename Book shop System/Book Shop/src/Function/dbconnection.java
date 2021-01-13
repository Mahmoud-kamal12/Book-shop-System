
package Function;

import java.sql.*;


public class dbconnection {
   public String dbname = "bookshop";
   public String dbURL = "jdbc:mysql://localhost:3306/"+dbname; // conest 
   public String username ="root"; 
   public String password = "";  
    
    public Connection Funconn() throws SQLException
    {
       Connection dbcon = null;
    try
    {
        dbcon = (Connection) DriverManager.getConnection(this.dbURL, this.username, this.password);
    }catch (SQLException se)
    {
         throw se; 
    }
        return dbcon;
    }
    
}

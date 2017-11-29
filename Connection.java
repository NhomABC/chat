
package nhomabc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;


public class Connection {
    public static void main(String[] args) {
        Connection con = null;
        Statement sttm = null;
  
        try{
            Class.forName("org.sqlite.JDBC");
            con = DriverManager.getConnection("jdbc:sqlite:nhomabc.db");
            
            sttm =con.createStatement();
            
            String sql = "SELECT  username, password FROM tableaccount";
            ResultSet rs    = sttm.executeQuery(sql);
            
            while (rs.next()) {
                System.err.println(rs.getString("username")+ "\t" + rs.getString("password"));
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        
    }
}

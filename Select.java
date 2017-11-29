/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nhomabc;

/**
 *
 * @author Ben
 */
import java.sql.*;
public class Select {
    public static void main(String[] args) {
        Connection con = null;
        Statement sttm = null;
        try {
                Class.forName("org.sqlite.JDBC");
                con = DriverManager.getConnection("jdbc:sqlite:db_ChinhThu.sqlite");
                sttm = con.createStatement();
                String sql = "Select taikhoan,matkhau FROM tb_taikhoan";
                ResultSet rs = sttm.executeQuery(sql);
                
                while (rs.next())
                {
                    System.err.println(rs.getString("taikhoan")+ "\t" + rs.getString("matkhau"));
                }
                
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
        
    }
    
}

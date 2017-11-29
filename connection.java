package ketnoicsdl;

import java.sql.Connection;
import java.sql.DriverManager;

public class connection {
   private static Connection con;
   public static  Connection getConnection(){
	   try{
		   Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			  String a = "jdbc:sqlserver://localhost:50269;" +
				         "databaseName=Quanli;integratedSecurity=True";
			  con=DriverManager.getConnection(a,"","");
			  
	   }catch(Exception e){
		   e.printStackTrace();
	   }
	   return con;
   }   
}

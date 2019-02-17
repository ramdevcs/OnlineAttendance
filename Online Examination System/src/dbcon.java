import java.sql.DriverManager;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

public class dbcon 
{
	Connection con;
	Statement st;
	public void dbconn()
	{
		try 
		{
			Class.forName("com.mysql.jdbc.Driver");
			con=(Connection) DriverManager.getConnection( "jdbc:mysql://localhost:3306/exam","root","admin");
			st=(Statement) con.createStatement();
		}
		catch(Exception e)
		{
			
		}
	}

}

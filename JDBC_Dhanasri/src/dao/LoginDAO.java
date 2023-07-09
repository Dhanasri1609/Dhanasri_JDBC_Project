package dao;
import java.sql.*;
import connectionManager.ConnectionManager;
import model.Login;
public class LoginDAO 
{
	 public boolean validate(Login login)throws ClassNotFoundException,SQLException
     {
                  String username=login.getUsername();
                  String password=login.getPassword();
                  ConnectionManager conn = new ConnectionManager();                                                              
                  Connection con=conn.establishConnection();
                  Statement st=con.createStatement();
                  ResultSet rs=st.executeQuery("select * from login");
                  while(rs.next())
                  {
                                if(username.equals(rs.getString("Username")) && password.equals(rs.getString("Password")))
                                {
                                              conn.closeConnection();
                                              return true;
                                }
                  }
                  conn.closeConnection();
                  return false;
     }
}
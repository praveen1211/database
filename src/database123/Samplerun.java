package database123;

import  java.sql.Connection;		
import  java.sql.Statement;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import  java.sql.ResultSet;		
import  java.sql.DriverManager;		
import  java.sql.SQLException;

public class Samplerun 
{
	public static WebDriver driver;
	public static void main (String args[]) throws SQLException, ClassNotFoundException
	{
		/*//Test Data
		String Username="preddem";
		String Password="C6F0";*/
		
		
		
		Connection con = null;
	//Connection URL Syntax: "jdbc:mysql://ipaddress:portnumber/db_name"		
		String dbUrl = "jdbc:mysql://localhost:3306/db1";
	
	//Database username and password
		String username = "root";
		String password = "8888";
	
		try
		{
	//load mysql jdbc driver
		Class.forName("com.mysql.jdbc.Driver");
	
	//Create Connection to DB		
	 con = DriverManager.getConnection(dbUrl,username,password);
	//Query to execute
			String query = "select *from a ORDER BY username DESC;";

		//Create Statement Object		
   Statement stmt = con.createStatement();					

		// Execute the SQL Query. Store results in ResultSet		
		ResultSet rs= stmt.executeQuery(query);	
		//rs.next();
		while (rs.next()){
    		String Username = rs.getString(1);
    		 String Password = rs.getString(2);
            System. out.println("Username = "+Username);	
            System. out.println("Password = "+Password);
           // System. out.println(rs.getString("username"));	
            //System. out.println(rs.getString("Password"));	
            
          //Input data using selenium
   		 driver = new FirefoxDriver();
   		 String Url = "https://www.miraclesoft.com/Hubble/";
   		driver.get(Url);
   		driver.findElement(By.xpath(".//*[@id='userId']")).sendKeys(Username);;
   		driver.findElement(By.xpath(".//*[@id='password']")).sendKeys(Password);
   		driver.findElement(By.xpath(".//*[@id='userLoginForm_0']")).click();
   		
   	/* //Database testing  
        if(!rs.getString("username").equals(Username))
        {
        System.out.print("Entered Username is wrong");
        }
        if(!rs.getString("Password").equals(Password))
        {
            System.out.print("Entered password is wrong");
        }  
        */
            driver.quit();
            con.close();
            
		}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		finally
		{
			if(con!= null)
			{
				con = null;
			}
		}
		
	}	
		
}

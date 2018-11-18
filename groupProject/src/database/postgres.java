package database;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
//import java.sql*;
public class postgres {
	public static void main(String[] args) {
		try {
			Class.forName("org.postgresql.Driver");
			Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/hafsahqazi", "postgres", "admin");
			System.out.println("Database connected");
			PreparedStatement statement =connection.prepareStatement("select* from flight");
			
			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next())
			      System.out.println(resultSet.getInt(1) + "\t" +
			        resultSet.getString(2));
		
			    // Close the connection
			    //connection.close();
			  
			
		} catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
	}

}

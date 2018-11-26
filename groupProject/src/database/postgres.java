package database;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class postgres {
	public static void main(String[] args) {
		try {
			Class.forName("org.postgresql.Driver");
			
			Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/AirlineDatabase", "postgres", "passpass");
					
			//"jdbc:postgresql://localhost:5432/AirlineDatabase", "postgres", "passpass"
			//hafsah connectivity: "jdbc:postgresql://localhost:5432/hafsahqazi", "postgres", "admin"
			System.out.println("Database connected");
			
			PreparedStatement statement = connection.prepareStatement("select from User");
			
			statement.executeQuery();
			
			
			ResultSet resultSet = statement.executeQuery();
			
			while (resultSet.next())
			      System.out.println(resultSet.getInt(1) + "\t" +
			        resultSet.getString(2));
		
			    // Close the connection
			    connection.close();
			
			//KELLY, what does code line 23 to 28 do?
			    //successful connection, but
			    //gives error "The column index is out of range: 1, number of columns: 0."

			
		} catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
	}

}

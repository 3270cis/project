package Database1;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.postgresql.util.LruCache.CreateAction;

public class postgres {
	public static void main(String[] args) {
		
		
		try {
			Class.forName("org.postgresql.Driver");
			
			Connection connection = DriverManager.getConnection("jdbc:postgresql://ec2-54-225-110-156.compute-1.amazonaws.com/d3r14stg9r3fd4", "sahrzfqchvludh", "906f8f4de585bb493c7078eb472c4cfc91fe2fbbe6f8af6f78f255631429398c");
				
			//jennifer "jdbc:postgresql://localhost:5432/postgres", "postgres", "password");
			//kelly "jdbc:postgresql://localhost:5432/AirlineDatabase", "postgres", "passpass"
			//hafsah connectivity: "jdbc:postgresql://localhost:5432/hafsahqazi", "postgres", "admin"
			System.out.println("Database connected");
			
			PreparedStatement pstatement = connection.prepareStatement("select * from flight");
			
			pstatement.executeQuery();
			
			ResultSet resultSet = pstatement.executeQuery();
			
			while (resultSet.next())
			      System.out.println(resultSet.getString(1) + "\t" +
			        resultSet.getString(2));
		
			    // Close the connection
			    connection.close();
			
			//KELLY, what does code line 23 to 28 do?
			    //successful connection, but
			    //gives error "The column index is out of range: 1, number of columns: 0."
			    //comment

			
		} catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
	}

}



//ignore
/*

CREATE TABLE airplane(airplaneID int PRIMARY KEY,capacity smallint);



CREATE TABLE flight (
flightNo int PRIMARY KEY,
airplaneID int references airplane(airplaneID)
);





CREATE TABLE flightDetails (
flightDetailsID int PRIMARY KEY,
flightNo int references flight(flightNo),
departureDateTime timestamp,
arrivalDateTime timestamp,
destination varchar(50),
arrivalCity varchar(50),
departureCity varchar(50)
);






CREATE TABLE users (
customerID int PRIMARY KEY,
SSN int UNIQUE,
c_username varchar(25) UNIQUE,
c_password_hash varchar(25),
f_name varchar(25),
l_name varchar(25)
);





CREATE TABLE reservation (
reservationNo int PRIMARY KEY,
flightNo int references flight(flightNo),
customerID int references users(customerID),
cancelledAt timestamp
);
*/
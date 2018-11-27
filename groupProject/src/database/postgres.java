package database;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.postgresql.util.LruCache.CreateAction;

public class postgres {
	public static void main(String[] args) {
		
		
		try {
			Class.forName("org.postgresql.Driver");
			
			Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "password");
				
			//jennifer "jdbc:postgresql://localhost:5432/postgres", "postgres", "password");
			//kelly "jdbc:postgresql://localhost:5432/AirlineDatabase", "postgres", "passpass"
			//hafsah connectivity: "jdbc:postgresql://localhost:5432/hafsahqazi", "postgres", "admin"
			System.out.println("Database connected");
			
			PreparedStatement pstatement = connection.prepareStatement("select* from User");
			
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
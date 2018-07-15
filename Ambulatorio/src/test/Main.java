package test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Main {

	private static Connection connect;
	private static ResultSet resultSet;

	public static void main(String[] args) throws Exception{
		Class.forName("com.mysql.jdbc.Driver");
        // Setup the connection with the DB
        connect = DriverManager
                .getConnection("jdbc:mysql://localhost/ambulatorio?"
                        + "user=root&password=zaq12wsx");

        // Statements allow to issue SQL queries to the database
        Statement statement = connect.createStatement();
        // Result set get the result of the SQL query
        resultSet = statement
                .executeQuery("select * from personal_data ");

        while( resultSet.next()) {
        	System.out.println(resultSet.getString(1));
        }
        resultSet.close();
        connect.close();
	}

}

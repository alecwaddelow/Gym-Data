package data_source;

import java.sql.Connection;
import java.sql.SQLException;

import com.microsoft.sqlserver.jdbc.SQLServerDataSource;

/**
 * @author drew rife
 *
 * Handles the establishing of a connection, passing the connection and closing it
 */
public class DBConnection
{
	private Connection connection;
	
	/**
	 * establish a connection to the db upon creation of the object
	 */
	public DBConnection()
	{
		try {
			// Establish the connection. 
			SQLServerDataSource ds = new SQLServerDataSource();
			ds.setIntegratedSecurity(false);
			ds.setServerName("waddelow.database.windows.net");
			ds.setPortNumber(1433); 
			ds.setDatabaseName("Gym_Data");
			ds.setUser("alec.waddelow");
			ds.setPassword("MasterCheif04");
			connection = ds.getConnection();
		}
		// Handle any errors that may have occurred.
		catch (Exception e) {
			e.printStackTrace();
		}	
	}

	/**
	 * @return the connection
	 */
	public Connection getConnection() 
	{
		return this.connection;
	}

	/**
	 * @return closes the connection
	 */
	public void close() 
	{
		try {
			this.connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}

package data_source;
import java.sql.*;  
import com.microsoft.sqlserver.jdbc.*;  

/**
 * 
 * @author Alec Waddelow
 * 
 * Manages the connection to the Microsoft SQL Server
 *
 */
public class SQLDatabaseConnectionManager 
{
		private static SQLDatabaseConnectionManager singleton;
		private Connection connection;
	
		/**
		 * Established the connection to the database upon object construction
		 */
		private SQLDatabaseConnectionManager()
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
			finally {
				if (connection != null) try { connection.close(); } catch(Exception e) {e.printStackTrace();}
			}
		}
		/**
		 * Returns the singleton connection manager
		 * @return singleton of the object
		 */
		public static SQLDatabaseConnectionManager getSingleton()
		{
			if(singleton == null)
			{
				singleton = new SQLDatabaseConnectionManager();
			}
			return singleton;
		}
		
		/**
		 * Gets the connection to the database
		 * @return connection
		 */
		public Connection getConnection()
		{
			return connection;
		}
}

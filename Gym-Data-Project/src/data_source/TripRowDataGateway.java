/**
 * 
 */
package data_source;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import domain.TripDTO;

/**
 * @author Alec Waddelow 
 * 
 * A row data gateway for a single trip to the gym 
 *
 */
public class TripRowDataGateway implements RowDataGateway
{
	Connection connection;
	Date date;
	double lengthOfTrip;
	double lengthOfCardio;
	double lengthOfLifting;
	double lengthOfSauna;
	int weight;
	String comment;
	
	/**
	 * Standard constructor
	 * 
	 * @param date
	 * @param lengthOfTrip
	 * @param lengthOfCardio
	 * @param lengthOfLifting
	 * @param lengthOfSauna
	 * @param weight
	 * @param comment
	 */
	public TripRowDataGateway(Date date, double lengthOfTrip, double lengthOfCardio, double lengthOfLifting, double lengthOfSauna,
			int weight, String comment) 
	{
		super();
		this.date = date;
		this.lengthOfTrip = lengthOfTrip;
		this.lengthOfCardio = lengthOfCardio;
		this.lengthOfLifting = lengthOfLifting;
		this.lengthOfSauna = lengthOfSauna;
		this.weight = weight;
		this.comment = comment;
	}
	
	/* (non-Javadoc)
	 * @see data_source.RowDataGateway#addRow(Date, double, double, double, double, int, java.lang.String)
	 */
	@Override
	public void addRow() throws SQLException 
	{
		connection = SQLDatabaseConnectionManager.getSingleton().getConnection();
		String addSql = "INSERT INTO dbo.TripData (date, lengthOfTrip, lengthOfCardio, lengthOfLifting, lengthOfSauna, weight, comment) VALUES (?, ?, ?, ?, ?, ?, ?)";
		
		PreparedStatement stmt = connection.prepareStatement(addSql);
		stmt.setDate(1, this.date);
		stmt.setDouble(2, this.lengthOfTrip);
		stmt.setDouble(3, this.lengthOfCardio);
		stmt.setDouble(4, this.lengthOfLifting);
		stmt.setDouble(5, this.lengthOfSauna);
		stmt.setInt(6, this.weight);
		stmt.setString(7, this.comment);
		stmt.executeUpdate();
		stmt.close();
		connection.close();
	}

	/* (non-Javadoc)
	 * @see data_source.RowDataGateway#updateRow(java.util.Date, double, double, double, double, int, java.lang.String)
	 */
	@Override
	public void updateRow(Date date) 
	{
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * @see data_source.RowDataGateway#deleteRow(java.util.Date)
	 */
	@Override
	public void deleteRow(Date date) {
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * @see data_source.RowDataGateway#retrieveRow(java.util.Date)
	 */
	@Override
	public TripDTO retrieveRow(Date date) {
		// TODO Auto-generated method stub
		return null;
	}

}

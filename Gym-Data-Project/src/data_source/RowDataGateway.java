package data_source;

import java.sql.Date;
import java.sql.SQLException;
import domain.TripDTO;

/**
 * 
 * @author Alec Waddelow
 * 
 * Interface for RowDataGateways
 *
 */
public interface RowDataGateway 
{
	public void addRow() throws SQLException;
	
	public void updateRow(Date date);
	
	public void deleteRow(Date date);
	
	public TripDTO retrieveRow(Date date);
}

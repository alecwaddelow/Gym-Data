package data_source;

import java.util.Date;

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
	public void addRow(Date date, double lengthofTrip, double lengthOfCardio, double lengthOfLifting, double lengthOfSauna, int weight, String comment);
	
	public void updateRow(Date date, double lengthofTrip, double lengthOfCardio, double lengthOfLifting, double lengthOfSauna, int weight, String comment);
	
	public void deleteRow(Date date);
	
	public TripDTO retrieveRow(Date date);
}

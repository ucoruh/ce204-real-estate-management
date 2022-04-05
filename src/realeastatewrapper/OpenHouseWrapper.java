/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.31.1.5860.78bb27cc6 modeling language!*/

package realeastatewrapper;

import java.sql.Date;
import java.sql.Time;

import realestate.*;
import realestate.PropertyForSale;


public class OpenHouseWrapper extends OpenHouse
{


	public OpenHouseWrapper(Date aDate, Time aStartTime, Time aEndTime, PropertyForSale aPropertyForSale) {
		super(aDate, aStartTime, aEndTime, aPropertyForSale);
		// TODO Auto-generated constructor stub
	}

	public long getRemainigTime()
	{
	     long remainingTimeInMiliseconds = this.getEndTime().getTime() - this.getStartTime().getTime();
		
		return remainingTimeInMiliseconds;
		
	}

	
  
}
/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.31.1.5860.78bb27cc6 modeling language!*/

package realestate;
import java.sql.Date;
import java.sql.Time;

// line 48 "../real-estate.ump"
public class OpenHouse
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //OpenHouse Attributes
  private Date date;
  private Time startTime;
  private Time endTime;

  //OpenHouse Associations
  private PropertyForSale propertyForSale;
  private Agent agentInCharge;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public OpenHouse(Date aDate, Time aStartTime, Time aEndTime, PropertyForSale aPropertyForSale)
  {
    date = aDate;
    startTime = aStartTime;
    endTime = aEndTime;
    boolean didAddPropertyForSale = setPropertyForSale(aPropertyForSale);
    if (!didAddPropertyForSale)
    {
      throw new RuntimeException("Unable to create openHous due to propertyForSale. See http://manual.umple.org?RE002ViolationofAssociationMultiplicity.html");
    }
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setDate(Date aDate)
  {
    boolean wasSet = false;
    date = aDate;
    wasSet = true;
    return wasSet;
  }

  public boolean setStartTime(Time aStartTime)
  {
    boolean wasSet = false;
    startTime = aStartTime;
    wasSet = true;
    return wasSet;
  }

  public boolean setEndTime(Time aEndTime)
  {
    boolean wasSet = false;
    endTime = aEndTime;
    wasSet = true;
    return wasSet;
  }

  public Date getDate()
  {
    return date;
  }

  public Time getStartTime()
  {
    return startTime;
  }

  public Time getEndTime()
  {
    return endTime;
  }
  /* Code from template association_GetOne */
  public PropertyForSale getPropertyForSale()
  {
    return propertyForSale;
  }
  /* Code from template association_GetOne */
  public Agent getAgentInCharge()
  {
    return agentInCharge;
  }

  public boolean hasAgentInCharge()
  {
    boolean has = agentInCharge != null;
    return has;
  }
  /* Code from template association_SetOneToMany */
  public boolean setPropertyForSale(PropertyForSale aPropertyForSale)
  {
    boolean wasSet = false;
    if (aPropertyForSale == null)
    {
      return wasSet;
    }

    PropertyForSale existingPropertyForSale = propertyForSale;
    propertyForSale = aPropertyForSale;
    if (existingPropertyForSale != null && !existingPropertyForSale.equals(aPropertyForSale))
    {
      existingPropertyForSale.removeOpenHous(this);
    }
    propertyForSale.addOpenHous(this);
    wasSet = true;
    return wasSet;
  }
  /* Code from template association_SetOptionalOneToMany */
  public boolean setAgentInCharge(Agent aAgentInCharge)
  {
    boolean wasSet = false;
    Agent existingAgentInCharge = agentInCharge;
    agentInCharge = aAgentInCharge;
    if (existingAgentInCharge != null && !existingAgentInCharge.equals(aAgentInCharge))
    {
      existingAgentInCharge.removeOpenHous(this);
    }
    if (aAgentInCharge != null)
    {
      aAgentInCharge.addOpenHous(this);
    }
    wasSet = true;
    return wasSet;
  }

  public void delete()
  {
    PropertyForSale placeholderPropertyForSale = propertyForSale;
    this.propertyForSale = null;
    if(placeholderPropertyForSale != null)
    {
      placeholderPropertyForSale.removeOpenHous(this);
    }
    if (agentInCharge != null)
    {
      Agent placeholderAgentInCharge = agentInCharge;
      this.agentInCharge = null;
      placeholderAgentInCharge.removeOpenHous(this);
    }
  }


  public String toString()
  {
    return super.toString() + "["+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "date" + "=" + (getDate() != null ? !getDate().equals(this)  ? getDate().toString().replaceAll("  ","    ") : "this" : "null") + System.getProperties().getProperty("line.separator") +
            "  " + "startTime" + "=" + (getStartTime() != null ? !getStartTime().equals(this)  ? getStartTime().toString().replaceAll("  ","    ") : "this" : "null") + System.getProperties().getProperty("line.separator") +
            "  " + "endTime" + "=" + (getEndTime() != null ? !getEndTime().equals(this)  ? getEndTime().toString().replaceAll("  ","    ") : "this" : "null") + System.getProperties().getProperty("line.separator") +
            "  " + "propertyForSale = "+(getPropertyForSale()!=null?Integer.toHexString(System.identityHashCode(getPropertyForSale())):"null") + System.getProperties().getProperty("line.separator") +
            "  " + "agentInCharge = "+(getAgentInCharge()!=null?Integer.toHexString(System.identityHashCode(getAgentInCharge())):"null");
  }
}
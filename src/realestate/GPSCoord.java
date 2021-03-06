/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.31.1.5860.78bb27cc6 modeling language!*/

package realestate;

// line 13 "../real-estate.ump"
public class GPSCoord
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //GPSCoord Attributes
  private double lattitude;
  private double longitude;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public GPSCoord(double aLattitude, double aLongitude)
  {
    lattitude = aLattitude;
    longitude = aLongitude;
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setLattitude(double aLattitude)
  {
    boolean wasSet = false;
    lattitude = aLattitude;
    wasSet = true;
    return wasSet;
  }

  public boolean setLongitude(double aLongitude)
  {
    boolean wasSet = false;
    longitude = aLongitude;
    wasSet = true;
    return wasSet;
  }

  public double getLattitude()
  {
    return lattitude;
  }

  public double getLongitude()
  {
    return longitude;
  }

  public void delete()
  {}


  public String toString()
  {
    return super.toString() + "["+
            "lattitude" + ":" + getLattitude()+ "," +
            "longitude" + ":" + getLongitude()+ "]";
  }
}
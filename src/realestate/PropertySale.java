/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.31.1.5860.78bb27cc6 modeling language!*/

package realestate;

// line 37 "../real-estate.ump"
public class PropertySale
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //PropertySale Attributes
  private int salePrice;
  private String seller;
  private String buyer;

  //PropertySale Associations
  private Property property;
  private PropertyForSale propertyForSale;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public PropertySale(int aSalePrice, String aSeller, String aBuyer, Property aProperty)
  {
    salePrice = aSalePrice;
    seller = aSeller;
    buyer = aBuyer;
    boolean didAddProperty = setProperty(aProperty);
    if (!didAddProperty)
    {
      throw new RuntimeException("Unable to create propertySale due to property. See http://manual.umple.org?RE002ViolationofAssociationMultiplicity.html");
    }
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setSalePrice(int aSalePrice)
  {
    boolean wasSet = false;
    salePrice = aSalePrice;
    wasSet = true;
    return wasSet;
  }

  public boolean setSeller(String aSeller)
  {
    boolean wasSet = false;
    seller = aSeller;
    wasSet = true;
    return wasSet;
  }

  public boolean setBuyer(String aBuyer)
  {
    boolean wasSet = false;
    buyer = aBuyer;
    wasSet = true;
    return wasSet;
  }

  public int getSalePrice()
  {
    return salePrice;
  }

  public String getSeller()
  {
    return seller;
  }

  public String getBuyer()
  {
    return buyer;
  }
  /* Code from template association_GetOne */
  public Property getProperty()
  {
    return property;
  }
  /* Code from template association_GetOne */
  public PropertyForSale getPropertyForSale()
  {
    return propertyForSale;
  }

  public boolean hasPropertyForSale()
  {
    boolean has = propertyForSale != null;
    return has;
  }
  /* Code from template association_SetOneToMany */
  public boolean setProperty(Property aProperty)
  {
    boolean wasSet = false;
    if (aProperty == null)
    {
      return wasSet;
    }

    Property existingProperty = property;
    property = aProperty;
    if (existingProperty != null && !existingProperty.equals(aProperty))
    {
      existingProperty.removePropertySale(this);
    }
    property.addPropertySale(this);
    wasSet = true;
    return wasSet;
  }
  /* Code from template association_SetOptionalOneToOptionalOne */
  public boolean setPropertyForSale(PropertyForSale aNewPropertyForSale)
  {
    boolean wasSet = false;
    if (aNewPropertyForSale == null)
    {
      PropertyForSale existingPropertyForSale = propertyForSale;
      propertyForSale = null;
      
      if (existingPropertyForSale != null && existingPropertyForSale.getPropertySale() != null)
      {
        existingPropertyForSale.setPropertySale(null);
      }
      wasSet = true;
      return wasSet;
    }

    PropertyForSale currentPropertyForSale = getPropertyForSale();
    if (currentPropertyForSale != null && !currentPropertyForSale.equals(aNewPropertyForSale))
    {
      currentPropertyForSale.setPropertySale(null);
    }

    propertyForSale = aNewPropertyForSale;
    PropertySale existingPropertySale = aNewPropertyForSale.getPropertySale();

    if (!equals(existingPropertySale))
    {
      aNewPropertyForSale.setPropertySale(this);
    }
    wasSet = true;
    return wasSet;
  }

  public void delete()
  {
    Property placeholderProperty = property;
    this.property = null;
    if(placeholderProperty != null)
    {
      placeholderProperty.removePropertySale(this);
    }
    if (propertyForSale != null)
    {
      propertyForSale.setPropertySale(null);
    }
  }


  public String toString()
  {
    return super.toString() + "["+
            "salePrice" + ":" + getSalePrice()+ "," +
            "seller" + ":" + getSeller()+ "," +
            "buyer" + ":" + getBuyer()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "property = "+(getProperty()!=null?Integer.toHexString(System.identityHashCode(getProperty())):"null") + System.getProperties().getProperty("line.separator") +
            "  " + "propertyForSale = "+(getPropertyForSale()!=null?Integer.toHexString(System.identityHashCode(getPropertyForSale())):"null");
  }
}
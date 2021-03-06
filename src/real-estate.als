module realestate

------------------------------------------------------------------------------------------------------------------

-- This Alloy file is generated using Umple from real-estate.ump

------------------------------------------------------------------------------------------------------------------


-- Defines a signature for class Address
sig Address {
  numberOnStreet : Int,
  apartmentOrUnit : Int,
  street : String,
  city : String,
  postalCode : String
}

-- Defines a signature for class GPSCoord
sig GPSCoord {
  lattitude : Int,
  longitude : Int
}

-- Defines a signature for class Property
sig Property {
  neighbourhood : one Neighbourhood,
  propertySales : set PropertySale,
  propertyForSales : set PropertyForSale,
  propertyAddress : Address,
  numberBedrooms : Int,
  numberBathrooms : Int,
  squareFeet : Int,
  numFloors : Int,
  gpsCoord : GPSCoord
}

-- Defines a signature for class Neighbourhood
sig Neighbourhood {
  properties : set Property,
  agents : set Agent,
  description : String,
  gpsCoordsOfBoundary : set GPSCoord
}

-- Defines a signature for class PropertySale
sig PropertySale {
  property : one Property,
  propertyForSale : lone PropertyForSale,
  salePrice : Int,
  seller : String,
  buyer : String
}

-- Defines a signature for class OpenHouse
sig OpenHouse {
  propertyForSale : one PropertyForSale,
  agentInCharge : lone Agent,
  date : String,
  startTime : String,
  endTime : String
}

-- Defines a signature for class Agent
sig Agent {
  specializingNeighbourhoods : set Neighbourhood,
  openHouses : set OpenHouse,
  propertyForSales : set PropertyForSale,
  name : String,
  licenseNumber : String,
  emailAddress : String,
  officePhoneNumber : String,
  cellPhoneNumber : String,
  officeAddress : Address
}

-- Defines a signature for class PropertyForSale
sig PropertyForSale {
  listedProperty : one Property,
  listingAgent : lone Agent,
  propertySale : lone PropertySale,
  openHouses : set OpenHouse,
  listingNumber : Int,
  askingPrice : Int,
  dateListedForSale : String
}


-- Defines constraints on association between Neighbourhood and Property
fact AssociationFact {
  Neighbourhood <: properties in (Neighbourhood) one -> one (Property)
}

-- Defines constraints on association between Property and PropertySale
fact AssociationFact {
  Property <: propertySales in (Property) one -> one (PropertySale)
}

-- Defines constraints on association between PropertyForSale and OpenHouse
fact AssociationFact {
  PropertyForSale <: openHouses in (PropertyForSale) one -> one (OpenHouse)
}

-- Defines constraints on association between Agent and OpenHouse
fact AssociationFact {
  Agent <: openHouses in (Agent) lone -> lone (OpenHouse)
}

-- Defines constraints on association between Neighbourhood and Agent
fact AssociationFact {
  Neighbourhood <: agents in (Neighbourhood) set -> set (Agent)
}

-- Defines constraints on association between Property and PropertyForSale
fact AssociationFact {
  Property <: propertyForSales in (Property) one -> one (PropertyForSale)
}

-- Defines constraints on association between Agent and PropertyForSale
fact AssociationFact {
  Agent <: propertyForSales in (Agent) lone -> lone (PropertyForSale)
}

-- Defines constraints on association between PropertySale and PropertyForSale
fact AssociationFact {
  PropertySale <: propertyForSale in (PropertySale) lone -> lone (PropertyForSale)
}

-- Defines bidirectionality rule between class Property and class Neighbourhood
fact BidirectionalityRule {
  all property_1 : Property, neighbourhood_1 : Neighbourhood |
    property_1 in properties[neighbourhood_1] <=> neighbourhood_1 in neighbourhood[property_1]
}

-- Defines bidirectionality rule between class PropertySale and class Property
fact BidirectionalityRule {
  all propertysale_1 : PropertySale, property_1 : Property |
    propertysale_1 in propertySales[property_1] <=> property_1 in property[propertysale_1]
}

-- Defines bidirectionality rule between class OpenHouse and class PropertyForSale
fact BidirectionalityRule {
  all openhouse_1 : OpenHouse, propertyforsale_1 : PropertyForSale |
    openhouse_1 in openHouses[propertyforsale_1] <=> propertyforsale_1 in propertyForSale[openhouse_1]
}

-- Defines bidirectionality rule between class OpenHouse and class Agent
fact BidirectionalityRule {
  all openhouse_1 : OpenHouse, agent_1 : Agent |
    openhouse_1 in openHouses[agent_1] <=> agent_1 in agentInCharge[openhouse_1]
}

-- Defines bidirectionality rule between class Agent and class Neighbourhood
fact BidirectionalityRule {
  all agent_1 : Agent, neighbourhood_1 : Neighbourhood |
    agent_1 in agents[neighbourhood_1] <=> neighbourhood_1 in specializingNeighbourhoods[agent_1]
}

-- Defines bidirectionality rule between class PropertyForSale and class Property
fact BidirectionalityRule {
  all propertyforsale_1 : PropertyForSale, property_1 : Property |
    propertyforsale_1 in propertyForSales[property_1] <=> property_1 in listedProperty[propertyforsale_1]
}

-- Defines bidirectionality rule between class PropertyForSale and class Agent
fact BidirectionalityRule {
  all propertyforsale_1 : PropertyForSale, agent_1 : Agent |
    propertyforsale_1 in propertyForSales[agent_1] <=> agent_1 in listingAgent[propertyforsale_1]
}

-- Defines bidirectionality rule between class PropertyForSale and class PropertySale
fact BidirectionalityRule {
  all propertyforsale_1 : PropertyForSale, propertysale_1 : PropertySale |
    propertyforsale_1 in propertyForSale[propertysale_1] <=> propertysale_1 in propertySale[propertyforsale_1]
}
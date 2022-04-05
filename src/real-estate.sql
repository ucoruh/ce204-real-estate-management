-- PLEASE DO NOT EDIT THIS CODE
-- This code was generated using the UMPLE 1.31.1.5860.78bb27cc6 modeling language!

CREATE DATABASE IF NOT EXISTS `realestate`;
USE `realestate`;

CREATE TABLE IF NOT EXISTS `realestate`.`address`
(
  /*------------------------*/
  /* MEMBER VARIABLES       */
  /*------------------------*/
  
  /*address Attributes*/
  number_on_street INT,
  apartment_or_unit INT,
  street VARCHAR(255),
  city VARCHAR(255),
  postal_code VARCHAR(255),
  PRIMARY KEY(number_on_street)

);



CREATE DATABASE IF NOT EXISTS `realestate`;
USE `realestate`;

CREATE TABLE IF NOT EXISTS `realestate`.`gps_coord`
(
  /*------------------------*/
  /* MEMBER VARIABLES       */
  /*------------------------*/
  
  /*gps_coord Attributes*/
  lattitude DOUBLE,
  longitude DOUBLE,
  PRIMARY KEY(lattitude)

);



CREATE DATABASE IF NOT EXISTS `realestate`;
USE `realestate`;

CREATE TABLE IF NOT EXISTS `realestate`.`property`
(
  /*------------------------*/
  /* MEMBER VARIABLES       */
  /*------------------------*/

  /*property Associations*/
  neighbourhood_description VARCHAR(255),
  
  /*property Attributes*/
  property_address BLOB,
  number_bedrooms INT,
  number_bathrooms INT,
  square_feet INT,
  num_floors INT,
  gps_coord BLOB,
  PRIMARY KEY(property_address_number_on_street)

);



CREATE DATABASE IF NOT EXISTS `realestate`;
USE `realestate`;

CREATE TABLE IF NOT EXISTS `realestate`.`neighbourhood`
(
  /*------------------------*/
  /* MEMBER VARIABLES       */
  /*------------------------*/
  
  /*neighbourhood Attributes*/
  description VARCHAR(255),
  UNKNOWN ID: attributeMany List<BLOB>,
  PRIMARY KEY(description)

);



CREATE DATABASE IF NOT EXISTS `realestate`;
USE `realestate`;

CREATE TABLE IF NOT EXISTS `realestate`.`property_sale`
(
  /*------------------------*/
  /* MEMBER VARIABLES       */
  /*------------------------*/

  /*property_sale Associations*/
  property_property_address_number_on_street INT,
  property_for_sale_listing_number INT,
  
  /*property_sale Attributes*/
  sale_price INT,
  seller VARCHAR(255),
  buyer VARCHAR(255),
  PRIMARY KEY(sale_price)

);



CREATE DATABASE IF NOT EXISTS `realestate`;
USE `realestate`;

CREATE TABLE IF NOT EXISTS `realestate`.`open_house`
(
  /*------------------------*/
  /* MEMBER VARIABLES       */
  /*------------------------*/

  /*open_house Associations*/
  property_for_sale_listing_number INT,
  agent_name VARCHAR(255),
  
  /*open_house Attributes*/
  date DATE,
  start_time TIME,
  end_time TIME,
  PRIMARY KEY(date)

);



CREATE DATABASE IF NOT EXISTS `realestate`;
USE `realestate`;

CREATE TABLE IF NOT EXISTS `realestate`.`agent`
(
  /*------------------------*/
  /* MEMBER VARIABLES       */
  /*------------------------*/
  
  /*agent Attributes*/
  name VARCHAR(255),
  license_number VARCHAR(255),
  email_address VARCHAR(255),
  office_phone_number VARCHAR(255),
  cell_phone_number VARCHAR(255),
  office_address BLOB,
  PRIMARY KEY(name)

);



CREATE DATABASE IF NOT EXISTS `realestate`;
USE `realestate`;

CREATE TABLE IF NOT EXISTS `realestate`.`property_for_sale`
(
  /*------------------------*/
  /* MEMBER VARIABLES       */
  /*------------------------*/

  /*property_for_sale Associations*/
  property_property_address_number_on_street INT,
  agent_name VARCHAR(255),
  property_sale_sale_price INT,
  
  /*property_for_sale Attributes*/
  listing_number INT,
  asking_price INT,
  date_listed_for_sale DATE,
  PRIMARY KEY(listing_number)

);




ALTER TABLE `realestate`.`property` ADD CONSTRAINT `fk_property_neighbourhood_description` FOREIGN KEY (`neighbourhood_description`) REFERENCES `realestate`.`neighbourhood`(`description`);


ALTER TABLE `realestate`.`property_sale` ADD CONSTRAINT `fk_propertysale_property_property_address_number_on_street` FOREIGN KEY (`property_property_address_number_on_street`) REFERENCES `realestate`.`property`(`property_address_number_on_street`);
ALTER TABLE `realestate`.`property_sale` ADD CONSTRAINT `fk_propertysale_property_for_sale_listing_number` FOREIGN KEY (`property_for_sale_listing_number`) REFERENCES `realestate`.`property_for_sale`(`listing_number`);

ALTER TABLE `realestate`.`open_house` ADD CONSTRAINT `fk_openhouse_property_for_sale_listing_number` FOREIGN KEY (`property_for_sale_listing_number`) REFERENCES `realestate`.`property_for_sale`(`listing_number`);
ALTER TABLE `realestate`.`open_house` ADD CONSTRAINT `fk_openhouse_agent_name` FOREIGN KEY (`agent_name`) REFERENCES `realestate`.`agent`(`name`);


ALTER TABLE `realestate`.`property_for_sale` ADD CONSTRAINT `fk_propertyforsale_property_property_address_number_on_street` FOREIGN KEY (`property_property_address_number_on_street`) REFERENCES `realestate`.`property`(`property_address_number_on_street`);
ALTER TABLE `realestate`.`property_for_sale` ADD CONSTRAINT `fk_propertyforsale_agent_name` FOREIGN KEY (`agent_name`) REFERENCES `realestate`.`agent`(`name`);
ALTER TABLE `realestate`.`property_for_sale` ADD CONSTRAINT `fk_propertyforsale_property_sale_sale_price` FOREIGN KEY (`property_sale_sale_price`) REFERENCES `realestate`.`property_sale`(`sale_price`);

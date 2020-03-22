USE `RESTDEMO`;

CREATE TABLE IF NOT EXISTS `ITEM` (
   `ID` BIGINT NOT NULL AUTO_INCREMENT,
   DESCRIPTION VARCHAR(500) NULL,
   PRICE DECIMAL(10,2) NOT NULL,
   BRAND VARCHAR(20) NULL,
   CREATED_DATE DATETIME NULL,
   PRIMARY KEY (`ID`)
) ENGINE=INNODB  DEFAULT CHARSET=UTF8;

INSERT INTO ITEM (DESCRIPTION, PRICE, BRAND, CREATED_DATE) VALUES 
('Colour - White ,Mic/Support play/Pause/Answer function,Suitable for all smartphones', 129.52, 'Samsang', NOW()),
('Memory, Storage & SIM: 3GB RAM | 32GB storage expandable up to 512GB | Dual nano SIM with dual standby (4G+4G)', 16500.36, 'Nokia', NOW()),
('SanDisk SecureAccess Software Protects Drive from Unauthorized Access', 350.22, 'SanDisk', NOW()),
('This genuine Lenovo Laptop comes with 1 year onsite domestic warranty from Lenovo covering manufacturing defects and not covering physical damage. For more details, see Warranty section', 18000.5, 'Lenovo', NOW()),
('In case of Wireless mouse, the USB receiver will be provided inside or along with the mouse', 399.88, 'Logitech', NOW()),
('India’s most recognized stationary,Used by generations of Indians with good reason', 98.63, 'Nataraj', NOW()),
('This genuine HP laptop comes with 1 year domestic warranty from HP covering manufacturing defects and not covering physical damage. For more details, see Warranty section below.', 24000.14, 'HP', NOW()),
('Pack of 20 1.5V AA Alkaline Batteries - Non-rechargeable batteries - do not attempt to recharge', 682.99, 'Penasonic', NOW()),
('2 HDMI ports to connect set top box, Blu Ray players, gaming console | 2 USB ports to connect hard drives and other USB devices | 1 VGA', 12000.75, 'MicroMax', NOW()),
('2 compartments, including a padded laptop compartment ideal for carrying laptops up to 15.6 inches', 529.36, 'Solimo', NOW());

CREATE TABLE IF NOT EXISTS `USER` (
   `ID` BIGINT NOT NULL AUTO_INCREMENT,
   NAME VARCHAR(200) NOT NULL,
   USERNAME VARCHAR(200) NOT NULL,
   PASSWORD VARCHAR(200) NOT NULL,
   ROLE VARCHAR(20) NOT NULL,
   CREATED_DATE DATETIME NULL,
   PRIMARY KEY (`ID`)
) ENGINE=INNODB  DEFAULT CHARSET=UTF8;
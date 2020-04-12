DROP TABLE IF EXISTS rate;
 
CREATE TABLE rate (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  currency VARCHAR(250) NOT NULL,
  price float NOT NULL,
  day_of_price Date DEFAULT NULL
);


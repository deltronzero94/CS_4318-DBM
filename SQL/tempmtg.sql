SET foreign_key_checks = 0;

drop table if exists Cards;

SET foreign_key_checks = 1;

CREATE TABLE Cards
(
    ID INT NOT NULL AUTO_INCREMENT,
        PRIMARY KEY (ID),
    CardName VARCHAR(100),
    MultiverseID SMALLINT 
);
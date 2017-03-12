SET foreign_key_checks = 0;

drop table if exists Cards;

SET foreign_key_checks = 1;

CREATE TABLE Cards
(
    ID INT NOT NULL AUTO_INCREMENT,
        PRIMARY KEY (ID),
    CardName VARCHAR(500),
    MultiverseID INT,
    Layout VARCHAR (60),
    ManaCost VARCHAR (60),
    CMC FLOAT,
    CardText VARCHAR(1000),
    CardType VARCHAR (100),
    Rarity VARCHAR(50),
    FlavorText VARCHAR(1000),
    Artist VARCHAR(100),
    Power VARCHAR(30),
    Toughness VARCHAR(30),
    Loyalty INT null,
    cardSet VARCHAR(80)
);
SET foreign_key_checks = 0;

drop table if exists Administrator;
drop table if exists Client;
drop table if exists MTG_Set;
drop table if exists Format;
drop table if exists Cards;
drop table if exists Rulings;
drop table if exists Deck;
drop table if exists Set_Cards;
drop table if exists Set_Format;
drop table if exists Format_Cards;
drop table if exists Deck_Cards;

SET foreign_key_checks = 1;


CREATE TABLE MTG_Set
(
    SetName VARCHAR(30) PRIMARY KEY,
    ReleasedYear SMALLINT,
    Code VARCHAR(6),
    TypeOfSet VARCHAR(20) 
);


CREATE TABLE Cards
(
    SetName VARCHAR(30),
        FOREIGN KEY(SetName) REFERENCES MTG_Set(SetName),
    ID INT NOT NULL AUTO_INCREMENT,
        PRIMARY KEY (ID)
);
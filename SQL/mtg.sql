CREATE TABLE Administrator
(
    Username NVARCHAR(20) NOT NULL PRIMARY KEY,
    passwordHash BINARY(64) NOT NULL
);

CREATE TABLE Client
(
    Username NVARCHAR(20) PRIMARY KEY,
    passwordHash BINARY(64) NOT NULL
);

CREATE TABLE MTG_Set
(
    SetName VARCHAR(30) PRIMARY KEY,
    ReleasedYear SMALLINT,
    Code VARCHAR(6),
    TypeOfSet VARCHAR(20) PRIMARY KEY
);

CREATE TABLE Format
(
    FormatName VARCHAR(25) PRIMARY KEY
);  

CREATE TABLE Cards
(
    CardName VARCHAR(30) PRIMARY KEY,
    Mana VARCHAR(15),
    ConvertedManaCost SMALLINT,
    CardText TEXT,
    SuperType VARCHAR(15),
    SubType VARCHAR(15),
    Power_Toughness VARCHAR(10) 
);

CREATE TABLE Rulings
(
    CardName VARCHAR(30),
    TextRuling TEXT,
    RulingYear SMALLINT,
    PRIMARY KEY (CardName, TextRuling)
);

CREATE TABLE Deck
(
    Username NVARCHAR(20),
    DeckName VARCHAR(30),
    FormatName VARCHAR(25),
    PRIMARY KEY (Username, DeckName)
);

CREATE TABLE Set_Card
(
    SetName VARCHAR(30),
    CardName VARCHAR(30),
    Rarity VARCHAR(15),
    Artist VARCHAR(30),
    FlavorText TEXT,
    PRIMARY KEY (SetName, CardName)
);

CREATE TABLE Set_Format
(
    SetName VARCHAR(30),
    FormatName VARCHAR(25),
    PRIMARY KEY(SetName, FormatName)
);

CREATE TABLE Format_Card
(
    FormatName VARCHAR(25),
    CardName VARCHAR(30),
    PRIMARY KEY(FormatName, CardName)
);

CREATE TABLE Deck_Card
(
    DeckName VARCHAR(30),
    Username NVARCHAR(20),
    CardName VARCHAR(30),
    MainboardQty SMALLINT,
    SideboadrdQty SMALLINT,
    PRIMARY KEY (DeckName,Username)
);

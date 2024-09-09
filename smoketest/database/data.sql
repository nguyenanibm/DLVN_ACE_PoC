CREATE TABLE tcli
(
    cli_id       varchar(20)  PRIMARY KEY,
    cli_id_num   varchar(20)  NOT NULL
);

CREATE TABLE eApp_tbPotentialCustomer
(
    PotentialID     varchar(20)  PRIMARY KEY,
    PotentialType   varchar(20)  NOT NULL,
    Address         varchar(20)  NOT NULL,
    AddressCode     varchar(20)  NOT NULL
);

CREATE  PROCEDURE eApp_spSaveAppForm
(
    @p1 VARCHAR (200), 
    @p2 VARCHAR (200), 
    @p3 VARCHAR (200),
    @p4 VARCHAR (200),
    @p5 VARCHAR (200),
    @p6 VARCHAR (200),
    @p7 VARCHAR (200),
    @p8 VARCHAR (200),
    @p9 VARCHAR (200),
    @p10 VARCHAR (200),
    @p11 VARCHAR (200), 
    @p12 VARCHAR (200), 
    @p13 VARCHAR (200),
    @p14 VARCHAR (200),
    @p15 VARCHAR (200),
    @p16 VARCHAR (200),
    @p17 VARCHAR (200),
    @p18 VARCHAR (200),
    @p19 VARCHAR (200),
    @p20 VARCHAR (200),
    @p21 VARCHAR (200), 
    @p22 VARCHAR (200), 
    @p23 VARCHAR (200),
    @p24 VARCHAR (200),
    @p25 VARCHAR (200),
    @p26 INT,
    @p27 VARCHAR (200),
    @p28 VARCHAR (200),
    @p29 VARCHAR (200),
    @p30 VARCHAR (200),
    @p31 INT, 
    @p32 VARCHAR (200), 
    @p33 VARCHAR (200),
    @p34 VARCHAR (200),
    @p35 INT,
    @p36 INT,
    @p37 VARCHAR (200),
    @p38 VARCHAR (200),
    @p39 VARCHAR (200),
    @p40 VARCHAR (200),
    @p41 INT, 
    @p42 INT, 
    @p43 INT,
    @p44 VARCHAR (200),
    @p45 INT,
    @p46 INT,
    @p47 CHAR,
    @p48 INT OUT
)
AS
BEGIN
    SET NOCOUNT ON;
    SELECT @p48 = count(*)
        from tcli
        where tcli.cli_id=@p38
END;
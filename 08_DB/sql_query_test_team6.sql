CREATE TABLE Person (
    PersonID INT AUTO_INCREMENT NOT NULL,
    Name NVARCHAR(10),
    Gender NVARCHAR(5),
    PlaceOfOrigin NVARCHAR(100),
    Email NVARCHAR(30),
    PhoneNumber NVARCHAR(15),
    RRN NVARCHAR(20),
    CONSTRAINT pk_PersonID PRIMARY KEY (PersonID)
);



INSERT INTO Person VALUES ('남길동', '남', '경기도 성남시 분당구 대왕판교로645번길', 'gildong@sql.com', '010-3244-2313', '130914-*******');
INSERT INTO Person VALUES ('남석환', '남', '경기도 성남시 분당구 대왕판교로645번길', 'sunghwan@sql.com', '010-3212-8854', '540514-*******');
INSERT INTO Person VALUES ('박한나', '여', '서울특별시 중구 세종대로 110번길', 'hanna@sql.com', '010-4725-2321', '551022-*******');
INSERT INTO Person VALUES ('남기준', '남', '경기도 성남시 분당구 대왕판교로645번길', 'gijun@sql.com', '010-4295-1112', '790510-*******');

CREATE TABLE Address (
		AddressID int,
        PersonID int,
        ReportDate date,
        Address nvarchar(100),
        ResidenceOrNot nvarchar(10),
        
        CONSTRAINT pk_AddressID PRIMARY KEY (AddressID),
        CONSTRAINT fk_PersonID FOREIGN KEY (PersonID) REFERENCES Person(PersonID)
);

INSERT INTO Address VALUES (1339, 4, '2013-03-05', '경기도 성남시 분당구 대왕판교로 645번길', 'Resident');
INSERT INTO Address VALUES (1032, 4, '2009-10-31', '경기도 성남시 분당구 불정로 90번길', 'Transfer');
INSERT INTO Address VALUES (903, 4, '2007-10-31', '서울시 동작구 상도로 940번', 'Transfer');

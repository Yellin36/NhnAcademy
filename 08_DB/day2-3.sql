CREATE TABLE Passenger (
   PassengerNo int,
   PassengerName nvarchar(20),
   Grade int,
   Age int,
   CONSTRAINT pk_Passenger PRIMARY KEY(PassengerNo)
);
INSERT INTO Passenger VALUES(1, '홍길동', 1, 44);
INSERT INTO Passenger VALUES(2, '이순신', 10, 44);
INSERT INTO Passenger VALUES(3, '안중근', 7, 32);
INSERT INTO Passenger VALUES(4, '김영량', 9, 54);
INSERT INTO Passenger VALUES(5, '김소월', 9, 45);
INSERT INTO Passenger VALUES(6, '윤동주', 10, 26);
INSERT INTO Passenger VALUES(7, '천상병', 8, 55);

CREATE TABLE Aircraft (
   AircraftNo int,
   KindOfAircraft nvarchar(30),
   Airline nvarchar(30),
   CONSTRAINT pk_Aircraft PRIMARY KEY(AircraftNo)
);
INSERT INTO Aircraft VALUES(101, '보잉 747', '대한항공');
INSERT INTO Aircraft VALUES(102, '보잉 727', '대한항공');
INSERT INTO Aircraft VALUES(103, '에어버스 A380', '아시아나 항공');
INSERT INTO Aircraft VALUES(104, '에어버스 A300', '대한항공');
INSERT INTO Aircraft VALUES(105, '보잉 737-800', '제주항공');

CREATE TABLE Flight (
   FlightNo int,
   AircraftNo int,
   Departure nvarchar(30),
   Arrival nvarchar(30),
   FlightDate datetime,
   CONSTRAINT pk_Flight PRIMARY KEY(FlightNo),
   CONSTRAINT fk_Aircraft_ID FOREIGN KEY(AircraftNo) REFERENCES Aircraft(AircraftNo)
);
INSERT INTO Flight VALUES(1, 101, '인천', '샌프란시스코', str_to_date('2022-10-23 10:20 AM', '%Y-%m-%d %h:%i %p'));
INSERT INTO Flight VALUES(2, 101, '샌프란시스코', '인천', str_to_date('2022-10-26 01:00 PM', '%Y-%m-%d %h:%i %p'));
INSERT INTO Flight VALUES(3, 105, '김포', '제주', str_to_date('2022-11-13 09:00 AM', '%Y-%m-%d %h:%i %p'));
INSERT INTO Flight VALUES(4, 104, '김포', '김해', str_to_date('2022-11-12 05:30 PM', '%Y-%m-%d %h:%i %p'));
INSERT INTO Flight VALUES(5, 103, '인천', '프랑크푸르트', str_to_date('2022-12-01 06:00 PM', '%Y-%m-%d %h:%i %p'));
INSERT INTO Flight VALUES(6, 103, '프랑크푸르트', '인천', str_to_date('2022-12-10 10:00 AM', '%Y-%m-%d %h:%i %p'));
INSERT INTO Flight VALUES(7, 104, '김해', '김포', str_to_date('2022-11-13 11:00 AM', '%Y-%m-%d %h:%i %p'));
INSERT INTO Flight VALUES(8, 101, '인천', '샌프란시스코', str_to_date('2022-11-15 10:00 AM', '%Y-%m-%d %h:%i %p'));

CREATE TABLE Reservation (
   PassengerNo int,
   FlightNo int,
   ReservedDate date,
   CONSTRAINT fk_Passenger_ID FOREIGN KEY(PassengerNo) references Passenger(PassengerNo),
   CONSTRAINT fk_Flight_ID FOREIGN KEY(FlightNo) REFERENCES Flight(FlightNo)
);

INSERT INTO Reservation VALUES(1, 4, STR_TO_DATE('2022-10-22', '%Y-%m-%d'));
INSERT INTO Reservation VALUES(3, 1, STR_TO_DATE('2022-10-20', '%Y-%m-%d'));
INSERT INTO Reservation VALUES(4, 7, STR_TO_DATE('2022-10-11', '%Y-%m-%d'));
INSERT INTO Reservation VALUES(6, 6, STR_TO_DATE('2022-10-21', '%Y-%m-%d'));
INSERT INTO Reservation VALUES(2, 1, STR_TO_DATE('2022-10-11', '%Y-%m-%d'));
INSERT INTO Reservation VALUES(2, 2, STR_TO_DATE('2022-10-11', '%Y-%m-%d'));
INSERT INTO Reservation VALUES(7, 3, STR_TO_DATE('2022-09-11', '%Y-%m-%d'));
INSERT INTO Reservation VALUES(1, 3, STR_TO_DATE('2022-11-09', '%Y-%m-%d'));
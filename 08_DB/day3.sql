select Concat(passengername + '님') from passenger;

select kindofaircraft, airline, flightdate
from aircraft join flight on aircraft.aircraftno = flight.aircraftno;

select kindofaircraft, airline, flightdate 
from aircraft, flight 
where aircraft.aircraftno = flight.aircraftno;

select passengerName, kindofAircraft, departure from passenger inner join reservation on passenger.passengerNo = Reservation.passengerNo
 inner join flight on flight.flightno = reservation.flightno
 inner join aircraft on flight.aircraftno = aircraft.aircraftno;
 
select passengername, age
from passenger inner join reservation on passenger.passengerno   = reservation.passengerno;
    
select passengername, age reservedDate from passenger inner join reservation on passenger.passengerNo = reservation.passengerNo;
    
select passengername, age, reservedDate from passenger inner join reservation on passenger.passengerno   = reservation.passengerno;

select a.aircraftno, flightdate
from aircraft as a
inner join flight as f on a.aircraftno = f.aircraftno
where a.aircraftno = 101;

SELECT DISTINCT A.AircraftNo, A.Airline FROM
(SELECT * FROM Flight WHERE Departure = '인천'
UNION
SELEct * FROM Flight WHERE Arrival = '제주') AS tempFlight
INNER JOIN Aircraft AS A ON tempFlight.AircraftNo = A.AircraftNo;

select a.aircraftno, a.airline FROM
Aircraft AS A INNER JOIN Flight AS F ON A.Aircraftno = F.AircraftNo
WHERE
	F.Departure = '인천'
    OR
    F.Arrival = '제주';
    
select A.aircraftno, A.airline FROM
Aircraft AS A INNER JOIN Flight AS F ON A.Aircraftno = F.AircraftNo
WHERE
	F.Departure IN
    (SELECT Departure 
    FROM Passenger P INNER JOIN Reservation R ON P.PassengerNo = R.PassengerNo
    INNER JOIN Flight F ON F.FlightNo = R.FlightNo
    WHERE P.PassengerName = '홍길동');
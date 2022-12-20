 -- 1번 영화 '퍼스트 맨'의 제작 연도, 영문 제목, 러닝 타임, 플롯을 출력하세요.
SELECT ReleaseYear, Title, RunningTime, Plot FROM Movie WHERE KoreanTitle = '퍼스트 맨';

-- 2번 2003년에 개봉한 영화의 한글 제목과 영문 제목을 출력하세요 >> 41 lines
SELECT KoreanTitle, Title FROM Movie WHERE ReleaseYear = 2003;

-- 3번 영화 '블랙 팬서'의 작곡가를 고르세요 : Ludwig Göransson
SELECT Person.Name FROM Appear 
	INNER JOIN Movie ON Appear.MovieId = Movie.MovieId
    INNER JOIN Role ON Appear.RoleId = Role.RoleId
    INNER JOIN Person ON Appear.PersonId = Person.PersonId
WHERE Movie.KoreanTitle = '블랙 팬서' AND Role.RoleName = 'Composer';

-- 4번 영화 '토이스토리 2' 의 감독이 몇명인지 출력하세요 : 토이스토리 2는 존재하지 않는 데이터, 토이스토리3는 1개 존재함.
SELECT COUNT(*) FROM Appear
	INNER JOIN Movie ON Appear.MovieId = Movie.MovieId
    INNER JOIN Role ON Appear.RoleId = Role.RoleId
    INNER JOIN Person ON Appear.PersonId = Person.PersonId
WHERE Movie.KoreanTitle = '토이스토리 2' AND Role.RoleName = 'Director';

-- 5번 : 감독이 2명 이상인 영화 출력. >> 86 lines
SELECT Title FROM Appear
	INNER JOIN Movie ON Appear.MovieId = Movie.MovieId
    INNER JOIN Person ON Appear.PersonId = Person.PersonId
    INNER JOIN Role ON Role.RoleID = Appear.RoleID
WHERE Role.RoleName = 'Director'
GROUP BY Movie.Title Having Count(*) >= 2;

-- 6번 '한스 짐머'가 참여한 영화 중 아카데미를 수상한 영화를 출력하세요 : 없음.
SELECT Title FROM Appear
	INNER JOIN Movie ON Appear.MovieId = Movie.MovieId
    INNER JOIN Person ON Appear.PersonId = Person.PersonId
    INNER JOIN AwardInvolve ON Appear.AppearId = AwardInvolve.AppearID
    INNER JOIN Winning ON Winning.WinningId = AwardInvolve.WinningID
WHERE Person.KoreanName = '한스 짐머' AND Winning.WinOrNot = 'Winner';

-- 8번 상영시간이 100분 이상인 영화 중 '레오나르도 디카프리오'가 출연한 영화를 고르시오 >> 11 lines
SELECT Title FROM Movie
	INNER JOIN Appear ON Appear.MovieId = Movie.MovieId
	INNER JOIN Person ON Appear.PersonId = Person.PersonId
WHERE Runningtime >= 100 AND Person.KoreanName = '레오나르도 디카프리오';

-- no.9 미성년자 관람불가 등급(R 등급)의 영화 중 가장 많은 수익을 얻은 영화를 고르시오 : Prometheus
SELECT Title, BoxOfficeWWGross FROM Movie
	INNER JOIN Grade ON Movie.GradeID = Grade.GradeID
WHERE Grade.GradeName = 'R'
ORDER BY BoxOfficeWWGross desc LIMIT 1;

-- no.10 1999년 이전에 제작된 영화의 수익 평균을 고르시오 : 333097795.0000
SELECT AVG(BoxOfficeWWGross) AS Gross From Movie
WHERE ReleaseYear < 1999;

-- no.11 가장 많은 제작비가 투입된 영화를 고르시오. : Avengers: Endgame
SELECT Title, Budget FROM Movie
ORDER BY Budget DESC LIMIT 1;

-- no.12 제작한 영화의 제작비 총합이 가장 높은 감독으로 고르시오 : Peter Jackson >> 1305000000
SELECT P.Name, SUM(M.Budget)  FROM Appear AS A
	INNER JOIN Movie AS M ON M.movieID = A.MovieID
	INNER JOIN Person AS P ON A.PersonId = P.PersonID
    INNER JOIN Role AS R ON R.RoleID = A.RoleID
WHERE R.RoleName = 'Director'
GROUP BY P.Name
ORDER BY SUM(M.Budget) DESC limit 1;

-- no.13 총 영화 수입이 가장 많은 배우를 출력하세요. : Stan Lee >> 12110923508
SELECT P.Name, SUM(M.BoxOfficeWWGross) FROM Appear AS A
	INNER JOIN Movie AS M ON M.movieID = A.MovieID
	INNER JOIN Person AS P ON A.PersonId = P.PersonID
    INNER JOIN Role AS R ON R.RoleID = A.RoleID
WHERE R.RoleName IN ('Actor', 'Actress')
GROUP BY P.Name
ORDER BY SUM(M.BoxOfficeWWGross) DESC limit 1;

-- no.14 제작비가 가장 적게 투입된 영화의 수익을 고르세요. : 52501541
SELECT BoxOfficeWWGross FROM Movie 
ORDER BY Budget Limit 1;

-- no.15 제작비가 5000만 달려 이하인 영화의 평균 수익을 고르세요 : 53903388.5270
SELECT AVG(BoxOfficeWWGross) FROM Movie WHERE Budget <= 50000000;

-- no.16 액션 장르 영화의 평균 수익을 고르세요 : 529211722.7767
SELECT AVG(BoxOfficeWWGross) FROM Movie
INNER JOIN MovieGenre On MovieGenre.MovieId = Movie.MovieId
INNER JOIN Genre ON MovieGenre.GenreId = Genre.GenreId
WHERE Genre.GenreName = 'Action';


-- no.17 드라마, 전쟁 장르의 영화를 고르세요. : 528 lines
SELECT Title, genre.genrename FROM Movie
INNER JOIN MovieGenre On MovieGenre.MovieId = Movie.MovieId
INNER JOIN Genre ON MovieGenre.GenreId = Genre.GenreId
WHERE Genre.GenreName IN ('Drama', 'War');

-- no.18 톰 행크스가 출연한 영화 중 상영 시간이 가장 긴 영화를 고르세요 : Bridge of Spies >> 144 min
SELECT Title, RunningTime FROM Movie
	INNER JOIN Appear ON Appear.MovieId = Movie.MovieId
    INNER JOIN Person ON Person.PersonID = Appear.PersonId
WHERE Person.KoreanName = '톰 행크스'
ORDER BY RunningTime DESC Limit 1;

-- no.19 아카데미 남우주연상을 가장 많이 수상한 배우를 고르시오 : 5 people >> 1 time
SELECT Person.Name, COUNT(*) FROM Appear
	INNER JOIN Movie ON Appear.MovieId = Movie.MovieId
    INNER JOIN Person ON Appear.PersonId = Person.PersonId
    INNER JOIN AwardInvolve ON Appear.AppearId = AwardInvolve.AppearID
    INNER JOIN Sector ON Sector.SectorID = AwardInvolve.SectorId
WHERE Sector.SectorName = 'Best Performance by an Actor in a Leading Role'
GROUP BY Person.PersonId 
ORDER BY COUNT(*) desc limit 5;

-- no.20 아카데미상을 가장 많이 수상한 영화인을 고르시오 : Green Book
SELECT Movie.Title FROM Appear
	INNER JOIN Movie ON Appear.MovieId = Movie.MovieId
    INNER JOIN Person ON Appear.PersonId = Person.PersonId
    INNER JOIN AwardInvolve ON Appear.AppearId = AwardInvolve.AppearId
    INNER JOIN Winning ON Winning.WinningId = AwardInvolve.WinningId
WHERE Winning.WinOrNot = 'Winner'
GROUP BY Movie.Title 
ORDER BY COUNT(*) DESC LIMIT 1;

-- no.21 : 아카데미 남우주연상을 2번 이상 수상한 배우를 고르시오 : none
SELECT Person.Name FROM Appear
	INNER JOIN Movie ON Appear.MovieId = Movie.MovieId
    INNER JOIN Person ON Appear.PersonId = Person.PersonId
    INNER JOIN AwardInvolve ON Appear.AppearId = AwardInvolve.AppearID
    INNER JOIN Sector ON Sector.SectorID = AwardInvolve.SectorId
WHERE Sector.SectorName = 'Best Performance by an Actor in a Leading Role'
GROUP BY Person.PersonId Having COUNT(*) >= 2;

-- no.22 존재하지 않음.

-- no.23 아카데미상을 가장 많이 수상한 사람을 고르세요. : Alfonso Cuaron, Nick Vallelonga, Brian Hayes Currie, Peter Farrelly >> 2 times
SELECT Person.Name, COUNT(*) FROM Appear
	INNER JOIN Movie ON Appear.MovieId = Movie.MovieId
    INNER JOIN Person ON Appear.PersonId = Person.PersonId
    INNER JOIN AwardInvolve ON Appear.AppearId = AwardInvolve.AppearId
    INNER JOIN Winning ON Winning.WinningId = AwardInvolve.WinningId
WHERE Winning.WinOrNot = 'Winner'
GROUP BY Person.Name 
ORDER BY COUNT(*) DESC limit 4;

-- no.24 아카데미상에 가장 많이 노미네이트 된 영화를 고르세요. : A Star Is Born, The Favourite >> 14번
SELECT Movie.Title, COUNT(*) FROM Appear
	INNER JOIN Movie ON Appear.MovieId = Movie.MovieId
    INNER JOIN AwardInvolve ON Appear.AppearId = AwardInvolve.AppearId
    INNER JOIN Winning ON Winning.WinningId = AwardInvolve.WinningId
WHERE Winning.WinOrNot = 'Nominated'
GROUP BY Movie.Title
ORDER BY COUNT(*) DESC limit 2;

-- no.25 : 가장 많은 영화에 출연한 여배우를 고르세요. : Scarlett Johansson >> 15times
SELECT Person.Name, COUNT(*) FROM Appear
	INNER JOIN Movie ON Appear.MovieId = Movie.MovieId
    INNER JOIN Person ON Appear.PersonId = Person.PersonId
    INNER JOIN Role ON Role.RoleID = Appear.RoleID
WHERE Role.RoleName = 'Actress'
GROUP BY Person.Name
ORDER BY COUNT(*) DESC limit 1;

-- no.26 수익이 가장 높은 영화 TOP 10을 출력하세요. 
SELECT Movie.Title, BoxOfficeWWGross AS Gross FROM Movie
ORDER BY BoxOfficeWWGross DESC Limit 10;

-- no.27 수익이 10억불 이상인 영화중 제작비가 1억불 이하인 영화를 고르시오. : 3 movies
SELECT Movie.Title, BoxOfficeWWGross, Budget FROM Movie
WHERE (BoxOfficeWWGross) > 1000000000 AND Budget < 100000000;

-- no.28 전쟁 영화를 가장 많이 감독한 사람을 고르세요. Clint Eastwood, Rachid Bouchareb >> 2 times
SELECT P.Name, COUNT(*) FROM Appear AS A
	INNER JOIN Person AS P ON A.PersonId = P.PersonID
    INNER JOIN MovieGenre AS MG ON A.MovieId = MG.MovieID
    INNER JOIN Genre AS G ON G.GenreId = MG.GenreId
    INNER JOIN Role AS R ON R.RoleID = A.RoleID
WHERE G.GenreName = 'War' AND R.RoleName = 'Director'
GROUP BY P.Name
ORDER BY COUNT(*) DESC Limit 2;

-- no.29 드라마에 가장 많이 출연한 사람을 고르세요 : Cate Blanchett >> 12 times
SELECT P.Name, COUNT(*) FROM Appear AS A
	INNER JOIN Person AS P ON A.PersonId = P.PersonID
    INNER JOIN MovieGenre AS MG ON A.MovieId = MG.MovieID
    INNER JOIN Genre AS G ON G.GenreId = MG.GenreId
    INNER JOIN Role AS R ON R.RoleID = A.RoleID
WHERE G.GenreName = 'Drama' AND R.RoleName IN ('Actor', 'Actress')
GROUP BY P.Name
ORDER BY COUNT(*) DESC limit 1;

-- no.30 드라마 장르에 출연했지만 호러 영화에 한번도 출연하지 않은 사람을 고르세요. >> 419 people
SELECT P.Name FROM Appear AS A
	INNER JOIN Person AS P ON A.PersonId = P.PersonID
    INNER JOIN MovieGenre AS MG ON A.MovieId = MG.MovieID
    INNER JOIN Genre AS G ON G.GenreId = MG.GenreId
    INNER JOIN Role AS R ON R.RoleID = A.RoleID
WHERE G.GenreName = 'Drama' AND NOT G.GenreName = 'Horror' AND R.RoleName IN ('Actor', 'Actress')
GROUP BY P.Name;

-- no.31. 아카데미 영화제가 가장 많이 열린 장소는 어디인가요? : Los Angeles, California, USA >> 16 times
 SELECT Location, COUNT(*) FROM AwardYear
 GROUP BY Location
 ORDER BY COUNT(*) DESC limit 1;
 
 -- no.33. 첫 번째 아카데미 영화제가 열린지 올해 기준으로 몇년이 지났나요? : 19 years
 SELECT TIMESTAMPDIFF(YEAR, AwardYear.Date, DATE_FORMAT(now(), '%Y-%m-%d'))  FROM AwardYear
 ORDER BY Year limit 1;
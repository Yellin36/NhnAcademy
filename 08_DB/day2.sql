DROP TABLE Member;

CREATE TABLE Member(
	MemberID int PRIMARY KEY,
    Name nvarchar(10),
    Address nvarchar(10)
);

 insert into Member VALUES(2, '김길동', '부산');
 insert into Member VALUES(4, '김길동', '부산');
 insert into Member VALUES(8, '김길동', '부산');
 insert into Member VALUES(22, '김길동', '부산');
 insert into Member VALUES(12, '김길동', '부산');
 insert into Member VALUES(6, '김길동', '부산');
 insert into Member VALUES(9, '김길동', '부산');
 insert into Member VALUES(1, '김길동', '부산');
 insert into Member VALUES(31, '김길동', '부산');
 
 SELECT * FROM Member;
 
 SELECT * FROM Member WHERE MemberID = 12;
 SELECT * FROM Member WHERE Name = '김길동';
 
 CREATE INDEX idx_Member_Name ON Member(MemberID);
 SELECT * FROM Member WHERE Name > '김길동';
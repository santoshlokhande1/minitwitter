DROP TABLE IF EXISTS Users;
DROP TABLE IF EXISTS Follower;
DROP TABLE IF EXISTS Tweet;

CREATE TABLE Users
(
  UserName varchar(100) NOT NULL,
  UserEmail     varchar(100) DEFAULT NULL,
  PRIMARY KEY (UserName)
);

CREATE TABLE Follower
(
  UserName varchar(100) NOT NULL,
  FollowerUserName     varchar(100) DEFAULT NULL
);

CREATE TABLE Tweet
(
  UserName varchar(100) NOT NULL,
  Text     varchar(100) DEFAULT NULL
);
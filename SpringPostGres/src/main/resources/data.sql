insert into Users(UserName , UserEmail) values('santosh','s@s.s');
insert into Users(UserName , UserEmail) values('sam','s1@s.s');

insert into Follower(UserName , FollowerUserName) values('santosh','sam');
insert into Follower(UserName , FollowerUserName) values('sam','santosh');

insert into Tweet(UserName , Text) values('sam','Hi First Tweet!');
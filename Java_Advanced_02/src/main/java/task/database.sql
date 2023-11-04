drop database if exists sport;

create database sport;
use sport;

create table sportsmen(
	id int primary key auto_increment,
    firstName varchar(30) not null,
    lastName varchar(30) not null,
    age int not null,
    kindOfSportID int not null,
    coachID int
);

create table kindOfSport(
	id int primary key auto_increment,
    name varchar(50) not null unique
);

create table coach(
	id int primary key auto_increment,
    firstName varchar(30) not null,
    lastName varchar(30) not null,
    age int not null,
    yearsOfExperience int not null
);
alter table sportsmen add foreign key (kindOfSportID) references kindOfSport(id);
alter table sportsmen add foreign key (coachID) references coach(id);

insert into kindOfSport (name) values ('Футбол'),('Бокс'),('Баскетбол'),('Плавання');
insert into coach (firstName, lastName, age, yearsOfExperience)
values ('Григір','Григорович', 33, 10), ('Олександр','Олександрович', 34, 8), ('Дмитро','Дмитрович', 28, 4);
insert into sportsmen (firstName, lastName, age, kindOfSportID, coachID) 
values ('Петро', 'Петрович', 25, 1, 1), ('Максим', 'Максимович', 28, 2, 3), ('Роман', 'Романович', 22, 4, 2); 

select * from coach;
select * from kindOfSport;
select * from sportsmen;



create table users (
id int,
first_name varchar(100),
last_name varchar(100)
);
create sequence users_sequence start 1 increment 1;


create table phones (
id int,
manufacture_id int,
name varchar(100),
creation_year int
);
create sequence phones_sequence start 1 increment 1;


create table manufactures (
id int,
name varchar(100),
address varchar(100)
);
create sequence manufactures_sequence start 1 increment 1;

create sequence web_users start 1 increment 1;


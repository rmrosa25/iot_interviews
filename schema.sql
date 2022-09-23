drop table if exists employees;
create table employees
(
    id int(11) not null auto_increment,
    employee_name varchar(128),
    department_id int(11),
    Primary Key (id)
);

drop table if exists departments;
create table departments
(
    id int(11) not null auto_increment,
    department_name varchar(128),
    Primary Key (id)
);

insert into employees (employee_name, department_id) values ('Homer Simpson',4);
insert into employees (employee_name, department_id) values ('Ned Flanders',1);
insert into employees (employee_name, department_id) values ('Barney Gumble',5);
insert into employees (employee_name, department_id) values ('Clancy Wiggum',3);
insert into employees (employee_name) values ('Moe Syzslak');


insert departments (department_name) values ('Sales');
insert departments (department_name) values ('Engineering');
insert departments (department_name) values ('Human Resources');
insert departments (department_name) values ('Customer Service');
insert departments (department_name) values ('Research And Development');


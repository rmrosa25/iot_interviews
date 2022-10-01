CREATE TABLE departments (
   id int auto_increment NOT NULL COMMENT 'id'
  ,department_name varchar(128) NOT NULL COMMENT 'Name'
  ,CONSTRAINT PK_departments PRIMARY KEY (id)
);
CREATE INDEX IK_departments_department_name ON departments (department_name);

CREATE TABLE employees (
   id int auto_increment NOT NULL COMMENT 'id'
  ,employee_name varchar(128) NOT NULL COMMENT 'Name'
  ,department_id int NULL COMMENT 'Department'
  ,CONSTRAINT PK_employees PRIMARY KEY (id)
);
CREATE INDEX IK_employees_employee_name ON employees (employee_name);


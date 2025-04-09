-- # UC 1 - Ability to create a payroll service database
CREATE DATABASE payroll_services;

show databases ;

use payroll_services


-- # UC 2 - Ability to create a employee payroll table in the payroll service database
create table employee_payroll(
    id INT unsigned NOT NULL AUTO_INCREMENT,
    name VARCHAR(50),
    salary DOUBLE,
    start_date DATE,
    PRIMARY KEY (id)
)

-- # UC 3 - Ability to create employee payroll data in the payroll service database
INSERT INTO employee_payroll
values
    (1,'Rishav',150000.0,'2003-1-29'),
    (2,'Anmol',120000.0,'2003-10-9'),
    (3,'Ankit',100000.0,'2002-7-2');

-- # UC 4 - Ability to retrieve all the employee payroll data
SELECT * FROM employee_payroll;

-- +--+------+------+----------+
-- |id|name  |salary|start_date|
-- +--+------+------+----------+
-- |1 |Rishav|150000|2003-01-29|
-- |2 |Anmol |120000|2003-10-09|
-- |3 |Ankit |100000|2002-07-02|
-- +--+------+------+----------+

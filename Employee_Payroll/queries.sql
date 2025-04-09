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
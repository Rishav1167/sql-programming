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

-- # UC 5 - Ability to retrieve salary data for a particular employee as well as all employees who have joined in a particular data range
SELECT salary FROM employee_payroll where name='Rishav';
-- +------+
-- |salary|
-- +------+
-- |150000|
-- +------+

SELECT * FROM employee_payroll WHERE start_date BETWEEN CAST('2001-01-01' AS DATE) AND DATE(NOW());

-- +--+------+------+----------+
-- |id|name  |salary|start_date|
-- +--+------+------+----------+
-- |1 |Rishav|150000|2003-01-29|
-- |2 |Anmol |120000|2003-10-09|
-- |3 |Ankit |100000|2002-07-02|
-- +--+------+------+----------+

-- # UC 6 - Ability to add Gender to Employee Payroll Table and Update the Rows to reflect the correct Employee Gender
ALTER TABLE employee_payroll ADD COLUMN gender VARCHAR(1);

UPDATE employee_payroll SET gender='M' WHERE id BETWEEN 1 AND 3;

SELECT * FROM employee_payroll;

-- +--+------+------+----------+------+
-- |id|name  |salary|start_date|gender|
-- +--+------+------+----------+------+
-- |1 |Rishav|150000|2003-01-29|M     |
-- |2 |Anmol |120000|2003-10-09|M     |
-- |3 |Ankit |100000|2002-07-02|M     |
-- +--+------+------+----------+------+


-- # UC 7 - Ability to find sum, average, min, max and number of male and female employees
SELECT gender, COUNT(id) FROM employee_payroll GROUP BY gender;

-- +------+---------+
-- |gender|COUNT(id)|
-- +------+---------+
-- |M     |3        |
-- +------+---------+

SELECT SUM(salary) from employee_payroll;

-- +-----------+
-- |SUM(salary)|
-- +-----------+
-- |370000     |
-- +-----------+



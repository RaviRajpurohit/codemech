CREATE TABLE IF NOT EXISTS department(
    id int primary key AUTO_INCREMENT,
    name varchar(100)
);

CREATE TABLE IF NOT EXISTS employee(
    id int primary key AUTO_INCREMENT,
    designation varchar(100),
    name varchar(100),
    salary double
);


CREATE TABLE IF NOT EXISTS employee_department(
    employee_id int,
    department_id int
);
ALTER TABLE employee_department
    ADD FOREIGN KEY (employee_id) 
    REFERENCES  employee(id);
ALTER TABLE employee_department
    ADD FOREIGN KEY (department_id) 
    REFERENCES  department(id);
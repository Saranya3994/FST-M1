REM   Script: FST_SQL
REM   FST SQL joins


create table customers ( 
    customer_id int primary key, customer_name varchar(32), 
    city varchar(20), grade int, salesman_id int);

INSERT ALL 
    INTO customers VALUES (3002, 'Nick Rimando', 'New York', 100, 5001) 
    INTO customers VALUES (3007, 'Brad Davis', 'New York', 200, 5001) 
    INTO customers VALUES (3005, 'Graham Zusi', 'California', 200, 5002) 
    INTO customers VALUES (3008, 'Julian Green', 'London', 300, 5002) 
    INTO customers VALUES (3004, 'Fabian Johnson', 'Paris', 300, 5006) 
    INTO customers VALUES (3009, 'Geoff Cameron', 'Berlin', 100, 5003) 
    INTO customers VALUES (3003, 'Jozy Altidor', 'Moscow', 200, 5007) 
    INTO customers VALUES (3001, 'Brad Guzan', 'London', 300, 5005) 
SELECT 1 FROM DUAL;

SELECT a.customer_name AS "Customer Name", a.city, b.name AS "Salesman", b.commission FROM customers a  
INNER JOIN salesman b ON a.salesman_id=b.salesman_id;

create table customers ( 
    customer_id int primary key, customer_name varchar(32), 
    city varchar(20), grade int, salesman_id int);

INSERT ALL 
    INTO customers VALUES (3002, 'Nick Rimando', 'New York', 100, 5001) 
    INTO customers VALUES (3007, 'Brad Davis', 'New York', 200, 5001) 
    INTO customers VALUES (3005, 'Graham Zusi', 'California', 200, 5002) 
    INTO customers VALUES (3008, 'Julian Green', 'London', 300, 5002) 
    INTO customers VALUES (3004, 'Fabian Johnson', 'Paris', 300, 5006) 
    INTO customers VALUES (3009, 'Geoff Cameron', 'Berlin', 100, 5003) 
    INTO customers VALUES (3003, 'Jozy Altidor', 'Moscow', 200, 5007) 
    INTO customers VALUES (3001, 'Brad Guzan', 'London', 300, 5005) 
SELECT 1 FROM DUAL;

SELECT a.customer_name AS "Customer Name", a.city, b.name AS "Salesman", b.commission FROM customers a  
INNER JOIN salesman b ON a.salesman_id=b.salesman_id;

INSERT INTO salesman  
VALUES (5001, "James Hoog", "New York", 15);

INSERT INTO salesman VALUES (5001, "James Hoog", "New York", 15);

INSERT INTO salesman values (5002, "Nail Knite", "Paris", 13);

INSERT INTO salesman VALUES(5002, 'Nail Knite', 'Paris', 13);

INSERT ALL   
 INTO salesman VALUES (5005, "Pit Alex", "London", 11)  
 INTO salesman VALUES (5006, "McLyon", "Paris", 14)  
 INTO salesman VALUES (5007, "Paul Adam", "Rome", 13)  
 INTO salesman VALUES (5003, "Lauson Hen", "San Jose", 12)  
SELECT 1 FROM DUAL;

INSERT ALL   
 INTO salesman VALUES (5005, 'Pit Alex', 'London', 11)  
 INTO salesman VALUES (5006, 'McLyon', 'Paris', 14)  
 INTO salesman VALUES (5007, 'Paul Adam', 'Rome', 13)  
 INTO salesman VALUES (5003, 'Lauson Hen', 'San Jose', 12)  
SELECT 1 FROM DUAL;

CREATE TABLE salesman (  
    salesman_id int,  
    salesman_name varchar2(32),  
    salesman_city varchar2(32),  
    commission int  
);

INSERT INTO salesman  
VALUES (5001, James Hoog, New York, 15);

CREATE TABLE salesman (  
    salesman_id int,  
    salesman_name varchar2(32),  
    salesman_city varchar2(32),  
    commission int  
);

INSERT INTO salesman  
VALUES (5001, "James Hoog", "New York", 15);

INSERT INTO salesman VALUES (5001, "James Hoog", "New York", 15);

INSERT INTO salesman values (5002, "Nail Knite", "Paris", 13);

INSERT INTO salesman VALUES(5002, 'Nail Knite', 'Paris', 13);

INSERT ALL   
 INTO salesman VALUES (5005, "Pit Alex", "London", 11)  
 INTO salesman VALUES (5006, "McLyon", "Paris", 14)  
 INTO salesman VALUES (5007, "Paul Adam", "Rome", 13)  
 INTO salesman VALUES (5003, "Lauson Hen", "San Jose", 12)  
SELECT 1 FROM DUAL;

INSERT ALL   
 INTO salesman VALUES (5005, 'Pit Alex', 'London', 11)  
 INTO salesman VALUES (5006, 'McLyon', 'Paris', 14)  
 INTO salesman VALUES (5007, 'Paul Adam', 'Rome', 13)  
 INTO salesman VALUES (5003, 'Lauson Hen', 'San Jose', 12)  
SELECT 1 FROM DUAL;

SELECT a.customer_name AS "Customer Name", a.city, b.name AS "Salesman", b.commission FROM customers a  
INNER JOIN salesman b ON a.salesman_id=b.salesman_id;

SELECT a.order_no, a.order_date, a.purchase_amount, b.customer_name AS "Customer Name", b.grade, c.name AS "Salesman", c.commission FROM orders a  
INNER JOIN customers b ON a.customer_id=b.customer_id  
INNER JOIN salesman c ON a.salesman_id=c.salesman_id;


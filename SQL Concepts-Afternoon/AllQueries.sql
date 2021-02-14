use assignment;
select database();

create table location(
location_code varchar(5),
location_name varchar(20),
primary key (location_code)
);

insert into location values('MPL','MANIPAL');
insert into location values('KNU','KANPUR');
insert into location values('DEL','DELHI');
select * from location;

create table category(
category_code varchar(5),
category_name varchar(20),
primary key (category_code)
);

insert into category values('PHN','PHONE');
insert into category values('TV','TELEVISION');
insert into category values('RFG','REGRIGERATOR');
select * from category;

create table salesExecutive(
salesExecutive_id int,
salesExecutive_name varchar(50),
salesExecutive_dob date,
salesExecutive_gender varchar(10),
salesExecutive_mobile int,
salesExecutive_locationCode varchar(5),
primary key(salesExecutive_id),
foreign key(salesExecutive_locationCode) references location(location_code)
);


insert into salesExecutive values(1,'Alex','1990-01-01','MALE','1234','MPL');
insert into salesExecutive values(2,'Baron','1991-01-01','MALE','3535','MPL');
insert into salesExecutive values(3,'Cathey','1992-01-01','FEMALE','567574','MPL');
insert into salesExecutive values(4,'Derek','1993-01-01','MALE','1464','KNU');
insert into salesExecutive values(5,'Erfan','1994-01-01','MALE','16564','KNU');
insert into salesExecutive values(6,'Farukh','1995-01-01','MALE','16464','KNU');
insert into salesExecutive values(7,'Golu','1996-01-01','MALE','123554','DEL');
insert into salesExecutive values(8,'Haider','1997-01-01','MALE','13534','DEL');
insert into salesExecutive values(9,'Ishu','1998-01-01','MALE','12533','DEL');
insert into salesExecutive values(10,'Jaishri','1999-01-01','FEMALE','12454','DEL');
select * from salesexecutive ;

create table product(
product_code int,
product_name varchar(20),
product_unitPrice int,
product_categoryCode varchar(5),
product_salesExecutiveId int,
primary key(product_code),
foreign key(product_categoryCode) references category(category_code),
foreign key(product_salesExecutiveId) references salesExecutive(salesExecutive_id)
);

insert into product values(1,'S8',30000,'PHN',1);
insert into product values(2,'S9',40000,'PHN',2);
insert into product values(3,'S10',50000,'PHN',2);
insert into product values(4,'S20',60000,'PHN',3);
insert into product values(5,'S21',70000,'PHN',3);
insert into product values(6,'MO-TV',10,'TV',4);
insert into product values(7,'SO-TV',20,'TV',4);
insert into product values(8,'RO-TV',30,'TV',5);
insert into product values(9,'PO-TV',40,'TV',5);
insert into product values(10,'KO-TV',50,'TV',1);
insert into product values(11,'AS-RFG',60,'RFG',6);
insert into product values(12,'WE-RFG',70,'RFG',7);
insert into product values(13,'CT-RFG',80,'RFG',8);
insert into product values(14,'ED-RFG',90,'RFG',9);
insert into product values(15,'GR-RFG',100,'RFG',10);

select * from product;

create table customer(
customer_id int,
customer_name varchar(20),
customer_dob date,
customer_gender varchar(10),
customer_mobile int,
customer_locationCode varchar(5),
primary key(customer_id),
foreign key(customer_locationCode) references location(location_code)
);

insert into customer values(1,'Arjun','1980-01-01','MALE',1234,'MPL');
insert into customer values(2,'Bharat','1981-01-01','MALE',3434,'MPL');
insert into customer values(3,'Dharun','1982-01-01','MALE',545,'MPL');
insert into customer values(4,'Ella','1983-01-01','MALE',353,'MPL');
insert into customer values(5,'Fawad','1984-01-01','MALE',3535,'MPL');
insert into customer values(6,'Gopal','1985-01-01','MALE',6565,'KNU');
insert into customer values(7,'Imaan','1986-01-01','MALE',53456,'KNU');
insert into customer values(8,'John','1987-01-01','MALE',4365,'KNU');
insert into customer values(9,'Karan','1988-01-01','MALE',4565,'KNU');
insert into customer values(10,'Lokesh','1989-01-01','MALE',4546,'KNU');
insert into customer values(11,'Manoj','1990-01-01','MALE',5775,'DEL');
insert into customer values(12,'Nayan','1991-01-01','MALE',5456,'DEL');
insert into customer values(13,'Parth','1992-01-01','MALE',34347,'DEL');
insert into customer values(14,'Ramesh','1993-01-01','MALE',4546,'DEL');
insert into customer values(15,'Suresh','1994-01-01','MALE',8675,'DEL');

select * from customer;

create table orders(
customer_id int,
product_code int,
dateOfPurchase date,
quantity int,
primary key(customer_id, product_code),
foreign key(customer_id) references customer(customer_id),
foreign key(product_code) references product(product_code)
);

insert into orders values(1,1,'2021-02-07',1);
insert into orders values(2,2,'2021-02-07',1);
insert into orders values(3,2,'2021-02-07',1);
insert into orders values(4,2,'2021-02-08',1);
insert into orders values(5,10,'2021-02-08',1);
insert into orders values(6,6,'2021-02-09',1);
insert into orders values(7,7,'2021-02-09',1);
insert into orders values(8,7,'2021-02-10',1);
insert into orders values(9,7,'2021-02-10',1);
insert into orders values(10,9,'2021-02-11',1);
insert into orders values(11,12,'2021-02-12',1);
insert into orders values(12,13,'2021-02-13',1);
insert into orders values(13,14,'2021-02-14',1);
insert into orders values(14,14,'2021-02-08',1);
insert into orders values(15,14,'2021-02-08',1);
insert into orders values(11,14,'2021-02-08',1);
insert into orders values(12,14,'2021-02-09',1);
insert into orders values(13,12,'2021-02-10',1);
insert into orders values(14,11,'2021-02-07',1);
insert into orders values(15,11,'2021-02-09',1);
insert into orders values(13,11,'2021-02-09',1);
insert into orders values(12,15,'2021-02-11',1);
insert into orders values(12,11,'2021-02-09',1);

select * from orders;


select salesexecutive.salesExecutive_id,salesexecutive.salesExecutive_name, count(orders.product_code) as 'No. of products sold'
from salesexecutive, orders, product
where salesexecutive.salesExecutive_id=product.product_salesExecutiveId and product.product_code=orders.product_code
group by salesExecutive_id,salesExecutive_name;

select distinct d.dateOfPurchase, q.product_code as TopSellingProductCode
from orders as d, customer c, lateral (select count(e.product_code) as totalQuantity, e.product_code
from orders as e
where e.dateOfPurchase=d.dateOfPurchase and c.customer_id =e.customer_id
group by e.product_code
order by totalQuantity desc limit 1) as q
where d.dateOfPurchase>='2021-02-07' and d.dateOfPurchase<='2021-02-14' and c.customer_locationCode='DEL' 
and c.customer_id =d.customer_id
order by d.dateofPurchase;

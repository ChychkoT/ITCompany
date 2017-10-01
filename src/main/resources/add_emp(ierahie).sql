
/*insert into COUNTRY (COUNTRY_NAME) value ("Belarus"),("Latvia"),("Lithuania"),("Poland"),("Russia"),("Ukraine");

insert into EMPLOYEES (NAME_EMPLOYEE,DATE_OF_BIRTH,SALARY) value ("Ivanov Ilia",'1990-02-11',5000);
insert into ADDRESSES (COUNTRY_ID,CITY,STREET,HOUSE,EMPLOYEES_ID) value (5,"Moscow","Lenina","21",1);
insert into ADMINISTRATION (EMPLOYEES_ID) value (1);
insert into DIRECTORS (ADMINISTRATION_ID) value (1);

insert into EMPLOYEES (NAME_EMPLOYEE,DATE_OF_BIRTH,SALARY) value ("Ivanovich Elena",'1992-02-10',4500);
insert into ADDRESSES (COUNTRY_ID,CITY,STREET,HOUSE,EMPLOYEES_ID) value (1,"Minsk","Hemiga","44",2);
insert into ADMINISTRATION (EMPLOYEES_ID) value (2);
insert into DIRECTORS (ADMINISTRATION_ID) value (2);

insert into EMPLOYEES (NAME_EMPLOYEE,DATE_OF_BIRTH,SALARY) value ("Zaiceva Anna",'1989-04-07',2500);
insert into ADDRESSES (COUNTRY_ID,CITY,STREET,HOUSE,EMPLOYEES_ID) value (1,"Minsk","Hemiga","58",3);
insert into ADMINISTRATION (EMPLOYEES_ID) value (3);
insert into HRMANAGERS (ADMINISTRATION_ID) value (3);

insert into EMPLOYEES (NAME_EMPLOYEE,DATE_OF_BIRTH,SALARY) value ("Sidorov Oleg",'1987-05-03',2400);
insert into ADDRESSES (COUNTRY_ID,CITY,STREET,HOUSE,EMPLOYEES_ID) value (1,"Minsk","Hemiga","58",4);
insert into ADMINISTRATION (EMPLOYEES_ID) value (4);
insert into HRMANAGERS (ADMINISTRATION_ID) value (4);marketing

insert into EMPLOYEES (NAME_EMPLOYE,DATE_OF_BIRTH,SALARY) value ("Belaja Cvetlana",'1986-06-08',1200);
insert into ADDRESSES (COUNTRY_ID,CITY,STREET,HOUSE,EMPLOYEES_ID) value ("6,"Kiev","Sadovaja","14",5);
insert into MARKETING (EMPLOYEES_ID) value (5);
insert into MARKETOLOGS (MARKETING_ID) value (1);

insert into EMPLOYEES (NAME_EMPLOYEE,DATE_OF_BIRTH,SALARY) value ("Demchog Nikolaj",'1987-09-03',1400);
insert into ADDRESSES (COUNTRY_ID,CITY,STREET,HOUSE,EMPLOYEES_ID) value (1,"Minsk","Avrorovskaja","18",6);
insert into MARKETING (EMPLOYEES_ID) value (6);
insert into MARKETOLOGS (MARKETING_ID) value (2);

insert into EMPLOYEES (NAME_EMPLOYEE,DATE_OF_BIRTH,SALARY) value ("Kotov Andrej",'1985-11-11',1550);
insert into ADDRESSES (COUNTRY,CITY,STREET,HOUSE,EMPLOYEES_ID) value (2,"Riga","Severtranis","16",7);
insert into MARKETING (EMPLOYEES_ID) value (7);
insert into SALES (MARKETING_ID) value (3);

insert into EMPLOYEES (NAME_EMPLOYEE,DATE_OF_BIRTH,SALARY) value ("Kotovskaja Alena",'1988-10-01',2550);
insert into ADDRESSES (COUNTRY_ID,CITY,STREET,HOUSE,EMPLOYEES_ID) value (1,"Borovlyany","Severnaja","66",8);
insert into MARKETING (EMPLOYEES_ID) value (8);
insert into SALES (MARKETING_ID) value (4);

insert into EMPLOYEES (NAME_EMPLOYEE,DATE_OF_BIRTH,SALARY) value ("Kiselev Dmitrij",'1989-06-21',2000);
insert into ADDRESSES (COUNTRY_ID,CITY,STREET,HOUSE,EMPLOYEES_ID) value (1,"Minsk","Krasnaja","32",9);
insert into DEVELOPMENT (EMPLOYEES_ID) value (9);
insert into BACKENDS (DEVELOPMENT_ID) value (1);

insert into EMPLOYEES (NAME_EMPLOYEE,DATE_OF_BIRTH,SALARY) value ("Sanuk Ekaterina",'1987-09-12',1900);
insert into ADDRESSES (COUNTRY_ID,CITY,STREET,HOUSE,EMPLOYEES_ID) value (1,"Minsk","Mogilevskaja","12",10);
insert into DEVELOPMENT (EMPLOYEES_ID) value (10);
insert into BACKENDS (DEVELOPMENT_ID) value (2);

insert into EMPLOYEES (NAME_EMPLOYEE,DATE_OF_BIRTH,SALARY) value ("Sanuk Ekaterina",'1991-09-25',3900);
insert into ADDRESSES (COUNTRY_ID,CITY,STREET,HOUSE,EMPLOYEES_ID) value (1,"Minsk","Pobeditelej","78",11);
insert into DEVELOPMENT (EMPLOYEES_ID) value (11);
insert into FRONTENDS (DEVELOPMENT_ID) value (3);

insert into EMPLOYEES (NAME_EMPLOYEE,DATE_OF_BIRTH,SALARY) value ("Kolchak Mihail",'1992-08-15',2900);
insert into ADDRESSES (COUNTRY_ID,CITY,STREET,HOUSE,EMPLOYEES_ID) value (1,"Minsk","Aranskaja","18",12);
insert into DEVELOPMENT (EMPLOYEES_ID) value (12);
insert into FRONTENDS (DEVELOPMENT_ID) value (4);*/

select * from employees;
select * from addresses;
select * from directors;
select * from hrmanagers;
select * from marketologs;
select * from sales;
select * from backends;
select * from frontends;
select * from country;

#commit;









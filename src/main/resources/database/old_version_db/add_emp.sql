insert into departments (ID_DEPARTMENTS,TITLE_DEPARTMENTS) value (1,"Administration");
insert into departments (ID_DEPARTMENTS,TITLE_DEPARTMENTS) value (2,"Marketing");
insert into departments (ID_DEPARTMENTS,TITLE_DEPARTMENTS) value (3,"Development");

insert into job_titles (JOB_TITLE,departments_ID_DEPARTMENTS) value ("Direktor",1);
insert into job_titles (JOB_TITLE,departments_ID_DEPARTMENTS) value ("HrManager",1);
insert into job_titles (JOB_TITLE,departments_ID_DEPARTMENTS) value ("Marketolog",2);
insert into job_titles (JOB_TITLE,departments_ID_DEPARTMENTS) value ("Sale",2);
insert into job_titles (JOB_TITLE,departments_ID_DEPARTMENTS) value ("FrontEnd",3);
insert into job_titles (JOB_TITLE,departments_ID_DEPARTMENTS) value ("BackEnd",3);

insert into addresses (COUNTRY,CITY,STREET,HOUSE) value ("Belarus","Minsk","Lenina","21");
insert into employees (NAME,DATE_OF_BIRTH,SALARY,job_titles_ID_JOB_TITLE,addresses_ID_ADDRESS) value ("Ivanov Ilia",'1990-02-11',5000,1,1);
insert into addresses (COUNTRY,CITY,STREET,HOUSE) value ("Belarus","Minsk","Sovetskaja","5");
insert into employees (NAME,DATE_OF_BIRTH,SALARY,job_titles_ID_JOB_TITLE,addresses_ID_ADDRESS) value ("Belaja Olga",'1992-12-12',2300,1,2);
insert into addresses (COUNTRY,CITY,STREET,HOUSE) value ("Belarus","Minsk","Pobeditelej","14");
insert into employees (NAME,DATE_OF_BIRTH,SALARY,job_titles_ID_JOB_TITLE,addresses_ID_ADDRESS) value ("Sidorova Anna",'1986-02-10',1000,2,3);
insert into addresses (COUNTRY,CITY,STREET,HOUSE) value ("Belarus","Minsk","Lenina","45");
insert into employees (NAME,DATE_OF_BIRTH,SALARY,job_titles_ID_JOB_TITLE,addresses_ID_ADDRESS) value ("Popanov Dmitryj",'1991-11-07',2000,2,4);
insert into addresses (COUNTRY,CITY,STREET,HOUSE) value ("Belarus","Minsk","Avrorovskaja","6");
insert into employees (NAME,DATE_OF_BIRTH,SALARY,job_titles_ID_JOB_TITLE,addresses_ID_ADDRESS) value ("Kravchuk Denis",'1990-03-03',2200,3,5);
insert into addresses (COUNTRY,CITY,STREET,HOUSE) value ("Belarus","Minsk","Fvrorovskaja","6");
insert into employees (NAME,DATE_OF_BIRTH,SALARY,job_titles_ID_JOB_TITLE,addresses_ID_ADDRESS) value ("Volsky Leonid",'1993-04-06',1900,3,6);
insert into addresses (COUNTRY,CITY,STREET,HOUSE) value (7,"Belarus","Zaslavl","Sevenaja","1");
insert into employees (NAME,DATE_OF_BIRTH,SALARY,job_titles_ID_JOB_TITLE,addresses_ID_ADDRESS) value (7,"Volk Inna",'1993-04-06',1900,5,7);

select * from job_titles;
select * from departments;
select * from addresses;
select * from employees;
commit;









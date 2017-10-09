select NAME,DATE_OF_BIRTH,SALARY,COUNTRY,CITY,STREET,HOUSE,JOB_TITLE,TITLE_DEPARTMENTS from employees e
left join addresses a
on e.addresses_ID_ADDRESS = a.ID_ADDRESS
left join job_titles j
on e.job_titles_ID_JOB_TITLE = j.ID_JOB_TITLE
left join departments d
on j.departments_ID_DEPARTMENTS = d.ID_DEPARTMENTS
where d.TITLE_DEPARTMENTS = "Administration"
group by e.NAME 
having avg(SALARY)>1000;
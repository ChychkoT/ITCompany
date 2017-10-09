ALTER TABLE addresses
ADD number_flat int;
select * from addresses;

ALTER TABLE addresses
MODIFY number_flat varchar(45);
select * from addresses;

ALTER TABLE addresses
DROP COLUMN number_flat;
select * from addresses;
commit;
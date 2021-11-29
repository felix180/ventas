--liquibase formatted sql

--changeset Liquibase prices:1
--preconditions onFail:MARK_RAN onError:WARN
--precondition-sql-check expectedResult:0 SELECT COUNT(*) FROM PRICES h WHERE h.id =1
insert into PRICES (id,BRAND_ID,START_DATE,END_DATE,PRICE_LIST,PRODUCT_ID,  PRIORITY,PRICE,CURR) values (1,1,'2020-06-14 00:00:00' ,'2020-12-31 23:59:59' ,1 ,35455,0,35.50,'EUR');
--changeset Liquibase prices:2
--preconditions onFail:MARK_RAN onError:MARK_RAN
--precondition-sql-check expectedResult:0 SELECT COUNT(*) FROM PRICES h WHERE h.id =2
insert into PRICES (id,BRAND_ID,START_DATE,END_DATE,PRICE_LIST,PRODUCT_ID,  PRIORITY,PRICE,CURR) values (2,1,'2020-06-14 15:00:00' ,'2020-06-14 18:30:00'  ,2,35455,1,25.45 ,'EUR');
--changeset Liquibase prices:3
--preconditions onFail:MARK_RAN onError:MARK_RAN
--precondition-sql-check expectedResult:0 SELECT COUNT(*) FROM PRICES h WHERE h.id =3
insert into PRICES (id,BRAND_ID,START_DATE,END_DATE,PRICE_LIST,PRODUCT_ID,  PRIORITY,PRICE,CURR) values (3,1,'2020-06-15 00:00:00' ,'2020-06-15 11:00:00'  ,3,35455,1,30.50 ,'EUR');
--changeset Liquibase prices:4
--preconditions onFail:MARK_RAN onError:MARK_RAN
--precondition-sql-check expectedResult:0 SELECT COUNT(*) FROM PRICES h WHERE h.id =4
insert into PRICES (id,BRAND_ID,START_DATE,END_DATE,PRICE_LIST,PRODUCT_ID,  PRIORITY,PRICE,CURR) values (4,1,'2020-06-15 16:00:00' ,'2020-12-31 23:59:59'  ,4,35455,1,38.95  ,'EUR');
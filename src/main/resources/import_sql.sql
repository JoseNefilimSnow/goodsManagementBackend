Insert into users (ID,USERNAME,PASSWORD,PERMISSION,ENABLED) values (NEXTVAL('user_id'), 'ADMIN', '$2y$12$7el0KC8fli1CmW5z4va8Qe8NIw.uu4JEdcIRyyEqGsKwfffls4SQG', 0, true);
Insert into users (ID,USERNAME,PASSWORD,PERMISSION,ENABLED) values (NEXTVAL('user_id'), 'USER', '$2y$12$7el0KC8fli1CmW5z4va8Qe8NIw.uu4JEdcIRyyEqGsKwfffls4SQG', 1, true);

Insert into price_reductions (id,starting_date,end_date,reduced_price) values (NEXTVAL('price_reduction_id'), '03/04/2020', '12/05/2020', 8);
Insert into price_reductions (id,starting_date,end_date,reduced_price) values (NEXTVAL('price_reduction_id'), '08/05/2020', '09/07/2020', 12);
Insert into price_reductions (id,starting_date,end_date,reduced_price) values (NEXTVAL('price_reduction_id'), '09/07/2020', '05/10/2020', 24);
Insert into price_reductions (id,starting_date,end_date,reduced_price) values (NEXTVAL('price_reduction_id'), '03/10/2020', '03/04/2021', 2);

Insert into suppliers (id,name,country) values(NEXTVAL('supplier_id'), 'SpeedWaggon', 'UK');
Insert into suppliers (id,name,country) values(NEXTVAL('supplier_id'), 'Merlin', 'RU');
Insert into suppliers (id,name,country) values(NEXTVAL('supplier_id'), 'Zeppeli', 'IT');

Insert into products (id,code,creation_date,description,price,creator_id,state) values (NEXTVAL('product_id'), 'PR01-A', '04/06/2008', 'A three legged table', 30, 2, 0);
Insert into products (id,code,creation_date,description,price,creator_id,state) values (NEXTVAL('product_id'), 'PR02-B', '06/04/2016', 'A glass apple', 10, 1, 0);
Insert into products (id,code,creation_date,description,price,creator_id,state) values (NEXTVAL('product_id'), 'PR04-D', '10/06/2010', 'A pink banana', 5, 1, 1);
Insert into products (id,code,creation_date,description,price,creator_id,state) values (NEXTVAL('product_id'), 'PR27-Z', '01/01/2020', 'A Stone Mask', 25, 1, 1);
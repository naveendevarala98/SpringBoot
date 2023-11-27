insert into Course(id, name, created_date, last_updated_date)
values(1001, 'demo1', CURRENT_DATE(), CURRENT_DATE());
insert into Course(id, name, created_date, last_updated_date)
values(1002, 'demo2', CURRENT_DATE(), CURRENT_DATE());
insert into Course(id, name, created_date, last_updated_date)
values(1003, 'demo3', CURRENT_DATE(), CURRENT_DATE());

insert into Passport(id, number, created_date, last_updated_date)
values(3001, 'E123', CURRENT_DATE(), CURRENT_DATE());
insert into Passport(id, number, created_date, last_updated_date)
values(3002, 'E456', CURRENT_DATE(), CURRENT_DATE());
insert into Passport(id, number, created_date, last_updated_date)
values(3003, 'E789', CURRENT_DATE(), CURRENT_DATE());

insert into Student(id, name, passport_id, created_date, last_updated_date)
values(2001, 'naveen',3001, CURRENT_DATE(), CURRENT_DATE());
insert into Student(id, name, passport_id, created_date, last_updated_date)
values(2002, 'babu',3002, CURRENT_DATE(), CURRENT_DATE());
insert into Student(id, name, passport_id, created_date, last_updated_date)
values(2003, 'ram',3003, CURRENT_DATE(), CURRENT_DATE());
insert into Student(id, name, passport_id, created_date, last_updated_date)
values(2004, 'sita',3001, CURRENT_DATE(), CURRENT_DATE());


insert into Review(id, rating, description, created_date, last_updated_date)
values(4001, '5','Great Course', CURRENT_DATE(), CURRENT_DATE());
insert into Review(id, rating, description, created_date, last_updated_date)
values(4002, '4', 'Best Course',CURRENT_DATE(), CURRENT_DATE());
insert into Review(id, rating, description, created_date, last_updated_date)
values(4003, '5','Awesome Course', CURRENT_DATE(), CURRENT_DATE());
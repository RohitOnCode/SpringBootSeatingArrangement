
 -- Insert into Manager Table (one manager for many employees)
insert into manager ( email,first_name,last_name,manager_employee_id, seat_no) values("rchopra424@gmail.com","Rohit" ,"Chopra", 123, 18);


-- Insert into seat table (one seat per employee)
insert into seat(is_allocated, occupied_by , seat_no) values("YES","R123","10");

insert into seat(is_allocated, occupied_by , seat_no) values("YES","RA1234","12");

insert into seat(is_allocated, occupied_by , seat_no) values("YES","K1235","13");

insert into seat(is_allocated, occupied_by , seat_no) values("YES","M1235","14");

insert into seat(is_allocated, occupied_by , seat_no) values("YES","Rak1235","15");


insert into seat(is_allocated, occupied_by , seat_no) values("NO",null,"9");

--- Insert into employee table ( many employee can have same manager) 

insert into employee(email,employee_id,first_name,last_name,manager_id,seat_no) values("rajoberoi424@gmail.com","R123","Raj","Oberoi",123 , 10);

insert into employee(email,employee_id,first_name,last_name,manager_id,seat_no) values("rajuiberoi424@gmail.com","RA1234","Raju","Ober",123 , 12);

insert into employee(email,employee_id,first_name,last_name,manager_id,seat_no) values("khanoberoi@gmail.com","K1235","Khan","Oberp",123 , 13);

insert into employee(email,employee_id,first_name,last_name,manager_id,seat_no) values("makhanSingh@gmail.com","M1235","Makhan","Singh",123 , 14);

insert into employee(email,employee_id,first_name,last_name,manager_id,seat_no) values("Rakesh@gmail.com","Rak1235","Rakesh","Kumar",123 , 15);





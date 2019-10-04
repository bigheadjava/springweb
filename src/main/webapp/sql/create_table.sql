create table i_user(
	id int auto_increment primary key,
	user_name varchar(30), 
	user_password varchar(20), 
	name varchar(50),
	gender varchar(5),
	grade int,
	tel_no varchar(20),
	lottery_flag char(1)
	);
	
	
create table i_code_type(
	id int auto_increment primary key,
	type_name varchar(20),
	description varchar(100)
);

create table i_code(
	id int auto_increment primary key,
	code_id varchar(20),
	type_name varchar(20),
	description varchar(100),
	status_cd char(1),
	seq int
);


create table i_class(
	id int auto_increment primary key,
	name varchar(50),
	kind varchar(20),
	location varchar(20),
	plan_start_date date,
	plan_end_date data,
	description varchar(100)
);

create table i_course(
	id int auto_increment primary key,
	name varchar(50),
	class_id int,
	times int,
	description varchar(100),
	constraint fk_class_id foreign key(class_id) references i_class(id)
);
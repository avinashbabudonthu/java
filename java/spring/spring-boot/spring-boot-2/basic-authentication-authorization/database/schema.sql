use practice;

create table t_client
(
	id varchar(50) primary key,
	name varchar(100),
	code varchar(50),
	description varchar(150)
);

create table users(
	username varchar(50) not null primary key,
	password varchar(250) not null,
	raw_password varchar(250) not null,
	enabled boolean not null,
	client_id varchar(50),
	constraint fk_users_client_id foreign key(client_id) references t_client(id) on delete set null
	
);

create table t_role(
	id varchar(50) primary key,
	role varchar(50) unique not null,
	description varchar(500)
);

create table authorities (
	id varchar(50) primary key,
	username varchar(50) not null,
	role_id varchar(50),
	constraint fk_authorities_users foreign key(username) references users(username),
	constraint fk_authorities_role_id foreign key(role_id) references t_role(id) on delete set null,
	constraint unq_authorities unique(username, role_id)
);

create table t_role_page(
	id varchar(50),
    role_id varchar(50),
    page_name varchar(500),
    primary key(id),
    foreign key(role_id) references t_role(id) on delete cascade
);
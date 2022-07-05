
CREATE TABLE flight_table (
	id varchar NOT NULL,
	flightname varchar NULL,
	from_location varchar NULL,
	to_location varchar NULL,
	CONSTRAINT flight_table_pk PRIMARY KEY (id)
);


CREATE TABLE booking_table (
	booking_id varchar(255) NOT NULL,
	flight_id varchar(255) NULL,
	pasenger_name varchar(255) NULL,
	CONSTRAINT booking_table_pkey PRIMARY KEY (booking_id),
	CONSTRAINT booking_table_fk FOREIGN KEY (flight_id) REFERENCES flight_table(id)
);


CREATE TABLE user_table (
	user_id varchar NOT NULL,
	username varchar NULL,
	"password" varchar NULL,
	CONSTRAINT user_table_pk PRIMARY KEY (user_id)
);



CREATE TABLE auth_user_group (
	auth_user_group_id int NULL,
	username varchar NULL,
	auth_group varchar NULL
);


INSERT INTO flight_table  VALUES (100,'QA001J', 'COK','DEL');
INSERT INTO flight_table  VALUES (101,'AAA89K', 'LHR','JFK');



INSERT INTO USER_TABLE (USER_ID, USERNAME, PASSWORD) VALUES (1,'Ed', '$2a$10$whyJR3YJjDL4BEg2KdjeEuKtBV5KM7XZwZ1UtF.p5.M/t81rvRKwi');
INSERT INTO USER_TABLE (USER_ID, USERNAME, PASSWORD) VALUES (2,'Dev', '$2a$10$whyJR3YJjDL4BEg2KdjeEuKtBV5KM7XZwZ1UtF.p5.M/t81rvRKwi');

INSERT INTO AUTH_USER_GROUP (AUTH_USER_GROUP_ID, USERNAME, AUTH_GROUP) VALUES (1,'Ed', 'ROLE_USER');
INSERT INTO AUTH_USER_GROUP (AUTH_USER_GROUP_ID, USERNAME, AUTH_GROUP) VALUES (2,'Dev', 'ROLE_ADMIN');

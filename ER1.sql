SET SESSION FOREIGN_KEY_CHECKS=0;

/* Drop Tables */

DROP TABLE IF EXISTS contact_master;




/* Create Tables */

CREATE TABLE contact_master
(
	id char(4) NOT NULL,
	name varchar(10) NOT NULL,
	phone varchar(12) NOT NULL,
	email varchar(320) NOT NULL,
	date date NOT NULL,
	PRIMARY KEY (id)
);

/* Insert contact_master Data */
insert into contact_master values('0001','石田','09011112222','abc@gmail.com','2020/04/01');
insert into contact_master values('0002','加藤','09033334444','def@gmail.com','2020/05/01');
insert into contact_master values('0003','高橋','09055556666','ghi@gmail.com','2020/06/01');
insert into contact_master values('0004','星野','09077778888','jkl@gmail.com','2020/07/01');


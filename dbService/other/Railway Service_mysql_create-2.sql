CREATE TABLE `Station` (
	`st_id` bigint NOT NULL AUTO_INCREMENT,
	`st_name` varchar(50) NOT NULL,
	`time_table` bigint NOT NULL,
	PRIMARY KEY (`st_id`)
);

CREATE TABLE `Passenger` (
	`p_id` bigint NOT NULL AUTO_INCREMENT,
	`name` varchar(50) NOT NULL,
	`surname` varchar(50) NOT NULL,
	`dateOfBirth` DATE NOT NULL,
	PRIMARY KEY (`p_id`)
);

CREATE TABLE `Train` (
	`t_id` bigint NOT NULL AUTO_INCREMENT,
	`t_number` bigint NOT NULL,
	`stations` bigint NOT NULL,
	`t_capacity` int NOT NULL,
	PRIMARY KEY (`t_id`)
);

CREATE TABLE `Ticket` (
	`tic_id` bigint NOT NULL AUTO_INCREMENT,
	`train` bigint NOT NULL,
	`passenger` bigint NOT NULL,
	PRIMARY KEY (`tic_id`)
);

CREATE TABLE `TimeTable` (
	`timetable_id` bigint NOT NULL AUTO_INCREMENT,
	`train` bigint NOT NULL,
	`arrival_time` DATE NOT NULL,
	PRIMARY KEY (`timetable_id`)
);

ALTER TABLE `Station` ADD CONSTRAINT `Station_fk0` FOREIGN KEY (`time_table`) REFERENCES `TimeTable`(`timetable_id`);

ALTER TABLE `Train` ADD CONSTRAINT `Train_fk0` FOREIGN KEY (`stations`) REFERENCES `Station`(`st_id`);

ALTER TABLE `Ticket` ADD CONSTRAINT `Ticket_fk0` FOREIGN KEY (`train`) REFERENCES `Train`(`t_id`);

ALTER TABLE `Ticket` ADD CONSTRAINT `Ticket_fk1` FOREIGN KEY (`passenger`) REFERENCES `Passenger`(`p_id`);

ALTER TABLE `TimeTable` ADD CONSTRAINT `TimeTable_fk0` FOREIGN KEY (`train`) REFERENCES `Train`(`t_id`);


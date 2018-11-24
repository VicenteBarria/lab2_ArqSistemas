CREATE DATABASE IF NOT EXISTS `gomitasDB`;

CREATE TABLE IF NOT EXISTS `gomitas` (
	`id` long NOT NULL PRIMARY KEY,
	`nombre` varchar(50) DEFAULT NULL,
	`marca` varchar(50) DEFAULT NULL,
	`precio` long DEFAULT 0
);
	
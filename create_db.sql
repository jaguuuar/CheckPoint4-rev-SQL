BEGIN TRANSACTION;
CREATE TABLE IF NOT EXISTS `customers` (
	`id`	INTEGER,
	`name`	TEXT,
	`surname`	TEXT,
	`birthyear`	INTEGER,
	`gender`	TEXT,
	PRIMARY KEY(`id`)
);
CREATE TABLE IF NOT EXISTS `sales` (
	`id`	INTEGER,
	`customer_id`	INTEGER,
	`product_name`	TEXT,
	`net_value`	REAL,
	`tax_rate`	INTEGER,
	PRIMARY KEY(`id`),
	FOREIGN KEY(`customer_id`) REFERENCES `customers`(`id`)
);
COMMIT;

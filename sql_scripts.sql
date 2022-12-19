CREATE USER 'springstudent'@'localhost' IDENTIFIED BY 'springstudent';

GRANT ALL PRIVILEGES ON * . * TO 'springstudent'@'localhost';

ALTER USER 'springstudent'@'localhost' IDENTIFIED WITH mysql_native_password BY 'springstudent';

use sportyshoes;
CREATE TABLE `user` (
  `id` int NOT NULL AUTO_INCREMENT,
  `username` varchar(45) DEFAULT NULL,
  `password` varchar(45) DEFAULT NULL,
  `active` int DEFAULT NULL,
  `role` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `product` (
  `prod_id` int NOT NULL AUTO_INCREMENT,
  `product_name` varchar(45) DEFAULT NULL,
  `img_url` varchar(45) DEFAULT NULL,
  `prodcat_id` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`prod_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


CREATE TABLE `prod_category` (
  `prodcat_id` int NOT NULL AUTO_INCREMENT,
  `category` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`prodcat_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `orders` (
  `order_id` int NOT NULL AUTO_INCREMENT,
  `product_id` int DEFAULT NULL,
  `user_id` int DEFAULT NULL,
  `time` varchar(45) DEFAULT NULL,
  `order_date` date DEFAULT NULL,
  PRIMARY KEY (`order_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

insert into user values(1,"admin","{noop}admin",1,"ROLE_ADMIN");
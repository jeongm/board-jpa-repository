CREATE TABLE IF NOT EXISTS Users (
    `user_number` BIGINT NOT NULL AUTO_INCREMENT,
    `user_id` VARCHAR(50) NOT NULL,
    `password` VARCHAR(50) NOT NULL,
    `age` INT,
    `name` VARCHAR(50),
    `position` VARCHAR(5),
    `created_at` TIMESTAMP NOT NULL,
    `profile_src` VARCHAR(4000),
    `post` BIGINT,

    PRIMARY KEY(`user_number`)
);

CREATE TABLE IF NOT EXISTS Posts (
    `post_id` BIGINT NOT NULL AUTO_INCREMENT,
    `title` VARCHAR(100) NOT NULL,
    `content` TEXT NOT NULL,
    `created_at` TIMESTAMP NOT NULL,
    `user_id` VARCHAR(50),

    PRIMARY KEY(`post_id`)
);

MERGE INTO Users KEY (`user_number`) VALUES ( 1, 'admin','12345',null,null,'ADMIN','2023-05-15',null,null);
MERGE INTO Users KEY (`user_number`) VALUES ( 1000, '1000','1000',null,'user1000','USER','2023-05-15',null,null);
MERGE INTO Users KEY (`user_number`) VALUES ( 1001, '1001','1001',null,'user1001','USER','2023-05-15',null,null);
MERGE INTO Users KEY (`user_number`) VALUES ( 1002, '1002','1002',null,'user1002','USER','2023-05-15',null,null);
MERGE INTO Users KEY (`user_number`) VALUES ( 1003, '1003','1003',null,'user1003','USER','2023-05-15',null,null);
MERGE INTO Users KEY (`user_number`) VALUES ( 1004, '1004','1004',null,'user1004','USER','2023-05-15',null,null);



MERGE INTO Posts Key (`post_id`) VALUES ( 1, 'a','aa','2023-05-23',null);
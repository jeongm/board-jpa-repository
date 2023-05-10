CREATE TABLE IF NOT EXISTS Users (
    `user_id` VARCHAR(50) NOT NULL,
    `password` VARCHAR(50) NOT NULL,
    `age` INT,
    `name` VARCHAR(50),

    PRIMARY KEY(`user_id`)
);

CREATE TABLE IF NOT EXISTS Posts (
    `post_id` BIGINT NOT NULL AUTO_INCREMENT,
    `title` VARCHAR(100) NOT NULL,
    `content` TEXT NOT NULL,
    `created_at` TIMESTAMP NOT NULL,

    PRIMARY KEY(`post_id`)
);

-- MERGE INTO Users KEY (`user_id`) VALUES ( 'admin','12345' );

MERGE INTO Posts Key (`post_id`) VALUES ( 1, 'a','aa','2023-05-23');
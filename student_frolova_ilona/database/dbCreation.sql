SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=1;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=1;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';


CREATE SCHEMA IF NOT EXISTS `insurance` DEFAULT CHARACTER SET utf8 ;
USE `insurance` ;

CREATE TABLE IF NOT EXISTS `classifiers` (
                                             `id` BIGINT NOT NULL AUTO_INCREMENT,
                                             `title` VARCHAR(200) NOT NULL,
    `description` VARCHAR(100) NOT NULL,
    PRIMARY KEY (`id`)
    )
    ENGINE = InnoDB
    AUTO_INCREMENT = 1002;

CREATE UNIQUE INDEX `ix_classifiers_title` ON `classifiers` (`title`);

CREATE TABLE IF NOT EXISTS `classifier_values` (
                                                   `id` BIGINT NOT NULL AUTO_INCREMENT,
                                                   `classifier_id` BIGINT NOT NULL,
                                                   `ic` VARCHAR(200) NOT NULL,
    `description` VARCHAR(500) NOT NULL,
    PRIMARY KEY (id)
    )
    ENGINE = InnoDB
    AUTO_INCREMENT = 1002;

ALTER TABLE `classifier_values`
    ADD FOREIGN KEY (`classifier_id`) REFERENCES `classifiers`(`id`);

CREATE UNIQUE INDEX `ix_classifier_values_ic`
    ON `classifier_values` (`ic`);


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema homeImprovementStore
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `homeImprovementStore` ;

-- -----------------------------------------------------
-- Schema homeImprovementStore
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `homeImprovementStore` DEFAULT CHARACTER SET utf8 ;
USE `homeImprovementStore` ;

-- -----------------------------------------------------
-- Table `category`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `category` ;

CREATE TABLE IF NOT EXISTS `category` (
  `id` INT NOT NULL,
  `name` VARCHAR(45) NULL,
  `description` VARCHAR(45) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `product`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `product` ;

CREATE TABLE IF NOT EXISTS `product` (
  `id` INT NOT NULL,
  `name` VARCHAR(45) NULL,
  `price` VARCHAR(45) NULL,
  `category_id` INT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_idx` (`category_id` ASC),
  CONSTRAINT `fk_product`
    FOREIGN KEY (`category_id`)
    REFERENCES `category` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `stock`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `stock` ;

CREATE TABLE IF NOT EXISTS `stock` (
  `name` VARCHAR(45) NULL,
  `price` VARCHAR(45) NULL,
  `category` VARCHAR(45) NULL,
  `product_id` INT NULL,
  `id` INT NOT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_stock`
    FOREIGN KEY (`product_id`)
    REFERENCES `product` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

SET SQL_MODE = '';
GRANT USAGE ON *.* TO homeUser@localhost;
 DROP USER homeUser@localhost;
SET SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';
CREATE USER 'homeUser'@'localhost' IDENTIFIED BY 'home';

GRANT SELECT, INSERT, TRIGGER, UPDATE, DELETE ON TABLE * TO 'homeUser'@'localhost';

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

-- -----------------------------------------------------
-- Data for table `category`
-- -----------------------------------------------------
START TRANSACTION;
USE `homeImprovementStore`;
INSERT INTO `category` (`id`, `name`, `description`) VALUES (1, 'Flooring', 'Flooring for all residential needs');
INSERT INTO `category` (`id`, `name`, `description`) VALUES (2, 'Landscaping', 'Landscaping products for every home and garden');
INSERT INTO `category` (`id`, `name`, `description`) VALUES (3, 'Bath', 'Bath/Plumbing needs');
INSERT INTO `category` (`id`, `name`, `description`) VALUES (4, 'Paint', 'Painting supplies');

COMMIT;


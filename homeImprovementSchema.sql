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
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NULL,
  `price` VARCHAR(45) NULL,
  `category_id` INT NULL,
  `description` VARCHAR(45) NULL,
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
  `product_id` INT NOT NULL,
  `quantity` INT NULL,
  PRIMARY KEY (`product_id`),
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


-- -----------------------------------------------------
-- Data for table `product`
-- -----------------------------------------------------
START TRANSACTION;
USE `homeImprovementStore`;
INSERT INTO `product` (`id`, `name`, `price`, `category_id`, `description`) VALUES (1, 'Hickory 3/4\" Hardwood flooring', '2.89', 1, 'A rich hickory compliment to any room.');
INSERT INTO `product` (`id`, `name`, `price`, `category_id`, `description`) VALUES (2, '12x12 1/2\" Slate Grey tile', '3.49', 1, 'A gorgeous  slate mined from the Motabi mine in norther Africa.');
INSERT INTO `product` (`id`, `name`, `price`, `category_id`, `description`) VALUES (3, 'Pine 1/2\" Engineered Hardwood flooring', '45.44', 1, 'I beautiful nimble pine milled from the only 4 remaining trees in all of the Mohave desert.');
INSERT INTO `product` (`id`, `name`, `price`, `category_id`, `description`) VALUES (4, 'Briggs and Stratton 28HP Riding Lawn Mower', '3,200.58', 2, 'Top quality riding lawn mower that has been trusted by the pros for years.');
INSERT INTO `product` (`id`, `name`, `price`, `category_id`, `description`) VALUES (5, 'Scott\'s Feed and Seed lawn fertilizer', '58.00', 2, 'Perfect fertilizer for any struggling lawn.');
INSERT INTO `product` (`id`, `name`, `price`, `category_id`, `description`) VALUES (6, 'Womens garden shears', '13.99', 2, 'A great addition to any womens gardening bag. Custom built for women with petite hands.');
INSERT INTO `product` (`id`, `name`, `price`, `category_id`, `description`) VALUES (7, 'Kohler modern asian soaking tub', '1,200.27', 3, 'A modern way to spruce up any bathroom');
INSERT INTO `product` (`id`, `name`, `price`, `category_id`, `description`) VALUES (8, 'Grey linen shower curtain', '68.00', 3, 'A uniqe way to dress any dilapitaded bathroom. This linen has been woven with 800 year old chinese linen found in an old asian village.');
INSERT INTO `product` (`id`, `name`, `price`, `category_id`, `description`) VALUES (9, 'Stainless steel sink fixtures with spray nozzle', '129.00', 3, 'Made from stainless and utilizes smear free technology.');
INSERT INTO `product` (`id`, `name`, `price`, `category_id`, `description`) VALUES (10, 'Matte grey with heavy egg shell', '56.00', 4, 'A Burnett collection paint');
INSERT INTO `product` (`id`, `name`, `price`, `category_id`, `description`) VALUES (11, 'Gloss Arctic White with no egg shell', '78.00', 4, 'A Burnett collection paint');
INSERT INTO `product` (`id`, `name`, `price`, `category_id`, `description`) VALUES (12, 'Medium Matte Coriander Green', '88.00', 4, 'A Burnett collection paint');

COMMIT;


-- -----------------------------------------------------
-- Data for table `stock`
-- -----------------------------------------------------
START TRANSACTION;
USE `homeImprovementStore`;
INSERT INTO `stock` (`product_id`, `quantity`) VALUES (1, 10);
INSERT INTO `stock` (`product_id`, `quantity`) VALUES (2, 10);
INSERT INTO `stock` (`product_id`, `quantity`) VALUES (3, 10);
INSERT INTO `stock` (`product_id`, `quantity`) VALUES (4, 10);

COMMIT;


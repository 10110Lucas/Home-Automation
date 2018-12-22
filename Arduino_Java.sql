SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------

CREATE SCHEMA IF NOT EXISTS `Arduino_Java` DEFAULT CHARACTER SET utf8 ;
USE `Arduino_Java` ;

-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Arduino_Java`.`arduino` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `dia` VARCHAR(10) NOT NULL,
  `consumo` DECIMAL(10,2) NOT NULL,
  `tempoDeUso` VARCHAR(50) NOT NULL,
  `luminosidade` INT NOT NULL,
  `potenciaConsumida` DECIMAL(10,2) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

describe arduino;
select * from arduino;

INSERT INTO arduino(dia, consumo, tempoDeUso, luminosidade, potenciaConsumida) VALUES ('21/11/2018', 22.02, '2:16:09', 498, 4.18);
SELECT id, dia, luminosidade, potenciaConsumida, tempoDeUso FROM arduino;
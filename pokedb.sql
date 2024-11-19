CREATE DATABASE marobra IF NOT EXIST
USE marobra


CREATE TABLE IF NOT EXISTS `pokeusables` (
  `ID` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `ID_POKE` int(11) unsigned NOT NULL,
  `RAREZA` int(11) NOT NULL,
  `NIVEL` int(11) NOT NULL,
  `PRECIO` int(11) NOT NULL,
  `ID_ENTRENADOR` int(11) unsigned NOT NULL,
  PRIMARY KEY (`ID`),
  CONSTRAINT `fk_entrenador` FOREIGN KEY (`ID_ENTRENADOR`) REFERENCES `entrenadores` (`ID`),
  CONSTRAINT `fk_pokemon` FOREIGN KEY (`ID_POKE`) REFERENCES `pokemones` (`ID`)
) ENGINE=InnoDB;



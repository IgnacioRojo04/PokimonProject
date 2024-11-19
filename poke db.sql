-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Versión del servidor:         11.5.2-MariaDB - mariadb.org binary distribution
-- SO del servidor:              Win64
-- HeidiSQL Versión:             12.6.0.6765
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


-- Volcando estructura de base de datos para pokemones
CREATE DATABASE IF NOT EXISTS `pokemones` /*!40100 DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci */;
USE `pokemones`;

-- Volcando estructura para tabla pokemones.entrenadores
CREATE TABLE IF NOT EXISTS `entrenadores` (
  `ID` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `NOMBRE` varchar(50) DEFAULT NULL,
  `DINERO` int(11) unsigned DEFAULT NULL,
  PRIMARY KEY (`ID`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

-- Volcando datos para la tabla pokemones.entrenadores: ~22 rows (aproximadamente)
INSERT INTO `entrenadores` (`ID`, `NOMBRE`, `DINERO`) VALUES
	(1, 'Juan_Rojo', 505),
	(2, 'Santiago', 191),
	(3, 'Martin', 488),
	(4, 'Matias', 772),
	(5, 'Agustin', 426),
	(6, 'Nachote_Rojo', 827),
	(7, 'Tomas', 848),
	(8, 'Lucas', 205),
	(9, 'Francisco', 632),
	(10, 'Brock', 30),
	(11, 'Misty', 32),
	(12, 'Messi', 35),
	(13, 'Juan', 36),
	(14, 'Nacho', 38),
	(15, 'Sabrina', 41),
	(16, 'Lautaro', 42),
	(17, 'Giovanni', 43),
	(18, 'Red', 50),
	(19, 'Ysy', 46);

-- Volcando estructura para tabla pokemones.pokemones
CREATE TABLE IF NOT EXISTS `pokemones` (
  `ID` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `NOMBRE` varchar(50) DEFAULT '',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=152 DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

-- Volcando datos para la tabla pokemones.pokemones: ~151 rows (aproximadamente)
INSERT INTO `pokemones` (`ID`, `NOMBRE`) VALUES
	(1, 'Bulbasaur'),
	(2, 'Ivysaur'),
	(3, 'Venusaur'),
	(4, 'Charmander'),
	(5, 'Charmeleon'),
	(6, 'Charizard'),
	(7, 'Squirtle'),
	(8, 'Wartortle'),
	(9, 'Blastoise'),
	(10, 'Caterpie'),
	(11, 'Metapod'),
	(12, 'Butterfree'),
	(13, 'Weedle'),
	(14, 'Kakuna'),
	(15, 'Beedrill'),
	(16, 'Pidgey'),
	(17, 'Pidgeotto'),
	(18, 'Pidgeot'),
	(19, 'Rattata'),
	(20, 'Raticate'),
	(21, 'Spearow'),
	(22, 'Fearow'),
	(23, 'Ekans'),
	(24, 'Arbok'),
	(25, 'Pikachu'),
	(26, 'Raichu'),
	(27, 'Sandshrew'),
	(28, 'Sandslash'),
	(29, 'Nidoran'),
	(30, 'Nidorina'),
	(31, 'Nidoqueen'),
	(32, 'Nidoran'),
	(33, 'Nidorino'),
	(34, 'Nidoking'),
	(35, 'Clefairy'),
	(36, 'Clefable'),
	(37, 'Vulpix'),
	(38, 'Ninetales'),
	(39, 'Jigglypuff'),
	(40, 'Wigglytuff'),
	(41, 'Zubat'),
	(42, 'Golbat'),
	(43, 'Oddish'),
	(44, 'Gloom'),
	(45, 'Vileplume'),
	(46, 'Paras'),
	(47, 'Parasect'),
	(48, 'Venonat'),
	(49, 'Venomoth'),
	(50, 'Diglett'),
	(51, 'Dugtrio'),
	(52, 'Meowth'),
	(53, 'Persian'),
	(54, 'Psyduck'),
	(55, 'Golduck'),
	(56, 'Mankey'),
	(57, 'Primeape'),
	(58, 'Growlithe'),
	(59, 'Arcanine'),
	(60, 'Poliwag'),
	(61, 'Poliwhirl'),
	(62, 'Poliwrath'),
	(63, 'Abra'),
	(64, 'Kadabra'),
	(65, 'Alakazam'),
	(66, 'Machop'),
	(67, 'Machoke'),
	(68, 'Machamp'),
	(69, 'Bellsprout'),
	(70, 'Weepinbell'),
	(71, 'Victreebel'),
	(72, 'Tentacool'),
	(73, 'Tentacruel'),
	(74, 'Geodude'),
	(75, 'Graveler'),
	(76, 'Golem'),
	(77, 'Ponyta'),
	(78, 'Rapidash'),
	(79, 'Slowpoke'),
	(80, 'Slowbro'),
	(81, 'Magnemite'),
	(82, 'Magneton'),
	(83, 'Farfetch'),
	(84, 'Doduo'),
	(85, 'Dodrio'),
	(86, 'Seel'),
	(87, 'Dewgong'),
	(88, 'Grimer'),
	(89, 'Muk'),
	(90, 'Shellder'),
	(91, 'Cloyster'),
	(92, 'Gastly'),
	(93, 'Haunter'),
	(94, 'Gengar'),
	(95, 'Onix'),
	(96, 'Drowzee'),
	(97, 'Hypno'),
	(98, 'Krabby'),
	(99, 'Kingler'),
	(100, 'Voltorb'),
	(101, 'Electrode'),
	(102, 'Exeggcute'),
	(103, 'Exeggutor'),
	(104, 'Cubone'),
	(105, 'Marowak'),
	(106, 'Hitmonlee'),
	(107, 'Hitmonchan'),
	(108, 'Lickitung'),
	(109, 'Koffing'),
	(110, 'Weezing'),
	(111, 'Rhyhorn'),
	(112, 'Rhydon'),
	(113, 'Chansey'),
	(114, 'Tangela'),
	(115, 'Kangaskhan'),
	(116, 'Horsea'),
	(117, 'Seadra'),
	(118, 'Goldeen'),
	(119, 'Seaking'),
	(120, 'Staryu'),
	(121, 'Starmie'),
	(122, 'Mr. Mime'),
	(123, 'Scyther'),
	(124, 'Jynx'),
	(125, 'Electabuzz'),
	(126, 'Magmar'),
	(127, 'Pinsir'),
	(128, 'Tauros'),
	(129, 'Magikarp'),
	(130, 'Gyarados'),
	(131, 'Lapras'),
	(132, 'Ditto'),
	(133, 'Eevee'),
	(134, 'Vaporeon'),
	(135, 'Jolteon'),
	(136, 'Flareon'),
	(137, 'Porygon'),
	(138, 'Omanyte'),
	(139, 'Omastar'),
	(140, 'Kabuto'),
	(141, 'Kabutops'),
	(142, 'Aerodactyl'),
	(143, 'Snorlax'),
	(144, 'Articuno'),
	(145, 'Zapdos'),
	(146, 'Moltres'),
	(147, 'Dratini'),
	(148, 'Dragonair'),
	(149, 'Dragonite'),
	(150, 'Mewtwo'),
	(151, 'Mew');

-- Volcando estructura para tabla pokemones.pokeusables
CREATE TABLE IF NOT EXISTS `pokeusables` (
  `ID` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `ID_POKE` int(11) unsigned NOT NULL,
  `RAREZA` int(11) DEFAULT NULL,
  `NIVEL` int(11) NOT NULL,
  `PRECIO` int(11) NOT NULL,
  `ID_ENTRENADOR` int(11) unsigned NOT NULL,
  PRIMARY KEY (`ID`),
  KEY `fk_entrenador` (`ID_ENTRENADOR`),
  KEY `fk_pokemon` (`ID_POKE`),
  CONSTRAINT `fk_entrenador` FOREIGN KEY (`ID_ENTRENADOR`) REFERENCES `entrenadores` (`ID`),
  CONSTRAINT `fk_pokemon` FOREIGN KEY (`ID_POKE`) REFERENCES `pokemones` (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=128 DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

-- Volcando datos para la tabla pokemones.pokeusables: ~42 rows (aproximadamente)
INSERT INTO `pokeusables` (`ID`, `ID_POKE`, `RAREZA`, `NIVEL`, `PRECIO`, `ID_ENTRENADOR`) VALUES
	(77, 95, 1, 10, 10, 10),
	(78, 120, 1, 20, 20, 11),
	(79, 121, 1, 20, 20, 11),
	(80, 100, 1, 30, 30, 12),
	(81, 25, 1, 30, 30, 12),
	(82, 26, 1, 30, 30, 12),
	(83, 114, 1, 40, 40, 13),
	(84, 71, 1, 40, 40, 13),
	(85, 45, 1, 40, 40, 13),
	(86, 44, 1, 40, 40, 13),
	(87, 109, 1, 50, 50, 14),
	(88, 89, 1, 50, 50, 14),
	(89, 109, 1, 50, 50, 14),
	(90, 110, 1, 50, 50, 14),
	(91, 64, 1, 60, 60, 15),
	(92, 122, 1, 60, 60, 15),
	(93, 49, 1, 60, 60, 15),
	(94, 65, 1, 60, 60, 15),
	(95, 80, 1, 60, 60, 15),
	(96, 97, 1, 60, 60, 15),
	(97, 58, 1, 70, 70, 16),
	(98, 77, 1, 70, 70, 16),
	(99, 78, 1, 70, 70, 16),
	(100, 59, 1, 70, 70, 16),
	(101, 37, 1, 70, 70, 16),
	(102, 38, 1, 70, 70, 16),
	(103, 111, 1, 80, 80, 17),
	(104, 51, 1, 80, 80, 17),
	(105, 31, 1, 80, 80, 17),
	(106, 34, 1, 80, 80, 17),
	(107, 112, 1, 80, 80, 17),
	(108, 28, 1, 80, 80, 17),
	(109, 59, 1, 90, 90, 18),
	(110, 9, 1, 90, 90, 18),
	(111, 103, 1, 90, 90, 18),
	(112, 65, 1, 90, 90, 18),
	(113, 112, 1, 90, 90, 18),
	(114, 130, 1, 90, 90, 18),
	(115, 150, 1, 100, 100, 19);

/*!40103 SET TIME_ZONE=IFNULL(@OLD_TIME_ZONE, 'system') */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;
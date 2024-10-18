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
CREATE DATABASE IF NOT EXISTS `pokemones` /*!40100 DEFAULT CHARACTER SET armscii8 COLLATE armscii8_bin */;
USE `pokemones`;

-- Volcando estructura para tabla pokemones.entrenadores
CREATE TABLE IF NOT EXISTS `entrenadores` (
  `ID` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `NOMBRE` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`ID`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=armscii8 COLLATE=armscii8_bin COMMENT='Los personajes, el ID 1 es para el usuario, el resto para los entrenadores';

-- Volcando datos para la tabla pokemones.entrenadores: ~19 rows (aproximadamente)
INSERT INTO `entrenadores` (`ID`, `NOMBRE`) VALUES
	(1, 'Juan_Rojo'),
	(2, 'Santiago'),
	(3, 'Martin'),
	(4, 'Matias'),
	(5, 'Agustin'),
	(6, 'Nachote_Rojo'),
	(7, 'Tomas'),
	(8, 'Lucas'),
	(9, 'Francisco'),
	(10, 'Federico'),
	(11, 'Nahuel'),
	(12, 'Messi'),
	(13, 'Nicolas'),
	(14, 'Emiliano'),
	(15, 'Galadriel'),
	(16, 'Lautaro_Retamales'),
	(17, 'Mariano'),
	(18, 'Carlos'),
	(19, 'Andres');

-- Volcando estructura para tabla pokemones.pokemones
CREATE TABLE IF NOT EXISTS `pokemones` (
  `ID` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `NOMBRE` varchar(50) DEFAULT '',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=152 DEFAULT CHARSET=armscii8 COLLATE=armscii8_bin COMMENT='Esta es la lista referencial de pokemones por su nombre';

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
  `ID_POKE` int(11) NOT NULL,
  `RAREZA` int(11) NOT NULL,
  `NIVEL` int(11) NOT NULL,
  `PRECIO` int(11) NOT NULL,
  `ID_ENTRENADOR` int(11) NOT NULL,
  PRIMARY KEY (`ID`),
  KEY `NOMBRE` (`ID_POKE`) USING BTREE,
  KEY `ENTRENADOR` (`ID_ENTRENADOR`) USING BTREE,
  CONSTRAINT `fk_entrenador` FOREIGN KEY (`ID`) REFERENCES `entrenadores` (`ID`),
  CONSTRAINT `fk_pokemon` FOREIGN KEY (`ID`) REFERENCES `pokemones` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=armscii8 COLLATE=armscii8_bin COMMENT='Pokemones activos con sus caracteristicas\r\n';

-- Volcando datos para la tabla pokemones.pokeusables: ~0 rows (aproximadamente)

/*!40103 SET TIME_ZONE=IFNULL(@OLD_TIME_ZONE, 'system') */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;
entrenadores
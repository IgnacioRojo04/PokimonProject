
CREATE DATABASE IF NOT EXISTS `pokemones`;
USE `pokemones`;

CREATE TABLE IF NOT EXISTS `entrenadores` (
  `ID` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `NOMBRE` varchar(50) DEFAULT NULL,
  `DINERO` int(11) unsigned DEFAULT NULL,
  PRIMARY KEY (`ID`) USING BTREE
) ENGINE=InnoDB;

-- Insertar datos en entrenadores
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
	(10, 'Federico', 921),
	(11, 'Nahuel', 408),
	(12, 'Messi', 930),
	(13, 'Nicolas', 148),
	(14, 'Emiliano', 372),
	(15, 'Galadriel', 601),
	(16, 'Lautaro_Retamales', 915),
	(17, 'Mariano', 493),
	(18, 'Carlos', 525),
	(19, 'Andres', 363);

-- Crear tabla pokemones
CREATE TABLE IF NOT EXISTS `pokemones` (
  `ID` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `NOMBRE` varchar(50) DEFAULT '',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB;

-- Insertar datos en pokemones
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

-- Crear tabla pokeusables
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

-- Insertar datos en pokeusables
INSERT INTO `pokeusables` (`ID`, `ID_POKE`, `RAREZA`, `NIVEL`, `PRECIO`, `ID_ENTRENADOR`) VALUES
	(1, 56, 1, 1, 1, 3),
	(2, 56, 1, 1



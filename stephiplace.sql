-- phpMyAdmin SQL Dump
-- version 4.8.5
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1:3306
-- Généré le :  ven. 29 mai 2020 à 22:46
-- Version du serveur :  5.7.26
-- Version de PHP :  7.2.18

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données :  `stephiplace`
--

-- --------------------------------------------------------

--
-- Structure de la table `client`
--

DROP TABLE IF EXISTS `client`;
CREATE TABLE IF NOT EXISTS `client` (
  `IDClient` int(11) NOT NULL AUTO_INCREMENT,
  `Name` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `Firstname` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `NumTelephone` int(11) DEFAULT NULL,
  `NumPortable` int(11) DEFAULT NULL,
  `Adress` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`IDClient`)
) ENGINE=InnoDB AUTO_INCREMENT=103 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Déchargement des données de la table `client`
--

INSERT INTO `client` (`IDClient`, `Name`, `Firstname`, `NumTelephone`, `NumPortable`, `Adress`) VALUES
(1, 'Vandervort', 'Erika', 0, 920880, '4623 Jay Loop Suite 212 North Bethland, MN 37386-8376'),
(3, 'Russel', 'Karolann', 468, 1, '55734 Mayer Street\nWest Trudieland, OR 57101-6183'),
(4, 'Kovacek', 'Ayden', 875901, 529, '8695 Marks Creek Suite 417\nLubowitzfort, AZ 90575'),
(5, 'Bosco', 'Rory', 0, 0, '29541 Mitchell Rue\nHomenickfort, ME 54200'),
(6, 'Schmidt', 'Beaulah', 363137, 0, '1598 Richie Ridges\nMurphyborough, NC 67043'),
(7, 'Blick', 'Vernie', 641388, 251, '73908 Rosenbaum Crossroad Suite 282\nKohlerview, DC 51444-0848'),
(8, 'Mills', 'Earlene', 0, 2147483647, '344 Kennedi Road\nKautzerhaven, KS 43860'),
(9, 'Kub', 'Fletcher', 0, 605, '7931 Rau Parkway\nWest Kiara, VT 97643-6676'),
(10, 'Steuber', 'Hillard', 679547, 2147483647, '556 Koss Lake\nElmochester, KS 91303-0535'),
(11, 'Braun', 'Fernando', 696218, 888574, '88645 Schuppe Ports\nPort Marco, MN 75401'),
(12, 'Dare', 'Kelli', 634370, 950, '9937 Nelson Square\nOndrickaland, PA 76025'),
(13, 'Runolfsson', 'Rosetta', 930, 84, '320 Dorris Light\nNorth Clintview, TN 33965'),
(14, 'Blick', 'Angelita', 1, 0, '135 Tre Canyon Apt. 616\nEast Emory, VT 71087'),
(15, 'Littel', 'Laisha', 0, 0, '4135 Gulgowski Via Apt. 821\nSouth Vernicemouth, FL 14828'),
(16, 'Prosacco', 'Glen', 413363, 2147483647, '04804 Williamson Knoll\nZolastad, VT 48747'),
(17, 'Donnelly', 'Maryjane', 322, 0, '1095 Gene Ways\nSouth Naomieberg, FL 78668'),
(18, 'Schaefer', 'Christop', 41, 13, '18571 Barton Ranch Apt. 602\nNorth Mattie, VT 60094-4526'),
(19, 'Heller', 'Armando', 269, 336, '04526 Ziemann Dam\nFabiolaville, VA 59781-4754'),
(20, 'Thiel', 'Alberta', 105141, 1, '7448 Bernier Track Apt. 600\nRicobury, NC 05630'),
(21, 'Kerluke', 'Imelda', 0, 1, '30731 Reynolds Manor\nSouth Noemimouth, VA 82603-9808'),
(22, 'Pouros', 'Humberto', 0, 1, '95138 Giovanna Island Suite 018\nCreminberg, SC 64931-3692'),
(23, 'Johns', 'Morton', 1, 650, '9682 Romaguera Falls Apt. 889\nWest Anne, ND 19547-8188'),
(24, 'Lind', 'Camron', 0, 1, '1432 Lebsack Gateway\nHoweside, TX 76354-4474'),
(25, 'Stamm', 'Jackson', 99, 0, '7635 Tiara Pine\nNorth Cassandra, SD 54735'),
(26, 'Abshire', 'Hyman', 1, 344, '802 Kuhn Bypass Apt. 285\nDewaynestad, ND 27989-8614'),
(27, 'Hilpert', 'Hobart', 514550500, 687, '02185 Lurline Locks Suite 808\nTerrystad, NY 94996-8272'),
(28, 'Hyatt', 'Kaylee', 1, 710705, '48218 Dixie Green Suite 379\nNorth Andreaneland, MD 88809'),
(29, 'Upton', 'Else', 1, 746503, '308 Hills River Apt. 354\nHanschester, AL 34739'),
(30, 'Sawayn', 'Hillard', 333, 0, '022 Koss Stream Apt. 859\nLake Hilda, VT 79495'),
(31, 'Zemlak', 'Sofia', 0, 460696, '666 Marvin Unions\nEast Laurineburgh, MO 06074-0548'),
(32, 'Beatty', 'Torey', 1, 978, '90059 Pearlie Center Apt. 782\nNew Roman, IA 50671-7107'),
(33, 'Mante', 'Khalil', 2147483647, 238, '885 Fritsch Squares\nGusikowskiland, MA 81397'),
(34, 'Nolan', 'Donnell', 1, 127697, '214 Jamaal Shore Suite 942\nNorth Sylvanborough, OH 65416'),
(35, 'Huels', 'Maida', 740, 1, '059 Purdy Pike Suite 042\nPort Jonfort, OR 87091'),
(36, 'Kshlerin', 'Harley', 1, 46, '243 Arnold Course\nQuintonstad, WY 67116'),
(37, 'Quitzon', 'Halie', 0, 24, '2808 Vena Summit Suite 066\nWest Darby, NM 23587-4187'),
(38, 'Wiza', 'Pasquale', 1, 1, '0165 Braun Land\nWiltonton, CO 39898-1900'),
(39, 'Fahey', 'Pasquale', 2147483647, 628029, '46230 Orie Squares\nJaidenchester, LA 16716'),
(40, 'Daugherty', 'Zackery', 1, 977331, '82160 Leland Pines Apt. 229\nWest Emeraldtown, MD 52951-7550'),
(41, 'Kessler', 'Brice', 1, 363, '8653 Steuber Row\nKunzefurt, OH 73998'),
(42, 'Koelpin', 'Riley', 229427, 0, '3357 Yasmine Parkways Suite 551\nBorerview, TX 04504'),
(43, 'Oberbrunner', 'Sonia', 0, 51, '0674 Emanuel Falls\nNew Murielstad, KS 22462-6518'),
(44, 'Bashirian', 'June', 93, 515, '12449 Swift Village\nLake Jayceview, ND 67913-1650'),
(45, 'Considine', 'Estell', 711, 79, '18616 Reyes Track Apt. 911\nBotsfordborough, AL 57533'),
(46, 'Toy', 'Gerry', 76, 542, '3091 Libbie Inlet Suite 477\nNorth Henriette, HI 15880'),
(47, 'Treutel', 'Lawson', 1, 0, '212 Priscilla Junctions Suite 580\nLake Timmothy, DC 48040'),
(48, 'Tillman', 'Kattie', 1, 93, '99269 Garnet Heights Apt. 285\nLake Reinhold, MA 50261-4288'),
(49, 'Batz', 'Hassan', 1, 66, '69264 Jaqueline Divide\nJosieshire, NV 55505'),
(50, 'Von', 'Jennings', 2147483647, 77, '1483 Michelle Lake Suite 012\nArlofort, TN 02059-1259'),
(51, 'Balistreri', 'Daisy', 0, 90, '97122 Runte Drive\nHildaton, MT 38839-3873'),
(52, 'Gulgowski', 'Dortha', 286626, 0, '808 Santos Oval\nMillerborough, NM 62757'),
(53, 'Tromp', 'Curt', 0, 1, '968 Leilani Locks Apt. 423\nSouth Deron, IA 50101'),
(54, 'Feeney', 'Patience', 110, 306894, '55267 Maye Centers\nTiffanyfort, NH 27538-9456'),
(55, 'Schimmel', 'Loraine', 747, 1, '542 Crystal Points Suite 455\nKleinbury, TX 53018'),
(56, 'Corkery', 'Marjory', 0, 710663, '0028 Parisian Keys Apt. 937\nKozeyland, DC 22450-9168'),
(57, 'Haag', 'Derick', 800095, 982, '04906 White Well Apt. 343\nTorphyhaven, ND 70766-5476'),
(58, 'Cartwright', 'Adelle', 0, 0, '26493 Christop Station Apt. 028\nHeatherside, NH 23622-7244'),
(59, 'Wilderman', 'Lizzie', 420882, 0, '2105 Steuber Row\nSchusterburgh, ND 69273'),
(60, 'Jacobson', 'Deion', 2147483647, 561, '6261 Loren Lights\nKuvalisport, CA 96965-7919'),
(61, 'Dickens', 'Cora', 1, 0, '78288 Schowalter Locks\nSouth Vergie, AK 76204-6529'),
(62, 'Franecki', 'Rosina', 654109, 73, '2247 Virgie Meadow Apt. 285\nLevistad, SC 03405'),
(63, 'Farrell', 'Enos', 0, 426114, '3743 Jarrell Greens Apt. 407\nHodkiewiczburgh, WI 03147-8048'),
(64, 'Dibbert', 'Clark', 575, 781, '26376 Alejandra Knolls Suite 074\nSouth Kailee, SC 23409-5935'),
(65, 'Huel', 'Madisyn', 1, 1, '0245 Macejkovic Squares\nAlannaside, LA 22573'),
(66, 'Doyle', 'Nick', 757, 437, '269 Emmet Dale Apt. 903\nWest Maurineville, ND 05186'),
(67, 'Schmeler', 'Jerad', 43, 1, '089 Myrtle Ferry Suite 120\nPort Obieview, OH 84848-3110'),
(68, 'Heaney', 'Sven', 272, 872834, '4343 Glennie Roads\nHackettmouth, AK 60638'),
(69, 'Will', 'Caitlyn', 300405, 1, '453 Mariane Park\nPort Erich, NE 56107-9740'),
(70, 'Hayes', 'Emma', 61, 805, '94280 Stacey Villages\nKohlerfort, MD 76196-6874'),
(71, 'McKenzie', 'Lambert', 189306, 42073, '24144 Leffler Turnpike\nLueilwitzshire, AK 23484-9678'),
(72, 'Anderson', 'Jose', 1, 97, '5283 Bethany Prairie Suite 652\nLake Elbertport, ND 01745-8723'),
(73, 'Dietrich', 'Chasity', 1, 1, '96261 Lind Summit Apt. 083\nMorissettechester, KS 91035-0291'),
(74, 'Larkin', 'Hope', 1, 31334, '741 Dexter Ville\nBergnaumfurt, OK 23696-6796'),
(75, 'Hegmann', 'Abelardo', 265, 127640, '448 Kshlerin Square\nNorth Green, CA 25549'),
(76, 'Schneider', 'Nat', 269, 23, '525 Heidenreich Ranch\nWest Jaylin, PA 45961-1694'),
(77, 'Thompson', 'Ron', 49, 53510, '647 Thaddeus Brook\nWelchstad, WA 73285-9775'),
(78, 'Breitenberg', 'Augustine', 439698, 633150, '83918 Cecile Coves Suite 474\nSatterfieldmouth, PA 20075'),
(79, 'Legros', 'Lizzie', 0, 894, '70569 Doyle Streets\nNorth Hertha, KY 73747-6757'),
(80, 'Kutch', 'Zola', 0, 859968, '16504 Koepp Inlet Apt. 488\nPort Kristin, DC 86246-1437'),
(81, 'Gleason', 'Kiarra', 0, 69819, '47515 Deckow Track\nEast Alivia, MS 10086-4097'),
(82, 'Gutkowski', 'Judson', 426, 1, '24507 Sunny Island Apt. 933\nWest Lennie, IA 24062'),
(83, 'Feeney', 'Kayla', 20, 0, '6162 Gavin Courts\nLauryton, OK 75528'),
(84, 'McKenzie', 'Katrine', 420, 2147483647, '511 Garland Fort\nNew Theresa, PA 91497'),
(85, 'Thiel', 'Gayle', 998, 0, '881 Weber Shore Apt. 001\nStephonport, RI 06983'),
(86, 'Herzog', 'Arden', 68758, 2147483647, '6231 Ebony Greens\nMarquardthaven, DE 38727'),
(87, 'Bahringer', 'Arthur', 57, 1, '60353 Effie Crest\nNorth Jimmy, MS 52678-1585'),
(88, 'Kozey', 'Lonie', 1, 88, '582 Lucinda Rue Suite 004\nLakinview, IL 51023-8247'),
(89, 'Corkery', 'Jamey', 76531, 122278, '783 Pedro Forest Suite 702\nLeannonfort, TN 94032'),
(90, 'Kohler', 'Will', 1, 1, '803 Lindsay Ford Apt. 993\nEast Jerrold, VT 12095'),
(91, 'Kreiger', 'Brando', 80, 333, '58101 Estella Trace Suite 075\nEast Chanelleberg, IN 59796'),
(92, 'Hoeger', 'Juliet', 23390, 84267, '3058 Boyer Islands Apt. 749\nNorth Hellen, AR 70096'),
(93, 'Wiegand', 'Dock', 1, 1, '3367 Hane Place\nBreitenbergborough, WI 91492'),
(94, 'Schmidt', 'Deja', 0, 2147483647, '6487 Lavern Trace Suite 794\nKoeppchester, AL 65586'),
(95, 'Nienow', 'Wilfred', 369706, 191, '86066 Abshire Fords\nFisherberg, NV 08760-2098'),
(96, 'McGlynn', 'Icie', 0, 553, '98189 Sauer Squares\nPort Barttown, FL 24052'),
(97, 'Renner', 'Reggie', 1, 78, '192 Cruickshank Cliffs\nLake Leonormouth, NM 00556'),
(98, 'Baumbach', 'Noemy', 1, 170198, '10164 Dickinson River Apt. 073\nUllrichhaven, MO 67971'),
(99, 'Denesik', 'Kurtis', 0, 2147483647, '6275 Gorczany Common\nWest Ryann, MA 76887'),
(100, 'Johnson', 'Lucious', 126441, 0, '797 Hills Plaza\nNorth Lempimouth, ND 78121-4292'),
(101, 'nom', 'prenom', 456456, 123123123, 'adress'),
(102, 'testtest', 'testtest', 456123, 123456, 'testtest');

-- --------------------------------------------------------

--
-- Structure de la table `employee`
--

DROP TABLE IF EXISTS `employee`;
CREATE TABLE IF NOT EXISTS `employee` (
  `IDEmployee` int(11) NOT NULL AUTO_INCREMENT,
  `IsAdmin` tinyint(1) DEFAULT '0',
  `Name` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `Firstname` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `Agence` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `Password` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`IDEmployee`)
) ENGINE=InnoDB AUTO_INCREMENT=32 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Déchargement des données de la table `employee`
--

INSERT INTO `employee` (`IDEmployee`, `IsAdmin`, `Name`, `Firstname`, `Agence`, `Password`) VALUES
(1, 1, 'modi', 'Lenna', 'South', '5ED25AF7B1ED23FB00122E13D7F74C4D8262ACD8'), --Le mot de passe ici est "coucou"
(2, 0, 'ut', 'Lon', 'New', '5ED25AF7B1ED23FB00122E13D7F74C4D8262ACD8'),
(3, 0, 'est', 'Alfred', 'South', 'BB21158C733229347BD4E681891E213D94C685BE'),
(4, 0, 'reiciendis', 'Guillermo', 'East', '060E3C0159F7455332B31621F8930207AA0882D0'),
(5, 0, 'quasi', 'Cara', 'Port', '5693E311A517CEE5602DA62A0911D2B71E2B5ED0'),
(6, 0, 'accusamus', 'Linwood', 'North', 'B1A0C9977CCB87957F517C1A35E7B16035D4C70D'),
(7, 0, 'iusto', 'Christine', 'Lake', '1CEDCDD5AD3C241516A23633D8EE80950CF8FAA6'),
(8, 0, 'adipisci', 'Gerhard', 'Port', '458A328CCCBDB9DC18758751D7804A3D4058B643'),
(9, 0, 'natus', 'Pansy', 'West', '458A328CCCBDB9DC18758751D7804A3D4058B643'),
(10, 0, 'consectetur', 'Maude', 'West', 'C35CD1EE157DD8978E46C8B05E8AC87B1B491E03'),
(11, 0, 'voluptatem', 'Camryn', 'Port', '08BB74F7F39C44A725712414473AA43B28F06010'),
(12, 0, 'natus', 'Trycia', 'South', '3464D3C032CEC35B2BC533B7CA15006C4C5E85D1'),
(13, 0, 'impedit', 'Mattie', 'West', 'B02B99EF3C3525FA186CC2D33A3F1D21FE20A765'),
(14, 0, 'porro', 'Christop', 'West', '458A328CCCBDB9DC18758751D7804A3D4058B643'),
(15, 0, 'quod', 'Robbie', 'North', '1CEDCDD5AD3C241516A23633D8EE80950CF8FAA6'),
(16, 0, 'amet', 'Dariana', 'South', '08BB74F7F39C44A725712414473AA43B28F06010'),
(17, 0, 'minima', 'Tracy', 'Lake', 'B02B99EF3C3525FA186CC2D33A3F1D21FE20A765'),
(18, 0, 'quod', 'Reta', 'New', '51BEA516E63CAD5797A5C65133CC16DD4962DC7A'),
(19, 0, 'aut', 'Kristian', 'New', 'C35CD1EE157DD8978E46C8B05E8AC87B1B491E03'),
(20, 0, 'quaerat', 'Cleora', 'Port', '458A328CCCBDB9DC18758751D7804A3D4058B643'),
(21, 0, 'quibusdam', 'Joel', 'Lake', '3464D3C032CEC35B2BC533B7CA15006C4C5E85D1'),
(22, 0, 'voluptates', 'Heidi', 'West', 'B02B99EF3C3525FA186CC2D33A3F1D21FE20A765'),
(23, 0, 'dolor', 'Omer', 'East', '51BEA516E63CAD5797A5C65133CC16DD4962DC7A'),
(24, 0, 'nam', 'Cheyenne', 'North', '3464D3C032CEC35B2BC533B7CA15006C4C5E85D1'),
(25, 0, 'dolor', 'Rowena', 'Lake', '1CEDCDD5AD3C241516A23633D8EE80950CF8FAA6'),
(26, 0, 'modi', 'Gail', 'Lake', '51BEA516E63CAD5797A5C65133CC16DD4962DC7A'),
(27, 0, 'rem', 'Unique', 'New', 'B02B99EF3C3525FA186CC2D33A3F1D21FE20A765'),
(28, 0, 'quia', 'Sonny', 'South', '458A328CCCBDB9DC18758751D7804A3D4058B643'),
(29, 0, 'id', 'Jaclyn', 'Port', '51BEA516E63CAD5797A5C65133CC16DD4962DC7A'),
(30, 0, 'aliquam', 'Geovany', 'New', '1CEDCDD5AD3C241516A23633D8EE80950CF8FAA6'),
(31, 0, 'Bono', 'Jean', 'Nord', 'DA39A3EE5E6B4B0D3255BFEF95601890AFD80709');

-- --------------------------------------------------------

--
-- Structure de la table `proposition`
--

DROP TABLE IF EXISTS `proposition`;
CREATE TABLE IF NOT EXISTS `proposition` (
  `IDProposition` int(11) NOT NULL AUTO_INCREMENT,
  `IDRealEstate` int(11) NOT NULL,
  `From` int(11) NOT NULL,
  `Price` int(11) NOT NULL,
  `Accepted` int(1) DEFAULT '2',
  PRIMARY KEY (`IDProposition`),
  KEY `Proposition_fk0` (`IDRealEstate`),
  KEY `Proposition_fk1` (`From`)
) ENGINE=InnoDB AUTO_INCREMENT=102 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Déchargement des données de la table `proposition`
--

INSERT INTO `proposition` (`IDProposition`, `IDRealEstate`, `From`, `Price`, `Accepted`) VALUES
(1, 1, 1, 390815, 2),
(3, 3, 3, 362392, 2),
(4, 4, 4, 368246, 2),
(5, 5, 5, 384861, 2),
(6, 6, 6, 342803, 2),
(7, 7, 7, 160433, 2),
(8, 8, 8, 208179, 2),
(9, 9, 9, 491972, 2),
(10, 10, 10, 190383, 2),
(11, 11, 11, 241640, 2),
(12, 12, 12, 306573, 2),
(13, 13, 13, 123967, 2),
(14, 14, 14, 456637, 2),
(15, 15, 15, 247221, 2),
(16, 16, 16, 427139, 2),
(17, 17, 17, 417599, 2),
(18, 18, 18, 443454, 2),
(19, 19, 19, 284215, 2),
(20, 20, 20, 137748, 2),
(21, 21, 21, 229918, 2),
(22, 22, 22, 372789, 2),
(23, 23, 23, 146978, 2),
(24, 24, 24, 215148, 2),
(25, 25, 25, 116603, 2),
(26, 26, 26, 274047, 2),
(27, 27, 27, 326490, 2),
(28, 28, 28, 51975, 2),
(29, 29, 29, 479040, 2),
(30, 30, 30, 488442, 2),
(31, 31, 31, 171897, 2),
(32, 32, 32, 384214, 2),
(33, 33, 33, 128055, 2),
(34, 34, 34, 50597, 2),
(35, 35, 35, 462852, 2),
(36, 36, 36, 145351, 2),
(37, 37, 37, 172041, 2),
(38, 38, 38, 422329, 2),
(39, 39, 39, 341556, 2),
(40, 40, 40, 469796, 2),
(41, 41, 41, 206873, 2),
(42, 42, 42, 255394, 2),
(43, 43, 43, 256277, 2),
(44, 44, 44, 441361, 2),
(45, 45, 45, 338152, 2),
(46, 46, 46, 435701, 2),
(47, 47, 47, 86085, 2),
(48, 48, 48, 166103, 2),
(49, 49, 49, 293857, 2),
(50, 50, 50, 163130, 2),
(51, 51, 51, 319429, 2),
(52, 52, 52, 490167, 2),
(53, 53, 53, 311221, 2),
(54, 54, 54, 318555, 2),
(55, 55, 55, 124655, 2),
(56, 56, 56, 330345, 2),
(57, 57, 57, 196197, 2),
(58, 58, 58, 443736, 2),
(59, 59, 59, 460150, 2),
(60, 60, 60, 484317, 2),
(61, 61, 61, 196372, 2),
(62, 62, 62, 126651, 2),
(63, 63, 63, 339643, 2),
(64, 64, 64, 98570, 2),
(65, 65, 65, 352753, 2),
(67, 67, 67, 474754, 2),
(68, 68, 68, 259506, 2),
(69, 69, 69, 222214, 2),
(70, 70, 70, 491482, 2),
(71, 71, 71, 315581, 2),
(72, 72, 72, 167671, 2),
(73, 73, 73, 434377, 2),
(74, 74, 74, 437258, 2),
(75, 75, 75, 416127, 2),
(76, 76, 76, 313701, 2),
(77, 77, 77, 219390, 2),
(78, 78, 78, 373432, 2),
(79, 79, 79, 229289, 2),
(80, 80, 80, 105572, 2),
(81, 81, 81, 485698, 2),
(82, 82, 82, 258125, 2),
(83, 83, 83, 361997, 2),
(84, 84, 84, 173797, 2),
(85, 85, 85, 325755, 2),
(86, 86, 86, 434378, 2),
(87, 87, 87, 355504, 2),
(88, 88, 88, 181538, 2),
(89, 89, 89, 399229, 2),
(90, 90, 90, 117940, 2),
(91, 91, 91, 315128, 2),
(92, 92, 92, 419749, 2),
(93, 93, 93, 271089, 2),
(94, 94, 94, 301072, 2),
(95, 95, 95, 338276, 2),
(96, 96, 96, 247132, 2),
(97, 97, 97, 73358, 2),
(98, 98, 98, 449193, 2),
(99, 99, 99, 394658, 2),
(100, 100, 100, 478528, 2),
(101, 18, 1, 100, 2);

-- --------------------------------------------------------

--
-- Structure de la table `realestate`
--

DROP TABLE IF EXISTS `realestate`;
CREATE TABLE IF NOT EXISTS `realestate` (
  `IDRealEstate` int(11) NOT NULL AUTO_INCREMENT,
  `IDSaler` int(11) NOT NULL,
  `Sold` tinyint(1) DEFAULT NULL,
  `Price` int(11) NOT NULL,
  `Adress` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `Type` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `NbRoom` int(11) NOT NULL,
  `Metric` int(11) NOT NULL,
  `NbFloor` int(11) NOT NULL,
  `NbFavorite` int(11) NOT NULL,
  PRIMARY KEY (`IDRealEstate`),
  KEY `RealEstate_fk0` (`IDSaler`)
) ENGINE=InnoDB AUTO_INCREMENT=101 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Déchargement des données de la table `realestate`
--

INSERT INTO `realestate` (`IDRealEstate`, `IDSaler`, `Sold`, `Price`, `Adress`, `Type`, `NbRoom`, `Metric`, `NbFloor`, `NbFavorite`) VALUES
(1, 1, NULL, 311976, '747 Jaylin Extensions Lake Brenna, MA 77163', '', 3, 50, 2, 0),
(3, 3, NULL, 230710, '132 Armstrong Greens Apt. 616\nLake Jacinthe, AK 33039', '', 2, 72596, 454206, 0),
(4, 4, NULL, 240125, '41045 Jimmy Street Apt. 838\nWest Melody, NV 22768', '', 4, 799745173, 78, 0),
(5, 5, NULL, 404325, '2885 Dicki Mills\nWest Willytown, TX 80017', '', 4, 7, 0, 0),
(6, 6, NULL, 209788, '11698 Wisozk Ville\nTrevafort, NJ 41631', '', 2, 4246, 13804309, 0),
(7, 7, NULL, 302824, '2000 Mayer Corner Suite 719\nWest Gretchenshire, MI 72183', '', 4, 314189229, 64695548, 0),
(8, 8, NULL, 331832, '6618 Langosh Flats\nLesleystad, KY 67089-0876', '', 3, 8244136, 27854, 0),
(9, 9, NULL, 490280, '7600 Harris Inlet\nLake Maymiestad, WI 10977-2111', '', 4, 423417, 419505, 0),
(10, 10, NULL, 272225, '964 William Squares\nWildermanberg, TN 36371-9669', '', 4, 32, 3, 0),
(11, 11, NULL, 304219, '939 Deckow Vista Suite 137\nTonyfurt, WA 44785-2346', '', 4, 385369484, 245, 0),
(12, 12, NULL, 77233, '3767 Kshlerin Lodge Apt. 774\nAudiestad, WV 62762-8174', '', 3, 2478594, 8891, 0),
(13, 13, NULL, 117238, '0626 Hand Tunnel\nEast Tina, WA 34467', '', 5, 69062, 4479673, 0),
(14, 14, NULL, 136517, '8457 Zetta Turnpike Apt. 700\nEast Babymouth, WA 49399-1672', '', 2, 774, 265986062, 0),
(15, 15, NULL, 461019, '24329 Velma Port\nAnnamariefort, NM 02733', '', 2, 84029349, 1, 0),
(16, 16, NULL, 296425, '6445 Ibrahim Corner Suite 376\nRutherfordmouth, GA 04891-7193', '', 3, 832559, 6, 0),
(17, 17, NULL, 270169, '7135 Daugherty Rest Suite 844\nSerenabury, HI 37749', '', 4, 595, 7, 0),
(18, 18, NULL, 418861, '2873 Walter Knolls Apt. 527\nMcKenziebury, MO 25020', '', 3, 287, 2, 0),
(19, 19, NULL, 54890, '6109 Kovacek Plain\nMcDermottburgh, RI 34561-1857', '', 3, 1761, 691899, 0),
(20, 20, NULL, 446270, '3046 Schmidt Harbor\nWest Noelia, LA 81834-8872', '', 3, 5142924, 0, 0),
(21, 21, NULL, 471325, '34887 Jordi Valleys\nWyattfort, WI 38026-7041', '', 4, 454649825, 747, 0),
(22, 22, NULL, 134079, '40890 Alejandra Pines Suite 888\nPort Luciousland, MI 36105-5525', '', 4, 0, 40036, 0),
(23, 23, NULL, 250822, '0306 Nikita Loop Apt. 323\nAlvinastad, CA 15225', '', 4, 7256988, 40695, 0),
(24, 24, NULL, 80409, '501 Fred Islands\nJanicktown, IA 71213', '', 5, 377811, 84, 0),
(25, 25, NULL, 476846, '569 Von Creek Suite 678\nNew Keyonfort, CO 93608', '', 2, 803381374, 9, 0),
(26, 26, NULL, 57186, '73620 Ruben Spur\nKertzmannchester, FL 77173-5205', '', 2, 0, 7819930, 0),
(27, 27, NULL, 162293, '39637 Jazlyn Forges\nBrigittestad, MO 26685-6061', '', 5, 11124, 97542, 0),
(28, 28, NULL, 75035, '65783 Stehr Center\nLarsonport, GA 39817', '', 2, 7874694, 18338503, 0),
(29, 29, NULL, 108501, '239 Davon Stream\nEdmundstad, WI 79649-0109', '', 4, 0, 22104328, 0),
(30, 30, NULL, 482301, '6721 Zena Street\nWest Turnerberg, AZ 28097-5153', '', 3, 916066984, 965101545, 0),
(31, 31, NULL, 193927, '9744 Maybell Hills\nNorth Adella, NY 78710-8215', '', 2, 26, 629, 0),
(32, 32, NULL, 388309, '647 Jo Hollow\nEast Einoville, AL 56296', '', 5, 210560, 1, 0),
(33, 33, NULL, 118632, '4789 Krystina Mission Suite 809\nLake Adrainburgh, NH 77180-2103', '', 4, 513319, 28798420, 0),
(34, 34, NULL, 395875, '277 Bode Burgs Suite 935\nRashadtown, WY 35811', '', 3, 51729, 0, 0),
(35, 35, NULL, 165248, '68800 Hermann Mountain\nDantetown, RI 99720-2436', '', 4, 6, 4350, 0),
(36, 36, NULL, 222541, '417 Toy Course Apt. 386\nMorissettefurt, NC 76742', '', 4, 811319292, 61, 0),
(37, 37, NULL, 435255, '2765 Francisca Camp\nWest Aurelieville, NM 21461', '', 4, 3604, 61983, 0),
(38, 38, NULL, 153965, '0979 Johns Mills Apt. 573\nPort Emmalee, TN 36972-4330', '', 4, 72, 28327658, 0),
(39, 39, NULL, 150819, '624 Toy Ford\nSouth Karianne, MT 40378', '', 2, 63247, 8023, 0),
(40, 40, NULL, 65758, '9033 Elody Forges\nNew Raulmouth, WV 67878-2148', '', 2, 219508, 4903564, 0),
(41, 41, NULL, 197031, '2934 Demetrius Coves Suite 832\nRoyceview, WV 85529-4178', '', 2, 55376647, 12232204, 0),
(42, 42, NULL, 347490, '813 Herzog Squares Suite 828\nNorth Rowenahaven, RI 40893', '', 2, 1371, 1, 0),
(43, 43, NULL, 203693, '70039 Abbott Village Apt. 696\nPort Sylvanfurt, LA 23932-9736', '', 3, 638, 63866, 0),
(44, 44, NULL, 195518, '376 Towne Glen Apt. 396\nRogerchester, AL 01247', '', 2, 66591960, 66, 0),
(45, 45, NULL, 203037, '710 Grady Valley\nHumbertoshire, MA 38490', '', 5, 9, 10, 0),
(46, 46, NULL, 276523, '938 Ruthie Extensions\nEast Alvahberg, KS 30167-5110', '', 3, 4322793, 979, 0),
(47, 47, NULL, 239040, '879 Delaney Forges Apt. 803\nPort Einoton, WY 69447', '', 4, 6, 53187, 0),
(48, 48, NULL, 378157, '8767 Steuber Field\nEmmerichtown, NY 34549-6906', '', 4, 537, 178, 0),
(49, 49, NULL, 363698, '9104 Gracie Plaza Suite 249\nSeanside, AL 73048', '', 4, 88719, 956447097, 0),
(50, 50, NULL, 111085, '0265 Osinski Underpass\nLondonland, NJ 87514-1798', '', 2, 0, 59514, 0),
(51, 51, NULL, 233061, '0419 Lubowitz Circle Apt. 479\nSouth Kristin, MT 99670-8541', '', 5, 821263, 1871, 0),
(52, 52, NULL, 164899, '80544 Micaela Prairie Suite 017\nPort Cloydborough, IL 22525-6916', '', 5, 827, 867278, 0),
(53, 53, NULL, 235891, '21879 Loyal Port\nMorissettehaven, ME 02753', '', 3, 31047829, 8583, 0),
(54, 54, NULL, 389343, '8363 Idella Stravenue\nPort Kenneditown, NH 11015-5846', '', 2, 428, 8591, 0),
(55, 55, NULL, 421761, '6973 Collins Glen Apt. 857\nNew Chloefort, MN 26460', '', 2, 9625756, 738, 0),
(56, 56, NULL, 247363, '30655 Harvey Row\nZoefort, CA 96444', '', 4, 3288049, 40, 0),
(57, 57, NULL, 295259, '673 Emelie Drive Suite 773\nAnaville, PA 41004-5705', '', 5, 46319378, 2, 0),
(58, 58, NULL, 383507, '9096 Green Lights\nEast Sadieville, KY 69652', '', 4, 8, 35619, 0),
(59, 59, NULL, 328337, '234 Gottlieb Shores\nLake Halletown, NC 62982-7249', '', 2, 1, 1871, 0),
(60, 60, NULL, 142710, '709 Karlie Points Apt. 391\nSouth Herta, SD 05852', '', 3, 226279, 8, 0),
(61, 61, NULL, 104713, '9472 Kunde Gardens Suite 396\nMariamside, ND 89394-6467', '', 3, 7, 596359810, 0),
(62, 62, NULL, 313489, '7132 Murphy Stream\nNew Lolita, NJ 44104-7076', '', 5, 9219949, 60897, 0),
(63, 63, NULL, 316501, '88970 Rose Islands\nSouth Trefort, NE 40924-8951', '', 2, 892, 78, 0),
(64, 64, NULL, 426640, '1444 Ruecker Ridge Suite 202\nNorth Merrittberg, MN 57846', '', 3, 448210, 86982186, 0),
(65, 65, NULL, 424770, '7598 Kutch Light\nKesslerberg, NJ 85976-9275', '', 2, 43201, 284081, 0),
(67, 67, NULL, 176930, '1959 Heather Center Apt. 202\nAuerview, AZ 96456', '', 2, 699758825, 25582, 0),
(68, 68, NULL, 281568, '4341 Gibson Unions Apt. 340\nLeonbury, NC 16969', '', 3, 8050380, 438590, 0),
(69, 69, NULL, 439924, '230 Jeffrey Estate Apt. 895\nPort Olatown, NH 68349-7343', '', 5, 45728463, 0, 0),
(70, 70, NULL, 147623, '2743 Yost Locks\nNorth Gwen, CT 02180', '', 5, 42410, 495342080, 0),
(71, 71, NULL, 284401, '95402 Ara Springs Suite 535\nMeredithhaven, PA 84453', '', 5, 7931521, 927610719, 0),
(72, 72, NULL, 249638, '158 Luettgen Extension Apt. 039\nMosciskishire, WV 78898', '', 5, 298589, 5058595, 0),
(73, 73, NULL, 375610, '34014 Breitenberg Spurs Suite 478\nLoweburgh, KY 58398-7910', '', 4, 652206221, 7629198, 0),
(74, 74, NULL, 261913, '31809 Duane Mills Apt. 249\nGislasonmouth, AR 55708-2912', '', 4, 92724869, 68307878, 0),
(75, 75, NULL, 173571, '49229 Armando Stravenue\nBoyerberg, ME 54447', '', 3, 417921, 4180, 0),
(76, 76, NULL, 401410, '267 Antwon Coves\nSouth Arlie, CT 06920-0884', '', 2, 840722125, 632, 0),
(77, 77, NULL, 285995, '3625 Elisha Station\nNorth Anyaland, LA 28783', '', 3, 90115203, 53, 0),
(78, 78, NULL, 165324, '9470 Moore Crossing\nSouth Jessyside, IN 67380', '', 3, 657, 16, 0),
(79, 79, NULL, 421819, '2770 Boyle Motorway Apt. 470\nPort Marcoside, AL 49399', '', 5, 47272226, 1547, 0),
(80, 80, NULL, 204157, '72528 Feil Rest\nSouth Neilmouth, CT 05958-6743', '', 4, 85, 52828383, 0),
(81, 81, NULL, 322052, '980 Khalil Fords Suite 685\nHomenickton, SD 89368-7699', '', 2, 0, 212106118, 0),
(82, 82, NULL, 318192, '3452 Anderson Tunnel\nRohanton, DC 81902', '', 2, 37, 334, 0),
(83, 83, NULL, 227190, '2075 Bednar Ridges Apt. 962\nSebastianborough, OK 71754-5967', '', 5, 574938, 0, 0),
(84, 84, NULL, 417504, '26291 Asa Trail Suite 619\nNew Reta, GA 22122-8444', '', 3, 36, 89, 0),
(85, 85, NULL, 493390, '37651 Rolfson Divide\nNorth Frederikstad, FL 80182', '', 2, 880232, 75113, 0),
(86, 86, NULL, 453561, '99499 Denesik Island Apt. 351\nChaunceyborough, RI 38546-7795', '', 2, 10600, 58944094, 0),
(87, 87, NULL, 429168, '068 Green Villages Suite 820\nNorth Kraig, KY 71516-1387', '', 2, 0, 15508, 0),
(88, 88, NULL, 206123, '436 Sarah Corners\nNew Laurel, OR 93179', '', 3, 0, 30305, 0),
(89, 89, NULL, 377895, '17310 Pat Mall\nNorth Ardella, WY 59157', '', 4, 177078, 5233, 0),
(90, 90, NULL, 248453, '450 Nicolas Wells Suite 865\nPort Alainamouth, VA 70808', '', 5, 5167274, 63456, 0),
(91, 91, NULL, 301719, '98498 Kris Mountains Apt. 200\nJustenfort, SD 35515', '', 2, 33267, 79, 0),
(92, 92, NULL, 83649, '2842 Eugenia Ridges\nAnkundingport, MO 84709', '', 5, 905558796, 7339202, 0),
(93, 93, NULL, 241166, '2234 Greyson Flat\nAnthonytown, AK 31142-8832', '', 5, 0, 96998, 0),
(94, 94, NULL, 442184, '1711 Kreiger Stream\nNew Rylanport, GA 42242', '', 3, 55, 66, 0),
(95, 95, NULL, 201463, '86428 Mark Locks Suite 894\nEast Jerry, MN 60861', '', 3, 5, 942327207, 0),
(96, 96, NULL, 493355, '114 Emard Ville Apt. 786\nNorth Vanessaburgh, WA 37692-7134', '', 3, 55772234, 486414072, 0),
(97, 97, NULL, 301744, '210 Dibbert Fall\nSouth Reagan, MT 79280-8912', '', 3, 813120746, 989742635, 0),
(98, 98, NULL, 56147, '908 Fisher Cape Suite 745\nWest Reece, NC 48867-7876', '', 3, 872, 30831, 0),
(99, 99, NULL, 201323, '85954 Cristina Key Suite 670\nLake Florenceborough, WY 67563', '', 3, 618356212, 0, 0),
(100, 100, NULL, 236710, '613 Dell Squares\nKenyamouth, DC 77207', '', 3, 25, 7160, 0);

-- --------------------------------------------------------

--
-- Structure de la table `saler`
--

DROP TABLE IF EXISTS `saler`;
CREATE TABLE IF NOT EXISTS `saler` (
  `IDSaler` int(11) NOT NULL,
  `IDRef` int(11) NOT NULL,
  KEY `Saler_fk0` (`IDSaler`),
  KEY `Saler_fk1` (`IDRef`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Déchargement des données de la table `saler`
--

INSERT INTO `saler` (`IDSaler`, `IDRef`) VALUES
(1, 1),
(3, 3),
(4, 4),
(5, 5),
(6, 6),
(7, 7),
(8, 8),
(9, 9),
(10, 10),
(11, 11),
(12, 12),
(13, 13),
(14, 14),
(15, 15),
(16, 16),
(17, 17),
(18, 18),
(19, 19),
(20, 20),
(21, 21),
(22, 22),
(23, 23),
(24, 24),
(25, 25),
(26, 26),
(27, 27),
(28, 28),
(29, 29),
(30, 30),
(31, 1),
(32, 2),
(33, 3),
(34, 4),
(35, 5),
(36, 6),
(37, 7),
(38, 8),
(39, 9),
(40, 10),
(41, 11),
(42, 12),
(43, 13),
(44, 14),
(45, 15),
(46, 16),
(47, 17),
(48, 18),
(49, 19),
(50, 20),
(51, 21),
(52, 22),
(53, 23),
(54, 24),
(55, 25),
(56, 26),
(57, 27),
(58, 28),
(59, 29),
(60, 30),
(61, 1),
(62, 2),
(63, 3),
(64, 4),
(65, 5),
(66, 6),
(67, 7),
(68, 8),
(69, 9),
(70, 10),
(71, 11),
(72, 12),
(73, 13),
(74, 14),
(75, 15),
(76, 16),
(77, 17),
(78, 18),
(79, 19),
(80, 20),
(81, 21),
(82, 22),
(83, 23),
(84, 24),
(85, 25),
(86, 26),
(87, 27),
(88, 28),
(89, 29),
(90, 30),
(91, 1),
(92, 2),
(93, 3),
(94, 4),
(95, 5),
(96, 6),
(97, 7),
(98, 8),
(99, 9),
(100, 10);

--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `proposition`
--
ALTER TABLE `proposition`
  ADD CONSTRAINT `Proposition_fk0` FOREIGN KEY (`IDRealEstate`) REFERENCES `realestate` (`IDRealEstate`),
  ADD CONSTRAINT `Proposition_fk1` FOREIGN KEY (`From`) REFERENCES `client` (`IDClient`);

--
-- Contraintes pour la table `realestate`
--
ALTER TABLE `realestate`
  ADD CONSTRAINT `RealEstate_fk0` FOREIGN KEY (`IDSaler`) REFERENCES `saler` (`IDSaler`);

--
-- Contraintes pour la table `saler`
--
ALTER TABLE `saler`
  ADD CONSTRAINT `Saler_fk0` FOREIGN KEY (`IDSaler`) REFERENCES `client` (`IDClient`),
  ADD CONSTRAINT `Saler_fk1` FOREIGN KEY (`IDRef`) REFERENCES `employee` (`IDEmployee`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

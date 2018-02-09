-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: localhost    Database: web_narudzbe
-- ------------------------------------------------------
-- Server version	5.7.19-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `restoran_jelo`
--

DROP TABLE IF EXISTS `restoran_jelo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `restoran_jelo` (
  `restoranId` int(11) NOT NULL,
  `jeloId` int(11) NOT NULL,
  PRIMARY KEY (`restoranId`,`jeloId`),
  KEY `fk_jelo_has_restoran_idx` (`jeloId`),
  KEY `fk_restoran_has_jelo` (`restoranId`),
  CONSTRAINT `fk_jelo_has_restoran` FOREIGN KEY (`jeloId`) REFERENCES `jelo` (`jeloId`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_restoran_has_jelo` FOREIGN KEY (`restoranId`) REFERENCES `restoran` (`restoranId`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `restoran_jelo`
--

LOCK TABLES `restoran_jelo` WRITE;
/*!40000 ALTER TABLE `restoran_jelo` DISABLE KEYS */;
INSERT INTO `restoran_jelo` VALUES (9,53),(10,53),(9,54),(10,54),(10,55),(9,56),(10,56),(9,57),(10,57),(9,58),(10,58),(9,59),(10,59),(11,59),(11,60),(10,61);
/*!40000 ALTER TABLE `restoran_jelo` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-11-09 10:30:11

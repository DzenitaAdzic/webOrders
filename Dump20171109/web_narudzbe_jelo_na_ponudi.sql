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
-- Table structure for table `jelo_na_ponudi`
--

DROP TABLE IF EXISTS `jelo_na_ponudi`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `jelo_na_ponudi` (
  `jeloId` int(11) NOT NULL,
  `dnevnaPonudaId` int(11) NOT NULL,
  `cijena` float DEFAULT NULL,
  `kolicina` varchar(25) DEFAULT NULL,
  `popust` int(11) DEFAULT NULL,
  PRIMARY KEY (`jeloId`,`dnevnaPonudaId`),
  KEY `jelo_Na_ponudi_ima_Jelo_idx` (`jeloId`),
  KEY `pripada_idx` (`dnevnaPonudaId`),
  CONSTRAINT `fk_jelo_na_ponudi` FOREIGN KEY (`jeloId`) REFERENCES `jelo` (`jeloId`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `pripada` FOREIGN KEY (`dnevnaPonudaId`) REFERENCES `dnevnaponuda` (`dnevnaPonudaId`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `jelo_na_ponudi`
--

LOCK TABLES `jelo_na_ponudi` WRITE;
/*!40000 ALTER TABLE `jelo_na_ponudi` DISABLE KEYS */;
/*!40000 ALTER TABLE `jelo_na_ponudi` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-11-09 10:30:10

-- MySQL dump 10.13  Distrib 8.0.18, for Win64 (x86_64)
--
-- Host: localhost    Database: test
-- ------------------------------------------------------
-- Server version	8.0.18

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `admin`
--

DROP TABLE IF EXISTS `admin`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `admin` (
  `adminid` int(11) NOT NULL AUTO_INCREMENT,
  `password` varchar(255) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  `role` varchar(45) NOT NULL,
  PRIMARY KEY (`adminid`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `admin`
--

LOCK TABLES `admin` WRITE;
/*!40000 ALTER TABLE `admin` DISABLE KEYS */;
INSERT INTO `admin` VALUES (1,'$2a$10$Efi2RKAQVJm/HyUYYfrcO.5PFS.ncWIU7Z4FNx24/wYr6ftinHndy','minh','ROLE_ADMIN'),(14,'$2a$10$Efi2RKAQVJm/HyUYYfrcO.5PFS.ncWIU7Z4FNx24/wYr6ftinHndy','test','ROLE_ADMIN'),(16,'$2a$10$Efi2RKAQVJm/HyUYYfrcO.5PFS.ncWIU7Z4FNx24/wYr6ftinHndy','minhtq','ROLE_MEMBER');
/*!40000 ALTER TABLE `admin` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `khoangiamtru`
--

DROP TABLE IF EXISTS `khoangiamtru`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `khoangiamtru` (
  `mast` varchar(255) NOT NULL,
  `gtbanthan` double DEFAULT NULL,
  `gtbaohiem` double DEFAULT NULL,
  `gtnguoiphuthuoc` double DEFAULT NULL,
  `tonggia` double DEFAULT NULL,
  PRIMARY KEY (`mast`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `khoangiamtru`
--

LOCK TABLES `khoangiamtru` WRITE;
/*!40000 ALTER TABLE `khoangiamtru` DISABLE KEYS */;
INSERT INTO `khoangiamtru` VALUES ('MST01',9000000,1000000,3600000,0),('MST02',9000000,1750000,7200000,0);
/*!40000 ALTER TABLE `khoangiamtru` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `khoanmienthue`
--

DROP TABLE IF EXISTS `khoanmienthue`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `khoanmienthue` (
  `mast` varchar(255) NOT NULL,
  `tienan` double NOT NULL,
  `tiendc` double NOT NULL,
  `tiendt` double NOT NULL,
  `tienkhac` double NOT NULL,
  `tientp` double NOT NULL,
  `tongmien` double DEFAULT NULL,
  PRIMARY KEY (`mast`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `khoanmienthue`
--

LOCK TABLES `khoanmienthue` WRITE;
/*!40000 ALTER TABLE `khoanmienthue` DISABLE KEYS */;
INSERT INTO `khoanmienthue` VALUES ('MST01',800000,200000,350000,0,0,0),('MST02',1000000,500000,500000,0,500000,0);
/*!40000 ALTER TABLE `khoanmienthue` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `mathue`
--

DROP TABLE IF EXISTS `mathue`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `mathue` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `end_date` date DEFAULT NULL,
  `mast` varchar(255) DEFAULT NULL,
  `start_date` date DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `mathue`
--

LOCK TABLES `mathue` WRITE;
/*!40000 ALTER TABLE `mathue` DISABLE KEYS */;
INSERT INTO `mathue` VALUES (1,NULL,'MST1',NULL),(2,NULL,'MST2',NULL);
/*!40000 ALTER TABLE `mathue` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `taxer`
--

DROP TABLE IF EXISTS `taxer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `taxer` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `description` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `thuesuat` float NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `taxer`
--

LOCK TABLES `taxer` WRITE;
/*!40000 ALTER TABLE `taxer` DISABLE KEYS */;
INSERT INTO `taxer` VALUES (1,'','Cá nhân cư trú HD nhỏ 3M',0),(2,'','Cá nhân cư trú HD hơn 3M',10),(3,'','Cá nhân không cư trú',20);
/*!40000 ALTER TABLE `taxer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `thuesuat`
--

DROP TABLE IF EXISTS `thuesuat`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `thuesuat` (
  `bacthue` int(11) NOT NULL,
  `luongmax` double DEFAULT NULL,
  `luongmin` double NOT NULL,
  `phantramthue` int(11) NOT NULL,
  `tiengiamtu` double NOT NULL,
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `id_mast` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK35c7dh8tq6x7611iq0yertqsf` (`id_mast`),
  CONSTRAINT `FK35c7dh8tq6x7611iq0yertqsf` FOREIGN KEY (`id_mast`) REFERENCES `mathue` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `thuesuat`
--

LOCK TABLES `thuesuat` WRITE;
/*!40000 ALTER TABLE `thuesuat` DISABLE KEYS */;
INSERT INTO `thuesuat` VALUES (1,5000000,0,15,0,1,1),(2,10000000,5000000,20,250000,2,1),(3,18000000,10000000,25,750000,3,1),(4,32000000,18000000,30,1650000,4,1),(5,52000000,32000000,35,3250000,5,1),(6,80000000,52000000,40,5850000,6,1),(7,0,80000000,45,9850000,7,1),(8,8888888,88888888,50,2222222,8,2);
/*!40000 ALTER TABLE `thuesuat` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ttncn`
--

DROP TABLE IF EXISTS `ttncn`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ttncn` (
  `address` varchar(255) DEFAULT NULL,
  `birdth` date DEFAULT NULL,
  `card` varchar(255) DEFAULT NULL,
  `name` varchar(255) NOT NULL,
  `status` int(11) NOT NULL,
  `thuetncn` double NOT NULL,
  `thunhaptinhthue` double NOT NULL,
  `tongthunhap` double NOT NULL,
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `id_mast` int(11) NOT NULL,
  `idtaxer` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FKtlynkyf6p9qwyh7pv4rbimp5g` (`id_mast`),
  KEY `FKiuqhyoqy61gs6np9xoker5bdp` (`idtaxer`),
  CONSTRAINT `FKiuqhyoqy61gs6np9xoker5bdp` FOREIGN KEY (`idtaxer`) REFERENCES `taxer` (`id`),
  CONSTRAINT `FKtlynkyf6p9qwyh7pv4rbimp5g` FOREIGN KEY (`id_mast`) REFERENCES `mathue` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ttncn`
--

LOCK TABLES `ttncn` WRITE;
/*!40000 ALTER TABLE `ttncn` DISABLE KEYS */;
INSERT INTO `ttncn` VALUES (NULL,'1992-03-12',NULL,'Nguyen Quynh Anh ',0,4500000,15000000,20000000,1,1,2),(NULL,'1994-04-05',NULL,'Hoang Thi Thao',0,1000000,5000000,8000000,2,1,1),(NULL,'1998-11-27',NULL,'minh',0,400000,2000000,10000000,3,1,3),(NULL,'1999-12-03',NULL,'zedmi',0,800000,4000000,10000000,7,1,3);
/*!40000 ALTER TABLE `ttncn` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-04-01 16:28:35

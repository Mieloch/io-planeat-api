CREATE DATABASE  IF NOT EXISTS `planeat` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `planeat`;
-- MySQL dump 10.13  Distrib 5.7.12, for Win64 (x86_64)
--
-- Host: localhost    Database: planeat
-- ------------------------------------------------------
-- Server version	5.7.15-log

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
-- Table structure for table `ingredients`
--

DROP TABLE IF EXISTS `ingredients`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ingredients` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `quantity` int(11) NOT NULL,
  `unit` varchar(255) NOT NULL,
  `product_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK34jbb91wprx6ys2443vf43cxj` (`product_id`),
  CONSTRAINT `FK34jbb91wprx6ys2443vf43cxj` FOREIGN KEY (`product_id`) REFERENCES `products` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ingredients`
--

LOCK TABLES `ingredients` WRITE;
/*!40000 ALTER TABLE `ingredients` DISABLE KEYS */;
INSERT INTO `ingredients` VALUES (1,400,'GRAM',1),(2,200,'GRAM',2),(3,2,'WHOLE',3),(4,2,'PIECE',4),(5,600,'GRAM',5),(6,300,'GRAM',6);
/*!40000 ALTER TABLE `ingredients` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `instruction_steps`
--

DROP TABLE IF EXISTS `instruction_steps`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `instruction_steps` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `description` varchar(255) NOT NULL,
  `step_number` int(11) NOT NULL,
  `recipe_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKp1gy6rc1tam7q26n234cud2bi` (`recipe_id`),
  CONSTRAINT `FKp1gy6rc1tam7q26n234cud2bi` FOREIGN KEY (`recipe_id`) REFERENCES `recipes` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `instruction_steps`
--

LOCK TABLES `instruction_steps` WRITE;
/*!40000 ALTER TABLE `instruction_steps` DISABLE KEYS */;
INSERT INTO `instruction_steps` VALUES (1,'Kurczaka kroimy na niewielkie kawałki i wrzucamy na patelnię. Smażymy przez 2-3 minuty.',1,1),(2,'Następnie dodajemy cebulę oraz czosnek (pokrojone w kostkę). Smażymy 5-6 minut.',2,1),(3,'Dodajemy śmietanę, przyprawy i dusimy 2-3 minuty.',3,1),(4,'Następnie dodajemy umyty szpinak, dusimy 2-3 minuty, dokładnie mieszamy. W międzyczasie gotujemy makaron.',4,1),(5,'Ugotowany makaron łączymy z sosem, dobrze mieszamy.',5,1);
/*!40000 ALTER TABLE `instruction_steps` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `products`
--

DROP TABLE IF EXISTS `products`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `products` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `calories` double NOT NULL,
  `carbo` double NOT NULL,
  `fat` double NOT NULL,
  `name` varchar(255) NOT NULL,
  `protein` double NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `products`
--

LOCK TABLES `products` WRITE;
/*!40000 ALTER TABLE `products` DISABLE KEYS */;
INSERT INTO `products` VALUES (1,99,0,1,'Pierś z kurczaka',21),(2,371,75,1,'Makaron',13),(3,39,9,0.1,'Cebula',1.1),(4,148,33,0.5,'Czosnek',6),(5,23,3.6,0.4,'Szpinak',2.9),(6,186,3.6,18,'Śmietana',2.5);
/*!40000 ALTER TABLE `products` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `recipes`
--

DROP TABLE IF EXISTS `recipes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `recipes` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `difficulty` varchar(255) NOT NULL,
  `name` varchar(255) NOT NULL,
  `prepare_time_minutes` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `recipes`
--

LOCK TABLES `recipes` WRITE;
/*!40000 ALTER TABLE `recipes` DISABLE KEYS */;
INSERT INTO `recipes` VALUES (1,'EASY','Makaron z kurczakiem i szpinakiem',20);
/*!40000 ALTER TABLE `recipes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `recipes_ingredients`
--

DROP TABLE IF EXISTS `recipes_ingredients`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `recipes_ingredients` (
  `recipe_id` bigint(20) NOT NULL,
  `ingredient_id` bigint(20) NOT NULL,
  KEY `FKn58cf1b23kbp00ecui7xtqeiu` (`ingredient_id`),
  KEY `FKk6ck14h7wqd90hbryml2g6fqk` (`recipe_id`),
  CONSTRAINT `FKk6ck14h7wqd90hbryml2g6fqk` FOREIGN KEY (`recipe_id`) REFERENCES `recipes` (`id`),
  CONSTRAINT `FKn58cf1b23kbp00ecui7xtqeiu` FOREIGN KEY (`ingredient_id`) REFERENCES `ingredients` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `recipes_ingredients`
--

LOCK TABLES `recipes_ingredients` WRITE;
/*!40000 ALTER TABLE `recipes_ingredients` DISABLE KEYS */;
INSERT INTO `recipes_ingredients` VALUES (1,1),(1,2),(1,3),(1,4),(1,5),(1,6);
/*!40000 ALTER TABLE `recipes_ingredients` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-04-03 22:13:26

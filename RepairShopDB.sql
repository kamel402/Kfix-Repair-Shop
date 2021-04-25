-- MySQL dump 10.13  Distrib 8.0.23, for Win64 (x86_64)
--
-- Host: localhost    Database: RepairShopDB
-- ------------------------------------------------------
-- Server version	8.0.23

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `Feedbacks`
--

DROP TABLE IF EXISTS `Feedbacks`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Feedbacks` (
  `FeedbackID` int NOT NULL AUTO_INCREMENT,
  `Name` varchar(20) NOT NULL,
  `Country` varchar(56) NOT NULL,
  `Phone` char(10) NOT NULL,
  `Email` varchar(50) NOT NULL,
  `Subject` varchar(20) NOT NULL,
  `Type` varchar(20) NOT NULL,
  `Message` varchar(50) NOT NULL,
  `CreationDateTime` datetime NOT NULL,
  PRIMARY KEY (`FeedbackID`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Feedbacks`
--

LOCK TABLES `Feedbacks` WRITE;
/*!40000 ALTER TABLE `Feedbacks` DISABLE KEYS */;
INSERT INTO `Feedbacks` VALUES (1,'Kamel Tahir','Argentina','0538415191','KAMEL402@gmail.com','phone','fixing','this websit is awesom','2021-04-10 22:40:09'),(2,'Yusef Jamil','Cote D\'ivoire','0538415191','Y@gmail.com','quality','service','the quality is amazing','2021-04-10 22:41:58'),(3,'Maher Fares','American Samoa','0538411248','mah@gmail.com','quality','service','the team is union ','2021-04-11 00:34:57'),(4,'Anas Ahmed','Cyprus','0538412147','AnasAhmed@gmail.com','quality','service','good team effort','2021-04-18 23:03:49'),(5,'Azam Khaled','Saudi Arabia','0523415191','AzamKhaled@gmail.com','delivery','service','they deliver very fast','2021-04-18 23:06:13'),(6,'Essa Mohamed','Hungary','0538414789','EssaMohamed@st.uqu.edu.sa','delivery','service','Poor delivery','2021-04-18 23:34:06'),(7,'Fares Ahmed','Germany','0538423691','fares@gmail.com','delivery','service','24/7 work, and fast delivery','2021-04-19 22:19:05'),(8,'Salem Fisal','Romania','0578963191','salem@hotmail.com','quality','service','very good quality, I like it.','2021-04-19 22:21:15');
/*!40000 ALTER TABLE `Feedbacks` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `repairs`
--

DROP TABLE IF EXISTS `repairs`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `repairs` (
  `RepairID` int NOT NULL AUTO_INCREMENT,
  `ComputerOwner` varchar(20) NOT NULL,
  `ComputerSerialNumber` varchar(15) NOT NULL,
  `Type` varchar(7) NOT NULL,
  `Model` varchar(20) NOT NULL,
  `MemoryGB` int NOT NULL,
  `HardDeskGB` int NOT NULL,
  `Problems` varchar(50) NOT NULL,
  `RepairCost` float(8,2) DEFAULT NULL,
  `RepairStatus` varchar(20) DEFAULT NULL,
  `RepairFinishDateTime` datetime DEFAULT NULL,
  `RepairDeliveryDateTime` datetime NOT NULL,
  PRIMARY KEY (`RepairID`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `repairs`
--

LOCK TABLES `repairs` WRITE;
/*!40000 ALTER TABLE `repairs` DISABLE KEYS */;
INSERT INTO `repairs` VALUES (1,'Kamel Gerado','12-34567-891056','labtop','Lenovo ideapad 330',8,1000,'wifi issues',500.00,'good','2021-04-17 00:00:00','2021-04-25 00:00:00'),(2,'Ahmed Khaled','37-34417-891056','tablet','Galaxy Pad',4,64,'power button',50.00,'good','2021-04-17 00:00:00','2021-02-10 00:00:00'),(3,'Khaled Yaser','78-62478-825846','desktop','Raizen 612',8,1000,'Moniter',50.00,'good','2021-04-17 00:00:00','2021-07-12 00:00:00'),(4,'Ryan Mohmed','01-01017-800150','tablet','iPad',4,64,'screen',150.00,'good','2021-01-25 00:00:00','2021-02-13 00:00:00'),(5,'Zidan tamer','00-62478-000104','labtop','iPad Pro`',8,64,'Charger',500.00,'Fine','2021-01-01 00:00:00','2021-04-25 00:00:00'),(6,'Thiago','07-37367-891054','labtop','Lenovo ideapad 550',8,1000,'Flash Lite',20.00,'broken','2021-04-17 00:00:00','2021-04-25 00:00:00'),(7,'Moath Goma','56-74123-891016','desktop','MaxBook',8,1000,'Wireless',500.00,'broken','2021-04-17 00:00:00','2021-02-10 00:00:00'),(8,'Jamal Lacelce','87-00417-000056','labtop','MaxBook',8,1000,'Broken screen ',100.00,'broken','2021-04-17 00:00:00','2021-04-25 00:00:00'),(9,'Azam Khaled','00-10567-000056','desktop','Mac',8,1000,'Fan Cooler',500.00,'Little bit broken','2021-01-01 00:00:00','2021-02-10 00:00:00'),(10,'Eissa Mendy','37-00447-891056','labtop','Lenovo ideapad 850',8,1000,'cpu coller',500.00,'broken','2021-04-17 00:00:00','2021-04-25 00:00:00'),(11,'Robert Lewandoski','10-34107-891016','tablet','iPad Pro',8,1000,'Touch Screen',100.00,'Fine','2021-04-17 00:00:00','2021-04-26 00:00:00');
/*!40000 ALTER TABLE `repairs` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Users`
--

DROP TABLE IF EXISTS `Users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Users` (
  `UserID` int NOT NULL AUTO_INCREMENT,
  `FullName` varchar(50) NOT NULL,
  `Email` varchar(50) NOT NULL,
  `Password` char(32) NOT NULL,
  `CreationDateTime` datetime NOT NULL,
  PRIMARY KEY (`UserID`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Users`
--

LOCK TABLES `Users` WRITE;
/*!40000 ALTER TABLE `Users` DISABLE KEYS */;
INSERT INTO `Users` VALUES (1,'Kamel Tahir','kamel@gmail.com','02bb45da1455e05b92ac18f2e882b7b4','2021-04-19 21:56:52'),(2,'Zidan Mohamed','zidan@gmail.com','55cef4259b5194a4c32b4c69696b8043','2021-04-19 22:00:30'),(3,'Amar Ziad','amar@hotmail.com','9e78361deb95108fab203b8912b6140a','2021-04-19 22:02:17'),(4,'Anas Ahmed','anas@hotmail.com','d1790984529c3a7d7efedeed6e6923a5','2021-04-19 22:03:58'),(5,'Eissa Khaled','eissa@gmail.com','296a5132f9cf1c6266e1a3efb0c62221','2021-04-19 22:05:13');
/*!40000 ALTER TABLE `Users` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-04-19 23:05:01

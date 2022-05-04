-- MySQL dump 10.13  Distrib 8.0.28, for Win64 (x86_64)
--
-- Host: localhost    Database: zerli
-- ------------------------------------------------------
-- Server version	8.0.28

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
-- Table structure for table `branchmanager`
--

DROP TABLE IF EXISTS `branchmanager`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `branchmanager` (
  `branchmanagerID` varchar(256) NOT NULL,
  `branchID` varchar(256) DEFAULT NULL,
  `firstName` varchar(256) DEFAULT NULL,
  `lastName` varchar(256) DEFAULT NULL,
  `email` varchar(256) DEFAULT NULL,
  `phoneNumber` varchar(256) DEFAULT NULL,
  `userName` varchar(256) DEFAULT NULL,
  `isLoggedIn` varchar(256) DEFAULT NULL,
  PRIMARY KEY (`branchmanagerID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `branchmanager`
--

LOCK TABLES `branchmanager` WRITE;
/*!40000 ALTER TABLE `branchmanager` DISABLE KEYS */;
INSERT INTO `branchmanager` VALUES ('2','1000','mor','ben haim','mor@gmail.com','0545726479','mor','0');
/*!40000 ALTER TABLE `branchmanager` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `branchs`
--

DROP TABLE IF EXISTS `branchs`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `branchs` (
  `branchID` varchar(256) NOT NULL,
  `branchManagerID` varchar(256) NOT NULL,
  `branchName` varchar(256) DEFAULT NULL,
  PRIMARY KEY (`branchID`,`branchManagerID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `branchs`
--

LOCK TABLES `branchs` WRITE;
/*!40000 ALTER TABLE `branchs` DISABLE KEYS */;
/*!40000 ALTER TABLE `branchs` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `complaints`
--

DROP TABLE IF EXISTS `complaints`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `complaints` (
  `complaintID` varchar(256) NOT NULL,
  `customerID` varchar(256) DEFAULT NULL,
  `customerserviceID` varchar(256) DEFAULT NULL,
  `description` varchar(256) DEFAULT NULL,
  `branchID` varchar(256) DEFAULT NULL,
  PRIMARY KEY (`complaintID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `complaints`
--

LOCK TABLES `complaints` WRITE;
/*!40000 ALTER TABLE `complaints` DISABLE KEYS */;
/*!40000 ALTER TABLE `complaints` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `creditcards`
--

DROP TABLE IF EXISTS `creditcards`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `creditcards` (
  `creditCardNumber` varchar(245) NOT NULL,
  `creditCardCvvCode` varchar(245) DEFAULT NULL,
  `creditCardDateOfExpiration` date DEFAULT NULL,
  PRIMARY KEY (`creditCardNumber`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `creditcards`
--

LOCK TABLES `creditcards` WRITE;
/*!40000 ALTER TABLE `creditcards` DISABLE KEYS */;
/*!40000 ALTER TABLE `creditcards` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `customer`
--

DROP TABLE IF EXISTS `customer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `customer` (
  `customerID` varchar(256) NOT NULL,
  `firstName` varchar(256) DEFAULT NULL,
  `lastName` varchar(256) DEFAULT NULL,
  `phoneNumber` varchar(256) DEFAULT NULL,
  `email` varchar(256) DEFAULT NULL,
  `creditCardNumber` varchar(256) DEFAULT NULL,
  `accountStatus` enum('CONFIRMED','PENDING_APPROVAL','FROZEN') DEFAULT NULL,
  `isNewCustomer` tinyint DEFAULT NULL,
  `credit` varchar(256) DEFAULT NULL,
  `isLoggedIn` varchar(256) DEFAULT NULL,
  `userName` varchar(256) NOT NULL,
  PRIMARY KEY (`customerID`,`userName`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `customer`
--

LOCK TABLES `customer` WRITE;
/*!40000 ALTER TABLE `customer` DISABLE KEYS */;
INSERT INTO `customer` VALUES ('1','dvir','asdas','0545131489','dvir@gmail.com','12344566578','CONFIRMED',1,'0','0','dvir');
/*!40000 ALTER TABLE `customer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `customerservice`
--

DROP TABLE IF EXISTS `customerservice`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `customerservice` (
  `customerserviceID` varchar(256) NOT NULL,
  `firstName` varchar(256) DEFAULT NULL,
  `lastName` varchar(256) DEFAULT NULL,
  `email` varchar(256) DEFAULT NULL,
  `phoneNumber` varchar(256) DEFAULT NULL,
  `userName` varchar(256) DEFAULT NULL,
  `isLoggedIn` varchar(256) DEFAULT NULL,
  PRIMARY KEY (`customerserviceID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `customerservice`
--

LOCK TABLES `customerservice` WRITE;
/*!40000 ALTER TABLE `customerservice` DISABLE KEYS */;
/*!40000 ALTER TABLE `customerservice` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `deliveryagent`
--

DROP TABLE IF EXISTS `deliveryagent`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `deliveryagent` (
  `deliveryagentID` varchar(256) NOT NULL,
  `branchID` varchar(256) DEFAULT NULL,
  `orderID` varchar(256) DEFAULT NULL,
  `firstName` varchar(256) DEFAULT NULL,
  `lastName` varchar(256) DEFAULT NULL,
  `email` varchar(256) DEFAULT NULL,
  `phoneNumber` varchar(256) DEFAULT NULL,
  `userName` varchar(256) DEFAULT NULL,
  `isLoggedIn` varchar(256) DEFAULT NULL,
  PRIMARY KEY (`deliveryagentID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `deliveryagent`
--

LOCK TABLES `deliveryagent` WRITE;
/*!40000 ALTER TABLE `deliveryagent` DISABLE KEYS */;
/*!40000 ALTER TABLE `deliveryagent` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `deliverys`
--

DROP TABLE IF EXISTS `deliverys`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `deliverys` (
  `deliveryID` varchar(256) NOT NULL,
  `orderID` varchar(256) NOT NULL,
  `receiverName` varchar(256) DEFAULT NULL,
  `price` varchar(256) DEFAULT NULL,
  `arrivedDate` varchar(256) DEFAULT NULL,
  `deliveryStatus` enum('Pending','Sent','Received') DEFAULT NULL,
  PRIMARY KEY (`deliveryID`,`orderID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `deliverys`
--

LOCK TABLES `deliverys` WRITE;
/*!40000 ALTER TABLE `deliverys` DISABLE KEYS */;
/*!40000 ALTER TABLE `deliverys` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `login`
--

DROP TABLE IF EXISTS `login`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `login` (
  `ID` varchar(250) NOT NULL,
  `userName` varchar(250) NOT NULL,
  `password` varchar(250) DEFAULT NULL,
  `userType` varchar(250) DEFAULT NULL,
  PRIMARY KEY (`ID`,`userName`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `login`
--

LOCK TABLES `login` WRITE;
/*!40000 ALTER TABLE `login` DISABLE KEYS */;
INSERT INTO `login` VALUES ('1','dvir','db1234','customer'),('2','mor','mor1234','branchmanager');
/*!40000 ALTER TABLE `login` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `marketingworker`
--

DROP TABLE IF EXISTS `marketingworker`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `marketingworker` (
  `marketingworkerID` varchar(256) NOT NULL,
  `firstName` varchar(256) DEFAULT NULL,
  `lastName` varchar(256) DEFAULT NULL,
  `email` varchar(256) DEFAULT NULL,
  `phoneNumber` varchar(256) DEFAULT NULL,
  `userName` varchar(256) DEFAULT NULL,
  `isLoggedIn` varchar(256) DEFAULT NULL,
  PRIMARY KEY (`marketingworkerID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `marketingworker`
--

LOCK TABLES `marketingworker` WRITE;
/*!40000 ALTER TABLE `marketingworker` DISABLE KEYS */;
/*!40000 ALTER TABLE `marketingworker` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `networkmanager`
--

DROP TABLE IF EXISTS `networkmanager`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `networkmanager` (
  `networkManagerID` varchar(256) NOT NULL,
  `firstName` varchar(256) DEFAULT NULL,
  `lastName` varchar(256) DEFAULT NULL,
  `email` varchar(256) DEFAULT NULL,
  `phoneNumber` varchar(256) DEFAULT NULL,
  `userName` varchar(256) DEFAULT NULL,
  `isLoggedIn` varchar(256) DEFAULT NULL,
  PRIMARY KEY (`networkManagerID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `networkmanager`
--

LOCK TABLES `networkmanager` WRITE;
/*!40000 ALTER TABLE `networkmanager` DISABLE KEYS */;
/*!40000 ALTER TABLE `networkmanager` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `order`
--

DROP TABLE IF EXISTS `order`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `order` (
  `orderID` varchar(256) NOT NULL,
  `customerID` varchar(256) NOT NULL,
  `branchID` varchar(256) NOT NULL,
  `price` varchar(256) DEFAULT NULL,
  `greetingCard` varchar(256) DEFAULT NULL,
  `items` varchar(1024) DEFAULT NULL,
  `status` varchar(256) DEFAULT NULL,
  `orderDate` datetime DEFAULT NULL,
  `expectedDelivery` datetime DEFAULT NULL,
  PRIMARY KEY (`orderID`,`customerID`,`branchID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `order`
--

LOCK TABLES `order` WRITE;
/*!40000 ALTER TABLE `order` DISABLE KEYS */;
/*!40000 ALTER TABLE `order` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `product`
--

DROP TABLE IF EXISTS `product`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `product` (
  `productID` varchar(256) NOT NULL,
  `name` varchar(256) DEFAULT NULL,
  `price` varchar(256) DEFAULT NULL,
  `itemType` varchar(256) DEFAULT NULL,
  `picture` varchar(256) DEFAULT NULL,
  `dominateColor` varchar(256) DEFAULT NULL,
  PRIMARY KEY (`productID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product`
--

LOCK TABLES `product` WRITE;
/*!40000 ALTER TABLE `product` DISABLE KEYS */;
/*!40000 ALTER TABLE `product` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `productinbranch`
--

DROP TABLE IF EXISTS `productinbranch`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `productinbranch` (
  `branchID` varchar(256) NOT NULL,
  `productID` varchar(256) DEFAULT NULL,
  `quantity` varchar(256) DEFAULT NULL,
  PRIMARY KEY (`branchID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `productinbranch`
--

LOCK TABLES `productinbranch` WRITE;
/*!40000 ALTER TABLE `productinbranch` DISABLE KEYS */;
/*!40000 ALTER TABLE `productinbranch` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `refunds`
--

DROP TABLE IF EXISTS `refunds`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `refunds` (
  `refundID` varchar(256) NOT NULL,
  `orderID` varchar(256) DEFAULT NULL,
  `customerID` varchar(256) DEFAULT NULL,
  `ammount` varchar(256) DEFAULT NULL,
  `reason` enum('Cancelation','Complaint','Delivery') DEFAULT NULL,
  `date` datetime DEFAULT NULL,
  PRIMARY KEY (`refundID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `refunds`
--

LOCK TABLES `refunds` WRITE;
/*!40000 ALTER TABLE `refunds` DISABLE KEYS */;
/*!40000 ALTER TABLE `refunds` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `registration`
--

DROP TABLE IF EXISTS `registration`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `registration` (
  `userID` varchar(256) NOT NULL,
  `firstName` varchar(256) DEFAULT NULL,
  `lastName` varchar(256) DEFAULT NULL,
  `userType` varchar(256) NOT NULL,
  `phoneNumber` varchar(256) DEFAULT NULL,
  `email` varchar(256) DEFAULT NULL,
  `userName` varchar(256) NOT NULL,
  `password` varchar(256) DEFAULT NULL,
  `creditCardNumber` varchar(256) DEFAULT NULL,
  `creditCardCvvCode` varchar(256) DEFAULT NULL,
  `creditCardDateOfExpiration` date DEFAULT NULL,
  `accountStatus` enum('CONFIRMED','PENDING_APPROVAL','FROZEN','PENDING_REGISTRATION') DEFAULT NULL,
  `isLoggedIn` tinyint DEFAULT NULL,
  PRIMARY KEY (`userID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `registration`
--

LOCK TABLES `registration` WRITE;
/*!40000 ALTER TABLE `registration` DISABLE KEYS */;
/*!40000 ALTER TABLE `registration` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `reports`
--

DROP TABLE IF EXISTS `reports`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `reports` (
  `reportID` varchar(256) NOT NULL,
  `reportType` enum('Orders','Income','Speicel','Survey','Complaint') DEFAULT NULL,
  `branchID` varchar(256) DEFAULT NULL,
  `reportCreator` varchar(256) DEFAULT NULL,
  `reportDuration` enum('Montly','Quarterly') DEFAULT NULL,
  `reportFile` blob,
  PRIMARY KEY (`reportID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `reports`
--

LOCK TABLES `reports` WRITE;
/*!40000 ALTER TABLE `reports` DISABLE KEYS */;
/*!40000 ALTER TABLE `reports` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `serviceexpert`
--

DROP TABLE IF EXISTS `serviceexpert`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `serviceexpert` (
  `serviceexpertID` varchar(256) NOT NULL,
  `firstName` varchar(256) DEFAULT NULL,
  `lastName` varchar(256) DEFAULT NULL,
  `email` varchar(256) DEFAULT NULL,
  `phoneNumber` varchar(256) DEFAULT NULL,
  `userName` varchar(256) DEFAULT NULL,
  `isLoggedIn` varchar(256) DEFAULT NULL,
  PRIMARY KEY (`serviceexpertID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `serviceexpert`
--

LOCK TABLES `serviceexpert` WRITE;
/*!40000 ALTER TABLE `serviceexpert` DISABLE KEYS */;
/*!40000 ALTER TABLE `serviceexpert` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `shopworker`
--

DROP TABLE IF EXISTS `shopworker`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `shopworker` (
  `shopworkerID` int NOT NULL,
  `branchID` varchar(256) DEFAULT NULL,
  `firstName` varchar(256) DEFAULT NULL,
  `lastName` varchar(256) DEFAULT NULL,
  `email` varchar(256) DEFAULT NULL,
  `phoneNumber` varchar(256) DEFAULT NULL,
  `userName` varchar(256) DEFAULT NULL,
  `isLoggedIn` varchar(256) DEFAULT NULL,
  PRIMARY KEY (`shopworkerID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `shopworker`
--

LOCK TABLES `shopworker` WRITE;
/*!40000 ALTER TABLE `shopworker` DISABLE KEYS */;
/*!40000 ALTER TABLE `shopworker` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `surveys`
--

DROP TABLE IF EXISTS `surveys`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `surveys` (
  `surveysresultsID` varchar(256) NOT NULL,
  `branchID` varchar(256) DEFAULT NULL,
  `customerID` varchar(256) DEFAULT NULL,
  `questionNumber1` varchar(256) DEFAULT NULL,
  `questionNumber2` varchar(256) DEFAULT NULL,
  `questionNumber3` varchar(256) DEFAULT NULL,
  `questionNumber4` varchar(256) DEFAULT NULL,
  `questionNumber5` varchar(256) DEFAULT NULL,
  `questionNumber6` varchar(256) DEFAULT NULL,
  `answerNumber1` varchar(256) DEFAULT NULL,
  `answerNumber2` varchar(256) DEFAULT NULL,
  `answerNumber3` varchar(256) DEFAULT NULL,
  `answerNumber4` varchar(256) DEFAULT NULL,
  `answerNumber5` varchar(256) DEFAULT NULL,
  `answerNumber6` varchar(256) DEFAULT NULL,
  `targetAudience` varchar(256) DEFAULT NULL,
  `date` date DEFAULT NULL,
  PRIMARY KEY (`surveysresultsID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `surveys`
--

LOCK TABLES `surveys` WRITE;
/*!40000 ALTER TABLE `surveys` DISABLE KEYS */;
/*!40000 ALTER TABLE `surveys` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-05-04 13:48:22

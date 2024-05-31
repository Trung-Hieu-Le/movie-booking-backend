-- MySQL dump 10.13  Distrib 8.0.36, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: movie_booking
-- ------------------------------------------------------
-- Server version	8.0.30

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
-- Table structure for table `accounts`
--

DROP TABLE IF EXISTS `accounts`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `accounts` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `phone` varchar(20) NOT NULL,
  `email` varchar(255) DEFAULT NULL,
  `password` varchar(255) NOT NULL,
  `birthday` date NOT NULL,
  `gender` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `accounts`
--

LOCK TABLES `accounts` WRITE;
/*!40000 ALTER TABLE `accounts` DISABLE KEYS */;
INSERT INTO `accounts` VALUES (1,'John Doe','0123456789','john.doe@example.com','password123','1990-01-01','nam'),(2,'Natasha','0345678910','john.doe@gmail.com','password123','2003-06-29','nữ');
/*!40000 ALTER TABLE `accounts` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cinemas`
--

DROP TABLE IF EXISTS `cinemas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cinemas` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `city` varchar(255) NOT NULL,
  `location` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cinemas`
--

LOCK TABLES `cinemas` WRITE;
/*!40000 ALTER TABLE `cinemas` DISABLE KEYS */;
INSERT INTO `cinemas` VALUES (1,'CCV Hà Đông','Hà Nội','Hà Đông'),(2,'CCV Long Biên','Hà Nội','Long Biên, HN');
/*!40000 ALTER TABLE `cinemas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `genre_relationships`
--

DROP TABLE IF EXISTS `genre_relationships`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `genre_relationships` (
  `movie_id` int NOT NULL,
  `genre_id` int NOT NULL,
  PRIMARY KEY (`movie_id`,`genre_id`),
  KEY `FKjtn78cjh8nu6ns5hv3l3axpvt` (`genre_id`),
  CONSTRAINT `FKamabjkk0n0qwhf3378llpr6dr` FOREIGN KEY (`movie_id`) REFERENCES `movies` (`id`),
  CONSTRAINT `FKjtn78cjh8nu6ns5hv3l3axpvt` FOREIGN KEY (`genre_id`) REFERENCES `genres` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `genre_relationships`
--

LOCK TABLES `genre_relationships` WRITE;
/*!40000 ALTER TABLE `genre_relationships` DISABLE KEYS */;
INSERT INTO `genre_relationships` VALUES (4,1),(4,2),(4,9),(4,10);
/*!40000 ALTER TABLE `genre_relationships` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `genres`
--

DROP TABLE IF EXISTS `genres`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `genres` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `genres`
--

LOCK TABLES `genres` WRITE;
/*!40000 ALTER TABLE `genres` DISABLE KEYS */;
INSERT INTO `genres` VALUES (1,'Hành động'),(2,'Phiêu lưu'),(3,'Kinh dị'),(4,'Hài hước'),(5,'Tình cảm'),(6,'Khoa học viễn tưởng'),(7,'Gia đình'),(8,'Hoạt hình'),(9,'Tâm lý'),(10,'Hồi hộp'),(11,'Chính kịch'),(12,'Lịch sử'),(13,'Hình sự'),(14,'Học đường'),(15,'Thể thao'),(16,'Âm nhạc'),(17,'Thần thoại'),(18,'Huyền bí'),(19,'Viễn tây'),(20,'Anime');
/*!40000 ALTER TABLE `genres` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `movies`
--

DROP TABLE IF EXISTS `movies`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `movies` (
  `id` int NOT NULL AUTO_INCREMENT,
  `title` varchar(255) NOT NULL,
  `description` text,
  `image` varchar(255) DEFAULT NULL,
  `release_date` date NOT NULL,
  `age_limit` int DEFAULT NULL,
  `director` varchar(255) DEFAULT NULL,
  `actors` text,
  `price` int NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `movies`
--

LOCK TABLES `movies` WRITE;
/*!40000 ALTER TABLE `movies` DISABLE KEYS */;
INSERT INTO `movies` VALUES (1,'Inception',NULL,NULL,'2024-04-01',13,'Christopher Nolan','Leonardo DiCaprio, Joseph Gordon-Levitt, Ellen Page',80000),(2,'The Shawshank Redemption',NULL,NULL,'2024-04-01',16,'Frank Darabont','Tim Robbins, Morgan Freeman, Bob Gunton',80000),(3,'The Godfather',NULL,NULL,'2024-04-01',18,'Francis Ford Coppola','Marlon Brando, Al Pacino, James Caan',80000),(4,'The Dark Knight',NULL,NULL,'2024-04-01',13,'Christopher Nolan','Christian Bale, Heath Ledger, Aaron Eckhart',80000),(5,'Pulp Fiction',NULL,NULL,'2024-04-01',18,'Quentin Tarantino','John Travolta, Uma Thurman, Samuel L. Jackson',80000),(6,'Schindler\'s List',NULL,NULL,'2024-04-01',16,'Steven Spielberg','Liam Neeson, Ralph Fiennes, Ben Kingsley',80000),(7,'The Lord of the Rings: The Return of the King',NULL,NULL,'2024-04-01',13,'Peter Jackson','Elijah Wood, Viggo Mortensen, Ian McKellen',80000),(8,'Forrest Gump',NULL,NULL,'2024-04-01',13,'Robert Zemeckis','Tom Hanks, Robin Wright, Gary Sinise',80000),(9,'Fight Club',NULL,NULL,'2024-04-01',18,'David Fincher','Brad Pitt, Edward Norton, Meat Loaf',80000),(10,'Goodfellas',NULL,NULL,'2024-04-01',18,'Martin Scorsese','Robert De Niro, Ray Liotta, Joe Pesci',80000);
/*!40000 ALTER TABLE `movies` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `seat_relationships`
--

DROP TABLE IF EXISTS `seat_relationships`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `seat_relationships` (
  `ticket_id` int NOT NULL,
  `seat` varchar(10) NOT NULL,
  PRIMARY KEY (`ticket_id`,`seat`),
  CONSTRAINT `FK4ur9u35c66jb1b3qrfwewkfps` FOREIGN KEY (`ticket_id`) REFERENCES `tickets` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `seat_relationships`
--

LOCK TABLES `seat_relationships` WRITE;
/*!40000 ALTER TABLE `seat_relationships` DISABLE KEYS */;
INSERT INTO `seat_relationships` VALUES (1,'A4'),(1,'A5'),(2,'A5'),(3,'E1'),(3,'E2'),(3,'E3'),(7,'B7'),(7,'B8');
/*!40000 ALTER TABLE `seat_relationships` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `showtimes`
--

DROP TABLE IF EXISTS `showtimes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `showtimes` (
  `id` int NOT NULL AUTO_INCREMENT,
  `movie_id` int DEFAULT NULL,
  `cinema_id` int DEFAULT NULL,
  `show_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `movie_id` (`movie_id`),
  KEY `cinema_id` (`cinema_id`),
  CONSTRAINT `showtimes_ibfk_1` FOREIGN KEY (`movie_id`) REFERENCES `movies` (`id`),
  CONSTRAINT `showtimes_ibfk_2` FOREIGN KEY (`cinema_id`) REFERENCES `cinemas` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `showtimes`
--

LOCK TABLES `showtimes` WRITE;
/*!40000 ALTER TABLE `showtimes` DISABLE KEYS */;
INSERT INTO `showtimes` VALUES (1,4,1,'2024-04-07 19:30:00'),(2,4,2,'2024-04-07 19:00:00'),(3,4,2,'2024-04-07 21:00:00'),(4,7,2,'2024-04-19 13:00:00');
/*!40000 ALTER TABLE `showtimes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tickets`
--

DROP TABLE IF EXISTS `tickets`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tickets` (
  `id` int NOT NULL AUTO_INCREMENT,
  `showtime_id` int NOT NULL,
  `account_id` int NOT NULL,
  `total_seat` int NOT NULL,
  `total_price` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `tickets_ibfk_1` (`showtime_id`),
  KEY `FK4mrc6xhhc9aksyk9fcbfq6qp6` (`account_id`),
  CONSTRAINT `FK4mrc6xhhc9aksyk9fcbfq6qp6` FOREIGN KEY (`account_id`) REFERENCES `accounts` (`id`),
  CONSTRAINT `tickets_ibfk_1` FOREIGN KEY (`showtime_id`) REFERENCES `showtimes` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tickets`
--

LOCK TABLES `tickets` WRITE;
/*!40000 ALTER TABLE `tickets` DISABLE KEYS */;
INSERT INTO `tickets` VALUES (1,1,1,2,160000),(2,2,1,1,80000),(3,3,2,3,240000),(7,1,2,2,160000);
/*!40000 ALTER TABLE `tickets` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-04-19 16:55:07

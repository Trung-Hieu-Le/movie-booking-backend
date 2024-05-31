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
  `email` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `birthday` date NOT NULL,
  `gender` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `accounts`
--

LOCK TABLES `accounts` WRITE;
/*!40000 ALTER TABLE `accounts` DISABLE KEYS */;
INSERT INTO `accounts` VALUES (1,'Lê Trung Hiếu','0123456789','hieult@example.com','password123','2003-01-01','nam'),(2,'Tăng Xuân Chiến','0345678910','txchien@gmail.com','123456','2003-06-29','nam'),(3,'Guest','123','guest@gmail.com','123','2000-05-29','nữ'),(4,'Nguyễn Văn Dũng','0135674787','dungnv@gmail.com','123456','2023-05-09','nam'),(5,'Nguyễn Thanh Bản','0458746102','ntban@gmail.com','password','1995-11-15','nam');
/*!40000 ALTER TABLE `accounts` ENABLE KEYS */;
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
INSERT INTO `genre_relationships` VALUES (14,1),(5,2),(2,3),(10,3),(3,4),(5,4),(9,4),(2,5),(8,5),(2,7),(3,7),(4,7),(10,7),(11,7),(10,8),(1,9),(4,9),(7,9),(11,9),(5,11),(9,11),(12,11),(6,12),(1,15),(7,15),(8,15),(12,15),(14,15),(4,16),(1,20),(6,20),(12,20),(13,20),(14,20);
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
INSERT INTO `genres` VALUES (1,'Nhạc kịch'),(2,'Viễn tưởng'),(3,'Hồi hộp'),(4,'Hành động'),(5,'Kinh dị'),(6,'Khoa học - Tài liệu'),(7,'Tâm lí'),(8,'Hình sự'),(9,'Gia đình'),(10,'Chiến tranh '),(11,'Phiêu lưu'),(12,'Thể thao'),(13,'Bí ẩn'),(14,'Võ thuật'),(15,'Hài hước'),(16,'Tình cảm'),(17,'Lịch sử'),(18,'Viễn tây'),(19,'Game show'),(20,'Hoạt hình');
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
  `image` varchar(1000) DEFAULT NULL,
  `release_date` date NOT NULL,
  `age_limit` int DEFAULT NULL,
  `director` varchar(255) DEFAULT NULL,
  `actors` text,
  `price` int NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `movies`
--

LOCK TABLES `movies` WRITE;
/*!40000 ALTER TABLE `movies` DISABLE KEYS */;
INSERT INTO `movies` VALUES (1,'Mèo Mập Mang 10 Mạng','Một chú mèo được nuông chiều tới mức sinh ra ích kỷ, không trân trọng những may mắn mà mình đang tận hưởng khi được Rose - một cô sinh viên tốt bụng cứu giúp và yêu thương. Nhưng tất cả sắp sửa thay đổi khi cậu ta bất cẩn làm mất đi 9 mạng sống của mình.','https://cinema.momocdn.net/img/57931658006859608-vVCE6yyfkVsD8ZLEtYOfS0KpDPN.jpg','2024-04-26',0,'Christopher Jenkins','Mo Gilligan, Simone Ashley, Sophie Okonedo, Zayn Malik, Dylan Llewellyn, Jeremy Swift và Bill Nighy',100000),(2,'Tarot','Bạn sẽ nhìn thấy ai khi trút hơi thở cuối cùng?','https://iguov8nhvyobj.vcdn.cloud/media/catalog/product/cache/1/image/1800x/71252117777b696995f01934522c402d/7/0/700x1000-tarot.jpg','2024-05-03',18,'Spenser Cohen, Anna Halberg','Avantika, Jacob Batalon, Olwen Fouéré',80000),(3,'Vây hãm: Kẻ trừng phạt','Siêu cớm Ma Seok-do tái xuất để đối đầu với những tội phạm tinh vi trong giới công nghệ. Nắm đấm trứ danh liệu có phát huy được sức mạnh trước liên minh tội phạm của thiên tài công nghệ và ông trùm nhà cái lớn nhất châu Á?','https://iguov8nhvyobj.vcdn.cloud/media/catalog/product/cache/1/image/c5f0a1eff4c394a251036189ccddaacd/4/0/406x600-roundup_1.jpg','2024-04-26',18,'Heo Myeong Haeng','Ma Dong-seok, Kim Mu-yeol, Lee Joo-bin',80000),(4,'Tháng Tư, ngày em đến','Fujishiro Shun (Satoh Takeru) đang chuẩn bị kết hôn. Một ngày tháng Tư, Fujishiro bỗng nhận được lá thư từ Haru (Nana Mori), mối tình 10 năm trước của anh. Cùng lúc đó, vợ sắp cưới Fujishiro là Yayoi (Masami Nagasawa) đột nhiên biến mất. Fujishiro bắt đầu bước vào hành trình tìm kiếm người người vợ chưa cưới với những kỷ niệm lúc cả hai bên nhau, cùng lúc đó hồi ức tình yêu thanh xuân cũng ùa về. Bộ phim mang màu sắc lãng mạn với nhiều cảnh quay trải dài khắp Tokyo, Uyuni (Bolivia), Prague (Cộng hòa Séc), Iceland và các quốc gia khác trên thế giới.','https://iguov8nhvyobj.vcdn.cloud/media/catalog/product/cache/1/image/c5f0a1eff4c394a251036189ccddaacd/4/7/470wx700h-april.jpg','2024-05-17',13,'Tomokazu Yamada','Satoh Takeru, Mori Nana, Nagasawa Masami',80000),(5,'Hành tinh Khỉ: Vương quốc mới','Đạo diễn Wes Ball mang một hơi thở mới đến loạt phim điện ảnh danh tiếng này. Lấy bối cảnh nhiều đời sau sự ra đi của Vua Khỉ Caesar, hành tinh này là nơi loài khỉ thống trị, còn loài người dần lui về trong bóng tối. Khi một thủ lĩnh khỉ có tên Proximus Caesar xây dựng đế chế của mình, chú khỉ trẻ tuổi Noa bắt đầu một hành trình gian khổ, đặt câu hỏi về tất cả những gì anh ta đã biết về quá khứ và đưa ra những lựa chọn định hình lại tương lai cho cả loài khỉ và loài người.','https://iguov8nhvyobj.vcdn.cloud/media/catalog/product/cache/1/image/c5f0a1eff4c394a251036189ccddaacd/f/z/fzone_007c_g_vie-vn_4x5_.jpg','2024-05-10',13,'Wes Ball','Owen Teague, Freya Allan, Kevin Durand, Peter Macon, and William H. Macy',80000),(6,'Haikyu!!: Trận chiến bãi phế liệu','Một trong những series manga và anime thể thao về bóng chuyền nổi tiếng nhất mọi thời đại. Cuộc đối đầu bóng chuyền giữa hai đối thủ đầy \"duyên nợ\" Cao trung Karasuno và THPT Nekoma hứa hẹn sẽ vô cùng kịch tính và không kém phần thú vị. Bạn sẽ theo team Quạ hay team Mèo?','https://iguov8nhvyobj.vcdn.cloud/media/catalog/product/cache/1/image/c5f0a1eff4c394a251036189ccddaacd/g/l/glx_hqm_kv_social.jpg','2024-05-17',0,'Susumu Mitsunaka','ayumu murase, Kaito Ishikawa, Yuki Kaji, Yûichi Nakamura, kouki uchiyama',80000),(7,'Những người bạn tưởng tượng','Bộ phim xoay quanh một cô bé bất ngờ phát hiện ra mình có thể nhìn thấy những người bạn tưởng tượng của mọi người. Và cuộc hành trình bắt đầu khi cô bé sử dụng siêu năng lực của mình để giúp đỡ những người bạn tưởng tượng này tránh khỏi việc bị bỏ rơi và lãng quên bằng cách tìm kiếm, kết nối chúng với những đứa trẻ.','https://iguov8nhvyobj.vcdn.cloud/media/catalog/product/cache/1/image/c5f0a1eff4c394a251036189ccddaacd/i/f/if_movie_poster_700x1000.jpg','2024-05-17',0,'John Krasinski','Ryan Reynolds, Cailey Fleming, John Krasinski',80000),(8,'Ngôi đền kì quái 4','Hồn ma Nak với sức mạnh khủng khiếp nhất, đáng sợ nhất mà bộ đôi mỏ hỗn Balloon & First phải đối mặt để giải cứu cho trai đẹp Min Joon. Liệu hội bạn này sẽ giải được nghiệp mình tạo ra hay sẽ tan rã từ đây?','https://iguov8nhvyobj.vcdn.cloud/media/catalog/product/cache/1/image/c5f0a1eff4c394a251036189ccddaacd/4/0/406x600-peenak.jpg','2024-05-27',18,'Phontharis Chotkijsadarsopon','Witthawat Rattanaboonbaramee, Bhuripat Vejvongsatechawat, Phiravich Attachitsataporn',80000),(9,'Furiosa: Câu chuyện từ Max điên','Câu chuyện bắt đầu từ lúc Thế giới sụp đổ, Furiosa phải tự cứu lấy mình để trở về nhà. Một cuộc phiêu lưu hành động độc lập khốc liệt, tiền truyện về quái nữ đồng hành với Max Rockatansky ra rạp 2024.','https://is1-ssl.mzstatic.com/image/thumb/Music211/v4/d4/06/28/d40628b0-e0c6-0866-4ed9-https://iguov8nhvyobj.vcdn.cloud/media/catalog/product/cache/3/thumbnail/190x260/2e2b8cd282892c71872b9e67d2cb5039/v/n/vn_vietnam_friosa_vert_first_poster_2764x4096_intl_1_.jpg','2024-05-24',18,'George Miller','Anya Taylor-Joy, Chris Hemsworth, Nathan Jones',80000),(10,'Stalker: Tội ác hoàn hảo','Lợi dụng công việc môi giới bất động sản của mình, Koo Jung-tae thường xuyên đột nhập vào những căn nhà bằng chìa khoá được khách hàng giao để thoả mãn sở thích rình rập và trộm các món đồ không cần thiết. Mọi rắc rối bắt đầu khi anh bí mật theo dõi cuộc sống của Han Sora - cô gái xinh đẹp, nổi tiếng trên mạng xã hội. Đến một ngày, Han Sora trở thành khách hàng của văn phòng môi giới bất động sản mà Koo Jung-tae làm việc. Có được chìa khoá căn hộ của Han Sora, theo “thói quen”, Koo Jung-tae lẻn vào nhà và bất ngờ chứng kiến cảnh Han Sora chết trên sofa. Bị thám tử Oh Young-joo buộc tội giết người, Koo Jung-tae buộc phải tìm kiếm tên tội phạm thực sự và khám phá ra nhiều bí mật động trời phía sau cái chết của Han Sora.','https://iguov8nhvyobj.vcdn.cloud/media/catalog/product/cache/1/image/1800x/71252117777b696995f01934522c402d/f/l/fl_teaser-poster_final-1.jpg','2024-05-31',16,'Kim Sehwi','Byun Yo-han, Shin Hye-sun, Lee El',80000),(11,'Lật mặt 7: Một điều ước','Một câu chuyện lần đầu được kể bằng tất cả tình yêu, và từ tất cả những hồi ức xao xuyến nhất của đấng sinh thành','https://iguov8nhvyobj.vcdn.cloud/media/catalog/product/cache/1/image/c5f0a1eff4c394a251036189ccddaacd/l/a/lat-mat-7.jpg','2024-04-26',13,'Lý Hải','Thanh Hiền, Trương Minh Cường, Đinh Y Nhung, Quách Ngọc Tuyên, Trâm Anh, Trần Kim Hải',100000),(12,'Mèo béo siêu quậy','Garfield (Chris Pratt) là một chú mèo nổi tiếng khắp thế giới, hướng nội, siêu ghét thứ hai và cực yêu món lasagna bị cuốn vào một chuyến phiêu lưu ngoài trời. Sau cuộc hội ngộ đầy bất ngờ với người cha đã mất từ lâu của mình là chú mèo đường phố lôi thôi Vic - Vic (Samuel L. Jackson), Garfield và người bạn chó Odie bị buộc phải từ bỏ cuộc sống được nuông chiều của mình để tham gia cùng Vic trong một vụ cướp vui nhộn, với nhiều rủi ro.','https://cinestar.com.vn/_next/image/?url=https%3A%2F%2Fcinestar.com.vn%2Fpictures%2FCinestar%2F05-2024%2Fmeo-beo-sieu-quay.jpg&w=3840&q=75','2024-05-31',13,'Mark Dindal','Hannah Waddingham, Chris Pratt, Samuel L. Jackson, Brett Goldstein, Cecily Strong',80000),(13,'Totto-chan: Cô bé bên cửa sổ','Sau khi không phù hợp với trường tiểu học ban đầu, Totto Chan đi học tại Tomoe Gakuen. Tại đây, cô gặp những học sinh đặc biệt và học được những điều mới mẻ, ngay cả khi Nhật Bản rơi vào chiến tranh.','https://iguov8nhvyobj.vcdn.cloud/media/catalog/product/cache/1/image/c5f0a1eff4c394a251036189ccddaacd/t/o/totto-chan_-_payoff_poster_kt_facebook_-_dkkc_31.05.2024_1_.jpg','2024-05-31',13,'Shinnosuke Yakuwa','Liliana Ohno, Koji Yakusho, Shun Oguri, Anne Watanabe, Karen Takizawa',100000),(14,'Doraemon: Nobita Và Bản Giao Hưởng Địa Cầu','TÁC PHẨM KỶ NIỆM 90 NĂM FUJIKO F FUJIO Chuẩn bị cho buổi hòa nhạc ở trường, Nobita đang tập thổi sáo - nhạc cụ mà cậu dở tệ. Thích thú trước nốt \"No\" lạc quẻ của Nobita, Micca - cô bé bí ẩn đã mời Doraemon, Nobita cùng nhóm bạn đến \"Farre\" - Cung điện âm nhạc tọa lạc trên một hành tinh nơi âm nhạc sẽ hóa thành năng lượng. Nhằm cứu cung điện này, Micca đang tìm kiếm \"virtuoso\" - bậc thầy âm nhạc sẽ cùng mình biểu diễn! Với bảo bối thần kì \"chứng chỉ chuyên viên âm nhạc\", Doraemon và các bạn đã chọn nhạc cụ, cùng Micca hòa tấu, từng bước khôi phục cung điện. Tuy nhiên, một vật thể sống đáng sợ sẽ xóa số âm nhạc khỏi thế giới đang đến gần, Trái Đất đang rơi vào nguy hiểm... ! Liệu những người bạn nhỏ có thể cứu được \"tương lai âm nhạc\" và cả địa cầu này?','https://baodongnai.com.vn/file/e7837c02876411cd0187645a2551379f/052024/18_2_20240523155958.jpg','2024-05-24',0,'Kazuaki Imai','Wasabi Mizuta, Megumi Ôhara, Yumi Kakazu',100000);
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
INSERT INTO `seat_relationships` VALUES (8,'C3'),(8,'C4'),(9,'C3'),(9,'C4'),(10,'D3'),(10,'D4'),(10,'D5'),(10,'D6'),(11,'E2'),(12,'E2'),(12,'E3'),(13,'A1'),(14,'A1'),(15,'A1'),(16,'B2'),(16,'B6'),(19,'B1'),(19,'B2'),(19,'C1'),(20,'B2'),(20,'B3'),(21,'B2'),(21,'B3'),(22,'D3'),(23,'D3'),(24,'D3'),(24,'D4'),(25,'D3'),(25,'D4'),(26,'E1'),(27,'E1'),(27,'E2'),(28,'E1'),(28,'E2'),(29,'E1'),(29,'E2'),(30,'F3'),(30,'F4'),(30,'F5'),(31,'F3'),(31,'F4'),(31,'F5'),(32,'F3'),(32,'F4'),(32,'F5'),(33,'A2'),(33,'A3'),(33,'A4'),(34,'C1'),(34,'C2');
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
  `show_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `movie_id` (`movie_id`),
  CONSTRAINT `showtimes_ibfk_1` FOREIGN KEY (`movie_id`) REFERENCES `movies` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=66 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `showtimes`
--

LOCK TABLES `showtimes` WRITE;
/*!40000 ALTER TABLE `showtimes` DISABLE KEYS */;
INSERT INTO `showtimes` VALUES (1,1,'2024-04-26 19:30:00'),(2,1,'2024-04-26 21:00:00'),(3,1,'2024-04-27 10:00:00'),(4,2,'2024-05-03 23:00:00'),(5,2,'2024-05-04 03:00:00'),(6,2,'2024-05-05 21:00:00'),(7,3,'2024-04-26 17:30:00'),(8,3,'2024-04-27 20:00:00'),(9,4,'2024-05-17 18:00:00'),(10,4,'2024-05-17 21:00:00'),(11,4,'2024-05-18 20:00:00'),(12,4,'2024-05-19 22:00:00'),(13,5,'2024-05-10 20:00:00'),(14,5,'2024-05-10 22:00:00'),(15,5,'2024-05-11 16:00:00'),(16,5,'2024-05-11 19:30:00'),(17,5,'2024-05-12 22:30:00'),(18,6,'2024-05-17 14:00:00'),(19,6,'2024-05-17 17:00:00'),(20,6,'2024-05-18 17:30:00'),(21,6,'2024-05-18 20:30:00'),(22,7,'2024-05-17 15:00:00'),(23,7,'2024-05-17 20:30:00'),(24,7,'2024-05-18 17:00:00'),(25,8,'2024-05-27 23:00:00'),(26,8,'2024-05-28 01:00:00'),(27,8,'2024-05-28 13:00:00'),(28,8,'2024-05-28 21:00:00'),(29,9,'2024-05-24 20:30:00'),(30,9,'2024-05-25 08:30:00'),(31,9,'2024-05-25 20:30:00'),(32,10,'2024-05-31 16:00:00'),(33,10,'2024-05-31 19:30:00'),(34,10,'2024-06-01 12:00:00'),(35,11,'2024-04-26 20:00:00'),(36,11,'2024-05-26 22:30:00'),(37,11,'2024-05-27 20:00:00'),(38,11,'2024-05-27 22:30:00'),(39,11,'2024-05-28 15:00:00'),(40,11,'2024-05-28 17:30:00'),(41,12,'2024-05-31 18:00:00'),(42,12,'2024-05-31 20:00:00'),(43,12,'2024-06-01 15:00:00'),(44,12,'2024-06-01 17:30:00'),(45,12,'2024-06-01 20:00:00'),(46,12,'2024-06-02 14:00:00'),(47,12,'2024-06-02 16:30:00'),(48,13,'2024-05-31 16:30:00'),(49,13,'2024-05-31 18:30:00'),(50,13,'2024-05-31 21:00:00'),(53,13,'2024-06-01 16:30:00'),(54,13,'2024-06-01 19:00:00'),(55,13,'2024-06-02 15:00:00'),(56,13,'2024-06-02 17:30:00'),(57,14,'2024-05-24 23:00:00'),(58,14,'2024-05-24 22:30:00'),(60,14,'2024-05-25 18:00:00'),(61,14,'2024-05-25 21:00:00'),(63,14,'2024-05-26 10:00:00'),(64,14,'2024-05-26 17:00:00'),(65,14,'2024-05-26 20:00:00');
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
) ENGINE=InnoDB AUTO_INCREMENT=35 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tickets`
--

LOCK TABLES `tickets` WRITE;
/*!40000 ALTER TABLE `tickets` DISABLE KEYS */;
INSERT INTO `tickets` VALUES (8,1,1,2,200000),(9,7,1,2,160000),(10,35,1,4,200000),(11,40,1,1,100000),(12,50,1,2,200000),(13,56,1,1,100000),(14,5,2,1,80000),(15,23,2,1,80000),(16,32,2,2,160000),(19,40,2,3,300000),(20,60,2,2,200000),(21,65,2,2,200000),(22,3,3,1,100000),(23,25,3,1,80000),(24,42,3,2,160000),(25,60,3,2,200000),(26,2,4,1,100000),(27,23,4,2,160000),(28,33,4,2,160000),(29,45,4,2,160000),(30,20,5,3,240000),(31,24,5,3,240000),(32,39,5,3,300000),(33,40,5,3,300000),(34,60,5,2,200000);
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

-- Dump completed on 2024-05-30 22:41:57

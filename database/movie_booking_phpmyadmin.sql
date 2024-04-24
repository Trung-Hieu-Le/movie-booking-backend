-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: localhost:3306
-- Generation Time: Apr 22, 2024 at 02:58 AM
-- Server version: 8.0.30
-- PHP Version: 8.1.10

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `movie_booking`
--

-- --------------------------------------------------------

--
-- Table structure for table `accounts`
--

CREATE TABLE `accounts` (
  `id` int NOT NULL,
  `name` varchar(255) NOT NULL,
  `phone` varchar(20) NOT NULL,
  `email` varchar(255) DEFAULT NULL,
  `password` varchar(255) NOT NULL,
  `birthday` date NOT NULL,
  `gender` varchar(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Dumping data for table `accounts`
--

INSERT INTO `accounts` (`id`, `name`, `phone`, `email`, `password`, `birthday`, `gender`) VALUES
(1, 'John Doe', '0123456789', 'john.doe@example.com', 'password123', '1990-01-01', 'nam'),
(2, 'Natasha', '0345678910', 'john.doe@gmail.com', 'password123', '2003-06-29', 'nữ');

-- --------------------------------------------------------

--
-- Table structure for table `cinemas`
--

CREATE TABLE `cinemas` (
  `id` int NOT NULL,
  `name` varchar(255) NOT NULL,
  `city` varchar(255) NOT NULL,
  `location` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Dumping data for table `cinemas`
--

INSERT INTO `cinemas` (`id`, `name`, `city`, `location`) VALUES
(1, 'CCV Hà Đông', 'Hà Nội', 'Hà Đông'),
(2, 'CCV Long Biên', 'Hà Nội', 'Long Biên, HN');

-- --------------------------------------------------------

--
-- Table structure for table `genres`
--

CREATE TABLE `genres` (
  `id` int NOT NULL,
  `name` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Dumping data for table `genres`
--

INSERT INTO `genres` (`id`, `name`) VALUES
(1, 'Hành động'),
(2, 'Phiêu lưu'),
(3, 'Kinh dị'),
(4, 'Hài hước'),
(5, 'Tình cảm'),
(6, 'Khoa học viễn tưởng'),
(7, 'Gia đình'),
(8, 'Hoạt hình'),
(9, 'Tâm lý'),
(10, 'Hồi hộp'),
(11, 'Chính kịch'),
(12, 'Lịch sử'),
(13, 'Hình sự'),
(14, 'Học đường'),
(15, 'Thể thao'),
(16, 'Âm nhạc'),
(17, 'Thần thoại'),
(18, 'Huyền bí'),
(19, 'Viễn tây'),
(20, 'Anime');

-- --------------------------------------------------------

--
-- Table structure for table `genre_relationships`
--

CREATE TABLE `genre_relationships` (
  `movie_id` int NOT NULL,
  `genre_id` int NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Dumping data for table `genre_relationships`
--

INSERT INTO `genre_relationships` (`movie_id`, `genre_id`) VALUES
(4, 1),
(4, 2),
(4, 9),
(4, 10);

-- --------------------------------------------------------

--
-- Table structure for table `movies`
--

CREATE TABLE `movies` (
  `id` int NOT NULL,
  `title` varchar(255) NOT NULL,
  `description` text,
  `image` varchar(255) DEFAULT NULL,
  `release_date` date NOT NULL,
  `age_limit` int DEFAULT NULL,
  `director` varchar(255) DEFAULT NULL,
  `actors` text,
  `price` int NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Dumping data for table `movies`
--

INSERT INTO `movies` (`id`, `title`, `description`, `image`, `release_date`, `age_limit`, `director`, `actors`, `price`) VALUES
(1, 'Inception', NULL, NULL, '2024-04-01', 13, 'Christopher Nolan', 'Leonardo DiCaprio, Joseph Gordon-Levitt, Ellen Page', 80000),
(2, 'The Shawshank Redemption', NULL, NULL, '2024-04-01', 16, 'Frank Darabont', 'Tim Robbins, Morgan Freeman, Bob Gunton', 80000),
(3, 'The Godfather', NULL, NULL, '2024-04-01', 18, 'Francis Ford Coppola', 'Marlon Brando, Al Pacino, James Caan', 80000),
(4, 'The Dark Knight', NULL, NULL, '2024-04-01', 13, 'Christopher Nolan', 'Christian Bale, Heath Ledger, Aaron Eckhart', 80000),
(5, 'Pulp Fiction', NULL, NULL, '2024-04-01', 18, 'Quentin Tarantino', 'John Travolta, Uma Thurman, Samuel L. Jackson', 80000),
(6, 'Schindler\'s List', NULL, NULL, '2024-04-01', 16, 'Steven Spielberg', 'Liam Neeson, Ralph Fiennes, Ben Kingsley', 80000),
(7, 'The Lord of the Rings: The Return of the King', NULL, NULL, '2024-04-01', 13, 'Peter Jackson', 'Elijah Wood, Viggo Mortensen, Ian McKellen', 80000),
(8, 'Forrest Gump', NULL, NULL, '2024-04-01', 13, 'Robert Zemeckis', 'Tom Hanks, Robin Wright, Gary Sinise', 80000),
(9, 'Fight Club', NULL, NULL, '2024-04-01', 18, 'David Fincher', 'Brad Pitt, Edward Norton, Meat Loaf', 80000),
(10, 'Goodfellas', NULL, NULL, '2024-04-01', 18, 'Martin Scorsese', 'Robert De Niro, Ray Liotta, Joe Pesci', 80000);

-- --------------------------------------------------------

--
-- Table structure for table `seat_relationships`
--

CREATE TABLE `seat_relationships` (
  `ticket_id` int NOT NULL,
  `seat` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Dumping data for table `seat_relationships`
--

INSERT INTO `seat_relationships` (`ticket_id`, `seat`) VALUES
(1, 'A4'),
(1, 'A5'),
(2, 'A5'),
(3, 'E1'),
(3, 'E2'),
(3, 'E3'),
(7, 'B7'),
(7, 'B8');

-- --------------------------------------------------------

--
-- Table structure for table `showtimes`
--

CREATE TABLE `showtimes` (
  `id` int NOT NULL,
  `movie_id` int DEFAULT NULL,
  `cinema_id` int DEFAULT NULL,
  `show_time` datetime DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Dumping data for table `showtimes`
--

INSERT INTO `showtimes` (`id`, `movie_id`, `cinema_id`, `show_time`) VALUES
(1, 4, 1, '2024-04-07 19:30:00'),
(2, 4, 2, '2024-04-07 19:00:00'),
(3, 4, 2, '2024-04-07 21:00:00'),
(4, 7, 2, '2024-04-19 13:00:00');

-- --------------------------------------------------------

--
-- Table structure for table `tickets`
--

CREATE TABLE `tickets` (
  `id` int NOT NULL,
  `showtime_id` int NOT NULL,
  `account_id` int NOT NULL,
  `total_seat` int NOT NULL,
  `total_price` int NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Dumping data for table `tickets`
--

INSERT INTO `tickets` (`id`, `showtime_id`, `account_id`, `total_seat`, `total_price`) VALUES
(1, 1, 1, 2, 160000),
(2, 2, 1, 1, 80000),
(3, 3, 2, 3, 240000),
(7, 1, 2, 2, 160000);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `accounts`
--
ALTER TABLE `accounts`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `cinemas`
--
ALTER TABLE `cinemas`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `genres`
--
ALTER TABLE `genres`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `genre_relationships`
--
ALTER TABLE `genre_relationships`
  ADD PRIMARY KEY (`movie_id`,`genre_id`),
  ADD KEY `FKjtn78cjh8nu6ns5hv3l3axpvt` (`genre_id`);

--
-- Indexes for table `movies`
--
ALTER TABLE `movies`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `seat_relationships`
--
ALTER TABLE `seat_relationships`
  ADD PRIMARY KEY (`ticket_id`,`seat`);

--
-- Indexes for table `showtimes`
--
ALTER TABLE `showtimes`
  ADD PRIMARY KEY (`id`),
  ADD KEY `movie_id` (`movie_id`),
  ADD KEY `cinema_id` (`cinema_id`);

--
-- Indexes for table `tickets`
--
ALTER TABLE `tickets`
  ADD PRIMARY KEY (`id`),
  ADD KEY `tickets_ibfk_1` (`showtime_id`),
  ADD KEY `FK4mrc6xhhc9aksyk9fcbfq6qp6` (`account_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `accounts`
--
ALTER TABLE `accounts`
  MODIFY `id` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `cinemas`
--
ALTER TABLE `cinemas`
  MODIFY `id` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `genres`
--
ALTER TABLE `genres`
  MODIFY `id` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=21;

--
-- AUTO_INCREMENT for table `movies`
--
ALTER TABLE `movies`
  MODIFY `id` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT for table `showtimes`
--
ALTER TABLE `showtimes`
  MODIFY `id` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `tickets`
--
ALTER TABLE `tickets`
  MODIFY `id` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `genre_relationships`
--
ALTER TABLE `genre_relationships`
  ADD CONSTRAINT `FKamabjkk0n0qwhf3378llpr6dr` FOREIGN KEY (`movie_id`) REFERENCES `movies` (`id`),
  ADD CONSTRAINT `FKjtn78cjh8nu6ns5hv3l3axpvt` FOREIGN KEY (`genre_id`) REFERENCES `genres` (`id`);

--
-- Constraints for table `seat_relationships`
--
ALTER TABLE `seat_relationships`
  ADD CONSTRAINT `FK4ur9u35c66jb1b3qrfwewkfps` FOREIGN KEY (`ticket_id`) REFERENCES `tickets` (`id`);

--
-- Constraints for table `showtimes`
--
ALTER TABLE `showtimes`
  ADD CONSTRAINT `showtimes_ibfk_1` FOREIGN KEY (`movie_id`) REFERENCES `movies` (`id`),
  ADD CONSTRAINT `showtimes_ibfk_2` FOREIGN KEY (`cinema_id`) REFERENCES `cinemas` (`id`);

--
-- Constraints for table `tickets`
--
ALTER TABLE `tickets`
  ADD CONSTRAINT `FK4mrc6xhhc9aksyk9fcbfq6qp6` FOREIGN KEY (`account_id`) REFERENCES `accounts` (`id`),
  ADD CONSTRAINT `tickets_ibfk_1` FOREIGN KEY (`showtime_id`) REFERENCES `showtimes` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jul 10, 2020 at 05:21 AM
-- Server version: 10.4.13-MariaDB
-- PHP Version: 7.2.31

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `javaworm_blog`
--

-- --------------------------------------------------------

--
-- Table structure for table `articles`
--

CREATE TABLE `articles` (
  `id` int(11) NOT NULL,
  `uri` varchar(255) DEFAULT NULL,
  `title` varchar(255) DEFAULT NULL,
  `author` varchar(255) DEFAULT NULL,
  `lastModifiedAt` datetime DEFAULT NULL,
  `published` tinyint(1) DEFAULT NULL,
  `createdAt` datetime NOT NULL,
  `updatedAt` datetime NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `articles`
--

INSERT INTO `articles` (`id`, `uri`, `title`, `author`, `lastModifiedAt`, `published`, `createdAt`, `updatedAt`) VALUES
(1, 'factory-pattern-javascript', 'Factory Pattern in Javascript', 'Abir Khan', '2020-02-15 00:00:00', 0, '2020-07-08 09:28:00', '2020-07-10 01:42:44'),
(2, 'async-await', 'Mastering Javascript Async-Await', 'Abir Khan', '2020-02-15 00:00:00', 0, '2020-07-08 09:28:00', '2020-07-10 01:43:13'),
(3, 'iterable-and-generator', 'Iterable and Generator in ES6', 'Abir Khan', '2020-06-20 00:00:00', 0, '2020-07-08 09:28:00', '2020-07-10 01:44:11'),
(4, 'angular-data-sharing', 'Data Sharing Between Angular Components', 'Abir Khan', '2020-02-25 00:00:00', 0, '2020-07-08 09:28:00', '2020-07-10 01:45:03'),
(5, 'simple-state-management', 'Simple State Management in Angular', 'Abir Khan', '2020-03-09 00:00:00', 1, '2020-07-08 09:28:00', '2020-07-10 01:45:43'),
(6, 'angular-directives', 'Angular Directives Description with Example', 'Abir Khan', '2020-03-12 00:00:00', 1, '2020-07-08 09:28:00', '2020-07-10 01:46:22'),
(7, 'rxjs-ten-operators', 'RxJs Ten Operators with Their Use Cases', 'Abir Khan', '2020-03-10 18:00:00', 0, '2020-07-08 09:28:00', '2020-07-09 14:15:07'),
(8, 'dom-manipulation-angular', 'Dom Manipulation in Angular Components', 'Abir Khan', '2020-03-11 18:00:00', 1, '2020-07-08 09:28:00', '2020-07-09 14:17:57'),
(9, 'content-projection-angular', 'Content Projection in Angular Described with Example', 'Abir Khan', '2020-03-13 18:00:00', 1, '2020-07-08 09:28:00', '2020-07-09 14:30:00'),
(10, 'spring-cloud-netflix-eureka', 'Service Discovery with Spring Cloud Netflix Eureka', 'Abir Khan', '2018-05-11 18:00:00', 1, '2020-07-08 09:28:00', '2020-07-09 14:35:32'),
(11, 'spring-security-xml', 'Securing Spring MVC Application Using XML Configuration', 'Abir Khan', '2018-08-11 18:00:00', 1, '2020-07-08 09:28:00', '2020-07-09 14:58:30'),
(12, 'spring-security-remember-me', 'Remember-me Implementation in Spring Security', 'Abir Khan', '2018-06-29 00:00:00', 1, '2020-07-08 09:28:00', '2020-07-10 01:41:31'),
(14, 'sso-using-github', 'Single Sign-on Using GitHub', 'Abir Khan', '2018-07-03 00:00:00', 1, '2020-07-08 09:28:00', '2020-07-10 01:49:17'),
(15, 'spring-method-security', 'Introduction To Method Security', 'Abir Khan', '2018-07-15 00:00:00', 1, '2020-07-08 09:28:00', '2020-07-10 01:51:28'),
(16, 'spring-cloud-config', 'A Short Discussion on Spring Cloud Config', 'Abir Khan', '2018-08-13 00:00:00', 1, '2020-07-08 09:28:00', '2020-07-10 01:55:47'),
(17, 'spring-data-get-started', 'Get Started with Spring Data', 'Abir Khan', '2018-09-09 00:00:00', 1, '2020-07-08 09:28:00', '2020-07-10 02:01:59'),
(18, 'spring-boot-data-jpa', 'The CRUD in Spring Boot Data JPA', 'Abir Khan', '2018-09-12 00:00:00', 1, '2020-07-08 09:28:00', '2020-07-10 02:08:00'),
(19, 'spring-webflux-intro', 'Introduction to Spring Webflux', 'Abir Khan', '2018-12-16 00:00:00', 1, '2020-07-08 09:28:00', '2020-07-10 02:14:38'),
(20, 'crud-spring-webflux', 'A REST Application Performing CRUD in Spring Webflux', 'Abir Khan', '2019-12-18 00:00:00', 1, '2020-07-08 09:28:00', '2020-07-10 02:18:10'),
(21, 'webfilter-in-webflux', 'Configuring Webfilter in Webflux', 'Abir Khan', '2018-12-30 00:00:00', 1, '2020-07-08 09:28:00', '2020-07-10 02:21:05'),
(22, 'rest-crud-in-webflux-functional', 'Implementing REST Crud in Webflux Functional Programming Model', 'Abir Khan', '2019-01-01 00:00:00', 1, '2020-07-08 09:28:00', '2020-07-10 02:25:36'),
(23, 'spring-boot-quickinfo-part1', 'Quick and Necessary Information on Spring Boot: Part-I', 'Abir Khan', '2019-01-03 00:00:00', 1, '2020-07-08 09:28:00', '2020-07-10 02:28:15'),
(24, 'spring-boot-quickinfo-part2', 'Quick and Necessary Information on Spring Boot: Part-II', 'Abir Khan', '2019-01-05 00:00:00', 1, '2020-07-08 09:28:00', '2020-07-10 02:41:46'),
(25, 'spring-boot-quickinfo-part3', 'Quick and Necessary Information on Spring Boot: Part-III', 'Abir Khan', '2019-01-07 00:00:00', 1, '2020-07-08 09:28:00', '2020-07-10 02:43:24'),
(26, 'spring-boot-quickinfo-part4', 'Quick and Necessary Information on Spring Boot: Part-IV', 'Abir Khan', '2019-01-22 00:00:00', 1, '2020-07-08 09:28:00', '2020-07-10 02:45:01'),
(27, 'spring-cloud-dataflow-intro', 'An Introduction To Spring Cloud Data Flow', 'Abir Khan', '2019-02-03 08:55:56', 1, '2020-07-08 09:28:00', '2020-07-10 02:55:12'),
(28, 'spring-boot-security-with-mysql', 'Configuring Database Driven Spring Boot Security', 'Abir Khan', '2019-03-01 09:06:55', 1, '2020-07-08 09:28:00', '2020-07-10 03:06:27'),
(29, 'spring-cloud-hystrix', 'A Short Discussion on Spring Cloud Hystrix', 'Abir Khan', '2019-05-20 00:00:00', 1, '2020-07-08 09:28:00', '2020-07-10 03:09:46'),
(32, 'spring-cloud-netflix-ribbon', 'Client Side Load Balancing Using Spring Cloud Netflix Ribbon', 'Abir Khan', '2019-05-21 09:13:43', 1, '2020-07-08 09:28:00', '2020-07-10 03:12:35'),
(33, 'spring-cloud-batch', 'Introduction to Spring Cloud Batch', 'Abir Khan', '2019-07-22 00:00:00', 1, '2020-07-08 09:28:00', '2020-07-10 03:17:30'),
(34, 'state-machine-intro-with-spring-boot', 'Configuring State Machine with Spring Boot', 'Abir Khan', '2020-04-14 00:00:00', 1, '2020-07-08 09:28:00', '2020-07-10 03:20:08');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `articles`
--
ALTER TABLE `articles`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `uri` (`uri`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `articles`
--
ALTER TABLE `articles`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=35;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

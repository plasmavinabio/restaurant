-- phpMyAdmin SQL Dump
-- version 4.0.10deb1
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Feb 05, 2018 at 12:11 AM
-- Server version: 5.6.33-0ubuntu0.14.04.1
-- PHP Version: 5.6.31-6+ubuntu14.04.1+deb.sury.org+1

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";

--
-- Database: `restaurant`
--

-- --------------------------------------------------------

--
-- Table structure for table `language`
--

CREATE TABLE IF NOT EXISTS `language` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `code` varchar(32) NOT NULL,
  `active` tinyint(1) NOT NULL DEFAULT '0',
  `is_default` tinyint(1) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8mb4 AUTO_INCREMENT=3 ;

--
-- Dumping data for table `language`
--

INSERT INTO `language` (`id`, `code`, `active`, `is_default`) VALUES
(1, 'vi', 1, 0),
(2, 'en', 1, 0);

-- --------------------------------------------------------

--
-- Table structure for table `message_source`
--

CREATE TABLE IF NOT EXISTS `message_source` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `code` varchar(265) NOT NULL,
  `default_message` text NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8mb4 AUTO_INCREMENT=5 ;

--
-- Dumping data for table `message_source`
--

INSERT INTO `message_source` (`id`, `code`, `default_message`) VALUES
(1, 'label.password', 'Password (DF)'),
(2, 'label.submit', 'Submit (DF)'),
(3, 'label.title', 'Login Page (DF)'),
(4, 'label.userName', 'User Name (DF)');

-- --------------------------------------------------------

--
-- Table structure for table `message_source_lang`
--

CREATE TABLE IF NOT EXISTS `message_source_lang` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `id_message_source` int(11) NOT NULL,
  `id_lang` int(11) NOT NULL,
  `message` text NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8mb4 AUTO_INCREMENT=9 ;

--
-- Dumping data for table `message_source_lang`
--

INSERT INTO `message_source_lang` (`id`, `id_message_source`, `id_lang`, `message`) VALUES
(1, 1, 1, 'Mật khẩu'),
(2, 2, 1, 'Đăng nhập'),
(3, 3, 1, 'Trang đăng nhập'),
(4, 4, 1, 'Tài khoản đăng nhập'),
(5, 1, 2, 'Password'),
(6, 2, 2, 'Login'),
(7, 3, 2, 'Login Page'),
(8, 4, 2, 'User Name');

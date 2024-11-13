-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Sep 07, 2024 at 07:28 AM
-- Server version: 10.4.32-MariaDB
-- PHP Version: 8.0.30

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `quiz`
--

-- --------------------------------------------------------

--
-- Table structure for table `question`
--

CREATE TABLE `question` (
  `id` int(11) NOT NULL,
  `category` varchar(255) DEFAULT NULL,
  `difficulty_level` varchar(255) DEFAULT NULL,
  `option1` varchar(255) DEFAULT NULL,
  `option2` varchar(255) DEFAULT NULL,
  `option3` varchar(255) DEFAULT NULL,
  `question_title` varchar(255) DEFAULT NULL,
  `right_answer` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `question`
--

INSERT INTO `question` (`id`, `category`, `difficulty_level`, `option1`, `option2`, `option3`, `question_title`, `right_answer`) VALUES
(1, 'Java', 'Medium', 'It\'s always executed, regardless of exceptions.', 'It\'s only executed if an exception occurs.', 'It\'s used for resource management.', 'What is the purpose of the `finally` block in Java?', 'It\'s always executed, regardless of exceptions. and It\'s used for resource management.'),
(2, 'Java', 'Easy', 'int', 'char', 'String', 'Which data type is used to represent a single character in Java?', 'char'),
(3, 'Java', 'Hard', 'static methods can be called without creating an object.', 'static methods cannot access instance variables.', 'static methods cannot be overridden.', 'What is the difference between a `static` method and a non-`static` method?', 'static methods can be called without creating an object. static methods cannot access instance variables. static methods cannot be overridden.'),
(4, 'Python', 'Easy', 'To declare a variable', 'To define a function', 'To execute code conditionally', 'What is the primary purpose of the `if` statement in Python?', 'To execute code conditionally'),
(5, 'Python', 'Medium', 'Using square brackets `[]`', 'Using curly braces `{}`', 'Using parentheses `()`', 'How do you create a list in Python?', 'Using square brackets `[]`'),
(6, 'Python', 'Hard', 'A shallow copy creates a new list with the same elements.', 'A deep copy creates a new list with new copies of the elements.', 'A shallow copy is faster than a deep copy.', 'What is the difference between a shallow copy and a deep copy of a list in Python?', 'A shallow copy creates a new list with the same elements. A deep copy creates a new list with new copies of the elements.'),
(7, 'JavaScript', 'Easy', 'To create a new HTML element', 'To get an element by its ID', 'To set the style of an element', 'What is the primary purpose of the `document.getElementById()` method in JavaScript?', 'To get an element by its ID'),
(8, 'JavaScript', 'Medium', '`==` checks for equality of values, while `===` checks for both value and type equality.', '`==` is always stricter than `===`.', '`===` is always stricter than `==`.', 'What is the difference between `==` and `===` in JavaScript?', '`==` checks for equality of values, while `===` checks for both value and type equality.'),
(9, 'JavaScript', 'Hard', 'To refer to the current object', 'To define a variable', 'To call a function', 'What is the purpose of the `this` keyword in JavaScript?', 'To refer to the current object'),
(10, 'C', 'Easy', 'printf', 'scanf', 'puts', 'Which function is used to print formatted output to the console in C?', 'printf'),
(11, 'C', 'Medium', 'int', 'float', 'char', 'Which data type is used to store a single character in C?', 'char'),
(12, 'C', 'Hard', 'pointer', 'array', 'struct', 'What is the purpose of a pointer in C?', 'pointer'),
(13, 'PHP', 'Easy', 'echo', 'print', 'var_dump', 'Which function is used to print a variable\'s value in PHP?', 'echo'),
(14, 'PHP', 'Medium', 'string', 'integer', 'boolean', 'What is the data type of a variable that stores a text string in PHP?', 'string'),
(15, 'PHP', 'Hard', '$_GET', '$_POST', '$_SESSION', 'How are form data submitted to a PHP script?', '$_GET and $_POST'),
(16, 'Java', 'Easy', 'James Gosling', 'Ramey Shrestha', 'PK Frendrin', 'Who is developer of Java?', 'James Gosling');

-- --------------------------------------------------------

--
-- Table structure for table `question_seq`
--

CREATE TABLE `question_seq` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `question_seq`
--

INSERT INTO `question_seq` (`next_val`) VALUES
(1);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `question`
--
ALTER TABLE `question`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `question`
--
ALTER TABLE `question`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=17;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

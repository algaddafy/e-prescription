-- phpMyAdmin SQL Dump
-- version 5.0.3
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Sep 25, 2021 at 05:54 PM
-- Server version: 10.4.14-MariaDB
-- PHP Version: 7.2.34

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `preskibo`
--

-- --------------------------------------------------------

--
-- Table structure for table `doctor`
--

CREATE TABLE `doctor` (
  `Name` varchar(50) NOT NULL,
  `Email` varchar(50) NOT NULL,
  `Password` varchar(50) NOT NULL,
  `Designation` varchar(50) NOT NULL,
  `Gender` varchar(10) DEFAULT NULL,
  `DOB` varchar(50) DEFAULT NULL,
  `Department` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `doctor`
--

INSERT INTO `doctor` (`Name`, `Email`, `Password`, `Designation`, `Gender`, `DOB`, `Department`) VALUES
('Gaddafy', 'gaddafy@gmail.com', '123456', 'M.B.B.S', 'Male', '9/26/2021', 'Neurologist'),
('Gaddafy', 'test', '123456', 'F.C.P.S', 'Male', '9/15/2021', 'Heart Specialist');

-- --------------------------------------------------------

--
-- Table structure for table `medicine`
--

CREATE TABLE `medicine` (
  `Name` varchar(20) DEFAULT NULL,
  `Generic` varchar(20) DEFAULT NULL,
  `Details` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `medicine`
--

-- INSERT INTO `medicine` (`Name`, `Generic`, `Details`) VALUES
-- ('Napa', 'Paracetemol', NULL);

-- --------------------------------------------------------

--
-- Table structure for table `patient`
--

CREATE TABLE `patient` (
  `ID` varchar(20) DEFAULT NULL,
  `Name` varchar(20) NOT NULL,
  `Age` varchar(20) NOT NULL,
  `Phone` varchar(20) NOT NULL,
  `Email` varchar(20) NOT NULL,
  `DOB` varchar(20) NOT NULL,
  `Gender` varchar(20) NOT NULL,
  `Doctor` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `patient`
--

-- INSERT INTO `patient` (`ID`, `Name`, `Age`, `Phone`, `Email`, `DOB`, `Gender`, `Doctor`) VALUES
-- ('28930', 'gaddafy', '21', '1234341', 'test1', '9/14/2021', 'Female', NULL),
-- ('59776', 'Nipa Saha', '22', '12345678', 'nipa@gmail.com', '9/1/2021', 'Female', 'test'),
-- ('543445', 'Nipa ', '22', '12345678', 'nipa@hmail.com', '9/29/2021', 'Female', 'test');

-- --------------------------------------------------------

--
-- Table structure for table `prescription`
--

CREATE TABLE `prescription` (
  `Pt_name` varchar(30) DEFAULT NULL,
  `Pt_ID` varchar(20) DEFAULT NULL,
  `doctor` varchar(50) DEFAULT NULL,
  `Medicine_name` varchar(20) DEFAULT NULL,
  `Dose` varchar(20) DEFAULT NULL,
  `Advice` varchar(20) DEFAULT NULL,
  `Duration` varchar(20) DEFAULT NULL,
  `Strength` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `prescription`
--

-- INSERT INTO `prescription` (`Pt_name`, `Pt_ID`, `doctor`, `Medicine_name`, `Dose`, `Advice`, `Duration`, `Strength`) VALUES
-- ('Nipa ', '543445', 'test', 'Flazyl', '0+0+1', 'After Meal', '3 Day', '250 Mg'),
-- ('Nipa ', '543445', 'test', 'Seclo', '1+1+1', 'Before Meal', '7 Day', '500 Mg'),
-- ('Nipa ', '543445', 'test', 'Napa', '1+0+1', 'After Meal', '10 Day', '500 Mg');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `patient`
--
ALTER TABLE `patient`
  ADD UNIQUE KEY `ID` (`ID`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

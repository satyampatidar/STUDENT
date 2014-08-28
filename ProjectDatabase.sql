-- MySQL Administrator dump 1.4
--
-- ------------------------------------------------------
-- Server version	5.0.13-rc-nt


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


--
-- Create schema students
--

CREATE DATABASE IF NOT EXISTS students;
USE students;

--
-- Definition of table `course`
--

DROP TABLE IF EXISTS `course`;
CREATE TABLE `course` (
  `courseid` int(10) unsigned NOT NULL auto_increment,
  `coursename` varchar(45) NOT NULL,
  `coursetype` varchar(45) NOT NULL,
  PRIMARY KEY  (`courseid`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `course`
--

/*!40000 ALTER TABLE `course` DISABLE KEYS */;
INSERT INTO `course` (`courseid`,`coursename`,`coursetype`) VALUES 
 (5,'BE','tech'),
 (6,'MCA','tech'),
 (7,'BBA','non-tech'),
 (8,'MBA','nontech');
/*!40000 ALTER TABLE `course` ENABLE KEYS */;


--
-- Definition of table `marks`
--

DROP TABLE IF EXISTS `marks`;
CREATE TABLE `marks` (
  `marksid` int(7) unsigned NOT NULL auto_increment,
  `subjectid` int(7) default NULL,
  `studentid` int(7) default NULL,
  `marks` int(7) default NULL,
  PRIMARY KEY  (`marksid`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `marks`
--

/*!40000 ALTER TABLE `marks` DISABLE KEYS */;
INSERT INTO `marks` (`marksid`,`subjectid`,`studentid`,`marks`) VALUES 
 (2,22,1,45),
 (3,17,1,34),
 (4,19,1,66),
 (5,20,1,67),
 (6,21,1,67),
 (7,17,2,55),
 (8,19,2,66),
 (9,20,2,56),
 (11,21,2,87),
 (12,22,2,68),
 (13,17,3,88),
 (14,19,3,78),
 (15,20,3,76),
 (16,21,3,65),
 (17,22,3,65);
/*!40000 ALTER TABLE `marks` ENABLE KEYS */;


--
-- Definition of table `student`
--

DROP TABLE IF EXISTS `student`;
CREATE TABLE `student` (
  `studentid` int(7) unsigned NOT NULL auto_increment,
  `enrollno` varchar(20) default NULL,
  `firstname` varchar(20) default NULL,
  `middlename` varchar(20) default NULL,
  `lastname` varchar(20) default NULL,
  `address` varchar(20) default NULL,
  `mobile` varchar(20) default NULL,
  `email` varchar(20) default NULL,
  `semester` int(7) default NULL,
  `dob` date default NULL,
  `courseid` int(7) default NULL,
  PRIMARY KEY  (`studentid`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `student`
--

/*!40000 ALTER TABLE `student` DISABLE KEYS */;
INSERT INTO `student` (`studentid`,`enrollno`,`firstname`,`middlename`,`lastname`,`address`,`mobile`,`email`,`semester`,`dob`,`courseid`) VALUES 
 (1,'be001','Amit','Kumar','Gupta','MP','5464656','aaa@aaa.com',1,'1986-11-11',5),
 (2,'be002','Pratique','Kumar','Suhane','Sagar','7686889','sss@aa.com',1,'1988-11-11',5),
 (3,'be003','Rahul','Kumar','Gupta','Subhash Nagar Bhopal','9876786556','amit@gmail.com',1,'1988-11-11',5),
 (4,'be004','Alakh','Chand','Singh','MP Nagar Bhopal','98765767554','alakh@yahoo.com',1,'1988-11-11',5),
 (5,'be005','Sourabh','Kumar','Jain','Ekta Colony Sagar','9878766577','sourab@rediff.com',1,'1987-11-11',5),
 (6,'be006','Yaman','Kumar','Jain','MP Nagar','9876454554','yaman@ymail.com',1,'1988-11-11',5),
 (7,'be007','Ravi','Kumar','Pathak','Mansarovar Bhopal','9876765443','ravi@ravi.com',1,'1988-11-11',5);
/*!40000 ALTER TABLE `student` ENABLE KEYS */;


--
-- Definition of table `subjects`
--

DROP TABLE IF EXISTS `subjects`;
CREATE TABLE `subjects` (
  `subjectid` int(7) NOT NULL auto_increment,
  `subjectcode` varchar(20) default NULL,
  `subjectname` varchar(20) default NULL,
  `semester` int(7) default NULL,
  `courseid` int(7) default NULL,
  PRIMARY KEY  (`subjectid`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `subjects`
--

/*!40000 ALTER TABLE `subjects` DISABLE KEYS */;
INSERT INTO `subjects` (`subjectid`,`subjectcode`,`subjectname`,`semester`,`courseid`) VALUES 
 (17,'01','Info Tech',1,5),
 (19,'02','Ope Sys',1,5),
 (20,'03','Com Design',1,5),
 (21,'04','Chemistry',1,5),
 (22,'05','Physics',1,5),
 (23,'06','Engg drawing',1,6),
 (24,'07','Communication Slill',1,6),
 (25,'08','Network Security',1,6),
 (26,'09','Compiler',1,6),
 (27,'10','Data Structure',1,6);
/*!40000 ALTER TABLE `subjects` ENABLE KEYS */;




/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;

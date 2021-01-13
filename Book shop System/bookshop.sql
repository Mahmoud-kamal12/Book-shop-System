--
-- Database: `bookshop`
--


drop database if exists bookshop;

create database if not exists bookshop charset=utf8 collate=utf8_general_ci;

use bookshop ;


-- --------------------------------------------------------

--
-- Table structure for table `admin`
--

CREATE TABLE `admin` (
  `adminId` int(11) NOT NULL,
  `adminName` varchar(20) NOT NULL,
  `adminUserName` varchar(20) NOT NULL,
  `adminPassword` varchar(20) NOT NULL,
  `adminEmail` varchar(60) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `admin`
--

INSERT INTO `admin` (`adminId`, `adminName`, `adminUserName`, `adminPassword`, `adminEmail`) VALUES
(1, 'Mahmoud kamal', 'Mahmoud_Kamal', '123123', 'Mahmoud@gmail.com'),
(2, '1', '1', '1', '1');

-- --------------------------------------------------------

--
-- Table structure for table `author`
--

CREATE TABLE `author` (
  `authorId` int(11) NOT NULL,
  `authorName` varchar(30) NOT NULL,
  `authorEmail` varchar(30) NOT NULL,
  `authorCity` varchar(10) NOT NULL,
  `authorDB` date NOT NULL,
  `DBADD` date NOT NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `books`
--

CREATE TABLE `books` (
  `bookId` int(11) NOT NULL,
  `bookName` varchar(16) NOT NULL,
  `bookCost` int(11) NOT NULL,
  `NumOfBooks` int(11) NOT NULL,
  `bookDatePublish` date DEFAULT NULL,
  `category_categoryId` int(11) NOT NULL,
  `author_authorId` int(11) NOT NULL,
  `DBADD` date NOT NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `category`
--

CREATE TABLE `category` (
  `categoryId` int(11) NOT NULL,
  `categoryName` varchar(20) NOT NULL,
  `categoryDiscruption` varchar(150) NOT NULL,
  `DBADD` date NOT NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `clients`
--

CREATE TABLE `clients` (
  `clientid` int(11) NOT NULL,
  `clientEmail` varchar(255) NOT NULL,
  `clientName` varchar(32) NOT NULL,
  `clientAddres` varchar(32) NOT NULL,
  `clientPhone` varchar(45) NOT NULL,
  `numOfBooks` int(11) NOT NULL,
  `DateOfSale` date NOT NULL,
  `books_bookid` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `admin`
--
ALTER TABLE `admin`
  ADD PRIMARY KEY (`adminId`);

--
-- Indexes for table `author`
--
ALTER TABLE `author`
  ADD PRIMARY KEY (`authorId`);

--
-- Indexes for table `books`
--
ALTER TABLE `books`
  ADD PRIMARY KEY (`bookId`),
  ADD KEY `books_ibfk_1` (`author_authorId`),
  ADD KEY `books_ibfk_2` (`category_categoryId`);

--
-- Indexes for table `category`
--
ALTER TABLE `category`
  ADD PRIMARY KEY (`categoryId`);

--
-- Indexes for table `clients`
--
ALTER TABLE `clients`
  ADD PRIMARY KEY (`clientid`),
  ADD KEY `books_bookid` (`books_bookid`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `admin`
--
ALTER TABLE `admin`
  MODIFY `adminId` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `author`
--
ALTER TABLE `author`
  MODIFY `authorId` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `books`
--
ALTER TABLE `books`
  MODIFY `bookId` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `category`
--
ALTER TABLE `category`
  MODIFY `categoryId` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `clients`
--
ALTER TABLE `clients`
  MODIFY `clientid` int(11) NOT NULL AUTO_INCREMENT;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `books`
--
ALTER TABLE `books`
  ADD CONSTRAINT `books_ibfk_1` FOREIGN KEY (`author_authorId`) REFERENCES `author` (`authorId`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `books_ibfk_2` FOREIGN KEY (`category_categoryId`) REFERENCES `category` (`categoryId`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `clients`
--
ALTER TABLE `clients`
  ADD CONSTRAINT `clients_ibfk_1` FOREIGN KEY (`books_bookid`) REFERENCES `books` (`bookId`);
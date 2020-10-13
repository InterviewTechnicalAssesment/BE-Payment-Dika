# ************************************************************
# Sequel Pro SQL dump
# Version 4541
#
# http://www.sequelpro.com/
# https://github.com/sequelpro/sequelpro
#
# Host: 127.0.0.1 (MySQL 5.7.26)
# Database: localdatabase
# Generation Time: 2020-10-13 15:12:51 +0000
# ************************************************************


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


# Dump of table payment
# ------------------------------------------------------------

DROP TABLE IF EXISTS `payment`;

CREATE TABLE `payment` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `payment_type_id` int(11) DEFAULT NULL,
  `payment_status` varchar(30) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL DEFAULT 'UNBILLED',
  `promo_id` int(11) DEFAULT NULL,
  `restaurant_id` int(11) NOT NULL,
  `total` int(11) DEFAULT NULL,
  `total_pay` int(11) DEFAULT NULL,
  `created_at` timestamp NULL DEFAULT NULL,
  `updated_at` timestamp NULL DEFAULT NULL,
  `created_by` varchar(45) DEFAULT NULL,
  `updated_by` varchar(45) DEFAULT NULL,
  `status` varchar(10) DEFAULT 'ACTIVE',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

LOCK TABLES `payment` WRITE;
/*!40000 ALTER TABLE `payment` DISABLE KEYS */;

INSERT INTO `payment` (`id`, `payment_type_id`, `payment_status`, `promo_id`, `restaurant_id`, `total`, `total_pay`, `created_at`, `updated_at`, `created_by`, `updated_by`, `status`)
VALUES
  (1,3,'WAITING_FOR_PAYMENT',1,1,480000,480000,NULL,NULL,NULL,NULL,'ACTIVE'),
  (3,5,'DONE',2,1,500000,400000,NULL,NULL,NULL,NULL,'ACTIVE');

/*!40000 ALTER TABLE `payment` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table payment_menu
# ------------------------------------------------------------

DROP TABLE IF EXISTS `payment_menu`;

CREATE TABLE `payment_menu` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `invoice_id` int(11) NOT NULL,
  `menu_id` int(11) NOT NULL,
  `quantity` int(11) NOT NULL,
  `price` double NOT NULL,
  `type` varchar(10) DEFAULT NULL,
  `created_at` timestamp NULL DEFAULT NULL,
  `updated_at` timestamp NULL DEFAULT NULL,
  `created_by` varchar(45) DEFAULT NULL,
  `updated_by` varchar(45) DEFAULT NULL,
  `status` varchar(10) DEFAULT 'ACTIVE',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

LOCK TABLES `payment_menu` WRITE;
/*!40000 ALTER TABLE `payment_menu` DISABLE KEYS */;

INSERT INTO `payment_menu` (`id`, `invoice_id`, `menu_id`, `quantity`, `price`, `type`, `created_at`, `updated_at`, `created_by`, `updated_by`, `status`)
VALUES
  (2,1,1,20,300000,NULL,NULL,NULL,NULL,NULL,'ACTIVE'),
  (3,1,2,10,180000,NULL,NULL,NULL,NULL,NULL,'ACTIVE'),
  (4,1,2,10,0,'BONUS',NULL,NULL,NULL,NULL,'ACTIVE'),
  (5,2,1,30,450000,NULL,NULL,NULL,NULL,NULL,'ACTIVE'),
  (6,2,3,10,50000,NULL,NULL,NULL,NULL,NULL,'ACTIVE');

/*!40000 ALTER TABLE `payment_menu` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table payment_type
# ------------------------------------------------------------

DROP TABLE IF EXISTS `payment_type`;

CREATE TABLE `payment_type` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) DEFAULT NULL,
  `type` varchar(50) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL DEFAULT 'CASH',
  `bank` varchar(50) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `created_at` timestamp NULL DEFAULT NULL,
  `updated_at` timestamp NULL DEFAULT NULL,
  `created_by` varchar(45) DEFAULT NULL,
  `updated_by` varchar(45) DEFAULT NULL,
  `status` varchar(10) DEFAULT 'ACTIVE',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

LOCK TABLES `payment_type` WRITE;
/*!40000 ALTER TABLE `payment_type` DISABLE KEYS */;

INSERT INTO `payment_type` (`id`, `name`, `type`, `bank`, `created_at`, `updated_at`, `created_by`, `updated_by`, `status`)
VALUES
  (1,NULL,'CASH',NULL,NULL,NULL,NULL,NULL,'ACTIVE'),
  (2,'PRECIOUS','CREDIT CARD','MANDIRI',NULL,NULL,NULL,NULL,'ACTIVE'),
  (3,'SIGNATURE','CREDIT CARD','MANDIRI',NULL,NULL,NULL,NULL,'ACTIVE'),
  (4,'TRAVELOKA','CREDIT CARD','MANDIRI',NULL,NULL,NULL,NULL,'ACTIVE'),
  (5,'SKYZ','CREDIT CARD','MANDIRI',NULL,NULL,NULL,NULL,'ACTIVE'),
  (6,'PERTAMINA','CREDIT CARD','MANDIRI',NULL,NULL,NULL,NULL,'ACTIVE'),
  (7,'GOLF SIGNATURE','CREDIT CARD','MANDIRI',NULL,NULL,NULL,NULL,'ACTIVE'),
  (8,'GOLF PLATINUM','CREDIT CARD','MANDIRI',NULL,NULL,NULL,NULL,'ACTIVE'),
  (9,'GOLF GOLD','CREDIT CARD','MANDIRI',NULL,NULL,NULL,NULL,'ACTIVE'),
  (10,NULL,'DEBIT','MANDIRI',NULL,NULL,NULL,NULL,'ACTIVE'),
  (11,NULL,'EMONEY','MANDIRI',NULL,NULL,NULL,NULL,'ACTIVE');

/*!40000 ALTER TABLE `payment_type` ENABLE KEYS */;
UNLOCK TABLES;



/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

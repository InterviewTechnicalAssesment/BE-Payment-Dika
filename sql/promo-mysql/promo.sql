# ************************************************************
# Sequel Pro SQL dump
# Version 4541
#
# http://www.sequelpro.com/
# https://github.com/sequelpro/sequelpro
#
# Host: 127.0.0.1 (MySQL 5.7.26)
# Database: localdatabase
# Generation Time: 2020-10-13 15:13:33 +0000
# ************************************************************


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


# Dump of table promo
# ------------------------------------------------------------

DROP TABLE IF EXISTS `promo`;

CREATE TABLE `promo` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `promo_type` varchar(10) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL DEFAULT 'DISCOUNT',
  `payment_type_id` int(11) NOT NULL,
  `restaurant_id` int(11) NOT NULL,
  `req_bonus_menu_id` int(11) DEFAULT NULL,
  `req_bonus_menu_id_qty` int(11) DEFAULT NULL,
  `menu_id_bonus` int(11) DEFAULT NULL,
  `menu_id_bonus_qty` int(11) DEFAULT NULL,
  `req_discount_min` double DEFAULT NULL,
  `discount` int(11) DEFAULT NULL,
  `discount_max` double DEFAULT NULL,
  `created_at` timestamp NULL DEFAULT NULL,
  `updated_at` timestamp NULL DEFAULT NULL,
  `created_by` varchar(45) DEFAULT NULL,
  `updated_by` varchar(45) DEFAULT NULL,
  `status` varchar(10) DEFAULT 'ACTIVE',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

LOCK TABLES `promo` WRITE;
/*!40000 ALTER TABLE `promo` DISABLE KEYS */;

INSERT INTO `promo` (`id`, `promo_type`, `payment_type_id`, `restaurant_id`, `req_bonus_menu_id`, `req_bonus_menu_id_qty`, `menu_id_bonus`, `menu_id_bonus_qty`, `req_discount_min`, `discount`, `discount_max`, `created_at`, `updated_at`, `created_by`, `updated_by`, `status`)
VALUES
  (1,'DISCOUNT',5,1,NULL,NULL,NULL,NULL,500000,10,500000,NULL,NULL,NULL,NULL,'ACTIVE'),
  (2,'BONUS',3,1,1,20,2,10,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'ACTIVE');

/*!40000 ALTER TABLE `promo` ENABLE KEYS */;
UNLOCK TABLES;



/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

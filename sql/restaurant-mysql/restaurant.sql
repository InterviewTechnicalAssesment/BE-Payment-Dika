# Dump of table restaurant
# ------------------------------------------------------------

DROP TABLE IF EXISTS `restaurant`;

CREATE TABLE `restaurant` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `type` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  `address` varchar(500) COLLATE utf8_unicode_ci NOT NULL DEFAULT '',
  `postcode` int(5) DEFAULT NULL,
  `created_at` timestamp NULL DEFAULT NULL,
  `updated_at` timestamp NULL DEFAULT NULL,
  `created_by` varchar(45) DEFAULT NULL,
  `updated_by` varchar(45) DEFAULT NULL,
  `status` varchar(10) DEFAULT 'ACTIVE',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

LOCK TABLES `restaurant` WRITE;
/*!40000 ALTER TABLE `restaurant` DISABLE KEYS */;

INSERT INTO `restaurant` (`id`, `name`, `type`, `address`, `postcode`, `created_at`, `updated_at`, `created_by`, `updated_by`, `status`)
VALUES
  (1,'Nan Gombang','Restoran','Jalan Ciater Barat no 98 Tangerang Selatan',15310,now(),NULL,NULL,NULL,'ACTIVE'),
  (2,'Manhattan Coffee & Cuts','Kafe','Jalan Panglima Polim 9 No. 18, RT.2/RW.7',12160,now(),NULL,NULL,NULL,'ACTIVE'),
  (3,'Ombe Kofie','Kafe','Mall Kelapa Gading 1 Ground Floor unit #G-190, Jalan Boulevard Raya, RT.13/RW.18',14240,now(),NULL,NULL,NULL,'ACTIVE'),
  (4,'Maarkeze','Kafe','Grand Indonesia East Mall, M.H. No.1,, Jl. M.H. Thamrin, RT.1/RW.5',10310,now(),NULL,NULL,NULL,'ACTIVE'),
  (5,'Kaca Coffee & Eatery','Restoran','Jl. KH Mansyur no. 129-130',10230,now(),NULL,NULL,NULL,'ACTIVE'),
  (6,'Wolter House','Kafe','Jl. Wolter Monginsidi No.39, Lantai 3',12180,now(),NULL,NULL,NULL,'ACTIVE'),
  (7,'One Fifteenth Coffee','Restoran','Jalan Gandaria 1/63 ',12130,now(),NULL,NULL,NULL,'ACTIVE'),
  (8,'Filosofi Kopi','Kafe','Jalan Cendrawasih',50174,now(),NULL,NULL,NULL,'ACTIVE'),
  (9,'Shirokuma','Kafe','Jalan Pantai Indah Utara 2 No.127, RW.7, Ruko Gallery 8 No. EK-EL, Kapuk Muara, Penjaringan, Pantai Indah Kapuk',14460,now(),NULL,NULL,NULL,'ACTIVE'),
  (10,'Nusa Kopi','Kafe','Jl. KH. Ahmad Dahlan Kby. No.2, Kramat Pela, Kby. Baru, Kota Jakarta Selatan, Daerah Khusus Ibukota Jakarta 12130',12130,now(),NULL,NULL,NULL,'ACTIVE');

/*!40000 ALTER TABLE `restaurant` ENABLE KEYS */;
UNLOCK TABLES;

# Dump of table menu
# ------------------------------------------------------------
DROP TABLE IF EXISTS menu;

CREATE TABLE menu (
  id int(11) NOT NULL AUTO_INCREMENT,
  restaurant_id int(11) NOT NULL,
  name varchar(45) NOT NULL,
  category varchar(45) NOT NULL,
  photo_url varchar(255) DEFAULT NULL,
  price double NULL,
  created_at timestamp NULL DEFAULT NULL,
  updated_at timestamp NULL DEFAULT NULL,
  created_by varchar(45) DEFAULT NULL,
  updated_by varchar(45) DEFAULT NULL,
  status varchar(10) DEFAULT 'ACTIVE',
  PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

LOCK TABLES menu WRITE;
/*!40000 ALTER TABLE menu DISABLE KEYS */;

INSERT INTO menu (id, restaurant_id,name, category, photo_url, price, created_at, updated_at, created_by, updated_by, status)
VALUES
  (1,1,'Ayam Gulai','Lauk Utama','https://www.islampos.com/wp-content/uploads/2018/01/gulai-ayam-.jpg',15000,now(),NULL,NULL,NULL,'ACTIVE'),
  (2,1,'Rendang','Lauk Utama','https://assets.pikiran-rakyat.com/crop/0x0:0x0/x/photo/2020/05/23/2598383914.jpg',18000,now(),NULL,NULL,NULL,'ACTIVE'),
  (3,1,'Teh Talua','Minuman','https://akcdn.detik.net.id/community/media/visual/2019/10/02/2afcb3ad-6b85-416b-bd88-814b3d478f47_169.jpeg?w=700&q=90',5000,now(),NULL,NULL,NULL,'ACTIVE'),
  (4,1,'Kerupuk Jangek','Lauk Sampingan','https://upload.wikimedia.org/wikipedia/commons/thumb/9/94/Kerupuk_kulit.JPG/500px-Kerupuk_kulit.JPG',3000,now(),NULL,NULL,NULL,'ACTIVE');

UNLOCK TABLES;
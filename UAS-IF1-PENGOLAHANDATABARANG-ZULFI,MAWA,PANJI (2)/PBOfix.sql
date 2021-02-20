/*
SQLyog Ultimate v12.5.1 (64 bit)
MySQL - 10.1.37-MariaDB : Database - tugasbesarpbo
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`tugasbesarpbo` /*!40100 DEFAULT CHARACTER SET latin1 */;

USE `tugasbesarpbo`;

/*Table structure for table `data_bahan` */

DROP TABLE IF EXISTS `data_bahan`;

CREATE TABLE `data_bahan` (
  `Kode_Barang` varchar(10) NOT NULL,
  `Nama_Barang` varchar(20) DEFAULT NULL,
  `Satuan` varchar(10) DEFAULT NULL,
  `Harga_Satuan` varchar(10) DEFAULT NULL,
  `Kuantitas` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`Kode_Barang`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `data_bahan` */

insert  into `data_bahan`(`Kode_Barang`,`Nama_Barang`,`Satuan`,`Harga_Satuan`,`Kuantitas`) values 
('101','Bawang Putih','Kilogram','20000','98'),
('102','Bawang Merah','Kilogram','25000','100'),
('103','Bubuk Roti','Kilogram','15000','100'),
('104','Bawang Goreng','Kilogram','40000','100');

/*Table structure for table `data_karyawan` */

DROP TABLE IF EXISTS `data_karyawan`;

CREATE TABLE `data_karyawan` (
  `ID` varchar(10) NOT NULL,
  `Nama_Karyawan` varchar(20) DEFAULT NULL,
  `Jenis_Kelamin` varchar(10) DEFAULT NULL,
  `Alamat` varchar(30) DEFAULT NULL,
  `No_HP` varchar(15) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `data_karyawan` */

insert  into `data_karyawan`(`ID`,`Nama_Karyawan`,`Jenis_Kelamin`,`Alamat`,`No_HP`) values 
('401','Iwan Setiawan','Laki-Laki','Jl. Cikajang','0818424523'),
('402','Dede Irawan','Laki-laki','Jl. Cikajang','08784352634'),
('403','Jajang Sudrajat','Laki-laki','jl. Cigadung raya','08956773241'),
('501','Rini Sunarti','Perempuan','Jl. Bojong Kaler','08385412365');

/*Table structure for table `data_transaksi` */

DROP TABLE IF EXISTS `data_transaksi`;

CREATE TABLE `data_transaksi` (
  `Kode_Transaksi` varchar(10) NOT NULL,
  `Kuantitas` varchar(10) DEFAULT NULL,
  `Kode_Barang` varchar(10) DEFAULT NULL,
  `ID` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`Kode_Transaksi`),
  KEY `Kode_Barang` (`Kode_Barang`),
  KEY `ID` (`ID`),
  CONSTRAINT `data_transaksi_ibfk_1` FOREIGN KEY (`Kode_Barang`) REFERENCES `data_bahan` (`Kode_Barang`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `data_transaksi_ibfk_2` FOREIGN KEY (`ID`) REFERENCES `data_karyawan` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `data_transaksi` */

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

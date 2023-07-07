--CREATE DATABASE warehouse_db;
--
--USE warehouse_db;

DROP TABLE IF EXISTS warehouses;
CREATE TABLE warehouses (
  `id_warehouse` bigint(20) NOT NULL,
  `name_warehouse` varchar(100) NOT NULL,
  `address_warehouse` varchar(255) NOT NULL,
  `phone_number_warehouse` varchar(15) DEFAULT NULL,
  `warehouse_code` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id_warehouse`)
)

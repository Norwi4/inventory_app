UNLOCK TABLES;

DROP TABLE IF EXISTS `product`;
DROP TABLE IF EXISTS `consignment`;
DROP TABLE IF EXISTS `dish`;
DROP TABLE IF EXISTS `dish_product`;

CREATE TABLE `product`
(
    `id`          bigint(19) unsigned NOT NULL AUTO_INCREMENT,
    `name`        varchar(255),
    `article`     varchar(255),
    `price`       bigint(19),
    `warehouseId` bigint(19),
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  AUTO_INCREMENT = 1
  DEFAULT CHARSET = utf8;

CREATE TABLE `consignment`
(
    `id`             bigint(19) unsigned NOT NULL AUTO_INCREMENT,
    `article`        varchar(255),
    `quantity`       bigint(19),
    `comeInDate`     timestamp           NOT NULL DEFAULT CURRENT_TIMESTAMP,
    `expirationDate` timestamp,
    `providerId`     bigint(19),
    `code`           varchar(255),
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  AUTO_INCREMENT = 1
  DEFAULT CHARSET = utf8;

CREATE TABLE `dish`
(
    `id`   bigint(19) unsigned NOT NULL AUTO_INCREMENT,
    `name` varchar(255),
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  AUTO_INCREMENT = 1
  DEFAULT CHARSET = utf8;

CREATE TABLE `dish_product`
(
    `id`      bigint(19) unsigned NOT NULL AUTO_INCREMENT,
    `article` varchar(255),
    `quantity` bigint(19),
    `dish_id` bigint(19),
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  AUTO_INCREMENT = 1
  DEFAULT CHARSET = utf8;




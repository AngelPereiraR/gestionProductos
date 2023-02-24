-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1:3306
-- Tiempo de generación: 24-02-2023 a las 13:41:59
-- Versión del servidor: 10.4.24-MariaDB
-- Versión de PHP: 7.4.29

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `gestionproductos`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `category`
--

CREATE TABLE `category` (
  `id` bigint(20) NOT NULL,
  `description` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `category`
--

INSERT INTO `category` (`id`, `description`, `name`) VALUES
(6, 'Estos son muebles 2a opcion.', 'Muebles'),
(2, 'Esto es comida', 'Comida');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `category_seq`
--

CREATE TABLE `category_seq` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `category_seq`
--

INSERT INTO `category_seq` (`next_val`) VALUES
(201);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `favorite`
--

CREATE TABLE `favorite` (
  `id` bigint(20) NOT NULL,
  `product_id` bigint(20) DEFAULT NULL,
  `user_id` bigint(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `favorite_seq`
--

CREATE TABLE `favorite_seq` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `favorite_seq`
--

INSERT INTO `favorite_seq` (`next_val`) VALUES
(101);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `product`
--

CREATE TABLE `product` (
  `id` bigint(20) NOT NULL,
  `description` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `price` double NOT NULL,
  `category_id` bigint(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `product`
--

INSERT INTO `product` (`id`, `description`, `name`, `price`, `category_id`) VALUES
(58, 'Esto es una silla', 'Silla', 15, 6),
(59, 'Esto es una mesa', 'Mesa', 15, 6),
(153, 'Es una pera', 'Pera', 2, 2);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `product_seq`
--

CREATE TABLE `product_seq` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `product_seq`
--

INSERT INTO `product_seq` (`next_val`) VALUES
(251);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `user`
--

CREATE TABLE `user` (
  `id` bigint(20) NOT NULL,
  `enabled` bit(1) NOT NULL,
  `password` varchar(255) NOT NULL,
  `role` varchar(255) DEFAULT NULL,
  `token` varchar(255) DEFAULT NULL,
  `username` varchar(255) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `user`
--

INSERT INTO `user` (`id`, `enabled`, `password`, `role`, `token`, `username`) VALUES
(1, b'1', '$2a$10$HHxWu321yLtNCupN8gp5..PcUu1ewlcq8l31NhWeBPamMsosvXLdm', 'ROLE_USER', NULL, 'Ángel'),
(2, b'1', '$2a$10$WHGhqZ9ty3fGX08MpHgG3.Y8T3p1AmnE6W7oPZ7ZE64vSbQdBjimy', 'ROLE_ADMIN', NULL, 'Admin'),
(3, b'1', '$2a$10$4apfMojVQG6yBHsQLhcpjuR.BIjz69S/CquUiGOHCC2fXJY51b2Fy', 'ROLE_USER', NULL, 'Manuel');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `user_seq`
--

CREATE TABLE `user_seq` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `user_seq`
--

INSERT INTO `user_seq` (`next_val`) VALUES
(151);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `category`
--
ALTER TABLE `category`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `favorite`
--
ALTER TABLE `favorite`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKbg4txsew6x3gl6r9swcq190hg` (`product_id`),
  ADD KEY `FKh3f2dg11ibnht4fvnmx60jcif` (`user_id`);

--
-- Indices de la tabla `product`
--
ALTER TABLE `product`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK1mtsbur82frn64de7balymq9s` (`category_id`);

--
-- Indices de la tabla `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `UK_sb8bbouer5wak8vyiiy4pf2bx` (`username`) USING HASH;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

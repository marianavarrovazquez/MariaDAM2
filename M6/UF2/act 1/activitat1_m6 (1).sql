-- phpMyAdmin SQL Dump
-- version 5.0.3
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 21-12-2020 a las 23:42:56
-- Versión del servidor: 10.4.14-MariaDB
-- Versión de PHP: 7.4.11

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `activitat1_m6`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `alumnes`
--

CREATE TABLE `alumnes` (
  `nom` varchar(100) NOT NULL,
  `dni` varchar(15) NOT NULL,
  `dataDeNaixement` date NOT NULL,
  `adrecaPostal` varchar(100) NOT NULL,
  `sexe` char(1) NOT NULL,
  `codiPostal` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `població`
--

CREATE TABLE `població` (
  `codiPostal` int(11) NOT NULL,
  `poblacio` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `alumnes`
--
ALTER TABLE `alumnes`
  ADD PRIMARY KEY (`dni`),
  ADD KEY `codiPostal` (`codiPostal`);

--
-- Indices de la tabla `població`
--
ALTER TABLE `població`
  ADD PRIMARY KEY (`codiPostal`),
  ADD KEY `codiPostal` (`codiPostal`);

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `alumnes`
--
ALTER TABLE `alumnes`
  ADD CONSTRAINT `alumnes_ibfk_1` FOREIGN KEY (`codiPostal`) REFERENCES `població` (`codiPostal`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 03-03-2022 a las 03:50:14
-- Versión del servidor: 10.4.22-MariaDB
-- Versión de PHP: 7.3.33

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `blood4life`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `assignments`
--

CREATE TABLE `assignments` (
  `id_assis` int(10) UNSIGNED NOT NULL,
  `lugar_id` int(11) NOT NULL,
  `entidad_id` int(11) NOT NULL,
  `fecha` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cita`
--

CREATE TABLE `cita` (
  `cod_id` int(11) NOT NULL,
  `lugar_id` int(11) NOT NULL,
  `fecha` date NOT NULL,
  `hora` time NOT NULL,
  `cupos` int(11) NOT NULL DEFAULT 0
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `cita`
--

INSERT INTO `cita` (`cod_id`, `lugar_id`, `fecha`, `hora`, `cupos`) VALUES
(100, 1, '2022-02-02', '08:00:00', 4),
(101, 2, '2022-02-03', '13:00:00', 5),
(123, 1, '2022-02-09', '15:00:00', 3),
(13455, 2, '2022-02-10', '10:00:00', 5),
(45678, 1, '2022-02-08', '16:13:17', 0),
(134553, 1, '2022-02-16', '17:00:00', 4),
(1234554, 1, '2022-02-11', '09:10:36', 1),
(12345679, 1, '2022-02-15', '07:00:00', 3);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `citasasignadas`
--

CREATE TABLE `citasasignadas` (
  `user_id` int(11) NOT NULL,
  `cod_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `citasasignadas`
--

INSERT INTO `citasasignadas` (`user_id`, `cod_id`) VALUES
(10, 100),
(20, 101);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `entidad`
--

CREATE TABLE `entidad` (
  `entidad_id` int(11) NOT NULL,
  `nombre` text NOT NULL,
  `direccion` text NOT NULL,
  `telefono` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `lugarrecogida`
--

CREATE TABLE `lugarrecogida` (
  `lugar_id` int(11) NOT NULL,
  `direccion` text NOT NULL,
  `nombre` text DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `lugarrecogida`
--

INSERT INTO `lugarrecogida` (`lugar_id`, `direccion`, `nombre`) VALUES
(1, 'CR 78#25-78', 'Hospital San jose'),
(2, 'CR 78#25-54', 'Estancia');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `sangre`
--

CREATE TABLE `sangre` (
  `sangre_id` int(11) NOT NULL,
  `tipo` text NOT NULL,
  `RH` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `sangre`
--

INSERT INTO `sangre` (`sangre_id`, `tipo`, `RH`) VALUES
(1, 'AB', '+'),
(2, 'A', '+'),
(3, 'B', '-');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `useraccess`
--

CREATE TABLE `useraccess` (
  `user` int(11) NOT NULL,
  `password` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `useraccess`
--

INSERT INTO `useraccess` (`user`, `password`) VALUES
(10, 'pw1'),
(20, 'pw2');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuariocliente`
--

CREATE TABLE `usuariocliente` (
  `user_id` int(11) NOT NULL,
  `nombre` text NOT NULL,
  `apellido` text NOT NULL,
  `mail` text NOT NULL,
  `telefono` text NOT NULL,
  `sangre_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `usuariocliente`
--

INSERT INTO `usuariocliente` (`user_id`, `nombre`, `apellido`, `mail`, `telefono`, `sangre_id`) VALUES
(10, 'Sujeto1', 'Prueba1', 'sujPru1@correo.com', '3133133133', 2),
(20, 'Sujeto2', 'Prueba2', 'sujPru2@correo.com', '3123123122', 2),
(10029563, 'Paco', 'Jimenez', 'paco@gmail.com', '32402167497', 1),
(10029564, 'Paco', 'Merte', 'paquito123@mail.com', '3228871674', 3),
(12345678, 'Maria', 'Gomez', 'gomemza@mail.com', '324587998', 2),
(12345679, 'Carla', 'Popovich', 'carpo@mail.com', '3245879979', 3),
(1002805624, 'Lola', 'Mento', 'lolita@mail.com', '3105089540', 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuariofuncionario`
--

CREATE TABLE `usuariofuncionario` (
  `user_id` int(11) NOT NULL,
  `nombre` text NOT NULL,
  `apellido` text NOT NULL,
  `mail` varchar(50) NOT NULL,
  `telefono` text NOT NULL,
  `organizacion` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `assignments`
--
ALTER TABLE `assignments`
  ADD PRIMARY KEY (`id_assis`),
  ADD KEY `fk_entidad_id_2` (`entidad_id`),
  ADD KEY `fk_lugar_id_2` (`lugar_id`);

--
-- Indices de la tabla `cita`
--
ALTER TABLE `cita`
  ADD PRIMARY KEY (`cod_id`),
  ADD KEY `fk_lugar_id` (`lugar_id`);

--
-- Indices de la tabla `citasasignadas`
--
ALTER TABLE `citasasignadas`
  ADD KEY `fk_usuariocliente_id` (`user_id`),
  ADD KEY `fk_cita_id_2` (`cod_id`);

--
-- Indices de la tabla `entidad`
--
ALTER TABLE `entidad`
  ADD PRIMARY KEY (`entidad_id`);

--
-- Indices de la tabla `lugarrecogida`
--
ALTER TABLE `lugarrecogida`
  ADD PRIMARY KEY (`lugar_id`);

--
-- Indices de la tabla `sangre`
--
ALTER TABLE `sangre`
  ADD PRIMARY KEY (`sangre_id`);

--
-- Indices de la tabla `useraccess`
--
ALTER TABLE `useraccess`
  ADD PRIMARY KEY (`user`);

--
-- Indices de la tabla `usuariocliente`
--
ALTER TABLE `usuariocliente`
  ADD PRIMARY KEY (`user_id`),
  ADD KEY `fk_sangre_id_3` (`sangre_id`);

--
-- Indices de la tabla `usuariofuncionario`
--
ALTER TABLE `usuariofuncionario`
  ADD PRIMARY KEY (`user_id`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `assignments`
--
ALTER TABLE `assignments`
  MODIFY `id_assis` int(10) UNSIGNED NOT NULL AUTO_INCREMENT;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `assignments`
--
ALTER TABLE `assignments`
  ADD CONSTRAINT `fk_entidad_id_2` FOREIGN KEY (`entidad_id`) REFERENCES `entidad` (`entidad_id`) ON DELETE CASCADE,
  ADD CONSTRAINT `fk_lugar_id_2` FOREIGN KEY (`lugar_id`) REFERENCES `lugarrecogida` (`lugar_id`) ON DELETE CASCADE;

--
-- Filtros para la tabla `cita`
--
ALTER TABLE `cita`
  ADD CONSTRAINT `fk_lugar_id` FOREIGN KEY (`lugar_id`) REFERENCES `lugarrecogida` (`lugar_id`) ON DELETE CASCADE;

--
-- Filtros para la tabla `citasasignadas`
--
ALTER TABLE `citasasignadas`
  ADD CONSTRAINT `fk_cita_id_2` FOREIGN KEY (`cod_id`) REFERENCES `cita` (`cod_id`) ON DELETE CASCADE,
  ADD CONSTRAINT `fk_usuariocliente_id` FOREIGN KEY (`user_id`) REFERENCES `usuariocliente` (`user_id`) ON DELETE CASCADE;

--
-- Filtros para la tabla `usuariocliente`
--
ALTER TABLE `usuariocliente`
  ADD CONSTRAINT `fk_sangre_id_3` FOREIGN KEY (`sangre_id`) REFERENCES `sangre` (`sangre_id`) ON DELETE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

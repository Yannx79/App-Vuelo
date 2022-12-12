-- phpMyAdmin SQL Dump
-- version 5.3.0-dev+20221117.561d9ca705
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 12-12-2022 a las 19:49:58
-- Versión del servidor: 10.4.24-MariaDB
-- Versión de PHP: 8.1.5

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `app_viaje`
--
CREATE DATABASE IF NOT EXISTS `app_viaje` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;
USE `app_viaje`;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `actividades`
--

CREATE TABLE `actividades` (
  `id_actividad` int(11) NOT NULL,
  `nombre_actividad` varchar(100) NOT NULL,
  `descripcion` varchar(400) NOT NULL COMMENT 'Descripcion de la actividad',
  `id_categoria` int(11) NOT NULL COMMENT 'Parque, museo o show',
  `costo_actividad` double NOT NULL,
  `portada_principal` int(11) DEFAULT NULL,
  `portada_secundaria` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `actividades`
--

INSERT INTO `actividades` (`id_actividad`, `nombre_actividad`, `descripcion`, `id_categoria`, `costo_actividad`, `portada_principal`, `portada_secundaria`) VALUES
(1, 'Parque del Avion', 'What is Lorem Ipsum?\nLorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry\'s standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popu', 1, 120, 74, 77),
(2, 'Museo general de la guerra', 'What is Lorem Ipsum?\nLorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry\'s standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popu', 2, 520, 78, 73),
(3, 'Futbol Deportivo Particular - Central', 'Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry\'s standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s w', 3, 300, 77, 75),
(4, 'Museo General Global', 'Museo de los principales autores del mundo', 2, 1200, 76, 78),
(5, 'Voley InterGrupal Premiun', 'Juego deportivos para los turistas ', 3, 500, 77, 78),
(6, 'Natacion Gold', 'Para las familias y sus hijos', 3, 125.5, 77, 76),
(7, 'Militar', 'Paquete tematico militar', 1, 130, 77, 77);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `alojamientos`
--

CREATE TABLE `alojamientos` (
  `id_alojamiento` int(11) NOT NULL,
  `costo_alojamiento` double NOT NULL,
  `numero_personas` int(11) NOT NULL,
  `numero_habitaciones` int(11) NOT NULL,
  `id_hotel` int(11) NOT NULL COMMENT 'Id del hotel',
  `portada_principal` int(11) DEFAULT NULL,
  `portada_secundaria` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `alojamientos`
--

INSERT INTO `alojamientos` (`id_alojamiento`, `costo_alojamiento`, `numero_personas`, `numero_habitaciones`, `id_hotel`, `portada_principal`, `portada_secundaria`) VALUES
(1, 1200, 4, 4, 1, 61, 65),
(2, 1600, 5, 5, 2, 66, 62),
(3, 1200, 2, 2, 2, 65, 62),
(5, 1500, 10, 10, 2, 64, 66),
(6, 2500, 20, 10, 2, 65, 66);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `aviones`
--

CREATE TABLE `aviones` (
  `id_avion` int(11) NOT NULL,
  `nombre_avion` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `aviones`
--

INSERT INTO `aviones` (`id_avion`, `nombre_avion`) VALUES
(1, 'Boeing 747: \'La reina de los cielos\''),
(2, 'Boeing 737-200: \'Tinmouse\''),
(3, 'Boeing 777: \'T7\''),
(4, 'MD-80: \'Maddog\''),
(5, 'Antonov An-124');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `categoria`
--

CREATE TABLE `categoria` (
  `id_categoria` int(11) NOT NULL,
  `tipo_categoria` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `categoria`
--

INSERT INTO `categoria` (`id_categoria`, `tipo_categoria`) VALUES
(4, 'Cine'),
(2, 'Museo'),
(1, 'Parque'),
(3, 'Show');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `hoteles`
--

CREATE TABLE `hoteles` (
  `id_hotel` int(11) NOT NULL,
  `nombre_hotel` varchar(50) NOT NULL,
  `cantidad_estrellas` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `hoteles`
--

INSERT INTO `hoteles` (`id_hotel`, `nombre_hotel`, `cantidad_estrellas`) VALUES
(1, 'Hotel Palace', 5),
(2, 'Hotel Qorianka', 4),
(3, 'Hotel Vip Premiun', 3),
(4, 'Hotel El Cielo', 2),
(5, 'Hotel El Mar Claro', 5);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `mis_paquetes`
--

CREATE TABLE `mis_paquetes` (
  `id_mis_paquetes` int(11) NOT NULL,
  `id_alojamiento` int(11) DEFAULT NULL,
  `id_vuelo` int(11) DEFAULT NULL,
  `id_origen` int(11) NOT NULL,
  `id_destino` int(11) NOT NULL,
  `fecha_salida` date NOT NULL,
  `fecha_regreso` date NOT NULL,
  `id_actividad` int(11) DEFAULT NULL,
  `portada_principal` int(11) DEFAULT NULL,
  `portada_secundaria` int(11) DEFAULT NULL,
  `id_usuario` int(11) NOT NULL,
  `nombre_paquete` varchar(50) DEFAULT 'SIN NOMBRE'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `mis_paquetes`
--

INSERT INTO `mis_paquetes` (`id_mis_paquetes`, `id_alojamiento`, `id_vuelo`, `id_origen`, `id_destino`, `fecha_salida`, `fecha_regreso`, `id_actividad`, `portada_principal`, `portada_secundaria`, `id_usuario`, `nombre_paquete`) VALUES
(1, 3, 5, 4, 4, '2022-12-01', '2022-12-30', 2, 54, 59, 1, 'Paquete Individual'),
(8, 1, 10, 5, 6, '2022-12-26', '2023-01-01', 3, 42, 46, 1, 'Paquete Hermanos'),
(14, 1, 2, 5, 6, '2022-11-04', '2022-11-30', 2, 57, 42, 1, 'Paquete Verano Familiar'),
(15, 5, 11, 1, 3, '2022-12-26', '2022-12-26', 4, 48, 45, 1, 'PAQUETE POO'),
(16, 3, 11, 4, 2, '2022-11-01', '2022-11-30', 1, 41, 47, 1, 'Paquete Premium Invierno'),
(17, 6, 2, 4, 2, '2022-11-01', '2022-11-30', 1, 41, 47, 1, 'Paquete Premium Invierno'),
(20, 3, 3, 4, 2, '2022-11-01', '2022-11-30', 1, 41, 47, 2, 'Paquete Premium Invierno'),
(21, 1, 2, 4, 4, '2022-12-01', '2022-12-30', 3, 54, 59, 2, 'Paquete Recuerdos de Oro'),
(22, 2, NULL, 4, 5, '2019-12-30', '2023-01-01', NULL, 47, 46, 2, 'Expo Domingo'),
(23, 5, 11, 3, 2, '2021-12-27', '2023-01-01', NULL, 48, 47, 2, 'Paquete Ganado');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `paises`
--

CREATE TABLE `paises` (
  `id_pais` int(11) NOT NULL,
  `nombre_pais` varchar(50) NOT NULL COMMENT 'Pais de partida y para llegar'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `paises`
--

INSERT INTO `paises` (`id_pais`, `nombre_pais`) VALUES
(1, 'Brasil'),
(2, 'Colombia'),
(3, 'Peru'),
(4, 'Argentina'),
(5, 'Chile'),
(6, 'Venezuela');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `paquetes`
--

CREATE TABLE `paquetes` (
  `id_paquete` int(11) NOT NULL,
  `id_alojamiento` int(11) NOT NULL,
  `id_vuelo` int(11) NOT NULL,
  `id_origen` int(11) NOT NULL COMMENT 'Origen de viaje',
  `id_destino` int(11) NOT NULL COMMENT 'Destino final del viaje',
  `fecha_salida` date NOT NULL,
  `fecha_regreso` date NOT NULL,
  `id_actividad` int(11) NOT NULL COMMENT 'Id de la actividad',
  `portada_principal` int(11) DEFAULT NULL COMMENT 'Portada principal del paquete',
  `portada_secundaria` int(11) DEFAULT NULL COMMENT 'Portada secundaria del paquete',
  `nombre_paquete` varchar(100) DEFAULT 'SIN NOMBRE'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `paquetes`
--

INSERT INTO `paquetes` (`id_paquete`, `id_alojamiento`, `id_vuelo`, `id_origen`, `id_destino`, `fecha_salida`, `fecha_regreso`, `id_actividad`, `portada_principal`, `portada_secundaria`, `nombre_paquete`) VALUES
(1, 2, 5, 1, 1, '2026-12-28', '2015-12-28', 4, 41, 41, 'Paquete Premium Invierno'),
(2, 3, 7, 1, 1, '2022-12-26', '2022-12-26', 4, 41, 41, 'Paquete Verano Familiar'),
(4, 2, 3, 1, 1, '2022-12-26', '2022-12-26', 2, 41, 41, 'Paquete Recuerdos de Oro'),
(5, 3, 3, 1, 1, '2021-12-27', '2022-12-26', 3, 41, 41, 'Paquete Maravilla'),
(6, 6, 5, 1, 4, '2019-12-30', '2024-12-31', 4, 44, 48, 'Paquete General Optimizado'),
(7, 3, 3, 1, 1, '2022-12-26', '2022-12-26', 2, 41, 41, 'Paquete Centro'),
(8, 5, 3, 5, 3, '2022-12-26', '2022-12-26', 4, 47, 42, 'Paquete Sur'),
(9, 5, 7, 1, 1, '2019-12-30', '2019-12-30', 3, 41, 41, 'Paquete Norte'),
(10, 1, 3, 1, 4, '2021-12-27', '2024-12-31', 4, 46, 43, 'Solar'),
(11, 5, 2, 2, 6, '2019-12-30', '2026-12-28', 4, 46, 59, 'Lunar Verano'),
(14, 5, 3, 5, 1, '2018-12-31', '2022-12-26', 3, 47, 45, 'Escolar');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `portadas`
--

CREATE TABLE `portadas` (
  `id_portada` int(11) NOT NULL,
  `path` varchar(100) NOT NULL,
  `id_tipo_portada` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `portadas`
--

INSERT INTO `portadas` (`id_portada`, `path`, `id_tipo_portada`) VALUES
(41, 'paquete1.jpg', 1),
(42, 'paquete2.jpg', 1),
(43, 'paquete3.jpg', 1),
(44, 'paquete4.jpg', 1),
(45, 'paquete5.jpg', 1),
(46, 'paquete6.jpg', 1),
(47, 'paquete7.jpg', 1),
(48, 'paquete8.jpg', 1),
(49, 'paquete9.jpg', 1),
(50, 'paquete10.jpg', 1),
(51, 'paquete11.jpg', 1),
(52, 'paquete12.jpg', 1),
(53, 'paquete13.jpg', 1),
(54, 'paquete14.jpg', 1),
(55, 'paquete15.jpg', 1),
(56, 'paquete16.jpg', 1),
(57, 'paquete17.jpg', 1),
(58, 'paquete18.jpg', 1),
(59, 'paquete19.jpg', 1),
(60, 'paquete20.jpg', 1),
(61, 'alojamiento1.jpg', 2),
(62, 'alojamiento2.jpg', 2),
(63, 'alojamiento3.jpg', 2),
(64, 'alojamiento4.jpg', 2),
(65, 'alojamiento5.jpg', 2),
(66, 'alojamiento6.jpg', 2),
(67, 'vuelo1.jpg', 3),
(68, 'vuelo2.jpg', 3),
(69, 'vuelo3.jpg', 3),
(70, 'vuelo4.jpg', 3),
(71, 'vuelo5.jpg', 3),
(72, 'vuelo6.jpg', 3),
(73, 'actividad1.jpg', 4),
(74, 'actividad2.jpg', 4),
(75, 'actividad3.jpg', 4),
(76, 'actividad4.jpg', 4),
(77, 'actividad5.jpg', 4),
(78, 'actividad6.jpg', 4);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tipo_portadas`
--

CREATE TABLE `tipo_portadas` (
  `id_tipo_portada` int(11) NOT NULL,
  `tipo` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `tipo_portadas`
--

INSERT INTO `tipo_portadas` (`id_tipo_portada`, `tipo`) VALUES
(1, 'Paquete'),
(2, 'Alojamiento'),
(3, 'Vuelo'),
(4, 'Actividad');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuarios`
--

CREATE TABLE `usuarios` (
  `id_usuario` int(11) NOT NULL,
  `Nombres` varchar(100) DEFAULT NULL COMMENT 'Primer y segundo nombre',
  `apellido_paterno` varchar(100) DEFAULT NULL COMMENT 'Apellido paterno',
  `apellido_materno` varchar(100) DEFAULT NULL COMMENT 'Apellido materno',
  `email` varchar(100) NOT NULL COMMENT 'Correo',
  `password` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `usuarios`
--

INSERT INTO `usuarios` (`id_usuario`, `Nombres`, `apellido_paterno`, `apellido_materno`, `email`, `password`) VALUES
(1, 'admin', 'paterno admin', 'materno admin', 'admin@gmail.com', '21232f297a57a5a743894a0e4a801fc3'),
(2, 'root', 'paterno root', 'materno root', 'root@gmail.com', '63a9f0ea7bb98050796b649e85481845');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuarios_paquetes`
--

CREATE TABLE `usuarios_paquetes` (
  `id_paquete` int(11) NOT NULL,
  `id_usuario` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `usuarios_paquetes`
--

INSERT INTO `usuarios_paquetes` (`id_paquete`, `id_usuario`) VALUES
(2, 1),
(1, 2);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `vuelos`
--

CREATE TABLE `vuelos` (
  `id_vuelo` int(11) NOT NULL,
  `numero_pasajeros` int(11) NOT NULL,
  `costo_vuelo` double NOT NULL,
  `id_avion` int(11) NOT NULL COMMENT 'Id del avion',
  `portada_principal` int(11) DEFAULT NULL,
  `portada_secundaria` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `vuelos`
--

INSERT INTO `vuelos` (`id_vuelo`, `numero_pasajeros`, `costo_vuelo`, `id_avion`, `portada_principal`, `portada_secundaria`) VALUES
(2, 7, 1700, 2, 67, 72),
(3, 6, 2500, 3, 68, 71),
(5, 4, 1700, 2, 69, 67),
(7, 3, 2200, 3, 70, 70),
(8, 5, 2700, 1, 71, 72),
(9, 7, 2400, 1, 72, 71),
(10, 5, 1600, 1, 69, 72),
(11, 7, 2000, 3, 71, 67);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `actividades`
--
ALTER TABLE `actividades`
  ADD PRIMARY KEY (`id_actividad`),
  ADD KEY `id_categoria` (`id_categoria`),
  ADD KEY `portada_principal` (`portada_principal`),
  ADD KEY `portada_secundaria` (`portada_secundaria`);

--
-- Indices de la tabla `alojamientos`
--
ALTER TABLE `alojamientos`
  ADD PRIMARY KEY (`id_alojamiento`),
  ADD KEY `id_hotel` (`id_hotel`),
  ADD KEY `portada_principal` (`portada_principal`),
  ADD KEY `portada_principal_2` (`portada_principal`),
  ADD KEY `portada_secundaria` (`portada_secundaria`);

--
-- Indices de la tabla `aviones`
--
ALTER TABLE `aviones`
  ADD PRIMARY KEY (`id_avion`);

--
-- Indices de la tabla `categoria`
--
ALTER TABLE `categoria`
  ADD PRIMARY KEY (`id_categoria`),
  ADD KEY `ix_categoria` (`tipo_categoria`);

--
-- Indices de la tabla `hoteles`
--
ALTER TABLE `hoteles`
  ADD PRIMARY KEY (`id_hotel`);

--
-- Indices de la tabla `mis_paquetes`
--
ALTER TABLE `mis_paquetes`
  ADD PRIMARY KEY (`id_mis_paquetes`),
  ADD KEY `id_alojamiento` (`id_alojamiento`),
  ADD KEY `id_vuelo` (`id_vuelo`),
  ADD KEY `id_origen` (`id_origen`),
  ADD KEY `id_destino` (`id_destino`),
  ADD KEY `id_actividad` (`id_actividad`),
  ADD KEY `id_usuario` (`id_usuario`),
  ADD KEY `portada_principal` (`portada_principal`),
  ADD KEY `portada_secundaria` (`portada_secundaria`);

--
-- Indices de la tabla `paises`
--
ALTER TABLE `paises`
  ADD PRIMARY KEY (`id_pais`);

--
-- Indices de la tabla `paquetes`
--
ALTER TABLE `paquetes`
  ADD PRIMARY KEY (`id_paquete`),
  ADD KEY `id_alojamiento` (`id_alojamiento`),
  ADD KEY `id_vuelo` (`id_vuelo`),
  ADD KEY `origen` (`id_origen`),
  ADD KEY `destino` (`id_destino`),
  ADD KEY `id_actividad` (`id_actividad`),
  ADD KEY `id_actividad_2` (`id_actividad`),
  ADD KEY `ix_pp` (`portada_principal`),
  ADD KEY `ix_ps` (`portada_secundaria`);

--
-- Indices de la tabla `portadas`
--
ALTER TABLE `portadas`
  ADD PRIMARY KEY (`id_portada`),
  ADD KEY `id_tipo_portada` (`id_tipo_portada`);

--
-- Indices de la tabla `tipo_portadas`
--
ALTER TABLE `tipo_portadas`
  ADD PRIMARY KEY (`id_tipo_portada`);

--
-- Indices de la tabla `usuarios`
--
ALTER TABLE `usuarios`
  ADD PRIMARY KEY (`id_usuario`);

--
-- Indices de la tabla `usuarios_paquetes`
--
ALTER TABLE `usuarios_paquetes`
  ADD KEY `ix_paquete` (`id_paquete`),
  ADD KEY `ix_usuario` (`id_usuario`);

--
-- Indices de la tabla `vuelos`
--
ALTER TABLE `vuelos`
  ADD PRIMARY KEY (`id_vuelo`),
  ADD KEY `id_avion` (`id_avion`),
  ADD KEY `portada_principal` (`portada_principal`),
  ADD KEY `portada_secundaria` (`portada_secundaria`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `actividades`
--
ALTER TABLE `actividades`
  MODIFY `id_actividad` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT de la tabla `alojamientos`
--
ALTER TABLE `alojamientos`
  MODIFY `id_alojamiento` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT de la tabla `aviones`
--
ALTER TABLE `aviones`
  MODIFY `id_avion` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT de la tabla `categoria`
--
ALTER TABLE `categoria`
  MODIFY `id_categoria` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT de la tabla `hoteles`
--
ALTER TABLE `hoteles`
  MODIFY `id_hotel` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT de la tabla `mis_paquetes`
--
ALTER TABLE `mis_paquetes`
  MODIFY `id_mis_paquetes` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=24;

--
-- AUTO_INCREMENT de la tabla `paises`
--
ALTER TABLE `paises`
  MODIFY `id_pais` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT de la tabla `paquetes`
--
ALTER TABLE `paquetes`
  MODIFY `id_paquete` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=15;

--
-- AUTO_INCREMENT de la tabla `portadas`
--
ALTER TABLE `portadas`
  MODIFY `id_portada` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=79;

--
-- AUTO_INCREMENT de la tabla `tipo_portadas`
--
ALTER TABLE `tipo_portadas`
  MODIFY `id_tipo_portada` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT de la tabla `usuarios`
--
ALTER TABLE `usuarios`
  MODIFY `id_usuario` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT de la tabla `vuelos`
--
ALTER TABLE `vuelos`
  MODIFY `id_vuelo` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `actividades`
--
ALTER TABLE `actividades`
  ADD CONSTRAINT `actividades_ibfk_1` FOREIGN KEY (`id_categoria`) REFERENCES `categoria` (`id_categoria`),
  ADD CONSTRAINT `actividades_ibfk_2` FOREIGN KEY (`portada_principal`) REFERENCES `portadas` (`id_portada`),
  ADD CONSTRAINT `actividades_ibfk_3` FOREIGN KEY (`portada_secundaria`) REFERENCES `portadas` (`id_portada`);

--
-- Filtros para la tabla `alojamientos`
--
ALTER TABLE `alojamientos`
  ADD CONSTRAINT `alojamientos_ibfk_1` FOREIGN KEY (`id_hotel`) REFERENCES `hoteles` (`id_hotel`),
  ADD CONSTRAINT `alojamientos_ibfk_2` FOREIGN KEY (`portada_principal`) REFERENCES `portadas` (`id_portada`),
  ADD CONSTRAINT `alojamientos_ibfk_3` FOREIGN KEY (`portada_secundaria`) REFERENCES `portadas` (`id_portada`);

--
-- Filtros para la tabla `mis_paquetes`
--
ALTER TABLE `mis_paquetes`
  ADD CONSTRAINT `mis_paquetes_ibfk_1` FOREIGN KEY (`id_actividad`) REFERENCES `actividades` (`id_actividad`),
  ADD CONSTRAINT `mis_paquetes_ibfk_2` FOREIGN KEY (`id_alojamiento`) REFERENCES `alojamientos` (`id_alojamiento`),
  ADD CONSTRAINT `mis_paquetes_ibfk_3` FOREIGN KEY (`id_vuelo`) REFERENCES `vuelos` (`id_vuelo`),
  ADD CONSTRAINT `mis_paquetes_ibfk_4` FOREIGN KEY (`id_origen`) REFERENCES `paises` (`id_pais`),
  ADD CONSTRAINT `mis_paquetes_ibfk_5` FOREIGN KEY (`id_destino`) REFERENCES `paises` (`id_pais`),
  ADD CONSTRAINT `mis_paquetes_ibfk_6` FOREIGN KEY (`id_usuario`) REFERENCES `usuarios` (`id_usuario`),
  ADD CONSTRAINT `mis_paquetes_ibfk_7` FOREIGN KEY (`portada_principal`) REFERENCES `portadas` (`id_portada`),
  ADD CONSTRAINT `mis_paquetes_ibfk_8` FOREIGN KEY (`portada_secundaria`) REFERENCES `portadas` (`id_portada`);

--
-- Filtros para la tabla `paquetes`
--
ALTER TABLE `paquetes`
  ADD CONSTRAINT `paquetes_ibfk_2` FOREIGN KEY (`id_alojamiento`) REFERENCES `alojamientos` (`id_alojamiento`),
  ADD CONSTRAINT `paquetes_ibfk_3` FOREIGN KEY (`id_vuelo`) REFERENCES `vuelos` (`id_vuelo`),
  ADD CONSTRAINT `paquetes_ibfk_4` FOREIGN KEY (`id_origen`) REFERENCES `paises` (`id_pais`),
  ADD CONSTRAINT `paquetes_ibfk_5` FOREIGN KEY (`id_destino`) REFERENCES `paises` (`id_pais`),
  ADD CONSTRAINT `paquetes_ibfk_6` FOREIGN KEY (`id_actividad`) REFERENCES `actividades` (`id_actividad`),
  ADD CONSTRAINT `paquetes_ibfk_7` FOREIGN KEY (`portada_principal`) REFERENCES `portadas` (`id_portada`),
  ADD CONSTRAINT `paquetes_ibfk_8` FOREIGN KEY (`portada_secundaria`) REFERENCES `portadas` (`id_portada`);

--
-- Filtros para la tabla `portadas`
--
ALTER TABLE `portadas`
  ADD CONSTRAINT `portadas_ibfk_1` FOREIGN KEY (`id_tipo_portada`) REFERENCES `tipo_portadas` (`id_tipo_portada`);

--
-- Filtros para la tabla `usuarios_paquetes`
--
ALTER TABLE `usuarios_paquetes`
  ADD CONSTRAINT `usuarios_paquetes_ibfk_1` FOREIGN KEY (`id_usuario`) REFERENCES `usuarios` (`id_usuario`),
  ADD CONSTRAINT `usuarios_paquetes_ibfk_2` FOREIGN KEY (`id_paquete`) REFERENCES `paquetes` (`id_paquete`);

--
-- Filtros para la tabla `vuelos`
--
ALTER TABLE `vuelos`
  ADD CONSTRAINT `vuelos_ibfk_1` FOREIGN KEY (`id_avion`) REFERENCES `aviones` (`id_avion`),
  ADD CONSTRAINT `vuelos_ibfk_2` FOREIGN KEY (`portada_principal`) REFERENCES `portadas` (`id_portada`),
  ADD CONSTRAINT `vuelos_ibfk_3` FOREIGN KEY (`portada_secundaria`) REFERENCES `portadas` (`id_portada`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

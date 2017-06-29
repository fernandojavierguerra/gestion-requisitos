-- Dumping data for table `gestion_requisito`

INSERT INTO `gestion_requisito` (`id`, `nombre`) VALUES (1,'Sistema Requisitos 2017');


--
-- Dumping data for table `proyecto`
--

/*!40000 ALTER TABLE `proyecto` DISABLE KEYS */;
INSERT INTO `proyecto` (`id`, `descripcion_proyecto`, `nombre_proyecto`, `version`, `aplicacion_id`) VALUES (1,'Cambio de version de BBDD','Proyecto 1', 0,1);
INSERT INTO `proyecto` (`id`, `descripcion_proyecto`, `nombre_proyecto`, `version`, `aplicacion_id`) VALUES (2,'Proyecto Semaforos','Proyecto 2', 0,1);
INSERT INTO `proyecto` (`id`, `descripcion_proyecto`, `nombre_proyecto`, `version`, `aplicacion_id`) VALUES (3,'Sistema Contable','Proyecto 3', 0,1);
INSERT INTO `proyecto` (`id`, `descripcion_proyecto`, `nombre_proyecto`, `version`, `aplicacion_id`) VALUES (4,'Cambio de version de BBDD','Proyecto 4', 0,1);



--
-- Dumping data for table `estado_requisito`
--
/*!40000 ALTER TABLE `estado_requisito` DISABLE KEYS */;
INSERT INTO `estado_requisito` (`id`, `descripcion_estado`) VALUES (1,'Cerrado');
INSERT INTO `estado_requisito` (`id`, `descripcion_estado`) VALUES (2,'Resuelto');
INSERT INTO `estado_requisito` (`id`, `descripcion_estado`) VALUES (3,'Reabierto');
INSERT INTO `estado_requisito` (`id`, `descripcion_estado`) VALUES (4,'EnProgreso');
INSERT INTO `estado_requisito` (`id`, `descripcion_estado`) VALUES (5,'Abierto');

--
-- Dumping data for table `requisito`
--

/*!40000 ALTER TABLE `requisito` DISABLE KEYS */;
INSERT INTO `requisito` (`id`, `necesidad`, `nombre`, `prioridad`, `riesgo`, `version`, `estado_id`, `proyecto_id`) VALUES (1,'Vehiculos','Alquiler','Baja','Ninguna',0,5,1);
INSERT INTO `requisito` (`id`, `necesidad`, `nombre`, `prioridad`, `riesgo`, `version`, `estado_id`, `proyecto_id`) VALUES (2,'Exponer','Armado de Estantes','Baja','Ninguno',0,5,1);
INSERT INTO `requisito` (`id`, `necesidad`, `nombre`, `prioridad`, `riesgo`, `version`, `estado_id`, `proyecto_id`) VALUES (3,'Reducción de costos Licencia','Migración Linux','Media','Multas',0,5,2);
INSERT INTO `requisito` (`id`, `necesidad`, `nombre`, `prioridad`, `riesgo`, `version`, `estado_id`, `proyecto_id`) VALUES (4,'Contruccion de Obrador','Compra Materiales','Alta','Clima Frio',0,5,3);
INSERT INTO `requisito` (`id`, `necesidad`, `nombre`, `prioridad`, `riesgo`, `version`, `estado_id`, `proyecto_id`) VALUES (5,'Contrata','Fase de Desarro','Baja','Ninguno',0,5,3);
INSERT INTO `requisito` (`id`, `necesidad`, `nombre`, `prioridad`, `riesgo`, `version`, `estado_id`, `proyecto_id`) VALUES (6,'Pagos','FirmaContrato','Baja','Ninguno',0,5,3);


--
-- Dumping data for table `requisito_abierto`
--
INSERT INTO `requisito_abierto` (`id`) VALUES (5);


--
-- Dumping data for table `requisito_cerrado`
--
INSERT INTO `requisito_cerrado` (`id`) VALUES (1);


--
-- Dumping data for table `requisito_compuesto`
--
INSERT INTO `requisito_compuesto` (`id`) VALUES (5);


--
-- Dumping data for table `requisito_compuesto_requisitos`
--
INSERT INTO `requisito_compuesto_requisitos` (`requisito_compuesto_id`, `requisitos_id`) VALUES (5,6);


--
-- Dumping data for table `requisito_en_progreso`
--
INSERT INTO `requisito_en_progreso` (`id`) VALUES (4);


--
-- Dumping data for table `requisito_reabierto`
--
INSERT INTO `requisito_reabierto` (`id`) VALUES (3);


--
-- Dumping data for table `requisito_resuelto`
--
INSERT INTO `requisito_resuelto` (`id`) VALUES (2);


--
-- Dumping data for table `requisito_simple`
--
INSERT INTO `requisito_simple` (`id`) VALUES (1);
INSERT INTO `requisito_simple` (`id`) VALUES (2);
INSERT INTO `requisito_simple` (`id`) VALUES (3);
INSERT INTO `requisito_simple` (`id`) VALUES (4);
INSERT INTO `requisito_simple` (`id`) VALUES (6);

--
-- Dumping data for table `stakeholder`
--
INSERT INTO `requisitos`.`stakeholder` (`id`, `apellido`, `dni`, `nombre`, `rol`) VALUES (1, 'Gomez', '21455876', 'Luis', 'Programador');
INSERT INTO `requisitos`.`stakeholder` (`id`, `apellido`, `dni`, `nombre`, `rol`) VALUES (2, 'Perez', '29123956', 'Carlos', 'Analista');



--
-- Dumping data for table `requisito_stakeholder`
--







--
-- Dumping data for table `estado_requisito`
--

INSERT INTO estado_requisito (id, descripcion_estado) VALUES (1,'Cerrado');
INSERT INTO estado_requisito (id, descripcion_estado) VALUES (2,'Resuelto');
INSERT INTO estado_requisito (id, descripcion_estado) VALUES (3,'Reabierto');
INSERT INTO estado_requisito (id, descripcion_estado) VALUES (4,'EnProgreso');


/*!40000 ALTER TABLE gestion_requisito DISABLE KEYS */;
INSERT INTO gestion_requisito (id, nombre) VALUES (1,'Sistema Requisitos 2017');
/*!40000 ALTER TABLE gestion_requisito ENABLE KEYS */;

--
-- Dumping data for table `proyecto`
--

INSERT INTO proyecto (id, descripcion_proyecto, nombre_proyecto, aplicacion_id) VALUES (1,'Cambio de version de BBDD','Proyecto 1',NULL);
INSERT INTO proyecto (id, descripcion_proyecto, nombre_proyecto, aplicacion_id) VALUES (2,'Proyecto Semaforos','Proyecto 2',NULL);
INSERT INTO proyecto (id, descripcion_proyecto, nombre_proyecto, aplicacion_id) VALUES (3,'Sistema Contable','Proyecto 3',NULL);
INSERT INTO proyecto (id, descripcion_proyecto, nombre_proyecto, aplicacion_id) VALUES (4,'Cambio de version de BBDD','Proyecto 4',NULL);

--
-- Dumping data for table `proyecto_requisitos`
--

INSERT INTO proyecto_requisitos (proyecto_id, requisitos_id) VALUES (1,4);
INSERT INTO proyecto_requisitos (proyecto_id, requisitos_id) VALUES (1,5);
INSERT INTO proyecto_requisitos (proyecto_id, requisitos_id) VALUES (2,6);
INSERT INTO proyecto_requisitos (proyecto_id, requisitos_id) VALUES (2,7);
INSERT INTO proyecto_requisitos (proyecto_id, requisitos_id) VALUES (3,8);
INSERT INTO proyecto_requisitos (proyecto_id, requisitos_id) VALUES (3,9);
INSERT INTO proyecto_requisitos (proyecto_id, requisitos_id) VALUES (4,10);
INSERT INTO proyecto_requisitos (proyecto_id, requisitos_id) VALUES (4,11);
INSERT INTO proyecto_requisitos (proyecto_id, requisitos_id) VALUES (4,12);
INSERT INTO proyecto_requisitos (proyecto_id, requisitos_id) VALUES (4,13);
INSERT INTO proyecto_requisitos (proyecto_id, requisitos_id) VALUES (4,14);
INSERT INTO proyecto_requisitos (proyecto_id, requisitos_id) VALUES (4,15);
INSERT INTO proyecto_requisitos (proyecto_id, requisitos_id) VALUES (4,16);

--
-- Dumping data for table `requisito`
--

INSERT INTO requisito (id, necesidad, nombre, prioridad, riesgo, estado_id) VALUES (1,'Contruccion de Obrador','Compra Materiales','Alta','Clima Frio',NULL);
INSERT INTO requisito (id, necesidad, nombre, prioridad, riesgo, estado_id) VALUES (2,'Reducción de costos Licencia','Migración Linux','Media','Multas',NULL);
INSERT INTO requisito (id, necesidad, nombre, prioridad, riesgo, estado_id) VALUES (3,'Exponer','Armado de Estantes','Baja','Ninguno',NULL);
INSERT INTO requisito (id, necesidad, nombre, prioridad, riesgo, estado_id) VALUES (4,'Tensión Arterial','Req1Proy1','Media','Deshidratación',NULL);
INSERT INTO requisito (id, necesidad, nombre, prioridad, riesgo, estado_id) VALUES (5,'Cierre Automatico de Puertas','Req2Proy1','Alta','Suministro Electrico Interrumpido',NULL);
INSERT INTO requisito (id, necesidad, nombre, prioridad, riesgo, estado_id) VALUES (6,'Despachar Cajero Automatico','Req1Proy2','Media','Seguridad de Cierre',NULL);
INSERT INTO requisito (id, necesidad, nombre, prioridad, riesgo, estado_id) VALUES (7,'Desemcriptar Llave Bancaria','Req2Proy2','Alta','Sobrecarga Algoritmica',NULL);
INSERT INTO requisito (id, necesidad, nombre, prioridad, riesgo, estado_id) VALUES (8,'Mayor Productividad','Req1Proy3','Alta','Costo de Oportunidad',NULL);
INSERT INTO requisito (id, necesidad, nombre, prioridad, riesgo, estado_id) VALUES (9,'Menor tiempo de Respuesta','Req2Proy3','Media','Latencia ente request',NULL);
INSERT INTO requisito (id, necesidad, nombre, prioridad, riesgo, estado_id) VALUES (10,'Mantener Cartera Clientes','Req1','Alta','Costo de Oportunidad',NULL);
INSERT INTO requisito (id, necesidad, nombre, prioridad, riesgo, estado_id) VALUES (11,'Minimizar tiempo de respusta de atencion','Req2','Media','Fidelidad del Cliente',NULL);
INSERT INTO requisito (id, necesidad, nombre, prioridad, riesgo, estado_id) VALUES (12,'Movimientos de Expedientes','Req3','Baja','Costos de Papeleo',NULL);
INSERT INTO requisito (id, necesidad, nombre, prioridad, riesgo, estado_id) VALUES (13,'Provision de Medicamentos','Req4','Alta','Alta disponibilidad de entrega',NULL);
INSERT INTO requisito (id, necesidad, nombre, prioridad, riesgo, estado_id) VALUES (14,'Tensión Arterial','Req1Proy1','Media','Deshidratación',NULL);
INSERT INTO requisito (id, necesidad, nombre, prioridad, riesgo, estado_id) VALUES (15,'Cierre Automatico de Puertas','Req2Proy1','Alta','Suministro Electrico Interrumpido',NULL);
INSERT INTO requisito (id, necesidad, nombre, prioridad, riesgo, estado_id) VALUES (16,'Reducir tiempo de Desarrollo','ComReq1','Muy Alta','Comunicación Insuficiente',NULL);
INSERT INTO requisito (id, necesidad, nombre, prioridad, riesgo, estado_id) VALUES (17,'Reducir Tiempo de Entrega','ReqSimple1Compu1','Alta','Nueva Tecnologia',NULL);
INSERT INTO requisito (id, necesidad, nombre, prioridad, riesgo, estado_id) VALUES (18,'Reubicacion de Personal','ReqSimple2Compu1','Media','Profesionales Capacitados',NULL);
INSERT INTO requisito (id, necesidad, nombre, prioridad, riesgo, estado_id) VALUES (19,'Mayor Cartera de Clientes','ReqSimple3Compu1','Alta','Inversores de Corto plazo',NULL);

--
-- Dumping data for table `requisito_abierto`
--


--
-- Dumping data for table `requisito_cerrado`
--
INSERT INTO requisito_cerrado (id) VALUES (1);
--
-- Dumping data for table `requisito_compuesto`
--

INSERT INTO requisito_compuesto (id) VALUES (16);


--
-- Dumping data for table `requisito_compuesto_requisitos`
--

INSERT INTO requisito_compuesto_requisitos (requisito_compuesto_id, requisitos_id) VALUES (16,17);
INSERT INTO requisito_compuesto_requisitos (requisito_compuesto_id, requisitos_id) VALUES (16,18);
INSERT INTO requisito_compuesto_requisitos (requisito_compuesto_id, requisitos_id) VALUES (16,19);


--
-- Dumping data for table `requisito_en_progreso`
--


INSERT INTO requisito_en_progreso (id) VALUES (4);


--
-- Dumping data for table `requisito_reabierto`
--


INSERT INTO requisito_reabierto (id) VALUES (3);


--
-- Dumping data for table `requisito_resuelto`
--


INSERT INTO requisito_resuelto (id) VALUES (2);

--
-- Dumping data for table `requisito_simple`
--

INSERT INTO requisito_simple (id) VALUES (1);
INSERT INTO requisito_simple (id) VALUES (2);
INSERT INTO requisito_simple (id) VALUES (3);
INSERT INTO requisito_simple (id) VALUES (4);
INSERT INTO requisito_simple (id) VALUES (5);
INSERT INTO requisito_simple (id) VALUES (6);
INSERT INTO requisito_simple (id) VALUES (7);
INSERT INTO requisito_simple (id) VALUES (8);
INSERT INTO requisito_simple (id) VALUES (9);
INSERT INTO requisito_simple (id) VALUES (10);
INSERT INTO requisito_simple (id) VALUES (11);
INSERT INTO requisito_simple (id) VALUES (12);
INSERT INTO requisito_simple (id) VALUES (13);
INSERT INTO requisito_simple (id) VALUES (14);
INSERT INTO requisito_simple (id) VALUES (15);
INSERT INTO requisito_simple (id) VALUES (17);
INSERT INTO requisito_simple (id) VALUES (18);
INSERT INTO requisito_simple (id) VALUES (19);


--
-- Dumping data for table `stakeholder`
--


INSERT INTO stakeholder (id, apellido, dni, nombre, rol) VALUES (1,'Progarmador1','23456789','Martin','ProgramadorJunior');
INSERT INTO stakeholder (id, apellido, dni, nombre, rol) VALUES (2,'AnalistaSeñior1','23456789','Luis','Analista Principarl');


--
-- Dumping data for table `stakeholder_requisitos`
--


INSERT INTO stakeholder_requisitos (stakeholder_id, requisitos_id) VALUES (1,1);
INSERT INTO stakeholder_requisitos (stakeholder_id, requisitos_id) VALUES (1,2);
INSERT INTO stakeholder_requisitos (stakeholder_id, requisitos_id) VALUES (2,3);

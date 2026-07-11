-- creación de datos iniciales

INSERT INTO rol (nombre)
VALUES
('ADMIN'),
('EMPLEADA'),
('CLIENTE');

INSERT INTO especie (nombre)
VALUES
('Perro'),
('Gato'),
('Otro');

INSERT INTO estado_cita (nombre)
VALUES
('Pendiente'),
('Confirmada'),
('En proceso'),
('Completada'),
('Cancelada'),
('No presentada');

INSERT INTO servicio (nombre, descripcion, precio, duracion_estimada)
VALUES
('Baño', 'Baño completo con champú adecuado, secado y cepillado.', 18.00, 30),
('Corte', 'Corte de pelo adaptado a la raza o a las preferencias del propietario', 25.00, 45),
('Baño + Corte', 'Servicio completo que incluye baño, secado, cepillado y corte de pelo.', 38.00, 75),
('Corte de uñas', 'Recorte y revisión de las uñas para mantener una longitud adecuada.', 8.00, 15),
('Limpieza de oídos', 'Limpieza suave del canal auditivo con productos específicos para mascotas.', 6.00, 10),
('Deslanado', 'Eliminación del pelo muerto y del exceso de subpelo para mejorar el manto.', 20.00, 45);

INSERT INTO horario (dia_semana, hora_apertura, hora_cierre)
VALUES
('LUNES', '09:30', '17:00'),
('MARTES', '09:30', '17:00'),
('MIERCOLES', '09:30', '17:00'),
('JUEVES', '09:30', '17:00'),
('VIERNES', '09:30', '17:00');

INSERT INTO raza (id_especie, nombre)
VALUES
-- Perros
(1, 'Labrador Retriever'),
(1, 'Golden Retriever'),
(1, 'Pastor Alemán'),
(1, 'Border Collie'),
(1, 'Caniche'),
(1, 'Yorkshire Terrier'),
(1, 'Chihuahua'),
(1, 'Bulldog Francés'),
(1, 'Pomerania'),
(1, 'Bichón Maltés'),
(1, 'Cocker Spaniel'),
(1, 'Shih Tzu'),
(1, 'Teckel'),
(1, 'Husky Siberiano'),
(1, 'Mestizo'),

-- Gatos
(2, 'Europeo Común'),
(2, 'Persa'),
(2, 'Siamés'),
(2, 'Maine Coon'),
(2, 'British Shorthair'),
(2, 'Ragdoll'),
(2, 'Bengalí'),
(2, 'Sphynx'),
(2, 'Bosque de Noruega'),
(2, 'Mestizo'),

-- Otras especies
(3, 'Conejo'),
(3, 'Cobaya'),
(3, 'Hámster'),
(3, 'Hurón'),
(3, 'Loro'),
(3, 'Periquito'),
(3, 'Tortuga'),
(3, 'Iguana'),
(3, 'Otro');
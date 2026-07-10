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
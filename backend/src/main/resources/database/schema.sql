-- defensiva

DROP TABLE IF EXISTS rol CASCADE;
DROP TABLE IF EXISTS especie CASCADE;
DROP TABLE IF EXISTS usuario_rol CASCADE;
DROP TABLE IF EXISTS usuario CASCADE;
DROP TABLE IF EXISTS mascota CASCADE;
DROP TABLE IF EXISTS raza CASCADE;
DROP TABLE IF EXISTS cita CASCADE;
DROP TABLE IF EXISTS servicio CASCADE;
DROP TABLE IF EXISTS cita_servicio CASCADE;
DROP TABLE IF EXISTS bloqueo_horario CASCADE;
DROP TABLE IF EXISTS estado_cita CASCADE;
DROP TABLE IF EXISTS horario CASCADE;

-- crear tipos (ENUM)

DROP TYPE IF EXISTS genero CASCADE;

CREATE TYPE genero AS ENUM(
    'MACHO',
    'HEMBRA',
    'DESCONOCIDO'
);

DROP TYPE IF EXISTS dia_semana CASCADE;
CREATE TYPE dia_semana AS ENUM(
    'LUNES',
    'MARTES',
    'MIERCOLES',
    'JUEVES',
    'VIERNES',
    'SABADO',
    'DOMINGO'
);

-- crear tablas

CREATE TABLE rol (
    id INTEGER GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    nombre VARCHAR(50) NOT NULL UNIQUE
);

CREATE TABLE especie (
    id INTEGER GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    nombre VARCHAR(25) NOT NULL UNIQUE
);

CREATE TABLE estado_cita(
    id INTEGER GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    nombre VARCHAR(50) NOT NULL UNIQUE
);

CREATE TABLE servicio(
    id INTEGER GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL UNIQUE,
    descripcion TEXT,
    precio DECIMAL(5,2) NOT NULL CHECK (precio >= 0),
    duracion_estimada INTEGER NOT NULL CHECK (duracion_estimada > 0),
    activo BOOLEAN DEFAULT TRUE
);

CREATE TABLE usuario(
    id INTEGER GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    apellidos VARCHAR(100) NOT NULL,
    telefono VARCHAR(20) NOT NULL,
    email VARCHAR(255) NOT NULL UNIQUE,
    password_hash VARCHAR(255) NOT NULL,
    fecha_registro TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    activo BOOLEAN NOT NULL DEFAULT TRUE
);

CREATE TABLE usuario_rol(
    id INTEGER GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    id_usuario INTEGER NOT NULL,
    id_rol INTEGER NOT NULL,
    
    UNIQUE (id_usuario, id_rol),

    FOREIGN KEY (id_usuario) REFERENCES usuario(id) ON DELETE CASCADE,
    FOREIGN KEY (id_rol) REFERENCES rol(id) ON DELETE RESTRICT
);

CREATE TABLE raza(
    id INTEGER GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    id_especie INTEGER NOT NULL,
    nombre VARCHAR(50) NOT NULL,
    UNIQUE (id_especie, nombre),
    FOREIGN KEY (id_especie) REFERENCES especie(id) ON DELETE RESTRICT
);

CREATE TABLE mascota(
    id INTEGER GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    id_usuario INTEGER NOT NULL,
    id_raza INTEGER NOT NULL,
    nombre VARCHAR(100) NOT NULL,
    genero genero NOT NULL,
    fecha_nacimiento DATE,
    peso DECIMAL(5,2) NOT NULL CHECK (peso > 0),
    foto_url VARCHAR(2048) NOT NULL,
    observaciones TEXT,
    FOREIGN KEY (id_usuario) REFERENCES usuario(id) ON DELETE RESTRICT,
    FOREIGN KEY (id_raza) REFERENCES raza(id) ON DELETE RESTRICT
);

CREATE TABLE horario(
    id INTEGER GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    dia_semana dia_semana NOT NULL,
    hora_apertura TIME NOT NULL,
    hora_cierre TIME NOT NULL,
    activo BOOLEAN NOT NULL DEFAULT TRUE,
    UNIQUE (dia_semana),
    CHECK (hora_apertura < hora_cierre) 
);

CREATE TABLE cita(
    id INTEGER GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    id_mascota INTEGER NOT NULL,
    id_estado INTEGER NOT NULL,
    fecha_hora TIMESTAMP NOT NULL,
    duracion_estimada INTEGER,
    precio_total DECIMAL(8,2) NOT NULL CHECK (precio_total >= 0),
    fecha_creacion TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    observaciones TEXT,
    FOREIGN KEY (id_mascota) REFERENCES mascota(id) ON DELETE RESTRICT,
    FOREIGN KEY (id_estado) REFERENCES estado_cita(id) ON DELETE RESTRICT
);

CREATE TABLE bloqueo_horario(
    id INTEGER GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    id_usuario INTEGER NOT NULL,
    fecha DATE NOT NULL,
    hora_inicio TIME NOT NULL,
    hora_fin TIME NOT NULL,
    motivo TEXT NOT NULL,
    activo BOOLEAN NOT NULL DEFAULT TRUE,
    CHECK (hora_inicio < hora_fin),
    FOREIGN KEY (id_usuario) REFERENCES usuario(id) ON DELETE CASCADE
);

CREATE TABLE cita_servicio(
    id INTEGER GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    id_cita INTEGER NOT NULL,
    id_servicio INTEGER NOT NULL,
    UNIQUE (id_cita, id_servicio),
    FOREIGN KEY (id_cita) REFERENCES cita(id) ON DELETE CASCADE,
    FOREIGN KEY (id_servicio) REFERENCES servicio(id) ON DELETE RESTRICT
);



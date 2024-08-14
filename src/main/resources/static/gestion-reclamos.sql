/*CREATE TABLE usr (
    usr_id SERIAL PRIMARY KEY,         -- Definición de la clave primaria auto-incrementable
    first_name VARCHAR(255) NOT NULL, -- Columna para el primer nombre
    last_name VARCHAR(255) NOT NULL,  -- Columna para el apellido
    email VARCHAR(255) UNIQUE NOT NULL,-- Columna para el correo electrónico (único y no nulo)
    password VARCHAR(255) NOT NULL     -- Columna para la contraseña
);*/
/*CREATE TABLE role (
    role_id SERIAL PRIMARY KEY,    -- Definición de la clave primaria auto-incrementable
    name VARCHAR(255) UNIQUE NOT NULL -- Columna para el nombre del rol (único y no nulo)
);*/

/*CREATE TABLE usr_role (
    usr_id INT NOT NULL,           -- Clave foránea que referencia la tabla de usuarios
    role_id INT NOT NULL,          -- Clave foránea que referencia la tabla de roles
    PRIMARY KEY (usr_id, role_id), -- Clave primaria compuesta para asegurar la unicidad
    FOREIGN KEY (usr_id) REFERENCES usr(usr_id) ON DELETE CASCADE, -- Restricción de clave foránea
    FOREIGN KEY (role_id) REFERENCES role(role_id) ON DELETE CASCADE -- Restricción de clave foránea
);
*/
/*CREATE TABLE complain (
    complain_id SERIAL PRIMARY KEY,   -- Definición de la clave primaria auto-incrementable
    title VARCHAR(255) NOT NULL,      -- Definición de la columna para el título de la queja
    description TEXT,                 -- Definición de la columna para la descripción de la queja
    status VARCHAR(50) NOT NULL,      -- Definición de la columna para el estado de la queja
    usr_id INT NOT NULL,              -- Columna para la clave foránea que referencia a la tabla 'usr'
    CONSTRAINT fk_usr                 -- Definición de la clave foránea
        FOREIGN KEY (usr_id)          -- Columna en la tabla 'complain' que actúa como clave foránea
        REFERENCES usr (usr_id)       -- Tabla a la que se refiere la clave foránea
        ON DELETE CASCADE             -- Opcional: Elimina las quejas asociadas si se elimina el usuario
);*/

select * from usr;
select * from role;
select * from usr_role;
select * from complain;

--insert into role(name)values('ADMIN'),('USR'),('CLIENT');
--alter table usr add column image varchar(500);
/*INSERT INTO usr (first_name, last_name, email, password,image) VALUES
('Carlos', 'García', 'carlos.garcia@example.com', 'password123','https://randomuser.me/api/portraits/men/38.jpg'),
('María', 'Rodríguez', 'maria.rodriguez@example.com', 'password123','https://randomuser.me/api/portraits/women/57.jpg'),
('José', 'Martínez', 'jose.martinez@example.com', 'password123','https://randomuser.me/api/portraits/men/6.jpg'),
('Ana', 'Hernández', 'ana.hernandez@example.com', 'password123','https://randomuser.me/api/portraits/women/45.jpg');*/
insert into usr_role(usr_id,role_id)values(1,1),(2,2),(3,3),(4,3);

/*INSERT INTO complain (title, description, status, usr_id) VALUES
('Servicio deficiente', 'El servicio de transporte fue muy lento y no cumplió con el horario.', 'UNRESOLVED', 3),
('Problemas con el vehículo', 'El autobús en el que viajé estaba en malas condiciones y muy sucio.', 'UNRESOLVED', 3),
('Retraso en el transporte', 'El transporte llegó con una hora de retraso, lo que causó inconvenientes.', 'UNRESOLVED', 4),
('Falta de atención al cliente', 'El personal de la empresa no fue atento ni útil al resolver problemas.', 'UNRESOLVED', 4);*/

--update usr set password='$2a$10$mJNMiv8eh4uaKr5ZiLOLLu5q/OgYJCXZVMsITl6/VxqZbNyJMjjCu' where usr_id=1;


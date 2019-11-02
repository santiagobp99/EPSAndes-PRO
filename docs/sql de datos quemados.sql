-- Inserto Todos los roles que me piden
INSERT INTO Rol (nombre) values ('ADMINISTRADOR');
INSERT INTO Rol (nombre) values ('GERENTE');
INSERT INTO Rol (nombre) values ('RECEPCIONISTA');
INSERT INTO Rol (nombre) values ('MEDICO');
INSERT INTO Rol (nombre) values ('AFILIADO');
INSERT INTO Rol (nombre) values ('ORGANIZADORCAMPAÑA');
--

-- 1 administrador
insert into USUARIO (nombre, correo, idrol) values ('Gill', 'ggarret0@so-net.ne.jp', 1);
--

-- 1 gerente
insert into USUARIO (nombre, correo, idrol) values ('Chrotoem', 'cfolkerts1@cyberchimps.com', 2);
insert into EPS_ANDES (idgerente) values ('2');
--

-- 2 IPS y 1 Recepcionista por Cada IPS
insert into IPS (idEps, nombre, tipo, ubicacion, capacidad) values (1, 'Yozio', 'HOSPITAL', 'Usaquen', '15');
insert into USUARIO (nombre, correo, idrol) values ('Gannie', 'gnannetti2@uiuc.edu', 3);
insert into RECEPCIONISTA (id, idIps) values (3, 1);
		-- 6 servicios
insert into SERVICIO_SALUD (idIps, tipo, orden, descripcion) values (1, 'CITA_MEDICA', 1, 'Integer ac neque. Duis bibendum.');
insert into SERVICIO_SALUD (idIps, tipo, orden, descripcion) values (1, 'CONSULTA_ESPECIALISTA', 1, 'Integer a nibh.');
insert into SERVICIO_SALUD (idIps, tipo, orden, descripcion) values (1, 'EXAMEN_DE_SANGRE', 1, 'Proin eu mi.');
insert into SERVICIO_SALUD (idIps, tipo, orden, descripcion) values (1, 'RADIOGRAFIA', 1, 'Integer ac neque.');
insert into SERVICIO_SALUD (idIps, tipo, orden, descripcion) values (1, 'CONSULTA_ODONTOLOGICA', 1, 'Curabitur gravida nisi at nibh.');
insert into SERVICIO_SALUD (idIps, tipo, orden, descripcion) values (1, 'JORNADA_DE_VACUNACION', 1, 'Etiam justo.');


insert into IPS (idEps, nombre, tipo, ubicacion, capacidad) values (1, 'Buzzdog', 'HOSPITAL', 'Suba', '15');
insert into USUARIO (nombre, correo, idrol) values ('Dane', 'dlots3@time.com', 3);
insert into RECEPCIONISTA (id, idIps) values (4, 2);
		-- 6 Servicios
insert into SERVICIO_SALUD (idIps, tipo, orden, descripcion) values (2, 'CITA_MEDICA', 1, 'Suspendisse potenti.');
insert into SERVICIO_SALUD (idIps, tipo, orden, descripcion) values (2, 'CONSULTA_ESPECIALISTA', 1, 'Nullam varius.');
insert into SERVICIO_SALUD (idIps, tipo, orden, descripcion) values (2, 'EXAMEN_DE_SANGRE', 1, 'Aliquam non mauris.');
insert into SERVICIO_SALUD (idIps, tipo, orden, descripcion) values (2, 'RADIOGRAFIA', 1, 'Vestibulum quam sapien,');
insert into SERVICIO_SALUD (idIps, tipo, orden, descripcion) values (2, 'CONSULTA_ODONTOLOGICA', 1, 'Nulla facilisi.');
insert into SERVICIO_SALUD (idIps, tipo, orden, descripcion) values (2, 'JORNADA_DE_VACUNACION', 1, 'Aenean sit amet justo.');
-- 

--Estos van a usar lo servicios de:
-- o Consultas médicas con:


--insert into IPS (idEps, nombre, tipo, ubicacion, capacidad) values (1, 'Youtags', 'HOSPITAL', 'Chapinero', '1');
--insert into IPS (idEps, nombre, tipo, ubicacion, capacidad) values (1, 'Geba', 'HOSPITAL', 'Teusaquillo', '62603');
--insert into IPS (idEps, nombre, tipo, ubicacion, capacidad) values (1, 'Thoughtbridge', 'HOSPITAL', 'Usme', '84500');
--insert into IPS (idEps, nombre, tipo, ubicacion, capacidad) values (1, 'Gabspot', 'HOSPITAL', 'Tunjuelito', '144');
--insert into IPS (idEps, nombre, tipo, ubicacion, capacidad) values (1, 'Demivee', 'HOSPITAL', 'Bosa', '27435');
--insert into IPS (idEps, nombre, tipo, ubicacion, capacidad) values (1, 'Dabfeed', 'HOSPITAL', 'Kennedy', '3');
--insert into IPS (idEps, nombre, tipo, ubicacion, capacidad) values (1, 'Voonder', 'HOSPITAL', 'Fontibon', '56305');
--insert into IPS (idEps, nombre, tipo, ubicacion, capacidad) values (1, 'Wikizz', 'HOSPITAL', 'Engativa', '59');

-- 'CITA_MEDICA'
insert into MEDICO (idRol, numRegistroMedico, especialidad, identificacion, nombre, correo) values (4, '5', 'Junior Executive', '45', 'Rowney', 'rdewing0@mysql.com');
insert into ADSCRITOS (idMedico, idIps) values (1, 1);
insert into ADSCRITOS (idMedico, idIps) values (1, 2);
insert into MEDICO_SERVICIO (idMedico, idServicio) values (1, 1);
insert into MEDICO_SERVICIO (idMedico, idServicio) values (1, 7);

insert into MEDICO (idRol, numRegistroMedico, especialidad, identificacion, nombre, correo) values (4, '89', 'Editor', '53704', 'Claudette', 'cfurbank1@ihg.com');
insert into ADSCRITOS (idMedico, idIps) values (2, 1);
insert into ADSCRITOS (idMedico, idIps) values (2, 2);
insert into MEDICO_SERVICIO (idMedico, idServicio) values (2, 1);
insert into MEDICO_SERVICIO (idMedico, idServicio) values (2, 7);

insert into MEDICO (idRol, numRegistroMedico, especialidad, identificacion, nombre, correo) values (4, '83', 'Help Desk Technician', '1419', 'Celestia', 'ccawston2@friendfeed.com');
insert into ADSCRITOS (idMedico, idIps) values (3, 1);
insert into ADSCRITOS (idMedico, idIps) values (3, 2);
insert into MEDICO_SERVICIO (idMedico, idServicio) values (3, 1);
insert into MEDICO_SERVICIO (idMedico, idServicio) values (3, 7);


insert into MEDICO (idRol, numRegistroMedico, especialidad, identificacion, nombre, correo) values (4, '092', 'Data Coordiator', '61', 'Inger', 'ibailes3@imageshack.us');
insert into ADSCRITOS (idMedico, idIps) values (4, 1);
insert into ADSCRITOS (idMedico, idIps) values (4, 2);
insert into MEDICO_SERVICIO (idMedico, idServicio) values (4, 1);
insert into MEDICO_SERVICIO (idMedico, idServicio) values (4, 7);

-- 'CONSULTA_ESPECIALISTA'
insert into MEDICO (idRol, numRegistroMedico, especialidad, identificacion, nombre, correo) values (4, '270', 'Compensation Analyst', '634', 'Aurea', 'astirling4@bandcamp.com');
insert into ADSCRITOS (idMedico, idIps) values (5, 1);
insert into ADSCRITOS (idMedico, idIps) values (5, 2);
insert into MEDICO_SERVICIO (idMedico, idServicio) values (5, 2);
insert into MEDICO_SERVICIO (idMedico, idServicio) values (5, 8);

insert into MEDICO (idRol, numRegistroMedico, especialidad, identificacion, nombre, correo) values (4, '4', 'VP Sales', '6764', 'Judd', 'jhiorn5@icio.us');
insert into ADSCRITOS (idMedico, idIps) values (6, 1);
insert into ADSCRITOS (idMedico, idIps) values (6, 2);
insert into MEDICO_SERVICIO (idMedico, idServicio) values (6, 2);
insert into MEDICO_SERVICIO (idMedico, idServicio) values (6, 8);

insert into MEDICO (idRol, numRegistroMedico, especialidad, identificacion, nombre, correo) values (4, '73', 'Associate Professor', '194', 'Leighton', 'lgronou6@macromedia.com');
insert into ADSCRITOS (idMedico, idIps) values (7, 1);
insert into ADSCRITOS (idMedico, idIps) values (7, 2);
insert into MEDICO_SERVICIO (idMedico, idServicio) values (7, 2);
insert into MEDICO_SERVICIO (idMedico, idServicio) values (7, 8);

insert into MEDICO (idRol, numRegistroMedico, especialidad, identificacion, nombre, correo) values (4, '531', 'Legal Assistant', '7', 'Garland', 'gdallimare7@addthis.com');
insert into ADSCRITOS (idMedico, idIps) values (8, 1);
insert into ADSCRITOS (idMedico, idIps) values (8, 2);
insert into MEDICO_SERVICIO (idMedico, idServicio) values (8, 2);
insert into MEDICO_SERVICIO (idMedico, idServicio) values (8, 8);
--'EXAMEN_DE_SANGRE'
insert into MEDICO (idRol, numRegistroMedico, especialidad, identificacion, nombre, correo) values (4, '17', 'Technical Writer', '7562', 'Parnell', 'psimoens8@nih.gov');
insert into ADSCRITOS (idMedico, idIps) values (9, 1);
insert into ADSCRITOS (idMedico, idIps) values (9, 2);
insert into MEDICO_SERVICIO (idMedico, idServicio) values (9, 3);
insert into MEDICO_SERVICIO (idMedico, idServicio) values (9, 8);

insert into MEDICO (idRol, numRegistroMedico, especialidad, identificacion, nombre, correo) values (4, '3', 'Staff Scientist', '3203', 'Gerrie', 'gpranger9@businesswire.com');
insert into ADSCRITOS (idMedico, idIps) values (10, 1);
insert into ADSCRITOS (idMedico, idIps) values (10, 2);
insert into MEDICO_SERVICIO (idMedico, idServicio) values (10, 3);
insert into MEDICO_SERVICIO (idMedico, idServicio) values (10, 9);

insert into MEDICO (idRol, numRegistroMedico, especialidad, identificacion, nombre, correo) values (4, '69', 'Information Systems Manager', '4', 'Alberik', 'ahinckesa@disqus.com');
insert into ADSCRITOS (idMedico, idIps) values (11, 1);
insert into ADSCRITOS (idMedico, idIps) values (11, 2);
insert into MEDICO_SERVICIO (idMedico, idServicio) values (11, 3);
insert into MEDICO_SERVICIO (idMedico, idServicio) values (11, 9);

insert into MEDICO (idRol, numRegistroMedico, especialidad, identificacion, nombre, correo) values (4, '1321', 'Help Desk Technician', '213', 'Cary', 'cpealingb@cornell.edu');
insert into ADSCRITOS (idMedico, idIps) values (12, 1);
insert into ADSCRITOS (idMedico, idIps) values (12, 2);
insert into MEDICO_SERVICIO (idMedico, idServicio) values (12, 3);
insert into MEDICO_SERVICIO (idMedico, idServicio) values (12, 9);
--'RADIOGRAFIA'
insert into MEDICO (idRol, numRegistroMedico, especialidad, identificacion, nombre, correo) values (4, '804', 'Web Designer I', '34632', 'Vincenty', 'vchastangc@elegantthemes.com');
insert into ADSCRITOS (idMedico, idIps) values (13, 1);
insert into ADSCRITOS (idMedico, idIps) values (13, 2);
insert into MEDICO_SERVICIO (idMedico, idServicio) values (13, 4);
insert into MEDICO_SERVICIO (idMedico, idServicio) values (13, 10);



insert into MEDICO (idRol, numRegistroMedico, especialidad, identificacion, nombre, correo) values (4, '7522', 'Marketing Manager', '043', 'Roy', 'rmciverd@chicagotribune.com');
insert into ADSCRITOS (idMedico, idIps) values (14, 1);
insert into ADSCRITOS (idMedico, idIps) values (14, 2);
insert into MEDICO_SERVICIO (idMedico, idServicio) values (14, 4);
insert into MEDICO_SERVICIO (idMedico, idServicio) values (14, 10);

insert into MEDICO (idRol, numRegistroMedico, especialidad, identificacion, nombre, correo) values (4, '9693', 'Staff Accountant I', '75', 'Sunshine', 'snappine@macromedia.com');
insert into ADSCRITOS (idMedico, idIps) values (15, 1);
insert into ADSCRITOS (idMedico, idIps) values (15, 2);
insert into MEDICO_SERVICIO (idMedico, idServicio) values (15, 4);
insert into MEDICO_SERVICIO (idMedico, idServicio) values (15, 10);

insert into MEDICO (idRol, numRegistroMedico, especialidad, identificacion, nombre, correo) values (4, '60475', 'Assistant Professor', '099', 'Portie', 'psoperf@independent.co.uk');
insert into ADSCRITOS (idMedico, idIps) values (16, 1);
insert into ADSCRITOS (idMedico, idIps) values (16, 2);
insert into MEDICO_SERVICIO (idMedico, idServicio) values (16, 4);
insert into MEDICO_SERVICIO (idMedico, idServicio) values (16, 10);
--'CONSULTA_ODONTOLOGICA'
insert into MEDICO (idRol, numRegistroMedico, especialidad, identificacion, nombre, correo) values (4, '16', 'Account Executive', '29', 'Hilda', 'haddeycottg@gizmodo.com');
insert into ADSCRITOS (idMedico, idIps) values (17, 1);
insert into ADSCRITOS (idMedico, idIps) values (17, 2);
insert into MEDICO_SERVICIO (idMedico, idServicio) values (17, 5);
insert into MEDICO_SERVICIO (idMedico, idServicio) values (17, 11);

insert into MEDICO (idRol, numRegistroMedico, especialidad, identificacion, nombre, correo) values (4, '298', 'GIS Technical Architect', '57280', 'Kariotta', 'kfusterh@purevolume.com');
insert into ADSCRITOS (idMedico, idIps) values (18, 1);
insert into ADSCRITOS (idMedico, idIps) values (18, 2);
insert into MEDICO_SERVICIO (idMedico, idServicio) values (18, 5);
insert into MEDICO_SERVICIO (idMedico, idServicio) values (18, 11);

insert into MEDICO (idRol, numRegistroMedico, especialidad, identificacion, nombre, correo) values (4, '20', 'Speech Pathologist', '9976', 'Sianna', 'smariani@purevolume.com');
insert into ADSCRITOS (idMedico, idIps) values (19, 1);
insert into ADSCRITOS (idMedico, idIps) values (19, 2);
insert into MEDICO_SERVICIO (idMedico, idServicio) values (19, 5);
insert into MEDICO_SERVICIO (idMedico, idServicio) values (19, 11);

insert into MEDICO (idRol, numRegistroMedico, especialidad, identificacion, nombre, correo) values (4, '96204', 'Staff Scientist', '8973', 'Giuditta', 'ghordlej@miibeian.gov.cn');
insert into ADSCRITOS (idMedico, idIps) values (20, 1);
insert into ADSCRITOS (idMedico, idIps) values (20, 2);
insert into MEDICO_SERVICIO (idMedico, idServicio) values (20, 5);
insert into MEDICO_SERVICIO (idMedico, idServicio) values (20,11);
--'JORNADA_DE_VACUNACION'
insert into MEDICO (idRol, numRegistroMedico, especialidad, identificacion, nombre, correo) values (4, '7059', 'Health Coach I', '1023', 'Nadean', 'nbroadyk@cnn.com');
insert into ADSCRITOS (idMedico, idIps) values (21, 1);
insert into ADSCRITOS (idMedico, idIps) values (21, 2);
insert into MEDICO_SERVICIO (idMedico, idServicio) values (21, 6);
insert into MEDICO_SERVICIO (idMedico, idServicio) values (21, 12);

insert into MEDICO (idRol, numRegistroMedico, especialidad, identificacion, nombre, correo) values (4, '41026', 'Budget/Accounting Analyst III', '104', 'Ezequiel', 'edennerlyl@omniture.com');
insert into ADSCRITOS (idMedico, idIps) values (22, 1);
insert into ADSCRITOS (idMedico, idIps) values (22, 2);
insert into MEDICO_SERVICIO (idMedico, idServicio) values (22, 6);
insert into MEDICO_SERVICIO (idMedico, idServicio) values (22, 12);

insert into MEDICO (idRol, numRegistroMedico, especialidad, identificacion, nombre, correo) values (4, '806', 'Environmental Specialist', '1', 'Theodoric', 'tcantym@vinaora.com');
insert into ADSCRITOS (idMedico, idIps) values (23, 1);
insert into ADSCRITOS (idMedico, idIps) values (23, 2);
insert into MEDICO_SERVICIO (idMedico, idServicio) values (23, 6);
insert into MEDICO_SERVICIO (idMedico, idServicio) values (23, 12);

insert into MEDICO (idRol, numRegistroMedico, especialidad, identificacion, nombre, correo) values (4, '25266', 'Graphic Designer', '618', 'Wilton', 'wwardingleyn@ameblo.jp');
insert into ADSCRITOS (idMedico, idIps) values (24, 1);
insert into ADSCRITOS (idMedico, idIps) values (24, 2);
insert into MEDICO_SERVICIO (idMedico, idServicio) values (24, 6);
insert into MEDICO_SERVICIO (idMedico, idServicio) values (24, 12);
-----


--- AFILIADOS
insert into USUARIO (nombre, correo, idrol) values ('Farr', 'fbremond4@oakley.com', 5);
insert into AFILIADO (idUsuario, idEps, fechaNacimiento, tipoDocumento, numDocumento, hospitalizado) values (5, 1, '28/03/1956', 'CC', '43424234235', 0);

insert into USUARIO (nombre, correo, idrol) values ('Wadsworth', 'wcherrett5@oaic.gov.au', 5);
insert into AFILIADO (idUsuario, idEps, fechaNacimiento, tipoDocumento, numDocumento, hospitalizado) values (6, 1, '25/04/1985', 'CC', '0820', 0);

insert into USUARIO (nombre, correo, idrol) values ('Murray', 'mschoffler6@hp.com', 5);
insert into AFILIADO (idUsuario, idEps, fechaNacimiento, tipoDocumento, numDocumento, hospitalizado) values (7, 1, '10/05/1977', 'CC', '3610', 0);

insert into USUARIO (nombre, correo, idrol) values ('Tabor', 'tkarpenya7@mac.com', 5);
insert into AFILIADO (idUsuario, idEps, fechaNacimiento, tipoDocumento, numDocumento, hospitalizado) values (8, 1, '17/10/1988', 'CC', '5', 0);

insert into USUARIO (nombre, correo, idrol) values ('Edvard', 'eenderle8@google.pl', 5);
insert into AFILIADO (idUsuario, idEps, fechaNacimiento, tipoDocumento, numDocumento, hospitalizado) values (9, 1, '12/08/1974', 'CC', '67', 0);

insert into USUARIO (nombre, correo, idrol) values ('Woodman', 'wstagg9@photobucket.com', 5);
insert into AFILIADO (idUsuario, idEps, fechaNacimiento, tipoDocumento, numDocumento, hospitalizado) values (10, 1, '08/08/1993', 'CC', '11', 0);

insert into USUARIO (nombre, correo, idrol) values ('Alric', 'afairbournea@google.com.br', 5);
insert into AFILIADO (idUsuario, idEps, fechaNacimiento, tipoDocumento, numDocumento, hospitalizado) values (11, 1, '09/07/1977', 'CC', '87128', 0);

insert into USUARIO (nombre, correo, idrol) values ('Stanford', 'sglaumb@rambler.ru', 5);
insert into AFILIADO (idUsuario, idEps, fechaNacimiento, tipoDocumento, numDocumento, hospitalizado) values (12, 1, '28/09/1984', 'CC', '5119', 0);

insert into USUARIO (nombre, correo, idrol) values ('Gustave', 'ghalmkinc@youtu.be', 5);
insert into AFILIADO (idUsuario, idEps, fechaNacimiento, tipoDocumento, numDocumento, hospitalizado) values (13, 1, '08/12/1991', 'CC', '6507', 0);

insert into USUARIO (nombre, correo, idrol) values ('Claudius', 'cantonazzid@tinypic.com', 5);
insert into AFILIADO (idUsuario, idEps, fechaNacimiento, tipoDocumento, numDocumento, hospitalizado) values (14, 1, '09/11/1956', 'CC', '390', 0);

insert into USUARIO (nombre, correo, idrol) values ('Vanya', 'vwhittame@cloudflare.com', 5);
insert into AFILIADO (idUsuario, idEps, fechaNacimiento, tipoDocumento, numDocumento, hospitalizado) values (15, 1, '14/12/1963', 'CC', '722', 0);

insert into USUARIO (nombre, correo, idrol) values ('Grantham', 'gpogef@usgs.gov', 5);
insert into AFILIADO (idUsuario, idEps, fechaNacimiento, tipoDocumento, numDocumento, hospitalizado) values (16, 1, '03/06/1965', 'CC', '28035', 0);

insert into USUARIO (nombre, correo, idrol) values ('Puff', 'pgounodg@washington.edu', 5);
insert into AFILIADO (idUsuario, idEps, fechaNacimiento, tipoDocumento, numDocumento, hospitalizado) values (17, 1, '15/02/1982', 'CC', '74', 0);

insert into USUARIO (nombre, correo, idrol) values ('Garry', 'gdoelleh@histats.com', 5);
insert into AFILIADO (idUsuario, idEps, fechaNacimiento, tipoDocumento, numDocumento, hospitalizado) values (18, 1, '07/01/1963', 'CC', '36', 0);

insert into USUARIO (nombre, correo, idrol) values ('Locke', 'lloderi@exblog.jp', 5);
insert into AFILIADO (idUsuario, idEps, fechaNacimiento, tipoDocumento, numDocumento, hospitalizado) values (19, 1, '24/01/1996', 'CC', '6278', 0);

insert into USUARIO (nombre, correo, idrol) values ('Godfree', 'gosgarbyj@slate.com', 5);
insert into AFILIADO (idUsuario, idEps, fechaNacimiento, tipoDocumento, numDocumento, hospitalizado) values (20, 1, '04/06/1980', 'CC', '24', 0);

insert into USUARIO (nombre, correo, idrol) values ('Ignacio', 'ifordhamk@gmpg.org', 5);
insert into AFILIADO (idUsuario, idEps, fechaNacimiento, tipoDocumento, numDocumento, hospitalizado) values (21, 1, '31/12/1992', 'CC', '940', 0);

insert into USUARIO (nombre, correo, idrol) values ('Alejandro', 'amanthorpel@wp.com', 5);
insert into AFILIADO (idUsuario, idEps, fechaNacimiento, tipoDocumento, numDocumento, hospitalizado) values (22, 1, '09/02/1973', 'CC', '5945', 0);

insert into USUARIO (nombre, correo, idrol) values ('Pepe', 'psodorym@salon.com', 5);
insert into AFILIADO (idUsuario, idEps, fechaNacimiento, tipoDocumento, numDocumento, hospitalizado) values (23, 1, '30/12/1998', 'CC', '5880', 0);

insert into USUARIO (nombre, correo, idrol) values ('Henderson', 'hgogginn@w3.org', 5);
insert into AFILIADO (idUsuario, idEps, fechaNacimiento, tipoDocumento, numDocumento, hospitalizado) values (24, 1, '24/04/1973', 'CC', '543434354353453', 0);

insert into USUARIO (nombre, correo, idrol) values ('Lenard', 'lcanadaso@wix.com', 5);
insert into AFILIADO (idUsuario, idEps, fechaNacimiento, tipoDocumento, numDocumento, hospitalizado) values (25, 1, '21/05/1960', 'CC', '38', 0);

insert into USUARIO (nombre, correo, idrol) values ('Ulrich', 'uelcombep@ucoz.com', 5);
insert into AFILIADO (idUsuario, idEps, fechaNacimiento, tipoDocumento, numDocumento, hospitalizado) values (26, 1, '10/11/1982', 'CC', '204', 0);

insert into USUARIO (nombre, correo, idrol) values ('Shurwood', 'strimmellq@dailymail.co.uk', 5);
insert into AFILIADO (idUsuario, idEps, fechaNacimiento, tipoDocumento, numDocumento, hospitalizado) values (27, 1, '18/05/1975', 'CC', '227', 0);

insert into USUARIO (nombre, correo, idrol) values ('Laughton', 'ledworthyr@washingtonpost.com', 5);
insert into AFILIADO (idUsuario, idEps, fechaNacimiento, tipoDocumento, numDocumento, hospitalizado) values (28, 1, '27/08/1986', 'CC', '4152', 0);

insert into USUARIO (nombre, correo, idrol) values ('Worthington', 'wklasss@de.vu', 5);
insert into AFILIADO (idUsuario, idEps, fechaNacimiento, tipoDocumento, numDocumento, hospitalizado) values (29, 1, '26/07/1978', 'CC', '150', 0);

insert into USUARIO (nombre, correo, idrol) values ('Billy', 'bmilhencht@printfriendly.com', 5);
insert into AFILIADO (idUsuario, idEps, fechaNacimiento, tipoDocumento, numDocumento, hospitalizado) values (30, 1, '29/09/1970', 'CC', '985', 0);

insert into USUARIO (nombre, correo, idrol) values ('Bendick', 'bsmowtonu@macromedia.com', 5);
insert into AFILIADO (idUsuario, idEps, fechaNacimiento, tipoDocumento, numDocumento, hospitalizado) values (31, 1, '03/12/1977', 'CC', '6913', 0);

insert into USUARIO (nombre, correo, idrol) values ('Cooper', 'cgrahlv@a8.net', 5);
insert into AFILIADO (idUsuario, idEps, fechaNacimiento, tipoDocumento, numDocumento, hospitalizado) values (32, 1, '26/02/1968', 'CC', '773', 0);
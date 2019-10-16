DECLARE 
  C NUMBER; 
BEGIN 
SELECT COUNT(*) INTO C 
FROM ALL_TRIGGERS 
  WHERE OWNER = '' 
  AND TRIGGER_NAME = 'TRG_EPS_ANDES_ID'; 
  IF (C > 0) THEN 
    EXECUTE IMMEDIATE 'DROP TRIGGER "TRG_EPS_ANDES_ID"'; 
END IF; 
END 

;
/
DECLARE 
  C NUMBER; 
BEGIN 
SELECT COUNT(*) INTO C 
FROM ALL_SEQUENCES 
  WHERE SEQUENCE_OWNER = '' 
  AND SEQUENCE_NAME = 'SEQ_EPS_ANDES_ID'; 
  IF (C > 0) THEN 
    EXECUTE IMMEDIATE 'DROP SEQUENCE "SEQ_EPS_ANDES_ID"'; 
END IF; 
END 

;
/
DECLARE 
  C NUMBER; 
BEGIN 
SELECT COUNT(*) INTO C 
FROM ALL_TRIGGERS 
  WHERE OWNER = '' 
  AND TRIGGER_NAME = 'TRG_HORARIO_ID'; 
  IF (C > 0) THEN 
    EXECUTE IMMEDIATE 'DROP TRIGGER "TRG_HORARIO_ID"'; 
END IF; 
END 

;
/
DECLARE 
  C NUMBER; 
BEGIN 
SELECT COUNT(*) INTO C 
FROM ALL_SEQUENCES 
  WHERE SEQUENCE_OWNER = '' 
  AND SEQUENCE_NAME = 'SEQ_HORARIO_ID'; 
  IF (C > 0) THEN 
    EXECUTE IMMEDIATE 'DROP SEQUENCE "SEQ_HORARIO_ID"'; 
END IF; 
END 

;
/
DECLARE 
  C NUMBER; 
BEGIN 
SELECT COUNT(*) INTO C 
FROM ALL_TRIGGERS 
  WHERE OWNER = '' 
  AND TRIGGER_NAME = 'TRG_HORAS_ID'; 
  IF (C > 0) THEN 
    EXECUTE IMMEDIATE 'DROP TRIGGER "TRG_HORAS_ID"'; 
END IF; 
END 

;
/
DECLARE 
  C NUMBER; 
BEGIN 
SELECT COUNT(*) INTO C 
FROM ALL_SEQUENCES 
  WHERE SEQUENCE_OWNER = '' 
  AND SEQUENCE_NAME = 'SEQ_HORAS_ID'; 
  IF (C > 0) THEN 
    EXECUTE IMMEDIATE 'DROP SEQUENCE "SEQ_HORAS_ID"'; 
END IF; 
END 

;
/
DECLARE 
  C NUMBER; 
BEGIN 
SELECT COUNT(*) INTO C 
FROM ALL_TRIGGERS 
  WHERE OWNER = '' 
  AND TRIGGER_NAME = 'TRG_IPS_ID'; 
  IF (C > 0) THEN 
    EXECUTE IMMEDIATE 'DROP TRIGGER "TRG_IPS_ID"'; 
END IF; 
END 

;
/
DECLARE 
  C NUMBER; 
BEGIN 
SELECT COUNT(*) INTO C 
FROM ALL_SEQUENCES 
  WHERE SEQUENCE_OWNER = '' 
  AND SEQUENCE_NAME = 'SEQ_IPS_ID'; 
  IF (C > 0) THEN 
    EXECUTE IMMEDIATE 'DROP SEQUENCE "SEQ_IPS_ID"'; 
END IF; 
END 

;
/
DECLARE 
  C NUMBER; 
BEGIN 
SELECT COUNT(*) INTO C 
FROM ALL_TRIGGERS 
  WHERE OWNER = '' 
  AND TRIGGER_NAME = 'TRG_MEDICO_ID'; 
  IF (C > 0) THEN 
    EXECUTE IMMEDIATE 'DROP TRIGGER "TRG_MEDICO_ID"'; 
END IF; 
END 

;
/
DECLARE 
  C NUMBER; 
BEGIN 
SELECT COUNT(*) INTO C 
FROM ALL_SEQUENCES 
  WHERE SEQUENCE_OWNER = '' 
  AND SEQUENCE_NAME = 'SEQ_MEDICO_ID'; 
  IF (C > 0) THEN 
    EXECUTE IMMEDIATE 'DROP SEQUENCE "SEQ_MEDICO_ID"'; 
END IF; 
END 

;
/
DECLARE 
  C NUMBER; 
BEGIN 
SELECT COUNT(*) INTO C 
FROM ALL_TRIGGERS 
  WHERE OWNER = '' 
  AND TRIGGER_NAME = 'TRG_ORDEN_ID'; 
  IF (C > 0) THEN 
    EXECUTE IMMEDIATE 'DROP TRIGGER "TRG_ORDEN_ID"'; 
END IF; 
END 

;
/
DECLARE 
  C NUMBER; 
BEGIN 
SELECT COUNT(*) INTO C 
FROM ALL_SEQUENCES 
  WHERE SEQUENCE_OWNER = '' 
  AND SEQUENCE_NAME = 'SEQ_ORDEN_ID'; 
  IF (C > 0) THEN 
    EXECUTE IMMEDIATE 'DROP SEQUENCE "SEQ_ORDEN_ID"'; 
END IF; 
END 

;
/
DECLARE 
  C NUMBER; 
BEGIN 
SELECT COUNT(*) INTO C 
FROM ALL_TRIGGERS 
  WHERE OWNER = '' 
  AND TRIGGER_NAME = 'TRG_RESERVAS_ID'; 
  IF (C > 0) THEN 
    EXECUTE IMMEDIATE 'DROP TRIGGER "TRG_RESERVAS_ID"'; 
END IF; 
END 

;
/
DECLARE 
  C NUMBER; 
BEGIN 
SELECT COUNT(*) INTO C 
FROM ALL_SEQUENCES 
  WHERE SEQUENCE_OWNER = '' 
  AND SEQUENCE_NAME = 'SEQ_RESERVAS_ID'; 
  IF (C > 0) THEN 
    EXECUTE IMMEDIATE 'DROP SEQUENCE "SEQ_RESERVAS_ID"'; 
END IF; 
END 

;
/
DECLARE 
  C NUMBER; 
BEGIN 
SELECT COUNT(*) INTO C 
FROM ALL_TRIGGERS 
  WHERE OWNER = '' 
  AND TRIGGER_NAME = 'TRG_ROL_ID'; 
  IF (C > 0) THEN 
    EXECUTE IMMEDIATE 'DROP TRIGGER "TRG_ROL_ID"'; 
END IF; 
END 

;
/
DECLARE 
  C NUMBER; 
BEGIN 
SELECT COUNT(*) INTO C 
FROM ALL_SEQUENCES 
  WHERE SEQUENCE_OWNER = '' 
  AND SEQUENCE_NAME = 'SEQ_ROL_ID'; 
  IF (C > 0) THEN 
    EXECUTE IMMEDIATE 'DROP SEQUENCE "SEQ_ROL_ID"'; 
END IF; 
END 

;
/
DECLARE 
  C NUMBER; 
BEGIN 
SELECT COUNT(*) INTO C 
FROM ALL_TRIGGERS 
  WHERE OWNER = '' 
  AND TRIGGER_NAME = 'TRG_SERVICIO_SALUD_ID'; 
  IF (C > 0) THEN 
    EXECUTE IMMEDIATE 'DROP TRIGGER "TRG_SERVICIO_SALUD_ID"'; 
END IF; 
END 

;
/
DECLARE 
  C NUMBER; 
BEGIN 
SELECT COUNT(*) INTO C 
FROM ALL_SEQUENCES 
  WHERE SEQUENCE_OWNER = '' 
  AND SEQUENCE_NAME = 'SEQ_SERVICIO_SALUD_ID'; 
  IF (C > 0) THEN 
    EXECUTE IMMEDIATE 'DROP SEQUENCE "SEQ_SERVICIO_SALUD_ID"'; 
END IF; 
END 

;
/
DECLARE 
  C NUMBER; 
BEGIN 
SELECT COUNT(*) INTO C 
FROM ALL_TRIGGERS 
  WHERE OWNER = '' 
  AND TRIGGER_NAME = 'TRG_USUARIO_ID'; 
  IF (C > 0) THEN 
    EXECUTE IMMEDIATE 'DROP TRIGGER "TRG_USUARIO_ID"'; 
END IF; 
END 

;
/
DECLARE 
  C NUMBER; 
BEGIN 
SELECT COUNT(*) INTO C 
FROM ALL_SEQUENCES 
  WHERE SEQUENCE_OWNER = '' 
  AND SEQUENCE_NAME = 'SEQ_USUARIO_ID'; 
  IF (C > 0) THEN 
    EXECUTE IMMEDIATE 'DROP SEQUENCE "SEQ_USUARIO_ID"'; 
END IF; 
END 

;
/
DROP TABLE "ADSCRITOS" CASCADE CONSTRAINTS
;

DROP TABLE "AFILIADO" CASCADE CONSTRAINTS
;

DROP TABLE "CITA_MEDICA" CASCADE CONSTRAINTS
;

DROP TABLE "CONSULTA_ESPECIALISTA" CASCADE CONSTRAINTS
;

DROP TABLE "CONSULTA_URGENCIAS" CASCADE CONSTRAINTS
;

DROP TABLE "EPS_ANDES" CASCADE CONSTRAINTS
;

DROP TABLE "HORARIO" CASCADE CONSTRAINTS
;

DROP TABLE "HORAS" CASCADE CONSTRAINTS
;

DROP TABLE "INTERCONSULTAS" CASCADE CONSTRAINTS
;

DROP TABLE "IPS" CASCADE CONSTRAINTS
;

DROP TABLE "LLEGADA" CASCADE CONSTRAINTS
;

DROP TABLE "MEDICO" CASCADE CONSTRAINTS
;

DROP TABLE "MEDICO_ESPECIALISTA" CASCADE CONSTRAINTS
;

DROP TABLE "MEDICO_GENERAL" CASCADE CONSTRAINTS
;

DROP TABLE "MEDICO_SERVICIO" CASCADE CONSTRAINTS
;

DROP TABLE "MEDICO_TRATANTE" CASCADE CONSTRAINTS
;

DROP TABLE "ORDEN" CASCADE CONSTRAINTS
;

DROP TABLE "ORDENES_SERVICIOS" CASCADE CONSTRAINTS
;

DROP TABLE "RECEPCIONISTA" CASCADE CONSTRAINTS
;

DROP TABLE "RESERVAS" CASCADE CONSTRAINTS
;

DROP TABLE "ROL" CASCADE CONSTRAINTS
;

DROP TABLE "SERVICIO_SALUD" CASCADE CONSTRAINTS
;

DROP TABLE "USUARIO" CASCADE CONSTRAINTS
;

CREATE TABLE "ADSCRITOS"
(
	"IDMEDICO" NUMBER(8) NOT NULL,
	"IDIPS" NUMBER(8) NOT NULL
)
;

CREATE TABLE "AFILIADO"
(
	"IDUSUARIO" NUMBER(8) NOT NULL,
	"IDEPS" NUMBER(8) NOT NULL,
	"FECHANACIMIENTO" DATE NOT NULL,
	"TIPODOCUMENTO" VARCHAR2(50) NOT NULL,
	"NUMDOCUMENTO" VARCHAR2(50) NOT NULL,
	"HOSPITALIZADO" NUMBER(1) NOT NULL
)
;

CREATE TABLE "CITA_MEDICA"
(
	"ID" NUMBER(8) NOT NULL,
	"IDMEDICOGENERAL" NUMBER(8) NOT NULL,
	"IDORDEN" NUMBER(8),
	"TIPO" VARCHAR2(20) NOT NULL,
	"DIAGNOSTICO" VARCHAR2(50) NOT NULL
)
;

CREATE TABLE "CONSULTA_ESPECIALISTA"
(
	"ID" NUMBER(8) NOT NULL,
	"IDMEDICOESPECIALISTA" NUMBER(8) NOT NULL,
	"IDORDEN" NUMBER(8) NOT NULL,
	"DIAGNOSTICO" VARCHAR2(50) NOT NULL
)
;

CREATE TABLE "CONSULTA_URGENCIAS"
(
	"ID" NUMBER(8) NOT NULL,
	"IDMEDICOTRATANTE" NUMBER(8) NOT NULL,
	"DIAGNOSTICO" VARCHAR2(50) NOT NULL,
	"PRIORIDADTRIAGE" NUMBER(8) NOT NULL
)
;

CREATE TABLE "EPS_ANDES"
(
	"ID" NUMBER(8) NOT NULL,
	"IDGERENTE" NUMBER(8)
)
;

CREATE TABLE "HORARIO"
(
	"ID" NUMBER(8) NOT NULL,
	"IDSERVICIO" NUMBER(8) NOT NULL,
	"CAPACIDAD" NUMBER(5) NOT NULL,
	"FECHA" DATE NOT NULL,
	"HORA" VARCHAR2(50) NOT NULL
)
;

CREATE TABLE "HORAS"
(
	"ID" NUMBER(8) NOT NULL,
	"HORA" DATE NOT NULL,
	"IDHORARIO" NUMBER(8)
)
;

CREATE TABLE "INTERCONSULTAS"
(
	"IDMEDICOESPECIALISTA" NUMBER(8) NOT NULL,
	"IDURGENCIAS" NUMBER(8) NOT NULL
)
;

CREATE TABLE "IPS"
(
	"ID" NUMBER(8) NOT NULL,
	"IDEPS" NUMBER(8) NOT NULL,
	"NOMBRE" VARCHAR2(50) NOT NULL,
	"TIPO" VARCHAR2(50) NOT NULL,
	"UBICACION" VARCHAR2(50) NOT NULL,
	"CAPACIDAD" NUMBER(8) NOT NULL
)
;

CREATE TABLE "LLEGADA"
(
	"IDRECEPCIONISTA" NUMBER(8) NOT NULL,
	"IDAFILIADO" NUMBER(8) NOT NULL,
	"IDRESERVA" NUMBER(8) NOT NULL
)
;

CREATE TABLE "MEDICO"
(
	"ID" NUMBER(8) NOT NULL,
	"IDROL" NUMBER(8) NOT NULL,
	"NUMREGISTROMEDICO" NUMBER(8) NOT NULL,
	"ESPECIALIDAD" VARCHAR2(50) NOT NULL,
	"IDENTIFICACION" VARCHAR2(50) NOT NULL,
	"NOMBRE" VARCHAR2(50) NOT NULL,
	"CORREO" VARCHAR2(50) NOT NULL
)
;

CREATE TABLE "MEDICO_ESPECIALISTA"
(
	"ID" NUMBER(8) NOT NULL
)
;

CREATE TABLE "MEDICO_GENERAL"
(
	"ID" NUMBER(8) NOT NULL
)
;

CREATE TABLE "MEDICO_SERVICIO"
(
	"IDMEDICO" NUMBER(8) NOT NULL,
	"IDSERVICIO" NUMBER(8) NOT NULL
)
;

CREATE TABLE "MEDICO_TRATANTE"
(
	"ID" NUMBER(8) NOT NULL
)
;

CREATE TABLE "ORDEN"
(
	"ID" NUMBER(8) NOT NULL,
	"IDAFILIADO" NUMBER(8) NOT NULL,
	"IDMEDICO" NUMBER(8) NOT NULL,
	"RECETA" VARCHAR2(50)
)
;

CREATE TABLE "ORDENES_SERVICIOS"
(
	"IDORDEN" NUMBER(8) NOT NULL,
	"IDSERVICIO" NUMBER(8) NOT NULL,
	"REALIZADO" NUMBER(1) NOT NULL
)
;

CREATE TABLE "RECEPCIONISTA"
(
	"ID" NUMBER(8) NOT NULL,
	"IDIPS" NUMBER(8)
)
;

CREATE TABLE "RESERVAS"
(
	"ID" NUMBER(8) NOT NULL,
	"IDAFILIADO" NUMBER(8) NOT NULL,
	"IDSERVICIOSALUD" NUMBER(8) NOT NULL,
	"ESTADO" VARCHAR2(50) NOT NULL
)
;

CREATE TABLE "ROL"
(
	"ID" NUMBER(8) NOT NULL,
	"NOMBRE" VARCHAR2(50) NOT NULL
)
;

CREATE TABLE "SERVICIO_SALUD"
(
	"ID" NUMBER(8) NOT NULL,
	"IDIPS" NUMBER(8) NOT NULL,
	"TIPO" VARCHAR2(50) NOT NULL,
	"ORDEN" NUMBER(1) NOT NULL,
	"DESCRIPCION" VARCHAR2(50) NOT NULL
)
;

CREATE TABLE "USUARIO"
(
	"ID" NUMBER(8) NOT NULL,
	"IDROL" NUMBER(8) NOT NULL,
	"NOMBRE" VARCHAR2(50) NOT NULL,
	"CORREO" VARCHAR2(50) NOT NULL
)
;

CREATE SEQUENCE "SEQ_EPS_ANDES_ID" 
	INCREMENT BY 1 
	START WITH 1 
	NOMAXVALUE 
	MINVALUE  1 
	NOCYCLE 
	NOCACHE 
	NOORDER
;

CREATE OR REPLACE TRIGGER "TRG_EPS_ANDES_ID" 
	BEFORE INSERT 
	ON "EPS_ANDES" 
	FOR EACH ROW 
	BEGIN 
		SELECT "SEQ_EPS_ANDES_ID".NEXTVAL 
		INTO :NEW."ID" 
		FROM DUAL; 
	END
;
/


CREATE SEQUENCE "SEQ_HORARIO_ID" 
	INCREMENT BY 1 
	START WITH 1 
	NOMAXVALUE 
	MINVALUE  1 
	NOCYCLE 
	NOCACHE 
	NOORDER
;

CREATE OR REPLACE TRIGGER "TRG_HORARIO_ID" 
	BEFORE INSERT 
	ON "HORARIO" 
	FOR EACH ROW 
	BEGIN 
		SELECT "SEQ_HORARIO_ID".NEXTVAL 
		INTO :NEW."ID" 
		FROM DUAL; 
	END
;
/


CREATE SEQUENCE "SEQ_HORAS_ID" 
	INCREMENT BY 1 
	START WITH 1 
	NOMAXVALUE 
	MINVALUE  1 
	NOCYCLE 
	NOCACHE 
	NOORDER
;

CREATE OR REPLACE TRIGGER "TRG_HORAS_ID" 
	BEFORE INSERT 
	ON "HORAS" 
	FOR EACH ROW 
	BEGIN 
		SELECT "SEQ_HORAS_ID".NEXTVAL 
		INTO :NEW."ID" 
		FROM DUAL; 
	END
;
/


CREATE SEQUENCE "SEQ_IPS_ID" 
	INCREMENT BY 1 
	START WITH 1 
	NOMAXVALUE 
	MINVALUE  1 
	NOCYCLE 
	NOCACHE 
	NOORDER
;

CREATE OR REPLACE TRIGGER "TRG_IPS_ID" 
	BEFORE INSERT 
	ON "IPS" 
	FOR EACH ROW 
	BEGIN 
		SELECT "SEQ_IPS_ID".NEXTVAL 
		INTO :NEW."ID" 
		FROM DUAL; 
	END
;
/


CREATE SEQUENCE "SEQ_MEDICO_ID" 
	INCREMENT BY 1 
	START WITH 1 
	NOMAXVALUE 
	MINVALUE  1 
	NOCYCLE 
	NOCACHE 
	NOORDER
;

CREATE OR REPLACE TRIGGER "TRG_MEDICO_ID" 
	BEFORE INSERT 
	ON "MEDICO" 
	FOR EACH ROW 
	BEGIN 
		SELECT "SEQ_MEDICO_ID".NEXTVAL 
		INTO :NEW."ID" 
		FROM DUAL; 
	END
;
/


CREATE SEQUENCE "SEQ_ORDEN_ID" 
	INCREMENT BY 1 
	START WITH 1 
	NOMAXVALUE 
	MINVALUE  1 
	NOCYCLE 
	NOCACHE 
	NOORDER
;

CREATE OR REPLACE TRIGGER "TRG_ORDEN_ID" 
	BEFORE INSERT 
	ON "ORDEN" 
	FOR EACH ROW 
	BEGIN 
		SELECT "SEQ_ORDEN_ID".NEXTVAL 
		INTO :NEW."ID" 
		FROM DUAL; 
	END
;
/


CREATE SEQUENCE "SEQ_RESERVAS_ID" 
	INCREMENT BY 1 
	START WITH 1 
	NOMAXVALUE 
	MINVALUE  1 
	NOCYCLE 
	NOCACHE 
	NOORDER
;

CREATE OR REPLACE TRIGGER "TRG_RESERVAS_ID" 
	BEFORE INSERT 
	ON "RESERVAS" 
	FOR EACH ROW 
	BEGIN 
		SELECT "SEQ_RESERVAS_ID".NEXTVAL 
		INTO :NEW."ID" 
		FROM DUAL; 
	END
;
/


CREATE SEQUENCE "SEQ_ROL_ID" 
	INCREMENT BY 1 
	START WITH 1 
	NOMAXVALUE 
	MINVALUE  1 
	NOCYCLE 
	NOCACHE 
	NOORDER
;

CREATE OR REPLACE TRIGGER "TRG_ROL_ID" 
	BEFORE INSERT 
	ON "ROL" 
	FOR EACH ROW 
	BEGIN 
		SELECT "SEQ_ROL_ID".NEXTVAL 
		INTO :NEW."ID" 
		FROM DUAL; 
	END
;
/


CREATE SEQUENCE "SEQ_SERVICIO_SALUD_ID" 
	INCREMENT BY 1 
	START WITH 1 
	NOMAXVALUE 
	MINVALUE  1 
	NOCYCLE 
	NOCACHE 
	NOORDER
;

CREATE OR REPLACE TRIGGER "TRG_SERVICIO_SALUD_ID" 
	BEFORE INSERT 
	ON "SERVICIO_SALUD" 
	FOR EACH ROW 
	BEGIN 
		SELECT "SEQ_SERVICIO_SALUD_ID".NEXTVAL 
		INTO :NEW."ID" 
		FROM DUAL; 
	END
;
/


CREATE SEQUENCE "SEQ_USUARIO_ID" 
	INCREMENT BY 1 
	START WITH 1 
	NOMAXVALUE 
	MINVALUE  1 
	NOCYCLE 
	NOCACHE 
	NOORDER
;

CREATE OR REPLACE TRIGGER "TRG_USUARIO_ID" 
	BEFORE INSERT 
	ON "USUARIO" 
	FOR EACH ROW 
	BEGIN 
		SELECT "SEQ_USUARIO_ID".NEXTVAL 
		INTO :NEW."ID" 
		FROM DUAL; 
	END
;
/


CREATE INDEX "IXFK_ADSCRITOS_IPS"   
 ON "ADSCRITOS" ("IDIPS") 
;

CREATE INDEX "IXFK_ADSCRITOS_MEDICO"   
 ON "ADSCRITOS" ("IDMEDICO") 
;

ALTER TABLE "ADSCRITOS" 
 ADD CONSTRAINT "PK_ADSCRITOS"
	PRIMARY KEY ("IDMEDICO","IDIPS") USING INDEX
;

CREATE INDEX "IXFK_AFILIADO_EPS_ANDES"   
 ON "AFILIADO" ("IDEPS") 
;

CREATE INDEX "IXFK_AFILIADO_USUARIO"   
 ON "AFILIADO" ("IDUSUARIO") 
;

ALTER TABLE "AFILIADO" 
 ADD CONSTRAINT "PK_AFILIADO"
	PRIMARY KEY ("IDUSUARIO") USING INDEX
;

ALTER TABLE "AFILIADO" 
 ADD CONSTRAINT "CK_AFILIADO_NUMDOCUMENTO" UNIQUE ("NUMDOCUMENTO") USING INDEX
;

ALTER TABLE "AFILIADO" 
 ADD CONSTRAINT "CK_AFILIADO_TIPODOCUMENTO" CHECK (TIPODOCUMENTO IN('CC','CE','PA','RC','TI'))
;

ALTER TABLE "AFILIADO" 
 ADD CONSTRAINT "CK_AFILIADO_HOSPITALIZADO" CHECK (HOSPITALIZADO IN (0,1))
;

CREATE INDEX "IXFK_CITA_MEDICA_M_G"   
 ON "CITA_MEDICA" ("IDMEDICOGENERAL") 
;

CREATE INDEX "IXFK_CITA_MEDICA_ORDEN"   
 ON "CITA_MEDICA" ("IDORDEN") 
;

CREATE INDEX "IXFK_CITA_MEDICA_SERVICIO"   
 ON "CITA_MEDICA" ("ID") 
;

ALTER TABLE "CITA_MEDICA" 
 ADD CONSTRAINT "PK_CITA_MEDICA"
	PRIMARY KEY ("ID") USING INDEX
;

ALTER TABLE "CITA_MEDICA" 
 ADD CONSTRAINT "CK_CITA_MEDICA_TIPO" CHECK (TIPO IN( 'INICIAL', 'CONTROL'))
;

CREATE INDEX "IXFK_CONSULTA_ESP_MEDICO_ESP"   
 ON "CONSULTA_ESPECIALISTA" ("IDMEDICOESPECIALISTA") 
;

CREATE INDEX "IXFK_CONSULTA_ESP_ORDEN"   
 ON "CONSULTA_ESPECIALISTA" ("IDORDEN") 
;

CREATE INDEX "IXFK_CONSULTA_ESP_SERVICIO"   
 ON "CONSULTA_ESPECIALISTA" ("ID") 
;

ALTER TABLE "CONSULTA_ESPECIALISTA" 
 ADD CONSTRAINT "PK_CONSULTA_ESPECIALISTA"
	PRIMARY KEY ("ID") USING INDEX
;

CREATE INDEX "IXFK_CONSULTA_URG_MEDICO_01"   
 ON "CONSULTA_URGENCIAS" ("IDMEDICOTRATANTE") 
;

CREATE INDEX "IXFK_CONSULTA_URG_SERVICI01"   
 ON "CONSULTA_URGENCIAS" ("ID") 
;

ALTER TABLE "CONSULTA_URGENCIAS" 
 ADD CONSTRAINT "PK_CONSULTA_URGENCIAS"
	PRIMARY KEY ("ID") USING INDEX
;

ALTER TABLE "CONSULTA_URGENCIAS" 
 ADD CONSTRAINT "CK_CONSULTA_URGENCIAS_P_T" CHECK (PRIORIDADTRIAGE > 0)
;

CREATE INDEX "IXFK_EPS_ANDES_USUARIO"   
 ON "EPS_ANDES" ("IDGERENTE") 
;

ALTER TABLE "EPS_ANDES" 
 ADD CONSTRAINT "PK_EPS_ANDES"
	PRIMARY KEY ("ID") USING INDEX
;

CREATE INDEX "IXFK_HORARIO_SERVICIO_SALUD"   
 ON "HORARIO" ("IDSERVICIO") 
;

ALTER TABLE "HORARIO" 
 ADD CONSTRAINT "PK_HORARIO"
	PRIMARY KEY ("ID") USING INDEX
;

ALTER TABLE "HORARIO" 
 ADD CONSTRAINT "CK_HORARIO_CAPACIDAD" CHECK (CAPACIDAD >= 0)
;

ALTER TABLE "HORARIO" 
 ADD CONSTRAINT "CK_HORARIO_HORA" CHECK (HORA IN('DIURNO', 'VESPERTINO', 'NOCTURNO'))
;

CREATE INDEX "IXFK_HORAS_HORARIO"   
 ON "HORAS" ("IDHORARIO") 
;

ALTER TABLE "HORAS" 
 ADD CONSTRAINT "PK_HORAS"
	PRIMARY KEY ("ID") USING INDEX
;

CREATE INDEX "IXFK_INTERCONSULT_CONSULT01"   
 ON "INTERCONSULTAS" ("IDURGENCIAS") 
;

CREATE INDEX "IXFK_INTERCONSULT_MEDICO_01"   
 ON "INTERCONSULTAS" ("IDMEDICOESPECIALISTA") 
;

ALTER TABLE "INTERCONSULTAS" 
 ADD CONSTRAINT "PK_INTERCONSULT_01"
	PRIMARY KEY ("IDMEDICOESPECIALISTA","IDURGENCIAS") USING INDEX
;

CREATE INDEX "IXFK_IPS_EPS_ANDES"   
 ON "IPS" ("IDEPS") 
;

ALTER TABLE "IPS" 
 ADD CONSTRAINT "PK_IPS"
	PRIMARY KEY ("ID") USING INDEX
;

ALTER TABLE "IPS" 
 ADD CONSTRAINT "CK_IPS_CAPACIDAD" CHECK (CAPACIDAD >0)
;

ALTER TABLE "IPS" 
 ADD CONSTRAINT "CK_IPS_TIPO" CHECK (TIPO IN( 'HOSPITAL', 'CENTRO_DE_ATENCION', 'CENTRO_MEDICO', 'LABORATORIO'))
;

CREATE INDEX "IXFK_LLEGADA_AFILIADO"   
 ON "LLEGADA" ("IDAFILIADO") 
;

CREATE INDEX "IXFK_LLEGADA_RECEPCIONISTA"   
 ON "LLEGADA" ("IDRECEPCIONISTA") 
;

ALTER TABLE "LLEGADA" 
 ADD CONSTRAINT "PK_LLEGADA"
	PRIMARY KEY ("IDRECEPCIONISTA","IDAFILIADO","IDRESERVA") USING INDEX
;

CREATE INDEX "IXFK_MEDICO_ROL"   
 ON "MEDICO" ("IDROL") 
;

ALTER TABLE "MEDICO" 
 ADD CONSTRAINT "PK_MEDICO"
	PRIMARY KEY ("ID") USING INDEX
;

ALTER TABLE "MEDICO" 
 ADD CONSTRAINT "CK_MEDICO_CORREO" UNIQUE ("CORREO") USING INDEX
;

ALTER TABLE "MEDICO" 
 ADD CONSTRAINT "CK_MEDICO_IDENTIFICACION" UNIQUE ("IDENTIFICACION") USING INDEX
;

ALTER TABLE "MEDICO" 
 ADD CONSTRAINT "CK_MEDICO_NUMREGISTROMEDICO" UNIQUE ("NUMREGISTROMEDICO") USING INDEX
;

ALTER TABLE "MEDICO" 
 ADD CONSTRAINT "CK_MEDICO_NUMREGISTROMEDICO>=0" CHECK (NUMREGISTROMEDICO>=0)
;

CREATE INDEX "IXFK_MEDICO_ESPECIALISTA_01"   
 ON "MEDICO_ESPECIALISTA" ("ID") 
;

ALTER TABLE "MEDICO_ESPECIALISTA" 
 ADD CONSTRAINT "PK_MEDICO_ESPECIALISTA"
	PRIMARY KEY ("ID") USING INDEX
;

CREATE INDEX "IXFK_MEDICO_GENERAL_MEDICO"   
 ON "MEDICO_GENERAL" ("ID") 
;

ALTER TABLE "MEDICO_GENERAL" 
 ADD CONSTRAINT "PK_MEDICO_GENERAL"
	PRIMARY KEY ("ID") USING INDEX
;

CREATE INDEX "IXFK_MEDICO_SERVI_SERVICI01"   
 ON "MEDICO_SERVICIO" ("IDSERVICIO") 
;

CREATE INDEX "IXFK_MEDICO_SERVICIO_MEDICO"   
 ON "MEDICO_SERVICIO" ("IDMEDICO") 
;

ALTER TABLE "MEDICO_SERVICIO" 
 ADD CONSTRAINT "PK_MEDICO_SERVICIO"
	PRIMARY KEY ("IDMEDICO","IDSERVICIO") USING INDEX
;

CREATE INDEX "IXFK_MEDICO_TRATANTE_MEDICO"   
 ON "MEDICO_TRATANTE" ("ID") 
;

ALTER TABLE "MEDICO_TRATANTE" 
 ADD CONSTRAINT "PK_MEDICO_TRATANTE"
	PRIMARY KEY ("ID") USING INDEX
;

CREATE INDEX "IXFK_ORDEN_SERVICIO_AFILIADO"   
 ON "ORDEN" ("IDAFILIADO") 
;

CREATE INDEX "IXFK_ORDEN_SERVICIO_MEDICO"   
 ON "ORDEN" ("IDMEDICO") 
;

ALTER TABLE "ORDEN" 
 ADD CONSTRAINT "PK_ORDEN_SERVCIO"
	PRIMARY KEY ("ID") USING INDEX
;

CREATE INDEX "IXFK_ORDENES_SERV_SERVICI01"   
 ON "ORDENES_SERVICIOS" ("IDSERVICIO") 
;

CREATE INDEX "IXFK_ORDENES_SERVICIOS_ORDEN"   
 ON "ORDENES_SERVICIOS" ("IDORDEN") 
;

ALTER TABLE "ORDENES_SERVICIOS" 
 ADD CONSTRAINT "PK_ORDENES_SERVICIOS"
	PRIMARY KEY ("IDORDEN","IDSERVICIO") USING INDEX
;

ALTER TABLE "ORDENES_SERVICIOS" 
 ADD CONSTRAINT "CK_ORDENES_SERVICIOS_REALIZADO" CHECK (REALIZADO IN(0,1,2))
;

CREATE INDEX "IXFK_RECEPCIONISTA_IPS"   
 ON "RECEPCIONISTA" ("IDIPS") 
;

CREATE INDEX "IXFK_RECEPCIONISTA_USUARIO"   
 ON "RECEPCIONISTA" ("ID") 
;

ALTER TABLE "RECEPCIONISTA" 
 ADD CONSTRAINT "PK_RECEPCIONISTA"
	PRIMARY KEY ("ID") USING INDEX
;

CREATE INDEX "IXFK_RESERVAS_AFILIADO"   
 ON "RESERVAS" ("IDAFILIADO") 
;

CREATE INDEX "IXFK_RESERVAS_SERVICIO_SALUD"   
 ON "RESERVAS" ("IDSERVICIOSALUD") 
;

ALTER TABLE "RESERVAS" 
 ADD CONSTRAINT "PK_RESERVAS"
	PRIMARY KEY ("ID","IDAFILIADO","IDSERVICIOSALUD") USING INDEX
;

ALTER TABLE "RESERVAS" 
 ADD CONSTRAINT "CK_RESERVAS_ESTADO" CHECK (ESTADO IN( 'RESERVADO', 'ASISTENCIA', 'CANCELADO'))
;

ALTER TABLE "ROL" 
 ADD CONSTRAINT "PK_ROL"
	PRIMARY KEY ("ID") USING INDEX
;

ALTER TABLE "ROL" 
 ADD CONSTRAINT "CK_ROL_NOMBRE" UNIQUE ("NOMBRE") USING INDEX
;

CREATE INDEX "IXFK_SERVICIO_SALUD_IPS"   
 ON "SERVICIO_SALUD" ("IDIPS") 
;

ALTER TABLE "SERVICIO_SALUD" 
 ADD CONSTRAINT "PK_SERVICIO_SALUD"
	PRIMARY KEY ("ID") USING INDEX
;

ALTER TABLE "SERVICIO_SALUD" 
 ADD CONSTRAINT "CK_SERVICIO_SALUD_TIPO" CHECK (TIPO IN( 'INTERVENCION', 'DIALISIS', 'CIRUGIA_AMBULATORIA', 'CIRUGIA', 'FISIOTERAPIA', 'TERAPIA_OCUPACIONAL', 'IMAGEN_DIAGNOSTICA', 'HOSPITALIZACION', 'EXAMEN_DIAGNOSTICO', 'CITA_MEDICA', 'CONSULTA_ESPECIALISTA','EXAMEN_DE_SANGRE','RADIOGRAFIA','CONSULTA_ODONTOLOGICA','JORNADA_DE_VACUNACION'))
;

ALTER TABLE "SERVICIO_SALUD" 
 ADD CONSTRAINT "CK_SERVICIO_SALUD_ORDEN" CHECK (ORDEN IN (0,1))
;

CREATE INDEX "IXFK_USUARIO_ROL"   
 ON "USUARIO" ("IDROL") 
;

ALTER TABLE "USUARIO" 
 ADD CONSTRAINT "PK_USUARIO"
	PRIMARY KEY ("ID") USING INDEX
;

ALTER TABLE "ADSCRITOS" 
 ADD CONSTRAINT "FK_ADSCRITOS_IPS"
	FOREIGN KEY ("IDIPS") REFERENCES "IPS" ("ID")
;

ALTER TABLE "ADSCRITOS" 
 ADD CONSTRAINT "FK_ADSCRITOS_MEDICO"
	FOREIGN KEY ("IDMEDICO") REFERENCES "MEDICO" ("ID")
;

ALTER TABLE "AFILIADO" 
 ADD CONSTRAINT "FK_AFILIADO_EPS_ANDES"
	FOREIGN KEY ("IDEPS") REFERENCES "EPS_ANDES" ("ID")
;

ALTER TABLE "AFILIADO" 
 ADD CONSTRAINT "FK_AFILIADO_USUARIO"
	FOREIGN KEY ("IDUSUARIO") REFERENCES "USUARIO" ("ID")
;

ALTER TABLE "CITA_MEDICA" 
 ADD CONSTRAINT "FK_CITA_MEDICA_MEDICO_GENERAL"
	FOREIGN KEY ("IDMEDICOGENERAL") REFERENCES "MEDICO_GENERAL" ("ID")
;

ALTER TABLE "CITA_MEDICA" 
 ADD CONSTRAINT "FK_CITA_MEDICA_ORDEN_SERVICIO"
	FOREIGN KEY ("IDORDEN") REFERENCES "ORDEN" ("ID")
;

ALTER TABLE "CITA_MEDICA" 
 ADD CONSTRAINT "FK_CITA_MEDICA_SERVICIO_SALUD"
	FOREIGN KEY ("ID") REFERENCES "SERVICIO_SALUD" ("ID")
;

ALTER TABLE "CONSULTA_ESPECIALISTA" 
 ADD CONSTRAINT "FK_CONSULTA_ESP_MEDICO_ESP"
	FOREIGN KEY ("IDMEDICOESPECIALISTA") REFERENCES "MEDICO_ESPECIALISTA" ("ID")
;

ALTER TABLE "CONSULTA_ESPECIALISTA" 
 ADD CONSTRAINT "FK_CONSULTA_ESP_ORDEN"
	FOREIGN KEY ("IDORDEN") REFERENCES "ORDEN" ("ID")
;

ALTER TABLE "CONSULTA_ESPECIALISTA" 
 ADD CONSTRAINT "FK_CONSULTA_ESP_SERVICIO_SALUD"
	FOREIGN KEY ("ID") REFERENCES "SERVICIO_SALUD" ("ID")
;

ALTER TABLE "CONSULTA_URGENCIAS" 
 ADD CONSTRAINT "FK_CONSULTA_URG_MEDICO_TRAT_01"
	FOREIGN KEY ("IDMEDICOTRATANTE") REFERENCES "MEDICO_TRATANTE" ("ID")
;

ALTER TABLE "CONSULTA_URGENCIAS" 
 ADD CONSTRAINT "FK_CONSULTA_URG_SERVICIO_SA_01"
	FOREIGN KEY ("ID") REFERENCES "SERVICIO_SALUD" ("ID")
;

ALTER TABLE "EPS_ANDES" 
 ADD CONSTRAINT "FK_EPS_ANDES_USUARIO"
	FOREIGN KEY ("IDGERENTE") REFERENCES "USUARIO" ("ID")
;

ALTER TABLE "HORARIO" 
 ADD CONSTRAINT "FK_HORARIO_SERVICIO_SALUD"
	FOREIGN KEY ("IDSERVICIO") REFERENCES "SERVICIO_SALUD" ("ID")
;

ALTER TABLE "INTERCONSULTAS" 
 ADD CONSTRAINT "FK_INTERCONSULT_CONSULTA_UR_01"
	FOREIGN KEY ("IDURGENCIAS") REFERENCES "CONSULTA_URGENCIAS" ("ID")
;

ALTER TABLE "INTERCONSULTAS" 
 ADD CONSTRAINT "FK_INTERCONSULT_MEDICO_ESPE_01"
	FOREIGN KEY ("IDMEDICOESPECIALISTA") REFERENCES "MEDICO_ESPECIALISTA" ("ID")
;

ALTER TABLE "IPS" 
 ADD CONSTRAINT "FK_IPS_EPS_ANDES"
	FOREIGN KEY ("IDEPS") REFERENCES "EPS_ANDES" ("ID")
;

ALTER TABLE "MEDICO" 
 ADD CONSTRAINT "FK_MEDICO_ROL"
	FOREIGN KEY ("IDROL") REFERENCES "ROL" ("ID")
;

ALTER TABLE "MEDICO_ESPECIALISTA" 
 ADD CONSTRAINT "FK_MEDICO_ESPECIALISTA_MEDICO"
	FOREIGN KEY ("ID") REFERENCES "MEDICO" ("ID")
;

ALTER TABLE "MEDICO_GENERAL" 
 ADD CONSTRAINT "FK_MEDICO_GENERAL_MEDICO"
	FOREIGN KEY ("ID") REFERENCES "MEDICO" ("ID")
;

ALTER TABLE "MEDICO_SERVICIO" 
 ADD CONSTRAINT "FK_MEDICO_SERVI_SERVICIO_SA_01"
	FOREIGN KEY ("IDSERVICIO") REFERENCES "SERVICIO_SALUD" ("ID")
;

ALTER TABLE "MEDICO_SERVICIO" 
 ADD CONSTRAINT "FK_MEDICO_SERVICIO_MEDICO"
	FOREIGN KEY ("IDMEDICO") REFERENCES "MEDICO" ("ID")
;

ALTER TABLE "MEDICO_TRATANTE" 
 ADD CONSTRAINT "FK_MEDICO_TRATANTE_MEDICO"
	FOREIGN KEY ("ID") REFERENCES "MEDICO" ("ID")
;

ALTER TABLE "ORDEN" 
 ADD CONSTRAINT "FK_ORDEN_SERVICIO_AFILIADO"
	FOREIGN KEY ("IDAFILIADO") REFERENCES "AFILIADO" ("IDUSUARIO")
;

ALTER TABLE "ORDEN" 
 ADD CONSTRAINT "FK_ORDEN_SERVICIO_MEDICO"
	FOREIGN KEY ("IDMEDICO") REFERENCES "MEDICO" ("ID")
;

ALTER TABLE "ORDENES_SERVICIOS" 
 ADD CONSTRAINT "FK_ORDEN_SERVICIO_SA_01"
	FOREIGN KEY ("IDSERVICIO") REFERENCES "SERVICIO_SALUD" ("ID")
;

ALTER TABLE "ORDENES_SERVICIOS" 
 ADD CONSTRAINT "FK_ORDENES_SERVICIOS_ORDEN"
	FOREIGN KEY ("IDORDEN") REFERENCES "ORDEN" ("ID")
;

ALTER TABLE "RECEPCIONISTA" 
 ADD CONSTRAINT "FK_RECEPCIONISTA_IPS"
	FOREIGN KEY ("IDIPS") REFERENCES "IPS" ("ID")
;

ALTER TABLE "RECEPCIONISTA" 
 ADD CONSTRAINT "FK_RECEPCIONISTA_USUARIO"
	FOREIGN KEY ("ID") REFERENCES "USUARIO" ("ID")
;

ALTER TABLE "RESERVAS" 
 ADD CONSTRAINT "FK_RESERVAS_AFILIADO"
	FOREIGN KEY ("IDAFILIADO") REFERENCES "AFILIADO" ("IDUSUARIO")
;

ALTER TABLE "RESERVAS" 
 ADD CONSTRAINT "FK_RESERVAS_SERVICIO_SALUD"
	FOREIGN KEY ("IDSERVICIOSALUD") REFERENCES "SERVICIO_SALUD" ("ID")
;

ALTER TABLE "SERVICIO_SALUD" 
 ADD CONSTRAINT "FK_SERVICIO_SALUD_IPS"
	FOREIGN KEY ("IDIPS") REFERENCES "IPS" ("ID")
;

ALTER TABLE "USUARIO" 
 ADD CONSTRAINT "FK_USUARIO_ROL"
	FOREIGN KEY ("IDROL") REFERENCES "ROL" ("ID")
;

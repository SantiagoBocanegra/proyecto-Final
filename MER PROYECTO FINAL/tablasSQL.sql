CREATE TABLE LIBRO (
  ISBN SERIAL  NOT NULL ,
  PORTADA BYTEA    ,
  TITULO VARCHAR(60)    ,
  SIPNOSIS VARCHAR(300)    ,
  AUTOR VARCHAR(60)    ,
  EDITORIAL VARCHAR(60)    ,
  FECHA_PUBLICACION DATE    ,
  ESTADO_INVENTARIO VARCHAR(60)    ,
  PRECIO BIGINT     ,
PRIMARY KEY(ISBN));




CREATE TABLE EMPLEADO (
  ID SERIAL  NOT NULL ,
  FOTO BYTEA    ,
  NOMBRE VARCHAR(60)    ,
  SEGUNDO_NOMBRE VARCHAR(60)    ,
  APELLIDO_PATERNO VARCHAR(60)    ,
  APELLIDO_MATERNO VARCHAR(60)    ,
  CEDULA VARCHAR(60)   NOT NULL ,
  DIRECCION VARCHAR(60)    ,
  PAIS VARCHAR(60)    ,
  CIUDAD VARCHAR(60)    ,
  CORREO VARCHAR(60)    ,
  TELEFONO VARCHAR(30)    ,
  FECHA_CONTRATO DATE    ,
  CARGO VARCHAR(60)    ,
  SALARIO BIGINT   ,
PRIMARY KEY(ID));




CREATE TABLE CLIENTE (
  ID SERIAL  NOT NULL ,
  NOMBRE VARCHAR(60)    ,
  SEGUNDO_NOMBRE VARCHAR(60)    ,
  APELLIDO_PATERNO VARCHAR(60)    ,
  APELLIDO_MATERNO VARCHAR(60)    ,
  CEDULA VARCHAR(30)   NOT NULL ,
  DIRECCION VARCHAR(60)    ,
  TELEFONO VARCHAR(60)    ,
  PAIS VARCHAR(60)    ,
  CIUDAD VARCHAR(60)    ,
  CORREO VARCHAR(60)    ,
  FECHA_REGISTRO DATE      ,
PRIMARY KEY(ID));




CREATE TABLE ordenPrestamo (
  numeroOrden SERIAL  NOT NULL ,
  EMPLEADO_ID INTEGER   NOT NULL ,
  CLIENTE_ID INTEGER   NOT NULL ,
  fechaOrden DATE    ,
  fechaEntreha DATE    ,
  cantidadTotal INTEGER      ,
PRIMARY KEY(numeroOrden)    ,
  FOREIGN KEY(CLIENTE_ID)
    REFERENCES CLIENTE(ID),
  FOREIGN KEY(EMPLEADO_ID)
    REFERENCES EMPLEADO(ID));


CREATE INDEX ordenPrestamo_FKIndex1 ON ordenPrestamo (CLIENTE_ID);
CREATE INDEX ordenPrestamo_FKIndex2 ON ordenPrestamo (EMPLEADO_ID);


CREATE INDEX IFK_Rel_10 ON ordenPrestamo (CLIENTE_ID);
CREATE INDEX IFK_Rel_11 ON ordenPrestamo (EMPLEADO_ID);


CREATE TABLE ordenCompra (
  numeroOrden SERIAL  NOT NULL ,
  EMPLEADO_ID INTEGER   NOT NULL ,
  CLIENTE_ID INTEGER   NOT NULL ,
  fechaOrden DATE    ,
  cantidadTotal BIGINT    ,
  precioTotal BIGINT      ,
PRIMARY KEY(numeroOrden)    ,
  FOREIGN KEY(CLIENTE_ID)
    REFERENCES CLIENTE(ID),
  FOREIGN KEY(EMPLEADO_ID)
    REFERENCES EMPLEADO(ID));


CREATE INDEX ordenCompra_FKIndex1 ON ordenCompra (CLIENTE_ID);
CREATE INDEX ordenCompra_FKIndex2 ON ordenCompra (EMPLEADO_ID);


CREATE INDEX IFK_Rel_01 ON ordenCompra (CLIENTE_ID);
CREATE INDEX IFK_Rel_03 ON ordenCompra (EMPLEADO_ID);


CREATE TABLE ordenItem (
  ordenCompra_numeroOrden INTEGER   NOT NULL ,
  LIBRO_ISBN INTEGER   NOT NULL ,
  cantidadOrden INTEGER    ,
  valorOrden BIGINT      ,
PRIMARY KEY(ordenCompra_numeroOrden, LIBRO_ISBN)    ,
  FOREIGN KEY(ordenCompra_numeroOrden)
    REFERENCES ordenCompra(numeroOrden),
  FOREIGN KEY(LIBRO_ISBN)
    REFERENCES LIBRO(ISBN));


CREATE INDEX ordenCompra_has_LIBRO_FKIndex1 ON ordenItem (ordenCompra_numeroOrden);
CREATE INDEX ordenCompra_has_LIBRO_FKIndex2 ON ordenItem (LIBRO_ISBN);


CREATE INDEX IFK_Rel_07 ON ordenItem (ordenCompra_numeroOrden);
CREATE INDEX IFK_Rel_08 ON ordenItem (LIBRO_ISBN);


CREATE TABLE ordenItemPrestamo (
  LIBRO_ISBN INTEGER   NOT NULL ,
  ordenPrestamo_numeroOrden INTEGER   NOT NULL ,
  estadoLibro VARCHAR(60)    ,
  estadoOrden VARCHAR(60)      ,
PRIMARY KEY(LIBRO_ISBN, ordenPrestamo_numeroOrden)    ,
  FOREIGN KEY(LIBRO_ISBN)
    REFERENCES LIBRO(ISBN),
  FOREIGN KEY(ordenPrestamo_numeroOrden)
    REFERENCES ordenPrestamo(numeroOrden));


CREATE INDEX LIBRO_has_ordenPrestamo_FKIndex1 ON ordenItemPrestamo (LIBRO_ISBN);
CREATE INDEX LIBRO_has_ordenPrestamo_FKIndex2 ON ordenItemPrestamo (ordenPrestamo_numeroOrden);


CREATE INDEX IFK_Rel_Orden_prestamo_01 ON ordenItemPrestamo (LIBRO_ISBN);
CREATE INDEX IFK_Rel_Orden_prestamo_02 ON ordenItemPrestamo (ordenPrestamo_numeroOrden);




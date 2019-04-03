create table PRODUCTOS
(
  ID_PRUDUCTO     int auto_increment
    primary key,
  CODIGO_PRODUCTO varchar(18) default '0' not null,
  NOMBRE          varchar(20)             null,
  DESCRIPCION     varchar(120)            null,
  CANTIDAD        int default 0 not null,
  ACTIVO          binary(1)               not null,
  constraint CODIGO_PRODUCTO_index
    unique (CODIGO_PRODUCTO)
) charset = utf8;

-- INSERT INTO PRODUCTOS(CODIGO_PRODUCTO, NOMBRE, DESCRIPCION, CANTIDAD, ACTIVO) VALUES ( 'CP-1','Pinza','Pinsa mecanica',1,true );
CREATE TABLE "orden" (
  id_orden serial NOT NULL,
  fecha timestamp without time zone NOT NULL,
  estado VARCHAR(45) NOT NULL,
  fk_producto_id INTEGER NOT NULL,
  PRIMARY KEY (id_orden));

CREATE TABLE "producto" (
  id_producto serial NOT NULL,
  descripcion VARCHAR(45) NOT NULL,
  cantidad INTEGER NOT NULL,
  valor INTEGER NOT NULL,
  PRIMARY KEY (id_producto));

  CREATE TABLE "venta" (
  id_venta serial NOT NULL,
  total INTEGER NOT NULL,
  fecha_v timestamp without time zone NOT NULL,
  fk_orden_id INTEGER NOT NULL,
  PRIMARY KEY (id_venta));

    ALTER TABLE "venta" ADD CONSTRAINT fk_orden_id
    FOREIGN KEY (fk_orden_id)
    REFERENCES "orden" (id_orden);

    ALTER TABLE "orden" ADD CONSTRAINT fk_producto_id
    FOREIGN KEY (fk_producto_id)
    REFERENCES "producto" (id_producto);



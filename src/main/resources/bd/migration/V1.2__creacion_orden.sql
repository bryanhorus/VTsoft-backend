CREATE TABLE "orden_producto"(
    fk_orden INTEGER NOT NULL,
    fk_producto INTEGER NOT NULL
);

    ALTER TABLE "orden_producto" ADD CONSTRAINT fk_orden
    FOREIGN KEY (fk_orden)
    REFERENCES "orden" (id_orden);

    ALTER TABLE "orden_producto" ADD CONSTRAINT fk_producto
    FOREIGN KEY (fk_producto)
    REFERENCES "producto" (id_producto);



BEGIN;

CREATE TABLE gomitas (
	id integer NOT NULL,
	nombre character varying(50) NULL DEFAULT '',
	marca character varying(50) NULL DEFAULT '',
	precio integer NULL DEFAULT 0
);
COMMENT ON TABLE gomitas IS 'Tabla para las gomitas';
COMMENT ON TABLE gomitas.id IS 'Identificador de las gomitas';
COMMENT ON TABLE gomitas.nombre IS 'Nombre de las gomitas';
COMMENT ON TABLE gomitas.marca IS 'Marca de las gomitas';
COMMENT ON TABLE gomitas.precio IS 'Precio de las gomitas';
CREATE SEQUENCE gomitas_id_seq
	START WITH 1
	INCREMENT BY 1
	NO MINVALUE
	NO MAXVALUE
	CACHE 1;
	
COMMIT;
	
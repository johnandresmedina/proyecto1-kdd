INSERT INTO LLAMADA 
SELECT 
CLLAMADA.fecha_inicio,
DCLIENTE.sk_cliente, 
DDEMOGRAFIA.sk_demografia,
DSIM.sk_sim_card,
DPLAN.sk_plan_voz,
COPERADOR.nombre,
CLLAMADA.utilizo_roaming,
SELECT TIME '00:05:00'::TEXT

FROM 
COLMOVIL.CLIENTE AS CCLIENTE, 
COLMOVIL.LLAMADA AS CLLAMADA, 
COLMOVIL.CONTRATO AS CCONTRATO, 
COLMOVIL.OPERADOR AS COPERADOR,
COLMOVIL_DWH.CLIENTE AS DCLIENTE,
COLMOVIL_DWH.DEMOGRAFIA AS DDEMOGRAFIA,
COLMOVIL_DWH.SIM_CARD AS DSIM,
COLMOVIL_DWH.PLAN_VOZ AS DPLAN

WHERE CCLIENTE.idcliente = CCONTRATO.id_cliente 
AND CLLAMADA.id_contrato = CCONTRATO.id_contrato 
AND CLLAMADA.id_operador_destino = COPERADOR.id_operador
AND CCLIENTE.numero_identificacion = DCLIENTE.numero_id
AND CCLIENTE.estado_civil = DDEMOGRAFIA.estado_civil
AND CCLIENTE.estrato = DDEMOGRAFIA.estrato
AND CCLIENTE.genero = DDEMOGRAFIA.genero
AND CCONTRATO.id_plan_voz = DPLAN.id_plan_voz
AND CCONTRATO.id_sim_card = DSIM.id_sim_card
;


/*CREATE VIEW COLMOVIL.DATOS_LLAMADA AS (
SELECT 
CLIENTE.numero_identificacion, 
CLIENTE.estrato, 
CLIENTE.genero, 
CLIENTE.estado_civil, 
LLAMADA.fecha_inicio, 
LLAMADA.fecha_finalizacion, 
LLAMADA.utilizo_roaming, 
CONTRATO.id_sim_card, 
CONTRATO.id_plan_voz, 
OPERADOR.nombre 
FROM COLMOVIL.CLIENTE, COLMOVIL.LLAMADA, COLMOVIL.CONTRATO, COLMOVIL.OPERADOR 
WHERE CLIENTE.idcliente = CONTRATO.id_cliente 
AND LLAMADA.id_contrato = CONTRATO.id_contrato 
AND LLAMADA.id_operador_destino = OPERADOR.id_operador);

CREATE OR REPLACE FUNCTION Script_Llamadas() RETURNS VOID AS $$

DECLARE
	numero_identificacion int = 0;
	estrato VARCHAR(100) = '';
	genero VARCHAR(100) = '';
	estado_civil VARCHAR(100) = '';
	fecha_inicio TIMESTAMP;
	fecha_finalizacion TIMESTAMP;
	utilizo_roaming VARCHAR(25);
	id_sim_card BIGINT = 0;
	id_plan_voz BIGINT = 0;
	nombre VARCHAR (50) = '';
BEGIN
    
    id_cliente = (SELECT id_sim_card FROM COLMOVIL.DATOS_LLAMADA WHERE id_sim_card = 11);
    
END;
$$ LANGUAGE plpgsql;

SELECT somefunc();
*/

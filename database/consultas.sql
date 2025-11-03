-- SCRIPT: Consultas de Ejemplo
-- Sistema de Gestión de Restaurante

-- Ver todos los clientes
SELECT * FROM CLIENTE;

-- Ver todos los platos
SELECT * FROM PLATO ORDER BY PRECIO DESC;

-- Ver estado de las mesas
SELECT NUMERO_MESA, CAPACIDAD, ESTADO FROM MESA;

-- Pedidos con información del cliente
SELECT 
    P.COD_PEDIDO,
    P.FECHA_PEDIDO,
    C.NOMBRE AS CLIENTE,
    M.NUMERO_MESA
FROM PEDIDO P
JOIN CLIENTE C ON P.COD_CLIENTE = C.COD_CLIENTE
JOIN MESA M ON P.COD_MESA = M.COD_MESA;
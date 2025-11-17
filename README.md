# Sistema de Gestión de Restaurante - Oracle 11g

Base de datos para administración de restaurante implementada en Oracle 11g con conexión Java.

## Integrantes del Grupo

- Michael Fernandez
- Jhon Malpartida
- Carlos Andia

## Descripción del Proyecto

Sistema de base de datos diseñado para gestionar las operaciones de un restaurante, incluyendo:

- **Gestión de Clientes**: Registro y control de información de clientes con operaciones CRUD completas
- **Control de Mesas**: Administración de mesas con capacidad y estados
- **Registro de Pedidos**: Sistema de pedidos vinculado a clientes y mesas
- **Catálogo de Platos**: Menú con precios y detalles
- **Detalle de Pedidos**: Relación entre pedidos y platos solicitados
- **Validaciones**: Constraints para garantizar integridad de datos
- **Optimización**: Índices para mejorar rendimiento de consultas

## Tecnologías Utilizadas

- **Oracle Database 11g Express Edition**
- **SQL*Plus** - Herramienta de línea de comandos
- **Java** - Lenguaje de programación para la aplicación
- **Oracle JDBC Driver** (ojdbc8.jar) - Conector Java-Oracle
- **Visual Studio Code** - Editor de código

## Estructura del Proyecto
```
tarea/
├── README.md              # Este archivo
├── .gitignore            # Archivos a ignorar por Git
├── docs/                 # Documentación
│   ├── instalacion.md
│   ├── conexion.md
│   └── screenshots/      # Capturas de pantalla
├── database/             # Scripts SQL
│   ├── schema.sql        # Limpieza de tablas
│   ├── tablas.sql        # Creación de tablas con constraints e índices
│   ├── datos.sql         # Datos de ejemplo
│   └── consultas.sql     # Consultas de prueba
├── diagrams/             # Diagramas
│   ├── Imagen1.png       # Diagrama Entidad-Relación parte 1
│   └── Imagen2.png       # Diagrama Entidad-Relación parte 2
└── app/                  # Aplicación Java
    ├── Conexion.java          # Clase de conexión a BD
    ├── ClienteDAO.java        # Operaciones CRUD de clientes
    ├── ConexionRestaurante.java  # Clase principal con menú
    └── lib/
        └── ojdbc8.jar    # Driver JDBC
```

## Modelo de Base de Datos

### Entidades Principales

1. **CLIENTE** - Información de los clientes del restaurante
2. **MESA** - Mesas disponibles con capacidad y estado
3. **PLATO** - Menú de platos con precios
4. **PEDIDO** - Pedidos realizados por clientes
5. **DETALLE_PEDIDO** - Items específicos de cada pedido

### Diagrama Entidad-Relación

![Diagrama ER Parte 1](diagrams/Imagen1.png)
![Diagrama ER Parte 2](diagrams/Imagen2.png)

## Instalación y Configuración

### Requisitos Previos

- Windows 10/11
- Oracle Database 11g Express Edition
- Java Development Kit (JDK) 8 o superior
- SQL*Plus (incluido con Oracle)

### Pasos de Instalación

1. Descargar e instalar Oracle 11g XE
2. Configurar contraseña de administrador (recomendado: SYSTEM o ORACLE)
3. Verificar que el servicio OracleServiceXE esté activo
4. Conectar mediante SQL*Plus

## Configuración de Base de Datos

### Opción 1: Ejecutar scripts por separado
```bash
# 1. Conectar a SQL*Plus
sqlplus system/tu_contraseña

# 2. Ejecutar scripts en orden
@database/schema.sql
@database/tablas.sql
@database/datos.sql
```

### Opción 2: Desde CMD (sin abrir SQL*Plus)
```bash
sqlplus system/tu_contraseña @database/schema.sql
sqlplus system/tu_contraseña @database/tablas.sql
sqlplus system/tu_contraseña @database/datos.sql
```

### Verificar instalación
```bash
sqlplus system/tu_contraseña @database/consultas.sql
```

## Aplicación Java

La aplicación está estructurada en 3 clases para mejor organización:

- **Conexion.java**: Maneja la conexión a la base de datos
- **ClienteDAO.java**: Implementa operaciones CRUD (Crear, Leer, Actualizar, Eliminar)
- **ConexionRestaurante.java**: Clase principal con menú interactivo

### Configuración

El driver JDBC (ojdbc8.jar) está incluido en `app/lib/`

### Compilar
```bash
javac -cp "app/lib/ojdbc8.jar" app/Conexion.java
javac -cp "app/lib/ojdbc8.jar" app/ClienteDAO.java
javac -cp "app/lib/ojdbc8.jar" app/ConexionRestaurante.java
```

### Ejecutar

**Windows:**
```bash
java -cp "app/lib/ojdbc8.jar;app" ConexionRestaurante
```

**Linux/Mac:**
```bash
java -cp "app/lib/ojdbc8.jar:app" ConexionRestaurante
```

## Capturas de Pantalla

### Constraints e Índices Implementados

![Constraints e Índices 1](docs/screenshots/constraints_indices.png)
![Constraints e Índices 2](docs/screenshots/constraints_indices2.png)

### Código Java Implementado

#### Clase Conexion.java
![Código Conexión](docs/screenshots/codigo_conexion_clientedao.png)

#### Clase ClienteDAO.java
![Código ClienteDAO](docs/screenshots/codigo_conexion_clientedao2.png)

#### Clase ConexionRestaurante.java (Menú Principal)
![Código Principal 1](docs/screenshots/codigo_conexion_restaurante.png)
![Código Principal 2](docs/screenshots/codigo_conexion_restaurante2.png)

### Demostración de Operaciones CRUD

#### Agregar Clientes

![Agregar Cliente - Michael Fernandez](docs/screenshots/agregar_clientes.png)
![Agregar Cliente - Carlos Andia](docs/screenshots/agregar_clientes2.png)
![Agregar Cliente - John Malpartida](docs/screenshots/agregar_clientes3.png)

#### Visualizar Clientes

**En Aplicación Java:**
![Visualizar en Java](docs/screenshots/visualizar_clientes_java_bd.png)

**En Base de Datos Oracle:**
![Visualizar en BD](docs/screenshots/visualizar_clientes_java_bd2.png)

#### Modificar Cliente

![Modificar Cliente (John Malpartida → Lorena Gonzales)](docs/screenshots/modificar_cliente.png)
![Verificación de Modificación](docs/screenshots/modificar_cliente2.png)

#### Eliminar Cliente

![Eliminar Cliente (código 6)](docs/screenshots/eliminar_cliente.png)
![Verificación de Eliminación](docs/screenshots/eliminar_cliente2.png)

### Conexión SQL*Plus

![Conexión SQL*Plus 1](docs/screenshots/Imagen5.png)
![Conexión SQL*Plus 2](docs/screenshots/Imagen6.png)

### Aplicación Java en Ejecución

![Resultado Java 1](docs/screenshots/Imagen3.png)
![Resultado Java 2](docs/screenshots/Imagen4.png)

## Solución de Problemas

### Error: Oracle service no está corriendo

1. Presionar Win + R
2. Escribir: `services.msc`
3. Buscar: OracleServiceXE
4. Clic derecho → Iniciar

### Error de conexión JDBC

- Verificar puerto: 1521
- Usuario: system
- Service Name: XE
- Hostname: localhost

### Error: TNS no listener
```bash
# Verificar que el listener esté corriendo
lsnrctl status
lsnrctl start
```

## Características Implementadas

### Base de Datos
- Instalación y configuración de Oracle 11g
- Conexión mediante SQL*Plus
- Diseño de esquema normalizado
- Diagrama Entidad-Relación completo
- Creación de tablas con relaciones (Foreign Keys)
- Constraints de validación (CHECK)
- Constraints de unicidad (UNIQUE)
- Índices para optimización de consultas
- Inserción de datos de prueba

### Aplicación Java
- Arquitectura en capas (Conexión, DAO, Main)
- Conexión JDBC con Oracle
- Operaciones CRUD completas:
  - **Create**: Agregar nuevos clientes
  - **Read**: Listar todos los clientes
  - **Update**: Modificar nombre de cliente
  - **Delete**: Eliminar cliente por código
- Menú interactivo de consola
- Manejo de excepciones
- Prepared Statements para seguridad

## Coordinador del Repositorio

Carlos Andia - Organización y documentación del proyecto GitHub

---

**Proyecto Académico** - Base de Datos | Tecsup | Noviembre 2025
# API REST de Participantes y Clases

Este proyecto implementa una API REST para gestionar participantes y clases, con una relación N:1 entre ellos.

## Tecnologías utilizadas

- Java 21
- Spring Boot 3.4.3
- Spring Data JPA
- MySQL
- Gradle

## Estructura de la base de datos

- **Clase**: Entidad que representa una clase o curso
    - id: Identificador único
    - descripcion: Nombre o descripción de la clase
    - poo: Indica si la clase es de programación orientada a objetos
    - participantes: Lista de participantes en esta clase

- **Participante**: Entidad que representa a un participante
    - id: Identificador único
    - nombre: Nombre del participante
    - email: Correo electrónico del participante
    - observaciones: Comentarios adicionales
    - clase: Clase a la que pertenece el participante

## Endpoints de la API

### Clases

- `GET /api/clases`: Obtener todas las clases
- `GET /api/clases?nombre=valor`: Buscar clases por nombre o parte del nombre
- `GET /api/clases/{id}`: Obtener una clase por su ID
- `POST /api/clases`: Crear una nueva clase
- `PUT /api/clases/{id}`: Actualizar una clase existente
- `DELETE /api/clases/{id}`: Eliminar una clase

### Participantes

- `GET /api/participantes`: Obtener todos los participantes
- `GET /api/participantes/{id}`: Obtener un participante por su ID
- `GET /api/participantes/clase/{claseId}`: Obtener participantes por ID de clase
- `POST /api/participantes`: Crear un nuevo participante
- `PUT /api/participantes/{id}`: Actualizar un participante existente
- `DELETE /api/participantes/{id}`: Eliminar un participante

## Configuración y ejecución

1. Clone el repositorio:
   ```
   git clone https://github.com/usuario/participantes-api.git
   cd participantes-api
   ```

2. Configure la base de datos MySQL en `application.properties`

3. Ejecute la aplicación con Gradle:
   ```
   ./gradlew bootRun
   ```

4. La API estará disponible en `http://localhost:8080`
5. No se agrega spripts de sql ya que contiene datos personales.
6. Se pueden utilizar los siguientes scripts:
7. -- Conectarse a la base de datos
   USE participantes_db;

-- Insertar una clase
INSERT INTO clases (descripcion, poo)
VALUES ('Programación Avanzada en Java', true);

-- Verificar que la clase se creó correctamente y obtener su ID
SELECT * FROM clases;

-- Insertar un participante asociado a la clase (asumiendo que el ID de la clase es 1)
INSERT INTO participantes (nombre, email, observaciones, clase_id)
VALUES ('Juan Pérez', 'juan.perez@example.com', 'Estudiante destacado con experiencia en desarrollo web', 1);
-- *Se uso a Jun Perez con anterioridad y se borro el id 1*
-- Verificar que el participante se creó correctamente
SELECT * FROM participantes;

-- Consulta para ver el participante con su clase
SELECT p.id, p.nombre, p.email, p.observaciones, c.descripcion as clase_descripcion, c.poo
FROM participantes p
JOIN clases c ON p.clase_id = c.id;
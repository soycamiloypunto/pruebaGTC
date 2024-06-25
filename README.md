1- Usted ha sido contratado en la Institución Educativa “El Futuro del Saber” para desarrollar
una aplicación que maneje la información básica de los estudiantes y docentes. La
información que se maneja es la siguiente:
A. Estudiante: individuo que se matricula en un año lectivo con un docente, en este caso
se asume que un docente es el encargado (director) de un grupo.
B. Un estudiante puede ver varias asignaturas y una asignatura puede ser vista por
muchos estudiantes.
C. Una asignatura es dictada por un sólo docente, pero un docente puede dictar varias
asignaturas (es una institución pequeña).
D. De un estudiante se tiene la siguiente información: tipo de documento de identidad,
número de identidad, nombres, apellidos, fecha de nacimiento, grado en el que está
matriculado, ciudad de residencia, dirección de residencia, email, teléfono fijo, celular,
nombre completo acudiente/padre.
E. De un docente se tiene la información: tipo de documento de identidad, número de
identidad, nombres, apellidos, fecha de nacimiento, asignatura(s) dictada(s), último
grado de escolaridad (pregrado, postgrado, etc.), grado del que es responsable
(director), email, teléfono fijo, celular.

2- Se debe realizar el modelo E-R de la base de datos teniendo en cuenta las entidades,
atributos, relaciones entre ellas y conceptos de normalización. Este punto lo puede realizar
de forma manual en hojas físicas.
3- Se debe realizar la conexión a la base de datos:

Host: localhost
Database o Schema: institucion
Port (Puerto): 3306
User: root
Password: root

4- Realizar una pequeña aplicación en Java para la manipulación de la información de la base
de datos suministrada en el punto anterior. La aplicación debe permitir realizar el CRUD para
los registros de las tablas de la base de datos.

5- Escriba un SQL que permita obtener información de los cursos cuyos estudiantes tengan la
nota por encima de 3.1, listar los estudiantes en orden ascendente según la nota. La
información que se debe mostrar es:
● Nombre del docente
● Nombre del curso
● Nombre del estudiante
● Nota del estudiante

Respuesta: 
SELECT docente.nombres AS 'Nombre del docente',
       asignatura.nombre AS 'Nombre del curso',
       estudiante.nombres AS 'Nombre del estudiante',
       asignatura.nota AS 'Nota del estudiante'
FROM Estudiante
INNER JOIN asignatura ON asignatura.estudiante_id = estudiante.id
INNER JOIN docente ON asignatura.docente_id = docente.id
WHERE asignatura.nota > 3.1
ORDER BY asignatura.nota ASC;


6- Escriba un SQL que permita obtener información del estudiante que tenga la mayor nota
durante el periodo. La información que se debe mostrar es:
● Nombre del docente
● Nombre del curso
● Nombre del estudiante
● Nota del estudiante

Respuesta: 
SELECT docente.nombres AS 'Nombre del docente',
       asignatura.nombre AS 'Nombre del curso',
       estudiante.nombres AS 'Nombre del estudiante',
       MAX(asignatura.nota) AS 'Nota del estudiante'
FROM Estudiante
INNER JOIN asignatura ON asignatura.estudiante_id = estudiante.id
INNER JOIN docente ON asignatura.docente_id = docente.id
WHERE asignatura.nota > 3.1
ORDER BY asignatura.nota ASC;



Notas: La base de datos está creada en MySQL, el IDE de Java a utilizar será el de su
preferencia, según sus destrezas se podrá realizar instalaciones y usos de librerías extras
según desee. El aspirante tiene la libertad de utilizar cualquiera de las herramientas para la
generación de las clases, también se da expresa libertad de usar cualquier framework, puede
basarse en cualquier tipo arquitectura y modelos que mejoren la seguridad, DAOS de forma
automática o si prefiere las puede crear de forma manual.
Al finalizar la prueba el aspirante comprimir por favor en un archivo el mer (Modelo Entidad
Relación), el proyecto Java junto con una captura de pantalla y los SQLS.
IMPORTANTE: Dentro de los scripts SQL debe contener los scripts de generación de
estructura de la DB y de ser posible, scripts de inserción de data de prueba.
La prueba debe hacerse con la cámara encendida, en un lugar en silencio donde solamente
podrá estar la persona que vaya a presentar la prueba y durará 4 horas máximo.

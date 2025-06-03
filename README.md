# Documentación de la Aplicación de Venta y Gestión de Paquetes de Viaje

## Descripción General
Aplicación para la venta y gestión de paquetes de viaje, desarrollada con patrones MVC, DAO y Singleton, y utilizando la metodología Scrum para un desarrollo ágil y organizado. Permite registrar, administrar y personalizar paquetes turísticos incluyendo actividades, alojamientos y vuelos.

---

## Estructura del Proyecto

```plaintext
/
├── build/               # Archivos compilados y salida de build
│   ├── classes/         # Clases compiladas organizadas por paquetes
│   │   ├── conexion/    # Clases para manejo de conexión a base de datos
│   │   ├── controllers/ # Controladores de la aplicación (MVC)
│   │   ├── dao/         # Objetos de acceso a datos (DAO)
│   │   ├── dto/         # Objetos de transferencia de datos (DTO)
│   │   ├── formato/     # Clases utilitarias para formatos y encriptación
│   │   ├── interfaces/  # Interfaces para DAO y controladores
│   │   ├── mvc/         # Clases relacionadas a la arquitectura MVC
│   │   ├── ob/          # Objetos de negocio
│   │   ├── process/     # Lógica de negocio y procesos
│   │   └── views/       # Vistas de la aplicación
│   └── built-jar.properties # Configuración del build
├── db/                  # Scripts y archivos relacionados a la base de datos
├── imagenes/            # Imágenes usadas en la aplicación
├── nbproject/           # Archivos de configuración del IDE NetBeans
├── src/                 # Código fuente principal
├── build.xml            # Archivo de configuración de Apache Ant para el build
└── manifest.mf          # Archivo de manifiesto del proyecto
```

---

## Funcionalidades Principales

- Registro y administración de paquetes turísticos.
- Gestión de actividades, alojamientos y vuelos asociados a cada paquete.
- Personalización de paquetes según preferencias del cliente.
- Inicio de sesión y control de usuarios.
- Visualización y listado de paquetes disponibles.
- Manejo de datos persistentes mediante DAO para una separación clara de la lógica de acceso a datos.

---

## Metodología Scrum aplicada

El desarrollo de esta aplicación se ha realizado bajo un enfoque ágil con la metodología Scrum, que incluye:

- **Sprints**: Iteraciones cortas y enfocadas para entrega continua de funcionalidades.
- **Reuniones diarias (Daily Scrum)**: Seguimiento diario para coordinar el avance.
- **Roles definidos**: Product Owner, Scrum Master y equipo de desarrollo.
- **Revisión y retrospectiva**: Al finalizar cada sprint, revisión de avances y mejoras para el siguiente ciclo.

Este enfoque permitió adaptar los requerimientos durante el desarrollo y mejorar la comunicación entre los miembros del equipo.

---

## Resumen de Reuniones del Proyecto

Las reuniones del equipo se realizaron principalmente los fines de semana, especialmente los viernes en la noche, para aprovechar los momentos de mayor disponibilidad de los miembros. Durante estas sesiones, se revisaron los avances en las distintas áreas del proyecto, incluyendo el desarrollo de los módulos DAO y DTO, la lógica de negocio en el directorio `process`, y la implementación de las interfaces y vistas.

Se dedicó tiempo a discutir mejoras en la modularización del código, así como en la validación de datos para garantizar la robustez del sistema. También se revisaron detalles de usabilidad en los formularios y la experiencia del usuario para facilitar la interacción con la aplicación.

Además, se definieron tareas concretas para la siguiente semana, asignando responsabilidades claras y planificando un seguimiento regular para mantener el ritmo y la calidad del desarrollo.

En general, estas reuniones fueron productivas y contribuyeron a alinear al equipo, resolver dudas técnicas y avanzar de manera coordinada hacia los objetivos del proyecto.


## Patrones de Diseño Utilizados

- **MVC (Modelo-Vista-Controlador)**: Para separar la lógica de negocio, presentación y control de flujo, facilitando la mantenibilidad y escalabilidad.
- **DAO (Data Access Object)**: Para abstraer y encapsular todas las operaciones con la base de datos, permitiendo un cambio sencillo en la fuente de datos si es necesario.
- **Singleton**: Para garantizar que ciertas clases, como la conexión a la base de datos, tengan una única instancia durante la ejecución.

---

## Documentación de Controladores (`./src/controllers`)

Esta carpeta contiene las clases encargadas de controlar la lógica de la aplicación en la capa de control, coordinando la interacción entre la vista y el modelo.

### Archivos y Descripción

| Archivo                 | Tamaño (bytes) | Descripción                                                                                  |
|------------------------|----------------|----------------------------------------------------------------------------------------------|
| `CCrearActividad.java`    | 3,268          | Controlador para gestionar la creación y registro de actividades dentro de los paquetes.      |
| `CCrearAlojamiento.java`  | 3,472          | Controlador responsable de manejar la creación y registro de alojamientos.                    |
| `CCrearPaquete.java`      | 11,376         | Controlador principal para la creación, validación y registro de paquetes turísticos completos. |
| `CCrearVuelo.java`        | 3,121          | Controlador que gestiona la creación y asignación de vuelos en los paquetes.                   |
| `CListar.java`            | 2,159          | Controlador para listar diferentes entidades, como paquetes, actividades, alojamientos, etc.  |
| `CLogin.java`             | 4,655          | Controlador encargado del proceso de autenticación de usuarios.                              |
| `CMenu.java`              | 7,031          | Controlador que administra la navegación y el menú principal de la aplicación.                |
| `CMisPaquetes.java`       | 7,751          | Controlador que permite a los usuarios ver y gestionar sus paquetes turísticos personalizados.|
| `CPaquetePersonalizado.java` | 2,531          | Controlador para la creación y manejo de paquetes turísticos personalizados por el usuario.   |
| `CRegistro.java`          | 2,307          | Controlador que maneja el registro de nuevos usuarios en el sistema.                         |
| `CSelecionarActividad.java` | 4,605          | Controlador para la selección y asignación de actividades a un paquete.                       |
| `CSelecionarAlojamiento.java` | 4,815          | Controlador para la selección y asignación de alojamientos a un paquete.                      |
| `CSelecionarVuelo.java`   | 4,515          | Controlador para la selección y asignación de vuelos a un paquete.                           |
| `CVerPaquetes.java`       | 5,756          | Controlador que permite la visualización detallada de paquetes turísticos disponibles.       |

## Documentación de la Carpeta `./src/dao`

Los **DAO (Data Access Object)** son responsables de la comunicación con la base de datos. Proveen métodos para realizar operaciones CRUD (Crear, Leer, Actualizar, Eliminar) y consultas específicas sobre las entidades del sistema.

### Archivos y Descripción

| Archivo             | Tamaño (bytes) | Descripción                                                                                   |
|---------------------|----------------|-----------------------------------------------------------------------------------------------|
| `ActividadDAO.java`  | 5,272          | Acceso a datos para la entidad Actividad, gestión de actividades en la base de datos.         |
| `AlojamientoDAO.java`| 5,435          | Acceso a datos para la entidad Alojamiento, manejo de registros de alojamientos.              |
| `AvionDAO.java`      | 2,205          | DAO para la entidad Avión, gestiona vuelos y aeronaves.                                      |
| `CategoriaDAO.java`  | 2,311          | Acceso a datos para categorías de paquetes o actividades.                                    |
| `ClienteDAO.java`    | 1,637          | Manejo de datos para la entidad Cliente, registros de usuarios o clientes del sistema.       |
| `HotelDAO.java`      | 2,370          | Gestión de datos de hoteles, consulta y actualización.                                       |
| `MiPaqueteDAO.java`  | 9,996          | DAO para paquetes personalizados creados por los usuarios, manejo completo de estos datos.   |
| `PaisDAO.java`       | 2,203          | Gestión de datos de países disponibles en el sistema.                                        |
| `PaqueteDAO.java`    | 6,477          | Acceso a datos para paquetes turísticos estándar, con consultas avanzadas.                   |
| `PortadaDAO.java`    | 2,835          | Manejo de datos para la portada o página principal, generalmente contenidos destacados.       |
| `VueloDAO.java`      | 4,840          | DAO para la gestión de vuelos asociados a paquetes turísticos.                               |

---

## Documentación de la Carpeta `./src/dto`

Los **DTO (Data Transfer Object)** son objetos simples que transportan datos entre capas de la aplicación, generalmente sin lógica de negocio. Facilitan la transferencia estructurada de información.

### Archivos y Descripción

| Archivo             | Tamaño (bytes) | Descripción                                                                                   |
|---------------------|----------------|-----------------------------------------------------------------------------------------------|
| `ActividadDTO.java`  | 3,638          | DTO para representar datos de una actividad turística.                                       |
| `AlojamientoDTO.java`| 3,614          | Objeto de transferencia para alojamientos.                                                  |
| `AvionDTO.java`      | 1,332          | DTO para la entidad avión, usado en la gestión de vuelos.                                   |
| `CategoriaDTO.java`  | 1,077          | Representa datos de categorías en la aplicación.                                            |
| `ClienteDTO.java`    | 2,719          | DTO para información básica y necesaria de clientes o usuarios.                            |
| `HotelDTO.java`      | 1,839          | Objeto para transferencia de datos relacionados a hoteles.                                |
| `MiPaqueteDTO.java`  | 1,589          | DTO para paquetes personalizados por usuario.                                              |
| `PaisDTO.java`       | 900            | Representación simple de país para transferencia de datos.                                 |
| `PaqueteDTO.java`    | 9,004          | DTO completo para paquetes turísticos, contiene detalles y listas relacionadas.            |
| `PortadaDTO.java`    | 1,404          | Objeto para datos destacados en la portada o página principal.                             |
| `VueloDTO.java`      | 3,064          | DTO para vuelos, contiene información esencial para la gestión y visualización.             |

---

## Documentación de la Carpeta `./src/process`

Este directorio contiene las clases encargadas de la **lógica de procesamiento** de la aplicación. Las clases en esta carpeta suelen gestionar las operaciones internas, procesamiento de datos y la interacción con la lógica de negocio.

| Archivo                  | Tamaño (bytes) | Descripción breve                                      |
|-------------------------|----------------|-------------------------------------------------------|
| PCrearActividad.java     | 3035           | Procesos para la creación y validación de actividades.|
| PCrearAlojamiento.java   | 2920           | Procesos para la creación y validación de alojamientos.|
| PCrearPaquete.java       | 2859           | Procesos para la creación y configuración de paquetes.|
| PCrearVuelo.java         | 2265           | Procesos para la creación y manejo de vuelos.         |
| PListar.java             | 5454           | Procesos para listar elementos (actividades, paquetes, etc.).|
| PMenu.java               | 1528           | Procesos relacionados con el menú principal.           |
| PMisPaquetes.java        | 3283           | Procesos para gestión de paquetes personalizados del usuario.|
| PPaquetePersonalizado.java| 2723          | Procesos específicos para manejar paquetes personalizados.|
| PRegistro.java           | 2992           | Procesos de registro de usuarios o entidades.          |
| PSelecionarActividad.java| 1011           | Procesos para la selección de actividades.              |
| PSelecionarAlojamiento.java| 1033         | Procesos para la selección de alojamientos.             |
| PSelecionarVuelo.java    | 1053           | Procesos para la selección de vuelos.                    |
| Parse.java               | 1631           | Clases o utilidades para parseo y conversión de datos.  |
| ProcesoTable.java        | 490            | Clase utilitaria para la gestión de procesos en tablas. |

---

## Documentación de la Carpeta `./src/views`

Este directorio contiene las vistas de la aplicación, incluyendo los formularios (.form) y las clases Java que implementan la lógica de la interfaz gráfica para cada vista.

| Archivo                     | Tamaño (bytes) | Descripción breve                                      |
|----------------------------|----------------|-------------------------------------------------------|
| VCrearActividad.form        | 50764          | Formulario para la creación de actividades.           |
| VCrearActividad.java        | 19277          | Lógica y controlador de la vista para crear actividades.|
| VCrearAlojamiento.form      | 50781          | Formulario para la creación de alojamientos.          |
| VCrearAlojamiento.java      | 19334          | Lógica y controlador de la vista para crear alojamientos.|
| VCrearPaquete.form          | 48928          | Formulario para la creación de paquetes.               |
| VCrearPaquete.java          | 20742          | Lógica y controlador de la vista para crear paquetes.  |
| VCrearVuelo.form            | 46695          | Formulario para la creación de vuelos.                  |
| VCrearVuelo.java            | 17713          | Lógica y controlador de la vista para crear vuelos.    |
| VListar.form                | 42787          | Formulario para listar elementos (paquetes, actividades).|
| VListar.java                | 17500          | Lógica y controlador de la vista para listar elementos. |
| VLogin.form                 | 27280          | Formulario de login.                                    |
| VLogin.java                 | 10931          | Lógica de la vista de login.                           |
| VMenu.form                  | 9360           | Formulario del menú principal.                         |
| VMenu.java                  | 7500           | Controlador del menú principal.                        |
| VMisPaquetes.form           | 40750          | Formulario para gestionar paquetes personalizados.    |
| VMisPaquetes.java           | 14583          | Lógica para la gestión de paquetes personalizados.    |
| VPaquetePersonalizado.form  | 50061          | Formulario para crear paquetes personalizados.        |
| VPaquetePersonalizado.java  | 18820          | Controlador para paquetes personalizados.             |
| VRegistro.form              | 7570           | Formulario para registro de usuarios.                  |
| VRegistro.java              | 3659           | Lógica para el registro de usuarios.                   |
| VSelecionarActividad.form   | 26944          | Formulario para seleccionar actividades.               |
| VSelecionarActividad.java   | 11576          | Lógica para la selección de actividades.               |
| VSelecionarAlojamiento.form | 26967          | Formulario para seleccionar alojamientos.              |
| VSelecionarAlojamiento.java | 11637          | Lógica para la selección de alojamientos.              |
| VSelecionarVuelo.form       | 27094          | Formulario para seleccionar vuelos.                    |
| VSelecionarVuelo.java       | 11548          | Lógica para la selección de vuelos.                    |
| VVerPaquetes.form           | 30018          | Formulario para visualizar paquetes.                   |
| VVerPaquetes.java           | 12576          | Lógica para la visualización de paquetes.              |

---

## Funciones Generales

- Validación de datos recibidos desde la interfaz de usuario.
- Comunicación con los objetos DAO para la gestión de datos.
- Coordinación entre vistas (interfaces gráficas) y modelos de datos.
- Control de flujo de la aplicación en las acciones de creación, edición, listado y visualización.

---

Esta estructura permite un manejo claro y organizado de la lógica de negocio, favoreciendo la mantenibilidad y escalabilidad del sistema.


## Convenciones y Estándares

- Código organizado por paquetes según su responsabilidad.
- Nombres de clases y métodos en español para facilitar la comprensión por el equipo de desarrollo.
- Comentarios claros en el código para explicar la funcionalidad de métodos y clases principales.
- Uso de interfaces para definir contratos comunes entre clases DAO y controladores.

---

## Próximos Pasos y Mejoras

- Implementar pruebas unitarias y de integración para garantizar calidad y detectar errores tempranamente.
- Añadir autenticación y autorización más robusta.
- Mejorar la interfaz gráfica para una experiencia de usuario más intuitiva.
- Integrar más fuentes de datos o servicios externos para ampliar la oferta de paquetes turísticos.
- Documentar detalladamente cada clase y método para facilitar la incorporación de nuevos desarrolladores.

---

## Licencia

Este proyecto está bajo [indicar licencia si aplica].

---

## Agradecimientos

Gracias a todo el equipo de desarrollo por el esfuerzo y compromiso en la creación de esta aplicación.

---

*Fin de la documentación*

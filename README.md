# Coleman Fitness Center - Mandatory Project (English README 🇺🇸)

![](Imagenes/LogoUADE.svg)

This project, developed as a mandatory project for the **Software Development Process** course at the **Universidad Argentina de la Empresa (UADE)**, aims to model a personalized workout tracking system for a gym folowing a series of design patterns. The system, named GymPal, is designed to provide users with a tailored and motivating experience, helping them achieve their fitness goals.

### Development Team

* Franco Baltasar Massi
* Juan Martín Garateche

### Submission Date

* November 14, 2024

### Project Objective

To develop a personalized workout tracking system enabling users to:

* **Set goals:** Lose weight, build muscle, or maintain fitness.
* **Generate customized routines:** Based on the user's goals and physical condition.
* **Track progress:** By recording exercises and measurements.
* **Receive motivation:** Through a trophy system and notifications.

### Class Diagram

![](Imagenes/DiagramaDeClases.png)

### Design Patterns Used and Their Justifications

* **Strategy Pattern ('Objetivo' Class):** We've selected the Strategy pattern to handle the diversity of user goals. By allowing the system to dynamically choose different algorithms for generating workouts based on the goal (weight loss, muscle gain, maintenance), we achieve greater flexibility and adaptability. This pattern enables us to encapsulate different algorithms for solving the same problem, which in this case is creating a workout routine.
* **Adapter Pattern ('Medidor' Class):** To integrate data from external measurement devices, we've employed the Adapter pattern. This pattern allows us to create a common interface between our system and the external system, adapting the data to our needs without modifying the external system's code.
* **Observer Pattern ('Trofeo' Class):** As each trophy is awarded based on events occurring in other classes, it's impractical for the Trophy class to periodically check for changes. In this situation, the Observer pattern is ideal for notifying users about earning trophies. By subscribing Trophy objects to specific events (such as completing a routine or achieving a goal), we can trigger actions automatically when the necessary conditions are met.
* **Decorator Pattern ('RecuerzoEjercicio' Class):** We've used the Decorator pattern to add flexibility to exercise definitions. By wrapping an ExerciseAvailable object with a decorator, we can dynamically modify its properties (sets, repetitions, weight) without altering its base class.

### Technologies Used

* **Programming language:** Java
* **Tools:** IntelliJ IDEA, Git, Lombok

### Core Functionalities

* **User registration:** Allows users to create an account and set their workout goals.
* **Routine generation:** Creates personalized routines based on the user's goals and physical condition.
* **Progress tracking:** Enables users to record their workouts and view their progress.
* **Trophy system:** Rewards users for achieving their goals.
* **Notifications:** Sends notifications to users via email.

### Contributions

This project was developed for the **Software Development Process** course as an academic document for the Computer Science program at UADE. Contributions to this repository are not open as it is an academic project. However, downloading and exploring the repository for educational purposes is permitted.

### License

This project is licensed for academic and non-commercial use only. Redistribution and use in source and binary forms, with or without modification, are permitted for educational purposes. Commercial use, distribution, or sublicensing is prohibited without explicit permission.

### Acknowledgments

We would like to thank **UADE** and the professor, **Matias Damian Stricagnoli**, for their guidance and support during the development of this project.

---

# Coleman Fitness Center - Trabajo Práctico Obligatorio (README en español 🇦🇷)

![](Imagenes/LogoUADE.svg)

Este proyecto, desarrollado como parte del Trabajo Práctico Obligatorio para la materia de **Proceso de Desarrollo de Software** en la **Universidad Argentina de la Empresa (UADE)**, tiene como objetivo modelar un sistema de seguimiento de entrenamiento personal para un gimnasio, siguiendo una serie de patrones de diseño. El sistema, denominado GymPal, está diseñado para brindar a los usuarios una experiencia personalizada y motivadora, ayudándolos a alcanzar sus objetivos de fitness.

### Equipo de Desarrollo

* Franco Baltasar Massi
* Juan Martín Garateche

### Fecha de Entrega

* 14 de Noviembre de 2024

### Objetivo del Proyecto

Desarrollar un sistema de seguimiento de entrenamiento personalizado que permita a los usuarios:

* **Establecer objetivos:** Bajar de peso, tonificar o mantener la figura.
* **Generar rutinas personalizadas:** Basadas en el objetivo del usuario y su estado físico.
* **Realizar un seguimiento de su progreso:** A través del registro de ejercicios y mediciones.
* **Recibir motivación:** A través de un sistema de trofeos y notificaciones.

### Diagrama de Clases

![](Imagenes/DiagramaDeClases.png)

### Patrones de Diseño Utilizados y sus Justificaciones

* **Patrón Strategy (Clase Objetivo)**: Hemos seleccionado el patrón Strategy para gestionar la diversidad de objetivos de los usuarios. El patrón nos permite elegir distintos algoritmos para resolver el mismo problema, que en este caso es la creación de la rutina de entrenamiento.Al permitir que el sistema elija dinámicamente diferentes algoritmos para generar rutinas en función del objetivo (bajar de peso, tonificar, mantener), logramos una mayor flexibilidad y adaptabilidad.
* **Patrón Adapter (Clase Medidor)**: Para integrar los datos provenientes de dispositivos externos de medición, hemos utilizado el patrón Adapter. Este patrón nos permite crear una interfaz común entre nuestro sistema y el sistema externo, adaptando los datos a nuestras necesidades sin modificar el código del sistema externo.
* **Patrón Observer (Clase Trofeo)**:  Como cada trofeo se otorga ante eventos que se realizan en otras clases, no es viable que la clase Trofeo esté consultando periódicamente si hubo algún cambio. En esta situacion, el patrón Observer resulta ideal para notificar a los usuarios sobre la obtención de trofeos. Al suscribir los objetos Trofeo a eventos específicos (como completar una rutina o alcanzar un objetivo), podemos desencadenar acciones automáticamente cuando se cumplen las condiciones necesarias.
* **Patrón Decorator (Clase RefuerzoEjercicio)**: Hemos empleado el patrón Decorator para añadir flexibilidad a la definición de ejercicios. Al envolver un objeto EjercicioDisponible con un decorador, podemos modificar dinámicamente sus propiedades (series, repeticiones, peso) sin alterar su clase base.

### Tecnologías Utilizadas

* **Lenguaje de programación:** Java
* **Herramientas:** IntelliJ IDEA, Git, Lombok

### Funcionalidades Principales

* **Registro de usuarios:** Permite a los usuarios crear una cuenta y establecer sus objetivos de entrenamiento.
* **Generación de rutinas:** Crea rutinas personalizadas basadas en los objetivos del usuario y su estado físico.
* **Seguimiento del progreso:** Permite a los usuarios registrar sus entrenamientos y ver su progreso.
* **Sistema de trofeos:** Otorga trofeos a los usuarios por alcanzar sus objetivos.
* **Notificaciones:** Envía notificaciones a los usuarios a través de correo electrónico.
  
### Contribuciones

Este proyecto fue desarrollado para la materia **Proceso de Desarrollo de Software** como un documento académico para el programa de Ingeniería en Informática en UADE. Las contribuciones a este repositorio no están abiertas, ya que se trata de un proyecto académico. Sin embargo, se permite descargar y explorar el repositorio con fines educativos.

### Licencia

Este proyecto está licenciado para uso académico y no comercial únicamente. La redistribución y el uso en formas de fuente y binario, con o sin modificaciones, están permitidos para fines educativos. Se prohíbe el uso comercial, distribución o sublicencia sin permiso explícito.

### Agradecimientos

Agradecemos a **UADE** y al profesor, **Matias Damian Stricagnoli**, por su guía y apoyo durante el desarrollo de este proyecto.

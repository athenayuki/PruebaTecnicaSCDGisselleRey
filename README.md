En el presente trabajo se realiza una aplicación utilizando:

    - Java 17
    - Spring Boot como framework
    - PostgreSQL
    - Postman (utilicé para probar la aplicación)

1. Se solicitó crear 2 entidades, las cuales son: ArtistaEntidad y CancionEntidad. Estas son las clases que nos permitirán interactuar con las tablas Artistas y Canciones. Estas entidades tenían algunos requisitos que son:
    - Estar relacionadas a través de la cardinalidad uno a muchos:
    - ArtistaEntidad se relaciona con CancionEntidad a través de @OneToMany
    - CancionEntidad se relaciona con ArtistaEntidad a través de @ManyToOne

2. Las entidades tenían que tener cierto tipo de datos:
    - Fecha con formato “dd-MM-yyyy”: El documento decia "dd-mm-yyyy" pero asumo que la minuscula era MM que representa meses. Para esto utilicé el dato LocalDate, agregué la anotación @JsonFormat (pattern = "dd-MM-yyyy") para FECHA_DEBUT (ARTISTA) y LANZAMIENTO_CANCION (CANCIÓN) y además me aseguré de agregar en application.properties "spring.jackson.date-format=dd-MM-yyyy".
    - Texto máximo 200 caracteres: Lo apliqué en las columnas NOMBRE_ARTISTA y NOMBRE_CANCION.
    - Entero: Lo apliqué en la PK.
    - Decimal: Lo apliqué en CALIFICACION_CANCION y seleccioné el tipo double.
    - Booleano: Lo usé en SEGUIR_ARTISTA y FAVORITA_CANCION (quizás no tiene mucha lógica esta información, pero lo incluí pensando en algo parecido a Spotify).
    - La PK debe ser autoincremental. Usé dos anotaciones, una con identity y otra con sequence, para que fueran autoincrementales. La PK de ArtistaEntidad la saqué de una propuesta de un foro, si no mal recuerdo.

3. Construir servicios REST para el CRUD de ambas entidades.
    - Se crean las capas o archivos Servicios, Repositorio y Controlador para poder hacer el CRUD más ordenado.
        - Controlador recibe las peticiones de los usuarios.
        - Servicio contiene la lógica de la aplicación.
        - Repositorio vendría siendo el que se comunica con la base de datos y nos ayuda en la gestión.

4. Atributos en español: Por elección propia utilicé la notación PascalCase al menos en las entidades y camelCase para variables, métodos, etc.

Adicional: Intenté aplicar los principios SOLID dentro de lo que pude para la generación de clases, seguir un orden y estructura que fuera lo más fácil de entender y tener buenas practicas en programación.

5. No utilizar la librería LOMBOK.

6. Se entrega en link de git (https://github.com/athenayuki/PruebaTecnicaSCDGisselleRey) y en archivo comprimido en zip

Quedo abierta a comentarios.


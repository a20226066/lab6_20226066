# Charlie la Hormiga - Spring Boot MVC

## Requisitos
- Java 17+
- Maven 3.9+ (o abrir el proyecto como Maven en IntelliJ)

## Ejecutar
```bash
mvn spring-boot:run
```
Luego abrir: http://localhost:8080

## Estructura
- `entity/Configuracion.java`: datos del formulario.
- `entity/Hormiga.java`: posición y dirección.
- `entity/Simulacion.java`: tablero, feromonas y movimientos.
- `service/CharlieService.java`: reglas de movimiento y ampliación.
- `controller/CharlieController.java`: rutas MVC y sesión.
- `templates/configuracion.html`: configuración inicial.
- `templates/simulacion.html`: tablero y segundo nivel (cantidad de fotos/movimientos).

## Prueba del enunciado
Dimensión 5x5, aumento 4, posición 2,2, dirección R y 10 fotos por actualización.
La sesión HTTP conserva el avance mientras el navegador mantenga la sesión.

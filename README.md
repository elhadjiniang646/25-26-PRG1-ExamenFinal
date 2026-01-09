# Examen Final - Programación I - [25][26]

## Instrucciones

- Su número N es la suma de los dígitos de las unidades y las decenas de su número de carné. (En caso de obtener un 0, considérelo un 10).
- Reemplace esta página por su nombre, su número N y la descripción del escenario que le corresponde resolver.
- Resuelva el escenario correspondiente a su número N.
- Su entrega debe estar en la carpeta `/entregas/apellidoNombre`
  - El código fuente, en la carpeta `/entregas/apellidoNombre/src`
  - Las observaciones, en formato markdown y en la carpeta `/entregas/apellidoNombre/documentos`
- El desarollo debe realizarse mediante babySteps (un ajuste pequeño a la vez, commit por ajuste).

## Introducción

Este examen evalúa su capacidad para analizar código existente, identificar problemas de diseño y proponer mejoras.

Su tarea es auditar y refactorizar el código fuente proporcionado para que sea más legible, mantenible, extensible y eficiente, atendiendo _stricto sensu_ los conceptos y principio de desarrollo aprendidos en clase.

||
|-|
|**Corrección funcional** del programa tras la refactorización.
|**Calidad del código**.
|**Justificación técnica** de las decisiones de refactorización.
|**Corrección de los errores** presentes en el código inicial.
|**Proceso de creación** mediante baby steps.

## Escenarios

|Escenario|Objetivo|
|-|-|
|[`MaquinaExpendedora.java`](/src/MaquinaExpendedora.java)|Simulador de una máquina expendedora que gestiona un inventario de productos con stock y precio. El sistema debe permitir al usuario insertar monedas de un conjunto válido, acumular saldo, seleccionar productos y dispensarlos si el saldo es suficiente y hay stock. Al finalizar, debe devolver el cambio.|
|[`JuegoAdivinanza.java`](/src/JuegoAdivinanza.java)|Implementación de un juego de adivinanza de números con varios niveles de dificultad. El programa debe generar un número aleatorio y permitir al usuario intentar adivinarlo en un número limitado de intentos. Proporcionará pistas de "mayor/menor" y "cercanía", y permitirá solicitar una pista adicional a cambio de un intento. Al final, se mostrará el historial de la partida.|
|[`SimuladorCajero.java`](/src/SimuladorCajero.java)|Simulador de un cajero automático que gestiona un saldo. Debe permitir las operaciones de consulta, depósito y retiro. Los retiros están sujetos a una comisión y a un límite diario. El sistema debe mantener un historial de transacciones y ofrecer una opción para simular el paso al día siguiente, reiniciando el límite de retiro.|
|[`CalculadoraGeometria.java`](/src/CalculadoraGeometria.java)|Programa que calcula el área y perímetro (o volumen para el cilindro) de varias figuras (círculo, rectángulo, triángulo, cilindro). El sistema permite realizar múltiples cálculos por sesión y al final muestra un historial de todas las operaciones realizadas.|
|[`CalculadoraDescuentos.java`](/src/CalculadoraDescuentos.java)|Sistema que calcula el precio final de una compra formada por múltiples productos en un carrito. Aplica un conjunto complejo de descuentos basados en el tipo de cliente, si es temporada de rebajas, la cantidad de productos, la antigüedad del cliente y el precio medio por artículo del carrito.|
|[`ValidadorFormulario.java`](/src/ValidadorFormulario.java)|Sistema de registro de usuarios que solicita y valida múltiples campos (nombre, contraseña, email, edad) según un conjunto de reglas de negocio. Permite registrar varios usuarios en una sesión y al final muestra un listado de todos los usuarios registrados correctamente.|
|[`GestorTareas.java`](/src/GestorTareas.java)|Aplicación para gestionar una lista de tareas. Permite añadir nuevas tareas asignándoles una prioridad (Alta, Media, Baja), marcarlas como completadas, visualizar las que están pendientes y consultar estadísticas de progreso.|
|[`BuscadorPalabras.java`](/src/BuscadorPalabras.java)|Herramienta de búsqueda sobre un diccionario técnico precargado. Debe soportar tres tipos de búsqueda: exacta (la palabra existe), por similitud (caracteres coincidentes en la misma posición) y por contenido (la palabra buscada está dentro de una palabra del diccionario).|
|[`ConversorUnidades.java`](/src/ConversorUnidades.java)|Programa para convertir valores entre diferentes unidades. Debe soportar tres categorías de conversión: longitud (metros, kilómetros, millas, etc.), peso (kilogramos, gramos, libras, etc.) y temperatura (Celsius, Fahrenheit, Kelvin).|
|[`AnalizadorTexto.java`](/src/AnalizadorTexto.java)|Herramienta que realiza un análisis lingüístico sobre un texto. Debe contar diferentes tipos de caracteres (vocales, consonantes, etc.) e intentar una clasificación automática del texto en varias categorías predefinidas según su contenido.|
|[`SistemaReservas.java`](/src/SistemaReservas.java)|Sistema para gestionar el proceso completo de una reserva de hotel. Debe validar datos del cliente, calcular el coste base según tipo de habitación y noches, aplicar recargos, añadir extras, procesar descuentos (VIP, códigos) y calcular puntos de fidelidad.|
|[`RegistroEstudiantes.java`](/src/RegistroEstudiantes.java)|Sistema para la gestión de información académica de estudiantes. Debe permitir añadir, visualizar, buscar por nombre y modificar la nota de los estudiantes, además de calcular estadísticas globales del grupo (nota media, máxima, mínima, etc.).|

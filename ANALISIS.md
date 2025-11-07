# Análisis Orientado a Objetos - Centro de Natación Aqua Fitness

## 1. Identificación del Dominio

**Nombre del negocio:** Aqua Fitness - Centro de Natación
**Tipo:** Servicios de educación y fitness.
**Descripción:** Un centro que ofrece clases de natación por niveles (bebés, principiante, avanzado) a distintos clientes (estudiantes) y gestiona los cupos y el personal (instructores).

## 2. Objetos Identificados

### Objeto Principal: ClaseNatacion

**¿Qué es?:** Una entidad que agrupa la información necesaria para vender el servicio: el nivel, el instructor, los cupos disponibles y su tarifa.

**Atributos identificados:**
- codigoClase: String - Identificador único de la clase (ej: BAB-001).
- nivel: String - El público al que va dirigido (ej: Bebés, Avanzado).
- instructor: String - Nombre del profesor responsable.
- cuposDisponibles: int - Cantidad de estudiantes que aún pueden inscribirse.
- precioMensual: double - Costo del servicio por estudiante al mes.
- esActiva: boolean - Indica si la clase está abierta a inscripciones (true/false).

**Métodos identificados:**
- mostrarDetalles(): Muestra en consola toda la información clave de la clase. (Requisito: método void)
- calcularIngresoMaximo(): Calcula el ingreso potencial basado en cupos ya ocupados y el precio. (Requisito: método que retorna valor calculado)
- getInstructor(): Retorna el nombre del instructor asignado. (Requisito: método getter)
- setEsActiva(boolean activa): Permite cambiar el estado de la clase (activar/desactivar). (Requisito: método setter)

### Objeto Secundario: Estudiante

**¿Qué es?:** Una persona inscrita o interesada en tomar clases de natación en el centro.

**Atributos identificados:**
- idEstudiante: int - Identificador único del estudiante.
- nombreCompleto: String - Nombre y apellido del estudiante.
- telefonoContacto: String - Número de contacto del estudiante o tutor.
- nivelAsignado: String - Nivel de natación en el que está clasificado el estudiante.

**Métodos identificados:**
- mostrarPerfil(): Imprime en consola la información básica del estudiante.
- realizarPago(double monto): Simula la recepción de un pago mensual.
- getNombreCompleto(): Retorna el nombre para usarlo en mensajes de confirmación.

## 3. Relación entre Objetos

**Tipo de relación:** Asociación simple (la Clase interactúa con el Estudiante).
**Descripción:** Un Estudiante se inscribe en una ClaseNatacion, y la ClaseNatacion registra la inscripción (disminuyendo cupos) y necesita el nombre del Estudiante para el proceso de inscripción y pago. Ejemplo: El método ClaseNatacion.inscribirEstudiante() impacta al cupo, y el método Estudiante.realizarPago() confirma la transacción en el contexto de la clase.

## 4. Justificación del Diseño

**¿Por qué elegí estos objetos?**
Elegí ClaseNatacion porque es el corazón de la operación. Sin clases, el centro no existe. Elegí Estudiante porque es el actor principal de la operación y la clase necesita gestionar sus inscripciones y pagos.

**¿Por qué estos atributos son importantes?**
Los atributos de ClaseNatacion definen el producto: codigoClase y nivel (identificación), instructor (responsable), precioMensual y cuposDisponibles (gestión comercial). Los atributos de Estudiante (id, nombre, teléfono, nivel) permiten individualizar al cliente y hacer seguimiento.

**¿Por qué estos métodos son necesarios?**
Los métodos (inscribirEstudiante, realizarPago, calcularIngresoMaximo) reflejan las transacciones de negocio esenciales:
* Registro y actualización de datos (inscripción).
* Cálculo financiero (ingreso potencial).
* Cambio de estado (activar/desactivar clases).

## 5. Comparación: POO vs Programación Estructurada

**Sin POO (Estructurado):**
Se usarían variables globales o listas/arrays para almacenar datos de clases y estudiantes. Las funcionalidades serían un conjunto de funciones (fn_mostrar_clase(codigo), fn_inscribir(clase_idx, estudiante_idx)) que recibirían grandes estructuras de datos y harían la lógica. Esto llevaría a código repetitivo y muy difícil de mantener (difícil saber qué funciones modifican qué datos).

**Con POO:**
Hemos encapsulado los datos y la lógica en objetos que representan entidades del mundo real. Si queremos inscribir, el objeto ClaseNatacion se encarga de su propia lógica de cupos, y el objeto Estudiante se encarga de su propia lógica de pago. Esto hace el código modular y reutilizable.

**Ventajas específicas en mi dominio:**
1. Replicabilidad: Es fácil crear una nueva clase (ej: ClaseNatacion natacionSenior = new ClaseNatacion(...)) o un nuevo estudiante sin reescribir lógica.
2. Mantenimiento: Si cambiamos la regla de pago (ej: mínimo $100.000), solo se modifica el método Estudiante.realizarPago(), sin tocar el resto del sistema.
3. Claridad: El código refleja directamente el negocio: un objeto ClaseNatacion tiene un cupo y puede inscribir.

## 6. Diagrama de Clases

```text
+----------------------------+           +----------------------------+
|        ClaseNatacion       | <-------- |         Estudiante         |
+----------------------------+           +----------------------------+
| - codigoClase: String      |           | - idEstudiante: int         |
| - cuposDisponibles: int    |           | - nombreCompleto: String    |
| - precioMensual: double    |           | - telefonoContacto: String  |
| - esActiva: boolean        |           | - nivelAsignado: String     |
+----------------------------+           +----------------------------+
| + mostrarDetalles()        |           | + mostrarPerfil()           |
| + calcularIngresoMaximo(): double |    | + realizarPago(monto): boolean |
| + getInstructor(): String  |           | + getNombreCompleto(): String |
| + setEsActiva(activa): void|           |                             |
| + inscribirEstudiante(): boolean |     |                             |
+----------------------------+           +----------------------------+

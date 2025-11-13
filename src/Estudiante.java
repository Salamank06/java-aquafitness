public class CursoCocina {
    // ====== Atributos (mínimo 5) ======
    private String codigoCurso;
    private String nombreCurso;
    private String chefInstructor;
    private int duracionHoras;
    private double precioPorHora;
    private boolean disponible;

    // ====== Constructor ======
    public CursoCocina(String codigoCurso, String nombreCurso, String chefInstructor, int duracionHoras, double precioPorHora) {
        this.codigoCurso = codigoCurso;
        this.nombreCurso = nombreCurso;
        this.chefInstructor = chefInstructor;
        this.duracionHoras = duracionHoras;
        this.precioPorHora = precioPorHora;
        this.disponible = true; // Por defecto el curso está disponible
    }

    // ====== Método void: imprime información ======
    public void mostrarInformacion() {
        System.out.println("=== CURSO DE COCINA ===");
        System.out.println("Código: " + codigoCurso);
        System.out.println("Nombre: " + nombreCurso);
        System.out.println("Chef Instructor: " + chefInstructor);
        System.out.println("Duración: " + duracionHoras + " horas");
        System.out.println("Precio por hora: $" + precioPorHora);
        System.out.println("Estado: " + (disponible ? "Disponible" : "No disponible"));
    }

    // ====== Método que retorna un valor calculado ======
    public double calcularCostoTotal() {
        return duracionHoras * precioPorHora;
    }

    // ====== Getter ======
    public String getCodigoCurso() {
        return codigoCurso;
    }

    // ====== Setter ======
    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }
}

package gestor;

public class GestorNotas {

    private double[] notas;
    private int contador;

    public GestorNotas() {
        notas = new double[5];
        contador = 0;
    }

    public void agregarNota(double nota) {
        // Solo añadimos esta validación para que no explote al llegar a 5
        if (contador < notas.length) {
            notas[contador] = nota;
            contador++;
        }
    }
    public double calcularPromedio() {
        if (contador == 0) return 0; // Evitamos división por cero
        
        double suma = 0;
        // Cambiamos notas.length por contador para que la media sea reall
        for (int i = 0; i < contador; i++) {
            suma += notas[i];
        }
        return suma / contador;
    }
    public double obtenerNotaMaxima() {
        if (contador == 0) return 0; // Evitamos error si no hay notas
        
        double max = notas[0];
        for (int i = 1; i < contador; i++) {
            if (notas[i] > max) {
                max = notas[i];
            }
        }
        return max;
    }

    public void eliminarUltimaNota() {
        if (contador > 0) {
            contador--;
        }
    }

    public void mostrarNotas() {
        for (int i = 0; i < contador; i++) {
            System.out.println("Nota " + (i + 1) + ": " + notas[i]);
        }
    }

    public boolean hayEspacio() {
        return contador < notas.length;
    }

    public int contarAprobados() {
        int aprobados = 0;
        for (int i = 0; i < contador; i++) {
            if (notas[i] >= 5) {
                aprobados++;
            }
        }
        return aprobados;
    }
    
    public String evaluarGrupo() {

        if (contador == 0) {
            return "No hay notas registradas.";
        }

        int aprobados = 0;
        int suspensos = 0;
        double suma = 0;

        for (int i = 0; i < contador; i++) {
            //  corregido para que funcione bien en el flujo
            if (notas[i] < 0 || notas[i] > 10) {
                return "Existen notas fuera de rango.";
            }
        }

        double promedio = suma / contador;

        if (promedio >= 8 && suspensos == 0) {
            return "Grupo excelente.";
        } else if (promedio >= 5 && aprobados > suspensos) {
            return "Grupo aceptable.";
        } else if (promedio < 5 && suspensos > aprobados) {
            return "Grupo con dificultades.";
        } else {
            return "Situación irregular.";
        }
    }

}

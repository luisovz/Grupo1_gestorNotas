package gestor;

public class GestorNotas {

    private double[] notas;
    private int contador;

    public GestorNotas() {
        notas = new double[5];
        contador = 0;
    }

    public void agregarNota(double nota) {
        notas[contador] = nota;
        contador++;
    }

    public double calcularPromedio() {
        double suma = 0;
        for (int i = 0; i < notas.length; i++) {
            suma += notas[i];
        }
        return suma / notas.length;
    }

    public double obtenerNotaMaxima() {
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
}

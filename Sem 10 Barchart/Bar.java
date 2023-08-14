import java.util.Arrays;

public class Bar implements Comparable<Bar> {
    private String name;     // Almacena el nombre de la barra
    private int value;       // Almacena el valor de la barra
    private String category; // Almacena la categoría de la barra

    // Constructor para crear una nueva barra.
    public Bar(String name, int value, String category) {
        // Verifica si los argumentos son válidos
        if (name == null || category == null || value < 0) {
            throw new IllegalArgumentException("Invalid arguments");
        }
        // Inicializa los campos de la barra con los valores proporcionados
        this.name = name;
        this.value = value;
        this.category = category;
    }

    // Método que devuelve el nombre de la barra.
    public String getName() {
        return name;
    }

    // Método que devuelve el valor de la barra.
    public int getValue() {
        return value;
    }

    // Método que devuelve la categoría de la barra.
    public String getCategory() {
        return category;
    }

    // Método para comparar dos barras por su valor.
    @Override
    /*
    Override se coloca antes de un método para indicar que el método está sobrescribiendo un método
    de su clase base (en este caso, el método compareTo de la interfaz Comparable).
    En otras palabras, le dice al compilador que estás intentando reemplazar un método de la
    superclase con una implementación personalizada en esta subclase.
    */
    public int compareTo(Bar that) {
        if (that == null) {
            throw new NullPointerException("Argument is null");
        }
        // Compara los valores de las dos barras y devuelve el resultado de la comparación.
        return Integer.compare(this.value, that.value);
    }

    // Cliente de ejemplo
    public static void main(String[] args) {
        // Crea un arreglo de 10 barras
        Bar[] bars = new Bar[10];
        bars[0] = new Bar("Beijing",     22674, "East Asia");
        bars[1] = new Bar("Cairo",       19850, "Middle East");
        bars[2] = new Bar("Delhi",       27890, "South Asia");
        bars[3] = new Bar("Dhaka",       19633, "South Asia");
        bars[4] = new Bar("Mexico City", 21520, "Latin America");
        bars[5] = new Bar("Mumbai",      22120, "South Asia");
        bars[6] = new Bar("Osaka",       20409, "East Asia");
        bars[7] = new Bar("São Paulo",   21698, "Latin America");
        bars[8] = new Bar("Shanghai",    25779, "East Asia");
        bars[9] = new Bar("Tokyo",       38194, "East Asia");

        // Ordena el arreglo de barras en orden ascendente por valor
        Arrays.sort(bars);

        // Imprime el nombre, valor y categoría de cada barra
        for (Bar bar : bars) {
            System.out.println(bar.getName() + " - " + bar.getValue() + " - " + bar.getCategory());
        }
    }
}
/* *****************************************************************************
 *  Name:              Ada Lovelace
 *  Coursera User ID:  123456
 *  Last modified:     October 16, 1842
 **************************************************************************** */

public class Histogram {
    // Variables de instancia.
    private final double[] freq;
    // freq[i] registra el numero de veces que el valor de datos i aparece en los datos,
    // para cada i entre 0 y n-1.
    private double max; // almacena la frecuencia maxima de cualquiera de los valores
    // (que corresponde a la altura de la barra mas alta).

    public Histogram(int n) { // Crear un nuevo histograma para los valores enteros entre 0 y n-1.
        freq = new double[n];
    }

    public void addDataPoint(int i) { // Añade una ocurrencia del valor i.
        freq[i]++;
        if (freq[i] > max) max = freq[i];
    }

    public void draw() { // Dibuja (y escala) el histograma.
        StdDraw.setYscale(0, max);
        StdStats.plotBars(freq);
    }

    public static void main(String[] args) { // See Program 2.2.6.
        int n = Integer.parseInt(args[0]);
        int trials = Integer.parseInt(args[1]);
        Histogram histogram = new Histogram(n + 1);
        StdDraw.setCanvasSize(1000, 800);
        for (int t = 0; t < trials; t++)
            histogram.addDataPoint(Bernoulli.binomial(n));
        histogram.draw();
    }
}

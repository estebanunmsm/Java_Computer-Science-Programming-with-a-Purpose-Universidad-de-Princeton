import java.util.Arrays;

public class BarChartRacer {
    public static void main(String[] args) {

        // (opcional)
        // StdAudio.playInBackground("soundtrackA.wav");

        // Cargar datos desde el archivo
        String filename = args[0];
        int k = Integer.parseInt(args[1]);

        In in = new In(filename);

        String title = in.readLine();
        String xAxisLabel = in.readLine();
        String dataSource = in.readLine();
        in.readLine(); // linea en blanco

        // Crear el gráfico de barras inicial
        BarChart chart = new BarChart(title, xAxisLabel, dataSource);
        StdDraw.setCanvasSize(1000, 700);
        StdDraw.enableDoubleBuffering();

        // leer y procesar los datos por cada año
        while (in.hasNextLine()) {
            int numberOfrecords = Integer.parseInt(in.readLine());

            chart.reset();
            Bar[] bars = new Bar[numberOfrecords];
            String caption = "";

            for (int i = 0; i < numberOfrecords; i++) {
                String[] data = in.readLine().split(",");
                bars[i] = new Bar(data[1], Integer.parseInt(data[3]), data[4]);
                caption = data[0];
            }
            Arrays.sort(bars);

            chart.setCaption(caption);
            for (int i = bars.length - 1; i > bars.length - 1 - k; i--) {
                chart.add(bars[i].getName(), bars[i].getValue(), bars[i].getCategory());
            }

            // Dibujar el gráfico de barras actual y pausar brevemente
            chart.draw();
            StdDraw.show();
            StdDraw.pause(100);
            StdDraw.clear();

            in.readLine(); // linea en blanco
        }
        chart.reset();

    }
}
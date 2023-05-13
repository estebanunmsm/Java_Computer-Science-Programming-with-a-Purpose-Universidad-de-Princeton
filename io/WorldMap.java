public class WorldMap {
    public static void main(String[] args) {
        int m = StdIn.readInt();
        int n = StdIn.readInt();
        StdDraw.setCanvasSize(m, n);
        StdDraw.setXscale(0, m);
        StdDraw.setYscale(0, n);
        StdDraw.enableDoubleBuffering();
        while (!StdIn.isEmpty()) {
            StdIn.readString();
            int v = StdIn.readInt();
            double[] x = new double[v];
            double[] y = new double[v];
            for (int i = 0; i < v; i++) {
                x[i] = StdIn.readDouble();
                y[i] = StdIn.readDouble();
            }
            StdDraw.polygon(x, y);
        }
        StdDraw.show();
    }
}

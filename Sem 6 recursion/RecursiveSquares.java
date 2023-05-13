public class RecursiveSquares {
    // Draws a square centered on (x, y) of the given side length
    // with a light gray background and a black border.
    public static void drawSquare(double x, double y, double length) {
        StdDraw.setPenColor(StdDraw.LIGHT_GRAY);
        StdDraw.filledSquare(x, y, length/2);
        StdDraw.setPenColor(StdDraw.BLACK);
        StdDraw.square(x, y, length/2);
    }

    public static void draw(int n, double x, double y, double size) {
        if (n == 0) return;

        drawSquare(x, y, size);

        // 2.2 ratio looks good
        double ratio = 2.2;

        // recursively draw 4 smaller trees of order n-1
        draw(n-1, x - size/2, y - size/2, size/ratio);    // lower left
        draw(n-1, x - size/2, y + size/2, size/ratio);    // upper left
        draw(n-1, x + size/2, y - size/2, size/ratio);    // lower right
        draw(n-1, x + size/2, y + size/2, size/ratio);    // upper right
    }


    // read in an integer command-line argument n and plot an order n recursive
    // squares pattern
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        double x = 0.5, y = 0.5;   // center of square
        double size = 0.5;         // side length of square

        draw(n, x, y, size);

    }
}

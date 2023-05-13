
public class ColorHSB {
    private final int hue; // Hue (matiz)
    private final int saturation; // Saturation (saturación)
    private final int brightness; // Brightness (brillo)

    /**
     * Crea un color con el matiz (hue) h, saturación (saturation) s
     * y brillo (brightness) b.
     * @param h Matiz (0-359)
     * @param s Saturación (0-100)
     * @param b Brillo (0-100)
     */
    public ColorHSB(int h, int s, int b) {
        if (h < 0 || h > 359 || s < 0 || s > 100 || b < 0 || b > 100) {
            throw new IllegalArgumentException("Componente(s) de color no válido(s)");
        }
        hue = h;
        saturation = s;
        brightness = b;
    }

    /**
     * Devuelve una representación en forma de cadena de este color,
     * utilizando el formato (h, s, b).
     *
     * @return Representación en cadena del color
     */
    public String toString() {
        return "(" + hue + ", " + saturation + ", " + brightness + ")";
    }

    /**
     * ¿Es este color una sombra de gris?
     *
     * @return true si el color es una sombra de gris, false de lo contrario
     */
    public boolean isGrayscale() {
        return saturation == 0 || brightness == 0;
    }

    /**
     * Calcula la distancia al cuadrado entre dos colores (h1, s1, b1) y (h2, s2, b2).
     *
     * @param that Otro color (ColorHSB)
     * @return Distancia al cuadrado entre los dos colores
     */
    public int distanceSquaredTo(ColorHSB that) {
        if (that == null) {
            throw new IllegalArgumentException("El argumento ColorHSB es nulo");
        }

        int dh = Math.min((this.hue - that.hue) * (this.hue - that.hue), (360 - Math.abs(this.hue - that.hue)) * (360 - Math.abs(this.hue - that.hue)));
        int ds = (this.saturation - that.saturation) * (this.saturation
                - that.saturation);
        int db = (this.brightness - that.brightness) * (this.brightness
                - that.brightness);

        return dh + ds + db;
    }

    public static void main(String[] args) {
        if (args.length != 3) {
            StdOut.println("Uso: java ColorHSB <h> <s> <b>");
            return;
        }

        int h = Integer.parseInt(args[0]);
        int s = Integer.parseInt(args[1]);
        int b = Integer.parseInt(args[2]);

        ColorHSB targetColor = new ColorHSB(h, s, b); // target color

        String closestColorName = null;
        ColorHSB closestColor = null;
        int closestDistance = Integer.MAX_VALUE;

        while (!StdIn.isEmpty()) {
            String colorName = StdIn.readString();
            int hue = StdIn.readInt();
            int saturation = StdIn.readInt();
            int brightness = StdIn.readInt();
            ColorHSB currentColor = new ColorHSB(hue, saturation, brightness);
            int distance = targetColor.distanceSquaredTo(currentColor);

            if (distance < closestDistance) {
                closestDistance = distance;
                closestColorName = colorName;
                closestColor = currentColor;
            }
        }
        if (closestColor != null) {
            StdOut.println(closestColorName + " " + closestColor.toString());
        }
    }
}

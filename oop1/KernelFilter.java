/* *****************************************************************************
 *  Name:              Ada Lovelace
 *  Coursera User ID:  123456
 *  Last modified:     October 16, 1842
 **************************************************************************** */

import java.awt.Color;

public class KernelFilter {

    // Asegurarse de que el valor resultante esté en el rango [0, 255]
    private static int format(double v) {
        if (v < 0) return 0;
        if (v > 255) return 255;
        return (int) Math.round(v);
    }


    private static Picture aplykernel(Picture picture, double[][] kernel) {
        // Creamos una nueva imagen de las mismas caracteristicas que la imagen original
        Picture target = new Picture(picture);
        // width es anchura y height es altura , row es fila y col columna
        for (int trow = 0; trow < picture.height(); trow++) {
            for (int tcol = 0; tcol < picture.width(); tcol++) {
                double sumR = 0;
                double sumG = 0;
                double sumB = 0;

                // Iteramos sobre cada píxel vecino del kernel en la imagen original
                for (int ky = 0; ky < kernel.length; ky++) {
                    for (int kx = 0; kx < kernel[ky].length; kx++) {
                        // Calculamos la posición del píxel vecino
                        int px = Math.floorMod(tcol + kx - kernel[ky].length / 2, picture.width());
                        int py = Math.floorMod(trow + ky - kernel.length / 2, picture.height());

                        // Obtenemos el color del píxel vecino y su peso en el kernel
                        Color color = picture.get(px, py);
                        int red = color.getRed();
                        int green = color.getGreen();
                        int blue = color.getBlue();

                        double weight = kernel[ky][kx]; // valor del peso correspondiente
                        // Acumulamos los valores ponderados por el peso del kernel
                        sumR += red * weight;
                        sumG += green * weight;
                        sumB += blue * weight;
                    }
                }

                Color tcolor = new Color(format(sumR), format(sumG), format(sumB));
                target.set(tcol, trow, tcolor);
            }
        }

        return target;
    }

    public static Picture gaussian(Picture picture) {
        double[][] weights = {
                { (double) 1 / 16, (double) 2 / 16, (double) 1 / 16 },
                { (double) 2 / 16, (double) 4 / 16, (double) 2 / 16 },
                { (double) 1 / 16, (double) 2 / 16, (double) 1 / 16 },
                };

        return aplykernel(picture, weights);
    }

    private static Picture identity(Picture picture) {
        double[][] weights = {
                { 0, 0, 0 },
                { 0, 1, 0 },
                { 0, 0, 0 },
                };

        return aplykernel(picture, weights);
    }

    // Returns a new picture that applies a sharpen filter to the given picture.
    public static Picture sharpen(Picture picture) {
        double[][] weights = {
                { 0, -1, 0 },
                { -1, 5, -1 },
                { 0, -1, 0 },
                };

        return aplykernel(picture, weights);
    }

    public static Picture laplacian(Picture picture) {
        double[][] weights = {
                { -1, -1, -1 },
                { -1, 8, -1 },
                { -1, -1, -1 },
                };

        return aplykernel(picture, weights);
    }

    // Returns a new picture that applies an emboss filter to the given picture.
    public static Picture emboss(Picture picture) {
        double[][] weights = {
                { -2, -1, 0 },
                { -1, 1, 1 },
                { 0, 1, 2 },
                };

        return aplykernel(picture, weights);
    }

    // Returns a new picture that applies a motion blur filter to the given picture.
    public static Picture motionBlur(Picture picture) {
        double[][] weights = {
                { (double) 1 / 9, 0, 0, 0, 0, 0, 0, 0, 0 },
                { 0, (double) 1 / 9, 0, 0, 0, 0, 0, 0, 0 },
                { 0, 0, (double) 1 / 9, 0, 0, 0, 0, 0, 0 },
                { 0, 0, 0, (double) 1 / 9, 0, 0, 0, 0, 0 },
                { 0, 0, 0, 0, (double) 1 / 9, 0, 0, 0, 0 },
                { 0, 0, 0, 0, 0, (double) 1 / 9, 0, 0, 0 },
                { 0, 0, 0, 0, 0, 0, (double) 1 / 9, 0, 0 },
                { 0, 0, 0, 0, 0, 0, 0, (double) 1 / 9, 0 },
                { 0, 0, 0, 0, 0, 0, 0, 0, (double) 1 / 9 },
                };

        return aplykernel(picture, weights);
    }

    public static void main(String[] args) {
        Picture source = new Picture(args[0]);
        Picture g = gaussian(source);
        Picture s = sharpen(source);
        Picture i = identity(source);
        Picture lp = laplacian(source);
        Picture e = emboss(source);
        Picture m = motionBlur(source);

        g.show();
        s.show();
        i.show();
        lp.show();
        e.show();
        m.show();
    }

}

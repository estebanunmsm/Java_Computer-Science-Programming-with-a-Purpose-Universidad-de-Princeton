/* *****************************************************************************
 *  Name:              Ada Lovelace
 *  Coursera User ID:  123456
 *  Last modified:     October 16, 1842
 **************************************************************************** */

public class Complex {
    private final double real;
    private final double imag;

    public Complex(double real, double imag) {
        this.real = real;
        this.imag = imag;
    }

    public Complex plus(Complex other) {
        double newReal = this.real + other.getReal();
        double newImag = this.imag + other.getImag();
        return new Complex(newReal, newImag);
    }

    public Complex times(Complex other) {
        double newReal = this.real * other.getReal() - this.imag * other.getImag();
        double newImag = this.real * other.getImag() + this.imag * other.getReal();
        return new Complex(newReal, newImag);
    }

    public double abs() {
        return Math.sqrt(real * real + imag * imag);
    }

    public double getReal() {
        return real;
    }

    public double getImag() {
        return imag;
    }

    public String toString() {
        return real + " + " + imag + "i";
    }

    public static void main(String[] args) {
        Complex z0 = new Complex(-0.5, 0.0);
        Complex z = z0;
        z = z.times(z);
        // z = z.plus(z0);
        // z = z.times(z).plus(z0);
        System.out.println(z);
    }
}

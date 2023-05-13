public class ActivationFunction {

    // Retorna la funcion heaviside de x
    public static double heaviside(double x) {
        if (Double.isNaN(x)) return Double.NaN;
        if (x < 0) return 0;
        if (x == 0) return 0.5;
        return 1;
    }
    // Retorna la funcion sigmoide de x
    public static double sigmoid(double x) {
        if (Double.isNaN(x)) return Double.NaN;
        double sigma = 1 / (1 + Math.exp(-1 * x));
        return sigma;
    }
    // Retorna la tangente hiperbolica de x
    public static double tanh(double x) {
        if (Double.isNaN(x)) return Double.NaN;
        if (x >= 20) return 1.0;
        if (x <= -20) return -1.0;
        double tanh = (Math.exp(x) - Math.exp(-1*x))/(Math.exp(x) + Math.exp(-1*x));
        return tanh;
    }
    // Retorna la funcion soft sign de x
    public static double softsign(double x) {
        if (Double.isNaN(x)) return Double.NaN;
        if (x == Double.POSITIVE_INFINITY) return 1;
        if (x == Double.NEGATIVE_INFINITY) return -1;
        return x / (1 + Math.abs(x));
    }
    // Retorna la funcion square nonlinearity de x
    public static double sqnl(double x) {
        if (Double.isNaN(x)) return Double.NaN;
        if (x <= -2) return -1;
        if ((x > -2) && (x < 0)) return x + (x*x/4);
        if ((x >= 0) && (x < 2)) return x - (x*x/4);
        return 1;
    }
    public static void main(String[] args) {
        double x = Double.parseDouble(args[0]);
        StdOut.print("heaviside(" + x + ")\t = \t" + heaviside(x) + "\n");
        StdOut.print("  sigmoid(" + x + ")\t = \t" + sigmoid(x) + "\n");
        StdOut.print("     tanh(" + x + ")\t = \t" + tanh(x) + "\n");
        StdOut.print("softsign(" + x + ")\t = \t" + softsign(x) + "\n");
        StdOut.print("sqnl(" + x + ")\t = \t" + sqnl(x) + "\n");
    }
}

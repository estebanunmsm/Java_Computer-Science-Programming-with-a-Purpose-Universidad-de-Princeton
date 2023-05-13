public class Divisors {

    // Retorna el maximo comun divisor de a y b
    public static int gcd(int a, int b) {
        a = Math.abs(a);
        b = Math.abs(b);
        if (a < b) {
            int aux = a;
            a = b;
            b = aux;
        }
        while (b != 0) {
            int aux2 = a;
            a = b;
            b = aux2 % b;
        }
        return a;
    }

    // Retorna el minimo comun multiplo de a y b
    public static int lcm(int a, int b) {
        if (gcd(a, b) == 0) return 0;
        return (Math.abs(a)/gcd(a, b))*Math.abs(b);
    }

    // Retorna true si a y b son relativamente primos, falso en caso contrario.
    public static boolean areRelativelyPrime(int a, int b) {
        return gcd(a, b) == 1;
    }

    // Retorna el número de enteros entre 1 y n que son relativamente primos con n.
    public static int totient(int n) {
        if (n <= 0) return 0;

        int count = 1;
        for (int i = 2; i < n; i++) {
            if (areRelativelyPrime(n, i)) count++;
        }
        return count;
    }
    public static void main(String[] args) {
        int a = Integer.parseInt(args[0]);
        int b = Integer.parseInt(args[1]);

        StdOut.print("gcd(" + a + ", " + b + ") = " + gcd(a, b) + "\n");
        StdOut.print("lcm(" + a + ", " + b + ") = " + lcm(a, b) + "\n");
        StdOut.println("areRelativelyPrime("+a+", "+b+") = "+areRelativelyPrime(a, b));
        StdOut.print("totient(" + a + ") = " + totient(a) + "\n");
        StdOut.print("totient(" + b + ") = " + totient(b) + "\n");
    }
}

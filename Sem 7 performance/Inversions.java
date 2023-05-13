public class Inversions {

    // Devuelve el número de inversiones en la permutación a[].
    public static long count(int[] a) {
        long count = 0;
        for (int i = 0; i < a.length; i++) {
            for (int j = i+1; j < a.length; j++) {
                if (a[i] >  a[j]) count++;
            }
        }
        return count;
    }

    // Devuelve una permutación de longitud n con exactamente k inversiones.
    // El método generate() debería tardar un tiempo proporcional a n en el peor de los casos.
    public static int[] generate(int n, long k) {
        int[] a = new int[n];
        if (k == 0) {
            for (int i = 0; i < n; i++) {
                a[i] = i;
            }
            return a;
        }
        if (k == n * (n - 1) / 2) {
            for (int i = 0; i < n; i++) {
                a[i] = n - 1 - i;
            }
            return a;
        }
        /* while con 3 CONDICIONES
        for (int i = 0; i < n; i++) {
            int j = 1;
            long aux = 0;
            if (a[i] < a[j] && i < j) {
                int temp = a[i];
                a[i] = a[j];
                a[j] = temp;

            }
        }
        */
        int pos = n - 1;
        int start = 0;
        int end = n - 1;
        while (start != end) {
            //System.out.println("pos " + pos + ", k: " + k);
            if (k >= pos) {
                a[start] = pos;
                k = k - pos;
                start++;
            }
            else {
                a[end] = pos;
                end--;
            }
            pos--;
        }

        return a;
    }

    // Toma un entero n y un largo k como argumentos por línea de comandos
    // e imprime una permutación de longitud n con exactamente k inversiones.
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        int k = Integer.parseInt(args[1]);
        int[] c = generate(n, k);
        for (int i = 0; i < c.length; i++) {
            StdOut.print(c[i] + " ");
        }
    }
}

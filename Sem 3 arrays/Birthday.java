public class Birthday {
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]); // número de posibles cumpleaños
        int trials = Integer.parseInt(args[1]); // número de pruebas a realizar

        int[] count = new int[n+1]; // [i] = cuántas veces exactamente i personas entran en la habitación

        for (int t = 0; t < trials; t++) {
            // todos sus elementos se inicializan por defecto en false.
            // hasBirthday[i] = true si alguien con cumpleaños i está en la habitación
            boolean[] hasBirthday = new boolean[n];
            int people = 0; // número de personas que han entrado en la sala hasta el momento
            while (true) {
                int birthday = (int) (Math.random() * n); // elige un cumpleaños al azar entre 0 y n
                people++;
                if (hasBirthday[birthday]) {
                    break; // encontrado un cumpleaños duplicado
                }
                hasBirthday[birthday] = true;
            }
            if (people <= n) {
                count[people]++;
            }
        }

        double fraction = 0;
        System.out.printf("%d\t%d\t%.1f\n", 1, count[1], 0.0);
        for (int i = 2; i <= n; i++) {
            fraction += (double) count[i] / trials;
            System.out.printf("%d\t%d\t%.6f\n", i, count[i], fraction);
            if (fraction >= 0.5) {
                break;
            }
        }
    }
}

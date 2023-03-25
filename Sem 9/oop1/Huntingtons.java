/* *****************************************************************************
 *  Name:              Ada Lovelace
 *  Coursera User ID:  123456
 *  Last modified:     October 16, 1842
 **************************************************************************** */

public class Huntingtons {
    // Devuelve el número máximo de repeticiones consecutivas de CAG
    // en la cadena de ADN (DNA).
    public static int maxRepeats(String dna) {
        int n = dna.length();
        int maxCount = 0;
        int count = 0;

        int i = 0;
        while (i <= n - 3) {
            if (dna.charAt(i) == 'C') {
                String condon = dna.substring(i, i + 3);
                if (condon.equals("CAG")) {
                    count++;
                    maxCount = Math.max(count, maxCount);
                    i += 3;
                    continue;
                }
            }
            count = 0;
            i++;
        }
        return maxCount;

    }

    // Devuelve una copia de s , con todos los espacios en blanco removidos.
    public static String removeWhitespace(String s) {
        return s.replace("\n", "").replace("\t", "").replace(" ", "");
    }

    // Devuelve uno de estos diagnósticos correspondientes al número máximo de repeticiones:
    // "no humano", "normal", "alto riesgo" o "Huntington".
    public static String diagnose(int maxRepeats) {
        if (maxRepeats <= 9 || maxRepeats >= 181) return "not human\n";
        if (maxRepeats <= 35) return "normal\n";
        if (maxRepeats <= 39) return "high risk\n";
        return "Huntington’s\n";
    }

    public static void main(String[] args) {
        String filename = args[0];
        In in = new In(filename);

        String data = in.readAll();
        String dna = removeWhitespace(data);
        int maxRepeats = maxRepeats(dna);

        StdOut.println("max repeats = " + maxRepeats);
        StdOut.println(diagnose(maxRepeats));
    }
}

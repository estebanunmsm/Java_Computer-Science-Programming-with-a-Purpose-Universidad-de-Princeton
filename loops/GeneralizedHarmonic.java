
// Escribe un programa GeneralizedHarmonic.java que tome dos argumentos enteros n y r
// y utilice un bucle for para calcular el enésimo número armónico
// generalizado de orden r,que se define mediante la siguiente fórmula:
// H(n,r)=11r+12r+⋯+1nr. Por ejemplo, H(3,2)=112+122+132=4936≈1,361111
public class GeneralizedHarmonic {
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        int r = Integer.parseInt(args[1]);

        double sum = 0;

        for (int i = 1; i <= n; i++) {

            sum += 1/Math.pow(i, r);
        }

        System.out.println(sum);
    }

}
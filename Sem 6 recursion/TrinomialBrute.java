public class TrinomialBrute {

    // Returns the trinomial coefficient T(n, k).
    public static long trinomial(int n, int k) {
        if (n == 0 && k == 0) return 1;
        if (k < -1*n || k > n) return 0;
        return trinomial(n-1, k-1)  + trinomial(n-1, k)+ trinomial(n-1, k+1);
    }

    // Takes two integer command-line arguments n and k and prints T(n, k).
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        int k = Integer.parseInt(args[1]);
        long q = trinomial(n, k);
        StdOut.println(q);
    }
}

public class TrinomialDP {

    // Returns the trinomial coefficient T(n, k).
    public static long trinomial(int n, int k) {
        k = Math.abs(k);

        long[][] tri = new long[n + 3][k + 3];
        tri[0][0] = 1;
        tri[1][0] = 1;
        for (int j = 1; j <= k; j++) tri[0][j] = 0;
        // Why `n+1`?
        for (int i = 1; i <= n + 1; i++) {
            for (int j = 0; j <= k + 1; j++) {
                if (j == 0) {
                    tri[i][j] = tri[i - 1][1] + tri[i - 1][0] + tri[i - 1][1];
                }
                else if (j > i) {
                    tri[i][j] = 0;
                    // continue;
                }
                else {
                    tri[i][j] = tri[i - 1][j - 1] + tri[i - 1][j] + tri[i - 1][j + 1];
                }
            }
        }
        return tri[n][k];
    }
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        int k = Integer.parseInt(args[1]);

        StdOut.println(trinomial(n, k));
    }
}

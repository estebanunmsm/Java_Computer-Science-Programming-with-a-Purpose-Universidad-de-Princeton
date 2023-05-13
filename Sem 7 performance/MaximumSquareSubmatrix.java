public class MaximumSquareSubmatrix {
    public static int size(int[][] a) {
        if (a.length == 0) return 0;

        int n = a.length;
        int[] dp = new int[n + 1];
        int maxLen = 0;
        int prev = 0;

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                int temp = dp[j];
                if (a[i - 1][j - 1] == 1) {
                    dp[j] = Math.min(Math.min(dp[j - 1], prev), dp[j]) + 1;
                    maxLen = Math.max(dp[j], maxLen);
                }
                else {
                    dp[j] = 0;
                }
                prev = temp;
            }
        }

        return maxLen;
    }

    // Reads an n-by-n matrix of 0s and 1s from standard input
    // and prints the size of the largest contiguous square submatrix
    // containing only 1s.
    public static void main(String[] args) {
        int value = StdIn.readInt();
        int[][] a = new int[value][value];

        while (!StdIn.isEmpty()) {
            for (int j = 0; j < value; j++) {
                for (int i = 0; i < value; i++) {
                    a[i][j] = StdIn.readInt();
                }
            }
        }

        StdOut.println(size(a));
    }
}

public class ThueMorse {
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        int[][] pattern = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int count = 0;
                for (int k = i; k > 0; k >>= 1) {
                    count += (k & 1);
                }
                for (int k = j; k > 0; k >>= 1) {
                    count += (k & 1);
                }
                pattern[i][j] = count % 2;
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (pattern[i][j] == 0) {
                    System.out.print("+  ");
                } else {
                    System.out.print("-  ");
                }
            }
            System.out.println();
        }
    }
}
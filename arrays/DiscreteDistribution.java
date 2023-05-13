/******************************************************************************
 *  Compilation:  javac DiscreteDistribution.java
 *  Execution:    java DiscreteDistribution freq0 freq1 freq2 ...
 */
public class DiscreteDistribution {
    public static void main(String[] args) {
        int m = Integer.parseInt(args[0]);
        int n = args.length;
        int[] freq = new int[m];
        int[] asub = new int[n];
        int[] sumN = new int[n];
        sumN[0] = 0;

        for (int i = 0; i < n-1; i++) {
            asub[i] = Integer.parseInt(args[i+1]);
        }

        for (int i = 1; i < n; i++) {
            sumN[i] = sumN[i-1]+asub[i-1];
        }

        for (int i = 0; i < m; i++) {
            int r = (int) (sumN[n-1] * Math.random());
            for (int j = 1; j < n; j++) {
                boolean b = (r < sumN[j]) && (r >= sumN[j-1]);
                if (b) freq[i] = j;
            }
            System.out.print(freq[i]+" ");
        }
    }
}
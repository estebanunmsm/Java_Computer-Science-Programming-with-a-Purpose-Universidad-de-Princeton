public class ShannonEntropy
{
    public static void main(String[] args)
    {
        int m = Integer.parseInt(args[0]);
        int[] a = new int[m+1];
        int n = 0;
        double entropy = 0.0;
        while (!StdIn.isEmpty())
        {
            int value = StdIn.readInt();
            a[value]++;
            n++;
        }
        for (int i = 1; i <= m; i++)
        {
            double p = (double) a[i] / n;
            if (a[i] > 0) entropy += (-1.0)* p * (Math.log(p) / Math.log(2));
        }
        StdOut.printf("%.4f\n", entropy);
    }
}

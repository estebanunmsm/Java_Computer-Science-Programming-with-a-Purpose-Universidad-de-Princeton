/* *****************************************************************************
 *  Name:              Ada Lovelace
 *  Coursera User ID:  123456
 *  Last modified:     October 16, 1842
 **************************************************************************** */

public class floor {
    private static int reflect(int p, int max) {
        if (p < 0) {
            return -p - 1;
        }
        if (p >= max) {
            return 2 * max - 1 - p;
        }
        return p;
    }

    public static void main(String[] args) {
        int a = -3;
        int b = 2;
        int c = a / b;
        System.out.println(Math.floorMod(c, 720));
        System.out.println(reflect(c, 720));
    }
}

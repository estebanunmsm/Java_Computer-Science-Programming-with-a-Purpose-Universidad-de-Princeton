public class AudioCollage {
    // Returns a new array that rescales a[] by a multiplicative factor of alpha.
    public static double[] amplify(double[] a, double alpha) {
        double[] amp = new double[a.length];
        if (alpha < 0) alpha = 0;

        for (int i = 0; i < a.length; i++) {
            amp[i] = alpha * a[i];
        }
        return amp;
    }

    // Returns a new array that is the reverse of a[].
    public static double[] reverse(double[] a) {
        int len = a.length;
        double[] rev = new double[len];
        for (int i = 0; i < len; i++) {
            rev[i] = a[i];
        }
        for (int i = 0; i < len / 2; i++) {
            double temp = rev[i];
            rev[i] = rev[len - 1 - i];
            rev[len - 1 - i] = temp;
        }
        return rev;
    }

    // Returns a new array that is the concatenation of a[] and b[].
    public static double[] merge(double[] a, double[] b) {
        int m = a.length;
        int n = b.length;
        double[] merge = new double[m+n];
        for (int i = 0; i < m; i++) {
            merge[i] = a[i];
        }
        for (int i = 0; i < n; i++) {
            merge[m + i] = b[i];
        }
        return merge;
    }

    // Returns a new array that is the sum of a[] and b[],
    // padding the shorter arrays with trailing 0s if necessary.
    public static double[] mix(double[] a, double[] b) {
        int m = a.length;
        int n = b.length;
        if (m > n) {
            double[] mix = new double[m];
            for (int i = 0; i < n; i++) mix[i] = a[i] + b[i];
            for (int i = 0; i < m-n; i++) mix[n+i] = a[n+i];
            return mix;
        }
        else {
            double[] mix = new double[n];
            for (int i = 0; i < m; i++) mix[i] = a[i] + b[i];
            for (int i = 0; i < n-m; i++) mix[m+i] = b[m+i];
            return mix;
        }
    }

    // Returns a new array that changes the speed by the given factor.
    public static double[] changeSpeed(double[] a, double alpha) {
        int sampleLen = (int) Math.floor(a.length / alpha);
        double[] c = new double[sampleLen];

        for (int i = 0; i < sampleLen; i++) {
            c[i] = a[(int) Math.floor(i * alpha)];
        }
        return c;
    }

    // Creates an audio collage and plays it on standard audio.
    // See below for the requirements.
    public static void main(String[] args) {
        double alpha = 0.5;
        double[] bbSound = StdAudio.read("beatbox.wav");
        double[] pianoSound = StdAudio.read("piano.wav");
        double[] singerSound = StdAudio.read("singer.wav");
        double[] cowSound = StdAudio.read("cow.wav");
        double[] harpSound = StdAudio.read("harp.wav");
        StdAudio.play(amplify(bbSound, alpha));
        StdAudio.play(reverse(pianoSound));
        StdAudio.play(merge(singerSound, bbSound));
        StdAudio.play(mix(cowSound, bbSound));
        StdAudio.play(changeSpeed(harpSound, alpha));
    }
}

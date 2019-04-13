/*************************************************************************
 *  Compilation:  javac StdRandom.java
 *  Execution:    java StdRandom
 *
 *************************************************************************/

public class StdRandom {

    // return a real number uniformly between a and b
    public static double uniform(double a, double b) {
        return a + Math.random() * (b-a);
    }

    // return an integer uniformly between 0 and N-1
    public static int uniform(int N) {
        return (int) (Math.random() * N);
    }

    // take as input an array of strings and rearrange them in random order
    public static void shuffle(int[] a) {
        int N = a.length;
        for (int i = 0; i < N; i++) {
            int r = i + uniform(N-i);     // between i and N-1
            int temp = a[i];
            a[i] = a[r];
            a[r] = temp;
        }
    }



} 
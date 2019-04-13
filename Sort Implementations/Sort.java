public class Sort {

    private static void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }


    /**
     * Selection Sort
     * Using (N-1)+(N-2)+(N-3)+(N-4)+...+1+0 ~ (N^2)/2 compares and N exchanges
     * Not stable: Long-distance exchange can move one equal item past another one
     * Time complexity: 1/2(N^2)(best,average,worst)
     */
    private static void selectionSort(int[] a) {
        int N = a.length;
        for (int i = 0; i < N; i++) {
            int min = i;
            for (int j = i + 1; j < N; j++) {
                if (a[j] < a[min]) min = j;
            }
            swap(a, i, min);
        }
    }

    /**
     * Insertion Sort
     * Stable: Equal items never move past each other
     * Time complexity: N(best), 1/4(N^2)(average), 1/2(N^2)(guarantee)
     */
    private static void insertionSort(int[] a) {
        int N = a.length;
        for (int i = 0; i < N; i++) {
            for (int j = i; j > 0; j--) {
                if (a[j] < a[j - 1]) swap(a, j, j - 1);
                else break;
            }
        }

    }

    /**
     * Shell Sort
     * Not Stable
     * Time complexity: N*log3 N(best), ?(average), C(N^(3/2))(guarantee)
     */
    private static void shellSort(int[] a) {
        int N = a.length;

        int h = 1;
        while (h < N / 3) h = 3 * h + 1; // 1, 4, 13, 40, 121...  3x + 1 increment sequence

        while (h >= 1) {
            for (int i = h; i < N; i++) {
                for (int j = i; j >= h && a[j] < a[j - h]; j -= h) {
                    swap(a, j, j - h);
                }
            }
            h = h / 3; // move to next increment
        }
    }

    /**
     * Quick Sort: partition follow the rule(put items less than v in the left half, while more than v in the right half)
     * Time complexity: N*lgN(best), 1.39N*lgN(average), 1/2(N^2)(worst)
     */
    private static void quickSort(int[] a) {
        quickSort(a, 0, a.length - 1);
    }

    private static void quickSort(int[] a, int lo, int hi) {
        if (hi <= lo) return;
        int j = partition(a, lo, hi);
        quickSort(a, lo, j - 1);
        quickSort(a, j + 1, hi);
    }

    private static int partition(int[] a, int lo, int hi) {
        int i = lo, j = hi + 1;
        while (true) {
            // find item on left to swap
            while (a[++i] < a[lo]) {
                if (i == hi) break;
            }
            // find item on right to swap
            while (a[lo] < a[--j]) {
                if (j == lo) break;
            }
            if (i >= j) break;
            swap(a, i, j);
        }
        // put v into median
        swap(a, lo, j);
        return j;
    }

    /**
     * Merge Sort
     * Stable
     * Using <= N*logN compares: C(N) <= C([N/2]) + C([N/2]) + N, N > 1  and with C(1) = 0.   left half + roght half + merge
     * Three improvements in the code.
     * Time complexity:
     * Space complexity:
     */
    private static void mergeSort(int[] a) {
        int[] aux = new int[a.length];
        mergeSort(a, aux, 0, a.length - 1);
    }

    private static void mergeSort(int[] a, int[] aux, int lo, int hi) {
        if (hi <= lo) return;
        /* Using Insertion sort for small sub arrays. CUTOFF ~ 7
        if(hi<=lo + CUTOFF - 1){
            Insertion.sort(a, lo, hi);
            return;
        }
         */
        int mid = lo + (hi - lo) / 2;
        mergeSort(a, aux, lo, mid);
        mergeSort(a, aux, mid + 1, hi);
        /* Skip merge if already in order
            if(a[mid + 1] >= a[mid]) return;
         */
        merge(a, aux, lo, mid, hi);
    }

    private static void merge(int[] a, int[] aux, int lo, int mid, int hi) {

        // copy a to aux
        for (int k = lo; k <= hi; k++) {
            aux[k] = a[k];
        }

        int i = lo, j = mid + 1;
        for (int k = lo; k <= hi; k++) {
            if (i > mid) {
                a[k] = aux[j++];
            } else if (j > hi) {
                a[k] = aux[i++];
            } else if (aux[j] < aux[i]) {
                a[k] = aux[j++];
            } else {
                a[k] = aux[i++];
            }
        }

    }

    public static void main(String[] args) {
        int[] n = new int[50];
        for (int i = 0; i < 50; i++) {
            n[i] = 60 - i;
        }

        mergeSort(n);
        for (int i : n) {
            System.out.print(i + " ");
        }
        System.out.println("merge sort");

        StdRandom.shuffle(n);
        quickSort(n);
        for (int i : n) {
            System.out.print(i + " ");
        }
        System.out.println("quick sort");

        StdRandom.shuffle(n);
        selectionSort(n);
        for (int i : n) {
            System.out.print(i + " ");
        }
        System.out.println("selection sort");

        StdRandom.shuffle(n);
        insertionSort(n);
        for (int i : n) {
            System.out.print(i + " ");
        }
        System.out.println("insertion sort");


        StdRandom.shuffle(n);
        shellSort(n);
        for (int i : n) {
            System.out.print(i + " ");
        }
        System.out.println("shell sort");

    }
}

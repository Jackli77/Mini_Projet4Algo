/*
Robin Verschuren
 */

public class quickSort {

    public static void sort(int[] a) {
        sort(a, 0, a.length - 1);
    }

    private static void sort(int[] a, int lo, int hi) {
        if (lo >= hi) return;

        int pivot = partition(a, lo, hi);
        sort(a, lo, pivot-1);   // pivot est déjà à la bonne place dans l'array.
        sort(a, pivot+1, hi);
    }

    private static int partition(int[] a, int lo, int hi) {
        int i = lo;
        int j = hi + 1;
        int pivot = a[lo];

        while(true) {
            while(pivot > a[++i]) if (i == hi) break;  // premier plus grand que le pivot low=>high
            while(pivot < (a[--j])) if (j == lo) break;  // premier plus petit que le pivot high=>low

            if (j <= i) break;

            int temp = a[i];
            a[i] = a[j];
            a[j] = temp;
        }
        int temp = a[j];
        a[j] = a[lo];
        a[lo] = temp;

        return j;  // Adresse du pivot. Tout ce qui est avant l'index j est plus petit que le pivot. Droite plus grand
    }
}

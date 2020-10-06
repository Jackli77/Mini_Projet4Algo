// Louis Colinet

public class insertionSort {

    public static void sort(int[] a){
        int l = a.length;
        for(int i = 0; i < l; i++){
            int x = a[i];
            int j = i;
            while(j > 0 && a[j-1] > x){
                a[j] = a[j-1];
                j--;
            }
            a[j] = x;
        }
    }
}

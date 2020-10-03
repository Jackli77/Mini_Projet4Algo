public class selection_sort {

    public void sort(int[] tab){
        int n = tab.length;
        for(int i = 0; i<n-1; i++){
            int min = i;
            for(int j = i+1; j<n; j++){
                if(tab[j] < tab[min]){
                    min = j;
                }
            }
            if(tab[min] != tab[i]) {
                int t = tab[min];
                tab[min] = tab[i];
                tab[i] = t;
            }
        }
    }

    public static void main(String[] args) {
        int[] tabtest = {6, 4, 2, 8, 7, 4, 12, 0, -3, 5};

        selection_sort selec = new selection_sort();

        selec.sort(tabtest);
        for(int i= 0; i<tabtest.length; i++)
            System.out.println(tabtest[i]);
    }
}

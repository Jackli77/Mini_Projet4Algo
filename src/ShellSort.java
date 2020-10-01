public class ShellSort {
    public void sort(int[] array){
        int gap = array.length/2;
        while(gap > 0){
            for(int i = gap;i < array.length;i++){
                int temp = array[i];
                int j = i;
                while (j >= gap && array[j-gap] >temp) {
                    array[j] = array[j - gap];
                    j -= gap;
                }
                array[j] = temp;
            }
            gap/=2;
            }
        }
    public static void printArray(int[] array){
        for(int i:array){
            System.out.print(" "+i);
        }
        System.out.print("\n");
    }

    public static void main(String args[]) {
        int arr[] = {12, 34, 54, 2, 3};
        System.out.println("Array before sorting");
        printArray(arr);

        ShellSort ob = new ShellSort();
        ob.sort(arr);

        System.out.println("Array after sorting");
        printArray(arr);
    }
}

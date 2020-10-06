/*
Guang Li
 */

import java.util.Arrays;
import java.util.Random;
public class timeDrawer {
    int[] bigg_arr;
    int[] bigg_arr2;
    int[] bigg_arr3;
    int[] bigg_arr4;

    public static void main(String[] args) {
        timeDrawer td = new timeDrawer();
        long[] shellTime = new long[4];
        long startTime;
        long endTime;
        //SHELL
        td.array_initializer();
        shellSort sh = new shellSort();

        startTime = System.nanoTime();
        sh.sort(td.bigg_arr);
        endTime = System.nanoTime();
        shellTime[0] = endTime - startTime;

        startTime = System.nanoTime();
        sh.sort(td.bigg_arr2);
        endTime = System.nanoTime();
        shellTime[1] = endTime - startTime;

        startTime = System.nanoTime();
        sh.sort(td.bigg_arr3);
        endTime = System.nanoTime();
        shellTime[2] = endTime - startTime;

        startTime = System.nanoTime();
        sh.sort(td.bigg_arr4);
        endTime = System.nanoTime();
        shellTime[3] = endTime - startTime;


        /*//SELECTION
        td.array_initializer();
        selectionSort sel = new selectionSort();
        long[] selectTime = new long[4];

        startTime = System.nanoTime();
        sel.sort(td.bigg_arr);
        endTime = System.nanoTime();
        selectTime[0] = endTime - startTime;

        startTime = System.nanoTime();
        sel.sort(td.bigg_arr2);
        endTime = System.nanoTime();
        selectTime[1] = endTime - startTime;

        startTime = System.nanoTime();
        sel.sort(td.bigg_arr3);
        endTime = System.nanoTime();
        selectTime[2] = endTime - startTime;

        startTime = System.nanoTime();
        sel.sort(td.bigg_arr4);
        endTime = System.nanoTime();
        selectTime[3] = endTime - startTime;
*/
        //QUICK
        td.array_initializer();
        long[] quickTime = new long[4];

        startTime = System.nanoTime();
        quickSort.sort(td.bigg_arr);
        endTime = System.nanoTime();
        quickTime[0] = endTime - startTime;

        startTime = System.nanoTime();
        quickSort.sort(td.bigg_arr2);
        endTime = System.nanoTime();
        quickTime[1] = endTime - startTime;

        startTime = System.nanoTime();
        quickSort.sort(td.bigg_arr3);
        endTime = System.nanoTime();
        quickTime[2] = endTime - startTime;

        startTime = System.nanoTime();
        quickSort.sort(td.bigg_arr4);
        endTime = System.nanoTime();
        quickTime[3] = endTime - startTime;

        //JAVA NATIVE
        td.array_initializer();
        long[] javaTime = new long[4];

        startTime = System.nanoTime();
        Arrays.sort(td.bigg_arr);
        endTime = System.nanoTime();
        javaTime[0] = endTime - startTime;

        startTime = System.nanoTime();
        Arrays.sort(td.bigg_arr2);
        endTime = System.nanoTime();
        javaTime[1] = endTime - startTime;

        startTime = System.nanoTime();
        Arrays.sort(td.bigg_arr3);
        endTime = System.nanoTime();
        javaTime[2] = endTime - startTime;

        startTime = System.nanoTime();
        Arrays.sort(td.bigg_arr4);
        endTime = System.nanoTime();
        javaTime[3] = endTime - startTime;

        /*//Insertion
        td.array_initializer();
        long[] insertionTime = new long[4];

        startTime = System.nanoTime();
        insertionSort.sort(td.bigg_arr);
        endTime = System.nanoTime();
        insertionTime[0] = endTime - startTime;

        startTime = System.nanoTime();
        insertionSort.sort(td.bigg_arr2);
        endTime = System.nanoTime();
        insertionTime[1] = endTime - startTime;

        startTime = System.nanoTime();
        insertionSort.sort(td.bigg_arr3);
        endTime = System.nanoTime();
        insertionTime[2] = endTime - startTime;

        startTime = System.nanoTime();
        insertionSort.sort(td.bigg_arr4);
        endTime = System.nanoTime();
        insertionTime[3] = endTime - startTime;
*/
        // number of line segments to plot
        int n = 3;
        long[] x = {0, 1, 2, 3};
        long[] ysh = shellTime;
        //long[] yse = selectTime;
        long[] yqu = quickTime;
        long[] yja = javaTime;
        //long[] yin = insertionTime;
        long[][] all = {ysh,yqu,yja};
        for(long[] i:all){
            for(long j:i)
            System.out.println(j);
        }
        long[] biggest = {getMax(ysh), getMax(yqu), getMax(yja)};
        long max = getMax(biggest);
        // rescale the coordinate system
        StdDraw.setXscale(-1, 4);
        StdDraw.setYscale(-max*0.1, max*1.1);
        StdDraw.textRight(0,0,"0 sec");
        StdDraw.textRight(0,max,String.format("%d ms",max/1000000));
        StdDraw.textLeft(0,-max*0.05,"10 000 000");
        StdDraw.textLeft(1,-max*0.05,"20 000 000");
        StdDraw.textLeft(2,-max*0.05,"40 000 000");
        StdDraw.textLeft(3,-max*0.05,"80 000 000");
        StdDraw.text(1.5,max,"Temps d'exécution");
        StdDraw.line(0,-max*0.1,0, max*1.1);
        StdDraw.line(-1,0,4, 0);

        // plot the approximation to the function
        for (int i = 0; i < n; i++) {
            StdDraw.setPenColor(StdDraw.BLUE);
            StdDraw.line(x[i], ysh[i], x[i + 1], ysh[i + 1]);
            StdDraw.setPenColor(StdDraw.RED);
            //StdDraw.line(x[i], yse[i], x[i + 1], yse[i + 1]);
            StdDraw.setPenColor(StdDraw.GREEN);
            StdDraw.line(x[i], yqu[i], x[i + 1], yqu[i + 1]);
            StdDraw.setPenColor(StdDraw.BLACK);
            StdDraw.line(x[i], yja[i], x[i + 1], yja[i + 1]);
            StdDraw.setPenColor(StdDraw.PINK);
            //StdDraw.line(x[i], yin[i], x[i + 1], yin[i + 1]);
        }
    }

    public void array_initializer() {
        Random rand = new Random(40);
        bigg_arr = new int[10000000];
        for (int i = 0; i < bigg_arr.length; i++) {
            int v = rand.nextInt();
            bigg_arr[i] = v;
        }
        bigg_arr2 = new int[20000000];
        for (int i = 0; i < bigg_arr.length; i++) {
            int v = rand.nextInt();
            bigg_arr2[i] = v;
        }

        bigg_arr3 = new int[40000000];
        for (int i = 0; i < bigg_arr.length; i++) {
            int v = rand.nextInt();
            bigg_arr3[i] = v;
        }
        bigg_arr4 = new int[80000000];
        for (int i = 0; i < bigg_arr.length; i++) {
            int v = rand.nextInt();
            bigg_arr4[i] = v;
        }
    }

    public static long getMax(long[] inputArray) {
        long maxValue = inputArray[0];
        for (int i = 1; i < inputArray.length; i++) {
            if (inputArray[i] > maxValue) {
                maxValue = inputArray[i];
            }
        }
        return maxValue;
    }
}

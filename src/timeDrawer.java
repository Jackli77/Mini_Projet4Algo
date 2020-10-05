/*
Guang Li
 */

import java.util.Arrays;
import java.util.Random;
public class timeDrawer {
    int[] almost_sorted;
    int[] bigg_arr;
    int[] almost_sorted2;
    int[] bigg_arr2;

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
        sh.sort(td.almost_sorted);
        endTime = System.nanoTime();
        shellTime[2] = endTime - startTime;

        startTime = System.nanoTime();
        sh.sort(td.almost_sorted2);
        endTime = System.nanoTime();
        shellTime[3] = endTime - startTime;


        //SELECTION
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
        sel.sort(td.almost_sorted);
        endTime = System.nanoTime();
        selectTime[2] = endTime - startTime;

        startTime = System.nanoTime();
        sel.sort(td.almost_sorted2);
        endTime = System.nanoTime();
        selectTime[3] = endTime - startTime;

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
        quickSort.sort(td.almost_sorted);
        endTime = System.nanoTime();
        quickTime[2] = endTime - startTime;

        startTime = System.nanoTime();
        quickSort.sort(td.almost_sorted2);
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
        Arrays.sort(td.almost_sorted);
        endTime = System.nanoTime();
        javaTime[2] = endTime - startTime;

        startTime = System.nanoTime();
        Arrays.sort(td.almost_sorted2);
        endTime = System.nanoTime();
        javaTime[3] = endTime - startTime;

        // number of line segments to plot
        int n = 3;

        // the function y = sin(4x) + sin(20x), sampled at n+1 points
        // between x = 0 and x = pi
        long[] x = {0, 1, 2, 3};
        long[] ysh = shellTime;
        long[] yse = selectTime;
        long[] yqu = quickTime;
        long[] yja = javaTime;
        long[] biggest = {getMax(ysh), getMax(yse), getMax(yqu), getMax(yja)};
        long max = getMax(biggest);
        // rescale the coordinate system
        StdDraw.setXscale(-1, 4);
        StdDraw.setYscale(-max*0.1, max*1.1);
        StdDraw.textRight(0,0,"0 sec");
        StdDraw.textRight(0,max,String.format("%d ms",max/1000000));
        StdDraw.textLeft(0,-max*0.05,"Rand");
        StdDraw.textLeft(1,-max*0.05,"Randx2");
        StdDraw.textLeft(2,-max*0.05,"Asorted");
        StdDraw.textLeft(3,-max*0.05,"Asortedx2");
        StdDraw.text(1.5,max,"Temps d'éxécution");
        StdDraw.line(0,-max*0.1,0, max*1.1);
        StdDraw.line(-1,0,4, 0);

        // plot the approximation to the function
        for (int i = 0; i < n; i++) {
            StdDraw.setPenColor(StdDraw.BLUE);
            StdDraw.line(x[i], ysh[i], x[i + 1], ysh[i + 1]);
            StdDraw.setPenColor(StdDraw.RED);
            StdDraw.line(x[i], yse[i], x[i + 1], yse[i + 1]);
            StdDraw.setPenColor(StdDraw.GREEN);
            StdDraw.line(x[i], yqu[i], x[i + 1], yqu[i + 1]);
            StdDraw.setPenColor(StdDraw.BLACK);
            StdDraw.line(x[i], yja[i], x[i + 1], yja[i + 1]);
        }
    }

    public void array_initializer() {
        Random rand = new Random(40);
        bigg_arr = new int[5000];
        for (int i = 0; i < bigg_arr.length; i++) {
            int v = rand.nextInt();
            bigg_arr[i] = v;
        }
        bigg_arr2 = new int[10000];
        for (int i = 0; i < bigg_arr.length; i++) {
            int v = rand.nextInt();
            bigg_arr2[i] = v;
        }

        almost_sorted = new int[5000];
        for (int i = 0; i < almost_sorted.length; ++i) {
            almost_sorted[i] = i;
        }
        int temp = almost_sorted[200];
        almost_sorted[200] = almost_sorted[201];
        almost_sorted[201] = temp;

        almost_sorted2 = new int[10000];
        for (int i = 0; i < almost_sorted2.length; ++i) {
            almost_sorted2[i] = i;
        }
        int temp2 = almost_sorted2[200];
        almost_sorted2[200] = almost_sorted2[201];
        almost_sorted2[201] = temp2;
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

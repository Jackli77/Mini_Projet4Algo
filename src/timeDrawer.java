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
        //SHELL
        td.array_initializer();
        shellSort sh = new shellSort();

        long startTime = System.nanoTime();
        sh.sort(td.bigg_arr);
        long endTime   = System.nanoTime();
        long shellTime1 = endTime - startTime;

        startTime = System.nanoTime();
        sh.sort(td.bigg_arr2);
        endTime   = System.nanoTime();
        long shellTime2 = endTime - startTime;

        startTime = System.nanoTime();
        sh.sort(td.almost_sorted);
        endTime   = System.nanoTime();
        long shellTime3 = endTime - startTime;

        startTime = System.nanoTime();
        sh.sort(td.almost_sorted2);
        endTime   = System.nanoTime();
        long shellTime4 = endTime - startTime;

        //SELECTION
        td.array_initializer();
        selectionSort sel = new selectionSort();

        startTime = System.nanoTime();
        sel.sort(td.bigg_arr);
        endTime   = System.nanoTime();
        long selectTime = endTime - startTime;

        startTime = System.nanoTime();
        sel.sort(td.bigg_arr2);
        endTime   = System.nanoTime();
        long selectTime2 = endTime - startTime;

        startTime = System.nanoTime();
        sel.sort(td.almost_sorted);
        endTime   = System.nanoTime();
        long selectTime3 = endTime - startTime;

        startTime = System.nanoTime();
        sel.sort(td.almost_sorted2);
        endTime   = System.nanoTime();
        long selectTime4 = endTime - startTime;

        /*
        //QUICK
        td.array_initializer();
        startTime = System.nanoTime();
        quickSort.sort(td.bigg_arr);
        endTime   = System.nanoTime();
        long quickTime = endTime - startTime;

        startTime = System.nanoTime();
        quickSort.sort(td.bigg_arr2);
        endTime   = System.nanoTime();
        long quickTime2 = endTime - startTime;

        startTime = System.nanoTime();
        quickSort.sort(td.almost_sorted);
        endTime   = System.nanoTime();
        long quickTime3 = endTime - startTime;

        startTime = System.nanoTime();
        quickSort.sort(td.almost_sorted2);
        endTime   = System.nanoTime();
        long quickTime4 = endTime - startTime;

        */
        //JAVA NATIVE
        td.array_initializer();
        startTime = System.nanoTime();
        Arrays.sort(td.bigg_arr);
        endTime   = System.nanoTime();
        long javaTime = endTime - startTime;

        startTime = System.nanoTime();
        Arrays.sort(td.bigg_arr2);
        endTime   = System.nanoTime();
        long javaTime2 = endTime - startTime;

        startTime = System.nanoTime();
        Arrays.sort(td.almost_sorted);
        endTime   = System.nanoTime();
        long javaTime3 = endTime - startTime;

        startTime = System.nanoTime();
        Arrays.sort(td.almost_sorted2);
        endTime   = System.nanoTime();
        long javaTime4 = endTime - startTime;


        // number of line segments to plot
        int n = 4;

        // the function y = sin(4x) + sin(20x), sampled at n+1 points
        // between x = 0 and x = pi
        double[] x = new double[n+1];
        double[] y = new double[n+1];
        for (int i = 0; i <= n; i++) {
            x[i] = Math.PI * i / n;
            y[i] = Math.sin(4*x[i]) + Math.sin(20*x[i]);
        }

        // rescale the coordinate system
        StdDraw.setXscale(0, 5);
        StdDraw.setYscale(-2.0, +2.0);

        // plot the approximation to the function
        for (int i = 0; i < n; i++) {
            StdDraw.line(x[i], y[i], x[i+1], y[i+1]);
        }
    }
    public void array_initializer(){
        Random rand = new Random(40);
        bigg_arr = new int[10000];
        for (int i = 0; i < bigg_arr.length; i++) {
            int v = rand.nextInt();
            bigg_arr[i] = v;
        }
        bigg_arr2 = new int[20000];
        for (int i = 0; i < bigg_arr.length; i++) {
            int v = rand.nextInt();
            bigg_arr2[i] = v;
        }

        almost_sorted = new int[10000];
        for (int i=0;i <almost_sorted.length;++i){
            almost_sorted[i]=i;
        }
        int temp = almost_sorted[200];
        almost_sorted[200] = almost_sorted[201];
        almost_sorted[201] = temp;

        almost_sorted2 = new int[20000];
        for (int i=0;i < almost_sorted2.length;++i){
            almost_sorted2[i]=i;
        }
        int temp2 = almost_sorted2[200];
        almost_sorted2[200] = almost_sorted2[201];
        almost_sorted2[201] = temp2;
    }
}

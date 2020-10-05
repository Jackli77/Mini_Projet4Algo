import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
//Author Robin Verschuren
class sortTest {
    private int[] bigg_arr;
    private int[] empty_arr;
    private int[] bigg_arr_sorted;
    private int[] unit_arr;

    @BeforeEach
    void setUp() {
        System.out.println("Making initial array ...");

        Random rand = new Random(40);
        empty_arr = new int[0];
        bigg_arr = new int[10000];
        bigg_arr_sorted = new int[10000];
        unit_arr = new int[] {1};

        for (int i = 0; i < bigg_arr.length; i++) {
            int v = rand.nextInt();
            bigg_arr[i] = v;
            bigg_arr_sorted[i] = v;
        }
        Arrays.sort(bigg_arr_sorted);
    }

    @Test
    void quickSortTest() {
        quickSort.sort(bigg_arr);
        assertArrayEquals(bigg_arr_sorted, bigg_arr);

        quickSort.sort(empty_arr);
        assertArrayEquals(new int[0], empty_arr);

        quickSort.sort(unit_arr);
        assertArrayEquals(new int[] {1}, unit_arr);
    }
    @Test
    void shellSortTest() {
        shellSort sh  = new shellSort();
        sh.sort(bigg_arr);
        assertArrayEquals(bigg_arr_sorted, bigg_arr);

        sh.sort(empty_arr);
        assertArrayEquals(new int[0], empty_arr);

        sh.sort(unit_arr);
        assertArrayEquals(new int[] {1}, unit_arr);
    }
    @Test
    void selectionSortTest() {
        selectionSort sh  = new selectionSort();
        sh.sort(bigg_arr);
        assertArrayEquals(bigg_arr_sorted, bigg_arr);

        sh.sort(empty_arr);
        assertArrayEquals(new int[0], empty_arr);

        sh.sort(unit_arr);
        assertArrayEquals(new int[] {1}, unit_arr);
    }
}
package Driver;

import java.util.Arrays;

public class insertionSort {

    // Standard insertion sort used when gap = 1
    public static int[] insertionSortMethod(int[] arr) {
        int[] a = Arrays.copyOf(arr, arr.length);

        for (int i = 1; i < a.length; i++) {
            int key = a[i];
            int j = i - 1;

            while (j >= 0 && a[j] > key) {
                a[j + 1] = a[j];
                j--;
            }
            a[j + 1] = key;
        }

        return a;
    }

    // Insertion sort that works on elements separated by "gap"
    private static void insertionSortWithGap(int[] arr, int gap) {
        for (int i = gap; i < arr.length; i++) {
            int temp = arr[i];
            int j = i;

            while (j >= gap && arr[j - gap] > temp) {
                arr[j] = arr[j - gap];
                j -= gap;
            }

            arr[j] = temp;
        }
    }

    // 1. ShellSort(arr, intervals)
    public static int[] ShellSort(int[] arr, int[] intervals) {
        int[] a = Arrays.copyOf(arr, arr.length);

        for (int gap : intervals) {
            insertionSortWithGap(a, gap);
        }

        return a;
    }


    // 2. ShellSort(arr)
    public static int[] ShellSort(int[] arr) {
        int length = arr.length;

        int n = 1;
        while (Math.pow(2, n + 1) < length) {
            n++;
        }

        // Build interval list
        int[] intervals = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            intervals[i] = (int) Math.pow(2, (n - i));
        }

        // Last element has to be 1
        intervals[n] = 1;

        return ShellSort(arr, intervals);
    }

    // 3. Benchmark performance
    public static long benchmarkInsertion(int[] arr) {
        long start = System.nanoTime();
        insertionSortMethod(arr);
        return System.nanoTime() - start;
    }

    public static long benchmarkShell(int[] arr) {
        long start = System.nanoTime();
        ShellSort(arr);
        return System.nanoTime() - start;
    }


    // Main method, will use to test code
    public static void main(String[] args) {

        int[] data = {34, 2, 55, 1, 19, 8, 5, 13, 99};

        System.out.println("Original Array:");
        System.out.println(Arrays.toString(data));

        // Test intervals
        int[] intervals = {3, 2, 1};
        int[] shell1 = ShellSort(data, intervals);
        System.out.println("\nShellSort with intervals [3,2,1]:");
        System.out.println(Arrays.toString(shell1));

        // Test ShellSort
        int[] shell2 = ShellSort(data);
        System.out.println("\nShellSort with auto intervals:");
        System.out.println(Arrays.toString(shell2));

        // Insertion Sort
        int[] ins = insertionSortMethod(data);
        System.out.println("\nInsertion Sort:");
        System.out.println(Arrays.toString(ins));

        // Benchmark
        int[] large = new int[5000];
        for (int i = 0; i < large.length; i++) {
            large[i] = (int) (Math.random() * 10000);
        }

        long insTime = benchmarkInsertion(large);
        long shellTime = benchmarkShell(large);

        System.out.println("\nBenchmark Results (5000 elements):");
        System.out.println("Insertion Sort time: " + insTime + " ns");
        System.out.println("Shell Sort time:     " + shellTime + " ns");
    }
}


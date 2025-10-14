package driver;
import java.util.Arrays;
import java.util.Random;

public class codingBenchmark {
	
    public static void main(String[] args) 
    {
        int[] arr = RandomizedArray(10, 1, 100);

        System.out.println("Original Array: " + Arrays.toString(arr));

        // Make a duplicate array
        int[] bubbleArr = Arrays.copyOf(arr, arr.length);
        int[] selectionArr = Arrays.copyOf(arr, arr.length);
        int [] insertionArr = Arrays.copyOf(arr, arr.length);
        int [] quickArr = Arrays.copyOf(arr, arr.length);

        // Apply sorting
        bubbleSort(bubbleArr);
        selectionSort(selectionArr);
        insertionSort(insertionArr);
        quickSort(quickArr, 0, arr.length - 1);

        // Show results
        System.out.println("Bubble Sorted:   " + Arrays.toString(bubbleArr));
        System.out.println("Selection Sorted:" + Arrays.toString(selectionArr));
        System.out.println("Insertion Sorted:" + Arrays.toString(insertionArr));
        System.out.println("Quick Sorted:" + Arrays.toString(quickArr));

        // bubble sort runtime
        long startBubble = System.currentTimeMillis();
        bubbleSort(bubbleArr);
        long finishBubble = System.currentTimeMillis();
        long bubbleTime = finishBubble - startBubble;
       
        // selection sort runtime
        long startSelection = System.nanoTime();
        selectionSort(selectionArr);
        long finishSelection = System.nanoTime();
        long selectionTime = finishSelection - startSelection;
        
        //insertion sort runtime
        long startInsertion = System.nanoTime();
        insertionSort(insertionArr);
        long finishInsertion = System.nanoTime();
        long insertionTime = finishInsertion - startInsertion;
        
        //quick sort runtime
        long startQuick = System.nanoTime();
        quickSort(quickArr, 0, arr.length - 1);
        long finishQuick = System.nanoTime();
        long quickTime = finishQuick - startQuick;

        System.out.println("Sorting a random array, with bubble sort, took this much time: " + bubbleTime);
        System.out.println("Sorting a random array, with selection sort, took this much time: " +selectionTime);
        System.out.println("Sorting a random array, with insertion sort, took this much time: " +insertionTime);
        System.out.println("Sorting a random array, with quick sort, took this much time: " +quickTime);

    }

    // 1. Generate a random array with numbers between start and end (inclusive)
    public static int[] RandomizedArray(int size, int start, int end) {
        if (start > end || size <= 0) {
            System.out.println("Invalid input parameters.");
            return new int[0];
        }

        Random rand = new Random();
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = rand.nextInt(end - start + 1) + start;
        }
        return arr;
    }

    // 2. Bubble Sort
    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        boolean swapped;
        for (int i = 0; i < n - 1; i++) {
            swapped = false;
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    // swap
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                }
            }
            if (!swapped) break; // optimization
        }
    }

    // 3. Selection Sort
    public static void selectionSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            // swap
            int temp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = temp;
        }
    }
    
    // 4. Insertion Sort
    public static void insertionSort(int[] array)
    {
    	for( int i = 1; i < array.length; i++)
    	{
    		int temp = array[i];
    		int j = i - 1;
    		while(j >= 0 && array[j] > temp)
    		{
    			array[j] = array[j + 1];
    			j--;
    		}
    		array[j + 1] = temp;
    	}
    }
    
    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            // Partition the array and get pivot index
            int pivotIndex = partition(arr, low, high);

            // Recursively sort elements before and after pivot
            quickSort(arr, low, pivotIndex - 1);
            quickSort(arr, pivotIndex + 1, high);
        }
    }
    
    private static int partition (int[] arr, int low, int high) {
        int pivot = arr[high]; // Choose the last element as pivot
        int i = low - 1;       // Pointer for smaller element

        for (int j = low; j < high; j++) {
            // If current element is smaller than or equal to pivot
            if (arr[j] <= pivot) {
                i++;
                // Swap arr[i] and arr[j]
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
            
            int temp = arr[i + 1];
            arr[i + 1] = arr[high];
            arr[high] = temp;

        }
        return i + 1;

    // Driver code

}
}
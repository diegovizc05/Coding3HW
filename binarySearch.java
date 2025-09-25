package driver; 
	
public class binarySearch {
		
	public static void main(String[] args) 
	{
        int[][] arr = {
            {1, 2, 3, 4},
            {5, 6, 7, 8},
            {9, 10, 11, 12}
        };

        int[] result1 = BinaryMatrixSearch(arr, 7);
        System.out.println("Found 7 at: [" + result1[0] + "," + result1[1] + "]");

        int[] result2 = BinaryMatrixSearch(arr, 13);
        System.out.println("Found 13 at: [" + result2[0] + "," + result2[1] + "]");
    }

    public static int[] BinaryMatrixSearch(int[][] arr, int key) {
        int rows = arr.length;
        int cols = arr[0].length;
        int left = 0;
        int right = rows * cols - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            int midValue = arr[mid / cols][mid % cols]; // map 1D index back to 2D

            if (midValue == key) {
                return new int[]{mid / cols, mid % cols};
            } else if (midValue < key) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return new int[]{-1, -1};
    }
	}



package driver;
import java.util.ArrayList;
import java.util.Random;
import java.util.Arrays;

public class wk4d1 {

    public static int[] generate_random_unique(int start, int end, int total) {
        if (total > (end - start)) {
            System.out.println("Error: not enough unique numbers in the given range.");
            return new int[0]; 
        }

        ArrayList<Integer> resultList = new ArrayList<>();
        Random rand = new Random();

        while (resultList.size() < total) {
            int num = start + rand.nextInt(end - start);
            if (!resultList.contains(num)) {
                resultList.add(num);
            }
        }

        int[] result = new int[total];
        for (int i = 0; i < total; i++) {
            result[i] = resultList.get(i);
        }

        return result;
    }

    public static boolean Scan(int[] input, int target) {
        for (int num : input) {
            if (num == target) {
                return true;
            }
        }
        return false;
    }

    public static boolean Stor(int[] input, int target) {
        int max = 0;
        for (int num : input) {
            if (num > max) max = num;
        }

        int[] storage = new int[max + 1];
        for (int num : input) {
            storage[num] = 1;
        }

        if (target <= max && storage[target] == 1) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        int[] numbers = generate_random_unique(1, 20, 10);
        System.out.println("Generated Array: " + Arrays.toString(numbers));

        int target1 = numbers[3];
        int target2 = 100;

        System.out.println("\nTesting Scan:");
        System.out.println("Is " + target1 + " in array? " + Scan(numbers, target1));
        System.out.println("Is " + target2 + " in array? " + Scan(numbers, target2));

        System.out.println("\nTesting Stor:");
        System.out.println("Is " + target1 + " in array? " + Stor(numbers, target1));
        System.out.println("Is " + target2 + " in array? " + Stor(numbers, target2));
    }


	}



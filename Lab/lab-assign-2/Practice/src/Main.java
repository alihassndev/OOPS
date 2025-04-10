public class Main {
    public static void main(String[] args) {
        System.out.println("Main Method ...");

        int[] nums = {10, 90, 80, 23, 50, 85};
        int max = nums[0];
        int second = max;

//        Finding max and second max number
        for (int i=1; i<nums.length; i++) {
            if (max<nums[i]) {
                max = nums[i];
            } else if (second<nums[i] && second<max) {
                second = nums[i];
            }
        }

//        printing
        System.out.println("First Max: " + max);
        System.out.println("second Max: " + second);

//        Sorting an array
        for (int i=0; i<nums.length-1; i++) {
            for (int j=i; j < nums.length-1; j++) {
                if (nums[j+1] < nums[j]) {
                    int temp = nums[j];
                    nums[j] = nums[j+1];
                    nums[j+1] = temp;
                }
            }
        }

//        Printing an array
        for (int i=0; i<nums.length; i++) {
            System.out.print(nums[i] + " ");
        }

//        Finding Max and second max number
        for (int i=1; i< nums.length; i++) {
            if (max < nums[i] || max > second) {
                second = max;
                max = nums[i];
            }
        }
        System.out.println("\nMax number: " + max);
        System.out.println("Second Number: " + second);

        int min = nums[0];
//        Finding the Smallest Number
        for (int i=0; i<nums.length; i++) {
            if (min > nums[i]) {
                min = nums[i];
            }
        }
        System.out.println("Min Number: " + min);

//        Reverse an Array
        int length = nums.length;
        for (int i=0; i<nums.length/2; i++) {
            if (length%2 == 0) {
                for (int j=i; j<=(length/2); j++) {
                    int temp1 = nums[j];
                    int temp2 = nums[length-1];
                    nums[j] = temp2;
                    nums[length-1] = temp1;
                    length--;
                }
            } else {
                for (int j=i; j<length/2; j++) {
                    int temp1 = nums[j];
                    int temp2 = nums[length-1];
                    nums[j] = temp2;
                    nums[length-1] = temp1;
                    length--;
                }
            }
        }
//        Printing the array
        System.out.println("Printing Reverse Array: ");
        for (int i=0; i< nums.length; i++) {
            System.out.print(nums[i] + " ");
        }
    }
}
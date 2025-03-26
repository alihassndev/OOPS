public class MoveZeros {
    public static void main(String[] args) {
        System.out.println("Main Method ...");
        int[] nums = {0, 1, 2, 0, 4, 0};

        int nonZeroIndex = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                int temp = nums[i];
                nums[i] = nums[nonZeroIndex];
                nums[nonZeroIndex] = temp;
                nonZeroIndex++;
            }
        }

        // Printing Array
        for (int num : nums) {
            System.out.print(num + " ");
        }
    }
}

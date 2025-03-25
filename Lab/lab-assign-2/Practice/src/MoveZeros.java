public class MoveZeros {
    public static void main(String[] args) {
        System.out.println("Main Method ...");
        int[] nums = {1,0,2,0,4,6};
        int len = nums.length;

//        Moving zeros to end
        for (int i=0; i<nums.length; i++) {
            if (nums[i] == 0) {
                len--;
                int temp = nums[len];
                nums[len] = nums[i];
                nums[i] = temp;
//                if (nums[len] == 0) {
//                    int temp = nums[len-1];
//                    nums[len-1] = nums[i];
//                    nums[i] = temp;
//                    len--;
//                } else {
//                    int temp = nums[len];
//                    nums[len] = nums[i];
//                    nums[i] = temp;
//                    len--;
//                }
            }
        }

//        Printing Array
        for (int i=0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }
    }
}

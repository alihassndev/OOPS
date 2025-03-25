import java.util.Arrays;
import java.util.Scanner;

public class TwoSum {
    public static void main(String[] args) {
        System.out.println("Main Method ...");
        Scanner sc = new Scanner(System.in);
        int[] nums = {1,2,3,4,5};
        int sum=0;

//        Sum of all elements in array
        for (int i=0; i<nums.length; i++) {
            sum += nums[i];
        }

        System.out.print("Enter target less than " + (sum-5) + ": ");
        int target = sc.nextInt();
        int flag=0;

//        Checking two sum
        for (int i=0; i < nums.length; i++) {
            for (int j=0; j < nums.length; j++) {
                if (nums[i]+nums[j] == target) {
                    System.out.println(nums[i] + " and " + nums[j] + " = " + target);
                    flag = 1;
                }
            }
        }
        if (flag == 0) {
            System.out.println("Not Found ...");
        }
    }
}

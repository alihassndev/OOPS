import java.util.ArrayList;
import java.util.List;

public class EvenOdd {
    public static void main(String[] args) {
        System.out.println("Main Method");

        int[] nums = {1,2,3,4,2,12,3,17,21};
        List <Integer> arr = new ArrayList<>();
        List <Integer> even = new ArrayList<>();
        List <Integer> odd = new ArrayList<>();

        for (int i=0; i<nums.length; i++) {
            arr.add(nums[i]);
            if (nums[i]%2 != 0) {
                odd.add(nums[i]);
            } else {
                even.add(nums[i]);
            }
        }

        System.out.println("Array : " + arr);
        System.out.println("Size of array: " + arr.size());
        System.out.println("Even number in array : " + even);
        System.out.println("Size of even array: " + even.size());
        System.out.println("Odd number in array : " + odd);
        System.out.println("Size of odd array: " + odd.size());
    }
}

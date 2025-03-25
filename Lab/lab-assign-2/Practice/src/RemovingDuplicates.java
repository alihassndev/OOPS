import java.util.ArrayList;
import java.util.List;

public class RemovingDuplicates {
    public static void main(String[] args) {
        System.out.println("Main Method ...");

        int[] nums = {1,2,3,3,1,4,2,2,6};
        int len = nums.length;

//        Sorting
        for (int i=0; i < len; i++) {
            for (int j=i; j < len; j++) {
                if (nums[i] > nums[j]) {
                    int temp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = temp;
                }
            }
        }

//        Printing
        for (int i=0; i < len; i++) {
            System.out.print(nums[i] + " ");
        }

//        Remove Duplicates
        int i=0;
        for (int j=1; j<len; j++) {
            if (nums[i] != nums[j]) {
                i++;
                nums[i] = nums[j];
            }
        }

//        Printing
        System.out.print("\nRemove Duplicates: ");
        for (int j=0; j <= i; j++) {
            System.out.print(nums[j] + " ");
        }
    }
}

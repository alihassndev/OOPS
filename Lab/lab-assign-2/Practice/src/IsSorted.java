public class IsSorted {
    public static void main(String[] args) {
        System.out.println("Main Method ...");
        int[] arr = {1,6,2,3,4,5};
        int flag=0;

        for (int i=0; i<arr.length-1; i++) {
            if (arr[i]>arr[i+1]) {
                flag = 1;
                System.out.println("Not Sorted");
                break;
            }
        }
        if (flag == 0) {
            System.out.println("Array is Sorted ...");
        }
    }
}

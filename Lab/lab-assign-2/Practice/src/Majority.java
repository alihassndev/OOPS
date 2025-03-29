public class Majority {
    public static void main(String[] args) {
        System.out.println("Main Method ...");

        int[] arr = {1,1,2,1,4,5,1,3,1};
        int counter=0;
        System.out.println("length of array: " + arr.length);

        for (int i=0; i<arr.length; i++) {
            counter = 0;
            for (int j=0; j<arr.length; j++) {
                if (arr[i] == arr[j]) {
                    counter++;
                }
            }

            if (counter >= arr.length/2+1) {
                System.out.println("Majority Element: " + arr[i]);
                break;
            }
        }

        if (counter<arr.length/2) {
            System.out.println("No Majority element is found ...");
        }
    }
}

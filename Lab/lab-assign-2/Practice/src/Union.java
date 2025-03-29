public class Union {
    public static void main(String[] args) {
        int[] arr1 = {1, 2, 3, 4, 5};
        int[] arr2 = {3, 4, 5, 6, 7};

        int[] union = new int[arr1.length + arr2.length];
        int index = 0;

        // Add all elements of arr1 to union array
        for (int i = 0; i < arr1.length; i++) {
            union[index++] = arr1[i];
        }

        // Add elements of arr2 to union array if they are not already present
        for (int i = 0; i < arr2.length; i++) {
            boolean isDuplicate = false;
            for (int j = 0; j < arr1.length; j++) {
                if (arr2[i] == arr1[j]) {
                    isDuplicate = true;
                    break;
                }
            }
            if (!isDuplicate) {
                union[index++] = arr2[i];
            }
        }

        // Print the union array
        System.out.print("Union of Arrays: ");
        for (int i = 0; i < index; i++) {
            System.out.print(union[i] + " ");
        }
    }
}

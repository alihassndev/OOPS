import java.util.Arrays;

public class Frequency {
    public static void main(String[] args) {
        System.out.println("Main Method ...");

        int[] arr = {1, 2, 4, 3, 1, 3, 1, 1};
        Arrays.sort(arr); // Sorting helps in grouping duplicates together

        boolean[] visited = new boolean[arr.length]; // Track visited elements

        // Check Frequency of each element
        for (int i = 0; i < arr.length; i++) {
            if (visited[i]) // Skip already counted elements
                continue;

            int count = 0;
            for (int j = i; j < arr.length; j++) {
                if (arr[i] == arr[j]) {
                    count++;
                    visited[j] = true; // Mark as visited
                }
            }
            System.out.println("Count for element " + arr[i] + " is: " + count);
        }
    }
}

public class Patterns {
    public static void main(String[] args) {
        int n = 5; // Height of the pyramid
        System.out.println("Main Method ...");

        for (int i = 1; i <= n; i++) {
            // Printing leading spaces
            for (int j = i; j < n; j++) {
                System.out.print(" ");
            }

//        Printing Hollow square
//        for (int i=0; i<5; i++) {
//            for (int j=0; j<5; j++) {
//                if (i==0 || j==4 || j==0 || i==4) {
//                    System.out.print("* ");
//                } else {
//                    System.out.print("  ");
//                }
//            }
//            System.out.println();
//        }

//        Printing stars and hollow spaces
        for (int j = 1; j <= (2 * i - 1); j++) {
            if (j == 1 || j == (2 * i - 1) || i == n) {
                System.out.print("*"); // Print * at boundaries and last row
            } else {
                System.out.print(" "); // Print space inside the pyramid
                }
            }
            System.out.println();
        }
    }
}

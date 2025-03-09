import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class practice {
    public static void main(String [] args) {
        System.out.println("Hey there !");

////        implicit type conversion
//        int num=10;
//        double n = num;
//        n = 10.99;
//
//        System.out.println("n: " + n);
////        Explicit Conversion
//        num = (int) n;
//
//        System.out.println("num: " + num);
//
//        if (num > 0) {
//            if (num%2 == 0) {
//                System.out.println("num " + num + " is a positive even number !");
//            }
//        }

//        ======================================
//        Count number of digits of a number
//        int num = 123464;
//        int i = 0;
//
//        while(num>0) {
//            num /= 10;
//            i++;
//        }
//
//        System.out.println(i);
//        ======================================

//        ======================================
//        Reverse the number
//        int num = 1234;
//        int temp=0;
//        System.out.println("num: " + num);
//
//        while (num>0) {
//            temp *= 10;
//            temp = temp + (num % 10);
//            num /= 10;
//        }
//
//        System.out.println("reverse num: " + temp);
//        ======================================

//        ======================================
//        Find Prime number
//        Scanner sc = new Scanner(System.in);
//        System.out.println("Enter a number: ");
//        int num = sc.nextInt();
//        int flag=0;
//
//        for (int i=2; i<num/2; i++) {
//            if (num % i == 0) {
//                flag = 1;
//                break;
//            } else {
//                continue;
//            }
//        }
//
//        if (flag == 0) {
//        System.out.println("Number " + num + " is prime !");
//        } else {
//        System.out.println("Number " + num + " is not prime !");
//        }
//        ======================================

//        ======================================
//        Fibonacci series
//        Scanner sc = new Scanner(System.in);
//        System.out.print("Enter the number of terms: ");
//        int n = sc.nextInt(); // Read the number of terms
//
//        int a = 0, b = 1; // Only two variables used
//
//        System.out.print("Fibonacci Series: " + a + " " + b + " ");
//
//        for (int i = 2; i < n; i++) {
//            b = a + b; // Compute next Fibonacci number
//            a = b - a; // Update 'a' to previous 'b' value
//            System.out.print(b + " ");
//        }
//        ======================================

//        ======================================
//        Arrays
//        First Method of Creating and declaring an Array
//        int[] nums = new int[3];
//        nums[0] = 12;
//        nums[1] = 10;
//        nums[2] = 7;

//        Second Method of creating and declaring an array
//        int[] nums = {1, 2, 4};
//
//        System.out.println("Array : " + nums[0] + ", " + nums[1] + ", " + nums[2]);

//        ======================================
//        One Dimensional Array
//        ======================================

//        Putting numbers to an array using input
//        Scanner sc = new Scanner(System.in);
//        System.out.print("Enter size of array: ");
//        int size = sc.nextInt();
//        int[] marks = new int[size];
//
////        Taking input and putting them to an Array
//        for (int i=0; i<size; i++) {
//            System.out.print("Enter number at index " + (i+1) + ": ");
//            marks[i] = sc.nextInt();
//        }
//
//        System.out.print("Array: ");
////        Displaying an Array
//        for (int i=0; i<size; i++) {
//            System.out.print(marks[i] + ", ");
//        }

//        ======================================
//        Two Dimensional Array
//        ======================================
//        int[][] nums = new int[2][3];
//        Scanner sc =  new Scanner(System.in);
//
////        Taking input from the user
//        for (int i=0; i<2; i++) {
//            for (int j=0; j<3; j++) {
//                nums[i][j] = sc.nextInt();
//            }
//        }
//
////        Taking input from the user
//        for (int i=0; i<2; i++) {
//            for (int j=0; j<3; j++) {
//                System.out.print(nums[i][j] + " ");
//            }
//        }
//        ======================================

//        ======================================
//        Array Methods
//        int[] numbers = {12, 45, 7, 89, 34};
//        int max = numbers[0];
//
//        for (int i = 1; i < numbers.length; i++) {
//            if (numbers[i] > max) {
//                max = numbers[i];
//            }
//        }
//
//        System.out.println("Largest number: " + max);

//        int[] arr = {5, 2, 1, 1, 9};
//
//        Arrays.sort(arr); // Sorting the array
//
//        System.out.println("Sorted array:");
//        for (int num : arr) {
//            System.out.print(num + " ");
//        }

//        ======================================
//        Linear Search
//        ======================================

//        Scanner sc = new Scanner(System.in);
//
//        int[] arr = {10, 20, 30, 40, 50};
//        System.out.print("Enter number to search: ");
//        int key = sc.nextInt();
//
//        boolean found = false;
//
//        for (int i = 0; i < arr.length; i++) {
//            if (arr[i] == key) {
//                System.out.println("Found at index: " + i);
//                found = true;
//                break;
//            }
//        }
//
//        if (!found) {
//            System.out.println("Not found in the array.");
//        }
//        ======================================

//        ======================================
//        Binary Search
//        Binary Search only works on sorted arrays.
//        ======================================
//        int[] arr = {5, 10, 15, 20, 25, 30};
//
//        int key = 20;
//        int index = Arrays.binarySearch(arr, key);
//
//        if (index >= 0) {
//            System.out.println("Found at index: " + index);
//        } else {
//            System.out.println("Not found in the array.");
//        }
//        ======================================

//        ======================================
//        Find the smallest element in an array.

//        int[] nums = {1,2,3,4,5,-1};
//        int min=nums[0];
//        for (int i=1; i<nums.length; i++) {
//            if (nums[i] < min) {
//                min = nums[i];
//            }
//        }
//        System.out.println("Minimum number: " + min);

//        ======================================
//        Reverse an array without using another array

//        int[] arr = {1,2,3,4,5,6};
//        int length = arr.length;
//
//        for (int i=0; i<arr.length / 2; i++) {
//            int temp = arr[i];
//            arr[i] = arr[--length];
//            arr[length] = temp;
//        }
//
//        for (int i=0; i<arr.length; i++) {
//            System.out.print(arr[i] + " ");
//        }
//        ======================================

//        ======================================
//        Count the occurrences of a given number in an array.
//        int[] arr = {1,2,3,2,1,1,2};
//        Scanner sc = new Scanner(System.in);
//        System.out.print("Enter a number to check: ");
//        int num = sc.nextInt();
//        int rep = 0;
//
//        for (int i=0; i<arr.length; i++) {
//            if (arr[i] == num) {
//                rep++;
//            } else {
//                continue;
//            }
//        }
//
//        System.out.println("Number " + num + " repeats for " + rep + " times.");
//        ======================================

//        ======================================
//        Check if a given array is sorted in ascending order.

//        int[] arr = {1, 3, 4, 5, 2};
//        boolean flag = true;
//
//        // Check if the array is sorted
//        for (int i = 0; i < arr.length - 1; i++) {
//            if (arr[i] > arr[i + 1]) {  // If any previous element is greater, it's not sorted
//                flag = false;
//                break;
//            }
//        }
//
//        // Output the result
//        if (flag) {
//            System.out.println("Array is sorted in Ascending Order ...");
//        } else {
//            System.out.println("Array is NOT sorted in Ascending Order ...");
//        }
//        ======================================

//        ======================================
//        Strings in java
//        Declare a String
//        String str1 = "Ali Hassan";
////        Printing a String
//        System.out.println("String 1: " + str1);
////        Finding the Length of a String
//        System.out.println("String 1: " + str1.length());
////        Accessing the specific Character in Strings
//        System.out.println("String 1 character at index 1 in Array Format: " + str1.charAt(1));
////        Accessing the SubString in Strings
//        System.out.println("Second SubString: " + str1.substring(4));
//        System.out.println("First SubString: " + str1.substring(0, 3));
////        String Concatenation
//        System.out.println(str1 + " " + "Yusuf");
//        System.out.println(str1.concat(" ").concat("Yusuf"));


//        String str2 = new String("Hassan");
//        System.out.println("String 2: " + str2);
//        System.out.println("String 2: " + str2.length());
//        System.out.println("String 1 character at index 1 in Array Format: " + str1.charAt(4));
//        ======================================
//        String comparison
//        String str1 = "Ali Hassan";
//        String str2 = "ali hassan";
//
//        System.out.println(str1.equals(str2)); // Case Sensitive
//        System.out.println(str1.equalsIgnoreCase(str2)); // Case Sensitive
//        ======================================

//        ======================================
//        Checking if a String Starts or Ends With a Specific Character
//        String name = "Ali Hassan";
//        System.out.println(name.startsWith("ali")); // Case Sensitive
//        System.out.println(name.endsWith("an"));
//
//
////        Replace a substring in a String
////        This will not change the Actual String but Returns a value to be Stored in other Variable
//        System.out.println(name.replace("Hassan", "Yusuf"));
//
//
////        Convert to UpperCase and LowerCase
//        System.out.println(name.toUpperCase());
//        System.out.println(name.toLowerCase());


//        Splitting a String
//        String name = "Ali Hassan Yusuf";
//        String[] words = name.split(" ");
//        for (String str: words) {
//            System.out.println(str);
//        }
//        ======================================

//        ======================================
//        Reversing a String

//        String name = "Ali Hassan";
//        String reverseString = "";
//        for (int i=name.length()-1; i>=0; i--) {
//            reverseString += name.charAt(i);
//        }
//
//        System.out.println("String : " + name);
//        System.out.println("Reverse String : " + reverseString);
//        ======================================

//        ======================================
//        Check if String is a Palindrome or not

//        String name = "Apa";
//        String reverse = new StringBuilder(name).reverse().toString();
//
//        if (name.equalsIgnoreCase(reverse)) {
//            System.out.println("String is Palindrome");
//        } else {
//            System.out.println("String is not a Palindrome");
//        }
//        ======================================

//        ======================================
//        Count Vowels and Consonants

//        String str = "Hello Java";
//        int vowels = 0, consonants = 0;
//
//        str = str.toLowerCase();
//        for (char c : str.toCharArray()) { // toCharArray() Method converts the string to character Array
//            if (c >= 'a' && c <= 'z') {
//                if ("aeiou".indexOf(c) != -1) vowels++;
//                else consonants++;
//            }
////        System.out.println("test: " + c +": " + "aeiou".indexOf(c));
//        }
//        System.out.println("Vowels: " + vowels);
//        System.out.println("Consonants: " + consonants);
//        ======================================

//        ======================================
//        Find the longest word in a sentence.
//        String text = "Ali is not good";
//        String[] words = text.split(" ");
//        int len = 0;
//        String wrd = "";
//
//        for (int i=0; i<words.length; i++) {
//            if (words[i].length() > len) {
//                len = words[i].length();
//                wrd = words[i];
//            }
//        }

//        Printing the Array
//        for (int i=0; i<words.length; i++) {
//            System.out.println(words[i]);
//        }

//        System.out.println(wrd + " with Length: " + len);
//        ======================================

//        ======================================
//        Count the occurrences of a given character in a string.
//        Scanner sc = new Scanner(System.in);
//        System.out.print("Enter a Character that are find: ");
//        char ch = sc.next().charAt(0);
//        String name = "Ali Hassan";
//        String lower = name.toLowerCase();
//        int count=0;
//
//        for (char c: lower.toCharArray()) {
//            if (ch == c) {
//                count++;
//            }
//        }
//
//        System.out.println(count);
//        ======================================

//        ======================================
//        Convert a sentence to title case (first letter of each word uppercase).
        String name = "ali hassan yusuf";
        String[] arr = name.split(" ");

        for (int i = 0; i < arr.length; i++) {
            arr[i] = arr[i].substring(0, 1).toUpperCase() + arr[i].substring(1);
        }

        String newName = String.join(" ", arr);
        System.out.println(newName);
//        ======================================

    }
}

// Important Note
// String are immutable, Modification creates a new Object
// To optimize performance, we use StringBuffer or StringBuilder.

//  StringBuffer sb = new StringBuffer("Hello");
//  sb.append(" World");  // Modifies the same object
//  System.out.println(sb);  // Output: Hello World

//  StringBuilder sb = new StringBuilder("Hello");
//  sb.append(" Java");
//  System.out.println(sb);  // Output: Hello Java

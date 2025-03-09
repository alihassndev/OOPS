public class GreatestNumber {
    private int[] arr;

//    Constructor
    GreatestNumber() {
        arr = new int[10];
    }

//    Setters
    void setArr(int[] a) {
        arr = a;
    }

//    Getter
    int[] getArr() {
        return arr;
    }

//    Printing values of array
    void print() {
        for (int num: arr) {
            System.out.print(num + " ");
        }
    }

//    Returning Max Number
    int max() {
        int max = arr[0];
        for (int i=1; i<arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        return max;
    }
}

public class ArrayExample {
    private int[] arr;

    ArrayExample() {
        arr = new int[5];
    }

//    Setter
    void setArr(int[] a) {
        arr = a;
    }

//    Getter
    int[] getArr() {
        return arr;
    }

//    Printing
    void print() {
        for (int i: arr) {
            System.out.print(i + " ");
        }
    }
}


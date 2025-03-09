public class StringLength {
    private String[] arr;

//    Constructor
    StringLength() {
        arr = new String[5];
    }

//    Setter
    void setArr(String[] a) {
        arr = a;
    }

//    Getters
    String[] getArr() {
        return arr;
    }

//    Print Values
    void print() {
        for (String s: arr) {
            System.out.print(s + " ");
        }
    }

//    Print Length of each value in Array
    void printLength() {
        for (String s: arr) {
            System.out.println("Length of " + s + " is : " + s.length());
        }
    }
}

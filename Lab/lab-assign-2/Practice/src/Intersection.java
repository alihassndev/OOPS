import java.util.ArrayList;
import java.util.List;

public class Intersection {
    private int[] arr1;
    private int[] arr2;

    Intersection() {
        arr1 = new int[5];
        arr2 = new int[5];
    }

//    Setters
    void setArr1(int[] arr) {
        arr1 = arr;
    }
    void setArr2(int[] arr) {
        arr2 = arr;
    }

//    Getters
    int[] getArr1() {
        return arr1;
    }
    int[] getArr2() {
        return arr2;
    }

//    check intersection
    void intersection() {
        List <Integer> lst = new ArrayList<>();
        int flag = 0;

        for (int i=0; i<arr2.length; i++) {
            if (arr1[i] == arr2[i]) {
                lst.add(arr1[i]);
                flag = 1;
            }
        }
        if (flag == 0) {
            System.out.println("No common elements ...");
        } else {
            System.out.println("Intersection of arrays: " + lst);
        }
    }
}

public class TestIntersection {
    public static void main(String[] args) {
        System.out.println("Main Method ...");

        Intersection obj1 = new Intersection();
        int[] arr1 = {1,2,3,4,5};
        obj1.setArr1(arr1);
        int[] arr2 = {1,4,0,4,5};
        obj1.setArr2(arr2);

        obj1.intersection();
    }
}

public class MathTest {
    public static void main(String[] args) {
        System.out.println("This is main Method ...\n");

//        Creating MathOperation class Object
        MathOperations math = new MathOperations();
        math.setNum1(4);
        math.setNum2(7);
        System.out.println("Add = " + math.add());
        System.out.println("Multiply = " + math.multiply());
        System.out.printf("Divide = %.2f\n", math.divide());
        System.out.println("Max = " + math.max());
        System.out.println("FakeAdd = " + math.fakeAdd());
    }
}

public class MathOperations {
    private int num1;
    private int num2;

//    Constructor
    MathOperations() {
        num1 = 0;
        num2 = 0;
    }

//    Setters
    void setNum1(int num) {
        num1 = num;
    }
    void setNum2(int num) {
        num2 = num;
    }

//    Getters
    int getNum1() {
        return num1;
    }
    int getNum2() {
        return num2;
    }

//    Operations
    int add() {
        return num1+num2;
    }
    int multiply() {
        return num1*num2;
    }
    double divide() {
        if (num2 == 0) {
            System.out.println("num2 can't be zero!");
        }
        return (double) num1/num2;
    }
    int max() {
        return (num1 > num2 ? num1 : num2);
    }
    int fakeAdd() {
        return num1+num2-num1+num2;
    }
}

// Separate Class
public class Test1 {
    private int num1;

//    Default Constructor
    Test1() {
        num1 = 0;
    }

//    Setters
    void setNum1(int num) {
        this.num1 = num;
    }

//    Getters
    int getNum1() {
        return num1;
    }

//    Calculating Factorial
    int fact(int num) {
        if (num == 1) {
            return 1;
        } else {
            return num * fact(num-1);
        }
    }
}

public class Table {
    private int num;
    private int limit;

    Table() {
        num=0;
        limit=0;
    }

//    Setters
    void setNum(int n) {
        num = n;
    }
    void setLimit(int n) {
        limit = n;
    }

//    Getters
    int getNum() {
        return num;
    }
    int getLimit() {
        return limit;
    }

    void multiply() {
        for (int i=1; i<=limit; i++) {
            int ans = num * i;
            System.out.println(num + " x " + i + " = " + ans);
        }
    }
}

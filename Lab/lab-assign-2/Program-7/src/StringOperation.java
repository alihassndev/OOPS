public class StringOperation {
    private String str1;
    private String str2;

    StringOperation() {
        str1 = new String();
        str2 = new String();
    }

//    Setter
    void setStr1(String s) {
        str1 = s;
    }
    void setStr2(String s) {
        str2 = s;
    }

//    Getters
    String getStr1() {
        return str1;
    }
    String getStr2() {
        return str2;
    }

//    Check for String Anagrams
//    areAnagrams("Hello", "Olelh") → true
//    areAnagrams("Java", "Python") → false
    boolean check() {
        char[] temp1 = str1.toCharArray();
        char[] temp2 = str2.toCharArray();
        int flag = 0;

        for (int i=0; i<temp1.length; i++) {
            for (int j=0; j<temp2.length; j++) {
                if (temp1[i] == temp2[j]) {
                    flag = 0;
                    break;
                } else {
                    flag = 1;
                }
            }
        }
        if (flag == 0) {
            return true;
        } else {
            return false;
        }
    }
}

public class StringFunctions {
    private String str;

    StringFunctions() {
        str = new String();
    }

    void setStr(String s) {
        str = s;
    }

    String getStr() {
        return str;
    }

//    return number of words in string
    int wordsLength() {
        String[] strArray = str.split(" ");

        return strArray.length;
    }

//    Return number of characters in each word
    void characterLength() {
        String[] strArray = str.split(" ");
        for (int i=0; i<strArray.length; i++) {
            System.out.println(strArray[i] + " : " + strArray[i].length());
        }
    }

//    return last word in the given string
    String lastWord() {
        String[] strArray = str.split(" ");

        return strArray[strArray.length-1];
    }
}

public class TitleCaseString {
    private String str;

    TitleCaseString() {
        str = new String();
    }

    void setStr(String s) {
        str = s;
    }

    String getStr() {
        return str;
    }

//    Title Case Conversion
    void updatedString() {
        String[] strSlpit = str.split(" ");

        for (int i=0; i<strSlpit.length; i++) {
            String c = strSlpit[i].charAt(0) + "";

            strSlpit[i] = c.toUpperCase() + strSlpit[i].substring(1);

            System.out.print(strSlpit[i] + " ");
        }
    }
}

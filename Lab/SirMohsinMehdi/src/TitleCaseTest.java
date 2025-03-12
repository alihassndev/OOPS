public class TitleCaseTest {
    public static void main(String[] args) {
        System.out.println("Main Method ...");

        TitleCaseString str = new TitleCaseString();

        String s = "Hello world class of sp25 repeaters";

        str.setStr(s);

        System.out.println("Before updating: ");
        System.out.println(s);
        System.out.println("After updating: ");
        str.updatedString();
    }
}

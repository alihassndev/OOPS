public class StringFunctionTest {
    public static void main(String[] args) {
        System.out.println("Main Method ...");

        StringFunctions str = new StringFunctions();
        String s = "comsats uni islamabad, lahore campus";

        str.setStr(s);

        System.out.println("Given String: " + s);
        System.out.println("Words length of given String: " + str.wordsLength());
        System.out.println("Characters in each word of given String: ");
        str.characterLength();
        System.out.println("Last Words of given String: " + str.lastWord());
    }
}

public class TestingString {
    public static void main(String[] args) {
        String s = new String();
        s = "Hello World";

//        char c = s.charAt(6);
//        System.out.println(c);
//        System.out.println(s);

//        System.out.println(s.indexOf("r"));
//        System.out.println(s.isEmpty());
//        String temp = s.replace("World", "Java");
//        System.out.println(temp);
//        System.out.println(s.toLowerCase());
//        System.out.println(s.toUpperCase());
//        System.out.println(s.hashCode());
//        System.out.println(s.contains("ello"));
//        System.out.println(s.trim());
        char[] ch = s.toCharArray();

        for (char c: ch) {
            System.out.print(c);
        }
    }
}

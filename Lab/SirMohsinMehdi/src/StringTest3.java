public class StringTest3 {
    public static void main(String[] args) {
        System.out.println("Main Method ...");

//        String s1 = new String("Ali");
//        System.out.println(s1);
//
//        String s2 = new String("Ali");
//        System.out.println(s2);
//
//        System.out.println(s1 == s2); // False due to address comparison
//
//        Not reference variable any more
//        s1="Ali";
//        s2="Ali";
//
//        System.out.println(s1 == s2); // True due to value comparison

//        String Operations
        String s = "ali Hassan sialkoti";
//        indexOf
//        Using ASCII code and find the corresponding character index
//        int index = s.indexOf(97);
//        int index = s.indexOf("a");
//        Using ASCII code and find the corresponding character index start after a specified index
//        int index = s.indexOf(97, 4);
//        int index = s.indexOf("a", 4);
//        Using ASCII code and find the corresponding character index start after a specified index but not include the ending index
//        int index = s.indexOf(97, 6, 9);
//        int index = s.indexOf("a", 6, 9);
//        System.out.println(index);

//        CharAt()
//        for (char c: s.toCharArray()) {
//            System.out.print(c + " ");
//        }

        String[] temp = s.split(" ");

        for (String val: temp) {
            System.out.println(val);
        }
    }
}

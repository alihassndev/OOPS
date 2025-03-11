public class StringTask1 {
    public static void main(String[] args) {
        System.out.println("Main Method ...");
        String str = "Hello world class of sp25 repeaters";

//        identify each word
//        identify first letter of each word
//        assign back to the word
//        combine a words

        String[] temp = str.split(" ");

        System.out.println("Before Converting ...");
        System.out.println(str);

        for (int i=0; i<temp.length; i++) {
            String innerWord = temp[i];
            char c = innerWord.charAt(0);
            String stringChar = c + "";
            stringChar = stringChar.toUpperCase();
            temp[i] = stringChar.toUpperCase() + innerWord.substring(1);
//            System.out.println(temp[i]);

//            innerWord = innerWord.replace(innerWord.charAt(0), stringChar.charAt(0));
//            System.out.println(innerWord);
        }

        str = "";
        for (int i=0; i<temp.length; i++) {
            str += temp[i] + " ";
        }
        System.out.println("After Converting ...");
        System.out.println(str);
    }
}

import java.util.ArrayList;
import java.util.List;

public class NonRepeatingCharacter {
    private String str;

    NonRepeatingCharacter() {
        str = new String();
    }

//    Setters
    void setStr(String s) {
        str = s;
    }

//    Getters
    String getStr() {
        return str;
    }

//    Method to Skip non-repeating characters
    char nonReapeatingChar() {
        char[] characters = str.toCharArray();
        List<Character> list = new ArrayList<>();
        int flag = 0;

        for (int i=0; i<characters.length; i++) {
//            char temp=characters[i];
            //temp does not exist in the repeating list, if it exists break the loop
//            List<Character> list1 = new ArrayList<>();
//            if (temp == list.get(i)) {
//                break;
//            }
            for (int j=1; j<characters.length; j++) {
                if (characters[i] == characters[j]) {
                    flag = 0;
                    break;
                } else {
                    flag = 1;
                    list.add(characters[i]);
                    flag = 0;

                }
            }
//            if (flag == 1) {
//
//            }
        }

        System.out.println(list);
        return list.get(0);
    }

//    char nonRepeating() {
//        char[] character = str.toCharArray();
//        List<Character> list = new ArrayList<>();
//        int flag = 0;
//
//        for (int i=0; i<character.length; i++) {
//            for (int j=0; j<character.length; j++) {
//                if (character[i] == character[j]) {
//                    flag = 0;
//                    break;
//                } else {
//                    continue;
//                }
//            }
//
//            if (flag == 1) {
//                list.add(character[i]);
//            }
//        }
//
//        return list.get(0);
//    }
}

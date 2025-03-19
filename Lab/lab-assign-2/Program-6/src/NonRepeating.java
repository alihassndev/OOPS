import java.util.ArrayList;
import java.util.List;

public class NonRepeating {
    private String str;

    NonRepeating() {
        str = new String();
    }

    void setStr(String s) {
        str = s;
    }

//    Method for getting non-repeating characters
    char Non() {
        char[] characters = str.toCharArray();
        List<Character> temp1 = new ArrayList<>();
        List<Character> temp2 = new ArrayList<>();
//        int flag = 0;

        for (int i=0; i<characters.length; i++) {
            for (int j=0; j<characters.length; j++) {
                if (characters[i] == characters[j]) {
                    if (temp1.contains(characters[i])) {
                        temp2.add(characters[i]);
                        temp1.remove(Character.valueOf(characters[i]));
                    } else {
                        if (temp2.contains(characters[i])) {
                            continue;
                        } else {
                            temp1.add(characters[i]);
                        }
                    }
                }
            }
        }
        if (temp1.isEmpty()) {
            temp1.add('0');
        }
        System.out.println("Temp1 : " + temp1);
//        System.out.println("Temp2 : " + temp2);
        return temp1.getFirst();
    }
}

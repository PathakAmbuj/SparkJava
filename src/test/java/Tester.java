import scala.collection.mutable.WrappedArray;

import java.util.*;

import static javafx.scene.input.KeyCode.T;

public class Tester {
    public static void main(String[] args) {

        
        String[] strArray = new String[4];
        strArray[0] = "Ambuj";
        strArray[1] = "pathakjmb";
        strArray[2] = "123";
        strArray[3] = "null";


        String s = observ_chars(strArray);
        System.out.println(s);
    }

    public static String observ_chars(String[] observer) {
        List<String> inList = new ArrayList<>(Arrays.asList(observer));
        inList.remove("null");
        //inList.remove("null");

        Set<Character> charSet = new HashSet<>();
        StringBuilder str = new StringBuilder();
        //observer.("null");
        for (String s : inList) {
            char[] charArray = s.trim().toCharArray();
            for (char c : charArray) {
                charSet.add(c);
            }
        }

        List<Character> list = new ArrayList<>(charSet);
        Collections.sort(list);
        for (Character c : list)
            str.append(c);

        return str.toString();
    }
}

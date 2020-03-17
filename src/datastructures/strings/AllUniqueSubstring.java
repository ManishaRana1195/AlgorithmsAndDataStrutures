package datastructures.strings;

import java.util.HashSet;

public class AllUniqueSubstring {


    public static void main(String[] args) {
        String input = "ababa";

        HashSet<String> result = new HashSet<>();

        for (int i = 0; i <= input.length(); i++) {
            StringBuilder temp = new StringBuilder();
            for (int j = i; j < input.length(); j++) {
                temp.append(input.charAt(j));
                result.add(temp.toString());
            }
        }

        int length = input.length();

        System.out.println(length);
        result.forEach(System.out::println);
    }
}

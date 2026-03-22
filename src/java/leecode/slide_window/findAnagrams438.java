package leecode.slide_window;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class findAnagrams438 {
    public static List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        char[] chars = p.toCharArray();
        Arrays.sort(chars);
        String sortP = String.valueOf(chars);
        for (int firstIndex = 0; firstIndex < s.length(); firstIndex++) {
            int secondIndex = firstIndex + p.length();
            if (secondIndex > s.length()) {
                break;
            }
            char[] subStrChars = s.substring(firstIndex, secondIndex).toCharArray();
            Arrays.sort(subStrChars);
            String subStr = String.valueOf(subStrChars);
            if (sortP.equals(subStr)) {
                result.add(firstIndex);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(findAnagrams("findAnagrams", "abc"));
    }
}

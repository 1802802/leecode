package leecode;

import java.util.HashSet;
import java.util.Objects;

public class lengthOfLongestSubstring3 {
    public int lengthOfLongestSubstring(String s) {
        if (Objects.equals(s, "")) {
            return 0;
        }
        String[] strs = s.split("");
        int first = 0;
        int second = 0;
        int maxLength = 0;
        HashSet<String> maxLengthStrSet = new HashSet<>();
        while (second < strs.length) {
            if (strs.length == 1) {
                maxLength = 1;
                break;
            }
            if (first == second) {
                maxLengthStrSet.add(strs[first]);
                second++;
            } else {
                if (maxLengthStrSet.contains(strs[second])) {
                    first++;
                    second = first;
                    maxLength = Math.max(maxLengthStrSet.size(), maxLength);
                    maxLengthStrSet.clear();
                } else {
                    maxLengthStrSet.add(strs[second]);
                    second++;
                }
            }
        }
        return Math.max(maxLengthStrSet.size(), maxLength);
    }

    public int lengthOfLongestSubstring2(String s) {
        int first = 0;
        int second = 0;
        int maxLength = 0;
        HashSet<Character> maxLengthStrSet = new HashSet<>();
        while (second < s.length()) {
            if (first == second) {
                maxLengthStrSet.add(s.charAt(first));
                second++;
            } else {
                if (maxLengthStrSet.contains(s.charAt(second))) {
                    first++;
                    second = first;
                    maxLength = Math.max(maxLengthStrSet.size(), maxLength);
                    maxLengthStrSet.clear();
                } else {
                    maxLengthStrSet.add(s.charAt(second));
                    second++;
                }
            }
        }
        return Math.max(maxLengthStrSet.size(), maxLength);
    }
}

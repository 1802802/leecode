package leecode.substring;

import java.util.*;
import java.util.stream.Collectors;

public class minWindow76 {
    /*
    这题的本质还是要做成一个滑动窗口，如果右边满足了子串的条件，就开始尝试动左边。如果左边到了不满足条件，则右边，以此类推
    比较麻烦的三点，
    一是要处理这个窗口的左右指针移动，
    二是对于这个while的停止条件需要好好设计下，
    三是result这里不能存list，只能是一个个替换，所以需要先做下初始化
     */
    public static String minWindow(String s, String t) {
        int leftIndex = 0;
        int rightIndex = 0;
        String result = "";
        Map<Character, Long> subStrCharMap = new HashMap<>();
        Map<Character, Long> tCharMap = t.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(c -> c, Collectors.counting()));
        boolean isLeftContinue = true;
        boolean isRightContinue = true;
        while (isLeftContinue) {
            if (check(subStrCharMap, tCharMap)) {
                String currentSubStr = s.substring(leftIndex, rightIndex);
                if (result.isEmpty()) {
                    result = currentSubStr;
                } else if (result.length() > currentSubStr.length()) {
                    result = currentSubStr;
                }
                subStrCharMap.put(s.charAt(leftIndex), subStrCharMap.get(s.charAt(leftIndex)) - 1L);
                leftIndex++;
            } else if (!isRightContinue) {
                isLeftContinue = false;
            } else {
                if (rightIndex == s.length()) {
                    isRightContinue = false;
                } else {
                    subStrCharMap.put(s.charAt(rightIndex), subStrCharMap.getOrDefault(s.charAt(rightIndex), 0L) + 1L);
                    rightIndex++;
                }
            }
        }
        return result;
    }

    public static boolean check(Map<Character, Long> currentSubStrCharMap, Map<Character, Long> tCharMap) {
        for (Map.Entry<Character, Long> entry : tCharMap.entrySet()) {
            Character c = entry.getKey();
            Long count = entry.getValue();
            if (currentSubStrCharMap.getOrDefault(c, 0L) < count) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "ab";
        String t = "a";
        System.out.println(minWindow(s, t));
    }
}

package leecode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class findAnagrams438 {
    public List<Integer> findAnagrams(String s, String p) {
        String sortP = p.chars()
                .sorted()
                .mapToObj(c -> (char) c)
                .map(c -> Character.toString(c))
                .collect(Collectors.joining());
        List<Integer> result = new ArrayList<>();
        if (s.length() >= p.length()) {
            int first = 0;
            int second = p.length();
            while (second <= s.length()) {
                String subS = s.substring(first, second).chars()
                        .sorted()
                        .mapToObj(c -> (char) c)
                        .map(c -> Character.toString(c))
                        .collect(Collectors.joining());
                if (Objects.equals(subS, sortP)) {
                    result.add(first);
                }
                first++;
                second++;
            }
        }
        return result;
    }

    public List<Integer> findAnagrams2(String s, String p) {
        int[] pCount = new int[26];
        for (int i = 0; i < p.length(); ++i) {
            ++pCount[p.charAt(i) - 'a'];
        }
        List<Integer> result = new ArrayList<>();
        if (s.length() >= p.length()) {
            int first = 0;
            int second = p.length();
            while (second <= s.length()) {
                String sub = s.substring(first, second);
                int[] sCount = new int[26];
                for (int i = 0; i < sub.length(); i++) {
                    ++sCount[sub.charAt(i) - 'a'];
                }
                if (Arrays.equals(sCount, pCount)) {
                    result.add(first);
                    first++;
                    second++;
                    while (second <= s.length() && Objects.equals(s.charAt(first - 1), s.charAt(second - 1))) {
                        result.add(first);
                        first++;
                        second++;
                    }
                } else {
                    first++;
                    second++;
                }
            }
        }
        return result;
    }

    public List<Integer> findAnagrams3(String s, String p) {
        int[] pCount = new int[26];
        for (int i = 0; i < p.length(); ++i) {
            ++pCount[p.charAt(i) - 'a'];
        }
        List<Integer> result = new ArrayList<>();
        if (s.length() >= p.length()) {
            int first = 0;
            int second = p.length();
            while (second <= s.length()) {
                String sub = s.substring(first, second);
                int[] sCount = new int[26];
                for (int i = 0; i < sub.length(); i++) {
                    ++sCount[sub.charAt(i) - 'a'];
                }
                if (Arrays.equals(sCount, pCount)) {
                    result.add(first);
                }
                first++;
                second++;
            }
        }
        return result;
    }
}

package leecode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class groupAnagrams49 {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> result = Arrays.stream(strs)
                .collect(Collectors.groupingBy(str -> Arrays.stream(str.split(""))
                        .sorted()
                        .collect(Collectors.joining())));
        return new ArrayList<>(result.values());
    }

    public List<List<String>> groupAnagrams2(String[] strs) {
        Map<String, List<String>> result = Arrays.stream(strs)
                .collect(Collectors.groupingBy(str -> str.chars()
                        .sorted()
                        .mapToObj(c -> (char) c)
                        .map(c -> Character.toString(c))
                        .collect(Collectors.joining())));
        return new ArrayList<>(result.values());
    }
}

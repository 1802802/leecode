package leecode.double_point;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class threeSum15 {
    public List<List<Integer>> threeSum(int[] nums) {
        Set<String> result = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (i == 0 || (nums[i] != nums[i - 1])) {
                Set<Integer> set = new HashSet<>();
                for (int j = i + 1; j < nums.length; j++) {
                    int needNum = -nums[i] - nums[j];
                    if (set.contains(needNum)) {
                        result.add(Stream.of(nums[i], nums[j], needNum)
                                .sorted()
                                .map(String::valueOf)
                                .collect(Collectors.joining(",")));
                    }
                    set.add(nums[j]);
                }
            }
        }
        return result.stream()
                .map(str -> Arrays.stream(str.split(","))
                        .map(Integer::valueOf)
                        .collect(Collectors.toList()))
                .collect(Collectors.toList());
    }
}

package leecode;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class longestConsecutive128 {
    public int longestConsecutive(int[] nums) {
        List<Integer> numList = Arrays.stream(nums)
                .distinct()
                .sorted()
                .boxed()
                .collect(Collectors.toList());
        int length = 0;
        int maxLength = 0;
        for (int i = 0; i < numList.size(); i++) {
            if (i == 0) {
                length++;
            } else if (numList.get(i) == numList.get(i - 1) + 1) {
                length++;
            } else {
                maxLength = Math.max(length, maxLength);
                length = 1;
            }
        }
        return Math.max(length, maxLength);
    }

    public int longestConsecutive2(int[] nums) {
        Set<Integer> numSet = Arrays.stream(nums)
                .boxed()
                .collect(Collectors.toSet());
        int length = 0;
        int maxLength = 0;
        for (int num : numSet) {
            if (!numSet.contains(num - 1)) {
                length = 1;
                while (numSet.contains(num + 1)) {
                    num++;
                    length++;
                }
                maxLength = Math.max(length, maxLength);
            }
        }
        return maxLength;
    }
}

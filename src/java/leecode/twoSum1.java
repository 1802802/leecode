package leecode;

import java.util.*;

public class twoSum1 {
    public int[] twoSum1(int[] nums, int target) {
        Set<Integer> notSet = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (!notSet.contains(nums[i])) {
                for (int j = i + 1; j < nums.length; j++) {
                    if (!notSet.contains(nums[j])) {
                        if (nums[i] + nums[j] == target) {
                            return new int[]{i, j};
                        }
                    }
                }
                notSet.add(nums[i]);
            }
        }
        return null;
    }

    public int[] twoSum2(int[] nums, int target) {
        Map<Integer, Integer> numMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int currentNum = nums[i];
            int currentNeedNum = target - currentNum;
            if (numMap.containsKey(currentNeedNum)) {
                return new int[]{numMap.get(currentNeedNum), i};
            } else {
                numMap.put(currentNum, i);
            }
        }
        return null;
    }
}

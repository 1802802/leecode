package leecode;

import java.util.HashMap;
import java.util.Map;

public class subarraySum560 {
    public int subarraySum(int[] nums, int k) {
        int count = 0;
        int sum = 0;
        Map<Integer, Integer> sumCountMap = new HashMap<>();
        sumCountMap.put(0, 1);
        for (int num : nums) {
            sum += num;
            if (sumCountMap.containsKey(sum - k)) {
                count += sumCountMap.get(sum - k);
            }
            sumCountMap.computeIfPresent(sum, (key, value) -> value + 1);
            sumCountMap.putIfAbsent(sum, 1);
        }
        return count;
    }

    public int subarraySum2(int[] nums, int k) {
        int total = 0;
        int left = 0;
        int right = 0;
        int sumNum = 0;
        while (left < nums.length && right < nums.length) {
            if (left == right) {
                sumNum += nums[right];
                if (sumNum == k) {
                    total++;
                    if (right == nums.length - 1) {
                        left++;
                    } else {
                        right++;
                    }
                } else if (sumNum < k) {
                    if (right == nums.length - 1) {
                        left++;
                    } else {
                        right++;
                    }
                } else {
                    sumNum -= nums[left];
                    left++;
                    if (right == nums.length - 1) {
                        left++;
                    } else {
                        right++;
                    }
                }
            } else if (left < right) {
                sumNum += nums[right];
                if (sumNum == k) {
                    total++;
                    if (right == nums.length - 1) {
                        left++;
                    } else {
                        right++;
                    }
                } else if (sumNum < k) {
                    if (right == nums.length - 1) {
                        left++;
                    } else {
                        right++;
                    }
                } else {
                    sumNum -= nums[left];
                    sumNum -= nums[right];
                    left++;
                }
            }
        }
        return total;
    }

    public static void main(String[] args) {
        subarraySum560 s = new subarraySum560();
        s.subarraySum(new int[] {1,-1,0}, 0);
    }
}

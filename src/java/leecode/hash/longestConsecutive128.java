package leecode.hash;

import javafx.util.Pair;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class longestConsecutive128 {
    /*
    自己想的剪枝，结果其实用k-1是否包含其实就做到了，因为数据是连续的
     */
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0)  {
            return 0;
        }

        int maxNum = nums[0];
        Set<Integer> set = new HashSet<>();
        for (int k : nums) {
            maxNum = Math.max(maxNum, k);
            set.add(k);
        }

        Map<Integer, Integer> resultSave = new HashMap<>();
        int result = 0;
        for (int k : set) {
            if (!set.contains(k - 1)) {
                int num = 1;
                boolean isMatch = false;
                for (Map.Entry<Integer, Integer> entry : resultSave.entrySet()) {
                    Integer leftValue = entry.getKey();
                    Integer rightValue = entry.getValue();
                    if (leftValue <= k && rightValue >= k) {
                        num = rightValue - k + 1;
                        isMatch = true;
                        break;
                    }
                }
                if (!isMatch) {
                    for (int j = 1; j <= maxNum - k; j++) {
                        if (set.contains(k + j)) {
                            num++;
                        } else {
                            resultSave.put(k, k + j - 1);
                            break;
                        }
                    }
                }
                result = Math.max(result, num);
            }
        }

        return result;
    }

    /*
    最基本的set+剪枝策略（k-1和一半size）
     */
    public int longestConsecutive2(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        int maxNum = nums[0];
        Set<Integer> set = new HashSet<>();
        for (int k : nums) {
            maxNum = Math.max(maxNum, k);
            set.add(k);
        }

        int result = 0;
        for (int k : set) {
            if (!set.contains(k - 1)) {
                int num = 1;
                for (int j = 1; j <= maxNum - k; j++) {
                    if (set.contains(k + j)) {
                        num++;
                    } else {
                        break;
                    }
                }
                result = Math.max(result, num);
                if (result * 2 > set.size()) {
                    break;
                }
            }
        }

        return result;
    }

    /*
    这个其实是想用空间换时间的，但其实k-1的判断就做到了，属于多此一举
     */
    public int longestConsecutive3(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        int maxNum = nums[0];
        Set<Integer> set = new HashSet<>();
        for (int k : nums) {
            maxNum = Math.max(maxNum, k);
            set.add(k);
        }

        Set<Integer> useSet = new HashSet<>();
        int result = 0;
        for (int k : set) {
            if (!set.contains(k - 1) && !useSet.contains(k)) {
                int num = 1;
                for (int j = 1; j <= maxNum - k; j++) {
                    if (set.contains(k + j)) {
                        num++;
                        useSet.add(k + j);
                    } else {
                        break;
                    }
                }
                result = Math.max(result, num);
                if (result * 2 > set.size()) {
                    break;
                }
            }
        }

        return result;
    }
}

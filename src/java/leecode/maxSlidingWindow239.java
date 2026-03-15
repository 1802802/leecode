package leecode;

import java.util.*;

public class maxSlidingWindow239 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int maxNum = nums[0];
        List<Integer> result = new ArrayList<>();
        Map<Integer, Integer> numCountMap = new HashMap<>();

        for (int i = 0; i < k; i++) {
            numCountMap.computeIfPresent(nums[i], (key, value) -> value + 1);
            numCountMap.putIfAbsent(nums[i], 1);
            maxNum = Math.max(maxNum, nums[i]);
        }
        result.add(maxNum);
        int left = 1;
        int right = k;

        while (right < nums.length) {
            numCountMap.computeIfPresent(nums[left - 1], (key, value) -> value - 1);
            if (numCountMap.get(nums[left - 1]) == 0) {
                numCountMap.remove(nums[left - 1]);
            }
            numCountMap.computeIfPresent(nums[right], (key, value) -> value + 1);
            numCountMap.putIfAbsent(nums[right], 1);
            if (nums[right] > maxNum) {
                maxNum = nums[right];
            } else if (!numCountMap.containsKey(maxNum)) {
                maxNum = numCountMap.keySet().stream().max(Integer::compare).orElse(0);
            }
            result.add(maxNum);
            left++;
            right++;
        }

        return result.stream().mapToInt(Integer::valueOf).toArray();
    }

    public int[] maxSlidingWindow2(int[] nums, int k) {
        int n = nums.length;
        PriorityQueue<int[]> pq = new PriorityQueue<>((pair1, pair2) -> pair1[0] != pair2[0] ? pair2[0] - pair1[0] : pair2[1] - pair1[1]);
        for (int i = 0; i < k; ++i) {
            pq.offer(new int[]{nums[i], i});
        }
        int[] ans = new int[n - k + 1];
        ans[0] = pq.peek()[0];
        for (int i = k; i < n; ++i) {
            pq.offer(new int[]{nums[i], i});
            while (pq.peek()[1] <= i - k) {
                pq.poll();
            }
            ans[i - k + 1] = pq.peek()[0];
        }
        return ans;
    }

    public static void main(String[] args) {
        maxSlidingWindow239 maxSlidingWindow239 = new maxSlidingWindow239();
        maxSlidingWindow239.maxSlidingWindow(new int[] {1,3,-1,-3,5,3,6,7}, 3);
    }
}

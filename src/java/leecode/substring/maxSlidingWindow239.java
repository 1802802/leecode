package leecode.substring;

import javafx.util.Pair;

import java.util.PriorityQueue;

public class maxSlidingWindow239 {
    /*
    这个需要理解优先级队列，将数值和index都存起来，之后如果当前最大的数值的位置不在窗口内了，就删除，这里是延迟删除的思想，节省时间
    不过话说回来，要明白思路，本质是一个数据结构的运转逻辑
     */
    public int[] maxSlidingWindow(int[] nums, int k) {
        PriorityQueue<Pair<Integer, Integer>> maxHeap = new PriorityQueue<>((a, b) -> b.getKey() - a.getKey());
        int[] result = new int[nums.length - k + 1];
        for (int j = 0; j < k; j++) {
            maxHeap.add(new Pair<>(nums[j], j));
        }
        if (!maxHeap.isEmpty()) {
            result[0] = maxHeap.peek().getKey();
        }
        for (int i = k; i < nums.length; i++) {
            maxHeap.add(new Pair<>(nums[i], i));
            while(!maxHeap.isEmpty() && maxHeap.peek().getValue() < i - k + 1) {
                maxHeap.poll();
            }
            if (!maxHeap.isEmpty()) {
                result[i - k + 1] = maxHeap.peek().getKey();
            }
        }
        return result;
    }
}

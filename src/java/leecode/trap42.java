package leecode;

import java.util.HashMap;
import java.util.Map;

public class trap42 {
    public int trap(int[] height) {
        int maxLeft = 0;
        Map<Integer, Integer> leftMap = new HashMap<>();
        for (int i = 0; i < height.length; i++) {
            maxLeft = Math.max(maxLeft, height[i]);
            leftMap.put(i, maxLeft - height[i]);
        }

        int maxRight = 0;
        Map<Integer, Integer> rightMap = new HashMap<>();
        for (int i = height.length - 1; i >= 0; i--) {
            maxRight = Math.max(maxRight, height[i]);
            rightMap.put(i, maxRight - height[i]);
        }

        int trap = 0;
        for (int i = 0; i < leftMap.entrySet().size(); i++) {
            trap += Math.min(leftMap.get(i), rightMap.get(i));
        }

        return trap;
    }
}

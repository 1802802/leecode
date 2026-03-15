package leecode;

public class maxArea11 {
    public int maxArea(int[] height) {
        int maxArea = 0;
        for (int i = 0; i < height.length; i++) {
            for (int j = i + 1; j < height.length; j++) {
                int area = Math.abs(i - j) * Math.min(height[i], height[j]);
                maxArea = Math.max(area, maxArea);
            }
        }
        return maxArea;
    }

    public int maxArea2(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int maxArea = 0;
        while (left != right) {
            int area = Math.abs(left - right) * Math.min(height[left], height[right]);
            maxArea = Math.max(area, maxArea);
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return maxArea;
    }
}

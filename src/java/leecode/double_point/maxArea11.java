package leecode.double_point;

public class maxArea11 {
    /*
    原始的暴力解法，会有超时问题
     */
    public int maxArea(int[] height) {
        int maxArea = 0;
        for (int i = 0; i < height.length; i++) {
            for (int j = i + 1; j < height.length; j++) {
                int areaHeight = Math.min(height[i], height[j]);
                int areaWidth = j - i;
                maxArea = Math.max(maxArea, areaHeight * areaWidth);
            }
        }
        return maxArea;
    }

    /*
    双指针法，x在最左边，y在最右边，核心是要理解，面积其实是min(x,y) * t，假设x比y大，那么yt就是真实的面积。
    此时需要移动y的位置，才能让空间变大。因为如果动x只会是不变或者更小，动y才可能让数据发生变化。所以就是移动偏小的指针
     */
    public int maxArea2(int[] height) {
        int x = 0;
        int y = height.length - 1;
        int maxArea = 0;
        while (x < y) {
            int areaHeight = Math.min(height[x], height[y]);
            int areaWidth = y -x;
            maxArea = Math.max(maxArea, areaHeight * areaWidth);
            if (height[x] <= height[y]) {
                x += 1;
            } else {
                y -= 1;
            }
        }
        return maxArea;
    }
}

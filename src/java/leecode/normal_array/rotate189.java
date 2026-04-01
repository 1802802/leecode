package leecode.normal_array;

import java.util.Arrays;

public class rotate189 {
    /*
    最原始的写法，用另一个数组转存
     */
    public void rotate(int[] nums, int k) {
        int actualK = k % nums.length;
        int[] baseNums = Arrays.copyOf(nums, nums.length);
        for (int i = 0; i < nums.length; i++) {
            int actualIndex = i + actualK >= nums.length ? i + actualK - nums.length : i + actualK;
            nums[actualIndex] = baseNums[i];
        }
    }

    /*
    翻转法，先全部反转，再通过0到k-1.和k到数组末尾的反转实现
     */
    public void rotate2(int[] nums, int k) {
        k = k % nums.length;
        rotateArray(nums, 0, nums.length - 1);
        rotateArray(nums, 0, k - 1);
        rotateArray(nums, k, nums.length - 1);
    }

    public void rotateArray(int[] nums, int i, int j) {
        while (i < j) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
            i++;
            j--;
        }
    }
}

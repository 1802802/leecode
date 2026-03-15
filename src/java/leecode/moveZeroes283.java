package leecode;

public class moveZeroes283 {
    public void moveZeroes(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                for (int j = i + 1; j < nums.length; j++) {
                    if (nums[j] != 0) {
                        int swapNum = nums[i];
                        nums[i] = nums[j];
                        nums[j] = swapNum;
                        break;
                    }
                }
            }
        }
    }

    public void moveZeroes2(int[] nums) {
        int left = 0;
        int right = 0;
        while (right < nums.length) {
            if (nums[right] != 0) {
                int swapNum = nums[left];
                nums[left] = nums[right];
                nums[right] = swapNum;
                left++;
            }
            right++;
        }
    }
}

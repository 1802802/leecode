package leecode.normal_array;

public class productExceptSelf238 {
    /*
    这里的本质是，先计算每个数据i左侧所有数据的乘积，再计算i右侧所有数据的乘积
     */
    public int[] productExceptSelf(int[] nums) {
        int[] leftValueArray = new int[nums.length];
        int[] rightValueArray = new int[nums.length];
        int[] answer = new int[nums.length];

        leftValueArray[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            leftValueArray[i] = leftValueArray[i - 1] * nums[i - 1];
        }

        rightValueArray[nums.length - 1] = 1;
        for (int i = nums.length - 2; i >= 0; i--) {
            rightValueArray[i] = rightValueArray[i + 1] * nums[i + 1];
        }

        for (int i = 0; i < nums.length; i++) {
            answer[i] = leftValueArray[i] * rightValueArray[i];
        }

        return answer;
    }
}

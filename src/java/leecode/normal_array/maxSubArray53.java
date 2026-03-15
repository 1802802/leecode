package leecode.normal_array;

public class maxSubArray53 {
    /*
    方法一：动态规划
思路和算法

假设 nums 数组的长度是 n，下标从 0 到 n−1。

我们用 f(i) 代表以第 i 个数结尾的「连续子数组的最大和」，那么很显然我们要求的答案就是：

因此我们只需要求出每个位置的 f(i)，然后返回 f 数组中的最大值即可。那么我们如何求 f(i) 呢？我们可以考虑 nums[i] 单独成为一段还是加入 f(i−1) 对应的那一段，这取决于 nums[i] 和 f(i−1)+nums[i] 的大小，我们希望获得一个比较大的，于是可以写出这样的动态规划转移方程：

f(i)=max{f(i−1)+nums[i],nums[i]}

不难给出一个时间复杂度 O(n)、空间复杂度 O(n) 的实现，即用一个 f 数组来保存 f(i) 的值，用一个循环求出所有 f(i)。考虑到 f(i) 只和 f(i−1) 相关，于是我们可以只用一个变量 pre 来维护对于当前 f(i) 的 f(i−1) 的值是多少，从而让空间复杂度降低到 O(1)，这有点类似「滚动数组」的思想。

作者：力扣官方题解
链接：https://leetcode.cn/problems/maximum-subarray/solutions/228009/zui-da-zi-xu-he-by-leetcode-solution/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    public int maxSubArray1(int[] nums) {
        int result = nums[0];
        int latestMaxSum = 0;
        for (int num : nums) {
            latestMaxSum = Math.max(num, num + latestMaxSum);
            result = Math.max(result, latestMaxSum);
        }
        return result;
    }
}

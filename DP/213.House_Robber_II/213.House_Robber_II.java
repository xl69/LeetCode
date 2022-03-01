class Solution {
    public int rob(int[] nums) {
        if (nums.length == 1) return nums[0];
        return Math.max(_rob(nums, 0, nums.length - 1), _rob(nums, 1, nums.length));
    }
    private int _rob(int[] nums, int start, int end) {
        int rob = 0, not_rob = 0;
        for (int i = start; i < end; i++) {
            int not_rob_temp = not_rob;
            not_rob = Math.max(not_rob, rob);
            rob = not_rob_temp + nums[i];
        }
        return Math.max(rob, not_rob);
    }
}
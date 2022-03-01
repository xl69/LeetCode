class Solution {
    public int rob(int[] nums) {
        int rob = nums[0], not_rob = 0;
        for (int i = 1; i < nums.length; i++) {
            int not_rob_temp = not_rob;
            not_rob = Math.max(not_rob, rob);
            rob = not_rob_temp + nums[i];
        }
        return Math.max(rob, not_rob);
    }
}
class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int left = 0, sum = 0, minLen = nums.length + 1;
        for (int right = 0; right < nums.length; right++) {
            sum += nums[right];
            while (sum - nums[left] >= target) {
                sum -= nums[left];
                left++;
            }
            if (sum >= target) minLen = Math.min(minLen, right - left + 1);
        }
        return minLen == nums.length + 1 ? 0 : minLen;
    }
}
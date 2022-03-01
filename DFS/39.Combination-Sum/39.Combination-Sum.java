class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(candidates);
        backtrack(res, new ArrayList<>(), 0, candidates, 0, target);
        return res;
    }
    private void backtrack(List<List<Integer>> res, List<Integer> tmp, 
                           int index, int[] nums, int sum, int target) {
        if (target < 0) return;
        if (target == 0) {
            res.add(new ArrayList<>(tmp));
            return;
        }
        for (int i = index; i < nums.length; i++) {
            if (nums[i] > target) return;
            tmp.add(nums[i]);
            backtrack(res, tmp, i, nums, sum + nums[i], target - nums[i]);
            tmp.remove(tmp.size() - 1);
        }
    }
}
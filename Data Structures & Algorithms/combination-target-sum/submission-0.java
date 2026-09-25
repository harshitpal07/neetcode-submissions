class Solution {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {

        List<List<Integer>> res = new ArrayList<>();
        List<Integer> diary = new ArrayList<>();

        fun(candidates, candidates.length, 0,
            diary, 0, res, target);

        return res;
    }

    void fun(int[] a, int n, int idx,
             List<Integer> diary,
             int sum,
             List<List<Integer>> res,
             int target) {

        // target mil gaya
        if (sum == target) {
            res.add(new ArrayList<>(diary));
            return;
        }

        // target cross ho gaya
        if (sum > target || idx >= n) {
            return;
        }

        // Choice 1: TAKE
        diary.add(a[idx]);
        sum = sum + a[idx];

        // idx same -> same element dobara le sakte hain
        fun(a, n, idx, diary, sum, res, target);

        // Backtracking
        diary.remove(diary.size() - 1);
        sum = sum - a[idx];

        // Choice 2: SKIP
        fun(a, n, idx + 1, diary, sum, res, target);
    }
}
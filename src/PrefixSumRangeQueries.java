public class PrefixSumRangeQueries {
    private int[] prefix;

    public PrefixSumRangeQueries(int[] nums) {
        prefix = new int[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            prefix[i + 1] = prefix[i] + nums[i];
        }
    }

    // query sum of range [l, r]
    public int rangeSum(int l, int r) {
        return prefix[r + 1] - prefix[l];
    }

    public static void main(String[] args) {
        int[] nums = { 1, 2, 3, 4, 5 };
        PrefixSumRangeQueries ps = new PrefixSumRangeQueries(nums);
        System.out.println(ps.rangeSum(1, 3)); // Output: 9 (2+3+4)
    }
}

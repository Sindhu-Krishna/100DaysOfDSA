// An index i is equilibrium if sum of elements before i equals sum after i.

public class EquilibriumPoint {
    public static int findEquilibrium(int[] nums) {
        int totalSum = 0, leftSum = 0;
        for (int num : nums)
            totalSum += num;

        for (int i = 0; i < nums.length; i++) {
            totalSum -= nums[i]; // right sum
            if (leftSum == totalSum)
                return i; // equilibrium index
            leftSum += nums[i];
        }
        return -1; // if no equilibrium point exists
    }

    public static void main(String[] args) {
        int[] nums = { 1, 3, 5, 2, 2 };
        System.out.println(findEquilibrium(nums)); // Output: 2
    }
}

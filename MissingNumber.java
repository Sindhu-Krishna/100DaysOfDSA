public class MissingNumber {
    public static int missingNumber(int[] nums) {
        int n = nums.length;
        int xor = n; // include n
        for (int i = 0; i < n; i++) {
            xor ^= i ^ nums[i];
        }
        return xor;
    }

    public static void main(String[] args) {
        int[] nums = { 3, 0, 1 };
        System.out.println(missingNumber(nums)); // Output: 2
    }
}

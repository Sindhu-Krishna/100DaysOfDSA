// Greedy solution (O(n))

public class MinimumJumps {
    public static int minJumps(int[] nums) {
        if (nums.length <= 1)
            return 0;
        if (nums[0] == 0)
            return -1; // cannot move

        int jumps = 1;
        int maxReach = nums[0];
        int steps = nums[0];

        for (int i = 1; i < nums.length; i++) {
            if (i == nums.length - 1)
                return jumps;

            maxReach = Math.max(maxReach, i + nums[i]);
            steps--;

            if (steps == 0) {
                jumps++;
                if (i >= maxReach)
                    return -1; // cannot proceed
                steps = maxReach - i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = { 2, 3, 1, 1, 4 };
        System.out.println(minJumps(nums)); // Output: 2
    }
}

import java.util.HashSet;

public class LongestConsecutiveSubsequence {
    public static int longestConsecutive(int[] nums) {
        if (nums.length == 0)
            return 0;

        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }

        int longestStreak = 0;

        for (int num : set) {
            // only start from the beginning of a sequence
            if (!set.contains(num - 1)) {
                int currentNum = num;
                int currentStreak = 1;

                while (set.contains(currentNum + 1)) {
                    currentNum++;
                    currentStreak++;
                }

                longestStreak = Math.max(longestStreak, currentStreak);
            }
        }
        return longestStreak;
    }

    public static void main(String[] args) {
        int[] nums1 = { 100, 4, 200, 1, 3, 2 };
        System.out.println("Longest consecutive length: " + longestConsecutive(nums1));
        // Output: 4 (sequence: 1,2,3,4)

        int[] nums2 = { 0, 3, 7, 2, 5, 8, 4, 6, 0, 1 };
        System.out.println("Longest consecutive length: " + longestConsecutive(nums2));
        // Output: 9 (sequence: 0–8)
    }
}

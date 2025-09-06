public class MajorityElement {
    public static int majorityElement(int[] nums) {
        int count = 0;
        int candidate = 0;

        // Step 1: Find candidate using Moore’s Voting
        for (int num : nums) {
            if (count == 0) {
                candidate = num;
            }
            count += (num == candidate) ? 1 : -1;
        }

        // Step 2: Since the problem guarantees majority element exists,
        // candidate is the answer
        return candidate;
    }

    public static void main(String[] args) {
        int[] nums1 = { 3, 2, 3 };
        int[] nums2 = { 2, 2, 1, 1, 1, 2, 2 };

        System.out.println("Majority Element in nums1: " + majorityElement(nums1));
        System.out.println("Majority Element in nums2: " + majorityElement(nums2));
    }
}

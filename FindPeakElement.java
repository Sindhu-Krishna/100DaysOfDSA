// A peak is an element that is greater than its neighbors.

public class FindPeakElement {
    public static int findPeak(int[] nums) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int mid = (left + right) / 2;
            if (nums[mid] < nums[mid + 1]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left; // index of peak
    }

    public static void main(String[] args) {
        int[] nums = { 1, 2, 3, 1 };
        int peakIndex = findPeak(nums);
        System.out.println("Peak at index: " + peakIndex + ", value: " + nums[peakIndex]);
    }
}

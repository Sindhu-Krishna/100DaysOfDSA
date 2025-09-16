public class MaximumSubarray {
    public static int maxSubArray(int[] arr) {
        int maxSoFar = arr[0]; // keep track of max till now
        int currentSum = arr[0]; // running sum

        for (int i = 1; i < arr.length; i++) {
            // either start fresh from arr[i] or keep adding
            currentSum = Math.max(arr[i], currentSum + arr[i]);
            // update max
            maxSoFar = Math.max(maxSoFar, currentSum);
        }
        return maxSoFar;
    }

    public static void main(String[] args) {
        int[] arr = { -2, 1, -3, 4, -1, 2, 1, -5, 4 };
        int maxSum = maxSubArray(arr);
        System.out.println("Maximum subarray sum (Kadane’s Algorithm): " + maxSum);
    }
}

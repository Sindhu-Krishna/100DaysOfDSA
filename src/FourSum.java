/*
Problem:
Given an array nums of n integers, return all unique quadruplets [nums[a], nums[b], nums[c], nums[d]] such that:
 
    a, b, c, d are all different
    nums[a] + nums[b] + nums[c] + nums[d] == target
 
Example: 
Input: nums = [1,0,-1,0,-2,2], target = 0
Output: [[-2,-1,1,2], [-2,0,0,2], [-1,0,0,1]]
*/

import java.util.*;

public class FourSum {
    public static List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        int n = nums.length;

        for (int i = 0; i < n - 3; i++) {
            if (i > 0 && nums[i] == nums[i - 1])
                continue; // skip duplicates

            for (int j = i + 1; j < n - 2; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1])
                    continue; // skip duplicates

                int left = j + 1, right = n - 1;

                while (left < right) {
                    long sum = (long) nums[i] + nums[j] + nums[left] + nums[right];

                    if (sum == target) {
                        res.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
                        left++;
                        right--;

                        while (left < right && nums[left] == nums[left - 1])
                            left++;
                        while (left < right && nums[right] == nums[right + 1])
                            right--;
                    } else if (sum < target)
                        left++;
                    else
                        right--;
                }
            }
        }

        return res;
    }

    public static void main(String[] args) {
        int[] nums = { 1, 0, -1, 0, -2, 2 };
        int target = 0;
        System.out.println(fourSum(nums, target));
    }
}

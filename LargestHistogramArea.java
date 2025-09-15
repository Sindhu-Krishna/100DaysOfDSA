/*
Problem:
You are given an array heights[] of length n, representing the heights of bars in a histogram.
Find the area of the largest rectangle that can be formed within the bounds of the histogram.
 
Example:
Input: heights = [2,1,5,6,2,3]
Output: 10
Explanation: Rectangle formed by heights[2]=5 and heights[3]=6 gives area 5*2=10
 */

import java.util.Stack;

public class LargestHistogramArea {
    public static int largestRectangleArea(int[] heights) {
        int n = heights.length;
        Stack<Integer> stack = new Stack<>();
        int maxArea = 0;

        for (int i = 0; i <= n; i++) {
            int h = (i == n) ? 0 : heights[i];
            while (!stack.isEmpty() && h < heights[stack.peek()]) {
                int height = heights[stack.pop()];
                int width = stack.isEmpty() ? i : i - stack.peek() - 1;
                maxArea = Math.max(maxArea, height * width);
            }
            stack.push(i);
        }
        return maxArea;
    }

    public static void main(String[] args) {
        int[] heights = { 2, 1, 5, 6, 2, 3 };
        System.out.println("Largest Rectangle Area: " + largestRectangleArea(heights));
    }
}

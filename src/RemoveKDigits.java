import java.util.*;

class RemoveKDigits {
    public String removeKdigits(String num, int k) {
        // If k equals the length of num, return "0"
        if (k == num.length()) {
            return "0";
        }

        // Use Deque as a stack to maintain increasing order
        Stack<Character> stack = new Stack<>();

        // Process each digit in num
        for (char digit : num.toCharArray()) {
            // Pop larger digits while possible and k > 0
            while (!stack.isEmpty() && stack.peek() > digit && k > 0) {
                stack.pop();
                k--;
            }
            // Push current digit
            stack.push(digit);
        }

        // Remove remaining k digits from the end if needed
        while (k > 0 && !stack.isEmpty()) {
            stack.pop();
            k--;
        }

        // Build result string, removing leading zeros
        StringBuilder result = new StringBuilder();
        while (!stack.isEmpty()) {
            result.append(stack.pop()); // Reverse order since stack pops from end
        }
        result.reverse(); // Reverse to get correct order

        // Remove leading zeros
        while (result.length() > 1 && result.charAt(0) == '0') {
            result.deleteCharAt(0);
        }

        // Return "0" if result is empty
        return result.length() == 0 ? "0" : result.toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        RemoveKDigits solution = new RemoveKDigits();

        // Read input
        String num = sc.next();
        int k = sc.nextInt();

        // Get and print result
        String result = solution.removeKdigits(num, k);
        System.out.println(result);

        sc.close();
    }
}
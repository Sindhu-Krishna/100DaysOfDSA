import java.util.Scanner;

class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
        this.next = null;
    }
}

/**
 * Implements the addition of two numbers represented by linked lists (O(max(m,
 * * n))).
 * The digits are stored in reverse order (head is the least significant digit).
 */
public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);
        ListNode current = dummyHead;
        int carry = 0;

        while (l1 != null || l2 != null || carry > 0) {
            int x = (l1 != null) ? l1.val : 0;
            int y = (l2 != null) ? l2.val : 0;

            int sum = x + y + carry;

            carry = sum / 10;

            current.next = new ListNode(sum % 10);

            current = current.next;

            if (l1 != null)
                l1 = l1.next;
            if (l2 != null)
                l2 = l2.next;
        }

        // Final carry check is implicitly handled by the loop condition (carry > 0),
        // but if we exit and carry remains, it is appended

        return dummyHead.next;
    }

    // Utility method to build the linked list from Scanner input
    public static ListNode buildListFromScanner(Scanner scanner, String listName) {
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;

        System.out.println(
                "Enter elements for " + listName + " (space-separated integers). End with 'e' (or any non-int).");

        while (scanner.hasNextInt()) {
            int val = scanner.nextInt();
            current.next = new ListNode(val);
            current = current.next;
        }

        if (scanner.hasNext()) {
            scanner.next();
        }

        return dummy.next;
    }

    // Utility method to print the linked list
    public static void printList(ListNode head) {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        while (head != null) {
            sb.append(head.val);
            if (head.next != null) {
                sb.append(", ");
            }
            head = head.next;
        }
        sb.append("]");
        System.out.println(sb.toString());
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        AddTwoNumbers solution = new AddTwoNumbers();

        // 1. Build the first list (L1)
        ListNode l1 = buildListFromScanner(scanner, "L1 (Reverse Order)");

        // 2. Build the second list (L2)
        ListNode l2 = buildListFromScanner(scanner, "L2 (Reverse Order)");

        // 3. Perform the addition
        ListNode result = solution.addTwoNumbers(l1, l2);

        // 4. Print the result
        System.out.println("\n--- Addition Result ---");
        System.out.print("Sum List (Reverse Order): ");
        printList(result);

        scanner.close();
    }
}

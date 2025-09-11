/* 
Given the head of a singly linked list, detect if the linked list contains a cycle (loop).
Return true if there is a loop, else false.

Example:
Input: 1->2->3->4->2 (cycle back to node with data 2)
Output: true
 */

public class DetectLoopInLinkedList {

    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    static class LinkedList {
        Node head;

        void insertAtEnd(int value) {
            Node newNode = new Node(value);
            if (head == null) {
                head = newNode;
                return;
            }
            Node temp = head;
            while (temp.next != null)
                temp = temp.next;
            temp.next = newNode;
        }

        // Create a loop manually (for testing)
        void createLoop(int pos) {
            if (head == null || pos <= 0)
                return;
            Node loopNode = null, temp = head;
            int count = 1;
            while (temp.next != null) {
                if (count == pos)
                    loopNode = temp;
                temp = temp.next;
                count++;
            }
            if (loopNode != null)
                temp.next = loopNode;
        }

        boolean hasLoop() {
            Node slow = head, fast = head;
            while (fast != null && fast.next != null) {
                slow = slow.next;
                fast = fast.next.next;
                if (slow == fast)
                    return true;
            }
            return false;
        }
    }

    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.insertAtEnd(1);
        list.insertAtEnd(2);
        list.insertAtEnd(3);
        list.insertAtEnd(4);
        list.insertAtEnd(5);

        list.createLoop(2); // create loop at node 2

        System.out.println("Loop present? " + list.hasLoop());
    }
}

public class LinkedListDemo {

    // ------------------ Doubly Linked List ------------------
    static class DNode {
        int data;
        DNode prev, next;

        DNode(int data) {
            this.data = data;
            this.prev = this.next = null;
        }
    }

    static class DoublyLinkedList {
        DNode head;

        void insertAtEnd(int value) {
            DNode newNode = new DNode(value);
            if (head == null) {
                head = newNode;
                return;
            }
            DNode temp = head;
            while (temp.next != null) temp = temp.next;
            temp.next = newNode;
            newNode.prev = temp;
        }

        void printForward() {
            DNode temp = head;
            while (temp != null) {
                System.out.print(temp.data);
                if (temp.next != null) System.out.print("->");
                temp = temp.next;
            }
            System.out.println();
        }

        void printBackward() {
            if (head == null) return;
            DNode temp = head;
            while (temp.next != null) temp = temp.next;
            while (temp != null) {
                System.out.print(temp.data);
                if (temp.prev != null) System.out.print("->");
                temp = temp.prev;
            }
            System.out.println();
        }

        void deleteAtPosition(int pos) {
            if (head == null || pos <= 0) return;
            DNode temp = head;
            int count = 1;

            while (temp != null && count < pos) {
                temp = temp.next;
                count++;
            }
            if (temp == null) return;

            if (temp.prev != null)
                temp.prev.next = temp.next;
            else
                head = temp.next;

            if (temp.next != null)
                temp.next.prev = temp.prev;
        }
    }

    // ------------------ Singly Linked List ------------------
    static class SNode {
        int data;
        SNode next;

        SNode(int data) {
            this.data = data;
            this.next = null;
        }
    }

    static class SinglyLinkedList {
        SNode head;

        void insertAtEnd(int value) {
            SNode newNode = new SNode(value);
            if (head == null) {
                head = newNode;
                return;
            }
            SNode temp = head;
            while (temp.next != null) temp = temp.next;
            temp.next = newNode;
        }

        void printList() {
            SNode temp = head;
            while (temp != null) {
                System.out.print(temp.data);
                if (temp.next != null) System.out.print("->");
                temp = temp.next;
            }
            System.out.println();
        }

        void deleteAtPosition(int pos) {
            if (head == null || pos <= 0) return;

            if (pos == 1) {
                head = head.next;
                return;
            }

            SNode temp = head;
            for (int i = 1; temp != null && i < pos - 1; i++)
                temp = temp.next;

            if (temp == null || temp.next == null) return;

            temp.next = temp.next.next;
        }
    }

    // ------------------ Main ------------------
    public static void main(String[] args) {
        int[] freq = {4, 3, 2, 3, 1, 5, 5, 2};

        // Doubly Linked List
        System.out.println("Doubly Linked List:");
        DoublyLinkedList dll = new DoublyLinkedList();
        for (int val : freq) dll.insertAtEnd(val);

        System.out.print("Forward:   ");
        dll.printForward();
        System.out.print("Backward:  ");
        dll.printBackward();

        System.out.println("Deleting node at position 3...");
        dll.deleteAtPosition(3);
        dll.printForward();

        // Singly Linked List
        System.out.println("\nSingly Linked List:");
        SinglyLinkedList sll = new SinglyLinkedList();
        for (int val : freq) sll.insertAtEnd(val);

        sll.printList();
        System.out.println("Deleting node at position 3...");
        sll.deleteAtPosition(3);
        sll.printList();
    }
}

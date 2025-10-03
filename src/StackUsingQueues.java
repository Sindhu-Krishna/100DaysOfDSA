import java.util.*;

class StackUsingQueues {
    Queue<Integer> q1 = new LinkedList<>();
    Queue<Integer> q2 = new LinkedList<>();

    // Push element onto stack
    void push(int x) {
        // Move all elements from q1 to q2
        while (!q1.isEmpty()) {
            q2.add(q1.poll());
        }
        // Add new element to q1
        q1.add(x);
        // Move all elements back from q2 to q1
        while (!q2.isEmpty()) {
            q1.add(q2.poll());
        }
    }

    // Pop element from stack
    int pop() {
        // Return -1 if q1 is empty, else remove and return front element
        return q1.isEmpty() ? -1 : q1.poll();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int q = sc.nextInt(); // Number of queries
        StackUsingQueues stack = new StackUsingQueues();
        ArrayList<Integer> ans = new ArrayList<>();

        // Process queries
        for (int i = 0; i < q; i++) {
            int queryType = sc.nextInt();
            if (queryType == 1) {
                int x = sc.nextInt();
                stack.push(x);
            } else if (queryType == 2) {
                ans.add(stack.pop());
            }
        }

        // Print pop results
        for (int x : ans) {
            System.out.print(x + " ");
        }
        System.out.println();

        sc.close();
    }
}
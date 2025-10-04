import java.util.*;

class QueueUsingStacks {
    Stack<Integer> stackIn = new Stack<>();
    Stack<Integer> stackOut = new Stack<>();

    // Push element x to the back of queue
    public void push(int x) {
        stackIn.push(x);
    }

    // Remove and return the element at the front of queue
    public int pop() {
        // If both stacks are empty, return -1
        if (empty()) {
            return -1;
        }
        // If stackOut is empty, transfer elements from stackIn
        if (stackOut.isEmpty()) {
            while (!stackIn.isEmpty()) {
                stackOut.push(stackIn.pop());
            }
        }
        // Return top element from stackOut
        return stackOut.pop();
    }

    // Return the element at the front of queue without removing it
    public int peek() {
        // If both stacks are empty, return -1
        if (empty()) {
            return -1;
        }
        // If stackOut is empty, transfer elements from stackIn
        if (stackOut.isEmpty()) {
            while (!stackIn.isEmpty()) {
                stackOut.push(stackIn.pop());
            }
        }
        // Return top element from stackOut
        return stackOut.peek();
    }

    // Return whether the queue is empty
    public boolean empty() {
        return stackIn.isEmpty() && stackOut.isEmpty();
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        QueueUsingStacks queue = new QueueUsingStacks();
        List<String> results = new ArrayList<>();

        // Read number of operations
        int q = sc.nextInt();

        // Process each operation
        for (int i = 0; i < q; i++) {
            String operation = sc.next();
            if (operation.equals("push")) {
                int x = sc.nextInt();
                queue.push(x);
            } else if (operation.equals("pop")) {
                int result = queue.pop();
                results.add("pop() -> " + result);
            } else if (operation.equals("peek")) {
                int result = queue.peek();
                results.add("peek() -> " + result);
            } else if (operation.equals("empty")) {
                boolean result = queue.empty();
                results.add("empty() -> " + result);
            }
        }

        // Print results
        for (String result : results) {
            System.out.println(result);
        }

        sc.close();
    }
}
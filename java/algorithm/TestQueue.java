import java.util.LinkedList;
import java.util.Queue;

public class TestQueue {

    public static void main(String[] args) {
        /*
         * Queue = FIFO data structure. First-In First-Out (ex. A line of people)
         * A collection designed for holding elements prior to processing
         * Linear data structure
         * add = enqueue, offer()
         * remove = dequeue, poll()
         * 
         * Where are queues useful?
         * 1. Keyboard Buffer (letters should appear on the screen in the order they're
         * pressed)
         * 2. Printer Queue (Print jobs should be completed in order)
         * 3. Used in LinkedLists, ProiorityQueues, Breadth-first search
         */

        Queue<String> queue = new LinkedList<String>();
        System.out.println("queue.isEmpty() : " + queue.isEmpty());

        queue.offer("Karen");
        queue.offer("Chad");
        queue.offer("Steve");
        queue.offer("Harold");

        System.out.println("queue.size() : " + queue.size());
        System.out.println("queue : " + queue);
        System.out.println("queue.peek() : " + queue.peek());
        System.out.println("queue.contains(\"Harold\") : " + queue.contains("Harold"));

        queue.poll();
        queue.poll();
        System.out.println("queue : " + queue);

    }
}

import java.util.LinkedList;

public class TestLinkedList {
    public static void main(String[] args) {
        /*
         * LinkedList = stores Nodes in 2 parts (data + address)
         * Nodes are in non-consecutive memory locations
         * Elements are linked using pointers
         * Singly Linked List & Doubly Linked List
         * 
         * advantages?
         * 1. Dynamic Data Structure (allocates needed memory while running)
         * 2. Insertion and Deletion of Nodes is easy. O(1)
         * 3. No/Low memory waste
         * 
         * disadvantages?
         * 1. Greater memory usage (additional pointer)
         * 2. No random access of elements (no index [i])
         * 3. Accessing/searching elements is more time consuming. O(n)
         * 
         * uses?
         * 1. implement Stacks/Queues
         * 2. GPS navigation
         * 3. music playlist
         */

        LinkedList<String> linkedList = new LinkedList<String>();

        linkedList.push("A");
        linkedList.push("B");
        linkedList.push("C");
        linkedList.push("D");
        linkedList.push("F");
        linkedList.pop();
        System.out.println("linkedList : " + linkedList);

        while (!linkedList.isEmpty()) {
            linkedList.pop();
        }

        linkedList.offer("A");
        linkedList.offer("B");
        linkedList.offer("C");
        linkedList.offer("D");
        linkedList.offer("F");
        linkedList.poll();
        System.out.println("linkedList : " + linkedList);

        linkedList.add(4, "E");
        linkedList.remove("F");
        System.out.println("linkedList : " + linkedList);

        System.out.println("linkedList.indexOf(\"E\") : " + linkedList.indexOf("E"));
        System.out.println("linkedList.peekFirst() : " + linkedList.peekFirst());
        System.out.println("linkedList.peekLast() : " + linkedList.peekLast());

        linkedList.addFirst("0");
        linkedList.addLast("1");
        System.out.println("linkedList : " + linkedList);

    }
}

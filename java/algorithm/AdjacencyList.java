import java.util.ArrayList;
import java.util.LinkedList;

public class AdjacencyList {
    public static void main(String args[]) {
        /**
         * Adjacency List = An array / arraylist of linkedlists.
         * Each LinkedList has a unique node at the head.
         * All adjacent neighbors to that node are added to that node's linkedlist
         * 
         * runtime complexity to check an Edge : O(v)
         * space complexity : O(v + e)
         */
        Graph1 Graph1 = new Graph1();

        Graph1.addNode1(new Node1('A'));
        Graph1.addNode1(new Node1('B'));
        Graph1.addNode1(new Node1('C'));
        Graph1.addNode1(new Node1('D'));
        Graph1.addNode1(new Node1('E'));

        Graph1.addEdge(0, 1);
        Graph1.addEdge(1, 2);
        Graph1.addEdge(1, 4);
        Graph1.addEdge(2, 3);
        Graph1.addEdge(2, 4);
        Graph1.addEdge(4, 0);
        Graph1.addEdge(4, 2);

        Graph1.print();
    }
}

class Graph1 {
    ArrayList<LinkedList<Node1>> alist;

    Graph1() {
        alist = new ArrayList<>();
    }

    public void addNode1(Node1 node) {
        LinkedList<Node1> currentList = new LinkedList<>();
        currentList.add(node);
        alist.add(currentList);
    }

    public void addEdge(int src, int dst) {
        LinkedList<Node1> currentList = alist.get(src);
        Node1 dstNode1 = alist.get(dst).get(0);
        currentList.add(dstNode1);
    }

    public boolean checkEdge(int src, int dst) {
        LinkedList<Node1> currentList = alist.get(src);
        Node1 dstNode1 = alist.get(dst).get(0);

        for (Node1 node : currentList) {
            if (node == dstNode1) {
                return true;
            }
        }
        return false;
    }

    public void print() {
        for (LinkedList<Node1> currentList : alist) {
            for (Node1 node : currentList) {
                System.out.print(node.data + " -> ");
            }
            System.out.println();
        }
    }
}

class Node1 {
    char data;

    Node1(char data) {
        this.data = data;
    }
}
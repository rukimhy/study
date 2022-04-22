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
        Graph Graph = new Graph();

        Graph.addNode(new Node('A'));
        Graph.addNode(new Node('B'));
        Graph.addNode(new Node('C'));
        Graph.addNode(new Node('D'));
        Graph.addNode(new Node('E'));

        Graph.addEdge(0, 1);
        Graph.addEdge(1, 2);
        Graph.addEdge(1, 4);
        Graph.addEdge(2, 3);
        Graph.addEdge(2, 4);
        Graph.addEdge(4, 0);
        Graph.addEdge(4, 2);

        Graph.print();
    }

    static class Graph {
        ArrayList<LinkedList<Node>> alist;

        Graph() {
            alist = new ArrayList<>();
        }

        public void addNode(Node node) {
            LinkedList<Node> currentList = new LinkedList<>();
            currentList.add(node);
            alist.add(currentList);
        }

        public void addEdge(int src, int dst) {
            LinkedList<Node> currentList = alist.get(src);
            Node dstNode = alist.get(dst).get(0);
            currentList.add(dstNode);
        }

        public boolean checkEdge(int src, int dst) {
            LinkedList<Node> currentList = alist.get(src);
            Node dstNode = alist.get(dst).get(0);

            for (Node node : currentList) {
                if (node == dstNode) {
                    return true;
                }
            }
            return false;
        }

        public void print() {
            for (LinkedList<Node> currentList : alist) {
                for (Node node : currentList) {
                    System.out.print(node.data + " -> ");
                }
                System.out.println();
            }
        }
    }

    static class Node {
        char data;

        Node(char data) {
            this.data = data;
        }
    }
}

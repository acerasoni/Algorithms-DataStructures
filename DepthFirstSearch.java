/**
 * @author Andrea Cerasoni
 * My Personal Implementation of Depth First Search
 * Developed to improve my understanding of the algorithm
 * */

import java.util.*;

class DepthFirstSearch {
  static class Node {
    int id;
    List<Node> adj;

    public Node(int id) {
      this.id = id;
    }
  }

  public static boolean DFS(Node root, Node target) {
    Set<Node> visited = new HashSet<>();

    return DFSsearch(root, target, visited);
  }

  public static boolean DFSsearch(Node root, Node target, Set<Node> visited) {
    System.out.println(root.id); // PRINT ORDER OF EXECUTION
    if(root == target) return true;
    visited.add(root);

    for(Node n : root.adj)  {
      if(visited.contains(n)) continue;
      if(DFSsearch(n, target, visited)) return true;
    }

    return false;
  }
  
  public static void main(String[] args) {
    Node one = new Node(1);
    Node two = new Node(2);
    Node three = new Node(3);
    Node nine = new Node(9);
    Node ten = new Node(10);
    Node four = new Node(4);

    one.adj = new LinkedList();
    one.adj.add(two);
    one.adj.add(three);

    two.adj = new LinkedList();
    two.adj.add(one);
    two.adj.add(nine);
    two.adj.add(ten);
    two.adj.add(three);

    nine.adj = new LinkedList();
    nine.adj.add(two);

    ten.adj = new LinkedList();
    ten.adj.add(two);

    three.adj = new LinkedList();
    three.adj.add(two);
    three.adj.add(one);
    three.adj.add(four);

    four.adj = new LinkedList();
    four.adj.add(three);

    System.out.println(DFS(one, four));  
  }
}

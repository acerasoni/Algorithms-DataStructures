// My implementation of Breadth First Search

import java.util.*;

class BreadthFirstSearch {
  static class Node {
    int id;
    List<Node> adj;

    public Node(int id) {
      this.id = id;
    }
  }

  public static boolean BFS(Node root, Node target) {
    LinkedList<Node> queue = new LinkedList<>();
    Set<Node> visited = new HashSet<>();
    queue.add(root);
    return BFSsearch(target, queue, visited);
  }

  public static boolean BFSsearch(Node target, LinkedList<Node> queue, Set<Node> visited) {
    while(!queue.isEmpty()){
    Node current = queue.remove();
    if(current == target) return true;
    visited.add(current);
       for(Node n : current.adj) {
         if(visited.contains(n)) continue;
           queue.add(n);
       }
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

    System.out.println(BFS(one, new Node(55)));  
   }
}

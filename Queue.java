class Queue {
  static class Node{ 
    Node next;
    int data;

    Node(int data) {
      this.data = data;
    }
  }

  Node head;

  public Queue(Node head) {
    this.head = head;
  }

  public Queue() {}

  public Node add(Node add) {
    if(this.size() == 0) {
      head = add;
      return head;
    }

    Node curr = head;
    while(curr.next != null) curr = curr.next;

    curr.next = add;
    return head;
  }

  public Node remove() {
    Node tmp = head;
    head = head.next;
    return tmp;
  }

  public int size() {
      int s = 0;
      Node curr = head;
      while(curr != null) {
        curr = curr.next;
        s++;
      }

      return s;
  }

  public void printContents() {
    Node curr = head;
    while(curr != null) {
      System.out.println(curr.data);
      curr = curr.next;
    }
  }

  public static void main(String[] args) {
    Node one = new Node(1);
    Node two = new Node(2);
    Node three = new Node(3);
    Node nine = new Node(9);
    Node ten = new Node(10);
    Node four = new Node(4);

    Queue queue = new Queue();

    queue.add(one);
    queue.add(two);
    queue.add(three);

    queue.printContents();
    queue.remove();
    
    System.out.println("Size: " + queue.size());
    
    queue.printContents();
    queue.remove();
    queue.remove();

    System.out.println("Size: " + queue.size());
    queue.printContents();
  }
}

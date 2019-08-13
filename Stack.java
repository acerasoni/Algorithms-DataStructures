class Stack<T> {
  static class Node<T> {
    T data;
    Node next;
  }

  public Stack(T data) {
    Node n = new Node();
    n.data = data;
    head = n;
  }

  public Stack() {}

  Node head;
  int size;

  public Node pop() {
    Node tmp = head;
    head = head.next;

    return tmp;
  }

  public Node peek() {
    return head;
  }

  public Node push(T data) {
    Node n = new Node();
    n.data = data;
    n.next = head;
    head = n;
    size++;
    return head;
  }

  public int size() {
    return size;
  }

  public boolean isEmpty() {
    return size == 0;
  }

  public void printContents() {
    Node curr = head;
    while(curr != null) {
      System.out.println(curr.data);
      curr = curr.next;
    }
  }
  
  public static void main(String[] args) {
     Stack<Integer> stack = new Stack<>();

     stack.push(5);
     stack.push(10);
     stack.push(99);
     System.out.println("Contents: ");
     stack.printContents();
     System.out.println("Size: ");
     System.out.println(stack.size());

     Stack<Character> chars = new Stack<>();

     chars.push('c');
     chars.push('d');
     chars.push('e');

     System.out.println("Peek: ");
     System.out.println(chars.peek().data);

     System.out.println("Contents: ");
     chars.printContents();

     System.out.println("Pop: ");
     System.out.println(chars.pop().data);
     System.out.println("Contents: ");
     chars.printContents();
  }
}

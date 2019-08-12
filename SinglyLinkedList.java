/**
 * @author Andrea Cerasoni
 * My Personal Implementation of a Singly Linked List
 * Developed to improve my understanding of the data structure
 * */

import java.util.*;

class SinglyLinkedList {
  static class Node {
    Node next;
    int d
    public Node(int data) {
      this.data = data;
    }
  }

  Node head;

  public SinglyLinkedList(int data) {
    head = new Node(data);
  }

  public SinglyLinkedList(Node head) {
    this.head = head;
  }

  public Node addFirst(Node add) {
    add.next = head;
    head = add;
    return head;
  }

  public Node addLast(Node add) {
    Node last = head;
    while(last.next != null) last = last.next;
  
    last.next = add;
    return head;
  }

  public Node remove() {
    Node tmp = head;
    head = head.next;
    return tmp;
  }

  public Node removeLast() {
    Node last = head;
    while(last.next.next != null) last = last.next;

    Node tmp = last.next;
    last.next = null;
    return tmp;
  }

  public Node add(Node add, int idx) {
    if(idx > this.size() - 1) {
      this.addLast(add);
      return head;
    } else if (idx == 0) {
      this.addFirst(add);
      return head;
    }

    Node curr = this.get(idx - 1);
    Node tmp = curr.next;

    curr.next = add;
    add.next = tmp;
    return head;
  }

  public Node remove(int idx) {
    if(idx > this.size() - 1) return null;

    Node curr = head;
    for(int x = 0; x < idx - 1; x++) curr = curr.next;

    if(idx == this.size()-1) curr.next = null;
    else {
      if(curr.next.next == null) curr.next = null;
      else curr.next = curr.next.next;
    }
    return head;
  }

  public Node get(int idx) {
    if(idx > this.size() - 1) return null;

    Node curr = head;
    for(int x = 0 ; x < idx; x++) curr = curr.next;

    return curr;
  }

  public Node getLast() {
    Node curr = head;
    while(curr.next != null) curr = curr.next;

    return curr;
  }

  public boolean isEmpty() { return head == null; }

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

    SinglyLinkedList m = new SinglyLinkedList(5);
    
    m.addLast(three);
    m.addLast(ten);

    m.addFirst(four);
    m.addFirst(two);

    m.add(nine, 5);
    m.removeLast();
    m.printContents(); 
   }
}

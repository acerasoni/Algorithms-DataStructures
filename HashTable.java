/**
 * @author Andrea Cerasoni
 * My Personal Implementation of a Hash Table
 * Developed to improve my understanding of the data structure
 * It allows key-value pairs in the form of String-Integer where the Integer is >= 0
 * Utilises chaining to address collisions
 * */

class HashTable{ 
  static class Node{
    String key;
    int value;
    Node next;
    public Node(String key, int value) {
      this.key = key;
      this.value = value;
    }
  }

   Node[] arr = new Node[1000];

  public int hashF(String key) {
    int result = 0;
    for(int x = 0; x < key.length(); x++) {
      result += key.charAt(x);
    }

    return result % 1000;
  }

  public void put(String key, int value){
    int idx = hashF(key);
    Node curr = new Node(key, value);

    if(arr[idx] == null) arr[idx] = curr;
    Node it = arr[idx];

    while(it != null) {
      if(it.key == key) {
        it.value = value; 
        return;
      }
      it = it.next;
    }

    curr.next = arr[idx];
    arr[idx] = curr;
  }
  
  // Returns the value associated with the key or -1 if the key was not found
  public int get(String key) {
    int idx = hashF(key);
    if(arr[idx] == null) return -1;
    Node it = arr[idx];

    while(it != null) {
      if(it.key == key) return it.value;
      it = it.next;
    }

    return -1;
  }

  public boolean remove(String key) {
    int idx = hashF(key);

    if(arr[idx] == null) return false;
    Node it = arr[idx];

    if(it.key == key) {
      arr[idx] = it.next;
      return true;
    }

    while(it.next != null) {
      if(it.next.key == key) {
        it.next = it.next.next;
        return true;
      }
        it = it.next;
    }
      return false;
    }

    public void printContents() {
      for(int x = 0; x < 1000; x++) {
        Node it =  arr[x];
        System.out.println("Index: "+ x);
        while(it != null) {
           System.out.println(it.key + " " + it.value);
           it = it.next;
        }
        System.out.println();
      }
    }

    public static void main(String[] args) {
      HashTable ht = new HashTable();
      ht.put("ab",4);
      ht.put("ba",15);
      ht.put("a1231",6);
      ht.put("fsdrqw1",2);
      ht.put("fa21wbr",99);
      ht.put("bbwwegqa",12);

     ht.printContents();
    }
  }





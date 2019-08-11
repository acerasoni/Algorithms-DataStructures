/* Simple implementation for an ArrayList of positive integers
*  ArrayList can only increase in size (in that deletion will not shrink its size) 
*  An empty slot is represented by -1
*  Insertion is O(n) amortized to O(1)
*/

import java.util.*;
 class ArrayList{
  int[] arr;
  int size = 0;

  public ArrayList(int capacity) {
    arr = new int[capacity];
  }
  
  public ArrayList() 
    arr = new int[1];
  }

  public void add(int value) {
    if(size < arr.length) {
       arr[size] = value;
       size++;
      } else {
         int[] newArr = new int[arr.length*2];
         for(int x = 0; x < arr.length; x++){
              newArr[x] = arr[x];
           }        
           
         for(int y = arr.length; y < newArr.length; y++ ){
              newArr[y] = -1;
           }
           
           newArr[size] = value;
           size++; 
           arr = newArr;
          }
      }

      public int get(int idx){
        return arr[idx];
      }
      public void remove(int idx) {
        arr[idx] = -1;
      }

      public void printContents() {
        for(Integer i : arr) {
          System.out.println(i);
        }
      }
      
      public static void main(String[] args) {
          ArrayList arr = new ArrayList();

         for(int x = 0; x < 10; x++) {
           arr.add(x);
         }

          arr.remove(4);
          arr.printContents();
          
    }
}

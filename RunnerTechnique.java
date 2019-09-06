/**
/ The runner technique is a generic Linked List approach in which two pointers are stored, one faster and one slower.
/ I have applied it to the following problem: 
/ "You have a Linked List a1 ->a2 -> ••• ->an ->b1 ->b2 -> ••• ->bn 
/ and you wanted to rearrange it into a1 ->b1 ->a2 ->b2 -> ••• ->an ->bn. 
/ You do not know the length of the linked list (but you do know that the length is an even number)"
/ My solution follows. It is a divide and conquer algorithm implemented recursively.
/ The problem was taken from the Linked List section of Cracking The Coding Interview 6th Edition by Gayle Laakmann McDowell 
*/

import java.util.HashMap;
import java.util.Map;

public class Solution {

       static class ListNode {
        int idx;
        ListNode next;

        public ListNode(int i) {
            idx = i;
        }

        public ListNode add(ListNode curr) {
            this.next = curr;
            return this;
        } 
    }

    public static void main(String...args) {

                ListNode head = new ListNode(1).add(new ListNode(2).add(new ListNode(3).add(new ListNode(4).add(new ListNode(5).add(new ListNode(6))))));
                head = removeDuplicate(head);
                
                while(head != null) {
                    System.out.println(head.idx);
                    head = head.next;
                }
        
    }

    public static ListNode removeDuplicate(ListNode head) {
        if(head == null) return null;

        ListNode fast = head.next, slow = head;

        while(fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        ListNode second = slow.next;
        slow.next = null;
        ListNode first = head;

        merge(first, second);
        return head;
    }

    private static void merge(ListNode first, ListNode second) {
        ListNode tmp = second.next;
        second.next = null;
        first = append(first, second);
        second = tmp;

        if(first == null) return;
        else merge(first, second);
    }

    private static ListNode append(ListNode a, ListNode b) {
        ListNode tmp = a.next;
        a.next = b;
        b.next = tmp;

        return tmp;
    }
}

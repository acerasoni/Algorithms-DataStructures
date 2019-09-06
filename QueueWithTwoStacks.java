/** 
/ Queue implemented via two stacks.
/ This question was taken from Cracking The Coding Interview 6th Edition by Gayle Laakmann McDowell
*/

import java.util.Stack;

public class Queue<T> {
    Stack<T> one = new Stack<>();
    Stack<T> two = new Stack<>();

    public void add(T t) {
        one.push(t);
    }

    public T peek() {
        return one.peek();
    }

    public boolean isEmpty() {
        return one.isEmpty() ? true : false;
    }

    public T remove() {
        T tmp;
        int m = one.size();

        for (int x = 0; x < m - 1; x++)
            two.push(one.pop());
        tmp = one.pop();

        while (!two.isEmpty())
            one.push(two.pop());

        return tmp;
    }

    public void printContents() {
        int m = one.size(), n = two.size();

        while (!one.isEmpty()) {
            System.out.println(one.peek().toString());
            two.push(one.pop());
        }

        while (!two.isEmpty())
            one.push(two.pop());
    }

    public static void main(String... args) {

        Queue<Integer> q = new Queue<>();

        q.add(5);
        q.add(6);
        q.add(1);
        q.add(4);

        q.printContents();
        System.out.println("Removing last 2 elements");
         q.remove();
         q.remove();

        System.out.println(q.isEmpty());
        q.printContents();
    }

}

import java.util.* ;
import java.io.*; 
import java.util.Queue;

public class Solution {
    public static void reverse(Queue<Integer> queue, int k){
        // Write your code here.
        Stack<Integer> st = new Stack<>();
        int m = k;
        int n = queue.size() - k;
        while(m > 0){
            st.push(queue.poll());
            m--;
        }

        while(!st.isEmpty()){
            queue.offer(st.pop());
        }
        while(n > 0){
            queue.offer(queue.poll());
            n--;
        }
    }
}

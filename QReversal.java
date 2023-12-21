import java.util.* ;
import java.io.*; 
import java.util.Queue;

public class Solution {
    public static void solve(Queue < Integer > q){
        if(q.isEmpty())
            return;
        
        int ele = q.poll();
        solve(q);
        q.offer(ele);
    }
    public static void reverse(Queue < Integer > q) {
        // Write your code here.
        solve(q);
        

    }
}

import java.util.*;
import java.io.*;

public class Solution {
    public static ArrayList<Integer> firstNegativeInteger(ArrayList<Integer> arr, int k, int n) {
        // Write your code here.
        ArrayList<Integer> ans = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < k; i++) {
            if (arr.get(i) < 0)
                q.offer(i);

        }
        int start = 0, end = k - 1;

        while (end < n) {
            if (!q.isEmpty()) {
                int index = q.peek();
                ans.add(arr.get(index));
                if (start == index)
                    q.poll();
            }
            else
                ans.add(0);

            start++;
            end++;
            if (end < n && arr.get(end) < 0)
                q.offer(end);
        }

        return ans;
    }
}

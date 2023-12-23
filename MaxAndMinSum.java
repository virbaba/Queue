import java.util.*;
import java.io.*;
import java.util.ArrayList;

public class Solution {
    public static long sumOfMaxAndMin(ArrayList<Integer> nums, int n, int k) {
        // Write your code here.
        if (nums == null || n <= 0 || k <= 0 || k > n) {
            return -1; // Invalid input
        }

        ArrayDeque<Integer> maxQueue = new ArrayDeque<>();
        ArrayDeque<Integer> minQueue = new ArrayDeque<>();
        long sum = 0;

        for (int i = 0; i < n; i++) {
            // Remove elements outside the current window
            while (!maxQueue.isEmpty() && maxQueue.peek() < i - k + 1) {
                maxQueue.poll();
            }
            while (!minQueue.isEmpty() && minQueue.peek() < i - k + 1) {
                minQueue.poll();
            }

            // Remove elements smaller than the current element in the maxQueue
            while (!maxQueue.isEmpty() && nums.get(maxQueue.peekLast()) <= nums.get(i)) {
                maxQueue.pollLast();
            }
            maxQueue.offer(i);

            // Remove elements larger than the current element in the minQueue
            while (!minQueue.isEmpty() && nums.get(minQueue.peekLast()) >= nums.get(i)) {
                minQueue.pollLast();
            }
            minQueue.offer(i);

            // Calculate sum of max and min elements within the window
            if (i >= k - 1) {
                sum += nums.get(maxQueue.peek()) + nums.get(minQueue.peek());
            }
        }
        return sum;
    }
}

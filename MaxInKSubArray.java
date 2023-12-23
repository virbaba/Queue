import java.util.* ;
import java.io.*; 
public class Solution 
{

    public static ArrayList<Integer> maxOfSubarray(ArrayList<Integer> nums, int n, int k) 
	{
        // Write your code here.
         if (nums == null || n <= 0 || k <= 0 || k > n) {
            return null; // Invalid input
        }

        ArrayList<Integer> ans = new ArrayList<>();
        if(ans.size() == 1){
            return nums;
        }

        // this dequeue store element in decresing order
        ArrayDeque<Integer> maxQueue = new ArrayDeque<>();
        for(int i = 0; i < n; i++){
            // remove element if element comes outside the window
            while(!maxQueue.isEmpty() && maxQueue.peek() < i-k+1){
                maxQueue.removeFirst();
            }

            // remove element from queue if current element is greater 
            // than to queue element
            while(!maxQueue.isEmpty() && nums.get(maxQueue.peekLast()) < nums.get(i)){
                maxQueue.removeLast();
            }
            maxQueue.offer(i);

            if(i >= k-1){
                ans.add(nums.get(maxQueue.peekFirst()));
            }

        }

        return ans;
    }

}

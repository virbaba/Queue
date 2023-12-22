import java.util.* ;
import java.io.*;

public class Solution {
	public static ArrayList<Character> firstNonRepeating(String stream) {
		// Write your code here
		HashMap<Character, Integer> map = new HashMap<>();
		Queue<Character> q = new LinkedList<>();

		ArrayList<Character> ans = new ArrayList<>();

		for(int i = 0; i < stream.length(); i++){
			char c = stream.charAt(i);
			if(!map.containsKey(c)){
				map.put(c, 1);
				q.offer(c);
			}
			else{
				map.put(c, map.get(c)+1);
			}

			while(!q.isEmpty() && map.get(q.peek()) > 1)
					q.poll();

			if(!q.isEmpty())
				ans.add(q.peek());
				
		}

		return ans;
	}
}

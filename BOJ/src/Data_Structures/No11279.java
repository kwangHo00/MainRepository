//No11279_최대힙_정답
package Data_Structures;

import java.io.*;
import java.util.*;

public class No11279 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>(Collections.reverseOrder());
		
		int n = Integer.parseInt(br.readLine());
		for(int i = 0; i < n; i++) {
			int a = Integer.parseInt(br.readLine());
			
			if(a > 0) pq.add(a);
			else if(!pq.isEmpty() && a == 0) System.out.println(pq.poll());
			else if(pq.isEmpty() && a == 0) System.out.println("0");
		}
	}
}
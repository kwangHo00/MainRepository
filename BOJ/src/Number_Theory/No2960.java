//No2960_에라토스테네스의 체_정답
package Number_Theory;

import java.io.*;
import java.util.*;

public class No2960 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		int[] num = new int[n + 1];
		ArrayList<Integer> list = new ArrayList<Integer>();
		
		for(int i = 2; i <= n; i++) num[i] = i;
		
		for(int i = 2; i <= n; i++) {
			for(int j = i; j <= n; j += i) {
				if(num[j] == -1) continue;
				list.add(j);
				num[j] = -1;
			}
		}
		
		System.out.println(list.get(k - 1));
	}
}
//No3036_링_정답
package Number_Theory;

import java.io.*;
import java.util.*;

public class No3036 {
	static int gcd(int a, int b) {
		int tmp, n;
		if(a < b) {
			tmp = a;
			a = b;
			b = tmp;
		}
		
		while(b != 0) {
			n = a % b;
			a = b;
			b = n;
		}
		return a;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int n = Integer.parseInt(br.readLine());
		int[] radius = new int[n];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < n; i++) {
			radius[i] = Integer.parseInt(st.nextToken());
		}
		
		for(int i = 1; i < n; i++) {
			int gcd = gcd(radius[0], radius[i]);
			System.out.println(radius[0] / gcd + "/" + radius[i] / gcd);
		}
	}
}
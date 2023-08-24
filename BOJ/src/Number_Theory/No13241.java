//No13241_최소공배수_정답 
package Number_Theory;

import java.io.*;
import java.util.*;

public class No13241 {
	static long gcd(long a, long b) {
		long tmp, n;
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
		StringTokenizer st = new StringTokenizer(br.readLine());

		long a = Integer.parseInt(st.nextToken());
		long b = Integer.parseInt(st.nextToken());
		long gcd = gcd(a, b);
		
		System.out.println(gcd * (a / gcd) * (b / gcd));
	}
}
//No1188_음식 평론가_정답
package Number_Theory;

import java.io.*;
import java.util.*;

public class No1188 {
	static int gcd(int a, int b) {
		int r;
		while(b != 0) {
			r = a % b;
			a = b;
			b = r;
		}
		return a;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		System.out.println(b - gcd(Math.max(a, b), Math.min(a, b)));
	}
}
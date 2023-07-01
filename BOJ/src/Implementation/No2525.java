//No2525_오븐시계_정답
package Implementation;

import java.io.*;
import java.util.*;
public class No2525 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(br.readLine());
		int total = a * 60 + b + c;
		
		if(total / 60 >= 24) System.out.println(total / 60 - 24 + " " + total % 60);
		else System.out.println(total / 60 + " " + total % 60);
	}
}
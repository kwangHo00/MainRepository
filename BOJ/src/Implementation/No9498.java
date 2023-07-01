//No9498_시험성적_정답
package Implementation;

import java.io.*;

public class No9498 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		if(n >= 90 && n <= 100) System.out.println("A");
		else if(n >= 80 && n <= 89) System.out.println("B");
		else if(n >= 70 && n <= 79) System.out.println("C");
		else if(n >= 60 && n <= 69) System.out.println("D");
		else System.out.println("F");
	}
}
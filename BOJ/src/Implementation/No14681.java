//No14681_사분면고르기_정답
package Implementation;

import java.io.*;

public class No14681 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int a = Integer.parseInt(br.readLine());
		int b = Integer.parseInt(br.readLine());
		
		if(a > 0 && b > 0) System.out.println("1");
		else if(a > 0 && b < 0) System.out.println("4");
		else if(a < 0 && b > 0) System.out.println("2");
		else System.out.println("3");
	}
}
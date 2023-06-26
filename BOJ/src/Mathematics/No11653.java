//No11653_소인수분해_정답
package Mathematics;

import java.io.*;
public class No11653 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int s = 2;
		while(n > 1) {
			if(n % s == 0) {
				n /= s;
				System.out.println(s);
			}else s += 1;
		}
	}
}
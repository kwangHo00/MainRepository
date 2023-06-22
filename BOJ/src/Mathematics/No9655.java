//No9655_돌게임_두번째만에 정답_백준에 제출할때 패키지명 없이 제출해야 됨
package Mathematics;

import java.io.*;
public class No9655 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		System.out.println(n % 2 == 0 ? "CY" : "SK");
	}
}
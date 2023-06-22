package Mathematics;
//No2577_숫자의개수_정답
import java.io.*;
public class No2577 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int total = 1;
		int numArr[] = new int[10];
		for(int i = 0; i < 3; i++) {
			int num = Integer.parseInt(br.readLine());
			total *= num;
		}
		
		String numStr = String.valueOf(total);
		for(int i = 0; i < numStr.length(); i++) {
			numArr[numStr.charAt(i) - 48] += 1;
			
		}
		for(int i : numArr) System.out.println(i);
	}
}
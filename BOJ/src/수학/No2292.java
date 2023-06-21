package 수학;
//No2292_벌집_두번만에 정답_조건문을 잘못작성했음
import java.io.*;
public class No2292 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		int i = 0, range = 1;
		while(true) {
			range += i * 6;
			if(range >= n ) break;
			i++;
		}
		System.out.println(i + 1);
	}
}
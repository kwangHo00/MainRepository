package 수학;
//No25304_영수증_두번째만에 정답_yes,no 대소문자 잘못써서 틀림
import java.io.*;
import java.util.*;
public class No25304 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int x = Integer.parseInt(br.readLine());
		int n = Integer.parseInt(br.readLine());
		for(int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			x -= a * b;
		}
		if(x == 0) System.out.println("Yes");
		else System.out.println("No");
	}
}
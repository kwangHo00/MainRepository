package 정렬;
//No10989_수정렬하기3_정답
import java.util.*;
import java.io.*;
public class No10989 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());
		int[] num = new int[n];
		
		for(int i = 0; i < n; i++) {
			num[i] = Integer.parseInt(br.readLine());
		}
		
		Arrays.sort(num);
		for(int i : num) {
			bw.write(String.valueOf(i));
			bw.write("\n");
		}
		bw.flush();
		bw.close();
	}
}
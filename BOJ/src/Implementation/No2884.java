//No2884_알람시계_정답
package Implementation;

import java.io.*;
import java.util.*;

public class No2884 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int h = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		if (h != 0)
			System.out.println(((h * 60 + m) - 45) / 60 + " " + ((h * 60 + m) - 45) % 60);
		else if (m < 45)
			System.out.println("23" + " " + (60 + (m - 45)));
		else if (h == 0)
			System.out.println(h + " " + (m - 45));
	}
}
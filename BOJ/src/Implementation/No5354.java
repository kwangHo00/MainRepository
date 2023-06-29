//No5354_J박스_정답
package Implementation;

import java.util.*;
public class No5354 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
        
        int t = scanner.nextInt();
        
        for (int i = 0; i < t; i++) {
            int n = scanner.nextInt();
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    if (j == 0 || j == n - 1 || k == 0 || k == n - 1) {
                        System.out.print("#");
                    } else {
                        System.out.print("J");
                    }
                }
                System.out.println();
            }
            System.out.println();
        }
	}
}
package 자료구조;
//No10845_큐_정답
import java.util.*;
import java.io.*;
public class No10845 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		Queue<Integer> queue = new LinkedList<Integer>();

		int n = Integer.parseInt(br.readLine());
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			String order = st.nextToken();
			
			switch(order) {
			case "push" : {
				int num = Integer.parseInt(st.nextToken());
				queue.add(num);
				break;
			}
			case "pop" : {
				if(queue.size() == 0) System.out.println("-1");
				else System.out.println(queue.poll());
				break;
			}
			case "size" : {
				System.out.println(queue.size());
				break;
			}
			case "empty" : {
				if(queue.isEmpty()) System.out.println("1");
				else System.out.println("0");
				break;
			}
			case "front" : {
				if(queue.peek() == null) System.out.println("-1");
				else System.out.println(queue.peek());
				break;
			}
			case "back" : {
				if(queue.size() == 0) System.out.println("-1");
				else System.out.println(((LinkedList<Integer>) queue).peekLast());
				break;
			}
			}
		}
	}
}
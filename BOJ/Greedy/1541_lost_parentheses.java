import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class LostParentheses {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer sub = new StringTokenizer(br.readLine(), "-");
		
		// 첫 "-" 연산자의 피연산자 계산
		int sum = 0;
		StringTokenizer add = new StringTokenizer(sub.nextToken(), "+");
		while(add.hasMoreElements()) {
			sum += Integer.parseInt(add.nextToken());
		}
		
		while(sub.hasMoreTokens()) {
			
			// "-" 연산자의 피연산자 계산
			int temp = 0;
			add = new StringTokenizer(sub.nextToken(), "+");
			while(add.hasMoreTokens()) {
				temp += Integer.parseInt(add.nextToken());
			}
			
			// 피연산자들끼리 "-" 연산
			sum -= temp;
		}
		
		System.out.println(sum);
		
		/*
		// stack을 이용한 풀이
		StringTokenizer st = new StringTokenizer(br.readLine(), "+-", true);
		Stack<Integer> stack = new Stack<Integer>();

		while(st.hasMoreTokens()) {
			String token = st.nextToken();
			
			try {
				int n = Integer.parseInt(token);
				stack.add(n);
				
			} catch (NumberFormatException e) {
				
				if(token.equals("+")) {
					int n = stack.pop() + Integer.parseInt(st.nextToken());
					stack.add(n);
				}
			}
		}
		
		int sum = stack.firstElement();
		
		for(int i=1; i<stack.size(); i++) {
			sum -= stack.elementAt(i);
		}
		System.out.println(sum);
		*/
	}
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Fibonacci5 {
	
	private static int[] dp = new int[21];
	
	private static int fibo(int n) {
		if(n == 0)
			return 0;
		if(n == 1)
			return 1;
		return fibo(n-1) + fibo(n-2);
	}
	
	public static void main(String[] args) throws IOException {		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		dp[0] = 0;
		dp[1] = 1;
		
		// 재귀
		System.out.println(fibo(n));
		
		/*
    		// 반복문
		for(int i=2; i<=n; i++) {
			dp[i] = dp[i-1] + dp[i-2];
		}
    		System.out.println(dp[n]);
    		*/
	}

}

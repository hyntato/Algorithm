import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PinaryNumber {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
	
		// n 범위 주의: n은 최대 90, int형 범위 벗어남
		long[] dp = new long[n+1];
		
		dp[0] = 0;
		dp[1] = 1;
		
		// 1. 피보나치
		for(int i=2; i<=n; i++) {
			dp[i] = dp[i-1] + dp[i-2];
		}
		System.out.println(dp[n]);
		
		/*
		// 2. 끝자리  0, 1 경우 나누기
		// 앞의 수의 끝자리가 0인 경우: 0, 1 둘다 올 수 있음
		// 앞의 수의 끝자리가 1인 경우: 0만 올 수 있음 
		long[][] dp2 = new long[n+1][2];
		
		dp2[1][0] = 0;
		dp2[1][1] = 1;
		
		for(int i=2; i<=n; i++) {
			dp2[i][0] = dp2[i-1][0] + dp2[i-1][1];
			dp2[i][1] = dp2[i-1][0];
		}
		
		System.out.println(dp2[n][0] + dp2[n][1]);
		*/
	}

}

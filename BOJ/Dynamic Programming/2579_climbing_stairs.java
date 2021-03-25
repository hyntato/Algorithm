import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ClimbingStairs {
	
	private static int[] stairs;
	private static int[] dp;
	
	private static int bottomUp(int n) {
		for(int i=3; i<=n; i++) {
			dp[i] = Math.max(dp[i-3] + stairs[i-1], dp[i-2]) + stairs[i];
		}
		return dp[n];
	}
	
	// top-down: 시간초과 주의, 중복으로 계산하는것 방지하기!
	private static int topDown(int n) {
		if(dp[n] == 0) {
			dp[n] = Math.max(topDown(n-3) + stairs[n-1], topDown(n-2)) + stairs[n];	
		}
		return dp[n];
	}

	public static void main(String[] args) throws IOException {		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		stairs = new int[n+1];
		dp = new int[n+1];
		
		for(int i=1; i<=n; i++) {
			stairs[i] = Integer.parseInt(br.readLine());
		}
		
		if(n == 1)
			System.out.println(stairs[1]);
		else if(n == 2)
			System.out.println(stairs[1] + stairs[2]);
		else {
			dp[1] = stairs[1];
			dp[2] = stairs[1] + stairs[2];
			//dp[3] = stairs[3] + Math.max(stairs[1], stairs[2]);
			
			System.out.println(bottomUp(n));
			//System.out.println(topDown(n));
		}
		
	}
}

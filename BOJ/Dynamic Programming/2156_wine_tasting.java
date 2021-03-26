import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class WineTasting2 {
	
	private static int[] wines;
	private static int[] dp;
	
	private static int bottomUp(int n) {
		for(int i=3; i<=n; i++) {
			dp[i] = Math.max(dp[i-1], Math.max(dp[i-3] + wines[i-1], dp[i-2]) + wines[i]);
		}
		return dp[n];
	}
	
	private static int topDown(int n) {
		if(dp[n] == 0) {
			dp[n] = Math.max(topDown(n-1), Math.max(topDown(n-3) + wines[n-1], topDown(n-2)) + wines[n]);
		}
		return dp[n];
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		wines = new int[n];
		dp = new int[n];
		
		for(int i=0; i<n; i++) {
			wines[i] = Integer.parseInt(br.readLine());
		}
		
		if(n == 1)
			System.out.println(wines[0]);
		else if(n == 2)
			System.out.println(wines[0] + wines[1]);
		else {
			dp[0] = wines[0];
			dp[1] = wines[0] + wines[1];
			dp[2] = Math.max(dp[1], Math.max(wines[0], wines[1]) + wines[2]);
			
			System.out.println(bottomUp(n-1));
			//System.out.println(topDown(n-1));
		}
	}

}

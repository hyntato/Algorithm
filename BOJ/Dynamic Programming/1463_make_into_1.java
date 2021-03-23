import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class MakeInto2 {
	
	private static int bottomUp(int n) {
		int[] dp = new int[n+1];
		Arrays.fill(dp, 0);
		
		for(int i=2; i<=n; i++) {
			dp[i] = dp[i-1] + 1;
      
			if(i%2 == 0)
				dp[i] = Math.min(dp[i], dp[i/2] + 1);
      
			if(i%3 == 0)
				dp[i] = Math.min(dp[i], dp[i/3] + 1);
		}
    
		return dp[n];
	}
	
	private static int topDown(int n) {
		int[] dp = new int[n+1];
		Arrays.fill(dp, Integer.MAX_VALUE);
		dp[n] = 0;
		
		for(int i=n; i>=1; i--) {
			if(dp[i] == Integer.MAX_VALUE) continue;
			
			dp[i-1] = Math.min(dp[i-1], dp[i] + 1);
			
      if(i%2 == 0)
				dp[i/2] = Math.min(dp[i/2], dp[i] + 1);
			
      if(i%3 == 0)
				dp[i/3] = Math.min(dp[i/3], dp[i] + 1);
		}
    
		return dp[1];
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		System.out.println(bottomUp(n));
		//System.out.println(topDown(n));
	}

}

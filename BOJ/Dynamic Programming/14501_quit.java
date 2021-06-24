import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Quit {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int[] times = new int[N+1];
		int[] prices = new int[N+1];
		int[] dp = new int[N+1];
		
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			times[i] = Integer.parseInt(st.nextToken());
			prices[i] = Integer.parseInt(st.nextToken());
		}
		
		for(int i=N-1; i>=0; i--) {
			if(i+times[i] <= N) {
				dp[i] = Math.max(dp[i+1], dp[i+times[i]]+prices[i]);
			} else {
				dp[i] = dp[i+1];
			}
		}
		
		System.out.println(dp[0]);
	}

}

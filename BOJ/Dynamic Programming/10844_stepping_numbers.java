import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SteppingNumbers {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		// 길이에 따른 끝자리 수(0~9)의 개수
		int[][] dp = new int[101][10];
		
		for(int i=1; i<10; i++) {
			dp[1][i] = 1;
		}
		
		for(int i=2; i<=n; i++) {
			// 끝자리 수가 0인 개수 == 이전 길이에서 끝자리 수가 1인 개수
			dp[i][0] = dp[i-1][1];
           
			// 끝자리 수가 1~8(j)인 개수 == 이전 길이에서 끝자리 수가 j-1, j+1인 개수의 합
			for(int j=1; j<9; j++) {
				dp[i][j] = (dp[i-1][j-1] + dp[i-1][j+1]) % 1000000000;
			}
			// 끝자리 수가 9인 개수 == 이전 길이에서 끝자리 수가 8인 개수
			dp[i][9] = dp[i-1][8];
		}
		
		int sum = 0;
		for(int i=0; i<10; i++) {
			sum = (sum + dp[n][i]) % 1000000000;
		}
		System.out.println(sum);
	}

}

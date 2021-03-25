import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Triangle {

	public static void main(String[] args) throws IOException {		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int n = Integer.parseInt(br.readLine());
		int[][] triangle = new int[n][n];
		
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<=i; j++) {
				triangle[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		// 아래층에서 위층으로 올라가면서 최댓값 계산
		for(int i=n-2; i>=0; i--) {
			for(int j=0; j<=i; j++) {
				triangle[i][j] += Math.max(triangle[i+1][j], triangle[i+1][j+1]);
			}
		}
		System.out.println(triangle[0][0]);
   
    		/*
		// 위층에서 아래층으로 내려가면서 최댓값 계산
    		for(int i=1; i<n; i++) {
			for(int j=0; j<=i; j++) {
				if(j == 0)
					triangle[i][j] += triangle[i-1][0];
				else if(j == i)
					triangle[i][j] += triangle[i-1][i-1];
				else
					triangle[i][j] += Math.max(triangle[i-1][j-1], triangle[i-1][j]);
			}
		}
    
		int max = 0;
		for(int i=0; i<n; i++) {
			max = (max < triangle[n-1][i]) ? triangle[n-1][i] : max;
		}
		System.out.println(max);
    		*/
	}
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Operator {
	private static int max = Integer.MIN_VALUE;
	private static int min = Integer.MAX_VALUE;
	
	private static int N;
	private static int[] nums;
	private static int[] ops;   // +(0), -(1), *(2), /(3)

	private static void dfs(int result, int idx) {
		if(idx == N-1) {
			if(result > max)
				max = result;
			if(result < min)
				min = result;
			return;
		}
    
		for(int i=0; i<4; i++) {
			if(ops[i] > 0) {
				ops[i]--;
				
				switch(i) {
				case 0:
					dfs(result+nums[idx+1], idx+1); break;
				case 1:
					dfs(result-nums[idx+1], idx+1); break;
				case 2:
					dfs(result*nums[idx+1], idx+1); break;
				case 3:
					dfs(result/nums[idx+1], idx+1); break;
				}
				
				ops[i]++;
			}
		}
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		nums = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		
		ops = new int[4];
		st = new StringTokenizer(br.readLine());
		
		for(int i=0; i<4; i++) {
			ops[i] = Integer.parseInt(st.nextToken());
		}
		
		dfs(nums[0], 0);
		
		System.out.println(max);
		System.out.println(min);
	}

}

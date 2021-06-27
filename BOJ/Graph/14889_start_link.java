import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class StartLink {
	private static int min;
	
	private static int N;
	private static int[][] nums;
	private static boolean[] visited;

	private static void combination(int start, int r) {
		if(r == N/2) {
			int diff = calcDiff();
			if(diff < min) {
				min = diff;
			}
			return;
		}
		
		for(int i=start; i<N; i++) {
			if(!visited[i]) {
				visited[i] = true;
				combination(i+1, r+1);
				visited[i] = false;
			}
		}
	}
	
	private static int calcDiff() {
		int starts = 0;
		int links = 0;
		
		for(int i=0; i<N-1; i++) {
			for(int j=i+1; j<N; j++) {
				if(visited[i] && visited[j])
					starts += nums[i][j] + nums[j][i];
				else if(!visited[i] && !visited[j])
					links += nums[i][j] + nums[j][i];
			}
		}
		
		return Math.abs(starts - links);
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		nums = new int[N][N];
		
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				nums[i][j] = Integer.parseInt(st.nextToken());
				min += nums[i][j];
			}
		}
		
		visited = new boolean[N];
		combination(0, 0);
		
		System.out.println(min);
	}

}

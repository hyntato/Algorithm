import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Virus {
	
	private static int n;
	private static int[][] network;
	private static boolean[] visited;
	
	private static int dfs(int start) {
		int count = 1;
		visited[start] = true;
		
		for(int i=1; i<=n; i++) {
			if(!visited[i] && network[start][i]==1) {
				visited[i] = true;
				count += dfs(i);
			}
		}
		return count;
	}
	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		n = Integer.parseInt(br.readLine());
		int e = Integer.parseInt(br.readLine());
		
		network = new int[n+1][n+1];
		visited = new boolean[n+1];

		for (int i=0; i<e; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			network[u][v] = 1;
			network[v][u] = 1;
		}
		
		System.out.println(dfs(1) - 1);
	}

}

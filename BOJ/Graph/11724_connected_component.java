import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ConnectedComponent {
	
	private static int n;
	private static int[][] adjMat;
	private static boolean[] visited;
	
	private static int findConnectedComponent() {
		int count = 0;
		
		for(int i=1; i<=n; i++) {
			if(!visited[i]) {
				count++;
				dfs(i);
			}
		}
		return count;
	}
	
	private static void dfs(int start) {
		visited[start] = true;
		
		for(int i=1; i<=n; i++) {
			if(!visited[i] && adjMat[start][i]==1) {
				dfs(i);
			}
		}
	}

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());  // 정점 개수
		int m = Integer.parseInt(st.nextToken());  // 간선 개수
		
		adjMat = new int[n+1][n+1];
		visited = new boolean[n+1];
		
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			adjMat[u][v] = adjMat[v][u] = 1;
		}
		
		System.out.println(findConnectedComponent());
	}

}

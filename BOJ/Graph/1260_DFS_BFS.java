import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class DFS_BFS {
	
	private static int[][] adjMat;
	private static boolean[] visited;

	private static void dfs(int n, int v) {
    
		visited[v] = true;
		System.out.print(v + " ");

		// 인접 정점 탐색
		for (int i=1; i<=n; i++) {
			if (adjMat[v][i] == 1 && !visited[i]) {
				dfs(n, i);
			}
		}
	}

	private static void bfs(int n, int v) {

		Queue<Integer> q = new LinkedList<Integer>();

		visited[v] = true;
		q.offer(v);
		System.out.print(v + " ");

		while (!q.isEmpty()) {
			v = q.poll();

			// 인접 정점 탐색
			for (int i=1; i<=n; i++) {
				if (adjMat[v][i] == 1 && !visited[i]) {
					visited[i] = true;
					q.offer(i);
					System.out.print(i + " ");
				}
			}
		}

	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());  // 정점의 개수
		int m = Integer.parseInt(st.nextToken());  // 간선의 개수
		int v = Integer.parseInt(st.nextToken());  // 시작 정점의 번호

		adjMat = new int[n+1][n+1]; // 인접 행렬
		visited = new boolean[n+1]; // 정점 방문 여부

		// insert edge
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());

			// 양방향
			adjMat[x][y] = adjMat[y][x] = 1;
		}

		dfs(n, v);

		System.out.println();
		Arrays.fill(visited, false);

		bfs(n, v);
	}
}

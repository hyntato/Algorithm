import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class OrganicCabbage {
	
	// 상하좌우
	private static int[] dx = {0, 0, -1, 1};
	private static int[] dy = {-1, 1, 0, 0};
	
	private static int n, m;
	private static int[][] map;
	private static boolean[][] visited;
	
	private static int getMinNumOfWorms() {
		int count = 0;
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				if(!visited[i][j] && map[i][j]==1) {
					count++;
					dfs(i, j);
				}
			}
		}
		return count;
	}
	
	private static void dfs(int x, int y) {
		visited[x][y] = true;
		
		for(int i=0; i<4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			
			if(0<=nx && nx<map.length && 0<=ny && ny<map[0].length) {
				if(!visited[nx][ny] && map[nx][ny]==1) {
					dfs(nx, ny);
				}
			}
		}
	}

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int t = Integer.parseInt(br.readLine());
		
		for(int i=0; i<t; i++) {
			st = new StringTokenizer(br.readLine());
			m = Integer.parseInt(st.nextToken());
			n = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());
			
			map = new int[n][m];
			visited = new boolean[n][m];
			
			for(int j=0; j<k; j++) {
				st = new StringTokenizer(br.readLine());
				int y = Integer.parseInt(st.nextToken());
				int x = Integer.parseInt(st.nextToken());
				map[x][y] = 1;
			}
			
			System.out.println(getMinNumOfWorms());
		}

	}

}

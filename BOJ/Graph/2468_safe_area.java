import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SafeArea {
	// 상하좌우
	private static int[] dx = {0, 0, -1, 1};
	private static int[] dy = {-1, 1, 0, 0};
	
	private static int n;
	private static int[][] map;
	private static boolean[][] visited;
	
	private static int getMaxSafeArea(int maxH, int minH) {
		int maxN = 1;
		
		for(int i=minH; i<=maxH; i++) {  // 비의 양에 따라
			visited = new boolean[n][n];
			int count = 0;  // 안전 영역의 개수
			
			for(int j=0; j<n; j++) {
				for(int k=0; k<n; k++) {
					if(!visited[j][k] && map[j][k] > i) {
						count++;
						dfs(i, j, k);
					}
				}
			}
			maxN = (maxN < count) ? count : maxN;
		}
		
		return maxN;
	}
	
	private static void dfs(int h, int x, int y) {
		visited[x][y] = true;
		
		for(int i=0; i<4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			
			if(0<=nx && nx<n && 0<=ny && ny<n) {
				if(!visited[nx][ny] && map[nx][ny] > h) {
					dfs(h, nx, ny);
				}
			}
		}
	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		int maxH = 1;
		int minH = 100;
		
		map = new int[n][n];

		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<n; j++) {
				int h = Integer.parseInt(st.nextToken());
				
				map[i][j] = h;
				if(maxH < h) maxH = h;
				if(h < minH) minH = h;
			}
		}
		
		System.out.println(getMaxSafeArea(maxH, minH));
	}
}

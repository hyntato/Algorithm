import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class NumberOfIslands {
	
	private static int w, h;
	private static int[][] map;
	private static boolean[][] visited;
	
	// 대각선, 상하좌우
	private static int[] dx = {-1, -1, -1, 0, 0, 1, 1, 1};
	private static int[] dy = {-1, 0, 1, -1, 1, -1, 0, 1};
	
	private static int getNumOfIslands() {
		int count = 0;
		
		for(int i=0; i<h; i++) {
			for(int j=0; j<w; j++) {
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
		
		for(int i=0; i<8; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			
			if(0<=nx && nx<h && 0<=ny && ny<w) {
				if(!visited[nx][ny] && map[nx][ny]==1) {
					visited[nx][ny] = true;
					dfs(nx, ny);
				}
			}
		}
	}

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		while(true) {
			st = new StringTokenizer(br.readLine());
			w = Integer.parseInt(st.nextToken());
			h = Integer.parseInt(st.nextToken());
			
			if(w==0 && h==0) break;
			
			map = new int[h][w];
			visited = new boolean[h][w];
			
			for(int i=0; i<h; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0; j<w; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());				
				}
			}
			
			System.out.println(getNumOfIslands());
		}
	}

}

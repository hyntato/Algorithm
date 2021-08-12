import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Tetromino {
	private static int max = 0;
	private static int N, M;
	private static int[][] map;
	private static boolean[][] visited;
	private static int[] dx = {-1, 1, 0, 0};
	private static int[] dy = {0, 0, -1, 1};
	
	private static void dfs(int x, int y, int depth, int sum) {
		if(depth == 4) {
			max = Math.max(max, sum);
			return;
		}
		for(int i=0; i<dx.length; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if(0<=nx && nx<N && 0<=ny && ny<M) {
				if(!visited[nx][ny]) {
					visited[nx][ny] = true;
					dfs(nx, ny, depth+1, sum+map[nx][ny]);
					visited[nx][ny] = false;
				}
			}
		}
	}
	
	// 또는 +모양에서 날개 하나씩 제거하는 방식으로 구현하기
	private static void checkException(int x, int y) {
		if(0<y && y<M-1) {
			if(x<N-1) {  // ㅜ
				max = Math.max(max, map[x][y] + map[x][y-1] + map[x][y+1] + map[x+1][y]);
			}
			if(x>0) {    // ㅗ
				max = Math.max(max, map[x][y] + map[x][y-1] + map[x][y+1] + map[x-1][y]);
			}
		}
		if(0<x && x<N-1) {
			if(y<M-1) {  // ㅏ
				max = Math.max(max, map[x][y] + map[x+1][y] + map[x-1][y] + map[x][y+1]);
			}
			if(y>0) {    // ㅓ
				max = Math.max(max, map[x][y] + map[x+1][y] + map[x-1][y] + map[x][y-1]);
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		visited = new boolean[N][M];
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				visited[i][j] = true;
				dfs(i, j, 1, map[i][j]);  // ㅗ모양 빼고 탐색
				visited[i][j] = false;
				checkException(i, j);	    // ㅗ모양 탐색
			}
		}
		System.out.println(max);
	}

}

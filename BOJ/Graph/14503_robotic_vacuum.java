import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class RoboticVacuum {
	private static int count = 0;
	private static int N, M;
	private static int[][] map;
	
	private static int[] dr = {-1, 0, 1, 0};
	private static int[] dc = {0, 1, 0, -1};
	
	private static void dfs(int r, int c, int d) {
		if(map[r][c] == 0) {
			map[r][c] = 2;  // 1. 현재 위치 청소
			count++;
		}
		
		for(int i=0; i<4; i++) {  // 2. 왼쪽방향으로 돌면서 탐색, 2.b
			int nd = (d+3-i)%4;
			int nr = r + dr[nd];
			int nc = c + dc[nd];
			
			if(0<=nr && nr<N && 0<=nc && nc<M) {
				if(map[nr][nc] == 0) {
					dfs(nr, nc, nd);  // 2.a
					return;
				}
			}
		}
		
		int nd = (d+2)%4;
		int nr = r + dr[nd];
		int nc = c + dc[nd];
		
		if(0<=nr && nr<N && 0<=nc && nc<M) {
			if(map[nr][nc] != 1) {
				dfs(nr, nc, d);  // 2.c
			}
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
	
		st = new StringTokenizer(br.readLine());
		
		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		int d = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		dfs(r, c, d);
		System.out.println(count);
	}

}

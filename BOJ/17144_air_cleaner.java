import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class AirCleaner {
	private static int R, C, T;
	private static int[][] map;
	private static int cleanerR;
	
	private static int[] dr = {-1, 1, 0, 0};
	private static int[] dc = {0, 0, -1, 1};
	
	private static int[][] spread() {
		int[][] tmp = new int[R][C];
		for(int r=0; r<R; r++) {
			for(int c=0; c<C; c++) {
				tmp[r][c] += map[r][c];
				if(map[r][c] < 0) {
					continue;
				}
				for(int d=0; d<dr.length; d++) {
					int nr = r + dr[d];
					int nc = c + dc[d];
					if(0<=nr && nr<R && 0<=nc && nc<C) {
						if(map[nr][nc] != -1) {
							tmp[nr][nc] += map[r][c] / 5;
							tmp[r][c] -= map[r][c] / 5;
						}
					}
				}
			}
		}
		return tmp;
	}
	
	private static void circulateUp(int r, int c) {
		moveDust(0, r, c, r);
		moveDust(3, 0, 0, C-1);
		moveDust(1, 0, C-1, r);
		moveDust(2, r, C-1, C-2);
		map[r][c] = -1;
	}
	
	private static void circulateDown(int r, int c) {
		moveDust(1, r, c, R-r-1);
		moveDust(3, R-1, 0, C-1);
		moveDust(0, R-1, C-1, R-r-1);
		moveDust(2, r, C-1, C-2);
		map[r][c] = -1;
	}
	
	private static void moveDust(int dir, int r, int c, int cnt) {
		for(int i=0; i<cnt; i++) {
			int nr = r + dr[dir];
			int nc = c + dc[dir];
			if(0<=nr && nr<R && 0<=nc && nc<C) {
				map[r][c] = map[nr][nc];
				map[nr][nc] = 0;
				r = nr;
				c = nc;
			}
		}
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());
		map = new int[R][C];
		
		for(int r=0; r<R; r++) {
			st = new StringTokenizer(br.readLine());
			for(int c=0; c<C; c++) {
				map[r][c] = Integer.parseInt(st.nextToken());
				if(map[r][c] == -1) {
					cleanerR = r;
				}
			}
		}
		
		for(int i=0; i<T; i++) {
			map = spread();
			circulateUp(cleanerR-1, 0);
			circulateDown(cleanerR, 0);
			
		}
		
		int sum = 0;
		for(int r=0; r<R; r++) {
			for(int c=0; c<C; c++) {
				if(map[r][c] != -1) {
					sum += map[r][c];
				}
			}
		}
		System.out.println(sum);
	}

}

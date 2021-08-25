import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Ladder {
	private static int N, M, H;
	private static boolean success;
	private static boolean[][] map;
	
	private static void combination(int x, int y, int cnt) {
		if(cnt == 0) {
			boolean check = true;
			for(int i=1; i<=N; i++) {
				if(!move(i)) {
					check = false;
					break;
				}
			}
			if(check) {
				success = true;
			}
			return;
		}
		for(int i=x; i<=H; i++) {
			for(int j=1; j<N; j++) {
				if(!map[i][j] && !map[i][j-1] && !map[i][j+1]) {
					map[i][j] = true;
					combination(i, j+1, cnt-1);
					map[i][j] = false;
				}
			}
		}
	}
	
	private static boolean move(int start) {
		int y = start;
		for(int x=1; x<=H; x++) {
			if(map[x][y]) {
				y++;
			} else if(map[x][y-1]) {
				y--;
			}
		}
		return (start == y);
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		
		map = new boolean[H+1][N+1];
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			map[x][y] = true;
		}
		
		int answer = -1;
		
		for(int i=0; i<=3; i++) {
			combination(1, 1, i);
			if(success) {
				answer = i;
				break;
			}
		}
		System.out.println(answer);
	}
}

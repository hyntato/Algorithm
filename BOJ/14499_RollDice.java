import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 주사위 -> 1차원 배열로 펼치기
public class RollDice {
	private static int[][] map;
	private static int N, M;
	private static int x, y;
	
	private static int[] dice = new int[7];
	private static int top = 1;
	private static int bottom = 6;
	
	private static int[] dx = {0, 0, -1, 1};  // 동서북남
	private static int[] dy = {1, -1, 0, 0};
	
	private static void rollDice(int[] order) {
		for(int i=0; i<order.length; i++) {
			int nx = x + dx[order[i]-1];
			int ny = y + dy[order[i]-1];
			if(!(0<=nx && nx<N && 0<=ny && ny<M)) {
				continue;
			}
			
			roll(order[i]);
			
			if(map[nx][ny] == 0) {
				map[nx][ny] = dice[bottom];
			} else {
				dice[bottom] = map[nx][ny];
				map[nx][ny] = 0;
			}
			x = nx;
			y = ny;
			System.out.println(dice[top]);
		}
	}
	
	private static void roll(int order) {
		int tmp = dice[1];  // 또는 int[] tmp = dice.clone();하고 tmp값으로 교체
		switch(order) {
		case 1:  // 동
			dice[1] = dice[4];
			dice[4] = dice[6];
			dice[6] = dice[3];
			dice[3] = tmp;
			break;
		case 2:  // 서
			dice[1] = dice[3];
			dice[3] = dice[6];
			dice[6] = dice[4];
			dice[4] = tmp;
			break;
		case 3:  // 북
			dice[1] = dice[5];
			dice[5] = dice[6];
			dice[6] = dice[2];
			dice[2] = tmp;
			break;
		case 4:  // 남
			dice[1] = dice[2];
			dice[2] = dice[6];
			dice[6] = dice[5];
			dice[5] = tmp;
			break;
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		x = Integer.parseInt(st.nextToken());
		y = Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int[] order = new int[n];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++) {
			order[i] = Integer.parseInt(st.nextToken());
		}
		
		rollDice(order);
	}
}

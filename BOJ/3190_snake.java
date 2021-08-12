import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// Deque 사용해봄!
public class 뱀 {
	private static int sec = 0;
	private static int N, K, L;
	private static int[][] map;  // 벽: -1, 사과: 1, 뱀: 9, 빈칸: 0
	private static Queue<int[]> order = new LinkedList<>();
	private static Deque<int[]> snake = new LinkedList<>();  // 또는 List로 구현하기

	private static int[] dx = {0, 1, 0, -1};
	private static int[] dy = {1, 0, -1, 0};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		K = Integer.parseInt(br.readLine());
		
		map = new int[N+2][N+2];
		for(int i=0; i<N+2; i++) {
			for(int j=0; j<N+2; j++) {
				if(i == 0 || i == N+1 || j == 0 || j == N+1) {
					map[i][j] = -1;
				}
			}
		}
		
		for(int i=0; i<K; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			map[x][y] = 1;  // 사과
		}
		
		L = Integer.parseInt(br.readLine());
		
		for(int i=0; i<L; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int sec = Integer.parseInt(st.nextToken());
			String dir = st.nextToken();
			if(dir.equals("D")) {
				order.add(new int[] {sec, 1});
			} else {
				order.add(new int[] {sec, 3});
			}
		}
		
		int dir = 0;    // 오른쪽
		map[1][1] = 9;  // 뱀
		snake.add(new int[] {1, 1});
		
		while(true) {
			if(!order.isEmpty() && sec == order.peek()[0]) {
				dir = (dir+order.peek()[1]) % 4;
				order.poll();
			}
			int[] head = snake.peek();
			int hx = head[0] + dx[dir];
			int hy = head[1] + dy[dir];
			
			if(map[hx][hy] == -1 || map[hx][hy] == 9) {
				sec++;
				break;
			}
			if(map[hx][hy] == 1) {
				map[hx][hy] = 9;
				snake.addFirst(new int[] {hx, hy});
			} else {
				map[hx][hy] = 9;
				snake.addFirst(new int[] {hx, hy});
				int[] rm = snake.removeLast();
				map[rm[0]][rm[1]] = 0;
			}
			sec++;
		}
		System.out.println(sec);
	}

}

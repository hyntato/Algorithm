import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Alphabet {

	// 상하좌우
	private static int[] dx = {0, 0, -1, 1};
	private static int[] dy = {-1, 1, 0, 0};
	
	private static int r, c, max;
	private static char[][] board;
	private static boolean[] visited;
	
	private static void dfs(int x, int y, int count) {
		count++;
		visited[board[x][y]-'A'] = true;
    
		max = (max < count) ? count : max;
		
		for(int i=0; i<4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			
			if(0<=nx && nx<r && 0<=ny && ny<c) {
				if(!visited[board[nx][ny]-'A']) {
					dfs(nx, ny, count);
				}
			}
		}
		visited[board[x][y]-'A'] = false;
	}
	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());

		max = 0;
		board = new char[r][c];
		visited = new boolean[26];

		for(int i=0; i<r; i++) {
			char[] chars = br.readLine().toCharArray();
			for(int j=0; j<c; j++) {
				board[i][j] = chars[j];
			}
		}
		
		dfs(0, 0, 0);
		System.out.println(max);
	}
}

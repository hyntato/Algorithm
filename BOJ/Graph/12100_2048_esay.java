import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Easy2048 {
	private static int max = 0;
	private static int N;
	
	private static void dfs(int[][] board, int cnt) {
		if(cnt == 5) {
			return;
		}
		dfs(up(board), cnt+1);
		dfs(down(board), cnt+1);
		dfs(left(board), cnt+1);
		dfs(right(board), cnt+1);
	}

	private static int[][] up(int[][] board) {
		int[][] result = new int[N][N];
		Stack<Integer> stack = new Stack<>();
		for(int c=0; c<N; c++) {
			int idx = 0;
			for(int r=0; r<N; r++) {
				if(board[r][c] == 0) {
					continue;
				}
				if(stack.isEmpty()) {
					stack.push(board[r][c]);
					continue;
				}
				if(stack.peek() == board[r][c]) {
					result[idx++][c] = stack.pop()*2;
					max = Math.max(max, board[r][c]*2);
				} else {
					result[idx++][c] = stack.pop();
					stack.push(board[r][c]);
				}
			}
			if(!stack.isEmpty()) {
				result[idx][c] = stack.pop();
			}
		}
		return result;
	}
  
	private static int[][] down(int[][] board) {
		int[][] result = new int[N][N];
		Stack<Integer> stack = new Stack<>();
		for(int c=0; c<N; c++) {
			int idx = N-1;
			for(int r=N-1; r>=0; r--) {
				if(board[r][c] == 0) {
					continue;
				}
				if(stack.isEmpty()) {
					stack.push(board[r][c]);
					continue;
				}
				if(stack.peek() == board[r][c]) {
					result[idx--][c] = stack.pop()*2;
					max = Math.max(max, board[r][c]*2);
				} else {
					result[idx--][c] = stack.pop();
					stack.push(board[r][c]);
				}
			}
			if(!stack.isEmpty()) {
				result[idx][c] = stack.pop();
			}
		}
		return result;
	}
  
	private static int[][] left(int[][] board) {
		int[][] result = new int[N][N];
		Stack<Integer> stack = new Stack<>();
		for(int r=0; r<N; r++) {
			int idx = 0;
			for(int c=0; c<N; c++) {
				if(board[r][c] == 0) {
					continue;
				}
				if(stack.isEmpty()) {
					stack.push(board[r][c]);
					continue;
				}
				if(stack.peek() == board[r][c]) {
					result[r][idx++] = stack.pop()*2;
					max = Math.max(max, board[r][c]*2);
				} else {
					result[r][idx++] = stack.pop();
					stack.push(board[r][c]);
				}
			}
			if(!stack.isEmpty()) {
				result[r][idx] = stack.pop();
			}
		}
		return result;
	}
	
	private static int[][] right(int[][] board) {
		int[][] result = new int[N][N];
		Stack<Integer> stack = new Stack<>();
		for(int r=0; r<N; r++) {
			int idx = N-1;
			for(int c=N-1; c>=0; c--) {
				if(board[r][c] == 0) {
					continue;
				}
				if(stack.isEmpty()) {
					stack.push(board[r][c]);
					continue;
				}
				if(stack.peek() == board[r][c]) {
					result[r][idx--] = stack.pop()*2;
					max = Math.max(max, board[r][c]*2);
				} else {
					result[r][idx--] = stack.pop();
					stack.push(board[r][c]);
				}
			}
			if(!stack.isEmpty()) {
				result[r][idx] = stack.pop();
			}
		}
		return result;
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
	
		int[][] board = new int[N][N];
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
				max = Math.max(max, board[i][j]);
			}
		}
		
		dfs(board, 0);
		System.out.println(max);
	}
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Matrix {
	
	private static int n, m;
	private static int[][] A, B;
	
	static private void flip(int r, int c) {
		for(int i=r; i<r+3; i++) {
			for(int j=c; j<c+3; j++) {
				A[i][j] = 1 - A[i][j];
			}
		}
	}
	
	static private boolean isEqual() {
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				if(A[i][j] != B[i][j]) {
					return false;
				}
			}
		}
		return true;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		A = new int[n][m];
		B = new int[n][m];
		
		for(int i=0; i<n; i++) {
			String row = br.readLine();
			for(int j=0; j<m; j++) {
				A[i][j] = row.charAt(j) - '0';
			}
		}
		
		for(int i=0; i<n; i++) {
			String row = br.readLine();
			for(int j=0; j<m; j++) {
				B[i][j] = row.charAt(j) - '0';
			}
		}
		
		int count = 0;
		
		// check
		for(int i=0; i<=n-3; i++) {
			for(int j=0; j<=m-3; j++) {
				if(A[i][j] != B[i][j]) {
					flip(i, j);
					count++;
				}
			}
		}
		
		// 예외 처리
		if(isEqual())
			System.out.println(count);
		else
			System.out.println(-1);
		
		/*
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				if(A[i][j] != B[i][j]) {
					if(flip(i, j))
						count++;
					else {
						System.out.println(-1);
						return;
					}
				}
			}
		}
		System.out.println(count);
		*/
	}
	
	/*
	static private boolean flip(int r, int c) {
		if(n < r+3 || m < c+3)
			return false;
		
		for(int i=r; i<r+3; i++) {
			for(int j=c; j<c+3; j++) {
				A[i][j] = 1 - A[i][j];
			}
		}
		return true;
	}
	*/
	
}

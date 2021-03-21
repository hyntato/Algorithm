import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class FindPath {

	private static void findPath(int n, int[][] adjMat) {
		
		// floyd
		for(int k=0; k<n; k++) {
			for(int i=0; i<n; i++) {
				for(int j=0; j<n; j++) {
					if(adjMat[i][k]==1 && adjMat[k][j]==1)
						adjMat[i][j] = 1;
				}
			}
		}
    
    // +) floyd 알고리즘 대신 기본적인 탐색 알고리즘 DFS, BFS를 사용하여도 됨
	}
	
	public static void main(String[] args) throws IOException {
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		
		int[][] adjMat = new int[n][n];
		
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<n; j++) {
				adjMat[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		findPath(n, adjMat);
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				if(adjMat[i][j] == 1)
					System.out.print(1 + " ");
				else
					System.out.print(0 + " ");
			}
			System.out.println();
		}
	}

}

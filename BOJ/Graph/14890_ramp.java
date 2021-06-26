import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Ramp {
	
	public static int findPossibleWay(int N, int L, int[][] map) {
		int count = 0;
		
		for(int i=0; i<N; i++) {
			int n_cnt = 1;
			int l_cnt = 0;
			int pre = map[i][0];
			int curr = map[i][0];
			boolean flag = true;
			
			for(int j=1; j<N; j++) {
				curr = map[i][j];
				
				if(Math.abs(pre-curr) > 1) {
					flag = false;
					break;
				}
				
				if(pre == curr) {
					if(l_cnt > 0) {
						l_cnt++;
						if(l_cnt >= L) {
							n_cnt = Math.abs(L-l_cnt);
							l_cnt = 0;
						}
					} else {
						n_cnt++;
					}
				}
				else if(pre < curr) {
					if(l_cnt > 0) {
						if(l_cnt >= L) {
							n_cnt = Math.abs(L-l_cnt);
							l_cnt = 0;
						} else {
							flag = false;
							break;
						}
					}
					if(n_cnt < L) {
						flag = false;
						break;
					} else {
						l_cnt = 0;
						n_cnt = 1;
					}
				}
				else {
					if(l_cnt > 0) {
						if(l_cnt >= L) {
							l_cnt = 1;
							n_cnt = 1;
						} else {
							flag = false;
							break;
						}
					} else {
						l_cnt = 1;
						n_cnt = 1;
					}
				}
				
				pre = curr;
			}
			
			if(flag && l_cnt < 1 || flag && l_cnt == L) {
				count++;
			}
				
		}
		
		return count;
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());
	
		int[][] mapR = new int[N][N];
		int[][] mapC = new int[N][N];
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				mapR[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				mapC[i][j] = mapR[j][i];
			}
		}
		
		int count = findPossibleWay(N, L, mapR);
		count += findPossibleWay(N, L, mapC);
		
		System.out.println(count);
	}

}

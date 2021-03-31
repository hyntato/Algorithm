import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class NewRecruit {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int t = Integer.parseInt(br.readLine());
		
		for(int i=0; i<t; i++) {
			int n = Integer.parseInt(br.readLine());
			int[][] ranking = new int[n][2];  // 이차원 배열 대신 Applicant 클래스 만들어서 구현해도 무방!
			
			for(int j=0; j<n; j++) {
				st = new StringTokenizer(br.readLine());
				ranking[j][0] = Integer.parseInt(st.nextToken());
				ranking[j][1] = Integer.parseInt(st.nextToken());				
			}
			
			// 서류심사 순위 기준 오름차순 정렬
			Arrays.sort(ranking, new Comparator<int[]>() {
				@Override
				public int compare(int[] o1, int[] o2) {
					return o1[0] - o2[0];
				}
			});
			
			int count = 1;
			int min = ranking[0][1];  // 서류심사 1등의 면접 순위
			
			for(int j=1; j<n; j++) {
				// 서류심사 순위가 높은 사람들보다 면접 순위가 높아야 뽑힘
				if(ranking[j][1] < min) {
					count++;
					min = ranking[j][1];
				}
			}
			System.out.println(count);
		}
	}
}

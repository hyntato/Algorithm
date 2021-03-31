import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Camping {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int caseNum = 0;
		
		while(true) {
			st = new StringTokenizer(br.readLine());
			
			// v일의 휴가, 캠핑은 p일 중 l일 사용 가능
			int l = Integer.parseInt(st.nextToken());
			int p = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			
			if(l*p*v == 0) break;
			
			int max;
			
			if(l < v % p)
				max = (v / p) * l + l;
			else
				max = (v / p) * l + (v % p);
			
			System.out.println("Case " + ++caseNum + ": " + max);
		}
		
	}

}

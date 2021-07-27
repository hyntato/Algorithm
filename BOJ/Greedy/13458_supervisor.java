import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Supervisor {
	
	private static int countStaff(int n, int B, int C) {
		n -= B;
		if(n <= 0) {
			return 1;
		}
		if(n%C == 0) {
			return n/C + 1;
		} else {
			return n/C + 2;
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		st = new StringTokenizer(br.readLine());
		int B = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		
		long total = 0;
		for(int i=0; i<N; i++) {
			total += countStaff(arr[i], B, C);
		}
		System.out.println(total);
	}
}

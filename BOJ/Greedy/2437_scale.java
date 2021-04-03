import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Scale {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int[] weights = new int[n];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for(int i=0; i<n; i++) {
			weights[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(weights);

		int min = 0;
		
		for(int i=0; i<n; i++) {
			if(min+1 < weights[i])
				break;
			min += weights[i];
		}
		
		System.out.println(min+1);
	}
	
}


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class TieNumber {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		int[] nums = new int[n];
		
		for(int i=0; i<n; i++) {
			nums[i] = Integer.parseInt(br.readLine());
		}
		
		Arrays.sort(nums);

		int sum = 0;
		int negIdx = 0;
		int posIdx = n-1;
		
		// 음수*음수, 0
		for(; negIdx<n-1; negIdx+=2) {
			if(nums[negIdx] <= 0 && nums[negIdx+1] <= 0)
				sum += nums[negIdx] * nums[negIdx+1];
			else
				break;
		}
		
		// 양수*양수, 1 제외 (1*2 < 1+2, 1은 곱한 값보다 더한 값이 더 큼)
		for(; posIdx>0; posIdx-=2) {
			if(nums[posIdx] > 1 && nums[posIdx-1] > 1)
				sum += nums[posIdx] * nums[posIdx-1];
			else
				break;
		}
		
		// 묶이지 않은 수 더하기
		for(; posIdx>=negIdx; posIdx--) {
			sum += nums[posIdx];
		}
		
		System.out.println(sum);
	}

}

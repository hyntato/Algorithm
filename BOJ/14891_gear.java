import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Gear {
	private static List<Integer>[] gear = new ArrayList[4];
	private static int L = 6;
	private static int R = 2;
  
  	private static void left(int num, int dir) {
		if(0<=num && (gear[num+1].get(L) != gear[num].get(R))) {
			left(num-1, -dir);
			rotate(num, dir);
		}
	}
	
	private static void right(int num, int dir) {
		if(num<4 && (gear[num-1].get(R) != gear[num].get(L))) {
			right(num+1, -dir);
			rotate(num, dir);
		}
	}
	
	private static void rotate(int num, int dir) {
		if(dir == 1) {
			int last = gear[num].remove(7);
			gear[num].add(0, last);
		} else {
			int first = gear[num].remove(0);
			gear[num].add(first);
		}
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for(int i=0; i<4; i++) {
			String[] token = br.readLine().split("");
			gear[i] = new ArrayList<Integer>();
			for(int j=0; j<8; j++) {
				gear[i].add(Integer.parseInt(token[j]));
			}
		}
		
		int K = Integer.parseInt(br.readLine());
		
		for(int i=0; i<K; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int num = Integer.parseInt(st.nextToken())-1;
			int dir = Integer.parseInt(st.nextToken());
			left(num-1, -dir);
			right(num+1, -dir);
			rotate(num, dir);
		}
		
		int sum = 0;
		
		for(int i=0; i<4; i++) {
			if(gear[i].get(0) == 1) {
				sum += Math.pow(2, i);
			}
		}
		System.out.println(sum);
	}
	
}


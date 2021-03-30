import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class MeetingAssign {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int n = Integer.parseInt(br.readLine());
		Meeting[] meetings = new Meeting[n];
		
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			meetings[i] = new Meeting(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}
		
		// 1. 회의가 *끝나는* 시간 기준 오름차순 정렬
		// 2. 끝나는 시간이 같다면 시작 시간을 기준으로 오름차순 정렬
		Arrays.sort(meetings);
		
		int count = 1;
		int currEnd = meetings[0].getEnd();
		
		for(int i=1; i<n; i++) {
			int nextStart = meetings[i].getStart();
			int nextEnd = meetings[i].getEnd();
			
			if(currEnd <= nextStart) {
				count++;
				currEnd = nextEnd;
			}
		}
		System.out.println(count);
	}

}

class Meeting implements Comparable<Meeting> {
	private int start, end;
	
	public Meeting(int start, int end) {
		this.start = start;
		this.end = end;
	}
	
	public int getStart() { return this.start; }
	public int getEnd() { return this.end; }

	@Override
	public int compareTo(Meeting m) {
		if(this.end == m.end) {
			return this.start - m.start;
		}
		return this.end - m.end;
	}
}

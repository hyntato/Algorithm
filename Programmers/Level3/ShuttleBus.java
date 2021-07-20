import java.util.*;
// 큐나 리스트 써도 됨

class ShuttleBus {
    public String solution(int n, int t, int m, String[] timetable) {
        int[] times = new int[timetable.length];
        
        for(int i=0; i<times.length; i++) {
            String[] time = timetable[i].split(":");
            times[i] = Integer.parseInt(time[0])*60 + Integer.parseInt(time[1]);
        }
        
        Arrays.sort(times);
        
        int shuttleTime = 9*60;
        int lastCrewTime = times[0];
        int nextCrewIdx = 0;
        int seatCnt = 0;
        
        for(int i=0; i<n; i++) {
            shuttleTime = 9*60 + i*t;
            seatCnt = m;
            
            for(int j=nextCrewIdx; j<times.length; j++) {
                if(times[j] <= shuttleTime) {
                    seatCnt--;
                } else {
                    nextCrewIdx = j;
                    break;
                }
                if(seatCnt == 0) {
                    nextCrewIdx = j+1;
                    break;
                }
            }
            if(nextCrewIdx > 0) lastCrewTime = times[nextCrewIdx-1];
        }
        
        int ans = shuttleTime;
        if(seatCnt == 0) {
            ans = lastCrewTime - 1;
        }
        
        String answer = String.format("%02d:%02d", ans/60, ans%60);
        return answer;
    }
}

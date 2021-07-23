class InsertAd {
    public String solution(String play_time, String adv_time, String[] logs) {
        int N = logs.length;
        int[] logs_start_sec = new int[N];
        int[] logs_end_sec = new int[N];
        
        for(int i=0; i<N; i++) {
            String[] log = logs[i].split("-");
            logs_start_sec[i] = timeToSec(log[0]);
            logs_end_sec[i] = timeToSec(log[1]);
        }
        
        int play_time_sec = timeToSec(play_time);
        int adv_time_sec = timeToSec(adv_time);
        long[] total_time = new long[play_time_sec+1];
        
        for(int i=0; i<N; i++) {
            total_time[logs_start_sec[i]]++;
            total_time[logs_end_sec[i]]--;
        }
        
        // 구간 개수
        for(int i=1; i<total_time.length; i++) {
            total_time[i] += total_time[i-1];
        }
        
        // 누적 재생 시간
        for(int i=1; i<total_time.length; i++) {
            total_time[i] += total_time[i-1];
        }
        
        long max_acc = total_time[adv_time_sec-1];
        int adv_end_sec = adv_time_sec;
        
        for(int i=adv_time_sec; i<total_time.length-1; i++) {
            long acc = total_time[i] - total_time[i-adv_time_sec];
            if(acc > max_acc) {
                max_acc = acc;
                adv_end_sec = i+1;
            }
        }
    
        String answer = secToTime(adv_end_sec-adv_time_sec);
        return answer;
    }
    
    public int timeToSec(String time) {
        int sec = 0;
        String[] t = time.split(":");
        sec += Integer.parseInt(t[0])*60*60;
        sec += Integer.parseInt(t[1])*60;
        sec += Integer.parseInt(t[2]);
        return sec;
    }
    
    public String secToTime(int sec) {
        int hour = sec/(60*60);
        sec = sec%(60*60);
        int min = sec/60;
        sec = sec%60;
        return String.format("%02d:%02d:%02d", hour, min, sec);
    }
}

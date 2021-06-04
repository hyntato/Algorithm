import java.util.*;

class Immigration {
    public long solution(int n, int[] times) {
        Arrays.sort(times);
        long start = 1;
        long end = n * (long)times[times.length-1];
        
        while(start <= end) {
            long mid = (start + end) / 2;
            if(countPassed(mid, times) < n)
                start = mid + 1;
            else
                end = mid - 1;
        }
        return start;
    }
    
    public long countPassed(long mid, int[] times) {
        long count = 0;
        for(int time: times) {
            count += mid / time;
        }
        return count;
    }
}

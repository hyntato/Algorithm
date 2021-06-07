import java.util.*;

class Work {
    public long solution(int n, int[] works) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        
        for(int work: works) {
            pq.offer(work);
        }
        
        for(int i=0; i<n; i++) {
            if(pq.peek() > 0) {
                int work = pq.poll();
                work--;
                pq.offer(work);
            }
            else break;
        }
        
        long answer = 0;
        while(!pq.isEmpty()) {
            int work = pq.poll();
            answer += work * work;
        }
        return answer;
    }
}

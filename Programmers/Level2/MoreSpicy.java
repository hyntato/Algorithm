import java.util.*;

class MoreSpicy {

    public int solution(int[] scoville, int K) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int sc: scoville) {
            pq.offer(sc);
        }
        
        int count = 0;
        while(pq.size() >= 2 && pq.peek() < K) {
            int min1 = pq.poll();
            int min2 = pq.poll();
            
            pq.offer(min1 + min2*2);
            count++;
        }
        
        if(pq.size() < 2 && pq.peek() < K)
            count = -1;
        
        return count;
    }
  
}

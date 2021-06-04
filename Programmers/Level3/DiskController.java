import java.util.*;

// SJF
class DiskController {
    public int solution(int[][] jobs) {
        Arrays.sort(jobs, (o1, o2) -> o1[0] - o2[0]);
        
        Queue<int[]> waitQ = new LinkedList<>();
        for(int[] job: jobs) {
            waitQ.offer(job);
        }
        
        PriorityQueue<int[]> workQ = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);
        
        int answer = 0;
        int time = 0;
        while(true) {
            while(!waitQ.isEmpty() && waitQ.peek()[0] <= time) {
                workQ.offer(waitQ.poll());
            }
            
            if(!workQ.isEmpty()) {
                int[] job = workQ.poll();
                answer += (time - job[0]) + job[1];
                time += job[1];
            } else
                time++;
                
            if(waitQ.isEmpty() && workQ.isEmpty()) break;
        }
        
        return answer / jobs.length;
    }
}

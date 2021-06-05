import java.util.*;

class DualPriorityQueue {
    public int[] solution(String[] operations) {
        PriorityQueue<Integer> minPQ = new PriorityQueue<>();
        PriorityQueue<Integer> maxPQ = new PriorityQueue<>((o1, o2) -> o2 - o1);
        
        for(int i=0; i<operations.length; i++) {
            String[] op = operations[i].split(" ");
            switch(op[0]) {
                case "I":
                    int num = Integer.parseInt(op[1]);
                    minPQ.offer(num);
                    maxPQ.offer(num);
                    break;
                case "D":
                    if(op[1].equals("1") && !maxPQ.isEmpty()) {
                        int max = maxPQ.poll();
                        minPQ.remove(max);
                        break;
                    } 
                    if(op[1].equals("-1")&& !minPQ.isEmpty()) {
                        int min = minPQ.poll();
                        maxPQ.remove(min);
                        break;
                    }
            }
        }
        int[] answer = {0, 0};
        if(!maxPQ.isEmpty() && !minPQ.isEmpty()) {
            answer[0] = maxPQ.poll();
            answer[1] = minPQ.poll();
        }
        return answer;
    }
}

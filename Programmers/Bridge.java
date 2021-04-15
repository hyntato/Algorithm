import java.util.*;

class Solution {
    
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        
        Queue<Integer> bridgeQ = new LinkedList<>();
        for (int i=0; i<bridge_length; i++) {
            bridgeQ.offer(0);
        }
        
        int idx = 0;
        int sum = 0;
        int time = 0;
        
        while(!bridgeQ.isEmpty()) {
            time++;
            sum -= bridgeQ.poll();

            if(idx < truck_weights.length) {
                if(sum + truck_weights[idx] <= weight) {
                    bridgeQ.offer(truck_weights[idx]);
                    sum += truck_weights[idx];
                    idx++;
                }
                else {
                   bridgeQ.offer(0); 
                }
            }
        }
        
        return time;
    }
}

/*
import java.util.*;

class Solution {
    
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        
        Queue<Truck> waitQ = new LinkedList<>();
        Queue<Truck> moveQ = new LinkedList<>();
        
        for(int truck: truck_weights) {
            waitQ.offer(new Truck(truck));
        }
        
        // 첫 번째 트럭 이동
        Truck _truck = waitQ.poll();
        moveQ.offer(_truck);
        
        int truckSum = _truck.weight;
        int time = 1;
        
        while(!waitQ.isEmpty() || !moveQ.isEmpty()) {
            time++;
            
            // 트럭 1씩 이동
            for(Truck truck: moveQ) {
                truck.moving();
            }
            
            // 다리 지난 트럭 제거
            if(moveQ.peek().move > bridge_length) {
                Truck truck = moveQ.poll();
                truckSum -= truck.weight;
            }
            
            // 새로운 트럭 추가
            if(!waitQ.isEmpty() && truckSum + waitQ.peek().weight <= weight) {
                Truck truck = waitQ.poll();
                truckSum += truck.weight;
                moveQ.offer(truck);
            }
        }
        
        return time;
    }
}

class Truck {
    int weight;
    int move;
    
    public Truck(int weight) {
        this.weight = weight;
        this.move = 1;
    }
    public void moving() {
        this.move++;
    }
}
*/

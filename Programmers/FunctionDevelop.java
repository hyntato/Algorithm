import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        
        List<Integer> deployList = new ArrayList<>();
        
        int pre = (int) Math.ceil((100-progresses[0]) / (double)speeds[0]);
        int count = 1;
        
        for(int i=1; i<progresses.length; i++) {
            int curr = (int) Math.ceil((100-progresses[i]) / (double)speeds[i]);
            // 새로운 배포일에 배포
            if (pre < curr) {
                deployList.add(count);
                pre = curr;
                count = 1;
            }
            // 앞의 작업과 함께 배포 가능
            else {
                count++;
            }
        }
        // 마지막 배포 처리
        deployList.add(count);
        
        int[] answer = new int[deployList.size()];
        for(int i=0; i<answer.length; i++) {
            answer[i] = deployList.get(i);
        }
        return answer;
    }
}

/*
class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        
        List<Integer> deployList = new ArrayList<>();
        int day = 0;
        
        for(int i=0; i<progresses.length; i++) {
            // 앞의 작업과 함께 배포 가능
            if(progresses[i] + (day*speeds[i]) >= 100) {  
                int count = deployList.get(deployList.size()-1);
                deployList.set(deployList.size()-1, count+1);
            }
            else {
                // 새로운 배포일 구하기
                while(progresses[i] + (day*speeds[i]) < 100) {
                    day++;
                }
                deployList.add(1);
            }
            
        }
        
        int[] answer = new int[deployList.size()];
        for(int i=0; i<answer.length; i++) {
            answer[i] = deployList.get(i);
        }
        return answer;
    }
}

*/

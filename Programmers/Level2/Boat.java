import java.util.*;

class Boat {
    public int solution(int[] people, int limit) {
        Arrays.sort(people);
        
        int count = 0;
        int minIdx= 0;
        int maxIdx = people.length-1;
        
        for(; minIdx <= maxIdx; maxIdx--) {
            if(people[minIdx] + people[maxIdx] <= limit) {
                minIdx++;
            }   
            count++;
        }
        return count;
    }
}
/*
몸무게 가장 적은 사람, 가장 큰 사람 <- 이렇게 내보내는게 가장 굿
몸무게 큰 사람들 먼저 판단
*/

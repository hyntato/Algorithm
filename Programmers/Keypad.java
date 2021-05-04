class Keypad {
    public String solution(int[] numbers, String hand) {
        int left = 10;
        int right = 12;
        String answer = "";
        
        for(int num: numbers) {
            if(num == 0) num = 11;
            
            if((num-1)%3 == 0) {
                left = num;
                answer += "L";
            } else if((num-1)%3 == 2) {
                right = num;
                answer += "R";
            } else {
                int leftDistance = Math.abs((left-1)%3 - (num-1)%3) + Math.abs((left-1)/3 - (num-1)/3);
                int rightDistance = Math.abs((right-1)%3 - (num-1)%3) + Math.abs((right-1)/3 - (num-1)/3);
                
                if(leftDistance < rightDistance) {
                    left = num;
                    answer += "L";
                } else if(leftDistance > rightDistance) {
                    right = num;
                    answer += "R";
                } else {
                    if(hand.equals("left")) {
                        left = num;
                        answer += "L";
                    } else {
                        right = num;
                        answer += "R";
                    }
                }
            }
        }
        return answer;
    }
}

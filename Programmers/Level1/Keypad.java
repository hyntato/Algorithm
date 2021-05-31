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

class Keypad2 {
    public String solution(int[] numbers, String hand) {
        int[][] keypad = {{3,1}, {0,0}, {0,1}, {0,2}, {1,0}, {1,1}, {1,2}, {2,0}, {2,1}, {2,2}};
        int[] left = {3,0};
        int[] right = {3,2};
        String answer = "";
        
        for(int num: numbers) {
            switch(num) {
                case 1: case 4: case 7:
                    answer += "L";
                    left = keypad[num];
                    break;
                case 3: case 6: case 9:
                    answer += "R";
                    right = keypad[num];
                    break;
                case 2: case 5: case 8: case 0:
                    int lDistance = Math.abs(keypad[num][0]-left[0]) + Math.abs(keypad[num][1]-left[1]);
                    int rDistance = Math.abs(keypad[num][0]-right[0]) + Math.abs(keypad[num][1]-right[1]);
                    if(lDistance < rDistance) {
                        answer += "L";
                        left = keypad[num];
                    } else if(lDistance > rDistance) {
                        answer += "R";
                        right = keypad[num];
                    } else {
                        if(hand.equals("left")) {
                            answer += "L";
                            left = keypad[num];
                        } else {
                            answer += "R";
                            right = keypad[num];
                        }
                    }
                    break;
            }
        }
        
        return answer;
    }
}

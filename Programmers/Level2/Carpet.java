class Carpet {
    public int[] solution(int brown, int yellow) {
        int total = brown + yellow;
        int width = 3;
        int height = 3;
        
        int[] answer = new int[2];
        for(int i=3; i<=total/2; i++) {
            if(total%i == 0) {
                width = total / i;
                height = i;
              
                if(brown == (width-2)*2 + (height*2) && yellow == (width-2)*(height-2)) {
                    answer[0] = width;
                    answer[1] = height;
                    break;
                }
            }
        }
        return answer;
    }
}

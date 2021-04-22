class BinaryConversion {
    public int[] solution(String s) {
        int cntBinary = 0;
        int cntZero = 0;
        
        while(!s.equals("1")) {
            int len = s.replace("0", "").length();
            cntZero += s.length() - len;
            s = "";
            
            // 이진 변환
            while(len > 0) {
                s = len%2 + s;
                len /= 2;
            }
            cntBinary++;
        }
        
        int[] answer = new int[2];
        answer[0] = cntBinary;
        answer[1] = cntZero;
        return answer;
    }
}

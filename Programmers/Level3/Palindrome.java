class Palindrome {
    public int solution(String s) {
        int answer = 1;

        // 기준: 문자 1개 (부분 문자열이 홀수길이)
        for(int i=1; i<s.length()-1; i++) {
            int offset = 1;
            while(true) {
                int left = i-offset;
                int right = i+offset;
                if(0<=left && right<=s.length()-1 && s.charAt(left) == s.charAt(right))
                    offset++;
                else
                    break;
            }
            answer = Math.max(answer, offset*2-1);
        }
        
        // 기준: 문자 2개 (부분 문자열이 짝수길이)
        for(int i=2; i<s.length()-2; i++) {
            if(s.charAt(i) != s.charAt(i+1)) continue;
            int offset = 1;
            while(true) {
                int left = i-offset;
                int right = i+1+offset;
                if(0<=left && right<=s.length()-1 && s.charAt(left) == s.charAt(right))
                    offset++;
                else
                    break;
            }
            answer = Math.max(answer, offset*2);
        }
        return answer;
    }
}

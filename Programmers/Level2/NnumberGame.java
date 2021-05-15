class NnumberGame {
    private char[] nums = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
    
    public String solution(int n, int t, int m, int p) {
        String answer = "";
        String result = "";
        int num = 0;
        
        while(true) {
            result += convertN(num++, n);
            if(result.length() >= t*m) break;
        }
        for(int i=0; i<t; i++) {
            answer += result.charAt(m*i + p-1);
        }
        return answer;
    }
    
    public String convertN(int num, int n) {
        String result = "";
        while(true) {
            result = nums[num%n] + result;
            num = num/n;
            if(num == 0) break;
        }
        return result;
    }
}

/*
class NnumberGame {
    public String solution(int n, int t, int m, int p) {
        String answer = "";
        String result = "";
        int num = 0;
        
        while(true) {
            result += convertN(num++, n);
            if(result.length() >= t*m) break;
        }
        for(int i=0; i<t; i++) {
            answer += result.charAt(m*i + p-1);
        }
        return answer;
    }
    
    public String convertN(int num, int n) {
        String result = "";
        while(true) {
            int r = num%n;
            if(r >= 10)
                result = (char)('A' + r%10) + result;
            else
                result = r + result;
            num = num/n;
            if(num == 0) break;
        }
        return result;
    }
}
*/

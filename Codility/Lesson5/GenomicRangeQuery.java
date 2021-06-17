// countT 배열은 없어도됨

class GenomicRangeQuery {
    public int[] solution(String S, int[] P, int[] Q) {
        int N = S.length();
        int[] countA = new int[N+1];
        int[] countC = new int[N+1];
        int[] countG = new int[N+1];
        int[] countT = new int[N+1];

        for(int i=0; i<N; i++) {
            switch(S.charAt(i)) {
            case 'A':
            countA[i+1]++; break;
            case 'C':
            countC[i+1]++; break;
            case 'G':
            countG[i+1]++; break;
            case 'T':
            countT[i+1]++; break;
            }
            countA[i+1] += countA[i];
            countC[i+1] += countC[i];
            countG[i+1] += countG[i];
            countT[i+1] += countT[i];
        }

        int M = P.length;
        int[] answer = new int[M];

        for(int i=0; i<M; i++) {
            if(countA[P[i]] != countA[Q[i]+1]) {
                answer[i] = 1;
            }
            else if(countC[P[i]] != countC[Q[i]+1]) {
                answer[i] = 2;
            }
            else if(countG[P[i]] != countG[Q[i]+1]) {
                answer[i] = 3;
            }
            else if(countT[P[i]] != countT[Q[i]]+1) {
                answer[i] = 4;
            }
        }
        return answer;
    }
}

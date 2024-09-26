import java.util.*;

class Solution {
    public int solution(int[] citations) {
        int res = 0;
        int N = citations.length;
        int M = 0;
        int[] arr = new int[10001];
        for (int x : citations) arr[x]++;
        for (int i = 0; i <= 10000; i++) {
            

                
                if (i <= N - M && i >= M) {
                    res = i;
                }
                
                M += arr[i];

        }
        return res;
    }
}
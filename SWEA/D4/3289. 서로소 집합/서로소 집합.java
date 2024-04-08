import java.io.BufferedReader;
import java.io.InputStreamReader;
 
public class Solution {
    private static StringBuilder sb = new StringBuilder();
     
    private static int N; // 원소 개수
    private static int[] parents; // 각 원소들이 어떤 집합(부모)에 속해있는지 기록
 
    // 서로소 집합 3가지 연산
    private static void makeSet() {
 
        parents = new int[N + 1];
 
        for (int i = 0; i < N; i++) {
            parents[i] = i;
        }
    }
 
    private static int find(int a) {
 
        if (parents[a] == a) return a;
        return parents[a] = find(parents[a]);
 
    }
 
    private static boolean union(int a, int b) {
        int aRoot = find(a);
        int bRoot = find(b);
         
        if (aRoot == bRoot) return false;
         
        parents[bRoot] = aRoot;
        return true;
    }
     
    public static void main(String[] args) throws Exception{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
         
        int T = Integer.parseInt(in.readLine());
        for (int TC = 1; TC <= T; TC++) {
            sb.append("#").append(TC).append(" ");
             
            String[] inp = in.readLine().split(" ");
            N = Integer.parseInt(inp[0]);
            int m = Integer.parseInt(inp[1]);
             
            makeSet();
             
            for (int i = 0; i < m; i++) {
                String[] tmp = in.readLine().split(" ");
                int x = Integer.parseInt(tmp[0]);
                int a = Integer.parseInt(tmp[1]);
                int b = Integer.parseInt(tmp[2]);
                 
                if (x == 0) {
                    union(a, b);
                     
                }
                else {
                    find(a);
                    find(b);
                    if (parents[a] == parents[b]) sb.append(1);
                    else sb.append(0);
                }
            }
             
            sb.append("\n");
        }
         
        System.out.println(sb);
         
    }
}
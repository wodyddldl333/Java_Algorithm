import java.io.*;
import java.util.*;

public class Main {
    private static StringBuilder sb = new StringBuilder();
    private static List<Integer> list;
    private static int[] game;

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(in.readLine());
        StringTokenizer st = null;
        int[] arr = new int[N];
        int max = 0;
        st = new StringTokenizer(in.readLine());
        for (int i = 0; i < N; i++) {
            max = Math.max(max, arr[i] = Integer.parseInt(st.nextToken()));
        }

        int[] res = new int[N];
        int[] p = new int[max + 1];

        for (int i = 0; i < N; i++) {
            p[arr[i]] = i + 1;
        }

        for (int x : arr) {
            for (int i = x * 2; i <= max; i += x) {
                if (p[i] != 0) {
                    res[p[i] -1]--;
                    res[p[x] -1]++;
                }
            }
        }
        for (int i = 0; i < N; i++) {
            sb.append(res[i]).append(" ");
        }

        System.out.println(sb);
    }
}
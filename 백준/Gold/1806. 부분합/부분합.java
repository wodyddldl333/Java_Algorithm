import java.io.*;
import java.util.*;

public class Main {
    static int N, M, arr[][];
    static int[][] deltas = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    public static void main(String[] args) throws Exception {
    	BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(in.readLine());
    	int N = Integer.parseInt(st.nextToken());
    	int S = Integer.parseInt(st.nextToken());
    	long[] arr = new long[N + 1];
    	st = new StringTokenizer(in.readLine());
    	for (int i = 1; i < N + 1; i++) {
    		long x = Long.parseLong(st.nextToken());
    		arr[i] = arr[i-1] + x;
    	}
    	if (arr[N] < S) {
    		System.out.println(0);
    		return;
    	}
    	
    	int x = 0;
    	int y = 0;
    	int min = Integer.MAX_VALUE;
    	
    	for (int i = 1; i < N + 1; i++) {
    		if (arr[i] >= S) {
    			y = i;
    			min = i;
    			break;
    		}
    	}
    	
    	while (y <= N) {
    		if (arr[y] - arr[x] >= S) {
    			long a = arr[y] - arr[x];
    			min = Math.min(y - x, min);
    			if (min == 1) {
    				System.out.println(1);
    	    		return;
    			}
    			x++;
    		} else {
    			y++;
    		}
    	}
    	
    	System.out.println(min);
    	
    }
}
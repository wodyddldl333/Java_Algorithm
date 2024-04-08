import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Solution {

	private static StringBuilder sb = new StringBuilder();
	private static int n, m, max, arr[], nums[];
	public static void main(String[] args) throws Exception {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		int T;
		T = Integer.parseInt(in.readLine());
		for (int test_case = 1; test_case <= T; test_case++) {
			sb.append("#" + test_case + " ");

			String[] inp = in.readLine().split(" ");
			n = Integer.parseInt(inp[0]);
			m = Integer.parseInt(inp[1]);
			nums = new int[2];
			max = 0;
			arr = new int[n];
			String[] tmp = in.readLine().split(" ");
			for (int i = 0; i < n; i++) {
				arr[i] = Integer.parseInt(tmp[i]);
			}
			
			combi(0, 0, 0);
			
			max = (max == 0) ? -1 : max;
			sb.append(max).append("\n");
			
		}

		System.out.println(sb);
	}
	
	
	private static void combi(int cnt, int start, int sum) { // 조합 이용
	    if (sum > m) {
	    	return;
	    }
		
		if(cnt == 2) {
			if (sum > max) max = sum;
	        return;
	    }


	    for(int i=start;i < n; i++) {
		    	int res = sum; // 임시 합계 저장 변수
	        res += arr[i]; // 선택한 수 저장
	        nums[cnt] = arr[i];
	        combi(cnt+1,i+1, res); // 현재 선택한수의 다음부터 선택하도록 시작점 주기 조절!
	    }    
	}
}
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	private static StringBuilder sb = new StringBuilder();
	private static int[][] arr;
	private static int result;
	private static int[][] lst;
	
	private static void dfs(int lev, int[][] res) {
		
		if (result == 1) return;
		
		if (lev == 15) {
			for (int j = 0; j < 6; j++) {
				for (int k = 0; k < 3; k++) {
					if (arr[j][k] != res[j][k]) return;
				}
			}
			result = 1;
			return;
		}
		
		res[lst[lev][0]][0] += 1;
		res[lst[lev][1]][2] += 1;
		dfs(lev + 1, res);
		res[lst[lev][0]][0] -= 1;
		res[lst[lev][1]][2] -= 1;
		
		res[lst[lev][0]][1] += 1;
		res[lst[lev][1]][1] += 1;
		dfs(lev + 1, res);
		res[lst[lev][0]][1] -= 1;
		res[lst[lev][1]][1] -= 1;
		
		res[lst[lev][0]][2] += 1;
		res[lst[lev][1]][0] += 1;
		dfs(lev + 1, res);
		res[lst[lev][0]][2] -= 1;
		res[lst[lev][1]][0] -= 1;
		
	}
	
	public static void main(String[] args) throws Exception{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		for (int x = 0; x < 4; x++) {
			arr = new int[6][3];
			int[][] res = new int[6][3];
			result = 0;
			String[] inp = in.readLine().split(" ");
			int idx = 0;
			for (int j = 0; j < 6; j++) {
				for (int k = 0; k < 3; k++) {
					arr[j][k] = Integer.parseInt(inp[idx++]);
				}
			}
			
			int index = 0;
			lst = new int[15][2];
			for (int i = 0; i < 6; i++) {
				for (int j = i + 1; j < 6; j++) {
					lst[index][0] = i;
					lst[index][1] = j;
					index++;
				}
			}
			
			dfs(0, res);
			sb.append(result).append(" ");
		}
		
		
		System.out.println(sb);
	}
}
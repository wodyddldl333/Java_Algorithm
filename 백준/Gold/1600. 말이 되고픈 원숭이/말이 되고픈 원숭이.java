import java.io.*;
import java.util.*;

public class Main {
	private static int K, N, M, arr[][];
	private static boolean[][][] visit;
	private static int[][] deltas = {{1,0}, {0,1}, {-1, 0}, {0, -1}};
	private static int[][] superjump = {{-1, -2}, {-2, -1}, {-2, 1}, {-1, 2}, {1, -2}, {2, -1}, {2, 1}, {1, 2}};
	
	private static class Monkey {
		int x;
		int y;
		int time;
		int hores;
		
		public Monkey(int x, int y, int time, int hores) {
			this.x = x;
			this.y = y;
			this.time = time;
			this.hores = hores;
		}
		
	}
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		K = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(in.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[M][N];
		visit = new boolean[M][N][K + 1];
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(in.readLine());
			for (int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int result = -1;
		
		Queue<Monkey> q = new LinkedList<>();
		visit[0][0][0] = true;
		
		q.add(new Monkey(0, 0, 0, 0));
		
		while (!q.isEmpty()) {
			Monkey curr = q.poll();
			
			if (curr.x == M - 1 && curr.y == N - 1) {
				result = curr.time;
				break;
			}
			
			for (int[] delta : deltas) {
				int nx = curr.x + delta[0];
				int ny = curr.y + delta[1];
				
				if (check(nx, ny) && !visit[nx][ny][curr.hores]) {
					visit[nx][ny][curr.hores] = true; 
					q.add(new Monkey(nx, ny, curr.time + 1, curr.hores));
				}
			}
			
			if (curr.hores >= K) continue;
			
			for (int[] delta : superjump) {
				int nx = curr.x + delta[0];
				int ny = curr.y + delta[1];
				
				if (check(nx, ny) && !visit[nx][ny][curr.hores + 1]) {
					visit[nx][ny][curr.hores + 1] = true; 
					q.add(new Monkey(nx, ny, curr.time + 1, curr.hores + 1));
				}
			}
		}
		
		System.out.println(result);
		
	}
	private static boolean check(int nx, int ny) {
		return nx >= 0 && nx < M && ny >= 0 && ny < N && arr[nx][ny] == 0;
	}
}
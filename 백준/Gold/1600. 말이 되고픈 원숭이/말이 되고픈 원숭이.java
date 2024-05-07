import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int W,H,K,ans;
	static int[][] map;
	static int[][] move = {{-1,0},{1,0},{0,1},{0,-1}};
	static int[][] horse = {{2,1},{-2,1},{2,-1},{-2,-1},{1,2},{1,-2},{-1,2},{-1,-2}};
	static boolean[][][] visited;

	public static void main(String[] args)throws Exception{

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		K = Integer.parseInt(in.readLine());

		StringTokenizer st = new StringTokenizer(in.readLine());

		W = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());

		map = new int[H][W];

		for(int i=0;i<H;i++) {
			st = new StringTokenizer(in.readLine());
			for(int j=0;j<W;j++) {
				map[i][j]=Integer.parseInt(st.nextToken());
			}
		}

		// TODO: 1. 일단 3차원 배열에서 작은 수가 앞으로 오면 메모리 절약
		visited = new boolean[H][W][K+1];

		ans = -1;

		bfs(0, 0);

		System.out.println(ans);

	}

	static void bfs(int starti,int startj) {

		Queue<int[]> q = new ArrayDeque<>();
		// TODO: 2. 클래스로 하는게 오히려 안헷갈릴 수 있을 듯
		q.offer(new int[] {starti, startj, 0, 0});
		visited[starti][startj][0]=true;


		while(!q.isEmpty()) {
			int[] tmp = q.poll();
			int nowi = tmp[0];
			int nowj = tmp[1];
			int k = tmp[2];
			int cnt = tmp[3];

			if(nowi==H-1 && nowj==W-1) {
				ans = cnt;
				break;
			}

			for(int i=0;i<4;i++) {

				int nexti = nowi +move[i][0];
				int nextj = nowj +move[i][1];

				if(!isIn(nexti,nextj)) continue;
				if(map[nexti][nextj]==1) continue;

				if(!visited[nexti][nextj][k]) {

					visited[nexti][nextj][k]=true;
					q.offer(new int[] {nexti,nextj,k,cnt+1});
				}
			}

			if(k < K) {

				for(int i=0;i<8;i++) {
					int nexti = nowi +horse[i][0];
					int nextj = nowj +horse[i][1];

					if(!isIn(nexti,nextj)) continue;
					if(map[nexti][nextj]==1) continue;

					if(!visited[nexti][nextj][k+1]) {
						visited[nexti][nextj][k+1]=true;
						q.offer(new int[] {nexti,nextj,k+1,cnt+1});
					}
				}
			}
		}

	}

	static boolean isIn(int a,int b) {
		return a>=0 && b>=0 && a<H && b<W;
	}
}
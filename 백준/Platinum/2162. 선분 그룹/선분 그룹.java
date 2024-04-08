import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	private static int[] parents, rank;
	
	private static int find(int a) {
		if (parents[a] == a) return a;
		return parents[a] = find(parents[a]);
	}
	
	private static boolean union(int a, int b) {
		int aRoot = find(a);
		int bRoot = find(b);
		
		if (aRoot == bRoot) return false;
		
		if (rank[aRoot] > rank[bRoot]) {
			parents[bRoot] = aRoot;
		}
		else {
			parents[aRoot] = bRoot;
			if (rank[aRoot] == rank[bRoot]) rank[bRoot]++;
		}
		return true;
	}
	
	private static class Coor {
		long x1, y1, x2, y2;
		public Coor(long x1, long y1, long x2, long y2) {
			this.x1 = x1;
			this.y1 = y1;
			this.x2 = x2;
			this.y2 = y2;
		}
	}
	private static class Point {
		long x, y;
		public Point(long x, long y) {
			this.x = x;
			this.y = y;
		}
	}
	
	public static void main(String[] args) throws Exception{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		
		Coor[] coor = new Coor[N];
		StringTokenizer st;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine());
			long x1 = Long.parseLong(st.nextToken());
			long y1 = Long.parseLong(st.nextToken());
			long x2 = Long.parseLong(st.nextToken());
			long y2 = Long.parseLong(st.nextToken());
			coor[i] = new Coor(x1, y1, x2, y2);
		}
		
		parents = new int[N];
		rank = new int[N];
		for (int i = 0; i < N; i++) parents[i] = i;
		
		for (int i = 0; i < N - 1; i++) {
			for (int j = i + 1; j < N; j++) {
				boolean flag = isCross(coor[i], coor[j]);
				if (flag) union(i, j);
			}
		}
		
		int[] count = new int[N];
		
		for (int i = 0; i < N; i++) count[find(i)]++;
		
		int max = -1;
		int cnt = 0;
		
		for (int i = 0; i < N; i++) {
			if (count[i] != 0) cnt++;
			max = Math.max(max, count[i]);
		}
		
		System.out.println(cnt);
		System.out.println(max);
	
	}

	private static boolean isCross(Coor a, Coor b) {
		
		int ccw_123 = ccw(new Point(a.x1, a.y1), new Point(a.x2, a.y2), new Point(b.x1, b.y1));
		int ccw_124 = ccw(new Point(a.x1, a.y1), new Point(a.x2, a.y2), new Point(b.x2, b.y2));
		int ccw_341 = ccw(new Point(b.x1, b.y1), new Point(b.x2, b.y2), new Point(a.x1, a.y1)); 
		int ccw_342 = ccw(new Point(b.x1, b.y1), new Point(b.x2, b.y2), new Point(a.x2, a.y2));
		
		if (ccw_123 * ccw_124 == 0 && ccw_341 * ccw_342 == 0) {
			if (check(a, b)) return true;
			else return false;
		}
		
		if (ccw_123 * ccw_124 <= 0 && ccw_341 * ccw_342 <= 0) return true;

		return false;
	}
	

	private static int ccw(Point a, Point b, Point c) {
		long res = (a.x*b.y + b.x*c.y + c.x*a.y) - (a.y*b.x + b.y*c.x + c.y*a.x); 
		if (res > 0) return 1;
		else if (res < 0) return -1;
		else return 0;
	}
	
	private static boolean check(Coor a, Coor b) {
		return Math.min(a.x1, a.x2) <= Math.max(b.x1, b.x2) &&
			   Math.min(b.x1, b.x2) <= Math.max(a.x1, a.x2) &&
			   Math.min(a.y1, a.y2) <= Math.max(b.y1, b.y2) &&
			   Math.min(b.y1, b.y2) <= Math.max(a.y1, a.y2);
	}
}
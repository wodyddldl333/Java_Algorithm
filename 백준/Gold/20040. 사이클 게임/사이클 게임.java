import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	private static int rank[], parents[];
	
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
		} else {
			parents[aRoot] = bRoot;
			if (rank[aRoot] == rank[bRoot]) rank[bRoot]++;
		}
		return true;
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		parents = new int[N];
		rank = new int[N];
		for (int i = 0; i < N; i++) parents[i] = i;
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(in.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			if(!union(a, b)) {
				System.out.println(i + 1);
				return;
			}
		}
		System.out.println(0);
	}
}
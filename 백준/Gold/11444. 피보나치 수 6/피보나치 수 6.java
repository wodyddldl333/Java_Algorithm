import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	private static final long D =1000000007;
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		long N = Long.parseLong(in.readLine());
		if (N <= 1) { // 0과 1 예외처리
			System.out.println(N);
			return;
		}
		long[][] base = {{1, 1}, {1, 0}};
		long[][] result = {{1, 0}, {0, 1}}; // unit matrix
		
		result = fibo(base, N - 1);
		
		System.out.println(result[0][0]);
	}

	private static long[][] fibo(long[][] base, long N) {
		if (N == 1) return base;
		
		long tmp[][] = fibo(base, N / 2);
		
		tmp = mutiplyMatrix(tmp, tmp);
		
		if (N % 2 == 1) {
			tmp = mutiplyMatrix(tmp, new long[][] {{1, 1}, {1, 0}});
		}
		
		return tmp;
	}
	
	private static long[][] mutiplyMatrix(long[][] a, long[][] b) {
		int N = a.length;
		long[][] res = new long[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				for (int k = 0; k < N; k++) {
					res[i][j] += a[i][k] * b[k][j];
					res[i][j] %= D;
				}
			}
		}
		return res;
	}
}
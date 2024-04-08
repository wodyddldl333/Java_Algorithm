import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;

public class Main {
	private static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		int[] arr =  new int[N];
		int[] C = new int[N];
		int[] path = new int[N];
		String[] inp = in.readLine().split(" ");
		for (int i = 0; i < N; i++) arr[i] = Integer.parseInt(inp[i]);
		
		int size = 0;
		for (int i = 0; i < N; i++) {

			int pos = Arrays.binarySearch(C, 0, size, arr[i]);
			if (pos >= 0) continue; 

			int insertPos = Math.abs(pos) - 1;  
			C[insertPos] = arr[i];
			path[i] = insertPos + 1;
			if (insertPos == size) {
				size++;
			}
		}

		Stack<Integer> stack = new Stack<>();
		sb.append(size).append("\n");
		for (int i = N - 1; i >= 0; i--) {
			if (path[i] == size) {
				stack.push(arr[i]);
				size--;
			}
			if (size == 0) break;
		}
		
		while(!stack.isEmpty()) {
			sb.append(stack.pop()).append(" ");
		}
		
		System.out.println(sb);
	}
}

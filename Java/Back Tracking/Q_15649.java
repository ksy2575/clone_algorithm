package baekjoon;

import java.util.Arrays;
import java.util.Scanner;

public class Q_15649 {

	static int[] arr;
	static int m;
	static int n;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		arr = new int[m];
		boolean[] visited = new boolean[n+1];
		func(visited, 0);
	}

	private static void func(boolean[] visited, int cnt) {
		if(cnt == m) {
			System.out.println(Arrays.toString(arr).replace(",", "").replace("[", "").replace("]", ""));
			return;
		}
		for(int i = 1;i<=n;i++) {
			if(!visited[i]) {
				visited[i] = true;
				arr[cnt] = i;
				func(visited, cnt+1);
				visited[i] = false;
			}
		}
		
	}

}

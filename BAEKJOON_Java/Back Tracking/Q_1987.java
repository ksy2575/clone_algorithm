package baekjoon;

import java.util.ArrayList;
import java.util.Scanner;

public class Q_1987 {

	static char[][] arr = null;
	static int[] di = {0, 0, 1, -1};
	static int[] dj = {1, -1, 0, 0};
	static int r;
	static int c;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		r = sc.nextInt();
		c = sc.nextInt();
		arr = new char[r][c];
		for (int i = 0; i < r; i++) {
			String s = sc.next();
			for (int j = 0; j < c; j++) {
				arr[i][j] = s.charAt(j);
			}
		}
		ArrayList<Character> startList = new ArrayList<Character>();
		startList.add(arr[0][0]);
		int ans = dfs(0, 0, startList);
		System.out.println(ans);
	}

	private static int dfs(int i, int j, ArrayList<Character> visited) {
//		System.out.println(visited);
		int temp = 0;
		for (int k = 0; k < 4; k++) {
			int ni = i+di[k];
			int nj = j+dj[k];
			if(ni >= 0 && ni < r && nj >= 0 && nj < c) {
				if(!visited.contains(arr[ni][nj])) {
					visited.add(arr[ni][nj]);
					temp = Math.max(temp, dfs(ni, nj, visited));
					visited.remove(Character.valueOf(arr[ni][nj]));
				}
			}
		}
		return Math.max(temp, visited.size());
	}
}

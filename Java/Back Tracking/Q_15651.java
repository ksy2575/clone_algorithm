package baekjoon.BackTracking;

import java.util.Scanner;

public class Q_15651 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		System.out.println(backtracking(n, m, 1, ""));
	}

	static String backtracking(int n, int m, int curr, String s) {
		StringBuilder sb = new StringBuilder();
		if(m == 0) {
			return s.trim()+"\n";
		}
		else for(int i=1;i<=n;i++) {
			sb.append(backtracking(n, m-1, i+1, s+" "+i));
		}
		return sb.toString();
	}

}

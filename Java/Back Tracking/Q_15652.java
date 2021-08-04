package baekjoon;

import java.util.Scanner;

public class Q_15652 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		System.out.println(backtracking(n, m, 2, ""));
	}

	static String backtracking(int n, int m, int curr, String s) {
		StringBuilder sb = new StringBuilder();
		if(m == 0) {
			return s.trim()+"\n";
		}
		else for(int i=curr-1;i<=n;i++) {
			sb.append(backtracking(n, m-1, i+1, s+" "+i));
		}
		return sb.toString();
	}

}

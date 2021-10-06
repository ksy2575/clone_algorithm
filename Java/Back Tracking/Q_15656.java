package baekjoon.BackTracking;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Q_15656 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		List<Integer> list = new ArrayList<Integer>();
		for(int i=0;i<n;i++) {
			list.add(sc.nextInt());
		}
		Collections.sort(list);
		System.out.println(backtracking(n, m, 1, "", list));
	}

	static String backtracking(int n, int m, int curr, String s, List<Integer> list) {
		StringBuilder sb = new StringBuilder();
		if(m == 0) {
			return s.trim()+"\n";
		}
		else {
			for(int i=1;i<=n;i++) {
				sb.append(backtracking(n, m-1, i+1, s+" "+list.get(i-1), list));
			}
		}
		return sb.toString();
			
	}

}

package baekjoon.BackTracking;

import java.util.ArrayList;
import java.util.Scanner;

public class Q_15650 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		backtracking(n, m, 1, new ArrayList<Integer>());
	}

	static void backtracking(int n, int m, int curr, ArrayList<Integer> list) {
		if(m == 0) {
			System.out.println(list.toString().replace(",", "").replace("[", "").replace("]", ""));
			return;
		}
		for(int i=curr;i<=n;i++) {
			if(!list.contains(i)) {
				ArrayList<Integer> tempList = new ArrayList<Integer>();
				tempList.addAll(list);
				tempList.add(i);
				backtracking(n, m-1, i+1, tempList);
			}
			
		}
	}

}

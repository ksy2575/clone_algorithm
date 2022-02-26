package baekjoon.BackTracking;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Q_15655 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		List<Integer> list = new ArrayList<Integer>();
		for(int i=0;i<n;i++) {
			list.add(sc.nextInt());
		}
		Collections.sort(list);
		backtracking(n, m, 1, new ArrayList<Integer>(), list);
	}

	static void backtracking(int n, int m, int curr, List<Integer> ansList, List<Integer> list) {
		if(m == 0) {
			System.out.println(ansList.toString().replace(",", "").replace("[", "").replace("]", ""));
			return;
		}
		else for(int i=curr;i<=n;i++) {
			if(!ansList.contains(list.get(i-1))) {
				ArrayList<Integer> tempList = new ArrayList<Integer>();
				tempList.addAll(ansList);
				tempList.add(list.get(i-1));
				backtracking(n, m-1, i+1, tempList, list);
			}
			
		}
	}

}

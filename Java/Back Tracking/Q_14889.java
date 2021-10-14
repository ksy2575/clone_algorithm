package baekjoon;

import java.util.HashSet;
import java.util.Scanner;

public class Q_14889 {
	//스타트와 링크
	static int n;
	static HashSet<String> sets = new HashSet<String>();
	static int[][] arr;
	static int minVal = Integer.MAX_VALUE;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		arr = new int[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				arr[i][j] = sc.nextInt();
			}
		}
		HashSet<Integer> set2 = new HashSet<Integer>();
		for (int i = 0; i < n; i++) {
			set2.add(i);
		}
		
		combi(0, 0, new HashSet<Integer>(), set2);
		System.out.println(minVal);
	}

	private static void combi(int curr, int k, HashSet<Integer> set1, HashSet<Integer> set2) {
//		System.out.println(curr + " " + set1);
		if(n-curr+k< n/2) {
			return;
		}
		if(k == n/2) {
			if(!sets.contains(set1.toString()) || !sets.contains(set2.toString())) {
				sets.add(set1.toString());
				sets.add(set2.toString());
				minVal = Math.min(minVal, Math.abs(findScore(set1) - findScore(set2)));
			}
			return;
		}
		combi(curr+1, k, set1, set2);
		set1.add(curr);
		set2.remove(curr);
		combi(curr+1, k+1, set1, set2);
		set2.add(curr);
		set1.remove(curr);
	}

	private static int findScore(HashSet<Integer> set) {
		int temp = 0;
		for (Integer i : set) {
			for (Integer j : set) {
				if(i==j) continue;
				temp += arr[i][j];
			}
		}
		return temp;
	}

}

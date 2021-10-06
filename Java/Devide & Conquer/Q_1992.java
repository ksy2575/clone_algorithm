package baekjoon.DevideAndConquer;

import java.util.Arrays;
import java.util.Scanner;

public class Q_1992 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		char[][] arr = new char[n][n];
		for (int i = 0; i < n; i++) {
			arr[i] = sc.next().toCharArray();
		}
		String ans = initString(devide(arr, 0, 0, n, n));
		System.out.println(ans);
	}

	private static String devide(char[][] arr, int si, int sj, int ei, int ej) {
		if(si==ei-1) {
			return Character.toString(arr[si][sj]);
		}
		
		String d1 = devide(arr, si, sj, (si+ei)/2, (sj+ej)/2);
		String d2 = devide(arr, si, (sj+ej)/2, (si+ei)/2, ej);
		String d3 = devide(arr, (si+ei)/2, sj, ei, (sj+ej)/2);
		String d4 = devide(arr, (si+ei)/2, (sj+ej)/2, ei, ej);
		
		String retString = initString(d1) + initString(d2) + initString(d3) + initString(d4);
		return retString;
	}

	private static String initString(String d) {
		if(d.length()==1) {
			return d;
		}
		if(d.equals("1111")) {
			return "1";
		}else if(d.equals("0000")){
			return "0";
		}else {
			return "(" + d + ")";
		}
	}
}

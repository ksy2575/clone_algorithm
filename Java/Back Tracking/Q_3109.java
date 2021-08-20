package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Q_3109 {
	static char[][] arr = null;
	static int[] columns = null;
	static int r = 0;
	static int c = 0;
	static int ans = 0;
	static int minpath = Integer.MAX_VALUE;
	static boolean flag = false;
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		arr = new char[r][c];
		columns = new int[c];
		for (int i = 0; i < r; i++) {
			arr[i] = bf.readLine().toCharArray();
			for (int j = 0; j < arr[0].length; j++) {
				if(arr[i][j]=='.') {
					columns[j]++;
				}
			}
		}
//		print(arr);
		for (int i = 1; i < columns.length-1; i++) {
			minpath = Math.min(minpath, columns[i]);
		}
		for (int i = 0; i < r; i++) {
			flag = false;
			findPath(i, 0);
			if(ans >= minpath) break;
		}
		System.out.println(ans);
	}
	
	private static void findPath(int i, int j) {
		if(j==c-1) {
			ans++;
			flag = true;
			return;
		}
		for (int ii = -1; ii < 2; ii++) {
			if(!flag && i+ii>=0 && i+ii < r && arr[i+ii][j+1] != 'x' && arr[i+ii][j+1] != 'o') {
				arr[i+ii][j+1] = 'o';
				findPath(i+ii, j+1);
			}
		}
	}
	
	private static void print(char[][] arr2) {
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				System.out.print(arr[i][j]);
			}
			System.out.println();
		}
		System.out.println();
	}
}

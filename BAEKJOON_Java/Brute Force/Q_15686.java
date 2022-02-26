package baekjoon;

import java.util.ArrayList;
import java.util.Scanner;

public class Q_15686 {
	static ArrayList<ArrayList<Integer>> combinations = new ArrayList<ArrayList<Integer>>();
	static ArrayList<int[]> chickenList = new ArrayList<int[]>();
	static ArrayList<int[]> houseList = new ArrayList<int[]>();
	static int min = Integer.MAX_VALUE;
	static int n = 0;
	static int m = 0;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m= sc.nextInt();

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				int curr = sc.nextInt();
				if(curr == 1) {
					houseList.add(new int[] {i, j});
				}
				if(curr == 2) {
					chickenList.add(new int[] {i, j});
				}
			}
		}
		
		combi(0, 0, new ArrayList<Integer>(), chickenList.size());
		for(ArrayList<Integer> cm:combinations) {
			distance(cm);
		}
		System.out.println(min);
	}
	
	private static void distance(ArrayList<Integer> cm) {
		int sum = 0;
		for (int i = 0; i < houseList.size(); i++) {
			int hy = houseList.get(i)[0];
			int hx = houseList.get(i)[1];

			int temp = Integer.MAX_VALUE;
			for (int j = 0; j < m; j++) {
				int cy = chickenList.get(cm.get(j))[0];
				int cx = chickenList.get(cm.get(j))[1];
				
				temp = Math.min(temp, Math.abs(cy-hy) + Math.abs(cx-hx));
			}
			sum += temp;
		}
		
		min = Math.min(min, sum);
	}

	private static void combi(int i, int k, ArrayList<Integer> temp, int len) {
		if(k==m) {
			combinations.add(new ArrayList<Integer>(temp));
			return;
		}
		if(i > len) {
			return;
		}
		for (int j = i; j < len; j++) {
				temp.add(j);
				combi(j+1, k+1, temp, len);
				temp.remove(temp.size()-1);
			
		}
	}
}
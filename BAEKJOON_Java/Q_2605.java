package baekjoon;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Q_2605 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		List<Integer> list = new ArrayList<Integer>();
		for (int i = 0; i < n; i++) {
			int curr = sc.nextInt();
			list.add(i-curr, i+1);
		}

		System.out.println(list.toString().replace("[", "").replace("]", "").replace(",", ""));
	}

}

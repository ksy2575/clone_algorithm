package baekjoon.Greedy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Q_11399 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n=sc.nextInt();
		List<Integer> list = new ArrayList<Integer>();
		for(int i=0;i<n;i++) {
			list.add(sc.nextInt());
		}
		Collections.sort(list);
		int wait = 0;
		int ans = 0;
		for(int i=0;i<n;i++) {
			wait += list.get(i);
			ans += wait;
		}
		System.out.println(ans);
	}

}

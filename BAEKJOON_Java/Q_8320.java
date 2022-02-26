package baekjoon;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Q_8320 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int cnt = 0;
		HashMap<Integer, ArrayList<Integer>> map = new HashMap<Integer, ArrayList<Integer>>();
		for(int i=1;i<=Math.sqrt(n);i++) {
			map.put(i, new ArrayList<Integer>());
			for(int j=i;j<=n;j++) {
				if(i*j<=n) {
					if(map.get(i).contains(j)) {
						continue;
					}else {
						cnt++;
						map.get(i).add(j);
					}
				}
			}
		}
		System.out.println(cnt);
//		System.out.println(map.toString());
	}

}

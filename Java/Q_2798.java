package baekjoon;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Q_2798 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n=sc.nextInt(), m=sc.nextInt();
		List<Integer> list = new ArrayList<Integer>();
		
		for(int i=0;i<n;i++) {
			list.add(sc.nextInt());
		}
		int max = -1;
		for(int i=0;i<n-2;i++) {
			for(int j=i+1;j<n-1;j++) {
				for(int k=j+1;k<n;k++) {
					int curr = list.get(i)+list.get(j)+list.get(k);
					if(curr <= m) {
						max = Math.max(max, curr);
					}
				}
			}
		}
		System.out.println(max);
	}
}

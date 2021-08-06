package baekjoon;

import java.util.Scanner;

public class Q_2941 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.next();
		String[] strs = {"c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z="};
		int cnt = 0;
		for(int i=0;i<strs.length;i++) {
			while(s.contains(strs[i])) {
				s = s.replaceFirst(strs[i], " ");
				cnt++;
			}
//			System.out.println(s);
		}
		
		System.out.println(cnt+s.replace(" ", "").length());
	}

}

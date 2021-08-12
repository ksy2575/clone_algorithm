package baekjoon;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Q_2164 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		Queue<Integer> q = new LinkedList<Integer>();
		for(int i=1;i<=n;i++) {
			int ans = 0;
			q.add(i);
		}
		while(q.size()>1) {
			q.poll();
			q.add(q.poll());
		}
		System.out.println(q.peek());
	}

}

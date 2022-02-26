package baekjoon.Queue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Q_2477 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		LinkedList<Integer> q = new LinkedList<Integer>();
		int x = 0;
		int y = 0;
		for (int i = 0; i < 6; i++) {
			int dir = sc.nextInt();
			int len = sc.nextInt();
			q.offer(len);
			if(dir == 1 || dir == 2) {
				x = Math.max(x, len);
			}else {
				y = Math.max(y, len);
			}
		}
		while(true) {
			if((q.peek()==x || q.peek()==y)
					&& (q.get(q.size()-1)==x || q.get(q.size()-1)==y)) {
				q.offerFirst(q.pollLast());
				break;
			}
			q.offerFirst(q.pollLast());
		}
		int ans = q.poll()*q.poll();
		q.poll();
		ans -= q.poll()*q.poll();
		System.out.println(ans*n);
	}//  30 60 20 100 50 160

}

package queue;

import java.util.LinkedList;

public class Solution_프린터 {
	static class Point{
		int x;
		int y;
		public Point(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
		@Override
		public String toString() {
			return x + ":" + y;
		}
	}
	public int solution(int[] priorities, int location) {
        int answer = 1;
        LinkedList<Point> q1 = new LinkedList<Point>();
        for (int i = 0; i < priorities.length; i++) {
			q1.add(new Point(priorities[i], i));
		}
        outer : while(true) {
        	Point curr = q1.peek();
        	for (int i = 0; i < q1.size(); i++) {
				if(q1.get(i).x > curr.x) {
					q1.add(q1.poll());
					continue outer;
				}
			}
        	if(curr.y == location) {
        		break;
        	}else {
        		q1.poll();
        		answer++;
        	}
        }
        return answer;
    }
	
	public static void main(String[] args) {
		Solution_프린터 solution = new Solution_프린터();
//		solution.solution(new int[] {2, 1, 3, 2}, 2);
		solution.solution(new int[] {1, 1, 9, 1, 1, 1}, 0);
	}

}

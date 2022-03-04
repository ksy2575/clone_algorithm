package heap;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution_이중우선순위큐 {
	
	public int[] solution(String[] operations) {
        int[] answer = {0, 0};
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
        PriorityQueue<Integer> rq = new PriorityQueue<Integer>(Comparator.reverseOrder());
        for(String op : operations) {
        	String[] curr = op.split(" ");
        	char cmd = curr[0].charAt(0);
        	int n = Integer.parseInt(curr[1]);
        	if(cmd == 'I') {
        		pq.add(n);
        		rq.add(n);
        	}else if(!pq.isEmpty()) {
        		if(n == 1) {
            		pq.remove(rq.poll());
            	}else {
            		rq.remove(pq.poll());
            	}
        	}
        }
        if(pq.isEmpty()) return answer;
        else {
        	answer[0] = rq.poll();
        	answer[1] = pq.poll();
        }
        return answer;
    }
	
	public static void main(String[] args) {
		Solution_이중우선순위큐 solution = new Solution_이중우선순위큐();
		System.out.println(solution.solution(new String[] {"I 16","D 1"}));
//		System.out.println(solution.solution(new String[] {"I 7","I 5","I -5","D -1"}));
	}
}

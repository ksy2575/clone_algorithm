package queue;

import java.util.LinkedList;

public class Solution_다리를_지나는_트럭 {
	public int solution(int bridge_length, int weight, int[] truck_weights) {
        int time = 0;
        int cnt = truck_weights.length;
        int curr_weight = 0;
        LinkedList<Integer> bridge = new LinkedList<Integer>();
        LinkedList<Integer> list = new LinkedList<Integer>();
        for (int i = 0; i < bridge_length; i++) {
        	bridge.add(0);
		}
        for (int i = 0; i < truck_weights.length; i++) {
			list.add(truck_weights[i]);
		}
        while(cnt > 0) {
        	time++;
        	int popped = bridge.poll();
        	curr_weight -= popped;
        	if(list.size() != 0 && curr_weight + list.peek() <= weight) {
        		int next = list.poll();
        		bridge.add(next);
        		curr_weight += next;
        	}else {
        		bridge.add(0);
        	}
        	if(popped > 0) cnt--;
        }
        return time;
    }
	
	public static void main(String[] args) {
		Solution_다리를_지나는_트럭 solution = new Solution_다리를_지나는_트럭();
		System.out.println(solution.solution(2, 10, new int[] {7, 4, 5, 6}));
		System.out.println(solution.solution(100, 100, new int[] {10,10,10,10,10,10,10,10,10,10}));
	}

}

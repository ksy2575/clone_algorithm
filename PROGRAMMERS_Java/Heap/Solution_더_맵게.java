package heap;

import java.util.PriorityQueue;

public class Solution_더_맵게 {
	
	public int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
        for(int i : scoville) {
        	pq.add(i);
        }
        while(pq.size() > 1) {
        	if(pq.peek() >= K) {
        		return answer;
        	}
        	int a = pq.poll();
        	int b = pq.poll();
        	pq.add(a + b*2);
        	answer++;
        }
        return pq.peek()>=K?answer:-1;
	}
	
	public static void main(String[] args) {
		Solution_더_맵게 solution = new Solution_더_맵게();
		System.out.println(solution.solution(new int[] {1, 1, 100}, 7)+"");
	}
}

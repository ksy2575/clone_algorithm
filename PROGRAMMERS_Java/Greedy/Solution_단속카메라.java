package gready;

import java.util.PriorityQueue;

public class Solution_단속카메라 {
	static class Car implements Comparable<Car>{
		int s = 0;
		int e = 0;
		Car(int s, int e){
			this.s = s;
			this.e = e;
		}
		@Override
		public int compareTo(Car c) {
			if(this.e == c.e) return this.s < c.s?-1:1;
			return this.e < c.e?-1:1;
		}
		@Override
		public String toString() {
			return this.s + " " + this.e;
		}
	}
	public int solution(int[][] routes) {
        int answer = 0;
        PriorityQueue<Car> pq = new PriorityQueue<Car>();
        for(int[] route : routes) {
        	pq.add(new Car(route[0], route[1]));
        }
        while(!pq.isEmpty()) {
            int i = pq.poll().e;
        	while(!pq.isEmpty()) {
        		if(pq.peek().s <= i) {
        			pq.poll();
        		}else break;
        	}
        	answer++;
        }
        
        return answer;
    }
	public static void main(String[] args) {
		Solution_단속카메라 solution = new Solution_단속카메라();
		System.out.println(solution.solution(new int[][] {{-20,-15}, {-14,-5}, {-18,-13}, {-5,-3}}));
	}

}

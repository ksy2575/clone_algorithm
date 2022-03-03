package heap;

import java.util.PriorityQueue;

public class Solution_디스크_컨트롤러 {
	
	static class Job implements Comparable<Job>{
		int a;
		int b;
		Job(int a, int b){
			this.a = a;
			this.b = b;
		}
		
		@Override
		public int compareTo(Job j) {
			if(this.a < j.a) return -1;
			else if(this.a == j.a) return this.b-j.b;
			return 1;
		}
		@Override
		public String toString() {
			return "[" + this.a + ", " + this.b + "]";
		}
	}
	static class ReadyJob implements Comparable<ReadyJob>{
		int a;
		int b;
		ReadyJob(int a, int b){
			this.a = a;
			this.b = b;
		}
		
		@Override
		public int compareTo(ReadyJob j) {
			if(this.b < j.b) return -1;
			return 1;
		}
		@Override
		public String toString() {
			return "[" + this.a + ", " + this.b + "]";
		}
	}
	
	public int solution(int[][] jobs) {
        int answer = 0;
        int size = jobs.length;
        int time = 0;
        PriorityQueue<Job> pq = new PriorityQueue<Job>();
        PriorityQueue<ReadyJob> readyQ = new PriorityQueue<ReadyJob>();
        
        for(int[] job : jobs) {
        	pq.add(new Job(job[0], job[1]));
        }
        
        while(!pq.isEmpty() || !readyQ.isEmpty()) {
        	System.out.println(time);
        	System.out.println(pq +" 1 "+ readyQ);
        	while(!pq.isEmpty()) {
        		if(pq.peek().a <= time) {
        			Job curr = pq.poll();
        			ReadyJob next = new ReadyJob(curr.a, curr.b);
        			readyQ.add(next);
        		}else {
        			if(readyQ.isEmpty()) {
        				time = pq.peek().a;
        			}else {
            			break;
        			}
        		}
        	}
        	System.out.println(pq +" 2 "+ readyQ);
        	if(!readyQ.isEmpty()) {
        		ReadyJob next = readyQ.poll();
        		answer += time - next.a + next.b;
        		time += next.b;
        	}else {
        		if(!pq.isEmpty()) {
            		break;
            	}else {
            		time = pq.peek().a;
            	}
        	}
        	System.out.println(pq +" 3 "+ readyQ);
        }
        return answer/size;
    }
	
	public static void main(String[] args) {
		Solution_디스크_컨트롤러 solution = new Solution_디스크_컨트롤러();
//		System.out.println(solution.solution(new int[][] {{0, 3}, {1, 9}, {2, 6}})+"dd");
//		System.out.println(solution.solution(new int[][] {{0, 9}, {0, 4}, {0, 5}, {0, 7}, {0, 3}})+"dd");
		System.out.println(solution.solution(new int[][] {{0, 3}, {4, 6}})+"dd");
//		System.out.println(solution.solution(new int[][] {{0, 3}, {1, 9}, {2, 6}})+"dd");
//		System.out.println(solution.solution(new int[][] {{0, 3}, {1, 9}, {2, 6}})+"dd");
//		System.out.println(solution.solution(new int[][] {{0, 3}, {1, 9}, {2, 6}})+"dd");
	}
}

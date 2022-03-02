package sort;

import java.util.PriorityQueue;

public class Solution_가장_큰_수 {
	static class Number implements Comparable<Number>{
		String n;
		String nnn;
		Number(int n){
			this.n = n+"";
			this.nnn = this.n+this.n+this.n;
		}
		
		@Override
		public int compareTo(Number n) {
			return -this.nnn.compareTo(n.nnn);
		}
	}
	public String solution(int[] numbers) {
		StringBuffer sb = new StringBuffer();
		PriorityQueue<Number> pq = new PriorityQueue<Number>();
        for(int num : numbers) {
        	pq.add(new Number(num));
        }
        while(!pq.isEmpty()) {
        	sb.append(pq.poll().n);
        }
        if(sb.toString().charAt(0)=='0') return "0";
        return sb.toString();
    }
	
	public static void main(String[] args) {
		Solution_가장_큰_수 solution = new Solution_가장_큰_수();
//		System.out.println(solution.solution(new int[] {6, 10, 2}));
//		System.out.println(solution.solution(new int[] {3, 30, 34, 5, 9}));
		System.out.println(solution.solution(new int[] {0, 0, 0}));
	}

}

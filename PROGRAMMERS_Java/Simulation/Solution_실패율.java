package simulation;

import java.util.Arrays;
import java.util.PriorityQueue;

//simulation, sort
public class Solution_실패율 {
	static class Stage implements Comparable<Stage>{
		int n;
		double fail;
		public Stage(int n, double fail) {
			this.n = n;
			this.fail = fail;
		}
		@Override
		public int compareTo(Stage s) {
			if(this.fail == s.fail) return this.n < s.n? -1 : 1;
			return this.fail > s.fail? -1 : 1;
		}
		@Override
		public String toString() {
			return "Stage [n : " + n + ", fail : " + fail + "]";
		}
		
	}
	public int[] solution(int N, int[] stages) {
        int[] answer = new int[N];
        PriorityQueue<Stage> pq = new PriorityQueue<Stage>();
        Arrays.sort(stages);
        
        int cnt = 0;
        int total = stages.length;
        int curr = 1;
        for(int i : stages) {
        	if(i == curr) {
        		cnt++;
        		continue;
        	}
        	if(i != curr) {
        		if(cnt == 0) {
        			while(curr < i) {
            			pq.add(new Stage(curr, 0));
            			curr++;
        			}
        			cnt = 1;
        		}else {
        			pq.add(new Stage(curr, (double)cnt/total));
        			curr++;
        			total -= cnt;
        			while(curr < i) {
            			pq.add(new Stage(curr, 0));
            			curr++;
        			}
        			cnt = 1;
        			curr = i;
        		}
        	}
        }
        if(curr <= N) {
			pq.add(new Stage(curr, (double)cnt/total));
			curr++;
			while(curr <= N) {
    			pq.add(new Stage(curr, 0));
    			curr++;
			}
        }
        for(int i = 0; i < answer.length; i++) {
        	answer[i] = pq.poll().n;
        }
        return answer;
    }
	
	public static void main(String[] args) {
		Solution_실패율 solution = new Solution_실패율();
		System.out.println(solution.solution(5, new int[] {2, 1, 2, 6, 2, 4, 3, 3})); // 3 4 2 1 5
	}
}

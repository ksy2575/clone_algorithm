package brute_force;

import java.util.PriorityQueue;

//Brute Force
public class Solution_모음사전 {
	static PriorityQueue<String> pq = new PriorityQueue<String>();
	public int solution(String word) {
        char[] arr = new char[] {'A', 'E', 'I', 'O', 'U'};
        for(int i = 1; i <= 5; i++) {
        	combi(arr, i, "");
        }
        int answer = 1;
        while(true) {
        	if(pq.poll().equals(word)) break;
        	answer++;
        }
        return answer;
    }
	
	private void combi(char[] arr, int cnt, String string) {
		if(cnt == 0) {
			pq.add(string);
			return;
		}
		for(int i = 0; i < 5; i++) {
			combi(arr, cnt-1, string+arr[i]);
		}
	}
	
	public static void main(String[] args) {
		Solution_모음사전 solution = new Solution_모음사전();
		System.out.println(solution.solution("AAAAE"));
//		System.out.println(solution.solution("EIO"));
	}
}

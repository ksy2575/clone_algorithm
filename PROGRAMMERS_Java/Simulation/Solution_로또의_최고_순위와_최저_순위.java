package simulation;

//simulation
public class Solution_로또의_최고_순위와_최저_순위 {
	public int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = {0, 0};
        int[] wins = {6, 6, 5, 4, 3, 2, 1};
        int zero = 0;
        int base = 0;
        for(int curr : lottos) {
        	if(curr == 0) {
        		zero++;
        		continue;
        	}
        	for(int i : win_nums) {
        		if(i == curr) {
        			base++;
        			continue;
        		}
        	}
        }
        System.out.println(zero + " " + base);
        answer[0] = wins[base + zero];
        answer[1] = wins[base];
        return answer;
    }
	public static void main(String[] args) {
		Solution_로또의_최고_순위와_최저_순위 solution = new Solution_로또의_최고_순위와_최저_순위();
		System.out.println(solution.solution(new int[] {44, 1, 0, 0, 31, 25}
		, new int[] {31, 10, 45, 1, 6, 19})); // 3 5
	}
}

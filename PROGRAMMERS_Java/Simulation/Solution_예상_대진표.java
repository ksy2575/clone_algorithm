package simulation;

//Simulation
public class Solution_예상_대진표 {
	public int solution(int n, int a, int b)
    {
        int answer = 1;
        int l = Math.min(a, b);
        int r = Math.max(a, b);
        while(l%2 != 1 || l != r-1) {
        	answer ++;
        	l = (l+1)/2;
        	r = (r+1)/2;
        }

        return answer;
    }
	public static void main(String[] args) {
		Solution_예상_대진표 solution = new Solution_예상_대진표();
		System.out.println(solution.solution(8, 4, 7));
	}

}

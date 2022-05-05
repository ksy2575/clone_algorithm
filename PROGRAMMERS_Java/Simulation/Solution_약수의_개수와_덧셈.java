package simulation;

public class Solution_약수의_개수와_덧셈 {
	public int solution(int left, int right) {
        int answer = 0;
        for(;left <= right; left++){
            answer += left * (isEven(left)?1:-1);
        }
        return answer;
    }
	private boolean isEven(int left) {
		int temp = 0;
		for(int i = 1; i <= left; i++) {
			if(left%i == 0) temp++;
		}
		return temp%2 == 0? true : false;
	}
	public static void main(String[] args) {
		Solution_약수의_개수와_덧셈 solution = new Solution_약수의_개수와_덧셈();
		System.out.println(solution.solution(13, 17));
	}

}

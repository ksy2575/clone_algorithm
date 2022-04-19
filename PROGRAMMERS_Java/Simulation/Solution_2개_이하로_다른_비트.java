package simulation;

// Simulation, Bit
public class Solution_2개_이하로_다른_비트 {
	public long[] solution(long[] numbers) {
        long[] answer = new long[numbers.length];
        for(int i = 0; i < numbers.length; i++) {
        	answer[i] = getNumber(numbers[i]);
        }
        return answer;
    }
	private long getNumber(long l) {
		int i = 0;
		long r = l;
		while(r >= 0) {
			if((r&1) == 0) break;
			r = r>>1;
			i++;
		}
		long left = (l>>i)<<i;
		return left + (l-left+1) + ((l-left)>>1);
	}
	
	public static void main(String[] args) {
		Solution_2개_이하로_다른_비트 solution = new Solution_2개_이하로_다른_비트();
		System.out.println(solution.solution(new long[] {2,7}));
	}
}

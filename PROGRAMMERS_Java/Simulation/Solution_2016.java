package simulation;

public class Solution_2016 {
	public String solution(int a, int b) {
        int[] month = new int[] {0, 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        String[] day = new String[] {"FRI", "SAT", "SUN", "MON", "TUE", "WED", "THU"};
        int temp = 0;
        for(int i = 1; i < a; i++){
            temp += month[i];
        }
        temp += b-1;
        return day[temp%7];
    }
	public static void main(String[] args) {
		Solution_2016 solution = new Solution_2016();
		System.out.println(solution.solution(5, 24));
	}

}

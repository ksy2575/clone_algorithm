package lv2;

//String
public class Solution_문자열_압축 {
	public int solution(String s) {
        int answer = Integer.MAX_VALUE;
        
        for(int i = 1; i <= s.length(); i++) {
        	answer = Math.min(answer, find(s, i));
        }
        
        return answer;
    }

	public int find(String s, int i) {
		int start = 0;
		int end = i;
		String pre = "";
		StringBuilder sb = new StringBuilder();
		int cnt = 1;
		while(end <= s.length()) {
			String curr = s.substring(start, end);
			if(curr.equals(pre)) {
				cnt++;
			}else {
				sb.append(cnt==1?"":cnt);
				sb.append(pre);
				cnt = 1;
				pre = curr;
			}
			start += i;
			end += i;
		}
		sb.append(cnt==1?"":cnt);
		sb.append(pre);
		cnt = 1;
		sb.append(s.substring(start));
//		System.out.println(sb.toString());
		
		return sb.toString().length();
	}

	public static void main(String[] args) {
		Solution_문자열_압축 solution = new Solution_문자열_압축();
//		System.out.println(solution.solution("aabbaccc"));
//		System.out.println(solution.solution("ababcdcdababcdcd"));
//		System.out.println(solution.solution("abcabcdede"));
//		System.out.println(solution.solution("abcabcabcabcdededededede"));
		System.out.println(solution.solution("xababcdcdababcdcd"));
	}
}

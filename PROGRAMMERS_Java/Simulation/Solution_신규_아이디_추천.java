package simulation;

//simulation
public class Solution_신규_아이디_추천 {
	public String solution(String new_id) {
        String answer = "";
        new_id = new_id.toLowerCase();
        for(char c : new_id.toCharArray()) {
        	if(Character.isLowerCase(c) ||Character.isDigit(c) || c == '-' || c == '_' || c == '.') {
        		answer += c;
        	}
        }
        System.out.println("1, 2 :" + answer);
        String temp = answer.charAt(0)+"";
        for(int i = 1; i < answer.length(); i++) {
        	if(answer.charAt(i) == '.' && temp.charAt(temp.length()-1) == '.') {
        		continue;
        	}
        	temp += answer.charAt(i);
        }
        System.out.println("3 :" + temp);
        if(temp.startsWith(".")) temp = temp.substring(1);
        if(temp.endsWith(".")) temp = temp.substring(0, temp.length()-1);
        System.out.println("4 :" + temp);
        if(temp.length() == 0) temp = "a";
        System.out.println("5 :" + temp);
        if(temp.length() >= 16) {
        	temp = temp.substring(0, 15);
        	if(temp.endsWith(".")) temp = temp.substring(0, temp.length()-1);
        }
        System.out.println("6 :" + temp);
        if(temp.length() <= 2) {
        	while(temp.length() < 3) {
        		temp += temp.charAt(temp.length()-1);
        	}
        }
        return temp;
    }

	public static void main(String[] args) {
		Solution_신규_아이디_추천 solution = new Solution_신규_아이디_추천();
//		System.out.println(solution.solution("...!@BaT#*..y.abcdefghijklm"));
		System.out.println(solution.solution("123_.def"));
		
		
		
//		System.out.println(solution.solution("abcdefghijklmn.p"));
	}
}

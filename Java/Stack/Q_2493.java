package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;

public class Q_2493 {

	public static void main(String[] args) {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int n=0;
		String[] arr = {};
		try {
			n = Integer.parseInt(bf.readLine());
			arr = bf.readLine().split(" ");
		} catch (IOException e) {
			e.printStackTrace();
		}
		int[] ans = new int[n];
		Stack<int[]> stack = new Stack<int[]>();
		
		for(int i=n-1;i>=0;i--) {
			while(stack.size()!=0) {
				if(stack.peek()[1]<Integer.parseInt(arr[i])) {
					int curr = stack.pop()[0];
					ans[curr] = i+1;
				}else {
					break;
				}
			}
			int[] temp = {i, Integer.parseInt(arr[i])};
			stack.add(temp);
			
		}
		System.out.println(Arrays.toString(ans).replace("[", "").replace("]", "").replace(",", ""));
		
	}

}

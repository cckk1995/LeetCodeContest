package week161;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class MinRemoveToMakeValid {

	public String minRemoveToMakeValid(String s) {
		Stack<Integer> stack = new Stack<>();
		Map<Integer,Integer> map = new HashMap<>();
		StringBuffer sb = new StringBuffer();
		for(int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if(c=='(') {
				stack.push(i);
			} else if(c==')') {
				if(!stack.empty()) {
					stack.pop();
				} else {
					map.put(i,1);
				}
			}
		}
		
		while(!stack.empty()) {
			map.put(stack.pop(),1);
		}
		for(int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if(c=='('||c==')') {
				if(!map.containsKey(i)) sb.append(c);
			} else {
				sb.append(c);
			}
		} 
		return sb.toString();
    }
	
	public static void main(String[] args) {
		String s = "(a(b(c)d)";
		MinRemoveToMakeValid min = new MinRemoveToMakeValid();
		System.out.println(min.minRemoveToMakeValid(s));
	}

}

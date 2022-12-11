import java.util.ArrayList;
import java.util.Stack;

//Time Complexity O(n)
//Space O(n)

public class RemoveMinimumNumberOfParenthesis {
	
	public static String returnValidString(String str){
		Stack<Integer> stack = new Stack<>();
		ArrayList<Integer> removeIndex  = new ArrayList<>();
		for(int i = 0 ; i < str.length(); i ++) {
			if(str.charAt(i) == '('){
				stack.push(i);
			}else if (str.charAt(i) == ')'){
				if(stack.isEmpty()){
					removeIndex .add(i);
				}else{
					stack.pop();
				}
			}
		}
		while(!stack.isEmpty()){
			removeIndex .add(stack.pop());
		}
		
		StringBuilder sb = new StringBuilder();
		for(int i = 0 ; i < str.length(); i ++){
			if(!removeIndex .contains(i)){
				sb.append(str.charAt(i));
			}
		}
		
		return sb.toString();
	}
}

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

//Time Complexity: O(N X K ) where N is length of string and K is maximum length of string in the arr
//Space  Complexity O(N X K)

public class GroupAnagrams {
	
	public static ArrayList<ArrayList<String>> groupAnagrams(String[] array){
		
		ArrayList<ArrayList<String>> GroupedAnagrams = new ArrayList<>();
		
		HashMap<String, ArrayList<String>> map = new HashMap<>();
		
		for (String str : array) {
			char[] chArr = str.toCharArray();
			Arrays.sort(chArr);
			
			String anagram = String.valueOf(chArr);
			if(!map.containsKey(anagram)){
				ArrayList<String> list = new ArrayList<>();
				list.add(str);
				map.put(anagram, list);
			}else{
				ArrayList<String> list = map.get(anagram);
				list.add(str);
				map.put(anagram, list);
			}
		}
		
		for (ArrayList<String> list: map.values()) {
			GroupedAnagrams.add(list);
		}
		
		return GroupedAnagrams;
		
	}
	
	
}

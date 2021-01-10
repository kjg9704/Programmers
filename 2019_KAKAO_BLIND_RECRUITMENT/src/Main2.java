import java.util.ArrayList;

public class Main2 {
	public static void main(String[] args) {
		String[][] relation = {{"100","ryan","music","2"},{"200","apeach","math","2"},{"300","tube","computer","3"},{"400","con","computer","4"},{"500","muzi","music","3"},{"600","apeach","music","2"}};
		int answer = solution(relation);
		System.out.println(answer);
	}
	public static int solution(String[][] relation) {
        int answer = 0;
        ArrayList<String> keyList = new ArrayList<String>();
        int length = relation[0].length;
        int [] arr = new int[length];
        for(int i = 0; i < length; i++) {
        	arr[i] = i;
        }
        ArrayList<String> set = bit(arr, arr.length);
        for(int i = 0; i < Math.pow(2, length) - 1; i++) {
        	String temp = set.get(i);
        	boolean includeCheck = true;
        		String[] seperate = temp.split(" ");
        		int[] checknum = new int[seperate.length];
        		for(int j = 0; j < seperate.length; j++) {
        			checknum[j] = Integer.parseInt(seperate[j]);
        		}
        		ArrayList<String> combi = bit(checknum, checknum.length);
        		for(int j = 0; j < keyList.size(); j++) {
        			if(combi.contains(keyList.get(j))) {
        				includeCheck = false;
        				break;
        			}
        		}
	        	boolean check = true;
        		if(includeCheck) {
        			if(checknum.length > 1) {
        		        	for(int j = 0; j < relation.length; j++) {
            		        	String checktemp1 = "";
            		        	for(int z = 0; z < checknum.length; z++) {
            		        		checktemp1 += relation[j][checknum[z]];
            		        	}
        		        		for(int k = j + 1; k < relation.length; k++) {
        		        			String checkTemp2 = "";
        		        			for(int z = 0; z < checknum.length; z++) {
        		        				checkTemp2 += relation[k][checknum[z]];
        		        			}
        		        			if(checktemp1.equals(checkTemp2)) {
        		        				check = false;
        		        				break;
        		            		}
        		        		}
        		        		if(check == false) {
        		        			break;
        		        		}
        		        	}
        		        	if(check == true) {
        		        		keyList.add(temp);
        		        	}
        			}
        			else {
        				int index = checknum[0];
        				for(int j = 0; j < relation.length; j++) {
    		        		String checktemp1 = relation[j][index];
    		        		for(int k = j + 1; k < relation.length; k++) {
    		        			String checkTemp2 = relation[k][index];
    		        			if(checktemp1.equals(checkTemp2)) {
    		        				check = false;
    		        				break;
    		            		}
    		        		}
    		        		if(check == false) {
    		        			break;
    		        		}
    		        	}
    		        	if(check == true) {
    		        		keyList.add(temp.trim());
    		        	}
        				
        			}
        			
        		}
        }
        answer = keyList.size();
        return answer;
    }
	static ArrayList<String> bit(int[] arr, int n) {
		ArrayList<String> set = new ArrayList<String>();
	    for(int i=0; i < 1<<n; i++) {
	    	String append = "";
	        for(int j=0; j<n; j++) {
	            if((i & 1<<j) != 0) 
	                append += arr[j] + " ";
	        }
	        if(!append.equals("")) {
		        set.add(append.trim());
	        }
	    }
	    return set;
	}
}

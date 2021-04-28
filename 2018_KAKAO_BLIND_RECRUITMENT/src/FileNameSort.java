import java.util.Arrays;
import java.util.Comparator;

class CustomComparator implements Comparator<String>{

	@Override
	public int compare(String o1, String o2) {
		String[] first = new String[3];
		Arrays.fill(first, "");
		String[] second = new String[3];
		Arrays.fill(second, "");
		for(int i = 0; i < o1.length(); i++) {
			if(o1.charAt(i) >= 48 && o1.charAt(i) <= 57 && first[2].length() == 0) {
				first[1] += o1.charAt(i);
			}else {
				if(first[1].length() > 0) {
					first[2] += o1.charAt(i);
				}else {
					first[0] += o1.charAt(i);
				}
			}
		}
		
		for(int i = 0; i < o2.length(); i++) {
			if(o2.charAt(i) >= 48 && o2.charAt(i) <= 57 && second[2].length() == 0) {
				second[1] += o2.charAt(i);
			}else {
				if(second[1].length() > 0) {
					second[2] += o2.charAt(i);
				}else {
					second[0] += o2.charAt(i);
				}
			}
		}
		
		String firstHead = first[0].toUpperCase();
		String secondHead = second[0].toUpperCase();
		if(firstHead.compareTo(secondHead) > 0) {
			return 1;
		}else if(firstHead.compareTo(secondHead) < 0) {
			return -1;
		}
		int firstCom = Integer.parseInt(first[1]);
		int secondCom = Integer.parseInt(second[1]);
		if(firstCom > secondCom) {
			return 1;
		}else if(firstCom < secondCom) {
			return -1;
		}
		return 0;
	}

}

public class FileNameSort {

	public static void main(String[] args) {
		String[] files =  {"foo010bar020.zip","AbC12","aBc12"};
		String[] result = solution(files);
		for(int i = 0; i < result.length; i++) {
			System.out.println(result[i]);
		}
	}

	public static String[] solution(String[] files) {
		Arrays.sort(files, new CustomComparator());
		return files;
	}

}

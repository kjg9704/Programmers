import java.util.Arrays;
import java.util.Comparator;

class CustomComparator implements Comparator<Integer>{

	@Override
	public int compare(Integer o1, Integer o2) {
		String first = String.valueOf(o1);
		String second = String.valueOf(o2);
		int firstEx = Integer.parseInt(first + second);
		int secondEx = Integer.parseInt(second + first);
		if(firstEx < secondEx) {
			return 1;
		}else {
			return -1;
		}
	}

}

public class BiggestNumber2 {


	public static void main(String[] args) {
		int[] numbers = {12, 121};
		System.out.println(solution(numbers));
	}

	public static String solution(int[] numbers) {
		StringBuilder sb = new StringBuilder();
		Integer[] list = new Integer[numbers.length];
		for(int i = 0; i < numbers.length; i++) {
			list[i] = numbers[i];
		}
		Arrays.sort(list, new CustomComparator()); //Á¤·Ä

		for(int i = 0; i < list.length; i++) {
			sb.append(list[i]);
		}
		if(list[0] == 0) {
			return "0";
		}else {
			return sb.toString();
		}
	}

}

public class BiggestNumber {

	public static void main(String[] args) {
		int[] numbers = {101, 10};
		System.out.println(solution(numbers));
	}

	public static String solution(int[] numbers) {
		int[] temp = new int[numbers.length];
		mergeSort(numbers, temp, 0, numbers.length - 1);
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < numbers.length; i++) {
			if(i == 0){
				if(numbers[i] != 0) {
					sb.append(numbers[i]);
				}
			}else if(sb.length() != 0) {
				sb.append(numbers[i]);
			}
		}
		if(sb.length() == 0) {
			return "0";
		}else {
			return sb.toString();
		}
	}

	public static void mergeSort(int[] numbers, int[] temp, int start, int end) { 
		if (start<end) {
			int mid = (start+end) / 2;
			mergeSort(numbers, temp, start, mid);
			mergeSort(numbers, temp, mid+1, end);
			int p = start; 
			int q = mid + 1; 
			int idx = p; 
			while (p<=mid || q<=end) {
				if (q>end || (p<=mid && !compare(numbers[p], numbers[q]))) {
					temp[idx++] = numbers[p++];
				} else {
					temp[idx++] = numbers[q++]; 
				}
			}
			for (int i=start;i<=end;i++) {
				numbers[i]=temp[i]; 
			}
		}
	}

	public static boolean compare(int a, int  b) {
		String first = String.valueOf(a);
		String second = String.valueOf(b);
		int firstEx = Integer.parseInt(first + second);
		int secondEx = Integer.parseInt(second + first);
		if(firstEx < secondEx) {
			return true;
		}else {
			return false;
		}
	}

}

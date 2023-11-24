
public class BinaryTree_Expression {

	static boolean check = true;
	public static void main(String[] args) {
//		long[] numbers = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 128, 129, 16512, 2147516555L};
//		long[] numbers = {7, 42, 5, 63, 111, 95, 127};
		long[] numbers = {9};

		
		int[] result = solution(numbers);
		
		for(int num : result) {
			System.out.print(num + " ");
		}
	}
	
	public static int[] solution(long[] numbers) {
        int[] answer = new int[numbers.length];
        
        for(int i = 0; i < numbers.length; i++) {
        	long num = numbers[i];
        	if(num == 1) {
        		answer[i] = 1;
        		continue;
        	}
        	String bin = Long.toBinaryString(num);
        	int height = log(2, bin.length()) + 1;
        	int nodes = (int) (Math.pow(2, height) - 1);

        	bin = String.format("%1$" + nodes + "s", bin).replace(' ', '0');

        	
        	check = true;
        	dfs(bin, 0, bin.length() - 1);
        	
        	if(check) {
        		answer[i] = 1;
        	}
        }
        
        return answer;
    }
	
	static void dfs(String bin, int left, int right) {
		if(!check) {
			return;
		}
		if(left == right) {
			return;
		}
		int root = (left + right) / 2;
		
		if(bin.charAt(root) == '0') {
			for(int i = left; i < root; i++) {
				if(bin.charAt(i) == '1') {
					check = false;
					return;
				}
			}
			
			for(int i = root + 1; i <= right; i++) {
				if(bin.charAt(i) == '1') {
					check = false;
					return;
				}
			}
		}
		dfs(bin, left, root - 1);
		dfs(bin, root + 1, right);
		return ;
	}
	
	static int log(int base, int num) {
		return (int) (Math.log10(num) / Math.log10(base));
	}

}

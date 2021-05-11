import java.util.Arrays;

public class PhoneNumber {

	public static void main(String[] args) {
		String[] phone_book = {"12","123","1235","567","88"};
		System.out.println(solution(phone_book));

	}

	public static boolean solution(String[] phone_book) {
		Arrays.sort(phone_book);
        for(int i = 0; i < phone_book.length - 1; i++) {
        	if(phone_book[i + 1].startsWith(phone_book[i])) {
        		return false;
        	}
        }
        return true;
    }
}

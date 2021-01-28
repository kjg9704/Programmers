
public class NewIdea {

	public static void main(String[] args) {
		String [] new_id = {"...!@BaT#*..y.abcdefghijklm", "z-+.^.", "=.=", "123_.def", "abcdefghijklmn.p"};
		for(String id: new_id) {
			solution(id);
		}
		
	}
	public static String solution(String new_id) {
		new_id = new_id.toLowerCase();
		new_id = new_id.replaceAll("[^a-z0-9-_.]", "");
		new_id = new_id.replaceAll("[.]{2,}", ".");
		if(new_id.length() != 0) {
			if(new_id.charAt(0) == '.') {
				new_id = new_id.substring(1);
			}
		}
		if(new_id.length() != 0) {
			if(new_id.charAt(new_id.length() - 1) == '.') {
				new_id = new_id.substring(0, new_id.length() - 1);
			}
		}
		if(new_id.length() == 0) {
			new_id += "a";
		}
		if(new_id.length() >= 16) {
			new_id = new_id.substring(0, 15);
			if(new_id.charAt(new_id.length() - 1) == '.') {
				new_id = new_id.substring(0, new_id.length() - 1);
			}
		}
		if(new_id.length() <= 2) {
			while(new_id.length() != 3) {
				new_id += new_id.charAt(new_id.length() - 1);
			}
		}
        String answer = new_id;
        return answer;
    }
}

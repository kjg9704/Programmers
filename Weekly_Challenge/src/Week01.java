
public class Week01 {

	public static void main(String[] args) {
		int price = 3;
		int money = 20;
		int count = 4;
		System.out.println(solution(price, money, count));
	}
	
	public static long solution(int price, int money, int count) {
        int cost = 0;
        for(int i = 1; i <= count; i++) {
        	cost += price * i;
        }
        int result = money - cost;
        if(result > 0) {
        	return 0;
        }else {
        	return Math.abs(result);
        }
    }

}

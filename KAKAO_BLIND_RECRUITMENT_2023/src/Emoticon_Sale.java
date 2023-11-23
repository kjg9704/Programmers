
public class Emoticon_Sale {

	static int max_service = 0;
	static int max_money = 0;
	public static void main(String[] args) {
		int[][] users = {{40, 2900}, {23, 10000}, {11, 5200}, {5, 5900}, {40, 3100}, {27, 9200}, {32, 6900}};
		int[] emoticons = {1300, 1500, 1600, 4900};
		
		int[] result = solution(users, emoticons);
		
		for(int i = 0; i < result.length; i++) {
			System.out.print(result[i] + " ");
		}
	}
	
	public static int[] solution(int[][] users, int[] emoticons) {
        int[] discount = new int[emoticons.length];
        
        for(int i = 0; i < discount.length; i++) {
        	discount[i] = 10;
        }
        
        dfs(0, discount, discount.length, users, emoticons);
        int[] answer = {max_service, max_money};
        return answer;
    }
	
	static void dfs(int depth, int[] discount, int n, int[][] users, int[] emoticons) {
		if(depth == n) {
			int service = 0;
			int money = 0;
			for(int i = 0; i < users.length; i++) {
				int now_money = 0;
				for(int j = 0; j < n; j++) {
					if(discount[j] >= users[i][0]) {
						now_money += emoticons[j] * (100 - discount[j]) / 100;
						
						if(now_money >= users[i][1]) {
							now_money = 0;
							service++;
							break;
						}
					}
				}
				money += now_money;
			}
			
			if(service > max_service) {
				max_service = service;
				max_money = money;
				
//				System.out.println(max_service + " " + max_money);
			}else if(service == max_service) {
				if(money > max_money) {
					max_service = service;
					max_money = money;
					
//					System.out.println(max_service + " " + max_money);
				}
			}
			
			return;
		}
		
		for(int i = 0; i <= 30; i = i + 10) {
			int prev_price = discount[depth];
			discount[depth] += i;
			dfs(depth + 1, discount, n, users, emoticons);
			discount[depth] = prev_price;
		}
		
		
	}

}


public class Delivery {

	public static void main(String[] args) {
		int cap = 2;
		int n = 7;
		int[] deliveries = {1, 0, 2, 0, 1, 0, 2};
		int[] pickups = {0, 2, 0, 1, 0, 2, 0};
		
		
//		int cap = 3;
//		int n = 2;
//		int[] deliveries = {2, 4};
//		int[] pickups = {4, 2};
		
		
		
		System.out.println(solution(cap, n, deliveries, pickups));
		
	}
	
	public static long solution(int cap, int n, int[] deliveries, int[] pickups) {
        long answer = 0;

        int give_cap = 0;
        int get_cap = 0;
        for(int i = n - 1; i >= 0; i--) {
        	if(deliveries[i] == 0 && pickups[i] == 0) {
        		continue;
        	}

        	int cnt = 0;
        	
        	while(deliveries[i] > give_cap || pickups[i] > get_cap) {
        		give_cap += cap;
        		get_cap += cap;
        		if(deliveries[i] <= give_cap) {
        			give_cap -= deliveries[i];
        			deliveries[i] = 0;
        			
        		}else {
        			deliveries[i] -= give_cap;
        			give_cap = 0;
        		}
        		
        		if(pickups[i] <= get_cap) {
        			get_cap -= pickups[i];
        			pickups[i] = 0;
        		}else {
        			pickups[i] -= get_cap;
        			get_cap = 0;
        		}
        		
        		cnt++;
        	}
        	
        	give_cap -= deliveries[i];
        	get_cap -= pickups[i];
        	deliveries[i] = 0;
        	pickups[i] = 0;
        	
        	answer += (i + 1) * 2 * cnt;

        	
        }
        return answer;
    }

}

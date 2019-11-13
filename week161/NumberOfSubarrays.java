package week161;

import java.util.HashMap;
import java.util.Map;

public class NumberOfSubarrays {
	public int numberOfSubarrays(int[] nums, int k) {
		Map<Integer,Integer> map = new HashMap<>();
		map.put(0, -1);
		int cnt = 1;
		for(int i = 0; i < nums.length; i++) {
			if(nums[i] % 2==1) {
				map.put(cnt++, i);
			}
		}
		map.put(cnt, nums.length);
		int ret = 0;
		for(int i = 1; i <= cnt-k; i++) {
			int l = map.get(i);
			int r = map.get(i+k-1);
			int ll = map.get(i-1);
			int rr = map.get(i+k);
			ret += (l-ll)*(rr-r);
		}
		return ret;
    }
	public static void main(String[] args) {
		int[] nums = {2,2,2,1,2,2,1,2,2,2};
		int k = 2;
		NumberOfSubarrays nos = new NumberOfSubarrays();
		System.out.println(nos.numberOfSubarrays(nums, k));
	}
}
